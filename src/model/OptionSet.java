/*
 * Yen Le
 * 20123455
 *
 * OptionSet.java
 * OptionSet is the outer class that represents an array of options. It contains methods to access, update, and delete
 * Option and Option values.
 *
 * Option is the inner class that represent an option for the Automotive object. It contains methods to get and set
 * Option values
 * */

package model;
import java.io.*;

public class OptionSet implements Serializable {
    private String name;
    private Option[] opArr;

    //constructors
    public OptionSet() {
        name = "";
    }
    public OptionSet(String name, int size) {
        super();
        this.name = name;
        this.opArr = new Option[size];
        //initializing array
        for (int i = 0; i < size; i++) {
            this.opArr[i] = new Option();
        }
    }

    //getters
    protected String getName() {
        return name;
    }

    protected Option[] getOpArr() {
        return opArr;
    }

    protected int getOpIndex(String opName) {
        for (int i = 0; i < opArr.length; i++) {
            if (opArr[i].getName().equals(opName)) {
                return i;
            }
        }
        return -1;
    }

    protected Option getOption(int index) {
        return opArr[index];
    }


    protected String getOpName(int index) {
        return opArr[index].getName();
    }

    protected float getOpPrice(int index) {
        return opArr[index].getPrice();
    }

    //setters
    protected void setName(String newName) {
        name = newName;
    }

    protected void setOpArr(Option[] newArray) {
        opArr = newArray;
    }

    protected void setOpName(int index, String newName) {
        this.opArr[index].setName(newName);
    }

    protected void setOpPrice(int index, float newPrice) {
        this.opArr[index].setPrice(newPrice);
    }

    //when need to set both name and price at the same time
    protected void setOpVals(int index, String newName, float newPrice) {
        this.opArr[index].setName(newName);
        this.opArr[index].setPrice(newPrice);
    }

    protected void setOp(int index, Option newOp) {
        this.opArr[index] = newOp;
    }

    //find methods
    protected Option findOption(String name) {

        for (int i = 0; i < opArr.length; i++) {
            if (opArr[i].getName().equals(name)) {
                return opArr[i];
            }
        }
        return null;
    }

    protected int findOpIndex(String opName) {
        return getOpIndex(opName);
    }

    protected float findOpPrice(String name) {
        for (int i = 0; i < opArr.length; i++) {
            if (opArr[i].getName().equals(name)) {
                return opArr[i].getPrice();
            }
        }
        return -1;
    }

    //updaters
    protected void updateOption(String name, Option newOp) {
        int updateIndex = this.getOpIndex(name);
        if (updateIndex != 1){
            this.setOp(updateIndex, newOp);
        }
    }

    protected void updateOpName(String name, String newName) {
        int updateIndex = this.getOpIndex(name);
        if(updateIndex != -1) {
            this.setOpName(updateIndex, newName);
        }
    }

    protected void updateOpPrice(String name, float newPrice) {
        int updateIndex = this.getOpIndex(name);
        if (updateIndex != -1) {
            this.opArr[updateIndex].setPrice(newPrice);
        }
    }

    //delete method
    protected void deleteOption(String name) {
        int deleteIndex = this.getOpIndex(name);
        if (deleteIndex != -1 ) {
            this.setOp(deleteIndex, null);
        }
    }

    //print
    protected void print() {
        System.out.printf("Option Set Name: %s\n", name);
        for(int i = 0; i < opArr.length; i++) {
            if (opArr[i] != null) {
                opArr[i].print();
            }
        }
    }

    //Option inner class
    protected class Option implements Serializable {
        private String name;
        private float price;

        //constructors
        protected Option() {
            this.name = "";
            this.price = 0;
        }

        protected Option(String name, float price) {
            super();
            this.name = name;
            this.price = price;
        }

        //getters
        protected String getName() {
            return name;
        }

        protected float getPrice() {
            return price;
        }

        //setters
        protected void setName(String newName) {
            this.name = newName;
        }

        protected void setPrice(float newPrice) {
            this.price = newPrice;
        }

        //print method
        protected void print() {
            System.out.printf("- %s: $%.2f\n", name, price);
        }
    }
}
