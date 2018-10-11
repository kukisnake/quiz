package com.github.kukisnake.controller;

import com.github.kukisnake.entity.Answer;
import com.github.kukisnake.entity.Question;
import com.github.kukisnake.repository.AnswerRepository;
import com.github.kukisnake.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(path="/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addQuestion () {
        String quest1 = "Które chcesz mieć wybite zęby?";
        String ans1 = "1";
        String ans2 = "2";
        String ans3 = "3";
        String ans4 = "4";

        Set<Answer> answerSet = new HashSet<>();
        answerSet.add(new Answer(ans1));
        answerSet.add(new Answer(ans2));
        answerSet.add(new Answer(ans3));
        answerSet.add(new Answer(ans4));

        Question questionObject = new Question();
        questionObject.setText(quest1);
        questionObject.setAnswers(answerSet);

        questionRepository.save(questionObject);
        return "Dodano pytanie";
    }
}