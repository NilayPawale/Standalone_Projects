package com.pen.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import com.pen.entities.BRAND;
import com.pen.entities.MATERIAL;
import com.pen.entities.Pen_Entities;
import com.pen.exception.Pen_Exception;

public class Pen_Utils {

	//Populated List for Data Testing
	public static ArrayList<Pen_Entities> populatedPenList()
	{
		Pen_Entities p1 = new Pen_Entities(BRAND.CELLO, "Blue", "Black", MATERIAL.PLASTIC, 55, LocalDate.parse("2002-03-06"), LocalDate.parse("2003-03-06"), 100, 20);
		Pen_Entities p2 = new Pen_Entities(BRAND.REYNOLDS, "Blue", "Black", MATERIAL.ALLOY_STEEL, 55, LocalDate.parse("2002-03-06"), LocalDate.parse("2003-09-08"), 100, 20);
		Pen_Entities p3 = new Pen_Entities(BRAND.PARKER, "Black", "Blue", MATERIAL.METAL, 56, LocalDate.parse("2002-04-09"), LocalDate.parse("2003-10-08"), 150, 30);
		
		ArrayList<Pen_Entities> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		return list;
	}
	
	//Create/Add New Pen from User
	public static Pen_Entities addPen(String brand, String color, String inkColor, String material, int stock,
			String stockUpdateDate, String stockListingDate, double price, int discount)
	{
		BRAND brands = BRAND.valueOf(brand);
		MATERIAL materials = MATERIAL.valueOf(material);
		LocalDate stockDate = LocalDate.parse(stockUpdateDate);
		LocalDate listDate = LocalDate.parse(stockListingDate);
		
		return new Pen_Entities(brands, color, inkColor, materials, stock, stockDate, listDate, price, discount);
	}
	
	//Display All Pens
	public static void display(ArrayList<Pen_Entities> list)
	{
		for(Pen_Entities p : list)
		{
			System.out.println(p);
		}
	}
	
	//Update Pen By ID
	public static void update(int id,int stock,ArrayList<Pen_Entities> list) throws Pen_Exception
	{
		for (Pen_Entities pen : list) {
            if (pen.getPen_id() == id) 
            {
                pen.setStock(stock);
                System.out.println("Stock of Pen with ID " + id + " updated successfully.");
                return;
            }
        }
        System.out.println("Pen with ID " + id + " not found.");
	}
	
	//Delete Pen By ID
	public static void delete(int id,ArrayList<Pen_Entities> list) throws Pen_Exception
	{
		Pen_Entities p = new Pen_Entities(id);
		
		int index = list.indexOf(p);
		if(index==-1)
		{
			throw new Pen_Exception("ERROR");
		}
		list.remove(index);
	}
	
	//Set discount of 20% for all the pens which are not at all sold in last 3 months
	public static void discount(ArrayList<Pen_Entities> list)
	{
		for(Pen_Entities p : list)
		{
			if(p.getStockUpdateDate()==null && ChronoUnit.MONTHS.between(p.getStockListingDate(), LocalDate.now())>3)
			{
				p.setPrice(p.getPrice()-p.getPrice()*0.20);
				System.out.println("New Price - "+p.getPrice());
			}
			else
			{
				System.out.println("Error");
			}
		}
	}
	
	//Remove Pens which are never sold once listed in 9 months
	public static void remove(ArrayList<Pen_Entities> list)
	{
		Iterator<Pen_Entities> iterator = list.iterator();
		
		while(iterator.hasNext())
		{
			Pen_Entities p = iterator.next();
			if(p.getStockUpdateDate()==null && ChronoUnit.MONTHS.between(p.getStockListingDate(), LocalDate.now())>9)
			{
				System.out.println(p.getBrand()+" is Not Sold for 9 Months");
			}
		}
	}
	
	//Sort Pen By ID
	public static void sortById(ArrayList<Pen_Entities> list)
	{
		Collections.sort(list,Comparator.comparingInt(Pen_Entities :: getPen_id));
	}
	
	//Sort Pen By Price
	public static void sortByPrice(ArrayList<Pen_Entities> list)
	{
		Collections.sort(list,Comparator.comparingDouble(Pen_Entities :: getPrice));
	}
}
