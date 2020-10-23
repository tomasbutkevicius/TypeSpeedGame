import Model.Leaderboard;
import Model.Race;

import java.io.IOException;

public enum MenuCommand {
        START
                {
                    @Override
                    public Leaderboard execute(Leaderboard leaderboard) {
                        Race typeRace = new TypeRace(4, leaderboard);
                        typeRace.start();
                        return leaderboard;
                    }
                },
        STATS
                {
                    @Override
                    public Leaderboard execute(Leaderboard leaderboard) {
                        Printer.printStats(leaderboard);
                        return leaderboard;
                    }
                },
        SAVE
                {
                    @Override
                    public Leaderboard execute(Leaderboard leaderboard) {
                        ObjectIO.WriteObjectToFile(leaderboard);
                        return leaderboard;
                    }
                },
        LOAD
                {
                    @Override
                    public Leaderboard execute(Leaderboard leaderboard) throws IOException, ClassNotFoundException {
                        return ObjectIO.readObjectFromFile(leaderboard);
                    }
                };

    public abstract Leaderboard execute(Leaderboard leaderboard) throws IOException, ClassNotFoundException;
}
