import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener
{
	private JLabel lblusrnm,lblpasswd,header,title;
	private JTextArea footer;
	private TextField txtpasswd;
	private JButton login,cancel;
	private Choice usrnm;
	private int c,x;
	private Connection conn;
	private Statement stat;
	private ResultSet rs;
	private String str1,str2;
	private Container cn;

	
	public login()
	{
		setTitle("WELCOME TO LOGIN PAGE");
		cn=getContentPane();
		cn.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cn.setBackground(new Color(55, 232, 163));
		
			Timer tm=new Timer(1000,new tmListener());
			tm.start();
			title=new JLabel("WELCOME TO ADVANCE JAVA PROJECT");
			title.setBounds(50,10,500,50);
			title.setFont(new Font("Monotype cursiva",Font.BOLD,20));
			title.setForeground(new Color(55, 232, 163 ));
			x=0;
			
			JLabel	img=new JLabel(new ImageIcon("login_page.png"));
			img.setBounds(0,0,500,450);
			
			JPanel pn=new JPanel();
			pn.setBounds(90,60,300,35);
			pn.setBackground(new Color(255,255,255));
			
			header=new JLabel("LOGIN PAGE");
			header.setForeground(Color.black);
			header.setFont(new Font("luxury",Font.BOLD,18));
			c=1;
			
			lblusrnm=new JLabel("USER NAME :");
			lblusrnm.setBounds(80,140,120,25);
			lblusrnm.setFont(new Font("luxury",Font.BOLD,16));
			lblusrnm.setForeground(Color.white);
			
			lblpasswd=new JLabel("PASSWORD :");
			lblpasswd.setBounds(80,200,120,25);
			lblpasswd.setFont(new Font("luxury",Font.BOLD,16));
			lblpasswd.setForeground(Color.white);
			
			txtpasswd=new TextField(10);
			txtpasswd.setBounds(210,200,170,25);
			txtpasswd.setBackground(new Color(255,255,255));
			txtpasswd.addActionListener(new enterListener());
			txtpasswd.setEchoChar('*');
			txtpasswd.setFont(new Font("luxury",Font.BOLD,22));
			
			login=new JButton("  Login   ");
			login.setBounds(100,280,100,30);
			login.setFont(new Font("Times New Roman",1,16));
			login.addActionListener(this);
			login.setToolTipText("press to login");
			login.setMnemonic('l');
			
			cancel=new JButton("  Cancel   ");
			cancel.setBounds(270,280,100,30);
			cancel.setFont(new Font("Times New Roman",1,16));
			cancel.addActionListener(this);
			cancel.setToolTipText("press to exit");
			cancel.setMnemonic('c');
			
			usrnm=new Choice();
			usrnm.setBounds(210,140,170,25);
			usrnm.setFont(new Font("luxury",Font.BOLD,16));
			
			footer=new JTextArea(3,1);
			footer.setText("                         Please   Fill  The  Password  Correct \n                 You Have  Maximum Three (3) Chances To Try");
			footer.setWrapStyleWord(true);
			footer.setBounds(0,340,500,50);
			footer.setForeground(Color.black);
			footer.setBackground(new Color(255,255,255));
			footer.setEditable(false);
			footer.setFont(new Font("Times of new Roman",Font.BOLD,16));
			
			pn.add(header);
			cn.add(title);
			cn.add(lblusrnm);
			cn.add(lblpasswd);
			cn.add(txtpasswd);
			cn.add(usrnm);
			cn.add(login);
			cn.add(cancel);
			cn.add(pn);
			cn.add(footer);
			cn.add(img);
			
			Dimension wind=Toolkit.getDefaultToolkit().getScreenSize();
			
			pack();
			setBounds((wind.width-500)/2,(wind.height-450)/2,500,450);
			setVisible(true);
			connect();
			try
			{
				rs=stat.executeQuery("select name from login");
				while(rs.next())
				usrnm.addItem(rs.getString(1));
				
			}
				catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"error to load Form"+sqle,"Form loadin Error",JOptionPane.ERROR_MESSAGE);
			}	
	}
	
	private void log()
	{   
		str1=usrnm.getSelectedItem().toString();
		str2=txtpasswd.getText();
		if(c==3)
			{
				JOptionPane.showMessageDialog(null,"Sorry Youre Chances Will No Longer \n  Please Try Again Later");
				System.exit(0);
			}
			try
			{
				rs=stat.executeQuery("select passwd from login where name='"+str1+"'");
				rs.next();
				String tmp=rs.getString(1);
				if(str2.compareTo(tmp.trim())==0)
				{
				    new Menu_Page(str1);
					rs.close();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null," Youre   "+c+"  Chances Will go \n   Try Again");
					txtpasswd.setText("");
					txtpasswd.requestFocus();
					c++;
				}
			}
				catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"error to load Form"+sqle,"Form loadin Error",JOptionPane.ERROR_MESSAGE);
			}	
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		String tmp=e.getActionCommand();
		tmp=tmp.trim();
		if(tmp.equalsIgnoreCase("login"))
		{
			log();	
		}
		else if(tmp.equalsIgnoreCase("cancel"))
		{
			System.exit(0);
		}
	}
	
	private class enterListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			log();	
		}
	}
	
	private class tmListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(x>=130)
			x=0;
			title.setLocation(x,0);
			x=x+20;	
		}
	}
	
	
	public void connect()
	{
		try
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn=DriverManager.getConnection("jdbc:odbc:abcl","xampp","admin");
				stat=conn.createStatement();
			}
			catch(SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,"error in Creating Connection","Database Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Not connected to Database","DataBase Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
    public static void main(String args[])
	{
		new login();
    }
}
