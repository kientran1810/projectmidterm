package haiquanid;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyProcessFile {

    public static void saveData(Object list,String fileName)
    {
        try
        {
            FileOutputStream fOut = new FileOutputStream(fileName);
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(list);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static Object openData(String fileName)
    {
        try
        {
            FileInputStream fIn = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fIn);
            return oIn.readObject();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}