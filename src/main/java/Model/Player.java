package Model;

import java.io.Serializable;

public class Player implements Comparable<Player>, Serializable {
    private String name;
    private Long wordsPerMinute;
    private Double accuracy;

    public Player(String name, Long wordsPerMinute, Double accuracy) {
        this.name = name;
        this.wordsPerMinute = wordsPerMinute;
        this.accuracy = accuracy;
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

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public Long getWordsPerMinute() {
        return wordsPerMinute;
    }

    public void setWordsPerMinute(Long wordsPerMinute) {
        this.wordsPerMinute = wordsPerMinute;
    }

    @Override
    public String toString() {
        return "'" + name + '\'' + "\n|wordsPerMinute=" + wordsPerMinute + "; " + accuracy + "% accuracy|";
    }

    @Override
    public int compareTo(Player player) {
        return -Long.valueOf(this.wordsPerMinute).compareTo(Long.valueOf(player.getWordsPerMinute()));
    }
}
