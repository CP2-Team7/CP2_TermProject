import Class.*;
import GUI.*;

public class Main {
    public static void main(String[] args) {
        GameRepository gameRepository = new GameRepository(); // DB
        gameRepository.printAllQuestionItem(); // 디버깅 용도

        //GameServer gameServer = new GameServer(); // Server
        //GameRound gameRound = new GameRound(); // Controller

        //UI ui = new UI();
    }
}
