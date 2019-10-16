package exception;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//AutoException class uses Exception methods
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
            FileWriter fw = new FileWriter(filename);
            PrintWriter writer = new PrintWriter(fw);
            writer.printf("\n - Error! Code %d: %s\n", errNum, errMessage);
            writer.close();
            fw.close();
        } catch(IOException e) {
            printStackTrace();
        }
    }
}
