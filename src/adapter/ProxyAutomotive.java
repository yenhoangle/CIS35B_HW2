package adapter;

import model.Automotive;
import util.FileIO;

public abstract class ProxyAutomotive {
    private Automotive a1;

    //implements CreateAuto interface methods via subclass BuildAuto
    public void buildAuto(String filename) {
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

    //FixAuto interface methods
    public void fix(String filename) {

    }
}
