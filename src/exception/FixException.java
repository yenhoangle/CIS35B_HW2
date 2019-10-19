package exception;
import java.io.File;
import java.util.*;
import adapter.*;
import model.Automotive;

/* helper class to fix some build errors
* fix by prompting user input */
public class FixException extends Exception {
    String fileFolder = "/textfiles/";
    //constructor
    public FixException() {
    }

    //fix for missing file  - error num: 1
    public void fix1(int errno) {
        boolean valid = false;
        while(!valid) {
            System.out.println("File is not found or empty. Please enter a new file name: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            String filename = fileFolder + input;
            File testFile = new File(filename);
            if (input.isEmpty() || !testFile.exists()) {
                continue;
            }
            valid = true;
            BuildAuto fixAuto = new BuildAuto();
            fixAuto.buildAuto(filename);
        }
    }

    //fix for invalid auto name - error num: 2
    public void fix2(int errno, Automotive auto) {
        //tell the user to fix the file for now, interface does not expose auto name setter

    }
    //fix for missing base price - error num: 3
    public void fix3(String errno, Automotive auto ) {
        //tell the user to fix the file for now, interface does not expose base price setter

    }

    //fix for missing number of option sets - error num: 4
    public void fix4(int errno, Automotive auto) {
        //tell user to fix the file for now, numset will not be necessary with future storage structures
    }

    //fix for missing option set name - error num: 5
    public void fix5(int errno, Automotive auto) {
        //tell user to fix file for now, interface does not expose opset setter


    }

    //fix for missing number of options - error num: 6
    public void fix6(int errno, Automotive auto) {
        //tell the user to fix the file for now

    }

    //fix for missing option price - error num: 7
    public void fix7(int errno, Automotive auto) {


    }

}
