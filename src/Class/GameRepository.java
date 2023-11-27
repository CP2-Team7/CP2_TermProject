package Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    public static List<Question> questionsCapital; // 수도문제 리스트
    public static List<Question> questionsConnection; // 이어말하기 문제 리스트
    public static List<Question> questionsFourLetters; // 사자성어 문제 리스트
    public static List<User> rankingCapital;
    public static List<User> rankingConnection;
    public static List<User> rankingFourLetters;

    public GameRepository() {
        questionsCapital = new ArrayList<>();
        questionsConnection = new ArrayList<>();
        questionsFourLetters = new ArrayList<>();
        rankingCapital = new ArrayList<>();
        rankingConnection = new ArrayList<>();
        rankingFourLetters = new ArrayList<>();
        this.setQuestion();
        this.setUserRanking();
    }

    public boolean setQuestion() {
        System.out.println("게임 문제 세팅을 시작합니다.");
        for(QuestionName questionName : QuestionName.values()) {
            int size = setQuestionList(questionName);
            System.out.printf("%s 문제 %d개 세팅을 완료했습니다.\n", questionName, size);
        }
        return true;
    }

    private int setQuestionList(QuestionName questionName) {
        String path = System.getProperty("user.dir") + "/question/" + questionName + ".csv";
        System.out.println(path);
        BufferedReader br;
        List<Question> list = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(path));
            String line = "";
            br.readLine();
            while((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                Question question = new Question(questionName, arr[0], arr[1]);
                if(questionName.equals(QuestionName.CAPITAL)){
                    list = questionsCapital;
                }else if(questionName.equals(QuestionName.CONNECTION)) {
                    list = questionsConnection;
                }else if(questionName.equals(QuestionName.FOURLETTERS)) {
                    list = questionsFourLetters;
                }
                list.add(question);
            }
            br.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list.size();
    }

    public void setUserRanking() {
        System.out.println("유저 랭킹 세팅을 시작합니다.");
        for(QuestionName questionName : QuestionName.values()) {
            int size = setUserRankingList(questionName);
            System.out.printf("%s 유저 랭킹 %d명 세팅을 완료했습니다.\n", questionName, size);
        }
    }

    private int setUserRankingList(QuestionName questionName) {
        String path = System.getProperty("user.dir") + "/userRanking/UserRanking_" + questionName + ".csv";
        BufferedReader br;
        List<User> list = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(path));
            String line = "";
            br.readLine();
            while((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                User user = new User(arr[1]);

                if(questionName.equals(QuestionName.CAPITAL)){
                    list = rankingCapital;
                }else if(questionName.equals(QuestionName.CONNECTION)) {
                    list = rankingConnection;
                }else if(questionName.equals(QuestionName.FOURLETTERS)) {
                    list = rankingFourLetters;
                }

                user.setScore(questionName.toString(), Integer.parseInt(arr[1]));

                user.setScore(questionName, Integer.parseInt(arr[2]));

                list.add(user);
            }
            br.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list.size();
    }


    // 각 분야별로 setting된 question item 출력 함수, test용도
    public void printAllQuestionItem() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("수도 문제 리스트업");
        for(int i = 0; i < questionsCapital.size(); i++) {
            System.out.printf("#%d | %s | %s | %s\n", i+1, questionsCapital.get(i).category, questionsCapital.get(i).content, questionsCapital.get(i).answer );
        }
        System.out.println("-----------------------------------------------------------------------");

        System.out.println("이어말하기 문제 리스트업");
        for(int i = 0; i < questionsConnection.size(); i++) {
            System.out.printf("#%d | %s | %s | %s\n", i+1, questionsConnection.get(i).category, questionsConnection.get(i).content, questionsConnection.get(i).answer );
        }
        System.out.println("-----------------------------------------------------------------------");

        System.out.println("사자성어 문제 리스트업");
        for(int i = 0; i < questionsFourLetters.size(); i++) {
            System.out.printf("#%d | %s | %s | %s\n", i+1, questionsFourLetters.get(i).category, questionsFourLetters.get(i).content, questionsFourLetters.get(i).answer );
        }
        System.out.println("-----------------------------------------------------------------------");

        System.out.println("capital 카테고리 user ranking 리스트업");
        for(User user : rankingCapital) {
            System.out.printf("%s %s | ", user.name, user.score[0]);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");

        System.out.println("connection 카테고리 user ranking 리스트업");
        for(User user : rankingConnection) {
            System.out.printf("%s %s | ", user.name, user.score[1]);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");

        System.out.println("fourletters 카테고리 user ranking 리스트업");
        for(User user : rankingFourLetters) {
            System.out.printf("%s %s | ", user.name, user.score[2]);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
    }

}
