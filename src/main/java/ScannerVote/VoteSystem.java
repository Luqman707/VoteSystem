package ScannerVote;

import java.util.Scanner;

public class VoteSystem {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int counter = 0;

        System.out.println("-------------------- WELCOME TO THE VOTING SYSTEM --------------------");

        do {
            System.out.println("\n-------------------******************************--------------------");
            System.out.print("Please enter your name: ");
            String userName = input.next();

            System.out.print("Please enter your age: ");
            int userAge = input.nextInt();

            if (userAge >= 18) {
                System.out.println("\nPlease select the candidate's party you are voting for:");
                System.out.println("1. APC\n2. PDP\n3. LP\n4. SDP\n5. YPP");
                System.out.print("Choice: ");
                int userSelection = input.nextInt();

                processVote(userSelection);

                System.out.println("Thank you for voting, " + userName + "!");
                counter++;

                if (counter >= 5) {
                    System.out.println("\nVoting limit reached. Processing results...");
                    break;
                }
            } else {
                System.out.println("Sorry, you are not eligible to vote (must be 18+).");
            }
        } while (true);


        identifyWinner();
    }

    private static void processVote(int selection) {
        switch (selection) {
            case 1: Candidate.setCandidate1Votes(); break;
            case 2: Candidate.setCandidate2Votes(); break;
            case 3: Candidate.setCandidate3Votes(); break;
            case 4: Candidate.setCandidate4Votes(); break;
            case 5: Candidate.setCandidate5Votes(); break;
            default: System.out.println("Invalid selection. Vote not counted."); break;
        }
    }

    private static void identifyWinner() {
        int[] votes = new int[5];
        votes[0] = Candidate.candidate1Votes;
        votes[1] = Candidate.candidate2Votes;
        votes[2] = Candidate.candidate3Votes;
        votes[3] = Candidate.candidate4Votes;
        votes[4] = Candidate.candidate5Votes;

        String[] parties = {"APC", "PDP", "LP", "SDP", "YPP"};

        int highestVotes = -1;
        int winnerNumber = 0;

        for (int i = 0; i < votes.length; i++) {
            if (votes[i] > highestVotes) {
                highestVotes = votes[i];
                winnerNumber = i + 1;
            }
        }

        System.out.println("\n======================================================================");
        System.out.println("FINAL RESULT: The winner is Candidate " + winnerNumber + " (" + parties[winnerNumber - 1] + ")");
        System.out.println("Total Votes: " + highestVotes);
        System.out.println("======================================================================");
    }

    static class Candidate {
        static int candidate1Votes = 0;
        static int candidate2Votes = 0;
        static int candidate3Votes = 0;
        static int candidate4Votes = 0;
        static int candidate5Votes = 0;

        public static void setCandidate1Votes() {
            candidate1Votes++;
            System.out.println("Vote recorded for APC. Current total: " + candidate1Votes);
        }
        public static void setCandidate2Votes() {
            candidate2Votes++;
            System.out.println("Vote recorded for PDP. Current total: " + candidate2Votes);
        }
        public static void setCandidate3Votes() {
            candidate3Votes++;
            System.out.println("Vote recorded for LP. Current total: " + candidate3Votes);
        }
        public static void setCandidate4Votes() {
            candidate4Votes++;
            System.out.println("Vote recorded for SDP. Current total: " + candidate4Votes);
        }
        public static void setCandidate5Votes() {
            candidate5Votes++;
            System.out.println("Vote recorded for YPP. Current total: " + candidate5Votes);
        }
    }
}