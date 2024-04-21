package org.example;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
//        Election e = () -> System.out.println(":)");
//        new Election(){
//            @Override
//            public void elect() {
//                System.out.println(":)");
//            }
//        };
//        e.elect();
        Election election = () -> System.out.println(":)");

        while (true) {

            Scanner input = new Scanner(System.in);

            int candidate1Votes = 0;
            int candidate2Votes = 0;
            Electorate el = new Electorate(new VotersCard());
            el.elect();

            // Get the electorate's name
            System.out.println("----------******************************----------");
            System.out.println("Please enter your Name: ");
            String electorateName = input.nextLine();
            System.out.println("welcome, " + electorateName);
            System.out.println("----------******************************----------");

            // Get the electorate's age
            System.out.println("Please enter your age: ");
            int electorateAge = input.nextInt();

            // Check if the user is eligible to vote

            if (electorateAge >= 18) {
                System.out.println("Please select your preferred candidate ");
                System.out.println("1. Candidate 1");
                System.out.println("2. Candidate 2");

                int electorateSelection = input.nextInt();

                switch (electorateSelection) {
                    case 1:
                        if (electorateSelection == 1) {
                            candidate1Votes++;
                        } else {
                            continue;
                        }
                    case 2:
                        if (electorateSelection == 2) {
                            candidate2Votes++;
                        } else {
                            break;
                        }
                }

                System.out.println("Thank you for voting, " + electorateName);

                // Display the final vote count
                System.out.println("Candidate 1: " + candidate1Votes + " votes");
                System.out.println("Candidate 2: " + candidate2Votes + " votes");

                if (electorateAge < 18) {
                    System.out.println("Sorry, you are not eligible to vote");
                    break;

                }
            }
        }
    }
}