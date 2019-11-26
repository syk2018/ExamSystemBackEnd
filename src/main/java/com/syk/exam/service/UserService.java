package com.syk.exam.service;

import com.syk.exam.mbg.model.TbStudent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    List<TbStudent> getUserByCardId(TbStudent student);

    TbStudent getUserById(Long id);

    int createUser(TbStudent student);

    int deleteUser(Long id);

    List<TbStudent> login(TbStudent student);

}
