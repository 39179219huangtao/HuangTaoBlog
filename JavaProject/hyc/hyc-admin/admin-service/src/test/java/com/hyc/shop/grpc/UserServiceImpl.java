//package com.hyc.shop.grpc;
//
//import com.anoyi.grpc.facade.entity.UserEntity;
//
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import org.springframework.stereotype.Service;
///**
// * @program hyc
// * @description:
// * @author: huangtao
// * @create: 2019/06/26 09:21
// */
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    /**
//     * 模拟数据库存储用户信息
//     */
//    private Map<Long, UserEntity> userMap = new ConcurrentHashMap<>();
//
//    @Override
//    public void insert(UserEntity userEntity) {
//        if (userEntity == null) {
//            System.out.println("insert user fail, userEntity is null!");
//            return;
//        }
//        userMap.putIfAbsent(userEntity.getId(), userEntity);
//    }
//
//    @Override
//    public void deleteById(final Long id) {
//
//    }
//
//    @Override
//    public void update(final UserEntity userEntity) {
//
//    }
//
//    @Override
//    public UserEntity findById(final Long id) {
//        return null;
//    }
//
//    @Override
//    public List<UserEntity> findAll() {
//        return null;
//    }
//
//}