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
            scanner.close();
        }
    }

    //fix for invalid auto name - error num: 2
    public void fix2(int errno, Automotive auto) {
        boolean valid = false;
        while(!valid) {
            System.out.println("Please enter the full Automotive name: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            if (input.isEmpty() || input.equals("null") || input.equals("NULL")) {
                continue;
            }
            valid = true;
            auto.setName(input);
            scanner.close();
        }
    }
    //fix for invalid base price - error num: 3
    public void fix3(int errno, Automotive auto ) {
        boolean valid = false;
        while(!valid) {
            System.out.println("Please enter a valid base price for the Automotive: ");
            Scanner scanner = new Scanner(System.in);
            Float price = scanner.nextFloat();
            //base price cannot be negative
            if (price < 0) {
                continue;
            }
            valid = true;
            auto.setBasePrice(price);
            scanner.close();
        }
    }

    //fix for invalid option set name - error num: 4
    public void fix4(int errno, Automotive auto) {
        boolean valid = false;
        while(!valid) {
            System.out.println("Please enter valid option set name: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            if (input.isEmpty() || input.equals("null") || input.equals("NULL")) {
                continue;
            }
            valid = true;
            //assuming the file has no mixed NULL and null, find first match and update name
            auto.updateOpSetName("NULL", input);
            auto.updateOpSetName("null", input);
            scanner.close();
        }
    }

    //fix for invalid option name - error num: 5
    public void fix5(int errno, Automotive auto) {
        boolean valid = false;
        while (!valid) {
            System.out.println("Invalid option name.");
            System.out.println("Please enter information in the format of Option Set Name:Option Name:Price");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                continue;
            }
            String[] info = line.split(":");
            String opsetName = info[0];
            String opname = info[1];
            Float price = Float.parseFloat(info[2]);
            if (opsetName.isEmpty() || opsetName.equals("null") || opsetName.equals("NULL") ||
                    opname.isEmpty() || opname.equals("null") || opname.equals("NULL")) {
                continue;
            }
            valid = true;
            auto.updateOpName(opsetName,"NULL", opname);
            auto.updateOpName(opsetName, "null", opname);
            scanner.close();
        }
    }
}
