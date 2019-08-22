package quiz;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyButton extends JButton{
	private static final long serialVersionUID = 1L;

	public MyButton(String s) {
		super(s);
		setFont(new Font(Font.DIALOG, Font.BOLD, 15));
	}
	
	public Results zagadka(Results results, JFrame frame, MyBGPanel myBGPanel, MyPictureList pictures, MyButton jb, JPanel panelQuesta) throws FileNotFoundException {
		if (results.getQuest()>=0&&results.getQuest()<10) {
			int nrPictury=(int)(Math.random()*pictures.size());
				while (results.getAl().indexOf(nrPictury)!=-1) {
				nrPictury=(int)(Math.random()*pictures.size());
			}
			results.setAl2(nrPictury);
			MyQuestionPanel qeustion=new MyQuestionPanel(results, nrPictury, frame, myBGPanel, pictures, jb, panelQuesta);
			qeustion.jlPicture.setPreferredSize(new Dimension(qeustion.szer, qeustion.wys));
			myBGPanel.add(qeustion);
			
			frame.revalidate();
			frame.repaint();
			results.setQuest();
			return results;
		}
		else {
			Results results2=new Results();
			String end="Zdobyles: "+results.getScore()+" punktow"+"\n na "+(results.getQuest()*2)+" mo¿liwych.";
			MyJPanel jpKoniec = new MyJPanel("Zagraj jeszcze raz", end, myBGPanel, frame, results2, pictures);
			return results2;
		}
	}
	
	public void answer(String s, JPanel myButtony, Results results, JFrame frame, MyBGPanel myBGPanel, MyPictureList pictures, MyButton jb, JPanel panelQuesta)  {
		myButtony.removeAll();
		MyButton jlAnsweru = new MyButton(s);
		MyButton next= new MyButton("Dalej");
		myBGPanel.add(jlAnsweru);
		myBGPanel.add(next);
		frame.revalidate();
		frame.repaint();
		jlAnsweru.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event) {jlAnsweru.nowy(results, frame, myBGPanel, pictures, jb, panelQuesta);}});
		next.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event) {next.nowy(results, frame, myBGPanel, pictures, jb, panelQuesta);}});
	}
		
	public Results nowy(Results results, JFrame frame, MyBGPanel myBGPanel, MyPictureList pictures, MyButton jb, JPanel panelQuesta) {
		myBGPanel.removeAll();
		try {jb.zagadka(results, frame, myBGPanel, pictures, jb, panelQuesta);} 
		catch (FileNotFoundException e) {e.printStackTrace();}
		frame.revalidate();
		frame.repaint();
		return results;
	}
	
	public Results odejmij(Results results) {
		results.setScoreM();
		return results;
	}
	
	public Results dodaj(Results results) {
		results.setScoreP();
		return results;
	}
	
}