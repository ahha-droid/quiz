package quiz;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyJPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	public MyJPanel(){
		super();
		setOpaque(false);
		setLayout(new BorderLayout());
	}
	
	public MyJPanel(String nameButton, String nameLabel, MyBGPanel bgPanel, JFrame frame, Results results, MyPictureList pictures){
		this(nameButton, nameLabel, "", bgPanel, frame, results, pictures);
	}
	
	public MyJPanel(String nameButton, String nameLabel, String nameLabel2,MyBGPanel bgPanel, JFrame frame, Results results, MyPictureList pictures){
		super();
		setOpaque(false);
		setLayout(new BorderLayout());
		
		MyJPanel panelQuesta=new MyJPanel();
		MyJPanel panelQuesta2=new MyJPanel();
		MyJLabel jl = new MyJLabel(nameLabel);
		MyJLabel jl2 = new MyJLabel(nameLabel2);
		MyButton jb = new MyButton(nameButton);
		jl2.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
		panelQuesta2.add(jl, BorderLayout.PAGE_START);
		panelQuesta2.add(jl2, BorderLayout.CENTER);
		panelQuesta.add(panelQuesta2);
		panelQuesta.add(jb, BorderLayout.PAGE_END);
		bgPanel.add(panelQuesta, BorderLayout.CENTER);
		jb.addActionListener(event -> {jb.nowy(results, frame, bgPanel, pictures, jb, panelQuesta);});
	}
	
}