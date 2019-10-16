package exception;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

//AutoException class uses Exception methods, use FixException class to fix errors, then log error to separate file
public class AutoException extends Exception {
    private int errNum;
    private String errMessage;

    //constructors
    public AutoException() {
        super();
    }

    public AutoException(String message) {
        super();
        errMessage = message;
    }


    public AutoException(int errNum) {
        super();
        this.errNum = errNum;
    }

    public AutoException(String message, int errNum) {
        this(message);
        this.errNum = errNum;

    }
    //getters
    public int getErrNum() {
        return errNum;
    }

    public String getErrMessage() {
        return errMessage;
    }


    //setters
    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }
    public void setErrMessage(String message) {
        errMessage = message;
    }

    //for fixing the file in order to build a proper Automotive, calls helper methods
    public void fix(int errno) {
        //TODO: implement method
        //create new FixException object to access its methods
        //switch statement to apply fix based on error number

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
            writer.printf("\n - Error occurred at [ %s ] Code %d: - %s\n", formattedTime, errNum, errMessage);
            writer.close();
            fw.close();
        } catch(IOException e) {
            printStackTrace();
        }
    }
}
