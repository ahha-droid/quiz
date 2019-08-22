package quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyArrayList extends ArrayList<String> {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("resource")
	MyArrayList(String name) throws FileNotFoundException{
		Scanner scaner=null;
		File plik = new File(name);
		scaner = new Scanner(plik).useDelimiter(",");;
		
		while (scaner.hasNext()){
			String var = String.valueOf(scaner.next());
			add(var);
		}
		System.out.println();
		scaner.close();
	}
	
}