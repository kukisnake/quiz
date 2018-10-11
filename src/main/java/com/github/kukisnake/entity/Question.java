package com.github.kukisnake.entity;


import com.github.kukisnake.repository.QuestionRepository;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "level")
    private String level;

    @OneToMany(mappedBy = "question")
    private Set<Answer> answers;

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}