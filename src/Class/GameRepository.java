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

    public GameRepository() {
        questionsCapital = new ArrayList<>();
        questionsConnection = new ArrayList<>();
        questionsFourLetters = new ArrayList<>();
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
    }

}