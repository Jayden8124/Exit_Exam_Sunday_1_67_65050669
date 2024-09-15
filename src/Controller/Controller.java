package Controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Model.Cow;
import View.View;

public class Controller {
    private List<Cow> cows;
    private View view;

    public Controller() {
        view = new View(); // for call method
        cows = new ArrayList<>(); 

        // add cow each team
        cows.add(new Cow("white 1"));
        cows.add(new Cow("black 1"));
        cows.add(new Cow("brown 1"));
        cows.add(new Cow("white 2"));
        cows.add(new Cow("black 2"));
        cows.add(new Cow("brown 2"));
        cows.add(new Cow("white 3"));
        cows.add(new Cow("black 3"));
        cows.add(new Cow("brown 3"));
    }

    public void start() {
        int totalRounds = 10;
        for (int round = 1; round <= totalRounds; round++) {
            view.showRound(round); 
            for (Cow cow : cows) {
                int[] result = cow.bowl();
                cow.addScore(result); 
                cow.report(result); // report each cow in 1 round
                view.showBowlResult(cow.getColor(), result[0], result[1]);
            }
        }

        cows.sort(Comparator.comparing(Cow::getTotalScore).reversed()); // reverse น้อยไปมาก
        view.showRanking(cows);
        calculateTeamRanking();
    }

    private void calculateTeamRanking() {
        Map<String, Integer> teamScores = new HashMap<>();
        teamScores.put("white", 0);
        teamScores.put("black", 0);
        teamScores.put("brown", 0);

        for (Cow cow : cows) { // Mapping Score each cow (use contain เพราะ เอาแค่ที่มีไว้แบ่งสีของทีมพอ ไม่งั้น Error)
            if (cow.getColor().contains("white")) {
                teamScores.put("white", teamScores.get("white") + cow.getTotalScore());
            } else if (cow.getColor().contains("black")) {
                teamScores.put("black", teamScores.get("black") + cow.getTotalScore());
            } else if (cow.getColor().contains("brown")) {
                teamScores.put("brown", teamScores.get("brown") + cow.getTotalScore());
            }
        }

        List<Map.Entry<String, Integer>> sortedTeams = new ArrayList<>(teamScores.entrySet());
        sortedTeams.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int rank = 1;
        int previousScore = -1; // เอาไว้กันกรณี Team ได้คะแนนรวมตั้งแต่ 1 หรือ 0
        int realRank = 1;
        for (int i = 0; i < sortedTeams.size(); i++) { // ซ้ำจะโชว์  rank เดิม ไม่ซ้ำก็ไปกันต่อ
            Map.Entry<String, Integer> team = sortedTeams.get(i);

            if (team.getValue() != previousScore) {
                realRank = rank;
            }

            view.showTeamRanking(realRank, team.getKey(), team.getValue());
            previousScore = team.getValue();
            rank++;
        }
    }
}
