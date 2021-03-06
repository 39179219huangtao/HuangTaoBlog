package com.hyc.shop.system.application.vo.deptment;

import com.hyc.shop.system.bo.deptment.DeptmentBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author: zhenxianyimeng
 * @date: 2019-06-15
 * @time: 16:57
 */
@Data
@ApiModel("部门VO")
public class DeptmentVO extends DeptmentBO {
    @ApiModelProperty("子部门数组")
    private List<DeptmentVO> children;
}
