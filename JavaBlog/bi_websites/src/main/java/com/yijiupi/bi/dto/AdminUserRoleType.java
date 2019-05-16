package com.yijiupi.bi.dto;

import java.util.EnumSet;
import java.util.Map;
import java.util.stream.Collectors;

public enum AdminUserRoleType {
	/**
	 * 可以登录运营平台，可以不属于某城市
	 */
	管理员("OPAdmin") {
		@Override
		public boolean isCanLoginOp() {
			return true;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	/**
	 * 可以不属于某城市，可以登录运营平台
	 */
	系统用户("OPUser") {
		@Override
		public boolean isCanLoginOp() {
			return true;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	/**
	 * 可以不属于某城市，不可以登录运营平台
	 */
	公司高层("ExecutiveOfficer") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	CEO("CEO") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	COO("COO") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	总部审核员("HeadPurchaseStaff") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	/**
	 * 暂不可以登录运营平台
	 */
	大区经理("RegionalManager") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.大区;
		}
	},
	/**
	 * 暂不可以登录运营平台
	 */
	大区采购经理("RegionalPurchaseManager") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.大区;
		}
	},
	/**
	 * 暂不可以登录运营平台
	 */
	大区采购专员("RegionalPurchaseStaff") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.大区;
		}
	},
	/**
	 * 暂不可以登录运营平台
	 */
	大区采购审核专员("RegionalPurchaseAndExamineStaff") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.大区;
		}
	},
	/**
	 * 可以登录运营平台，可以不属于某城市
	 */
	城市管理员("CityAdmin") {
		@Override
		public boolean isCanLoginOp() {
			return true;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.城市;
		}
	},
	/**
	 * 可以登录运营平台，可以不属于某城市
	 */
	加盟城市管理员("JoinCityAdmin") {
		@Override
		public boolean isCanLoginOp() {
			return true;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.城市;
		}
	},
	/**
	 * 必须有所属城市且授权城市与所属城市一致，可以登录运营平台，权限同 <b>城市管理员</b>
	 */
	城市经理("CityManager") {
		@Override
		public boolean isCanLoginOp() {
			return true;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.城市;
		}
	},
	/**
	 * 必须有所属城市且授权机构与所属城市一致，暂不可以登录运营平台
	 */
	省区总监("ProvinceGeneral") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.城市;
		}
	},
	/**
	 * 必须有所属城市且授权机构与所属城市一致，暂不可以登录运营平台
	 */
	采购经理("PurchasingManager") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.城市;
		}
	},
	/**
	 * 必须有所属城市且授权机构与所属城市一致，暂不可以登录运营平台
	 */
	经纪人("SaleUser") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.城市;
		}
	},
	/**
	 * 必须有所属城市且授权机构与所属城市一致，暂不可以登录运营平台
	 */
	配送员("DeliveryUser") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.城市;
		}
	},
	/**
	 * 必须有所属城市且授权机构与所属城市一致，暂不可以登录运营平台
	 */
	出纳人员("Cashier") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.城市;
		}
	},
	/**
	 * 必须有所属城市且授权机构与所属城市一致，暂不可以登录运营平台
	 */
	仓库管理员("StoreAdmin") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.仓库;
		}
	},
	/**
	 * 必须有所属城市且授权机构与所属城市一致，暂不可以登录运营平台
	 */
	装卸人员("Stevedore") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.仓库;
		}
	},
	/**
	 * 必须有所属城市且授权机构与所属城市一致，暂不可以登录运营平台
	 */
	拣货员("OrderPicker") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.仓库;
		}
	},
	/**
	 * 必须有所属城市且授权机构与所属城市一致，暂不可以登录运营平台
	 */
	盘存人员("Inventory") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.仓库;
		}
	},
	/**
	 * 可以登录运营平台，可以不属于某城市，权限同<b>系统管理员</b>
	 */
	研发人员("Developer") {
		@Override
		public boolean isCanLoginOp() {
			return true;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	会计人员("Accountant") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.城市;
		}
	},
	总部HR("HR") {
		@Override
		public boolean isCanLoginOp() {
			return true;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	大商经纪人("PartnerSaleUser") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.城市;
		}
	},
	投资人("InvestorAdmin") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	调拨系统管理员("AllocateUser") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	城市调拨人员("CityAllocateUser") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.城市;
		}
	},
	总部财务("HQFinance") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	调拨发货人员("AllocateConsignor") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.仓库;
		}
	},
	/**
	 * 该角色只对经营内参模块有管理权限， 该角色可以查看产品信息和产品SKU列表，但是不能进行任何操作。
	 */
	市场部人员("MarketingUser") {
		@Override
		public boolean isCanLoginOp() {
			return true;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	/**
	 * 该角色不能登录运营平台 属于仓库这个级别的。 人员必须要先有城市，然后才能设置仓库下的这个角色
	 */
	物流队长("LogisticsLeader") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.仓库;
		}
	},
	/**
	 * 该角色不能登录运营平台 属于总部级别
	 */
	易久批零管理员("RetailOPAdmin") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	/**
	 * 该角色不能登录运营平台 属于总部级别;如果是易酒批零的人员，可以设置如下2个角色：【易久批零店主】和【易久批零配送员】
	 */
	易久批零店主("RetailShopkeeper") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	/**
	 * 该角色不能登录运营平台 属于总部级别;只有是易酒批零的人员，可以设置如下2个角色：【易久批零店主】和【易久批零配送员】
	 */
	易久批零配送员("RetailDeliveryUser") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	总部运营("OPStaff") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	},
	城市仓配经理("CityDistributionManager") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.城市;
		}
	},共享仓配管理员("ShareDistributionManager") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.城市;
		}
	},
	NULL("Null") {
		@Override
		public boolean isCanLoginOp() {
			return false;
		}

		@Override
		public OrgType getOrgType() {
			return OrgType.总部;
		}
	};
	private static Map<String, AdminUserRoleType> cache = EnumSet.allOf(AdminUserRoleType.class).stream().collect(Collectors.toMap(p -> p.role, p -> p));
	/**
	 * 枚举值
	 */
	public String role;

	AdminUserRoleType(String role) {
		this.role = role;
	}

	public static AdminUserRoleType getAdminUserRoleType(String type) {
		AdminUserRoleType adminUserRoleType = null;
		if (type != null) {
			adminUserRoleType = cache.get(type);
		}
		return adminUserRoleType == null ? AdminUserRoleType.NULL : adminUserRoleType;
	}

	/**
	 * 是否可以登录运营平台
	 * @return true为可以登录
	 */
	public abstract boolean isCanLoginOp();

	/**
	 * 获取组织机构
	 * @return OrgType
	 */
	public abstract OrgType getOrgType();
}
