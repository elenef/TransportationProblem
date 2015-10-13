import Helpers.MatrixHelpers;
import TransportationProblem.TransportTable;

public class Interface {
    public static void main(String[] args) {
        TransportTable table = new TransportTable();
        table.isClosed();
        table.fillDeliveries();
        MatrixHelpers.printMatrix(table.getDelivery(),3,4);
    }
}
