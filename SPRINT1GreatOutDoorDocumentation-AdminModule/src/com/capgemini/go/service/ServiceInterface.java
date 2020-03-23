package com.capgemini.go.service;

import java.util.ArrayList;

import com.capgemini.go.entity.GrowthRevenue;
import com.capgemini.go.entity.RevenueReport;

public interface ServiceInterface {
	public ArrayList<RevenueReport> viewSalesReportByCategoryAndUser(String entry, String exit, String targetUserId, String category);
	public ArrayList<GrowthRevenue> viewDetailedSalesReportByProduct(String date1, String date2, String category) throws Exception;
	public boolean dateValidate(String date1);
	public boolean dateCompare(String date1, String date2);
	
}
