package com.syk.exam.mbg.mapper;

import com.syk.exam.mbg.model.TbQuestionsChoice;
import com.syk.exam.mbg.model.TbQuestionsChoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbQuestionsChoiceMapper {
    long countByExample(TbQuestionsChoiceExample example);

    int deleteByExample(TbQuestionsChoiceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbQuestionsChoice record);

    int insertSelective(TbQuestionsChoice record);

    List<TbQuestionsChoice> selectByExample(TbQuestionsChoiceExample example);

    TbQuestionsChoice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbQuestionsChoice record, @Param("example") TbQuestionsChoiceExample example);

    int updateByExample(@Param("record") TbQuestionsChoice record, @Param("example") TbQuestionsChoiceExample example);

    int updateByPrimaryKeySelective(TbQuestionsChoice record);

    int updateByPrimaryKey(TbQuestionsChoice record);
}