/*
 * Yen Le
 * 20123455
 *
 * Automotive.java
 * Class contains methods to create a representation of all options for specifying a Automative object as well as
 * performing CRUD operations on the OptionSet objects.
 * */

package model;
import java.io.*; //for serializable
import model.OptionSet.*; //for using Option inner class

public class Automotive implements Serializable {
    private String name;
    private float basePrice;
    private OptionSet[] opset; //the array of option arrays

    //constructors
    public Automotive() {
        this.name = "";
        basePrice = 0;
    }

    public Automotive(String name, float basePrice, int OptionSetSize) {
        super();
        this.name = name;
        this.basePrice = basePrice;
        this.opset = new OptionSet[OptionSetSize];
        //initializing array
        for (int i = 0; i < OptionSetSize; i++) {
            opset[i] = new OptionSet();
        }
    }

    //getters
    public String getName() {
        return name;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public OptionSet[] getOpSetArr() {
        return opset;
    }

    public OptionSet getOpSet(int index) {
        return opset[index];
    }

    public int getOpSetIndex(String name) {
        for (int i = 0; i < opset.length; i++) {
            if (opset[i].getName().equals(name))
                return i;
        }
        return -1;
    }


    public String getOpName(int setIndex, int opIndex) {
        return this.opset[setIndex].getOpName(opIndex);
    }

    public float getOpPrice(int setIndex, int opIndex) {
        return this.opset[setIndex].getOpPrice(opIndex);
    }

    //setters
    public void setName(String newName) {
        name = newName;
    }

    public void setBasePrice(float newPrice) {
        basePrice = newPrice;
    }

    public void setOpSetArr(OptionSet[] newOpSet) {
        opset = newOpSet;
    }

    public void setOpSet(int index, OptionSet newOpSet) {
        opset[index] = newOpSet;
    }

    public void setOpVals(int opsetIndex, int opArrIndex, String name, float price) {
        opset[opsetIndex].setOpVals(opArrIndex, name, price);
    }

    public void setOpSetName(int index, String newName) {
        opset[index].setName(newName);
    }

    public void setOpName(int opsetIndex,int opIndex, String newName) {
        opset[opsetIndex].getOption(opIndex).setName(newName);

    }

    //find methods
    public int findOpSetIndex(String name) {
        if (name == null) return -1;
        for (int i = 0; i < opset.length; i++) {
            if (opset[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public OptionSet findOpSet(String name) {
        if (name == null) return null;

        for (int i = 0; i < opset.length; i++) {
            if (opset[i].getName().equals(name))
                return opset[i];
        }
        return null;
    }

    public Option findOption(String opSetName, String opName) {
        return findOpSet(opSetName).findOption(opName);
    }

    //update methods
    public void updateOpSet(String name, OptionSet newOpSet) {
        int updateIndex = this.findOpSetIndex(name);
        if (updateIndex == -1) {
            this.setOpSet(updateIndex, newOpSet);
        }
    }

    public void updateOpSetName(String name, String newName) {
        int updateIndex = this.findOpSetIndex(name);
        if(updateIndex == -1) {
            this.setOpSetName(updateIndex, newName);
        }
    }

    public void updateOp(String opSetName, String opName, Option newOp) {
        this.findOpSet(opSetName).updateOption(opName, newOp);
    }

    public void updateOpName(String opSetName, String opName, String newName) {
        this.findOpSet(opSetName).updateOpName(opName, newName);
    }

    public void updateOpPrice(String opSetName, String opName, float newPrice) {
        this.findOpSet(opSetName).updateOpPrice(opName, newPrice);
    }


    //delete methods
    public void deleteOptionSet(String name) {
        if (opset != null) {
            for (int i = 0; i < opset.length; i++) {
                if (opset[i] != null && (opset[i].getName()).equals(name))
                    opset[i] = null;
            }
        }
    }

    public void deleteOption(String opSetName, String opName) {
        if (opset != null) {
            for (int i = 0; i < opset.length; i++) {
                if (opset[i] != null && (opset[i].getName()).equals(opSetName))
                    opset[i].updateOption(opName, null);
            }
        }
    }

    //print method for the Automotive object
    public void print() {
        System.out.printf("%s\nBase Price: $%.2f\n", name, basePrice);
        if (opset != null) {
            for(int i = 0; i < opset.length; i++) {
                if (opset[i] != null) opset[i].print();
            }
        }
    }
}
