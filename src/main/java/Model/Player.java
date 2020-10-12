package Model;

public class Player implements Comparable<Player> {
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
        return "'" + name + '\'' + ", wordsPerMinute=" + wordsPerMinute ;
    }

    @Override
    public int compareTo(Player player) {
        return -Long.valueOf(this.wordsPerMinute).compareTo(Long.valueOf(player.getWordsPerMinute()));
    }
}
