package org.springrain.erp.tc.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springrain.erp.tc.entity.TongchouRecord;
import org.springrain.erp.tc.entity.TongchouShow;

public class DkdjRecordDto {
	private String username;//用户名
	private String userId;//用户编号
	private List<TongchouRecord> stats;//保险信息
	private List<TongchouShow> showList = new ArrayList<TongchouShow>();//页面用于显示一行里所有统筹显示信息
	private Date month ;//月份
	private String totalcount;//合计
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<TongchouRecord> getStats() {
		return stats;
	}
	public void setStats(List<TongchouRecord> stats) {
		this.stats = stats;
	}
	public List<TongchouShow> getShowList() {
		return showList;
	}
	public void setShowList(List<TongchouShow> showList) {
		this.showList = showList;
	}
	public Date getMonth() {
		return month;
	}
	public void setMonth(Date month) {
		this.month = month;
	}
	public String getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(String totalcount) {
		this.totalcount = totalcount;
	}
	
	
}
