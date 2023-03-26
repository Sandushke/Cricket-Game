package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileHandling {
    public static void fileWrite(Inning firstInnings, Inning secondInnings) throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try{
            fw = new FileWriter("sample/matchStatus.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.flush();

        }finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            }
            catch (IOException io) {
            }
        }try(FileWriter f = new FileWriter("sample/matchStatus.txt");
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);){

            p.println("\n1st Innings: ");
            p.print("Runs: "+ firstInnings.getRunScore());
            p.print("\tWickets: " + firstInnings.getWickets());
            p.print("\tBalls: "  + firstInnings.getBalls());

            p.println("\n2nd Innings: ");
            p.print("Runs: " + secondInnings.getRunScore());
            p.print("\tWickets: " + secondInnings.getWickets());
            p.print("\tBalls: " + secondInnings.getBalls());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
