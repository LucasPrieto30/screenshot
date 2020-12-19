import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.*;

public class CapturadorPantalla {

	public static void main(String[] args) {
		Program myprogram=new Program();
		myprogram.setVisible(true);
		myprogram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

class Program extends JFrame{

	public Program () {
		
		setBounds(640,250,200,80);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel=new JPanel();
		JButton screenshot_button=new JButton("Screenshot");
		Toolkit mytoolkit =Toolkit.getDefaultToolkit();
		Dimension screen_size = mytoolkit.getScreenSize();
		
		panel.add(screenshot_button);
		add(panel);
		JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);

		screenshot_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					
					topFrame.setExtendedState(JFrame.ICONIFIED);
					SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy hh mm ss a");
					Calendar now = Calendar.getInstance();
			        Robot robot = new Robot();
			        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(screen_size));
			        ImageIO.write(screenShot, "TIFF", new File("screenshots"+File.separator+formatter.format(now.getTime())+".tiff"));
			        System.out.println(formatter.format(now.getTime()));
				
				}catch(Exception ex) {
					System.out.println(ex);
				}
			}
			
		});
		
	}
	
}