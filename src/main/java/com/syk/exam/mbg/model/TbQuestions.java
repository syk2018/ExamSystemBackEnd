package com.syk.exam.mbg.model;

import java.util.List;

/**
 * @author: shaoyikun
 * @Date: 2019-11-25
 * @Description:
 **/
public class TbQuestions {

    private Long examId;

    private List<TbQuestionsChoice> questionsChoices;

    public List<TbQuestionsChoice> getQuestionsChoices() {
        return questionsChoices;
    }

    public void setQuestionsChoices(List<TbQuestionsChoice> questionsChoices) {
        this.questionsChoices = questionsChoices;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }
}
