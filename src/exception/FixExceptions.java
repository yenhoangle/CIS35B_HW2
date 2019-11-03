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
        }
    }

    //fix for invalid option set name - error num: 4
    public void fix4(int errno, Automotive car) {
        boolean valid = false;
        while(!valid) {
            System.out.println("Please check file and enter the missing option set name: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            if (input.isEmpty() || input.equals("")) {
                continue;
            }
            valid = true;
            car.setOpSetName(car.findOpSetIndex(""), input);
        }
    }

    //fix for invalid option name - error num: 5
    public void fix5(int errno, Automotive car) {
        boolean valid = false;
        while (!valid) {
            System.out.println("Invalid option name.");
            System.out.println("Please check the file and enter the option set name:");
            Scanner scanner = new Scanner(System.in);
            String optionset = scanner.nextLine().trim();
            if (optionset.isEmpty()) {
                continue;
            }
            System.out.println("Please enter the missing option name: ");
            String option = scanner.nextLine().trim();
            car.updateOpName(optionset,"", option);
            valid = true;
        }
    }
}
