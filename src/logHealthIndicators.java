import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class logHealthIndicators extends JPanel {
	
	
	private Border blackline;
	
	//All variables needed for left panel
	private JPanel leftpanel;
	private JLabel intro;
	private JButton bloodpressure;
	private JButton pulserate;
	private JButton bloodsugar;
	
	
	//rightpanel will be changing depending on option chosen from left panel
	private JPanel rightpanel;
	private JLabel savedinfo;
	
	//variables needed to create rightpanel when bloodpressure is chosen
	private JPanel getbpinfo;
	private JLabel bpintro;
	private JTextField enterbpinfo;
	private JPanel bpbuttons;
	private JButton savebp;
	private JButton cancelbp;
	private String bprecord;
	
	//variables needed to create rightpanel when pulserate is chosen
	private JPanel getprinfo;
	private JLabel printro;
	private JTextField enterprinfo;
	private JPanel prbuttons;
	private JButton savepr;
	private JButton cancelpr;
	private String prrecord;
	
	//variables needed to create rightpanel when bloodsugar is chosen
	private JPanel getbsinfo;
	private JLabel bsintro;
	private JTextField enterbsinfo;
	private JPanel bsbuttons;
	private JButton savebs;
	private JButton cancelbs;
	private String bsrecord;
	
	private JButton cancel;
	public logHealthIndicators()
	{
		cancel=new JButton("Cancel");
		cancel.addActionListener(new ButtonListener());
		blackline=BorderFactory.createLineBorder(Color.black);
		bprecord="";
		prrecord="";
		bsrecord="";
		savedinfo=new JLabel("", JLabel.CENTER);
		leftpanel=new JPanel();
		rightpanel=new JPanel();
		leftpanel.setLayout(new GridLayout(5,1));
		rightpanel.setLayout(new GridLayout(1,1));
		intro=new JLabel("Please pick a record to create", JLabel.CENTER);
		bloodpressure=new JButton("blood pressure");
		bloodpressure.addActionListener(new ButtonListener());
		pulserate=new JButton("pulse rate");
		pulserate.addActionListener(new ButtonListener());
		bloodsugar=new JButton("blood sugar");
		bloodsugar.addActionListener(new ButtonListener());
		

		
		//sets up everything for when bloodpresure is chosen
		getbpinfo=new JPanel();
		getbpinfo.setLayout(new GridLayout(3,1));
		bpintro=new JLabel("please enter blood pressure", JLabel.CENTER);
		enterbpinfo=new JTextField();
		bpbuttons=new JPanel();
		bpbuttons.setLayout(new GridLayout(1,2));
		savebp=new JButton("Save");
		cancelbp=new JButton("Cancel");
		cancelbp.addActionListener(new ButtonListener());
		savebp.addActionListener(new ButtonListener());
		bpbuttons.add(cancelbp);
		bpbuttons.add(savebp);
		getbpinfo.add(bpintro);
		getbpinfo.add(enterbpinfo);
		getbpinfo.add(bpbuttons);
		
		//sets up everything for when pulserate is chosen
		getprinfo=new JPanel();
		getprinfo.setLayout(new GridLayout(3,1));
		printro=new JLabel("please enter pulse rate", JLabel.CENTER);
		enterprinfo=new JTextField();
		prbuttons=new JPanel();
		prbuttons.setLayout(new GridLayout(1,2));
		savepr=new JButton("Save");
		cancelpr=new JButton("Cancel");
		cancelpr.addActionListener(new ButtonListener());
		savepr.addActionListener(new ButtonListener());
		prbuttons.add(cancelpr);
		prbuttons.add(savepr);
		getprinfo.add(printro);
		getprinfo.add(enterprinfo);
		getprinfo.add(prbuttons);
		
		//sets up everything for when blood sugar is chosen
		getbsinfo=new JPanel();
		getbsinfo.setLayout(new GridLayout(3,1));
		bsintro=new JLabel("please enter blood sugar level", JLabel.CENTER);
		enterbsinfo=new JTextField();
		bsbuttons=new JPanel();
		bsbuttons.setLayout(new GridLayout(1,2));
		savebs=new JButton("Save");
		cancelbs=new JButton("Cancel");
		cancelbs.addActionListener(new ButtonListener());
		savebs.addActionListener(new ButtonListener());
		bsbuttons.add(cancelbs);
		bsbuttons.add(savebs);
		getbsinfo.add(bsintro);
		getbsinfo.add(enterbsinfo);
		getbsinfo.add(bsbuttons);
		
		
		
		
		leftpanel.add(intro);
		leftpanel.add(bloodpressure);
		leftpanel.add(pulserate);
		leftpanel.add(bloodsugar);
		leftpanel.add(cancel);
		
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
	    	if(source==bloodpressure)
	    	{
	    		rightpanel.add(getbpinfo);
	    		updateUI();
	    	}
	    	if(source==pulserate)
	    	{
	    		rightpanel.add(getprinfo);
	    		updateUI();
	    	}
	    	if(source==cancelbp)
	    	{
	    		enterbpinfo.setText("");
	    		rightpanel.remove(getbpinfo);
	    		updateUI();
	    	}
	    	if(source==savebp)
	    	{
	    		bprecord=enterbpinfo.getText();
	    		savedinfo.setText(bprecord + " saved!");
	    		enterbpinfo.setText("");
	    		rightpanel.remove(getbpinfo);
	    		rightpanel.add(savedinfo);
	    		updateUI();
	    	}
	    	if(source==savepr)
	    	{
	    		prrecord=enterprinfo.getText();
	    		savedinfo.setText(prrecord+" saved!");
	    		enterprinfo.setText("");
	    		rightpanel.remove(getprinfo);
	    		rightpanel.add(savedinfo);
	    		updateUI();
	    	}
	    	if(source==cancelpr)
	    	{
	    		enterprinfo.setText("");
	    		rightpanel.remove(getprinfo);
	    		updateUI();
	    	}
	    	if(source==bloodsugar)
	    	{
	    		rightpanel.add(getbsinfo);
	    		updateUI();
	    	}
	    	if(source==cancelbs)
	    	{
	    		enterbsinfo.setText("");
	    		rightpanel.remove(getbsinfo);
	    		updateUI();
	    	}
	    	if(source==savebs)
	    	{
	    		bsrecord=enterbsinfo.getText();
	    		savedinfo.setText(bsrecord+" workout hours were saved!");
	    		enterbsinfo.setText("");
	    		rightpanel.remove(getbsinfo);
	    		rightpanel.add(savedinfo);
	    		updateUI();
	    	}
	    	if(source==cancel)
	    	{
	    		Hms.dude.remove(Hms.three);
	    		Hms.dude.add(Hms.one);
	    		Hms.dude.repaint();
	    		Hms.dude.revalidate();
	    	}
	    	
	     }
	   }
}
