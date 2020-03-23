package com.capgemini.go.dao;

import java.util.ArrayList;

import com.capgemini.go.entity.GrowthRevenue;
import com.capgemini.go.entity.RevenueReport;

public interface DaoInterface {
	public ArrayList<RevenueReport> viewSalesReportByCategoryAndUser(String entry, String exit, String targetUserId, String category)throws Exception;
	public ArrayList<GrowthRevenue> viewDetailedSalesReportByProduct(String entry,String exit,String category) throws Exception;

}
