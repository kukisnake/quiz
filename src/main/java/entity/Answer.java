package entity;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id @GeneratedValue
    @Column (name = "answer_id")
    private int answerId;

    @Column (name = "answer_text")
    private String answerText;

    @ManyToOne
    @JoinColumn(name = "question_id" , nullable = false)
    private Question question;

    public Answer() {}

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}