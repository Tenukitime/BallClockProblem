package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ball Clock Simulator");
        System.out.println("Enter a number between 27 and 127 to calculate the time in days required for the balls to return to their original order.");
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Enter an integer between 27 and 127.  Enter -1 to quit.");
            int in = input.nextInt();

            if (in == -1) {
                System.exit(1);
            }
            if (in > 127 || in < 27) {
                System.out.println("Integer must be between 27 and 127.");
            } else {
                BallClock clock = new BallClock(in);

                long startTime = System.nanoTime();

                int days = clock.cycleToOriginalOrder();

                long endTime = System.nanoTime();
                long totalTime = endTime - startTime;
                long msTime = totalTime / 1000000;

                System.out.println(in + " balls takes " + days + " days");
                if (msTime == 0) {
                    System.out.println("This calculation took <1ms.");
                } else {
                    System.out.println("This calculation took " + msTime + "ms.");
                }
                System.out.println();
            }
        }
    }
} 
