package TransportationProblem;

import Helpers.ArrayHelpers;
import Helpers.MatrixHelpers;
import com.sun.org.apache.xpath.internal.SourceTree;

public class TransportTable {
    int[] inventory = {100, 50, 60};
    int[] orders = {70, 80, 50};
    int[][] delivery, rates;

    public int[][] getDelivery() {
        return delivery;
    }

    public TransportTable() {
        rates = MatrixHelpers.RandomMatrix(3, 3);
    }

    public void isClosed() {
        int sumInventory = ArrayHelpers.sum(inventory);
        int sumOrders = ArrayHelpers.sum(orders);

        if (sumInventory > sumOrders) {
            orders = ArrayHelpers.push(orders, sumInventory - sumOrders);
            delivery = MatrixHelpers.createMatrix(3, 4);
        }

        else if (sumInventory < sumOrders) {
            inventory = ArrayHelpers.push(inventory, sumInventory - sumOrders);
            delivery =  MatrixHelpers.createMatrix(4, 3);
        }
        else{
            delivery =  MatrixHelpers.createMatrix(3, 3);
        }
    }


    public void fillDeliveries() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++) {
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
