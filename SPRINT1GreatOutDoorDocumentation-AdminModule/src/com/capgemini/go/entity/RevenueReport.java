package com.capgemini.go.entity;

public class RevenueReport {
private String userid;
private String odate;
private int orderid;
private int productid;
private String category;
private int price;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getOdate() {
	return odate;
}
public void setOdate(String odate) {
	this.odate = odate;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public RevenueReport(String userid, String odate, int orderid, int productid, String category, int price) {
	super();
	this.userid = userid;
	this.odate = odate;
	this.orderid = orderid;
	this.productid = productid;
	this.category = category;
	this.price = price;
}
@Override
public String toString() {
	return "\n"+userid +"\t"+odate+"\t"+orderid+"\t"+productid+"\t"+category+"\t"+price;
}

}
