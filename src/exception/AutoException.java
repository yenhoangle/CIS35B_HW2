package exception;

import model.Automotive;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

//AutoException class uses Exception methods, use FixExceptions class to fix errors, then log error to separate file
public class AutoException extends Exception {
    private int errno;
    private String errMessage;
    private Automotive auto;

    //messages for logging purposes
    private static String BAD_FILENAME = "Invalid Filename";
    private static String BAD_AUTO_NAME = "Invalid Auto Name";
    private static String BAD_BASE = "Invalid Base Price";
    private static String BAD_OPSET_NAME = "Invalid Option Set Name";
    private static String BAD_OP_NAME = "Invalid Option Name";
    private static String UNEXPECTED_EXCEPTION = "Unexpected Exception";

    //constructors
    public AutoException() {
        super();
    }

    public AutoException(int errno) {
        super();
        this.errno = errno;
        switch(errno) {
            case 1:
                errMessage = BAD_FILENAME;
                break;
            case 2:
                errMessage = BAD_AUTO_NAME;
                break;
            case 3:
                errMessage = BAD_BASE;
                break;
            case 4:
                errMessage = BAD_OPSET_NAME;
                break;
            case 5:
                errMessage = BAD_OP_NAME;
                break;
            default:
                errMessage = UNEXPECTED_EXCEPTION;
        }
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
    public void fix(int errno, Automotive car) {
        auto = car;
        FixExceptions fixer = new FixExceptions();
        log();
        switch(errno) {
            case 1:
                errMessage = BAD_FILENAME;
                break;
            case 2:
                errMessage = BAD_AUTO_NAME;
                fixer.fix2(errno, car);
                break;

            case 3:
                errMessage = BAD_BASE;
                fixer.fix3(errno, car);
                break;

            case 4:
                errMessage = BAD_OPSET_NAME;
                fixer.fix4(errno, car);
                break;
            case 5:
                errMessage = BAD_OP_NAME;
                fixer.fix5(errno, car);
                break;

            default:
                errMessage = UNEXPECTED_EXCEPTION;
                log();
        }
    }

    //logger method to write error to a file
    public void log() {
        String filename = "C:\\Users\\Arteh\\IdeaProjects\\CIS35B_HW2\\textfiles\\log.txt";
        try {
            //creates a timestamp
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String formattedTime = formatter.format(date);
            //sets file writer to append mode
            FileWriter fw = new FileWriter(filename, true);
            PrintWriter writer = new PrintWriter(fw);
            writer.printf("\n - Error occurred at [ %s ] Code %d: - %s\n", formattedTime, errno, errMessage);
            writer.close();
            fw.close();
        } catch(IOException e) {
            printStackTrace();
        }
    }
}
