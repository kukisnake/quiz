package com.github.kukisnake.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVReader {

    public static void main(String[] args) {

        List<QuestionsAndAnswers> qanda = readFromCSV("src/main/resources/csv/q&a_list.csv");

        // print to console
        for (QuestionsAndAnswers q : qanda) {
            System.out.println(q);
        }

    }

    private static List<QuestionsAndAnswers> readFromCSV(String fileName) {
        List<QuestionsAndAnswers> qanda = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {

                String line = br.readLine();

                while (line != null) {
                    String[] attributes = line.split(",");

                    QuestionsAndAnswers questionsAndAnswers = createQuestionSet(attributes);
                    qanda.add(questionsAndAnswers);

                    line = br.readLine();
                }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return qanda;
    }

    private static QuestionsAndAnswers createQuestionSet(String[] metadata) {
        String question = metadata[0];
        String answer1 = metadata[1];
        String answer2 = metadata[2];
        String answer3 = metadata[3];
        String answer4 = metadata[4];

        return new QuestionsAndAnswers(question, answer1, answer2, answer3, answer4);
    }
}
