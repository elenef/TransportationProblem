package TransportationProblem;

import Helpers.ArrayHelpers;
import Helpers.MatrixHelpers;

public class TransportTable {
    int[] inventory, orders;
    int[][] delivery, rates;

    public TransportTable(int[] _inventory, int[] _orders) {
        inventory = _inventory;
        orders = _orders;

        rates = MatrixHelpers.create(inventory.length, orders.length);
        MatrixHelpers.fillRandomly(rates);

        delivery = MatrixHelpers.create(inventory.length, orders.length);
    }

    public int[][] getDelivery() {
        return delivery;
    }


    public void isClosed() {
        int sumInventory = ArrayHelpers.sum(inventory);
        int sumOrders = ArrayHelpers.sum(orders);

        if (ArrayHelpers.sum(inventory) > ArrayHelpers.sum(orders)) {
            orders = ArrayHelpers.push(orders, sumInventory - sumOrders);
            delivery = MatrixHelpers.expand(delivery, true);
            rates =  MatrixHelpers.expand(rates, true);
        } else {
            inventory = ArrayHelpers.push(inventory, sumOrders - sumInventory);
            delivery = MatrixHelpers.expand(delivery, false);
            rates =  MatrixHelpers.expand(rates, false);
        }
    }


    public void fillDeliveries() {
        for (int i = 0; i < delivery.length; i++)
            for (int j = 0; j < delivery[0].length; j++) {
                if (orders[j] < inventory[i]) {
                    delivery[i][j] = orders[j];
                    inventory[i] -= orders[j];
                    orders[j] = 0;
                    j++;
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


}
