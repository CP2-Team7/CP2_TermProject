package Class;

import Class.Question;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    private final String[] questionNameList = {"capital", "connection", "fourletters"};
    private final String[] questionList = {"questionsCapital", "questionsConnection", "questionsFourLetters"};
    List<Question> questionsCapital; // 수도문제 리스트
    List<Question> questionsConnection; // 이어말하기 문제 리스트
    List<Question> questionsFourLetters; // 사자성어 문제 리스트

    public boolean setQuestion() throws IOException {
        System.out.println(questionNameList.toString() + "게임 문제 세팅을 시작합니다.");
        for (String questionName : questionNameList) {
            setQuestionList(questionName);
            System.out.println(questionName + "문제 세팅을 완료했습니다.");
        }
        return true;
    }

    private void setQuestionList(String questionName) {
        String path = System.getProperty("user.dir") + "/question/" + questionName + ".csv";
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(path));
            String line = "";
            br.readLine();
            while((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                Question question = new Question(questionName, arr[0], arr[1]);
                if(questionName.equals("capital")){
                    questionsCapital.add(question);
                }else if(questionName.equals("connection")) {
                    questionsConnection.add(question);
                }else if(questionName.equals("fourletters")) {
                    questionsFourLetters.add(question);
                }
            }
            br.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
