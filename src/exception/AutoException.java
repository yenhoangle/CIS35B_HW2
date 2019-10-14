package exception;

import adapter.FixAuto;

public class AutoException extends Exception implements FixAuto {
    public void fix(int errno) {

    }
}
