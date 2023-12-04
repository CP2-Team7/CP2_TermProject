package Class;

public enum QuestionName {
    CAPITAL("수도 맞추기"), CONNECTION("이어 말하기"), FOURLETTERS("사자 성어");

    final private String name;

    QuestionName(String name) {
        this.name =  name;
    }
    public String getName(){
        return name;
    }
}
