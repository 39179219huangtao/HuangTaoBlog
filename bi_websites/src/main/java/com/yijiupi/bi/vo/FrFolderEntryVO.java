package com.yijiupi.bi.vo;

import com.yijiupi.bi.entity.FrFolderentry;
import com.yijiupi.bi.entity.FrReportletentry;
import com.yijiupi.bi.entity.FrRppe;
import com.yijiupi.bi.entity.FrUrlentry;

import java.util.List;

/**
 * @Decription:
 * @Author: Huang Yuansheng
 * @Date: Create in 16:03 2018/7/27 0027
 * @Email: huangyuansheng@yijiupi.cn
 **/
public class FrFolderEntryVO extends FrFolderentry {
	
	private static final long serialVersionUID = 6561178333207974395L;
	
	private List<FrReportletentry> reportletentries;
	
	private List<FrRppe> rppes;
	
	private List<FrUrlentry> urlentries;
	
	private FrFolderEntryVO childFolder;
	
	public FrFolderEntryVO getChildFolder() {
		return childFolder;
	}
	
	public void setChildFolder(FrFolderEntryVO childFolder) {
		this.childFolder = childFolder;
	}
	
	public List<FrReportletentry> getReportletentries() {
		return reportletentries;
	}
	
	public void setReportletentries(List<FrReportletentry> reportletentries) {
		this.reportletentries = reportletentries;
	}
	
	public List<FrRppe> getRppes() {
		return rppes;
	}
	
	public void setRppes(List<FrRppe> rppes) {
		this.rppes = rppes;
	}
	
	public List<FrUrlentry> getUrlentries() {
		return urlentries;
	}
	
	public void setUrlentries(List<FrUrlentry> urlentries) {
		this.urlentries = urlentries;
	}
	
	@Override
	public String toString() {
		return "FrFolderEntryVO{" +
				"reportletentries=" + reportletentries +
				", rppes=" + rppes +
				", urlentries=" + urlentries +
				", childFolder=" + childFolder +
				'}';
	}
}
