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

    public void setScore(QuestionName category, int value) {//value 총 점수
        if (category.equals(QuestionName.CAPITAL)) {
            score[0] = value;
        } else if (category.equals(QuestionName.CONNECTION)) {
            score[1] = value;
        } else if (category.equals(QuestionName.FOURLETTERS)) {
            score[2] = value;
        } else {
            throw new IllegalArgumentException("유효하지 않은 카테고리입니다.");
        }
    }
}