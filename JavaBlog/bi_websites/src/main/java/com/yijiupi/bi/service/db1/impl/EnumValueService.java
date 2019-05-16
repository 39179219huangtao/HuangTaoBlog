//package com.yijiupi.bi.service.db1.impl;
//
//import com.yijiupi.bi.dto.EnumValueDTO;
//import com.yijiupi.bi.entity.EnumCategoryPO;
//import com.yijiupi.bi.entity.EnumValuePO;
//import com.yijiupi.bi.entity.FrCompanyrole;
//import com.yijiupi.bi.kit.easyui.EasyUiPage;
//import com.yijiupi.bi.mapper.EnumValuePOMapper;
//import com.yijiupi.bi.service.db1.IEnumValueService;
//import org.springframework.stereotype.Service;
//
//
///**
// * @author huangtao
// * @Title: himalaya-bi-microservice-orgsettings
// * @Package com.yijiupi.himalaya.bi.orgsettings.service.impl
// * @Description:
// * @date 2018/7/5  16:54
// */
//@Service
//public class EnumValueService extends BaseServiceImpl<EnumValuePOMapper, EnumValuePO> implements IEnumValueService {
//
//
//    @Override
//    public EasyUiPage<EnumValuePO> findEnumValueList(EasyUiPage<EnumValuePO> pageInfo, EnumValuePO enumValuePO, String... attrs) {
//        return pageByDynamicEqual(pageInfo, enumValuePO, attrs);
//    }
//
//    @Override
//    public int insertSelective(EnumValuePO enumValuePO) {
//
//
//        return baseMapper.insertSelective(enumValuePO);
//    }
//
//    @Override
//    public int update(EnumValuePO enumValuePO) {
//        return baseMapper.updateById(enumValuePO);
//    }
//
//    @Override
//    public EnumValuePO selectByPrimaryKey(Integer id) {
//        return baseMapper.selectById(id);
//    }
//
//    @Override
//    public int deleteByPrimaryKey(Integer id) {
//        return baseMapper.deleteById(id);
//    }
//}
