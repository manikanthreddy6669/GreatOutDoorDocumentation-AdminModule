package com.capgemini.go.pl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.capgemini.go.entity.GrowthRevenue;
import com.capgemini.go.entity.RevenueReport;
import com.capgemini.go.service.ServiceClass;

public class MainUI {
	static ServiceClass ss = new ServiceClass();

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		String opt;
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("\n1.View revenue reports");
			System.out.println("2.View growth reports");
			opt = s.next();

			switch (opt) {

			case "1":
				System.out.println("enter entry date(dd-mmm-yy)");
				String entry = s.next();
				while (!ss.dateValidate(entry)) {
					System.out.println("enter valid entry date(dd-mmm-yy)");
					entry = s.next();
				}
				System.out.println("enter exit date(dd-mmm-yy)");
				String exit = s.next();
				while (!ss.dateValidate(exit)) {
					System.out.println("enter valid exit date(dd-mmm-yy)");
					exit = s.next();
				}
				//COMPARING DATES
				while (ss.dateCompare(entry, exit)) {
					System.out.println("enter valid entry date(dd-mmm-yy)");
					entry = s.next();
					while (!ss.dateValidate(entry)) {
						System.out.println("enter valid entry date(dd-mmm-yy)");
						entry = s.next();
					}
					System.out.println("enter exit date(dd-mmm-yy)");
					exit = s.next();
					while (!ss.dateValidate(exit)) {
						System.out.println("enter valid exit date(dd-mmm-yy)");
						exit = s.next();
					}
				}
				System.out.println("enter user_id");
				String targetUserId = s.next();
				System.out.println("enter category");
				String category = s.next();
				ArrayList<RevenueReport> al = ss.viewSalesReportByCategoryAndUser(entry, exit, targetUserId, category);
				Iterator<RevenueReport> it = al.iterator();
				if(it.hasNext()) {
					System.out.println("UserID\t\tDate\t\tOrderId\tProductID\tCategory\tPrice");
					do{
                      RevenueReport a=it.next();
                      System.out.println(a);
					}while(it.hasNext());
				} else
					System.out.println("No Records found");
				break;
			case "2":
				System.out.println("enter entry date(dd-mmm-yy)");
				 entry = s.next();
				while (!ss.dateValidate(entry)) {
					System.out.println("enter valid entry date(dd-mmm-yy)");
					entry = s.next();
				}
				System.out.println("enter exit date(dd-mmm-yy)");
				 exit = s.next();
				while (!ss.dateValidate(exit)) {
					System.out.println("enter valid exit date(dd-mmm-yy)");
					exit = s.next();
				}
				//COMPARING DATES
				while (ss.dateCompare(entry, exit)) {
					System.out.println("enter valid entry date(dd-mmm-yy)");
					entry = s.next();
					while (!ss.dateValidate(entry)) {
						System.out.println("enter valid entry date(dd-mmm-yy)");
						entry = s.next();
					}
					System.out.println("enter exit date(dd-mmm-yy)");
					exit = s.next();
					while (!ss.dateValidate(exit)) {
						System.out.println("enter valid exit date(dd-mmm-yy)");
						exit = s.next();
					}
				}
				System.out.println("enter category");
				category = s.next();
				ArrayList<GrowthRevenue> al2 = ss.viewDetailedSalesReportByProduct(entry, exit, category);
				Iterator<GrowthRevenue> it1 = al2.iterator();
				if(it1.hasNext()) {
					System.out.println("Month Year\tRevenue\tAmountChange\tPercentageGrowth\tColor");
					do{
                      GrowthRevenue a1=it1.next();
                      System.out.println(a1);
					}while(it1.hasNext());
				} 
				else
					System.out.println("No Records found");
				break;
			default:
				System.out.println("not a valid option");
			}
		}
	}
}