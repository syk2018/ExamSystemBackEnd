package com.syk.exam.controller;

import com.syk.exam.common.api.CommonResult;
import com.syk.exam.common.api.ResultCode;
import com.syk.exam.mbg.model.TbQuestions;
import com.syk.exam.mbg.model.TbQuestionsChoice;
import com.syk.exam.mbg.model.TbSturesult;
import com.syk.exam.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: shaoyikun
 * @Date: 2019-11-25
 * @Description:
 **/
@Api(tags = "QuestionController", description = "Question information api")
@Controller
@RequestMapping(value = "web/rep/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @ApiOperation("Get Question")
    @RequestMapping(value = "getQuestionByType", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TbQuestions> GetQuestionByType(@RequestParam("stuId") Long stuId, @RequestParam("typeId") Long typeId, @RequestParam("num") int num) {
        return CommonResult.success(questionService.getQuestions(stuId, typeId, num));
    }

    @ApiOperation("Get Exam by student id")
    @RequestMapping(value = "getExamById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getExamById(@RequestParam("stuId") Long id) {
        return CommonResult.success(questionService.getExamByStuId(id));
    }

    @ApiOperation("Get Result by exam id")
    @RequestMapping(value = "getResultById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getResultById(@RequestParam("examId") Long id) {
        return CommonResult.success(questionService.getResultByExamId(id));
    }

    @ApiOperation("Submit Result")
    @RequestMapping(value = "submit", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult submit(@RequestBody List<TbSturesult> sturesult) {

        return CommonResult.success(questionService.submitQuestions(sturesult));
    }

    @ApiOperation("Get Choice By id")
    @RequestMapping(value = "getChoiceById", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getChoiceById(@RequestBody List<Long> id) {
        return CommonResult.success(questionService.getChoiceById(id));
    }

    @ApiOperation("Create Choice Question")
    @RequestMapping(value = "createChoice", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createChoice(@RequestBody TbQuestionsChoice choice) {

        questionService.addChoice(choice);

        return CommonResult.success(choice,"success");

    }
}
