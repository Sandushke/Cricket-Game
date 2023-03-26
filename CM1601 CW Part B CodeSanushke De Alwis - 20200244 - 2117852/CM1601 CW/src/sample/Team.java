package sample;

public class Team {
    public Player[] players = new Player[11];
    private String name;
    private String group;
    private String[] player;
    private String currentInning;
    private int score;
    private byte fallenWickets;
    private String tossSide;
    private String firstInningSide = "None";
    private String secondInningSide = "None";

    public Team(
            String name,
            String group,
            String p1,
            String p2,
            String p3,
            String p4,
            String p5,
            String p6,
            String p7,
            String p8,
            String p9,
            String p10,
            String p11
    ) {
        this.name = name;
        this.group = group;
        this.players[0] = new Player(p1);
        this.players[1] = new Player(p2);
        this.players[2] = new Player(p3);
        this.players[3] = new Player(p4);
        this.players[4] = new Player(p5);
        this.players[5] = new Player(p6);
        this.players[6] = new Player(p7);
        this.players[7] = new Player(p8);
        this.players[8] = new Player(p9);
        this.players[9] = new Player(p10);
        this.players[10] = new Player(p11);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showTeam() {
        for (int i = 1; i <= this.players.length; i++) {
            System.out.println(this.players[i - 1].getName());
        }
    }

    public String getFirstInningSide() {
        return firstInningSide;
    }

    public void setFirstInningSide(String firstInningSide) {
        this.firstInningSide = firstInningSide;
    }

    public String getSecondInningSide() {
        return secondInningSide;
    }

    public void setSecondInningSide(String secondInningSide) {
        this.secondInningSide = secondInningSide;
    }

    public byte getFallenWickets() {
        return fallenWickets;
    }

    public void setFallenWickets() {
        this.fallenWickets += 1;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

}


