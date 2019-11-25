package com.syk.exam.service.impl;

import com.syk.exam.mbg.mapper.TbQuestionsChoiceMapper;
import com.syk.exam.mbg.model.TbQuestions;
import com.syk.exam.mbg.model.TbQuestionsChoice;
import com.syk.exam.mbg.model.TbQuestionsChoiceExample;
import com.syk.exam.mbg.model.TbType;
import com.syk.exam.service.QuestionService;
import com.syk.exam.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: shaoyikun
 * @Date: 2019-11-25
 * @Description:
 **/
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private TbQuestionsChoiceMapper choiceMapper;

    @Autowired
    private TypeService typeService;

    @Override
    public TbQuestions getQuestions(String type, int choiceNum) {

        TbQuestions questions = new TbQuestions();

        List<TbType> selectType = typeService.getTypeByName(type);

        TbQuestionsChoiceExample choiceExample = new TbQuestionsChoiceExample();

        choiceExample.createCriteria().andTypeidEqualTo(selectType.get(0).getId());

        List<TbQuestionsChoice> result = this.random(choiceMapper.selectByExample(choiceExample),choiceNum);

        questions.setQuestionsChoices(result);

        return questions;
    }

    @Override
    public int addChoice(TbQuestionsChoice choice) {
        return choiceMapper.insertSelective(choice);
    }

    @Override
    public TbQuestionsChoice getChoiceById(Long id) {
        return choiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteChoice(Long id) {
        return choiceMapper.deleteByPrimaryKey(id);
    }

    private <T> List<T> random(List<T> selected,int num) {
        List<T> result = new ArrayList<>();

        Random random = new Random();

        while (result.size() < num) {
            int n = random.nextInt(selected.size());
            T temp = selected.get(n);
            if(result.contains(temp)) {
                continue;
            } else {
                result.add(temp);
            }
        }

        return result;
    }
}
