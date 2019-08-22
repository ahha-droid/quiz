package quiz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyQuestionPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	ArrayList<Integer> listUseButtons=new ArrayList<Integer>();
	//protected Results sc = new Results();
	MyButton jb1=new MyButton(""), jb2=new MyButton(""), jb3=new MyButton(""), jb4=new MyButton("");
	MyButton[] tabBut = {jb1, jb2, jb3, jb4};
	JPanel myButtony;
	JLabel jlPicture;
	ImageIcon obraz;
	Image skalowanie;
	int szer;
	int wys;
	
	public MyQuestionPanel(Results results, int nrPictury, JFrame frame, MyBGPanel myBGPanel, MyPictureList pictures, MyButton jb, JPanel panelQuesta) throws FileNotFoundException {
		ArrayList<String> authors = new MyArrayList("autorzy.txt");
		ArrayList<Integer> listUseAuthors =new ArrayList<Integer>();
		
		while (listUseButtons.size()<tabBut.length) {
			int nrB0123=(int)(Math.random()*tabBut.length);
		
			if (listUseButtons.isEmpty()) {
				tabBut[nrB0123].setText(pictures.get(nrPictury).getAuthor());
				tabBut[nrB0123].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event) {
						tabBut[nrB0123].dodaj(results);
						String s="Dobra odpowiedz. "+pictures.get(nrPictury).toString();
						tabBut[nrB0123].answer(s, myButtony, results, frame, myBGPanel, pictures, jb, panelQuesta);
					}
				});
				listUseButtons.add(nrB0123);
			}
			else if (listUseButtons.indexOf(nrB0123)==-1) {
					int nrAuthora=(int)(Math.random()*authors.size());
					
					if(!(pictures.get(nrPictury).getAuthor().equals(authors.get(nrAuthora)))&&(listUseAuthors.indexOf(nrAuthora)==-1)) {
						tabBut[nrB0123].setText(authors.get(nrAuthora));
						listUseAuthors.add(nrAuthora);
						tabBut[nrB0123].addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent event) {
								tabBut[nrB0123].odejmij(results);
								String s="Zla odpowiedz. "+pictures.get(nrPictury).toString();
								tabBut[nrB0123].answer(s, myButtony, results, frame, myBGPanel, pictures, jb, panelQuesta);
							}
						});
						listUseButtons.add(nrB0123);
					}
			}
		}
		
		myButtony = new JPanel();
		
		myButtony.setOpaque(false);
		myButtony.add(jb1);
		myButtony.add(jb2);
		myButtony.add(jb3);
		myButtony.add(jb4);

		int wysokosc=0;
        int szerokosc=0;
		
        jlPicture = new JLabel(new ImageIcon(pictures.get(nrPictury).getImg()));
		//jlPicture = new JLabel(new ImageIcon(pictures.get(nrPictury).getImg()));
		obraz = new ImageIcon(pictures.get(nrPictury).getImg());
        
       
        if (((int)myBGPanel.getHeight()-80)>(pictures.get(nrPictury).getImg()).getHeight(jlPicture)) {
        	wysokosc = (pictures.get(nrPictury).getImg()).getHeight(jlPicture);
        	szerokosc = (pictures.get(nrPictury).getImg()).getWidth(jlPicture);
        }
        else{
        	wysokosc = myBGPanel.getHeight()-80;
        	double skala = (double)(pictures.get(nrPictury).getImg()).getHeight(jlPicture)/(double)(myBGPanel.getHeight()-80);
        	szerokosc = (int)((pictures.get(nrPictury).getImg()).getWidth(jlPicture)/skala);
        }
//        if (((int)myBGPanel.getWidth()-80)<(pictures.get(nrPictury).getImg()).getWidth(jlPicture)) {
       	if (((int)myBGPanel.getWidth()-80)<szerokosc) {
        	szerokosc = myBGPanel.getWidth()-80;
        	double skala = (double)(pictures.get(nrPictury).getImg()).getWidth(jlPicture)/(double)(myBGPanel.getWidth()-80);
        	wysokosc = (int)((pictures.get(nrPictury).getImg()).getHeight(jlPicture)/skala);
        }
        
        if (szerokosc==0) szerokosc=200;
        skalowanie = obraz.getImage().getScaledInstance(szerokosc, wysokosc, Image.SCALE_DEFAULT);
        jlPicture.setIcon(new ImageIcon(skalowanie));
	
		szer=((jb1.getWidth()+jb1.getWidth()+jb3.getWidth()+jb4.getWidth()+20)>szerokosc? (jb1.getWidth()+jb1.getWidth()+jb3.getWidth()+jb4.getWidth()+20): szerokosc+20);
		wys=wysokosc+20;
		
		setLayout(new BorderLayout());
		add(jlPicture, BorderLayout.PAGE_START);
		add(myButtony, BorderLayout.PAGE_END);repaint();
	}
	
}