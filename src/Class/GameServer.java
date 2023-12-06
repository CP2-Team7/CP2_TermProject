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
    }

    public String getRanking(UI uui) {
        StringBuilder rankingList = new StringBuilder();
        List<User> ranking = null;

        switch (uui.gameRound.currentCategory) {
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
        switch (uui.gameRound.currentCategory) {
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

        for(User u : ranking) {
            rankingList.append(u.name +"님 : " + u.score[cat] + " 점 \n\n");
        }

        return rankingList.toString();
    }


    public void checkLeaderboard(UI uui) {

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

        updateRankingList(ranking, cu, cat);
        GameRepository.writeRanking(cat, uui.gameRound.currentCategory, ranking);
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
    private static void updateRankingList(List<User> ranking, User newUser, int cat) {
        // 이미 리스트에 있는 이름인 경우
        for (User existingUser : ranking) {
            if (existingUser.name.equals(newUser.name)) {
                if (newUser.score[cat] > existingUser.score[cat]) {
                    existingUser.score[cat] = newUser.score[cat];
                }
                return; // 이미 업데이트 했으므로 종료
            }
        }

        // 리스트에 없는 이름이고, 리스트 사이즈가 10이 넘지 않는 경우
        if (ranking.size() < 10) {
            ranking.add(newUser);
            ranking.sort(Comparator.comparingInt((User u) -> u.score[cat]).reversed());
        } else {
            // 리스트에 없는 이름이고, 리스트 사이즈가 10이 넘는 경우
            int minScore = ranking.get(ranking.size() - 1).score[cat];
            if (newUser.score[cat] > minScore) {
                ranking.removeIf(user -> user.score[cat] == minScore); // 최하 점수를 가진 User 제거
                ranking.add(newUser);
                ranking.sort(Comparator.comparingInt((User u) -> u.score[cat]).reversed());
            }
        }


    }
}
