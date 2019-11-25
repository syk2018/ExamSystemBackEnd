package com.syk.exam.service.impl;

import com.syk.exam.common.api.ResultCode;
import com.syk.exam.mbg.mapper.TbStudentMapper;
import com.syk.exam.mbg.model.TbStudent;
import com.syk.exam.mbg.model.TbStudentExample;
import com.syk.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbStudentMapper studentMapper;

    @Override
    public List<TbStudent> getUserByUsername(TbStudent student) {
        TbStudentExample studentExample = new TbStudentExample();
        studentExample.createCriteria().andNameEqualTo(student.getName());

        return studentMapper.selectByExample(studentExample);
    }

    @Override
    public TbStudent getUserById(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createUser(TbStudent student) {
        List<TbStudent> result = getUserByUsername(student);
        if(result.isEmpty()) {
            student.setJointime(new Date());
            return studentMapper.insertSelective(student);
        }
        else return ResultCode.DUPLICATE.getCode();
    }

    @Override
    public int deleteUser(Long id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TbStudent> login(TbStudent student) {
        List<TbStudent> result;
        TbStudentExample studentExample = new TbStudentExample();
        studentExample.createCriteria().andCardnoEqualTo(student.getCardno()).andPwdEqualTo(student.getPwd());

        result = studentMapper.selectByExample(studentExample);

        return result;
    }
}
