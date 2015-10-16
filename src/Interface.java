import Helpers.MatrixHelpers;
import TransportationProblem.TransportTable;

public class Interface {
    public static void main(String[] args) {
        int[] inventory = {100, 50, 60};
        int[] orders = {70, 80, 50};

        TransportTable table = new TransportTable(inventory,orders);
        table.isClosed();
        table.fillDeliveries();
        MatrixHelpers.print(table.getDelivery());
    }
}
