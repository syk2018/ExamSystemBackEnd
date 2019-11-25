package com.syk.exam.service;

import com.syk.exam.mbg.model.TbExam;
import com.syk.exam.mbg.model.TbQuestions;
import com.syk.exam.mbg.model.TbQuestionsChoice;
import com.syk.exam.mbg.model.TbSturesult;

import java.util.List;

public interface QuestionService {

    TbQuestions getQuestions(Long stuId, String type, int choiceNum);

    List<TbSturesult> submitQuestions(List<TbSturesult> sturesult);

    List<TbSturesult> getResultByExamId(Long examId);

    List<TbExam> getExamByStuId(Long stuId);

    int addChoice(TbQuestionsChoice choice);

    TbQuestionsChoice getChoiceById(Long id);

    int deleteChoice(Long id);
}
