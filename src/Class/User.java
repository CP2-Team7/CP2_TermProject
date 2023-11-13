package Class;
public class User {
    public String name;
    public int[] score; // 0번 scoreCapital, 1번 scoreConnection, 2번 scoreFourLetters

    public User(String name) {
        this.name = name;
        this.score = new int[3];
    }

    public String getName() {
        return name;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(String category, int value) {//value 총 점수
        if ("수도문제".equals(category)) {
            score[0] = value;
        } else if ("이어말하기문제".equals(category)) {
            score[1] = value;
        } else if ("사자성어문제".equals(category)) {
            score[2] = value;
        } else {
            throw new IllegalArgumentException("유효하지 않은 카테고리입니다.");
        }
    }
}