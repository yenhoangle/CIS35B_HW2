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
    private static String BAD_FILENAME = "Invalid Filename";
    private static String BAD_AUTO_NAME = "Invalid Auto Name";
    private static String BAD_BASE = "Invalid Base Price";
    private static String BAD_OPSET_NAME = "Invalid Option Set Name";
    private static String BAD_OP_NAME = "Invalid Option Name";

    //constructors
    public AutoException() {
        //super();
    }

    public AutoException(int errno) {
        //super();
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
    public void fix(int errno, Automotive car) {
        auto = car;
        FixException fixer = new FixException();
        log();
        switch(errno) {
            /*
            case 1:
                errMessage = BAD_FILENAME;
                fixer.fix1(errno, fixString);
                break;

             */
            case 2:
                errMessage = BAD_AUTO_NAME;
                fixer.fix2(errno, car);
                break;
                /*
            case 3:
                errMessage = BAD_BASE;
                fixer.fix3(errno, fixString);
                break;


            case 4:
                errMessage = BAD_OPSET_NAME;
                fixer.fix4(errno, fixString);
                break;
            case 5:
                errMessage = BAD_OP_NAME;
                fixer.fix5(errno, fixString);
                break;

                 */
        }
    }

    //logger method to write error to a file
    public void log() {
        String filename = "/textfiles/logfile";
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
