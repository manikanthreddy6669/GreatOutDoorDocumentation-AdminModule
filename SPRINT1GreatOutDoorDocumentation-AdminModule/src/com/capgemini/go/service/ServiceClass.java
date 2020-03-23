package com.capgemini.go.service;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.capgemini.go.dao.DaoClass;
import com.capgemini.go.entity.GrowthRevenue;
import com.capgemini.go.entity.RevenueReport;

public class ServiceClass {
	DaoClass dao = new DaoClass();

	public ArrayList<RevenueReport> viewSalesReportByCategoryAndUser(String entry, String exit, String targetUserId, String category)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.viewSalesReportByCategoryAndUser(entry, exit, targetUserId, category);
	}

	public ArrayList<GrowthRevenue> viewDetailedSalesReportByProduct(String date1, String date2, String category) throws Exception {
		return dao.viewDetailedSalesReportByProduct(date1, date2, category);
	}

//VALIDATING DATES
	public boolean dateValidate(String date1) {
		int count1 = 0, count2 = 0, count3 = 0;
		boolean b = false;
		if (date1.contains("-") && (!(date1.indexOf("-") == date1.lastIndexOf("-")))) {
			String sub1 = date1.substring(date1.indexOf('-') + 1, date1.lastIndexOf('-'));// GETTING MONTH FROM STRING
			int len = date1.substring(0, date1.indexOf("-")).length();
			String month;

			// VALIDATING DATE
			if (len > 0 && len < 3) {
				if ((date1.charAt(0) >= '0' && date1.charAt(0) <='9')
						&& (date1.charAt(1) >='0' && date1.charAt(1) <='9')) {
					int d = Integer.parseInt(date1.substring(0, date1.indexOf("-")));
					if (d > 0 && d < 31) {
						count1 = 1;
					}
				}
			}
			// VALIDATING MONTH
			for (int i = 1; i <= 12; i++) {
				month = new DateFormatSymbols().getMonths()[i - 1];
				if (month.substring(0, 3).equalsIgnoreCase(sub1)) {
					count2 = 1;

				}
			}
			//validating year
			int yearlength=date1.substring(date1.lastIndexOf("-") + 1, date1.length()).length();
			int datelength=date1.length();
			if(yearlength==4 && (date1.charAt(datelength-4)>'0' && date1.charAt(datelength-4)<='9') &&
					(date1.charAt(datelength-3)>='0' && date1.charAt(datelength-3)<='9') && (date1.charAt(datelength-2)>='0' && date1.charAt(datelength-2)<='9')
					&& (date1.charAt(datelength-1)>='0' && date1.charAt(datelength-1)<='9')){
				count3 = 1;

			}

		} else
			System.out.println("Invalid date format");
		// System.out.println(count1+" "+count2+" "+count3);
		if (count1 == 1 && count2 == 1 && count3 == 1) {
			b = true;
		}
		return b;
	}

//CHECKING WHETHER ENTRY DATE IS GREATER THAN EXIT DATE
	public boolean dateCompare(String date1, String date2) {
		boolean b = false;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			Date entrydate = formatter.parse(date1);
			Date exitdate = formatter.parse(date2);

			if (entrydate.after(exitdate)) {
				b = true;
				System.out.println("Entry date should not be greater than exit date");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return b;
	}
}
