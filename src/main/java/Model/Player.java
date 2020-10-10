package Model;

public class Player {
    String name;
    Long wordsPerMinute;

    public Player(String name, Long wordsPerMinute) {
        this.name = name;
        this.wordsPerMinute = wordsPerMinute;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWordsPerMinute() {
        return wordsPerMinute;
    }

    public void setWordsPerMinute(Long wordsPerMinute) {
        this.wordsPerMinute = wordsPerMinute;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", wordsPerMinute=" + wordsPerMinute +
                '}';
    }
}
