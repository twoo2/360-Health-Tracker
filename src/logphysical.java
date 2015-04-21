import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class logphysical extends JPanel {
	
	private Border blackline;
	
	//All variables needed for left panel
	private JPanel leftpanel;
	private JLabel intro;
	private JButton cardio;
	private JButton strength;
	private JButton hours;
	private JButton sleep;
	private JButton supercancel;
	
	//rightpanel will be changing depending on option chosen from left panel
	private JPanel rightpanel;
	private JLabel savedinfo;
	
	//variables needed to create rightpanel when cardio is chosen
	private JPanel getcardioinfo;
	private JLabel cardiointro;
	private JTextField entercardioinfo;
	private JPanel cabottombuttons;
	private JButton savecardio;
	private JButton cancelcardio;
	private String cardioworkout;
	
	//variables needed to create rightpanel when strength is chosen
	private JPanel getstrengthinfo;
	private JLabel strengthintro;
	private JTextField enterstrengthinfo;
	private JPanel stbottombuttons;
	private JButton savestrength;
	private JButton cancelstrength;
	private String strengthworkout;
	
	//variables needed to create rightpanel when hours is chosen
	private JPanel getworkhours;
	private JLabel whintro;
	private JTextField enterwhinfo;
	private JPanel whbuttons;
	private JButton savewh;
	private JButton cancelwh;
	private String whrecord;
	
	//variables needed to create right panel when sleep is chosen
	private JPanel getsleephours;
	private JLabel sleepintro;
	private JTextField entersleepinfo;
	private JPanel sleepbuttons;
	private JButton savesleep;
	private JButton cancelsleep;
	private String sleeprecord;
	Date date;
	
	public logphysical()
	{
		date=new Date();
		blackline=BorderFactory.createLineBorder(Color.black);
		cardioworkout="";
		strengthworkout="";
		whrecord="";
		sleeprecord="";
		savedinfo=new JLabel("",JLabel.CENTER);
		
		leftpanel=new JPanel();
		leftpanel.setLayout(new GridLayout(6,1));
		
		rightpanel=new JPanel();
		rightpanel.setLayout(new GridLayout(1,1));
		
		//sets up everything for when cardio is chosen
		getcardioinfo=new JPanel();
		getcardioinfo.setLayout(new GridLayout(3,1));
		cardiointro=new JLabel("please enter name for workout", JLabel.CENTER);
		entercardioinfo=new JTextField();
		cabottombuttons=new JPanel();
		cabottombuttons.setLayout(new GridLayout(1,2));
		savecardio=new JButton("Save");
		cancelcardio=new JButton("Cancel");
		cancelcardio.addActionListener(new ButtonListener());
		savecardio.addActionListener(new ButtonListener());
		cabottombuttons.add(cancelcardio);
		cabottombuttons.add(savecardio);
		getcardioinfo.add(cardiointro);
		getcardioinfo.add(entercardioinfo);
		getcardioinfo.add(cabottombuttons);
		
		//sets up everything for when strength is chosen
		getstrengthinfo=new JPanel();
		getstrengthinfo.setLayout(new GridLayout(3,1));
		strengthintro=new JLabel("please enter name for workout", JLabel.CENTER);
		enterstrengthinfo=new JTextField();
		stbottombuttons=new JPanel();
		stbottombuttons.setLayout(new GridLayout(1,2));
		savestrength=new JButton("Save");
		cancelstrength=new JButton("Cancel");
		cancelstrength.addActionListener(new ButtonListener());
		savestrength.addActionListener(new ButtonListener());
		stbottombuttons.add(cancelstrength);
		stbottombuttons.add(savestrength);
		getstrengthinfo.add(strengthintro);
		getstrengthinfo.add(enterstrengthinfo);
		getstrengthinfo.add(stbottombuttons);
		
		//sets up everything for when hours is chosen
		getworkhours=new JPanel();
		getworkhours.setLayout(new GridLayout(3,1));
		whintro=new JLabel("please enter workout hours", JLabel.CENTER);
		enterwhinfo=new JTextField();
		whbuttons=new JPanel();
		whbuttons.setLayout(new GridLayout(1,2));
		savewh=new JButton("Save");
		cancelwh=new JButton("Cancel");
		cancelwh.addActionListener(new ButtonListener());
		savewh.addActionListener(new ButtonListener());
		whbuttons.add(cancelwh);
		whbuttons.add(savewh);
		getworkhours.add(whintro);
		getworkhours.add(enterwhinfo);
		getworkhours.add(whbuttons);
		
		//sets up everything for when sleep is chosen
		getsleephours=new JPanel();
		getsleephours.setLayout(new GridLayout(3,1));
		sleepintro=new JLabel("please enter hours slept", JLabel.CENTER);
		entersleepinfo=new JTextField();
		sleepbuttons=new JPanel();
		sleepbuttons.setLayout(new GridLayout(1,2));
		savesleep=new JButton("Save");
		cancelsleep=new JButton("Cancel");
		cancelsleep.addActionListener(new ButtonListener());
		savesleep.addActionListener(new ButtonListener());
		sleepbuttons.add(cancelsleep);
		sleepbuttons.add(savesleep);
		getsleephours.add(sleepintro);
		getsleephours.add(entersleepinfo);
		getsleephours.add(sleepbuttons);
		
		
		//arranges everything on leftpanel
		intro=new JLabel("Please pick a record to create", JLabel.CENTER);
		cardio=new JButton("Cardio Workout");
		cardio.addActionListener(new ButtonListener());
		strength=new JButton("Strength Workout");
		strength.addActionListener(new ButtonListener());
		hours=new JButton("Workout Hours");
		hours.addActionListener(new ButtonListener());
		sleep=new JButton("Sleep Hours");
		sleep.addActionListener(new ButtonListener());
		supercancel=new JButton("Back");
		supercancel.addActionListener(new ButtonListener());

		
		leftpanel.add(intro);
		leftpanel.add(cardio);
		leftpanel.add(strength);
		leftpanel.add(hours);
		leftpanel.add(sleep);
		leftpanel.add(supercancel);
		leftpanel.setBorder(blackline);
		rightpanel.setBorder(blackline);
		setLayout(new GridLayout(1,2));
		add(leftpanel);
		add(rightpanel);

	}
	public class ButtonListener implements ActionListener
	   {
	    public void actionPerformed(ActionEvent event)
	     {
	    	Object source=event.getSource();
	    	rightpanel.removeAll();
	    	if(source==cardio)
	    	{
	    		rightpanel.add(getcardioinfo);
	    		updateUI();
	    	}
	    	if(source==strength)
	    	{
	    		rightpanel.add(getstrengthinfo);
	    		updateUI();
	    	}
	    	if(source==cancelcardio)
	    	{
	    		entercardioinfo.setText("");
	    		rightpanel.remove(getcardioinfo);
	    		updateUI();
	    	}
	    	if(source==savecardio)
	    	{
	    		cardioworkout=entercardioinfo.getText();
	    		Workout r=new Workout(cardioworkout,0, date);
	    		Hms.database.addRecord(r);
	    		savedinfo.setText(cardioworkout+" saved!");
	    		entercardioinfo.setText("");
	    		rightpanel.remove(getcardioinfo);
	    		rightpanel.add(savedinfo);
	    		updateUI();
	    	}
	    	if(source==savestrength)
	    	{
	    		strengthworkout=enterstrengthinfo.getText();
	    		savedinfo.setText(strengthworkout+" saved!");
	    		enterstrengthinfo.setText("");
	    		rightpanel.remove(getstrengthinfo);
	    		rightpanel.add(savedinfo);
	    		updateUI();
	    	}
	    	if(source==cancelstrength)
	    	{
	    		enterstrengthinfo.setText("");
	    		rightpanel.remove(getstrengthinfo);
	    		updateUI();
	    	}
	    	if(source==hours)
	    	{
	    		rightpanel.add(getworkhours);
	    		updateUI();
	    	}
	    	if(source==cancelwh)
	    	{
	    		enterwhinfo.setText("");
	    		rightpanel.remove(getworkhours);
	    		updateUI();
	    	}
	    	if(source==savewh)
	    	{
	    		whrecord=enterwhinfo.getText();
	    		savedinfo.setText(whrecord+" workout hours were saved!");
	    		enterwhinfo.setText("");
	    		rightpanel.remove(getworkhours);
	    		rightpanel.add(savedinfo);
	    		updateUI();
	    	}
	    	if(source==sleep)
	    	{
	    		rightpanel.add(getsleephours);
	    		updateUI();
	    	}
	    	if(source==savesleep)
	    	{
	    		sleeprecord=entersleepinfo.getText();
	    		savedinfo.setText(sleeprecord+" hours slept saved!");
	    		entersleepinfo.setText("");
	    		rightpanel.remove(getsleephours);
	    		rightpanel.add(savedinfo);
	    		updateUI();
	    	}
	    	if(source==cancelsleep)
	    	{
	    		entersleepinfo.setText("");
	    		rightpanel.remove(getsleephours);
	    		updateUI();
	    	}
	    	if(source==supercancel)
	    	{
	    		Hms.dude.remove(Hms.two);
	    		Hms.dude.add(Hms.one);
	    		Hms.dude.repaint();
	    		Hms.dude.revalidate();
	    	}
	  
	     }
	   }
	
}
