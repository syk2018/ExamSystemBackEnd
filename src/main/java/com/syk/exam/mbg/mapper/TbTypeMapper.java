package com.syk.exam.mbg.mapper;

import com.syk.exam.mbg.model.TbType;
import com.syk.exam.mbg.model.TbTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTypeMapper {
    long countByExample(TbTypeExample example);

    int deleteByExample(TbTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbType record);

    int insertSelective(TbType record);

    List<TbType> selectByExample(TbTypeExample example);

    TbType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbType record, @Param("example") TbTypeExample example);

    int updateByExample(@Param("record") TbType record, @Param("example") TbTypeExample example);

    int updateByPrimaryKeySelective(TbType record);

    int updateByPrimaryKey(TbType record);
}