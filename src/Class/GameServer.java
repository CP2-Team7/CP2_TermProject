package Class;
import java.util.*;

public class GameServer {
    static List<User> users;
    //implement rankings as linked instead of array
    static List<User> rankingCapital; 
    void setRankingCaptial(List<User> set) {rankingCapital = set;}
    static List<User> rankingConnection;
    void setRankingConnection(List<User> set) {rankingConnection = set;}
    static List<User> rankingFourLetters;
    void setRankingFourLetters(List<User> set) {rankingFourLetters = set;}

    static final int setSize = 10;
    static final int rankingSize = 10;

    static public void init() {
        users = new ArrayList<User>();
        rankingCapital = GameRepository.rankingCapital;
        rankingConnection = GameRepository.rankingConnection;
        rankingFourLetters = GameRepository.rankingFourLetters;
        //do the things where you read from files later
    }

    static void checkLeaderboard(int score, User user, QuestionName category) {
        List<User> leaderboard = rankingCapital;
        int type = 0;
        switch(category) {
            case CAPITAL :
                leaderboard = rankingCapital;
                type = 0;
                break;
            case CONNECTION :
                leaderboard = rankingConnection;
                type = 1;
                break;
            case FOURLETTERS :
                leaderboard = rankingFourLetters;
                type = 2;
                break;
            default : 
                System.out.println("장비를 정지합니다");
                break;
        }

        for(int i = 0; i < rankingSize; i++) {
            if(score > leaderboard.get(i).score[type]) {
                leaderboard.add(i, user);
                leaderboard.remove(rankingSize);
                break;
            }
        }

        //write to repository
        //GameRepository.whateverthenameis
    }

    static void checkPersonalHigh(int score, User user, QuestionName category) {
        int ogScore = 0;
        switch(category) {
            case CAPITAL :
                ogScore = user.score[0];
                break;
            case CONNECTION :
                ogScore = user.score[1];
                break;
            case FOURLETTERS :
                ogScore = user.score[2];
                break;
            default : 
                System.out.println("장비를 정지합니다");
                break;
        }

        if(score > ogScore) {
            ogScore = score;
        }
    }
}
