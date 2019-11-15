/*
 * Yen Le
 * 20123455
 *
 * Abstract class that implements interface methods for child class BuildAuto so that BuildAuto can remain empty
 * */
package adapter;

import exception.AutoException;
import model.Automotive;
import util.FileIO;

public abstract class ProxyAutomotive {
    private static Automotive a1;

    //implements CreateAuto interface methods via subclass BuildAuto
    public void buildAuto(String filename) throws AutoException {
        FileIO fileIO = new FileIO();
        a1 = fileIO.buildAutoObject(filename);
    }

    public void printAuto(String modelName) {
        a1.print();
    }

    //UpdateAuto interface methods via subclass BuildAuto
    public void updateOptionSetName(String modelName, String opsetName, String newOpsetName) {
        a1.updateOpSetName(opsetName, newOpsetName);
    }

    public void updateOptionPrice(String modelName, String opsetName, String opName, float newPrice) {
        a1.updateOpPrice(opsetName, opName, newPrice);
    }

    //FixAuto
    public void fix(int errno)  {
        //implemented by file IO
    }
}
