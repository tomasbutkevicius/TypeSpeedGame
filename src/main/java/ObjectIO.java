import Model.Leaderboard;
import Model.Player;

import java.io.*;

public class ObjectIO {

    public static void WriteObjectToFile(Leaderboard leaderboard) {
        try {
            FileOutputStream fileOut = new FileOutputStream(new File("lastSave.txt"));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(leaderboard);
            objectOut.close();
            System.out.println("Leaderboard saved");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Leaderboard readObjectFromFile(Leaderboard leaderboard) throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream(new File("lastSave.txt"));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            // Read objects
            leaderboard = (Leaderboard) objectIn.readObject();

            objectIn.close();
            fileIn.close();
            System.out.println("Last saved leaderboard successfully loaded");

        } catch (FileNotFoundException e) {
            System.out.println("Save not found");
        }
        return leaderboard;
    }
}
