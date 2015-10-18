import Helpers.ArrayHelpers;
import Helpers.MatrixHelpers;
import TransportationProblem.TransportTable;

public class Interface {
    public static void main(String[] args) {
        int[] inventory = {100, 50, 60};
        int[] orders = {70, 80, 50};

        TransportTable table = new TransportTable(inventory,orders);
        table.isClosed();
        table.fillDeliveries();
        table.BasicCells();
        //table.isDegeneratePlan();
        MatrixHelpers.print(table.getDelivery());
        MatrixHelpers.print(table.getRates());
        ArrayHelpers.print(table.getBasicCells());
        //System.out.println("Add cell");
        //ArrayHelpers.print(table.getPosZeroBasic());
        System.out.println(table.getCosts());
    }
}
