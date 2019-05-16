package com.yijiupi.bi.dto;
/*********************************************
 * ClassName: OrgType Description: 组织机构类型
 * @author penglei Date 2016年2月15日
 *********************************************/
public enum OrgType {
	总部(1), 城市(2), 仓库(3), 大区(4), 易久批零店铺(5);
	public Integer type;

	OrgType(Integer type) {
		this.type = type;
	}

	public static OrgType getOrgType(Integer type) {
		if (type != null) {
			switch (type) {
				case 1:
					return OrgType.总部;
				case 2:
					return OrgType.城市;
				case 4:
					return OrgType.仓库;
				case 5:
					return OrgType.易久批零店铺;
				default:
					return OrgType.总部;
			}
		}
		return OrgType.总部;
	}

	@Override
	public String toString() {
		return this.type.toString();
	}
}
