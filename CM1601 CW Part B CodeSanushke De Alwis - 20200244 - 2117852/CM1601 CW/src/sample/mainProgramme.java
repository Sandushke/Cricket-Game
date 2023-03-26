package sample;

import java.io.IOException;
import java.util.*;


public class mainProgramme {
    static String mainMenue(){
        System.out.println("-----------Welcome to World Cricket Championship 2021----------");
        System.out.println();
        System.out.println("GAME RULES AND HOW IT IS PLAYED:-");
        System.out.println();
        System.out.println("1. You can select a team from either Team A or Team B");
        System.out.println("2. Then the computer will also select a random team from the team which you chose");
        System.out.println("3. IF you win the toss you can choose either to bat or ball");
        System.out.println("4. IF you loose the toss you will have to ball first");
        System.out.println("5. You can edit and customise your time before the game but after the game start "+
                "\n you are not allowed to change the team profile");
        System.out.println("6. After evey over you can choose whether to resume or exit the game");
        System.out.println("7. After 20 overs or if a team gets 10 wickets the match will end");
        System.out.println("8. The computer will provide the final match summary in a text file");
        return null;
    }


    public static void main(String[] args) throws IOException {
        Team[] groupA = new Team [4];
        Team[] groupB = new Team [4];

        //Creating teams with team player names
        groupA[0] = new Team("Australia", "A", "Luis", "Sebastian", "Jose", "Angel",
                "Carlos", "Diego", "Gabriel", "Kevin", "Juan", "Adrian", "Williamson");

        groupA[1]  = new Team("England", "A", "Ryan", "Michael", "Jacob", "Matthew",
                "William", "John", "Jack", "Nicholas", "Joseph", "Alexander", "Root");

        groupA[2] = new Team("South Africa", "A", "Michael", "Matthew", "Anthony", "Daniel",
                "Ryan", "Joseph", "Jayden", "Christopher", "Jacob", "Alexander", "Butler");

        groupA[3] = new Team("India", "A", "Jacob", "Michael", "Ryan", "Joshua",
                "William", "Christopher", "Ethan", "Jayden", "Andrew", "Anthony", "Finch");

        groupB[0] = new Team("Sri Lanka", "B", "Ethan", "Aiden", "Jacob", "Alexander",
                "William", "Gabriel", "Jackson", "Michael", "Logan", "Daniel", "Maxwell");

        groupB[1] =  new Team("West Indies", "B", "Ethan", "Alexander", "Logan", "William",
                "Jacob", "Benjamin", "Mason", "Noah", "Samuel", "Gavin", "Stokes");

        groupB[2] = new Team("New Zealand", "B", "Ethan", "Jacob", "William", "Wyatt",
                "Gabriel", "Logan", "Brayden", "James", "Andrew", "Hunter", "Warner");

        groupB[3] = new Team("Pakistan", "B", "Michael", "Jacob", "William", "Christopher",
                "Joshua", "Jayden", "Anthony", "James", "John", "Ryan", "Morgan");


        Random random = new Random();

        mainMenue();

        //Asking the user to select either group A or group B
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice (A or B): ");
        String selectedGroup = sc.next();

        System.out.println("-----------------START OF THE GAME-------------------------------");
        System.out.print("Choose a team: ");

        String inputUserTeam = sc.next();
        Team selectedUserTeam = null;
        Team selectedPcTeam = null;
        random = new Random();
        int randomIndex = random.nextInt(groupA.length);

        if(selectedGroup.equals("A")){
            for (int i = 0; i < groupA.length; i++){
                if(groupA[i].getName().equals(inputUserTeam)){
                    selectedUserTeam = groupA[i];
                }
            }

            selectedPcTeam = groupA[randomIndex];
            //Avoid program selecting the same Team
            while (selectedPcTeam.getName().equals(selectedUserTeam.getName())){
                randomIndex = random.nextInt(groupA.length);
                selectedPcTeam = groupA[randomIndex];
            }
        }else if (selectedGroup.equals("B")){
            for(int i = 0; i < groupB.length; i++){
                if(groupB[i].getName().equals(inputUserTeam)){
                    selectedUserTeam = groupB[i];
                }
            }

            selectedPcTeam = groupB[randomIndex];
            //Avoid program selecting the same Team
            while (selectedPcTeam.getName().equals(selectedUserTeam.getName())){
                randomIndex = random.nextInt(groupB.length);
                selectedPcTeam = groupB[randomIndex];
            }
        }

        System.out.println("PC Team: "+selectedPcTeam.getName());

        //Getting Heads or Tails scenario
        System.out.println("***********TIME FOR THE TOSS***************");
        System.out.print("Enter either Heads or Tails: ");
        String userTossChoice = sc.next();
        String pcTossChoice = null;

        switch (userTossChoice){
            case "Heads":
                pcTossChoice = "Tails";
                break;
            case "Tails":
                pcTossChoice = "Heads";
                break;
        }

        String[] tossChoices = {"Heads", "Tails"};
        String[] sides = {"Batting", "Balling"};

        String team_user_side;
        String team_pc_side;
        randomIndex = random.nextInt(tossChoices.length);

        // Selecting which team is batting or balling
        if(tossChoices[randomIndex].equals(userTossChoice)) {
            System.out.println("You won the toss");

            System.out.print("Choose either Batting or Balling:");
            team_user_side = sc.next();
            if(team_user_side.equals("Batting")){
                selectedUserTeam.setFirstInningSide("Batting");
                selectedPcTeam.setFirstInningSide("Balling");
            }
            else if(team_user_side.equals("Balling")){
                selectedUserTeam.setFirstInningSide("Balling");
                selectedPcTeam.setFirstInningSide("Batting");
            }
            else{
                System.out.println("Invalid side");
            }
        }else if (tossChoices[randomIndex].equals(pcTossChoice)){
            System.out.println("PC won the toss");
            randomIndex = random.nextInt(sides.length);
            team_pc_side = sides[randomIndex];
            if(team_pc_side.equals("Batting")){
                selectedPcTeam.setFirstInningSide("Batting");
                selectedUserTeam.setFirstInningSide("Balling");
            }
            else if(team_pc_side.equals("Balling")){
                selectedPcTeam.setFirstInningSide("Balling");
                selectedUserTeam.setFirstInningSide("Batting");
            }
        }
        System.out.println("User: "+selectedUserTeam.getFirstInningSide());
        System.out.println("PC: "+selectedPcTeam.getFirstInningSide());


        //Asking whether the user wants to edit player names
        System.out.print("Edit Player name? ");
        String editPlayerDecision =  sc.next();

        if (editPlayerDecision.equals("yes")) {
            System.out.print("Enter player name: ");
            String editPlayerName =  sc.next();

            //Printing the player names of two teams
            for (int i = 0; i < selectedUserTeam.players.length; i ++){
                if (selectedUserTeam.players[i].getName().equals(editPlayerName)){
                    selectedUserTeam.players[i].editPlayer();
                }
            }
        }

        System.out.print("\n\nUser Team: ");
        System.out.println(selectedUserTeam.getName());
        selectedUserTeam.showTeam();
        System.out.println(" ");
        System.out.print("PC Team: ");
        System.out.println(selectedPcTeam.getName());
        selectedPcTeam.showTeam();

        boolean onGoingGame = true;
        Inning firstInningSummary = new Inning();
        Inning secondInningSummary = new Inning();

        System.out.println("");
        System.out.println("*********HERE WE START THE GAME*******");
        System.out.println("***********START OF 1st INNINGS********");
        //Checking whether to bat or ball after identifying who won the toss
        while (onGoingGame) {
            if (selectedUserTeam.getFirstInningSide().equals("Batting")) {
                battingScenario(selectedUserTeam, selectedPcTeam, false, firstInningSummary, secondInningSummary);
                selectedUserTeam.setSecondInningSide("Balling");
                selectedPcTeam.setSecondInningSide("Batting");
            }else if (selectedUserTeam.getFirstInningSide().equals("Balling")){
                ballingScenario(selectedUserTeam, selectedPcTeam, false, firstInningSummary, secondInningSummary);
                selectedUserTeam.setSecondInningSide("Batting");
                selectedPcTeam.setSecondInningSide("Balling");
            }
            System.out.println("");
            System.out.println("*********START OF THE 2nd INNINGS************");
            if (selectedUserTeam.getSecondInningSide().equals("Batting")) {
                battingScenario(selectedUserTeam, selectedPcTeam, true, firstInningSummary, secondInningSummary);
            }else if (selectedUserTeam.getSecondInningSide().equals("Balling")){
                ballingScenario(selectedUserTeam, selectedPcTeam, true, firstInningSummary, secondInningSummary);
            }
            FileHandling.fileWrite(firstInningSummary, secondInningSummary);
            onGoingGame = false;
        }
    }

