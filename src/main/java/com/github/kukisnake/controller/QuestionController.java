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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addQuestion () {
        String quest1 = "Które chcesz mieć wybite zęby?";
        String ans1 = "1";
        String ans2 = "2";
        String ans3 = "3";
        String ans4 = "4";

        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer(ans1));
        answerList.add(new Answer(ans2));
        answerList.add(new Answer(ans3));
        answerList.add(new Answer(ans4));

        Question questionObject = new Question();
        questionObject.setText(quest1);

        questionRepository.save(questionObject);

        for (Answer oneAnswer : answerList) {
            oneAnswer.setQuestion(questionObject);
            answerRepository.save(oneAnswer);
        }

        return "Dodano pytanie";
    }
}