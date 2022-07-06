package gitlet;

import java.io.*;
import java.util.PropertyResourceBundle;

/**
 * @Author TOMYUE
 * @Date 2022/7/6
 */
public class SerializeUtils {

    /** Stores an Object to a file by file path.
     * */
    public static void storeObjectToFile(Object obj, String filePath) {
        File outFile = new File(filePath);
        try {
            ObjectOutputStream outObj = new ObjectOutputStream(new FileOutputStream(outFile));
            outObj.writeObject(obj);
            outObj.close();
        }catch (IOException e) {
            System.err.println("Error storing object to file.");
        }

    }

    /** Converts an Object to a ByteArray, only use if SHA-1
     * hash value is nedded
     */
    public static byte[] toByteArray(Object obj) {
        try {
            ByteArrayOutputStream outByteArrayStream = new ByteArrayOutputStream();
            ObjectOutputStream objStream = new ObjectOutputStream(outByteArrayStream);
            objStream.writeObject(obj);
            objStream.close();
        }catch (IOException e){
            throw new IllegalArgumentException("Error in serializing commit.");
        }
        return null;
    }

    /** Reconstructs an Object from ByteArray. */
    public static <T> T deserialize(String fileName, Class<T> type) {
        T obj;
        File inFile = new File(fileName);
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(inFile));
            obj = (T) input.readObject();
            input.close();
            return obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* String and filePath */

    /** Converts String to a new file in the exact filePath. */
    public static void writeStringToFile(String str, String filePath, boolean appending) throws IOException {
        try {
            File logFile = new File(filePath);
            BufferedWriter out = new BufferedWriter(new FileWriter(logFile, appending));
            out.write(str);
            out.close();
        }catch (IOException e){
            return;
        }
    }

    /** Read the file from the exact filePath and converts
     * it to String. */
    public static String readStringFromFile(String filePath) {
        File readingFrom = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(readingFrom));
            String line = null;
            String content = "";
            while((line = br.readLine()) != null) {
                content += line;
            }
            return content;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