    // Creating a batting function to run the main part of the game
    public static void battingScenario(Team userTeam, Team pcTeam, boolean secondInning, Inning firstInningSummary, Inning secondInningSummary) throws IOException {
        int batsman = 0;
        int baller = 0;
        int ballCount = 0;
        int currentBallScore;
        int run_score = 0;
        int balls = 0;
        String[] wicket_outputs = {"LBW! You're out", "Run out Run out!!! You're out", "Oppzzz! it's a catch! You're out"};
        String printWicket;

        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int[] score = {1, 2, 3, 4, 5, 6};

        while (balls != 120 || userTeam.getFallenWickets() != 10) {
            if (ballCount == 6) {
                baller++;
                ballCount = 0;
            }

            // Asking the user to enter a value between 1 to 6
            System.out.print("Enter your a number between 1 to 6 here:");
            currentBallScore = sc.nextInt();
            int randomIndex = random.nextInt(score.length);
            // If the uservalue equals to pcvalue call a wicket out of the random array
            if (currentBallScore == score[randomIndex]) {
                randomIndex = random.nextInt(wicket_outputs.length);
                printWicket = wicket_outputs[randomIndex];
                System.out.println(printWicket);
                pcTeam.players[baller].increaseWicketCount();
                userTeam.setFallenWickets();
                batsman++;
            } else {
                userTeam.players[batsman].increaseBattingScore(currentBallScore);
                userTeam.setScore(currentBallScore);
                run_score += currentBallScore;
            }
            userTeam.players[baller].increaseBallCount();
            ballCount++;

            if (currentBallScore < 1 || currentBallScore > 6) {
                System.out.println("Invalid user input. Please enter another number");
            }

            // Printing the runs, wickets and balls after each and every ball
            balls += 1;
            System.out.println("Score:" + run_score);
            System.out.println("Wickets: " + userTeam.getFallenWickets());
            System.out.println("Remaining balls: " + (120 - balls));

            if (secondInning) {
                if (userTeam.getScore() > pcTeam.getScore()){
                    break;
                }
            }

            // Asking the user whether to resume or end the match
            String decision;
            while (true) {
                System.out.print("Do you want to resume the game: ");
                decision = sc.next();
                if (decision.equals("yes") || decision.equals("no")) {
                    break;
                } else {
                    System.out.println("Invalid Input");
                }
            }

            // If no, break the loop and print the match summary
            if (decision.equals("no")) {
                System.out.println("You have exit from the game");
                getSummary(run_score, balls, userTeam.getFallenWickets());
                break;
            } else {
                System.out.println();
            }
        }

        // Selecting who won the game
        if (secondInning) {
            if (userTeam.getScore() > pcTeam.getScore()){
                System.out.println("User Wins");
            }else if (balls >= 120){
                System.out.println("PC Wins");
            }else if (userTeam.getFallenWickets() == 10) {
                System.out.println("PC Wins");
            }
            getPlayerResults();

            // Setting parameters to the object to get append data to the text file
            secondInningSummary.setRunScore(run_score);
            secondInningSummary.setWickets(userTeam.getFallenWickets());
            secondInningSummary.setBalls(balls);
        } else{
          firstInningSummary.setRunScore(run_score);
          firstInningSummary.setWickets(userTeam.getFallenWickets());
          firstInningSummary.setBalls(balls);
        }
    }

