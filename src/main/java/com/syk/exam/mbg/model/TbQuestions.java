package com.syk.exam.mbg.model;

import java.util.List;

/**
 * @author: shaoyikun
 * @Date: 2019-11-25
 * @Description:
 **/
public class TbQuestions {
    
    private List<TbQuestionsChoice> questionsChoices;

    public List<TbQuestionsChoice> getQuestionsChoices() {
        return questionsChoices;
    }

    public void setQuestionsChoices(List<TbQuestionsChoice> questionsChoices) {
        this.questionsChoices = questionsChoices;
    }
}
