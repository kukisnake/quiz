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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String addQuestion() {

        String csvFilePath = "src/main/resources/csv/q&a_list.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {

            while ((line = br.readLine()) != null) {

                String[] questionAndAnswersArray = line.split(csvSplitBy);

                List<Answer> answerList = new ArrayList<>();
                answerList.add(new Answer(questionAndAnswersArray[1]));
                answerList.add(new Answer(questionAndAnswersArray[2]));
                answerList.add(new Answer(questionAndAnswersArray[3]));
                answerList.add(new Answer(questionAndAnswersArray[4]));

                Question questionObject = new Question();
                questionObject.setText(questionAndAnswersArray[0]);

                questionRepository.save(questionObject);

                for (Answer oneAnswer : answerList) {
                    oneAnswer.setQuestion(questionObject);
                    answerRepository.save(oneAnswer);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Dodano pytanie";
    }
}