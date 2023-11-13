package Class;
import java.util.*;

public class GameServer {
    List<User> users;
    List<Question> questionsCapital;
    List<Question> questionsConnection;
    List<Question> questionsFourLetters;
    //implement rankings as linked instead of array
    List<User> rankingCapital; 
    void setRankingCaptial(List<User> set) {rankingCapital = set;}
    List<User> rankingConnection;
    void setRankingConnection(List<User> set) {rankingConnection = set;}
    List<User> rankingFourLetters;
    void setRankingFourLetters(List<User> set) {rankingFourLetters = set;}

    final int setSize = 10;
    final int rankingSize = 10;

    public void init() {
        users = new ArrayList<User>();
        questionsCapital = new ArrayList<Question>();
        questionsConnection = new ArrayList<Question>();
        questionsFourLetters = new ArrayList<Question>();
        rankingCapital = new LinkedList<User>();
        rankingConnection = new LinkedList<User>();
        rankingFourLetters = new LinkedList<User>();
        //do the things where you read from files later
    }

    public Question[] GetQuestionSet(String type) {
        List<Question> origin;
        switch(type) {
            case "Capital" :
                origin = questionsCapital;
                break;
            case "Connection" :
                origin = questionsConnection;
                break;
            case "FourLetters" :
                origin = questionsFourLetters;
                break;
            default : 
                System.out.println("장비를 정지합니다");
                break;
        }

        Random rand = new Random();
        Set<Question> temp = new HashSet<Question>();
        for(int i = 0; i < setSize;) {
            if(temp.add(origin[rand.nextInt(origin.size())])) {
                i++;
            }
        }

        return temp.toArray();
    }

    void checkLeaderboard(int score, User user, String category) {
        List<User> leaderboard;
        switch(category) {
            case "Capital" :
                leaderboard = rankingCapital;
                break;
            case "Connection" :
                leaderboard = rankingConnection;
                break;
            case "FourLetters" :
                leaderboard = rankingFourLetters;
                break;
            default : 
                System.out.println("장비를 정지합니다");
                break;
        }

        for(int i; i < rankingSize; i++) {
            if(score > leaderboard[i]) {
                leaderboard.add(i, user);
                leaderboard.remove(rankingSize);
                break;
            }
        }

        //write to repository
        //GameRepository.whateverthenameis
    }

    void checkPersonalHigh(int score, User user, String category) {
        int ogScore;
        switch(category) {
            case "Capital" :
                ogScore = user.score[0];
                break;
            case "Connection" :
                ogScore = user.score[1];
                break;
            case "FourLetters" :
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

    boolean[] checkAnswer(List<Integer> answers, List<Question> questions) {
        boolean[] ret = new boolean[setSize];

        for(int i = 0; i < setSize; i++) {
            if(answers.get(i) == questions.get(i).getAnswer) {
                ret[i] = true;
            }
            else {
                ret[i] = false;
            }
        }

        return ret;
    }
}
