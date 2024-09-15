package Model;

import java.util.Random;

public class Cow {
    private String color; // separate team 
    private int[] scores = new int[10];
    private int totalScore = 0; // find winner
    private boolean isBlackTeam; // เอาไว้แยก condition black สำหรับการโกง
    private boolean isWhiteTeam; // เอาไว้แยก condition white สำหรับการโกงเช่นกันงับ
    private boolean isBrownTeam; // เอาไว้บอกทีมน้ำตาลเฉยๆ เพื่อแยกให้ชัดเจนว่าอยู่ทีมไหน (เอาไว้ check)
    private Random rand = new Random();

    public Cow(String color) {
        this.color = color;
        this.isWhiteTeam = color.equals("white"); 
        this.isBlackTeam = color.equals("black"); 
    }

    public int[] bowl() {
        int remainingPins = 10;
        int[] result = new int[2];

        // first throw
        result[0] = rand.nextInt(remainingPins + 1);
        remainingPins -= result[0];

        // check black team
        if (isBlackTeam && rand.nextDouble() < 0.2) {
            result[0] = 0;  
        }

        if (isWhiteTeam && rand.nextDouble() < 0.1) {
            result[0] = 10;  // ล้างท่อ -> Strike
        }

        if (result[0] == 10) {
            return result; // ถ้า strike ไม่ต้องโยนครั้งที่สอง
        }

        // second throw
        result[1] = rand.nextInt(remainingPins + 1);

        // condition black
        if (isBlackTeam && rand.nextDouble() < 0.2) {
            result[1] = 0;  
        }

        // condition white
        if (isWhiteTeam && rand.nextDouble() < 0.1) {
            result[1] = 10; //spare
        }

        return result;
    }

    public void addScore(int[] result) { // total by per round unitl end game
        int score = result[0] + result[1];
        totalScore += score;
    }

    public void report(int[] actualResult) {
        System.out.println("Cow " + color + " bowled: " + actualResult[0] + " + " + actualResult[1]); // พินที่ล้ม
    }

    // Getter & Setter Method 
    public String getColor() {
        return color;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public boolean isBlackTeam() {
        return isBlackTeam;
    }

    public void setBlackTeam(boolean isBlackTeam) {
        this.isBlackTeam = isBlackTeam;
    }

    public boolean isWhiteTeam() {
        return isWhiteTeam;
    }

    public void setWhiteTeam(boolean isWhiteTeam) {
        this.isWhiteTeam = isWhiteTeam;
    }

    public boolean isBrownTeam() {
        return isBrownTeam;
    }

    public void setBrownTeam(boolean isBrownTeam) {
        this.isBrownTeam = isBrownTeam;
    }

    // random
    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }
}