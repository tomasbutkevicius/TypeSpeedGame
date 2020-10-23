import Model.Leaderboard;

import java.io.IOException;

public enum MenuCommand {
        START
                {
                    @Override
                    public Leaderboard execute(Leaderboard leaderboard) {
                        Race race = new Race(4, leaderboard);
                        race.start();
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
