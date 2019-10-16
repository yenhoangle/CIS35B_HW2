package exception;

//helper class to fix some build errors
public class FixException extends Exception {
    private int errNum;
    public FixException() {

    }

    public FixException(int errNum) {
        this.errNum = errNum;
    }

}
