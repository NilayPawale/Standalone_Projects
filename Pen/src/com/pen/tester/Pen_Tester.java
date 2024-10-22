package com.pen.tester;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.pen.entities.Pen_Entities;
import com.pen.exception.Pen_Exception;
import static com.pen.utils.Pen_Utils.*;
import static com.pen.utils.Pen_IO_Utils.writeDetails;

public class Pen_Tester {

	public static void main(String[] args) throws Pen_Exception, IOException {
		try(Scanner sc = new Scanner(System.in))
		{
			boolean exit = false;
			ArrayList<Pen_Entities> penList = populatedPenList();
			
			while(!exit)
			{
				System.out.println("Choose a Option");
				System.out.println("1.Add\n"
						+ "2.Display\n"
						+ "3.Update\n"
						+ "4.Delete\n"
						+ "5.Discount at 20%\n"
						+ "6.Remove Pen not sold for 9 Months\n"
						+ "7.Sort By Id\n"
						+ "8.Sort By Price\n");
				
				switch(sc.nextInt())
				{
					case 1://Add
						Pen_Entities p = addPen(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(), sc.nextInt());
						penList.add(p);
						System.out.println("Added Successfully");
						break;
					case 2://Display
						display(penList);
						System.out.println("Display Sucessful");
						break;
					case 3:
						System.out.println("Enter Id");
//						delete(sc.nextInt(), penList);
						System.out.println("Enter the Stock to be Updated");
						update(sc.nextInt(), sc.nextInt(), penList);
						System.out.println("Update Successful");
						break;
					case 4:
						System.out.println("Enter Id");
						delete(sc.nextInt(), penList);
						System.out.println("Deleted Successfully");
						break;
					case 5:
						discount(penList);
						System.out.println("Discount Applied");
						break;
					case 6:
						remove(penList);
						System.out.println("Removed for 9 Months");
						break;
					case 7:
						sortById(penList);
						writeDetails(penList, sc.next());
						System.out.println("Id Write Successful");
						break;
					case 8:
						sortByPrice(penList);
						writeDetails(penList, sc.next());
						System.out.println("Price Write Successful");
						break;
				}
			}
		}

	}

}
