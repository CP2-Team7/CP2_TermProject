package Class;

public class Question {
    public QuestionName category;
    public String content;
    public String answer;

    public Question(QuestionName category, String content, String answer) {
        this.category = category;
        this.content = content;
        this.answer = answer;
    }

    // Getter와 Setter 메서드
    public QuestionName getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public String getAnswer() {
        return answer;
    }
}
