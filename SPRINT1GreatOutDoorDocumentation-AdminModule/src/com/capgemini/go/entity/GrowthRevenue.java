package com.capgemini.go.entity;

public class GrowthRevenue {
	private String monthyear;
	private int revenue;
	private int change;
	private int percentagegrowth;
	private String color;

	public String getMonthyear() {
		return monthyear;
	}

	public void setMonthyear(String monthyear) {
		this.monthyear = monthyear;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

	public int getPercentagegrowth() {
		return percentagegrowth;
	}

	public void setPercentagegrowth(int percentagegrowth) {
		this.percentagegrowth = percentagegrowth;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public GrowthRevenue(String monthyear, int revenue, int change, int percentagegrowth, String color) {
		super();
		this.monthyear = monthyear;
		this.revenue = revenue;
		this.change = change;
		this.percentagegrowth = percentagegrowth;
		this.color = color;
	}

	@Override
	public String toString() {
		return monthyear + "\t" + revenue + "\t" + change+ "\t" + percentagegrowth + "\t" + color;
	}

}
