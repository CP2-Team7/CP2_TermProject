package Class;

import java.util.*;

public class GameRound {
    final int stepNumber = 10;
    final int scoreRate = 10;
    QuestionName currentCategory;
    User currentUser;
    List<Question> questionList;
    ArrayList<String> answerList;
    ArrayList<Integer> scoreList;


    public void initGameRound(QuestionName currentCategory, User currentUser) {
        this.currentCategory = currentCategory;
        this.currentUser = currentUser;
        this.questionList = new ArrayList<>();
        this.answerList = new ArrayList<>();
        this.scoreList = new ArrayList<>();
        setQuestionListRandom(currentCategory);
    }

    private void setQuestionListRandom(QuestionName currentCategory) {
        List<Question> list = new ArrayList<>();
        if (currentCategory.equals(QuestionName.CAPITAL)) {
            list = GameRepository.questionsCapital;
        } else if (currentCategory.equals(QuestionName.CONNECTION)) {
            list = GameRepository.questionsConnection;
        } else if (currentCategory.equals(QuestionName.FOURLETTERS)) {
            list = GameRepository.questionsFourLetters;
        }

        Integer[] arr = setRandomNumber(stepNumber, list.size());

        // 앞서 추출한 랜덤 넘버로 문제를 뽑고 출제할 문제 리스트에 추가
        for (int i = 0; i < arr.length; i++) {
            questionList.add(list.get(arr[i]));
            answerList.add(list.get(arr[i]).answer);
        }
    }

    // 유저가 제출한 답과 문제의 정답을 비교해 채점한 후 score 기록
    // 유저가 제출한 답 : String 타입의 list (문제 순서대로)
    // return : total score (int)
    public int checkAnswer(List<String> userAnswerList) {
        int totalScore = 0;

        for(int i = 0; i < answerList.size(); i++) {
            if(answerList.get(i).equals(userAnswerList.get(i))) {
                scoreList.add(1);
                totalScore++;
            } else {
                scoreList.add(0);
            }
        }
        return totalScore * scoreRate;
    }

    // 중복 없이 범위 내에서 난수 생성
    private Integer[] setRandomNumber(int count, int listSize) {
        Set<Integer> set = new HashSet<>();
        while (set.size() < count) {
            Double d = Math.random() * (listSize-1) + 0;
            set.add(d.intValue());
        }
        Integer[] randomNumbers = set.toArray(new Integer[0]);
        Arrays.sort(randomNumbers);
        return randomNumbers;
    }

    public void printAllItem() {
        System.out.println("currentCategory : " + this.currentCategory);
        System.out.println("currentUser : " + this.currentUser.name + this.currentUser.score);
        System.out.println("questionList : ");
        for(int i = 0; i < questionList.size(); i++) {
            System.out.printf("#%d | %s | %s | %s\n", i+1, questionList.get(i).category, questionList.get(i).content, questionList.get(i).answer);
        }
        System.out.println("answerList : " + answerList.toString());
        System.out.println("scoreList : " + scoreList.toString());
    }

    public boolean checkAnswer() {
        for(int i = 0; i < stepNumber; i++) {
            if(!answerList.get(i).equals(questionList.get(i).answer)) {
                return false;
            }
        }
        return true;
    }
}
