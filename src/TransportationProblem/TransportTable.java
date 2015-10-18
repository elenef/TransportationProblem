package TransportationProblem;

import Helpers.ArrayHelpers;
import Helpers.MatrixHelpers;

import java.util.BitSet;

public class TransportTable {
    int[] inventory, orders;
    int[][] delivery, rates;
    int[] basicCells;
    int[] posZeroBasic = {0,0};
    int costs = 0;



    public TransportTable(int[] _inventory, int[] _orders) {
        inventory = _inventory;
        orders = _orders;

        rates = MatrixHelpers.create(inventory.length, orders.length);
        MatrixHelpers.fillRandomly(rates);

        delivery = MatrixHelpers.create(inventory.length, orders.length);
    }

    public int[] getPosZeroBasic() {
        return posZeroBasic;
    }

    public int[] getBasicCells() {
        return basicCells;
    }

    public int[][] getDelivery() {
        return delivery;
    }

    public int[][] getRates() {
        return rates;
    }

    public int getCosts() {
        for (int i = 0; i < inventory.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                costs += delivery[i][j] * rates[i][j];
            }
        }
        return costs;
    }


    public void isClosed() {
        int sumInventory = ArrayHelpers.sum(inventory);
        int sumOrders = ArrayHelpers.sum(orders);

        if (ArrayHelpers.sum(inventory) > ArrayHelpers.sum(orders)) {
            orders = ArrayHelpers.push(orders, sumInventory - sumOrders);
            delivery = MatrixHelpers.expand(delivery, true);
            rates = MatrixHelpers.expand(rates, true);
        } else if(ArrayHelpers.sum(inventory) < ArrayHelpers.sum(orders)){
            inventory = ArrayHelpers.push(inventory, sumOrders - sumInventory);
            delivery = MatrixHelpers.expand(delivery, false);
            rates = MatrixHelpers.expand(rates, false);
        }
    }


    public void fillDeliveries() {
        for (int i = 0; i < delivery.length; i++)
            for (int j = 0; j < delivery[0].length; j++) {
                if (orders[j] < inventory[i]) {
                    delivery[i][j] = orders[j];
                    inventory[i] -= orders[j];
                    orders[j] = 0;

                }
                if (orders[j] > inventory[i]) {
                    delivery[i][j] = inventory[i];
                    orders[j] -= inventory[i];
                    inventory[i] = 0;

                } else if (orders[j] == inventory[i]) {
                    delivery[i][j] = inventory[i];
                    inventory[i] = 0;
                    orders[j] = 0;
                }

            }

    }


    public void BasicCells() {
        basicCells = ArrayHelpers.createArray(MatrixHelpers.numberBasicCells(delivery));
        int count = 0;
        for (int i = 0; i < delivery.length; i++) {
            for (int j = 0; j < delivery[0].length; j++) {
                if(delivery[i][j]>0){
                    basicCells[count] = delivery[i][j];
                    count++;
                }
            }
        }
    }
    public boolean isCycle(int row, int coll, int[] values, int count, int oneRow, int twoColl) {
        int[] position;

        if(count == 0){
            oneRow = row;
            twoColl = coll;
        }

        if (count > 3 &&  (oneRow == row || twoColl == coll)) {
            return true;
        }

        for (int i = 0; i < values.length;i++) {
            position = MatrixHelpers.findValue(delivery, basicCells[i]);
            if (position[0] == row || position[1] == coll) {
                count++;
                isCycle(position[0], position[1],ArrayHelpers.del(values,i), count, oneRow, twoColl);
            }
        }
        return false;
    }


    public void isDegeneratePlan() {
        if (getBasicCells().length < inventory.length + orders.length - 1) {
            exit:for (int i = 0; i < delivery.length; i++) {
                for (int j = 0; j < delivery[0].length; j++) {
                    if(delivery[i][j] == 0){
                        if(!(isCycle(i,j,getBasicCells(),0,0,0))){
                            posZeroBasic[0] = i;
                            posZeroBasic[1] = j;
                            basicCells = ArrayHelpers.push(getBasicCells(),delivery[i][j]);break exit;
                        }
                    }
                }
            }
        }
    }

}
