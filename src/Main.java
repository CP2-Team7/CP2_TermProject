import Class.*;
import GUI.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GameRepository gameRepository = new GameRepository(); // DB
        gameRepository.printAllQuestionItem(); // 디버깅 용도

        GameServer gameServer = new GameServer(); // Server
        GameRound gameRound = new GameRound(); // Controller

        // 테스트
        User user = new User("yujin");
        gameRound.initGameRound(QuestionName.CAPITAL, user);
        gameRound.printAllItem();

        UI ui = new UI();
    }
}
