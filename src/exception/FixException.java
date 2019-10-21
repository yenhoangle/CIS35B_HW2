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
    public void fix1(int errno, String file) {
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
            file = filename;
            scanner.close();
        }
    }

    //fix for invalid auto name - error num: 2
    public void fix2(int errno, String autoname) {
        boolean valid = false;
        while(!valid) {
            System.out.println("Please enter the full Automotive name: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            if (input.isEmpty() || input.equals("null") || input.equals("NULL")) {
                continue;
            }
            valid = true;
            autoname = input;
            scanner.close();
        }
    }
    //fix for invalid base price - error num: 3
    public void fix3(int errno, String autoprice ) {
        boolean valid = false;
        while(!valid) {
            System.out.println("Please enter a valid base price for the Automotive: ");
            Scanner scanner = new Scanner(System.in);
            //conversion to check for negative value
            Float price = scanner.nextFloat();
            //base price cannot be negative
            if (price < 0) {
                continue;
            }
            valid = true;
            autoprice = price.toString();
            scanner.close();
        }
    }

    //fix for invalid option set name - error num: 4
    public void fix4(int errno, String opsetname) {
        boolean valid = false;
        while(!valid) {
            System.out.println("Please enter valid option set name: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            if (input.isEmpty() || input.equals("null") || input.equals("NULL")) {
                continue;
            }
            valid = true;
            opsetname = input;
            scanner.close();
        }
    }

    //fix for invalid option name - error num: 5
    public void fix5(int errno, String opname) {
        boolean valid = false;
        while (!valid) {
            System.out.println("Invalid option name.");
            System.out.println("Please enter valid option name");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                continue;
            }

            valid = true;

            scanner.close();
        }
    }
}
