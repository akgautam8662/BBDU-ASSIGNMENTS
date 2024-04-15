import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class welcome extends JWindow implements ActionListener
{
	private JLabel title,message,pic;
	private JProgressBar pbar;
	private JTextArea area,devloper;
	Timer tm;
	int i,x,c;
	
	public welcome()
	{
		Container cn=getContentPane();
		cn.setLayout(null);
		cn.setBackground(new Color(0,0,0)); 
		
		tm=new Timer(350,this);
		tm.start();
		i=0;x=0;c=0;
		JPanel pn=new JPanel();
		title=new JLabel("WELCOMME TO DAIRY PRODUCT MANAGEMENT SYSTEM");
		title.setFont(new Font("monotype cursiva",Font.BOLD,25));
		title.setBounds(100,0,900,40);
		pn.setBounds(0,5,900,40);
		pn.setLayout(null);
		pn.setBackground(new Color(233,117,82,255)); 
		pn.add(title);
		JLabel tmp=new JLabel(new ImageIcon("Copy of 1658221146.jpg"));
		tmp.setBounds(0,0,900,40);
		pn.add(tmp);
		
		
		devloper=new JTextArea(4,4);
		devloper.setText("DEVLOPED BY:-  ASHISH KUMAR GAUTAM,VICKY KUMAR (BCA) \nPLEASE SEND FEEDBACK ABOUT THE PROJECT TO :  \nEMAIL :- ashishkumargautam8662@gmail.com");
		devloper.setBounds(500,210,400,100);
		devloper.setBackground(new Color(0,0,0)); 
		devloper.setForeground(Color.white);
		
		pic=new JLabel();
		pic.setIcon(new ImageIcon("welcome bg.png"));
		pic.setBounds(550,50,300,150);
		
		message=new JLabel();
		message.setForeground(new Color(255,255,255));
		message.setBounds(10,230,250,25);
		
		pbar=new JProgressBar();
		pbar.setBounds(10,270,870,25);
		pbar.setBackground(Color.white);
		pbar.setForeground(new Color(117, 208, 39));
		pbar.setValue(i);
		
		area=new JTextArea();
		area.setText("DAIRY PRODUCT MANAGEMENT SYSTEM has been created \n with the help of two languages known as java and oracle.\n computerized Dairy system of Bihar is used for \n capturing storing, analyzing and managing data and associated attributes. \n It is a system based of computer system. \n It is Basically use to analyze for the Dairy Production....");
		area.setBounds(10,60,520,150); 
		area.setBackground(new Color(0,0,0)); 
		area.setForeground(new Color(242,177,110,255));
		area.setFont(new Font("Times of New Roman",Font.BOLD,14));
		
		cn.add(pn);
		cn.add(area);
		cn.add(message);
		cn.add(pic);
		cn.add(pbar);
		cn.add(devloper);
		
		pack();
		setBounds(300,250,900,300);
		setVisible(true);
		
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
			x=x+20;
			if(x>=90)
			{
				i+=10;
				 pbar.setValue(i);
				 x=0;
				 c++;
			}
			switch (c)
			{
				case 0: message.setText("Please Waite While installing Component...............");break;
				case 1: message.setText("Mounting Database.....................................");break;
				case 2: message.setText("Checking Connection....................................");break;
				case 3: message.setText("Extracting Neccessory File.............................");break;
				case 4: message.setText("Checking For Space Nedded..............................");break;
				case 5: message.setText("Creating Backup of File.................................");break;
				case 6: message.setText("Installing Modules......................................");break;
				case 7: message.setText("Verifying Data...........................................");break;
				case 8: message.setText("Loading Component........................................");break;
				case 9: message.setText("Loading Module............................................");break;
				case 10: message.setText("Finishing Installation....................................");break;
			}
			if(i>=98)
			{
				tm.stop();
				dispose();
				new login();
			}
	}
	
	public static void main(String args[])
	{
		new welcome();
	}
}
