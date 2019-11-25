package com.syk.exam.service;

import com.syk.exam.mbg.model.TbQuestions;
import com.syk.exam.mbg.model.TbQuestionsChoice;

import java.util.List;

public interface QuestionService {

    TbQuestions getQuestions(String type, int choiceNum);

    int addChoice(TbQuestionsChoice choice);

    TbQuestionsChoice getChoiceById(Long id);

    int deleteChoice(Long id);
}
