package exception;

import model.Automotive;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

//AutoException class uses Exception methods, use FixException class to fix errors, then log error to separate file
public class AutoException extends Exception {
    private int errno;
    private String errMessage;
    private Automotive auto;

    //messages for logging purposes
    private static String BAD_FILE = "Invalid Filename";
    private static String BAD_AUTO = "Invalid Auto Name";
    private static String BAD_BASE = "Invalid Base Price";
    private static String BAD_NUM_OPSET = "Invalid Number of Option Sets";
    private static String BAD_OPSET = "Invalid Option Set Name";
    private static String BAD_NUM_OP = "Invalid Number of Options";
    private static String BAD_OP_PRICE = "Invalid Option Price";

    //constructors
    public AutoException() {
        super();
    }

    public AutoException(String message) {
        super();
        errMessage = message;
    }


    public AutoException(int errno, Automotive auto) {
        super();
        this.errno = errno;
        this.auto = auto;
    }

    public AutoException(String message, int errno) {
        this(message);
        this.errno = errno;

    }
    //getters
    public int getErrNo() {
        return errno;
    }

    public String getErrMessage() {
        return errMessage;
    }


    //setters
    public void setErrNo(int errno) {
        this.errno = errno;
    }
    public void setErrMessage(String message) {
        errMessage = message;
    }
    public void setAuto(Automotive auto) {this.auto = auto; }

    //for fixing the file in order to build a proper Automotive, calls helper methods
    public void fix(int errno) {
        //TODO: implement method
        //create new FixException object to access its methods
        //switch statement to apply fix based on error number

        this.errno = errno;
        FixException fixer = new FixException();
        switch(errno) {
            case 1:
                errMessage = BAD_FILE;
                fixer.fix1(errno);
                break;
            case 2:
                errMessage = BAD_AUTO;
                fixer.fix2(errno, auto);
                break;
            case 3:
                errMessage = BAD_BASE;
                fixer.fix3(errno, auto);
                break;
            case 4:
                errMessage = BAD_NUM_OPSET;
                fixer.fix4(errno, auto);
                break;
            case 5:
                errMessage = BAD_OPSET;
                fixer.fix5(errno, auto);
                break;
            case 6:
                errMessage = BAD_NUM_OP;
                fixer.fix6(errno, auto);
                break;
            case 7:
                errMessage = BAD_OP_PRICE;
                fixer.fix7(errno, auto);
                break;
        }
    }

    //logger method to write error to a file
    public void log() {
        //TODO: CHANGE FILE NAME
        String filename = "filename";
        try {
            //creates a timestamp
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String formattedTime = formatter.format(date);
            FileWriter fw = new FileWriter(filename);
            PrintWriter writer = new PrintWriter(fw);
            writer.printf("\n - Error occurred at [ %s ] Code %d: - %s\n", formattedTime, errno, errMessage);
            writer.close();
            fw.close();
        } catch(IOException e) {
            printStackTrace();
        }
    }
}
