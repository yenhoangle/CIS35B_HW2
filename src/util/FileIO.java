/*
 * Yen Le
 * 20123455
 *
 * FileIO.java
 * Class contains methods to build an Automative object from a file as well as serializing and deserialzing it
 * */

package util;
import java.util.*;
import java.io.*;

import exception.AutoException;
import model.Automotive;
import model.OptionSet;

public class FileIO {
    public Automotive buildAutoObject(String filename) throws AutoException {
        try {
            try {
                File testFile = new File(filename);
                if (!testFile.exists() || testFile.length() == 0) {
                    throw new AutoException(1);
                }
            } catch (AutoException ae) {
                //ae.fix(1, filename);

            }
            FileReader fileReader = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(fileReader);
            //creates a boolean value to keep track of end of file
            boolean eof = false;
            //first line has auto name, base price, and size of opset array
            String autoString = buffer.readLine();
            //file is empty
            try {
                if (autoString.isEmpty() || autoString.equals(" ")) {
                    throw new AutoException(1);
                }
            } catch (AutoException ae) {
                //ae.fix(1, filename);
            }
            String[] baseAuto = autoString.split(":");
            String autoName = baseAuto[0];
            try {
                if (baseAuto[1].isEmpty()) {
                    throw new AutoException(3);
                }
            } catch (AutoException ae) {
                //ae.fix(3, baseAuto[1]);
            }
            Float basePrice = Float.parseFloat(baseAuto[1]);
            int opsetNum = Integer.parseInt(baseAuto[2]);
            Automotive auto = new Automotive(autoName, basePrice, opsetNum);
            //throw exception if auto name invalid
            try {
                if (baseAuto[0].equals(" ") || baseAuto[0].isEmpty()) {
                    System.out.println("throwing this");
                    throw new AutoException(2);
                }
            } catch (AutoException ae) {
                //TODO: TAKE OUT
                System.out.println("fixing autoname");
                ae.fix(2, auto);
                //auto.setName(baseAuto[0]);
                //ae.log();
                System.out.println("error logged");

            }
            //throw exception if base price is negative
            //TODO

            try {
                if (basePrice < 0) {
                    throw new AutoException(3);
                }
            } catch (AutoException ae) {
                ae.fix(3, auto);
            }

            //save the length of the array of array
            int opsetSize = auto.getOpSetArr().length;
            while (!eof) {
                //populating opset array
                for (int i = 0; i < opsetSize; i++) {
                    //get a new OptionSet
                    String line = buffer.readLine();
                    //split line into name : length
                    String[] pair = line.split(":");
                    int opSize = Integer.parseInt(pair[1]);
                    //each opset entry is a newly created OptionSet object, which has an array of option : price
                    auto.setOpSet(i, new OptionSet(pair[0], opSize));
                    /*
                    if (pair[0].equals("NULL") || pair[0].equals("null")) {
                        throw new AutoException(4);
                    }
                     */
                    buffer.readLine(); //skips (
                    //loop for the option array itself
                    for (int j = 0; j < opSize; j++) {
                        String option = buffer.readLine();
                        //split option into name : price
                        String[] namePrice = option.split(":");
                        //TODO
                        //throw new exception of op name is invalid
                        /*if (namePrice[0].equals("NULL") || namePrice[1].equals("null")) {
                            throw new AutoException(5);
                        } */
                        float price = Float.parseFloat(namePrice[1]);
                        auto.setOpVals(i, j, namePrice[0], price);
                    }
                    //next line is ), skip it
                    buffer.readLine();
                }
                eof = true;
            }
            buffer.close();
            fileReader.close();
            return auto;
        } catch (FileNotFoundException fnf) {
            System.out.println("FNF");
        } catch (NullPointerException npe) {
            System.out.println("NPE");
        } catch (IOException e) {
            System.out.println("Error");
        }
        return null;
    }

    public void serialize(String filename, Automotive a1) throws AutoException {
        try {
            FileOutputStream foStream = new FileOutputStream(filename);
            ObjectOutputStream ooStream = new ObjectOutputStream(foStream);
            ooStream.writeObject(a1);
            //closing streams after done writing
            ooStream.close();
            foStream.close();
        } catch (FileNotFoundException fnf) {
            throw new AutoException(1);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Automotive deserialize(String filename) throws AutoException {
        if (filename == null) return null;
        Automotive autoObj = null;
        try {
            FileInputStream fiStream = new FileInputStream(filename);
            ObjectInputStream oiStream = new ObjectInputStream(fiStream);
            autoObj = (Automotive) oiStream.readObject();
            //closing streams after done reading
            oiStream.close();
            fiStream.close();
        } catch (FileNotFoundException fnf) {
            throw new AutoException(1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return autoObj;
    }
}

