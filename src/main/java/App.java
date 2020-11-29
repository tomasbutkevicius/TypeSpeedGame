import Model.Leaderboard;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Leaderboard leaderboard = Leaderboard.getInstance();
        Menu.launch(leaderboard);
    }
}