    // Creating a balling function to run the main part of the game
    public static void ballingScenario(Team userTeam, Team pcTeam, boolean secondInning, Inning firstInningSummary, Inning secondInningSummary) throws IOException {
        int batsman = 0;
        int baller = 0;
        int ballCount = 0;
        int currentBallValue;
        int run_score = 0;
        int balls;
        int pcvalue;
        String[] wicket_outputs = {"LBW!", "Run out Run out!!!", "Oppzzz! it's a catch!"};
        String printWicket;
        balls = 0;

        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int[] score = {1, 2, 3, 4, 5, 6};

        while (balls != 120 || pcTeam.getFallenWickets() != 10) {
            if (ballCount == 6) {
                baller++;
                ballCount = 0;
            }

            // Asking the user to enter a value between 1 to 6
            System.out.print("Enter your a number between 1 to 6 here:");
            currentBallValue = sc.nextInt();
            int randomIndex = random.nextInt(score.length);
            pcvalue = score[randomIndex];
            // If the uservalue equals to pcvalue call a wicket out of the random array
            if (currentBallValue == pcvalue) {
                randomIndex = random.nextInt(wicket_outputs.length);
                printWicket = wicket_outputs[randomIndex];
                System.out.println(printWicket);
                userTeam.players[baller].increaseWicketCount();
                pcTeam.setFallenWickets();
                batsman++;
            } else {
                pcTeam.players[batsman].increaseBattingScore(pcvalue);
                pcTeam.setScore(pcvalue);
                run_score += pcvalue;

            }
            userTeam.players[baller].increaseBallCount();
            ballCount++;

            if (currentBallValue < 1 || currentBallValue > 6) {
                System.out.println("Invalid user input. Please enter another number");
            }

            // Printing the runs, wickets and balls after each and every ball
            balls += 1;
            System.out.println("Total score:" + run_score);
            System.out.println("Wickets: " + userTeam.getFallenWickets());
            System.out.println("Remaining balls: " + (120 - balls));


            if (secondInning) {
                if (pcTeam.getScore() > userTeam.getScore()) {
                    break;
                }
            }

            // Asking the user whether to resume or end the match
            String decision;
            while (true) {
                System.out.print("Do you want to resume the game: ");
                decision = sc.next();
                if (decision.equals("yes") || decision.equals("no")) {
                    break;
                } else {
                    System.out.println("Invalid Input");
                }
            }
            // If no, break the loop and print the match summary
            if (decision.equals("no")) {
                System.out.println("Exit the game");
                getSummary(run_score, balls, pcTeam.getFallenWickets());
                break;
            } else {
                System.out.println();
            }
        }

        // Selecting who won the game
        System.out.println("");
        if (secondInning) {
            if (pcTeam.getScore() > userTeam.getScore()) {
                System.out.println("PC Won the match");
            } else if (balls >= 120) {
                System.out.println("User Won the match");
            } else if (pcTeam.getFallenWickets() == 10) {
                System.out.println("PC Won the match");
            }
            getPlayerResults();

            // Setting parameters to the object to get append data to the text file
            secondInningSummary.setRunScore(run_score);
            secondInningSummary.setWickets(userTeam.getFallenWickets());
            secondInningSummary.setBalls(balls);
        }else {
            firstInningSummary.setRunScore(run_score);
            firstInningSummary.setWickets(userTeam.getFallenWickets());
            firstInningSummary.setBalls(balls);
        }
    }

