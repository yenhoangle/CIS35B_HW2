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
import model.Automotive;
import model.OptionSet;

public class FileIO {
    public Automotive buildAutoObject(String filename) {
        if (filename == null) return null;
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(fileReader);
            //creates a boolean value to keep track of end of file
            boolean eof = false;
            //first 3 lines are auto name, base price, and size of opset array
            Automotive auto = new Automotive(buffer.readLine(), Float.parseFloat(buffer.readLine()),
                    Integer.parseInt(buffer.readLine()));
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
                    buffer.readLine(); //skips (
                    //loop for the option array itself
                    for(int j = 0; j < opSize; j++) {
                        String option = buffer.readLine();
                        //split option into name : price
                        String[] namePrice = option.split(":");
                        //check if size is 2, if not 2, missing price
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void serialize(String filename, Automotive a1) {
        try {
            FileOutputStream foStream = new FileOutputStream(filename);
            ObjectOutputStream ooStream = new ObjectOutputStream(foStream);
            ooStream.writeObject(a1);
            //closing streams after done writing
            ooStream.close();
            foStream.close();
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    public Automotive deserialize(String filename) {
        if (filename == null) return null;
        Automotive autoObj = null;
        try {
            FileInputStream fiStream = new FileInputStream(filename);
            ObjectInputStream oiStream = new ObjectInputStream(fiStream);
            autoObj = (Automotive) oiStream.readObject();
            //closing streams after done reading
            oiStream.close();
            fiStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return autoObj;
    }
}

