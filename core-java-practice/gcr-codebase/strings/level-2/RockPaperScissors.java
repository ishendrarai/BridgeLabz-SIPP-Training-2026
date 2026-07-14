import java.util.Scanner;

public class RockPaperScissors {
    public static String getComputerChoice() {
        int random = (int) (Math.random() * 3);
        if (random == 0) return "rock";
        if (random == 1) return "paper";
        return "scissors";
    }

    public static String getWinner(String userChoice, String compChoice) {
        if (userChoice.equals(compChoice)) return "Tie";
        if ((userChoice.equals("rock") && compChoice.equals("scissors")) ||
            (userChoice.equals("paper") && compChoice.equals("rock")) ||
            (userChoice.equals("scissors") && compChoice.equals("paper"))) {
            return "User";
        }
        return "Computer";
    }

    public static String[][] computeStats(int userWins, int compWins, int totalGames) {
        String[][] stats = new String[2][2];
        stats[0][0] = "User";
        stats[0][1] = String.format("%.2f%%", (userWins * 100.0) / totalGames);
        stats[1][0] = "Computer";
        stats[1][1] = String.format("%.2f%%", (compWins * 100.0) / totalGames);
        return stats;
    }

    public static void displayStats(String[][] stats) {
        System.out.println("\nPlayer\tWinning Percentage");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int games = input.nextInt();
        input.nextLine(); // consume newline

        int userWins = 0;
        int compWins = 0;

        for (int i = 0; i < games; i++) {
            System.out.print("Enter rock, paper, or scissors: ");
            String userChoice = input.nextLine().toLowerCase();
            String compChoice = getComputerChoice();
            System.out.println("Computer chose: " + compChoice);

            String winner = getWinner(userChoice, compChoice);
            if (winner.equals("User")) userWins++;
            if (winner.equals("Computer")) compWins++;

            System.out.println("Winner of this round: " + winner + "\n");
        }

        String[][] stats = computeStats(userWins, compWins, games);
        displayStats(stats);

        input.close();
    }
}
