package Class;

import GUI.*;
import Class.*;

import java.util.*;

public class GameServer {
    List<User> users;
    //implement rankings as linked instead of array
    public List<User> rankingCapital; 
    void setRankingCaptial(List<User> set) {rankingCapital = set;}
    public List<User> rankingConnection;
    void setRankingConnection(List<User> set) {rankingConnection = set;}
    public List<User> rankingFourLetters;
    void setRankingFourLetters(List<User> set) {rankingFourLetters = set;}

    final int setSize = 10;
    final int rankingSize = 10;

    public GameServer() {
        users = new ArrayList<User>();
        rankingCapital = GameRepository.rankingCapital;
        rankingConnection = GameRepository.rankingConnection;
        rankingFourLetters = GameRepository.rankingFourLetters;
        //do the things where you read from files later
    }

    public String checkLeaderboard(UI uui) {

        int score = uui.submit.score;
        User cu = uui.gameRound.currentUser;
        QuestionName category = uui.gameRound.currentCategory;

        List<User> ranking = null;

        switch (category) {
            case CAPITAL:
                ranking = uui.gameServer.rankingCapital;
                break;
            case CONNECTION:
                ranking = uui.gameServer.rankingConnection;
                break;
            case FOURLETTERS:
                ranking = uui.gameServer.rankingFourLetters;
                break;
            default:
                break;
        }

        int cat = 0;
        switch (category) {
            case CAPITAL:
                cat = 0;
                break;
            case CONNECTION:
                cat = 1;
                break;
            case FOURLETTERS:
                cat = 2;
                break;
            default:
                break;
        }

        for(int i = 0; i < ranking.size(); i++) {
            if(ranking.get(i).score[cat] < score) {
                ranking.add(i, cu);
                break;
            }
        }

        StringBuilder rankingList = new StringBuilder();

        for(User u : ranking) {
            rankingList.append(u.name +"님 : " + u.score[cat] + " 점 \n\n");
        }

        GameRepository.writeRanking(cat, category, ranking);

        return rankingList.toString();
    }

    void checkPersonalHigh(int score, User user, QuestionName category) {
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
