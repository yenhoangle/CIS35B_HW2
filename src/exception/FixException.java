package exception;

/* helper class to fix some build errors
* fix by prompting user input */
public class FixException extends Exception {
    private int errNum;
    public FixException() {

    }

    public FixException(int errNum) {
        this.errNum = errNum;
    }

    //fix for missing file // wrong file name - error num: 100
    //fix for invalid model name - error num: 101
    //fix for missing base price - error num: 102
    //fix for missing number of option sets - error num: 103
    //fix for missing number of options - error num: 104
    //fix for missing option price - error num: 105

}