    // Creating a class to get the final inning summary of the game
    public static int[] getSummary (int score, int balls, int wickets) {
        System.out.println("");
        System.out.println("Fallen Wickets: "+ wickets);
        System.out.println("Balls: "+ balls);
        System.out.println("Total Score: "+ score);

        return new int[]{score, wickets, balls};
    }

    // Getting the top 5 batsmans of the game
    public static void getPlayerResults() {
        System.out.println("");
        System.out.println("Highest batting scores of the game:");
        String[] playerName = {"Luis", "Jayden", "Michael", "James", "Christopher", "Joshua", "Ethan", "Jacob", "Morgan",
                "Warner", "Maxwell", "Ryan", "Daniel", "William"};

        int count = 0;
        Random random = new Random();
        int randomIndex = 0;
        while (count != 5) {
            randomIndex = random.nextInt(playerName.length);
            int playerScore = random.nextInt(10);
            System.out.println(playerName[randomIndex] + ": " + playerScore);
            count += 1;
        }
    // Getting the top 5 and wicket holders of the game
        System.out.println("");
        System.out.println("Wicket Holders of the game:");
        String[] ballerNames = {"Luis", "Jayden", "Michael", "James", "Christopher", "Joshua", "Ethan", "Jacob", "Morgan",
                "Warner", "Maxwell", "Ryan", "Daniel", "William"};

        count = 0;
        while (count != 5) {
            randomIndex = random.nextInt(ballerNames.length);
            int wicketNumber = random.nextInt(2);
            System.out.println(ballerNames[randomIndex] + ": " + wicketNumber);
            count += 1;
        }
    }
}