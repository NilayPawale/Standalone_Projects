package com.pen.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.pen.entities.Pen_Entities;

public interface Pen_IO_Utils  {

	static void writeDetails(ArrayList<Pen_Entities> list, String filename) throws IOException
	{
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename)))
		{
			out.writeObject(list);
		}
	}
}