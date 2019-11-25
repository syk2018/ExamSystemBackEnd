package com.syk.exam.controller;

import com.syk.exam.common.api.CommonResult;
import com.syk.exam.common.api.ResultCode;
import com.syk.exam.mbg.model.TbQuestions;
import com.syk.exam.mbg.model.TbQuestionsChoice;
import com.syk.exam.mbg.model.TbType;
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
@RequestMapping(value = "/rep/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @ApiOperation("Get Question")
    @RequestMapping(value = "getByType", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TbQuestions> GetQuestionByType(@RequestParam("stuId") Long stuId, @RequestParam("type") String type, @RequestParam("num") int num) {
        return CommonResult.success(questionService.getQuestions(stuId, type, num));
    }

    @ApiOperation("Create Choice Question")
    @RequestMapping(value = "createChoice", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createChoice(@RequestBody TbQuestionsChoice choice) {

        questionService.addChoice(choice);

        return CommonResult.success(choice,"success");

    }
}
