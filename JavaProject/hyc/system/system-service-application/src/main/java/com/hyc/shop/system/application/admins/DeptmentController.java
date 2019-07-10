package com.hyc.shop.system.application.admins;

import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.common.vo.PageResult;
import com.hyc.shop.system.application.convert.DeptmentConvert;
import com.hyc.shop.system.application.vo.deptment.DeptmentVO;
import com.hyc.shop.system.bo.deptment.DeptmentBO;
import com.hyc.shop.system.constant.ResourceConstants;
import com.hyc.shop.system.dto.depetment.DeptmentAddDTO;
import com.hyc.shop.system.dto.depetment.DeptmentPageDTO;
import com.hyc.shop.system.dto.depetment.DeptmentUpdateDTO;
import com.hyc.shop.system.sdk.context.AdminSecurityContextHolder;
import com.hyc.shop.system.service.DeptmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.hyc.shop.common.vo.CommonResult.success;

/**
 * Description:
 *
 * @author: zhenxianyimeng
 * @date: 2019-06-14
 * @time: 19:07
 */
@RestController
@RequestMapping("admins/dept")
@Api("部门模块")
public class DeptmentController {

    @Autowired
    private DeptmentService deptmentService;

    @GetMapping("tree/page")
    @ApiOperation(value = "根部门分页的部门树")
    public CommonResult<PageResult<DeptmentVO>> treePage(DeptmentPageDTO deptmentPageDTO){
        PageResult<DeptmentBO> pageResult = deptmentService.getPageRootDeptment(deptmentPageDTO);
        PageResult<DeptmentVO> voPageResult = DeptmentConvert.INSTANCE.convert(pageResult);
        List<DeptmentBO> list = deptmentService.getAllDeptments();
        List<DeptmentVO> voList = DeptmentConvert.INSTANCE.convert(list);
        Map<Integer, DeptmentVO> nodeMap = voList.stream().collect(Collectors.toMap(e->e.getId(), e->e));

        nodeMap.values().stream()
                .filter(node -> !node.getPid().equals(ResourceConstants.PID_ROOT))
                .forEach((childNode) -> {
                    // 获得父节点
                    DeptmentVO parentNode = nodeMap.get(childNode.getPid());
                    if (parentNode.getChildren() == null) { // 初始化 children 数组
                        parentNode.setChildren(new ArrayList<>());
                    }
                    // 将自己添加到父节点中
                    parentNode.getChildren().add(childNode);
                });

        voPageResult.getList().forEach(d->{
            d.setChildren(nodeMap.get(d.getId()).getChildren());
        });
        return success(voPageResult);
    }

    @PostMapping("add")
    @ApiOperation(value = "新增部门", notes = "选择部门名称，父级部门")
    public CommonResult<DeptmentBO> add(@RequestBody DeptmentAddDTO deptmentAddDTO){
        return success(deptmentService.addDeptment(
                AdminSecurityContextHolder.getContext().getAdminId(), deptmentAddDTO));

    }

    @PostMapping("delete")
    @ApiOperation(value = "删除部门")
    @ApiImplicitParam(name = "id", value = "部门id", required = true, example = "1")
    public CommonResult<Boolean> delete(@RequestParam("id") Integer id){

        return success(deptmentService.deleteDeptment(
                AdminSecurityContextHolder.getContext().getAdminId(), id
        ));
    }

    @PostMapping("update")
    @ApiOperation(value = "更新部门")
    public CommonResult<Boolean> update(@RequestBody DeptmentUpdateDTO deptmentUpdateDTO){
        return success(deptmentService.updateDeptment(
                AdminSecurityContextHolder.getContext().getAdminId(), deptmentUpdateDTO
        ));
    }


}
