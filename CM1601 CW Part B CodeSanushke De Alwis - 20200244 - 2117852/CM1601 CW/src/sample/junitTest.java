package sample;

import org.junit.Test;
import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.*;

public class junitTest {
    @Test
    public void testToAskToResume() {
        String output;
        String[] arr={"yes","no"};
        Random random=new Random();
        int num= random.nextInt(2);
        output=arr[num];
        if (output=="no" ) {
            System.out.println("You're out of the game");
        }
        else{
            System.out.println("You're continuing");
        }

        junit main = new junit();
        main.checkAskToContinue(output);
    }

    @Test
    public void testUserInputValues() {
        int userInputValue = 2;
        int pcInputValue = 3;
        int expectedIntputValue = 5;

        junit main = new junit();

        int actualIntValue=main.checkTwoNumbers(userInputValue,pcInputValue);
        assertEquals(expectedIntputValue,actualIntValue);
    }

    @Test
    public void testWickets() {
        int userInputValue = 4;
        int pcInputValue = 4;
        if(userInputValue == pcInputValue){
            System.out.println("It's a wicket");
        }

        junit main=new junit();
        main.checkWickets(userInputValue,pcInputValue);
    }

    @Test
    public void testLessThanGivenValue() {
        int userValue = 8;
        if(userValue > 6 || userValue < 1){
            System.out.println("Enter another a value between one to six");
        }

        junit main = new junit();
        main.checkValueLimit(userValue);
    }

}
