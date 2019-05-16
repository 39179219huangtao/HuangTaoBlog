//package com.yijiupi.bi.web;
//
//import com.baomidou.mybatisplus.toolkit.StringUtils;
//import com.yijiupi.bi.dto.EnumCategoryDTO;
//import com.yijiupi.bi.dto.EnumValueDTO;
//import com.yijiupi.bi.entity.EnumCategoryPO;
//import com.yijiupi.bi.entity.EnumValuePO;
//import com.yijiupi.bi.entity.FrUser;
//import com.yijiupi.bi.kit.easyui.EasyUiPage;
//import com.yijiupi.bi.service.db1.IEnumCategoryService;
//import com.yijiupi.bi.service.db1.IEnumValueService;
//import com.yijiupi.bi.utils.BaseResult;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * @author huangtao
// * @Title: himalaya-bi-websites-op
// * @Package com.yijiupi.himalaya.op.controller.enumcategory
// * @Description:
// * @date 2018/7/5  17:03
// */
//@Controller
//@RequestMapping("/enumCategory")
//public class EnumCategoryController {
//    @Autowired
//    IEnumCategoryService enumCategoryService;
//
//    @Autowired
//    IEnumValueService enumValueService;
//
//    @ResponseBody
//    @RequestMapping(value = "getEnumCategoryList", method = RequestMethod.POST)
//    public EasyUiPage<EnumCategoryPO> findEnumCategoryList(EasyUiPage<EnumCategoryPO> pageInfo, EnumCategoryPO enumCategoryPO) {
//        return enumCategoryService.findEnumCategoryList(pageInfo, enumCategoryPO, "categoryName");
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "selectEnumCategoryByPrimaryKey")
//    public EnumCategoryPO selectEnumCategoryByPrimaryKey(@RequestParam Integer id) {
//        return enumCategoryService.selectByPrimaryKey(id);
//    }
//
//    @RequestMapping(value = "updateEnumCategory", method = RequestMethod.POST, consumes = "application/json")
//    @ResponseBody
//    public BaseResult update(@RequestBody EnumCategoryPO enumCategoryPO) {
//        enumCategoryService.update(enumCategoryPO);
//        return BaseResult.getSuccessResult();
//    }
//
//    @RequestMapping(value = "insertEnumCategory", method = RequestMethod.POST, consumes = "application/json")
//    @ResponseBody
//    public BaseResult insert(@RequestBody EnumCategoryPO enumCategoryPO) {
//        int i = enumCategoryService.insertSelective(enumCategoryPO);
//        return BaseResult.getSuccessResult();
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "getAllEnumCategory")
//    public List<EnumCategoryPO> getAllEnumCategory() {
//        EasyUiPage<EnumCategoryPO> pageInfo = new EasyUiPage<>();
//        pageInfo.setPage(1);
//        pageInfo.setRows(100000000);
//
//        EnumCategoryPO enumCategoryPO = new EnumCategoryPO();
//
//        EasyUiPage<EnumCategoryPO> enumCategoryList = enumCategoryService.findEnumCategoryList(pageInfo, enumCategoryPO);
//        return enumCategoryList.getRecords();
//    }
//
//
//    @ResponseBody
//    @RequestMapping(value = "getEnumValueList", method = RequestMethod.POST)
//    public EasyUiPage<EnumValuePO> findEnumValueList(EasyUiPage<EnumValuePO> pageInfo, EnumValuePO enumValuePO) {
//        return enumValueService.findEnumValueList(pageInfo, enumValuePO, "categoryID","enumText");
//    }
//
//
//    @ResponseBody
//    @RequestMapping(value = "selectEnumValueByPrimaryKey")
//    public EnumValuePO selectEnumValueByPrimaryKey(@RequestParam Integer id) {
//        return enumValueService.selectByPrimaryKey(id);
//    }
//
//    @RequestMapping(value = "updateEnumValue", method = RequestMethod.POST, consumes = "application/json")
//    @ResponseBody
//    public BaseResult updateEnumValue(@RequestBody EnumValuePO enumValuePO) {
//        enumValueService.update(enumValuePO);
//        return BaseResult.getSuccessResult();
//    }
//
//    @RequestMapping(value = "insertEnumValue", method = RequestMethod.POST, consumes = "application/json")
//    @ResponseBody
//    public BaseResult insertEnumValue(@RequestBody EnumValuePO enumValuePO) {
//        int i = enumValueService.insertSelective(enumValuePO);
//        return BaseResult.getSuccessResult();
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "deleteEnumValue")
//    public BaseResult deleteEnumValue(@RequestParam Integer id) {
//        enumValueService.deleteByPrimaryKey(id);
//        return BaseResult.getSuccessResult();
//    }
//
//}
