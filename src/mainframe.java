import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
public class mainframe extends JPanel {
	private JButton logPhysical;
	private JButton logHealth;
	private JButton print;
	private JButton edit;
	private JButton delete;
	private JButton quit;
	private JLabel welcomelabel;
	private JLabel leftmiddlelabel;
	private JLabel lefttoplabel;
	private Border blackline;
	private JPanel leftpanel;
	private JPanel topleftpanel;
	private JPanel mainmiddle;
	private JPanel rightpanel;
	public static JFrame temp;
	logphysical numberone=new logphysical();
	logHealthIndicators numbertwo=new logHealthIndicators();
	
	public mainframe(){
		rightpanel=new JPanel();
		
		welcomelabel=new JLabel("Welcome to Last Minute Workout Tracker", JLabel.CENTER);
		leftmiddlelabel=new JLabel("Insert motivational quote here", JLabel.CENTER);
		lefttoplabel=new JLabel("Please choose one of the following options", JLabel.CENTER);
		blackline=BorderFactory.createLineBorder(Color.black);
		
		leftpanel=new JPanel();
		topleftpanel=new JPanel();
		mainmiddle=new JPanel();
		
		leftpanel.setLayout(new GridLayout(3,1));
		topleftpanel.add(lefttoplabel);
		mainmiddle.add(leftmiddlelabel);
		leftpanel.add(topleftpanel);
		leftpanel.add(mainmiddle);
		leftpanel.setBorder(blackline);
		
		setBorder(blackline);
		rightpanel.setLayout(new GridLayout(6,1));
		
		
		logPhysical= new JButton("Log Physical Activity");
		logPhysical.addActionListener(new ButtonListener());
		logHealth= new JButton("Log Health Indicators");
		logHealth.addActionListener(new ButtonListener());
		print=new JButton("Print Records");
		edit=new JButton("Edit Entry");
		delete=new JButton("Delete Entry");
		quit=new JButton("Quit");
		quit.addActionListener(new ButtonListener());
		
		
		rightpanel.add(logPhysical);
		rightpanel.add(logHealth);
		rightpanel.add(print);
		rightpanel.add(edit);
		rightpanel.add(delete);
		rightpanel.add(quit);
		setLayout(new BorderLayout());
		welcomelabel.setBorder(blackline);
		leftpanel.setBorder(blackline);
		rightpanel.setBorder(blackline);
		add(welcomelabel, BorderLayout.PAGE_START);
		add(leftpanel, BorderLayout.LINE_START);
		add(rightpanel,BorderLayout.CENTER);
	}
	public class ButtonListener implements ActionListener
	   {
	    public void actionPerformed(ActionEvent event)
	     {
	    	Object source=event.getSource();
	    	if(source==logPhysical)
	    	{
	    		Hms.dude.remove(Hms.one);
	    		Hms.dude.repaint();
	    		Hms.dude.add(Hms.two);
	    		Hms.dude.revalidate();
	    	}
	    	if(source==logHealth)
	    	{
	    		Hms.dude.remove(Hms.one);
	    		Hms.dude.repaint();
	    		Hms.dude.add(Hms.three);
	    		Hms.dude.revalidate();
	    	}
	    	if(source==quit)
	    	{
					try {
						Hms.database.save("saved");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
	    		System.exit(0);
	    	}
	   
	   }
}}
