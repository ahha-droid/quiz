package quiz;

import java.awt.Image;

public class Picture {
	private int lp;
	private String author;
	private String title;
	private String year;
	private String technique;
	private Image img;
	
	public Picture(int lp, String author, String title, String year, String technique, Image img) {
		this.lp = lp;
		this.author = author;
		this.title = title;
		this.year = year;
		this.technique = technique;
		this.img = img;
	}
	
	public int getLp() {return lp;}
	public String getAuthor() {return author;}
	public String getTitle() {return title;}
	public String getYear() {return year;}
	public String getTechnique() {return technique;}
	public Image getImg() {return img;}
	
	public void setLp(int lp) {this.lp = lp;}
	public void setAuthor(String author) {this.author = author;}
	public void setTitle(String title) {this.title = title;}
	public void setYear(String year) {this.year = year;}
	public void setTechnique(String technique) {this.technique = technique;}
	public void setImg(Image img) {this.img = img;}
	
	public String toString() {return "Autorem tego obrazu jest: " + author +", Obraz nosi tytul: \""+ title +"\", zostal namalowany w roku: "+ year +", w technice: "+ technique+ ".";}
	
}