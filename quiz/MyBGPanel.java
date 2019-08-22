package quiz;

import java.awt.*;

import javax.swing.JPanel;

public class MyBGPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image img;

    public MyBGPanel(Image img) {
    	//setLayout(new BorderLayout());
    	this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        	}

    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }
}