package com.pen.entities;

import java.time.LocalDate;

public class Pen_Entities {

	private int pen_id;
	private BRAND brand;
	private String color;
	private String inkColor;
	private MATERIAL material;
	private int stock;
	private LocalDate stockUpdateDate;
	private LocalDate stockListingDate;
	private double price;
	private int discount;
	
	private static int counter = 1;
	
	public Pen_Entities(BRAND brand, String color, String inkColor, MATERIAL material, int stock,
			LocalDate stockUpdateDate, LocalDate stockListingDate, double price, int discount) {
		super();
		this.pen_id = counter++;
		this.brand = brand;
		this.color = color;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = stock;
		this.stockUpdateDate = stockUpdateDate;
		this.stockListingDate = stockListingDate;
		this.price = price;
		this.discount = discount;
	}


	public Pen_Entities(int pen_id) {
		super();
		this.pen_id = pen_id;
	}

	public int getPen_id() {
		return pen_id;
	}


		public BRAND getBrand() {
		return brand;
	}


	public void setBrand(BRAND brand) {
		this.brand = brand;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getInkColor() {
		return inkColor;
	}


	public void setInkColor(String inkColor) {
		this.inkColor = inkColor;
	}


	public MATERIAL getMaterial() {
		return material;
	}


	public void setMaterial(MATERIAL material) {
		this.material = material;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public LocalDate getStockUpdateDate() {
		return stockUpdateDate;
	}


	public void setStockUpdateDate(LocalDate stockUpdateDate) {
		this.stockUpdateDate = stockUpdateDate;
	}


	public LocalDate getStockListingDate() {
		return stockListingDate;
	}


	public void setStockListingDate(LocalDate stockListingDate) {
		this.stockListingDate = stockListingDate;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
}
