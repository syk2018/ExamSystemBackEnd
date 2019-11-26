package com.syk.exam.service.impl;

import com.syk.exam.common.api.ResultCode;
import com.syk.exam.mbg.mapper.TbTypeMapper;
import com.syk.exam.mbg.model.TbType;
import com.syk.exam.mbg.model.TbTypeExample;
import com.syk.exam.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TbTypeMapper typeMapper;

    @Override
    public int createType(TbType type) {
        if(getTypeByName(type.getType()).isEmpty()) {
            return this.typeMapper.insertSelective(type);
        }
        return ResultCode.DUPLICATE.getCode();
    }

    @Override
    public int deleteType(Long id) {
        return this.typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateType(TbType type) {
        return this.typeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public List<TbType> getAllType() {

        return typeMapper.selectByExample(new TbTypeExample());
    }

    @Override
    public List<TbType> getTypeByName(String name) {
        List<TbType> result;
        TbTypeExample typeExample = new TbTypeExample();
        typeExample.createCriteria().andTypeEqualTo(name);
        result = typeMapper.selectByExample(typeExample);
        return result;
    }

    @Override
    public TbType getTypeById(Long id) {

        return typeMapper.selectByPrimaryKey(id);
    }
}
