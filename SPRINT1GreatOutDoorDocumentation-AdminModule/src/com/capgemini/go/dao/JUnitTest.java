package com.capgemini.go.dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import com.capgemini.go.entity.GrowthRevenue;
import com.capgemini.go.entity.RevenueReport;

import junit.framework.Assert;

public class JUnitTest {
    DaoClass dao =new DaoClass();
   @Test
  public void getPrice() throws Exception
  {
  ArrayList al=dao.viewSalesReportByCategoryAndUser("01-dec-2017","01-dec-2018","Siri6669","electronics");
  int expectedrevenue =0,actualRevenue=0;
  Iterator<RevenueReport> it = al.iterator();
	if(it.hasNext()) {
		do{
        RevenueReport a=it.next();
        actualRevenue+=a.getPrice();
		}while(it.hasNext());
	}
  Assert.assertEquals(expectedrevenue,actualRevenue);
  }
   @Test
   public void getPrices() throws Exception
   {
   ArrayList al=dao.viewSalesReportByCategoryAndUser("01-dec-2019","01-dec-2019","Siri6669","electronics");
   int expectedrevenue =10000,actualRevenue=0;
   Iterator<RevenueReport> it = al.iterator();
 	if(it.hasNext()) {
 		do{
         RevenueReport a=it.next();
         actualRevenue+=a.getPrice();
 		}while(it.hasNext());
 	}
   Assert.assertNotSame(expectedrevenue,actualRevenue);
   }
   @Test
   public void getTransactions() throws Exception
   {
   ArrayList al=dao.viewSalesReportByCategoryAndUser("01-jan-2018","01-jan-2020","manikanth6669","electronics");
   int expectedTransctions=4,actualTransctions=0;
   Iterator<RevenueReport> it = al.iterator();
 	if(it.hasNext()) {
 		do{
         RevenueReport a=it.next();
         actualTransctions++;
 		}while(it.hasNext());
 	}
   Assert.assertEquals(expectedTransctions,actualTransctions);
   }
    @Test
    public void getTotalJanSales() throws Exception {

    	ArrayList al=dao.viewDetailedSalesReportByProduct("01-jan-2019","31-jan-2019","electronics");
    	int expectedRevenue = 20000,actualRevenue=0;
    	Iterator<GrowthRevenue> it = al.iterator();
    	if(it.hasNext())
    	{GrowthRevenue g=it.next();
    	actualRevenue=g.getRevenue();
    	}
        Assert.assertEquals(expectedRevenue,actualRevenue);
    }
    
    @Test
    public void getDecSales() throws Exception {
    	ArrayList al=dao.viewDetailedSalesReportByProduct("01-dec-2019","29-dec-2019","electronics");
    	int expectedRevenue =30000,actualRevenue=0;
    	Iterator<GrowthRevenue> it = al.iterator();
    	if(it.hasNext())
    	{GrowthRevenue g=it.next();
    	actualRevenue=g.getRevenue();
    	}
        Assert.assertNotSame(expectedRevenue,actualRevenue);
    }
    
}
