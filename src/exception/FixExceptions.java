package exception;
import java.io.File;
import java.util.*;
import adapter.*;
import model.Automotive;

/* helper class to fix some build errors
* fix by prompting user input */
public class FixExceptions {
    String fileFolder = "/textfiles/";
    //constructor
    public FixExceptions() {
    }


    //fix for invalid auto name - error num: 2
    public void fix2(int errno, Automotive auto) {
        boolean valid = false;
        while(!valid) {
            System.out.println("Please enter the full Automotive name: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            /*
            if (input.isEmpty()) {
                continue;
            } */
            valid = true;
            //autoname = input;
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
            //conversion to check for negative value
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
    public void fix4(int errno, Automotive car) {
        boolean valid = false;
        while(!valid) {
            System.out.println("Please enter valid option set name: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            if (input.isEmpty() || input.equals("")) {
                continue;
            }
            valid = true;
            car.setOpSetName(car.findOpSetIndex(""), input);
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