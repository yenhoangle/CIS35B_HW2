package driver;
import adapter.BuildAuto;
import exception.AutoException;
import model.Automotive;
import util.FileIO;


public class Driver2 {
    public static void main(String[] args) throws AutoException {
        boolean complete = false;
        String file = "C:\\Users\\Arteh\\IdeaProjects\\CIS35B_HW2\\textfiles";
            try {

                //testing out a bad file
                System.out.println("Building auto from buggy file");
                FileIO fileIO = new FileIO();
                //attempting to build the car
                Automotive car = fileIO.buildAutoObject(file);
                System.out.println("Printing the auto after building");
                car.print();

                // update the Automobile's options
                BuildAuto buildAuto = new BuildAuto();
                buildAuto.updateOptionSetName("", "Color", "Colour");
                buildAuto.updateOptionPrice("", "Transmission", "Manual", -800);
                complete = true;
            } catch (AutoException ae) {
                complete = false;
            }
    }
}
