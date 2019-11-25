package com.syk.exam.mbg.mapper;

import com.syk.exam.mbg.model.TbExamid;
import com.syk.exam.mbg.model.TbExamidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbExamidMapper {
    long countByExample(TbExamidExample example);

    int deleteByExample(TbExamidExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbExamid record);

    int insertSelective(TbExamid record);

    List<TbExamid> selectByExample(TbExamidExample example);

    TbExamid selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbExamid record, @Param("example") TbExamidExample example);

    int updateByExample(@Param("record") TbExamid record, @Param("example") TbExamidExample example);

    int updateByPrimaryKeySelective(TbExamid record);

    int updateByPrimaryKey(TbExamid record);
}