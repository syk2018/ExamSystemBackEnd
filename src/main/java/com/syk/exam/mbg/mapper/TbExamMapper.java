package com.syk.exam.mbg.mapper;

import com.syk.exam.mbg.model.TbExam;
import com.syk.exam.mbg.model.TbExamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbExamMapper {
    long countByExample(TbExamExample example);

    int deleteByExample(TbExamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbExam record);

    int insertSelective(TbExam record);

    List<TbExam> selectByExample(TbExamExample example);

    TbExam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbExam record, @Param("example") TbExamExample example);

    int updateByExample(@Param("record") TbExam record, @Param("example") TbExamExample example);

    int updateByPrimaryKeySelective(TbExam record);

    int updateByPrimaryKey(TbExam record);
}