package adapter;

import exception.AutoException;
import model.Automotive;

public interface FixAuto {
    public void fix(int errno) throws AutoException;
}
