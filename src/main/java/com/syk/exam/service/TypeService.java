package com.syk.exam.service;

import com.syk.exam.mbg.model.TbType;

import java.util.List;

public interface TypeService {
    int createType(TbType type);

    int deleteType(Long id);

    int updateType(TbType type);

    List<TbType> getAllType();

    List<TbType> getTypeByName(String name);

    TbType getTypeById(Long id);
}
