package com.github.kukisnake.entity;

import com.github.kukisnake.repository.AnswerRepository;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id @GeneratedValue
    @Column (name = "id")
    private int id;

    @Column (name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "question_id" , nullable = false)
    private Question question;

    public Answer(String answerText) {
        this.text = answerText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}