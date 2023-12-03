package Class;

import java.util.*;
import java.util.stream.IntStream;

public class GameRound {
    static final int stepNumber = 10;
    final int scoreRate = 10;
    public QuestionName currentCategory;
    public User currentUser;
    public List<Question> questionList;
    public ArrayList<String> answerList;
    public ArrayList<Integer> scoreList;


    public void initGameRound(QuestionName cG, User cU) {
        currentCategory = cG;
        currentUser = cU;
        questionList = new ArrayList<>();
        answerList = new ArrayList<>();
        scoreList = new ArrayList<>();
        setQuestionListRandom(currentCategory);
    }
    public QuestionName getCurrentCategory() {return currentCategory;}
    public List<Question> getQuestionList() {
        return questionList;
    }
    public ArrayList<String> getAnswerList() {
        return answerList;
    }
    public ArrayList<Integer> getScoreList() {
        return scoreList;
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
        return IntStream.range(0, answerList.size())
                .mapToObj(i -> answerList.get(i).equals(userAnswerList.get(i)) ? 1 : 0)
                .peek(scoreList::add)
                .reduce(0, Integer::sum) * scoreRate;
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
        System.out.println("currentCategory : " + currentCategory);
        System.out.println("currentUser : " + currentUser.name + currentUser.score);
        System.out.println("questionList : ");
        for(int i = 0; i < questionList.size(); i++) {
            System.out.printf("#%d | %s | %s | %s\n", i+1, questionList.get(i).category, questionList.get(i).content, questionList.get(i).answer);
        }
        System.out.println("answerList : " + answerList.toString());
        System.out.println("scoreList : " + scoreList.toString());
    }
}
