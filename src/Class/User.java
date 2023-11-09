package Class;
import java.util.*;
public class User {
    String name;
    int[] score; // 0번 scoreCapital, 1번 scoreConnection, 2번 scoreFourLetters

    //getter / setter 메소드
    public ArrayList<Integer> getScoreList() {
        //GameRound r = new GameRound();
        //return r.scoreList;
    }
    public static void main(String[] args) {
        User u = new User();

        Scanner sc = new Scanner(System.in);
        u.name = sc.next();
        u.score = new int[3];
    }
}
