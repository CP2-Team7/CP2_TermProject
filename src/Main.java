import Class.*;
import GUI.*;

public class Main {
    public static void main(String[] args) {
        GameRepository gameRepository = new GameRepository(); // DB
        gameRepository.printAllQuestionItem(); //디버깅

        UI ui = new UI();
    }
}
