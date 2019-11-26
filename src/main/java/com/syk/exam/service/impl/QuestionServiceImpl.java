package com.syk.exam.service.impl;

import com.syk.exam.mbg.mapper.TbExamMapper;
import com.syk.exam.mbg.mapper.TbQuestionsChoiceMapper;
import com.syk.exam.mbg.mapper.TbSturesultMapper;
import com.syk.exam.mbg.model.*;
import com.syk.exam.service.QuestionService;
import com.syk.exam.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    private TbExamMapper examMapper;

    @Autowired
    private TbQuestionsChoiceMapper choiceMapper;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TbSturesultMapper sturesultMapper;

    @Override
    public TbQuestions getQuestions(Long stuId, Long typeId, int choiceNum) {

        TbExam exam = new TbExam();

        exam.setExamtime(new Date());
        exam.setStuid(stuId);

        examMapper.insertSelective(exam);

        TbQuestions questions = new TbQuestions();

        TbType selectType = typeService.getTypeById(typeId);

        TbQuestionsChoiceExample choiceExample = new TbQuestionsChoiceExample();

        choiceExample.createCriteria().andTypeidEqualTo(selectType.getId());

        List<TbQuestionsChoice> result = this.random(choiceMapper.selectByExample(choiceExample),choiceNum);

        questions.setQuestionsChoices(result);
        questions.setExamId(exam.getId());

        return questions;
    }

    @Override
    public List<TbSturesult> submitQuestions(List<TbSturesult> sturesult) {

        Long id = sturesult.get(0).getExamid();

        TbExam exam = this.examMapper.selectByPrimaryKey(id);

        exam.setHassubmit(true);

        this.examMapper.updateByPrimaryKey(exam);

        for(int i=0; i<sturesult.size(); i++) {
            sturesultMapper.insertSelective(sturesult.get(i));
        }

        return sturesult;

    }

    @Override
    public List<TbSturesult> getResultByExamId(Long examId) {
        TbSturesultExample sturesultExample = new TbSturesultExample();
        sturesultExample.createCriteria().andExamidEqualTo(examId);

        return sturesultMapper.selectByExample(sturesultExample);
    }

    @Override
    public List<TbExam> getExamByStuId(Long stuId) {
        TbExamExample examExample = new TbExamExample();
        examExample.setOrderByClause("ExamTime DESC");
        examExample.createCriteria().andStuidEqualTo(stuId).andHassubmitEqualTo(true);

        return examMapper.selectByExample(examExample);
    }

    @Override
    public int addChoice(TbQuestionsChoice choice) {
        return choiceMapper.insertSelective(choice);
    }

    @Override
    public List<TbQuestionsChoice> getChoiceById(List<Long> id) {
        List<TbQuestionsChoice> result = new ArrayList<>();

        for(int i=0; i<id.size(); i++) {
            result.add(choiceMapper.selectByPrimaryKey(id.get(i)));
        }
        return result;
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
