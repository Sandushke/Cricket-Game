package sample;

import java.util.*;
import java.util.Random;

import java.util.Scanner;
public class Player {
    private String name;
    private int battingScore;
    private byte wickets;
    private byte ballCount;

    Player (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void editPlayer () {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Enter player's new name: ");
        name = scanner.next();
    }

    public void increaseBallCount () {
        ballCount += 1;
    }

    public void increaseWicketCount () {
        wickets += 1;
    }

    public void increaseBattingScore (int score) {
        battingScore += score;
    }
}


