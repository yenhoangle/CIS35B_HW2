/*
* Test Driver to demonstrate functionality of the interfaces in CRUD options as well as fixing mechanisms.
* File used, log.txt, and sample output runs are found in textfiles folder.
* */
package driver;
import adapter.BuildAuto;
import adapter.CreateAuto;
import adapter.UpdateAuto;
import exception.AutoException;
import util.FileIO;


public class Driver2 {
    public static void main(String[] args) throws AutoException {
        try {
            boolean complete = false;
            String file = "C:\\Users\\Arteh\\IdeaProjects\\CIS35B_HW2\\textfiles\\missingAutoName.txt";
            CreateAuto a1 = new BuildAuto();
            UpdateAuto a2 = new BuildAuto();
            //testing out a bad file
            System.out.println("Building auto from buggy file");
            FileIO fileIO = new FileIO();
            //attempting to build the car
            System.out.println("Attempting to build the car");
            a1.buildAuto(file);
            System.out.println("\nPrinting the auto after building");
            a1.printAuto("");

            // update the Automobile's options
            System.out.println("\nUpdating car's option set name");
            a2.updateOptionSetName("Ford Focus Wagon ZTW", "Color", "Colour");
            System.out.println("Updating car's option price");
            a2.updateOptionPrice("Ford Focus Wagon ZTW",
                    "Transmission", "Manual", -800);
            System.out.println("\nPrinting the auto after updating");
            a1.printAuto("");
        } catch (AutoException ae) {

        }
    }
}
