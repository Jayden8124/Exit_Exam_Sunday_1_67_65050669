package View;

import java.util.List;
import Model.Cow;

public class View {
    public void showScore(String color, int round, int score) {
        System.out.println("Cow " + color + " Round " + round + ": Score = " + score);
    }

    public void showWinner(String winnerTeam) {
        System.out.println("The winning team is: " + winnerTeam);
    }

    public void showBowlResult(String color, int firstThrow, int secondThrow) {
        System.out.println("Cow " + color + " threw: " + firstThrow + " and " + secondThrow);
    }

    public void showRound(int round) {
        System.out.println("Round " + round);
    }

    public void showRanking(List<Cow> cows) {
        System.out.println("Ranking of Cows:");
        for (int i = 0; i < cows.size(); i++) {
            Cow cow = cows.get(i);
            System.out.println((i + 1) + ". Cow " + cow.getColor() + ": " + cow.getTotalScore() + " points");
        }
    }

    public void showTeamRanking(int rank, String team, int score) {
        System.out.println("Rank " + rank + ": Team " + team + " with score: " + score);
    }
}
