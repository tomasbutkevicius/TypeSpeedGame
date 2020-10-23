import Model.Leaderboard;

import java.io.*;

public class ObjectIO {
//Use final block (close streamsĄĄ)
    public static void WriteObjectToFile(Leaderboard leaderboard) {
        try(ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(new File("lastSave.txt")))) {
            objectOut.writeObject(leaderboard);
            objectOut.close();
            System.out.println("Leaderboard saved");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        } finally {
//            objectOut.close)
//        }
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
