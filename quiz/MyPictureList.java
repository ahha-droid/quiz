package quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class MyPictureList extends ArrayList<Picture> {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("resource")
	MyPictureList(String name) throws FileNotFoundException{
		Scanner scaner=null;
		File plik = new File(name);
		scaner = new Scanner(plik).useDelimiter(",|\\n");
		
		while (scaner.hasNext()){
			Picture pictu=new Picture(0, "", "", "", "", null);
		
			pictu.setLp(Integer.parseInt(String.valueOf(scaner.next())));
			pictu.setAuthor(String.valueOf(scaner.next()));
			pictu.setTitle(String.valueOf(scaner.next()));
			pictu.setYear(String.valueOf(scaner.next()));
			pictu.setTechnique(String.valueOf(scaner.next()));
		
			String picture=(""+pictu.getLp()+".jpg");
			pictu.setImg((new ImageIcon(picture).getImage()));
			add(pictu);
		}
		scaner.close();
	}

}