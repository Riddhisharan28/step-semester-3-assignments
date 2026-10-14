package main.java.session_1.class_problems;


import java.util.*;
public class RockPaperScissors {

    static String playRound(String player, String computer) {
        if (player.equals(computer))
            return "Draw";
        else if (player.equals("Rock") && computer.equals("Scissors")
              || player.equals("Paper") && computer.equals("Rock")
              || player.equals("Scissors") && computer.equals("Paper"))
            return "Player Wins";
        else
            return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] player = new String[5];
        String[] computer = new String[5];
        String[] result = new String[5];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Rock, Paper or Scissors: ");
            player[i] = sc.next();

            player[i] = player[i].substring(0, 1).toUpperCase()
                       + player[i].substring(1).toLowerCase();

            computer[i] = moves[r.nextInt(3)];
            result[i] = playRound(player[i], computer[i]);

            System.out.println("Computer: " + computer[i]);
            System.out.println("Result: " + result[i]);

            if (result[i].equals("Player Wins"))
                wins++;
            else if (result[i].equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        System.out.println("\nRound\tPlayer\t\tComputer\tResult");
        for (int i = 0; i < 5; i++)
            System.out.println((i + 1) + "\t" + player[i] + "\t\t"
                               + computer[i] + "\t\t" + result[i]);

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + (wins * 100.0 / 5) + "%");

        sc.close();
    }
}