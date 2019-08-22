package quiz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MyJLabel extends JLabel{
	private static final long serialVersionUID = 1L;

	public MyJLabel(String name){
		super(name);
		setOpaque(true);
		setBackground(new Color(220, 230, 240));
		setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
	}
	
}