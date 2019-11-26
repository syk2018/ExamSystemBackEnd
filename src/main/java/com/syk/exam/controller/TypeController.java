package com.syk.exam.controller;

import com.syk.exam.common.api.CommonResult;
import com.syk.exam.common.api.ResultCode;
import com.syk.exam.mbg.model.TbType;
import com.syk.exam.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "TypeController", description = "Type information api")
@Controller
@RequestMapping(value = "web/rep/Type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @ApiOperation("Create Type")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createType(@RequestBody TbType type) {
        int result = typeService.createType(type);
        if(result == ResultCode.DUPLICATE.getCode()) {
            return CommonResult.duplicate("Duplicate type name.");
        }
        else {
            List<TbType> temp = typeService.getTypeByName(type.getType());
            return CommonResult.success(temp);
        }
    }

    @ApiOperation("Get Type")
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAllType() {
        return CommonResult.success(typeService.getAllType());
    }
}
