package Class;

import Class.Question;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    List<Question> questionsCapital; // 수도문제 리스트
    List<Question> questionsConnection; // 이어말하기 문제 리스트
    List<Question> questionsFourLetters; // 사자성어 문제 리스트
    List<Question> questionList;

    public boolean setQuestion(String questionName) throws IOException {
        String path = System.getProperty("user.dir") + "/question/" + questionName + ".csv";
        BufferedReader br;
        questionList = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(path));
            String line = "";
            while((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                Question question = new Question("questionName", arr[0], arr[1]);
                questionList.add(question);
            }
            br.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
