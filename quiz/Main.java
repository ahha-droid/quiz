package quiz;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	MyPictureList pictures= new MyPictureList("obrazy.txt");
	protected Results results = new Results();
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {try {
				new Main();
			} catch (IOException e) {
				e.printStackTrace();
			}}});
		//SwingUtilities.invokeLater( () -> new MojeGUI() );
	}
	
	public Main() throws IOException {
		
		JFrame frame=new JFrame();
		MyBGPanel myBGPanel = new MyBGPanel(new ImageIcon("tlo.jpg").getImage());
		frame.add(myBGPanel);
		frame.setContentPane(myBGPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1400, 800));
		frame.setLocationRelativeTo(null);
		
		if (results.getQuest()==0) {
			MyJPanel jpStart = new MyJPanel("Przejdz dalej", "Witaj w quizie o sztuce!","<html>Przypisz obrazom ich twórcê<br/>Odpowiedz poprawna +2 pkty, b³êdna -1<br/>Przed Tob¹ 10 obrazów znanych malarzy<br/>Mi³ej zabawy!!</html>", myBGPanel, frame, results, pictures);
		}
		
		frame.repaint();
		frame.pack();
		frame.setVisible(true);
	}
	
}