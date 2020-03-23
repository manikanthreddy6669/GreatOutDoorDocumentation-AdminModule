package com.capgemini.go.dao;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.capgemini.go.entity.GrowthRevenue;
import com.capgemini.go.entity.RevenueReport;

public class DaoClass implements DaoInterface {
	ArrayList<RevenueReport> a = new ArrayList<RevenueReport>();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

	public DaoClass() {
		RevenueReport r1 = new RevenueReport("manikanth6669", "29-DEC-2019", 1, 1000, "electronics", 10000);
		a.add(r1);
		RevenueReport r2 = new RevenueReport("Siri6669", "11-DEC-2019", 1, 1000, "electronics", 10000);
		a.add(r2);
		RevenueReport r3 = new RevenueReport("Siri6669", "10-JAN-2019", 1, 1000, "electronics", 10000);
		a.add(r3);
		RevenueReport r4 = new RevenueReport("Siri6669", "28-FEB-2019", 1, 1000, "electronics", 10000);
		a.add(r4);
		RevenueReport r5 = new RevenueReport("manikanth9999", "29-MAR-2019", 1, 1000, "electronics", 10000);
		a.add(r5);
		RevenueReport r6 = new RevenueReport("nani9", "29-JAN-2019", 1, 1000, "electronics", 10000);
		a.add(r6);
		RevenueReport r7 = new RevenueReport("manikanth6669", "29-NOV-2019", 1, 1000, "electronics", 10000);
		a.add(r7);
		RevenueReport r8 = new RevenueReport("nani9", "29-JUN-2019", 1, 1000, "electronics", 10000);
		a.add(r8);
		RevenueReport r9 = new RevenueReport("manikanth6669", "29-SEP-2019", 1, 1000, "electronics", 10000);
		a.add(r9);
		RevenueReport r10 = new RevenueReport("manikanth6669", "29-MAR-2019", 1, 1000, "electronics", 10000);
		a.add(r10);

	}

	// VIEW SALES REPORT BY USER AND CATEGORY IN SPECIFIED PERIOD
	public ArrayList<RevenueReport> viewSalesReportByCategoryAndUser(String entry, String exit, String targetUserId, String category)
			throws Exception {
		// TODO Auto-generated method stub
		Date entrydate = formatter.parse(entry);
		Date exitdate = formatter.parse(exit);
		ArrayList<RevenueReport> al = new ArrayList<RevenueReport>();
		for (RevenueReport s : a) {
			Date orderdate = formatter.parse(s.getOdate());
			if (s.getUserid().equals(targetUserId) && s.getCategory().equals(category) && orderdate.after(entrydate)
					&& orderdate.before(exitdate)) {
				al.add(s);
			}
		}
		return al;

	}

	// VIEW GROWTH REPORT BY CATEGORY IN SPECIFIED PERIOD
	public ArrayList<GrowthRevenue> viewDetailedSalesReportByProduct(String entry, String exit, String category) throws Exception {
		// TODO Auto-generated method stub
		int month;
		int year;
		int revenue, prev = 0;
		String monthyear, monthyear1, colorcode;
		ArrayList<RevenueReport> al1 = new ArrayList<RevenueReport>();

		Date entrydate = formatter.parse(entry);
		Date exitdate = formatter.parse(exit);
		for (RevenueReport s : a) {
			Date orderdate = formatter.parse(s.getOdate());
			if (s.getCategory().equals(category) && orderdate.after(entrydate) && orderdate.before(exitdate)) {
				al1.add(s);
			}
		}
		// Storing monthyear,totalrevenue in treemap
		int total = 0;
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		for (int i = 0; i < al1.size(); i++) {
			total = al1.get(i).getPrice();
			Date date1 = formatter.parse(al1.get(i).getOdate());
			for (int j = i + 1; j < al1.size(); j++) {
				Date date2 = formatter.parse(al1.get(j).getOdate());
				if (date1.getMonth() == date2.getMonth() && date1.getYear() == date2.getYear()) {
					total = al1.get(i).getPrice() + al1.get(j).getPrice();
					al1.remove(j);
				}
			}
			tm.put(Integer.parseInt(date1.getMonth() + "" + (date1.getYear() + 1900)), total);// jan2019
		}
		
		Set<Entry<Integer, Integer>> set = tm.entrySet();
		Iterator it = set.iterator();
		ArrayList<GrowthRevenue> al2 = new ArrayList<GrowthRevenue>();

		while (it.hasNext()) {
			Map.Entry m = (Map.Entry) it.next();
			monthyear = Integer.toString((int) m.getKey());
			revenue = (int) m.getValue();
			if (monthyear.length() == 6) {
				month = Integer.parseInt(monthyear.substring(0, 2));
				year = Integer.parseInt(monthyear.substring(2, 6));
			} else if (monthyear.length() == 5) {
				month = Integer.parseInt(monthyear.substring(0, 1));
				year = Integer.parseInt(monthyear.substring(2, 5));
			} else {
				month = 0;
				year = Integer.parseInt(monthyear);
			}
			monthyear1 = new DateFormatSymbols().getMonths()[month] + " " + year;
			int amountchange = revenue - prev;
			int percentagegrowth = (amountchange* 100) / revenue;
			if (percentagegrowth > 10)
				colorcode = "green";
			else if (percentagegrowth > 2 && percentagegrowth < 10)
				colorcode = "blue";
			else
				colorcode = "red";
			al2.add(new GrowthRevenue(monthyear1, revenue, amountchange, percentagegrowth, colorcode));
			prev = revenue;
		}
		return al2;
	}
}