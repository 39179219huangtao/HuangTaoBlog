package com.hyc.shop.admin.domain.dao;

import com.hyc.shop.admin.domain.dataobject.UserRegisterDO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegisterMapper {

    void insert(UserRegisterDO entity);

}