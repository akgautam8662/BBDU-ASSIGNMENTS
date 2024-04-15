import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
//import Report.*;


  public class Menu_Page extends JFrame //implements Runnable
    {
	private JMenuBar mBar;
	private JMenu mMaster,mTranscition,mReport,mHelp,mExit,mAbout,mTools;
	private JMenuItem miProduct_category,miProduct_master,miRegistration_master,miRetailer_master,miStaff_master;
	private JMenuItem miProduct_distribution,miPayment,miReturn;//miSchool,miEducation,miFamily;
	private JMenuItem miDeveloper,miSoftware,miYes,miNo,miDocu,mibakup,mirestore,michngpasswd,micreateusr;
	private JMenuItem rProduct_master,rRegistration_master,rRetailer_master,rStaff_master;
	private JMenuItem rProduct_distribution,rPayment,rReturn,rSchool,rEducation,rFamily;
	private ImageIcon image;
	private JLabel lblImage,rn;
	private JPanel pnl,mvpnl;
	private Container mycontainer; 
	private String str1,usrtype;
	int r;

  public Menu_Page(String ss)
    {
	setTitle(" DAIRY PRODUCT MANAGEMENT SYSTEM ");
	getContentPane().setLayout(null);
	getContentPane().setBackground(new Color(252,226,250));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	usrtype=ss.trim();

	pnl = new JPanel();
	image=new ImageIcon("MAINpAGE1.jpg");
	pnl.setLayout(null);
	mvpnl=new JPanel();
   	r=0;
	
	 rn=new JLabel("WELCOME TO  DAIRY PRODUCT MANAGEMENT SYSTEM ");
	 rn.setForeground(Color.blue);
	 rn.setFont(new Font("monotype cursiva",Font.BOLD,20));
	 
	 rn.setBounds(0,400,750,30);
	 //mvpnl.add(rn);
	
	Timer tm=new Timer(500,new timerListener());
	tm.start();
		
	lblImage=new JLabel(image);
	lblImage.setBounds(0,0,800,600);

	mycontainer=getContentPane();
        mycontainer.setLayout(new GridLayout(1,1));
        pnl.add(rn);
        pnl.add(lblImage);
	mycontainer.add(pnl);

	mBar = new JMenuBar();
	mMaster = new JMenu("Master Entry   ");
	mMaster.setMnemonic('M');
	mTranscition = new JMenu("Transcition Entry   ");
	mTranscition.setMnemonic('T');
	mReport = new JMenu("Report     ");
	mReport.setMnemonic('R');
	mHelp = new JMenu("Help       ");
	mHelp.setMnemonic('H');
	mExit = new JMenu("Exit       ");
	mExit.setMnemonic('X');
	mAbout = new JMenu("About     ");
	mTools=new JMenu("Tools       ");
	mTools.setMnemonic('O');
	
	miProduct_master = new JMenuItem("Product_master");
	miProduct_category = new JMenuItem("Registration_master");
	miRegistration_master = new JMenuItem("Registration_master");
	miRetailer_master = new JMenuItem("Retailer_master Master");
	miStaff_master = new JMenuItem("Staff_master Master");
	

	miProduct_distribution = new JMenuItem("Product_distribution");
	miPayment = new JMenuItem("Payment");
	miReturn = new JMenuItem("Return");
	//miFamily = new JMenuItem("Family Master");
	//miSchool = new JMenuItem("School Master");
	//miEducation = new JMenuItem("Education Master");
	

	miDeveloper = new JMenuItem("Developer");
	miSoftware = new JMenuItem("Software");
	miYes = new JMenuItem("Yes");
	miNo = new JMenuItem("No");
	miDocu = new JMenuItem("Documentation");
	mibakup=new JMenuItem("BackUp");
	mirestore=new JMenuItem("Restore");
	michngpasswd=new JMenuItem("Change Password");
	micreateusr=new JMenuItem("Manage User");

	rProduct_master = new JMenuItem("Product_master Master Report");
	rRegistration_master = new JMenuItem("Registration_master Master Report");
	rRetailer_master = new JMenuItem("Retailer_master Master Report");
	rStaff_master = new JMenuItem("Staff_master Master Report");

	rProduct_distribution = new JMenuItem("Product_distribution Master Report");
	rPayment = new JMenuItem("Payment Master Report");
	rReturn = new JMenuItem("Return Information Master Report");
	rFamily = new JMenuItem("Family Information Master Report");
	rSchool = new JMenuItem("School Information Master Report");
	rEducation = new JMenuItem("Education Master Report");

	
	
	mMaster.add(miProduct_category);
	mMaster.add(miProduct_master);
	mMaster.add(miRegistration_master);
	mMaster.add(miRetailer_master);
	mMaster.add(miStaff_master);

	mTranscition.add(miProduct_distribution);
	mTranscition.add(miReturn);
	//mTranscition.add(miFamily);
	mTranscition.add(miPayment);
	//mTranscition.add(miSchool);
	//mTranscition.add(miEducation);


	mHelp.add(mAbout);
	mAbout.add(miSoftware);
	mAbout.add(miDeveloper);
	mHelp.add(miDocu);

	mExit.add(miYes);
	//mExit.add(miNo);
	mTools.add(mibakup);
	mTools.add(mirestore);
	mTools.add(micreateusr);
	mTools.add(michngpasswd);
	//micreateusr.addMnemonic(KeyStroke.V_K);

	setJMenuBar(mBar);
	mBar.add(mMaster);
	mBar.add(mTranscition);
	mBar.add(mReport);
	mBar.add(mTools);
	mBar.add(mHelp);
	mBar.add(mExit);
	
	mReport.add(rProduct_master);
	mReport.add(rRegistration_master);
	mReport.add(rRetailer_master);
	mReport.add(rStaff_master);
	mReport.add(rProduct_distribution);
	mReport.add(rReturn);
	mReport.add(rFamily);
	mReport.add(rPayment);
	mReport.add(rSchool);
	mReport.add(rEducation);

	mBar.setBackground(new Color(140,251,250));
	
	/*miProduct_master.addActionListener(new menuListener());
	mi Product_category.addActionListener(new menuListener());
	miRegistration_master.addActionListener(new menuListener());
	miRetailer_master.addActionListener(new menuListener());
	miStaff_master.addActionListener(new menuListener());
	miProduct_distribution.addActionListener(new menuListener());
	miPayment.addActionListener(new menuListener());
	miReturn.addActionListener(new menuListener());
	miFamily.addActionListener(new menuListener());
	miSchool.addActionListener(new menuListener());
	miEducation.addActionListener(new menuListener());

	miSoftware.addActionListener(new menuListener());
	miDeveloper.addActionListener(new menuListener());
	miYes.addActionListener(new menuListener());
	mibakup.addActionListener(new menuListener());
	mirestore.addActionListener(new menuListener());
	michngpasswd.addActionListener(new menuListener());
	micreateusr.addActionListener(new menuListener());
//	mExit.addActionListener(new menuListener());

	rProduct_master.addActionListener(new reportListener());
	rRegistration_master.addActionListener(new reportListener());
	rRetailer_master.addActionListener(new reportListener());
	rStaff_master.addActionListener(new reportListener());
	rProduct_distribution.addActionListener(new reportListener());
	rPayment.addActionListener(new reportListener());
	rReturn.addActionListener(new reportListener());
	rFamily.addActionListener(new reportListener());
	rSchool.addActionListener(new reportListener());
	rEducation.addActionListener(new reportListener());
	*/
	if(usrtype.equalsIgnoreCase("Ravi"))
	mMaster.setEnabled(false);
	else if(usrtype.equalsIgnoreCase("Guest"))
	{
		mMaster.setEnabled(false);
		mTranscition.setEnabled(false);
	}
	setSize(800,650);
	setLocation(100,30);
	setResizable(false);
	setVisible(true);
    }

private class menuListener implements ActionListener
  {
  public void actionPerformed(ActionEvent e)
    {
      if(e.getSource()==miProduct_master)
       {
        // Product_master_Details sm = new Product_master_Details();
       }
      if(e.getSource()==miProduct_category)
       {
        //  Product_category_Details dm = new  Product_category_Details();
       }
      if(e.getSource()==miRegistration_master)
       {
        // Registration_master_Details bm = new Registration_master_Details();
       }
      if(e.getSource()==miRetailer_master)
       {
        // Retailer_master_Details pm = new Retailer_master_Details();
       }
      if(e.getSource()==miStaff_master)
       {
        // Staff_master_Details vm = new Staff_master_Details();
       }
      if(e.getSource()==miProduct_distribution)
       {
        // Product_distribution_Details ppm = new Product_distribution_Details();
       }
      if(e.getSource()==miPayment)
       {
        // Payment_info lnm = new Payment_info();
       }
      if(e.getSource()==miReturn)
       {
       //  Return_Information hsm = new Return_Information();
       }
      //if(e.getSource()==miFamily)
      // {
       //  Family_Details rdw = new Family_Details();
      // }
      //if(e.getSource()==miSchool)
      // {
        // School_Details rlw = new School_Details();
      // }
      //if(e.getSource()==miEducation)
      // {
        // Education_Details wtw = new Education_Details();
      // }
      
      if(e.getSource()==miSoftware)
      {
       //  aboutSoftware abs = new aboutSoftware();
       }
      if(e.getSource()==miDeveloper)
       {
        // aboutDeveloper abd = new aboutDeveloper();
       }
      if(e.getSource()==miYes)
       {
         int n = JOptionPane.showConfirmDialog(null, "Would you really want to EXIT","Confirmation",
		                                              JOptionPane.YES_NO_OPTION);
         if (n == JOptionPane.YES_OPTION) 
	    System.exit(0);			 
       }
       if(e.getSource()==mibakup)
       {
       }
       if(e.getSource()==mirestore)
       {
       }
       if(e.getSource()==michngpasswd)
       {
       		//new ChangePasswd(usrtype);
       }
       if(e.getSource()==micreateusr)
       {
       	//	new CreateUser(usrtype);
       }
     }
   }

private class reportListener implements ActionListener
  {
  public void actionPerformed(ActionEvent e)
    {
      if(e.getSource()==rProduct_master)
       {
        // new   Product_category_wise_Product_master();
       }
      if(e.getSource()==rRegistration_master)
       {
       // new   Product_category_wise_Registration_master();
       }
      if(e.getSource()==rRetailer_master)
       {
        // new  Registration_master_wise_Retailer_master_Report();
       }
      if(e.getSource()==rStaff_master)
       {
       // new  Retailer_master_wise_Staff_master_Report();
       }
      if(e.getSource()==rProduct_distribution)
       {
       //  new  Staff_master_wise_Product_distribution_Report();
       }
      if(e.getSource()==rPayment)
       {
       //  new Return_Payment_Information_Report();
       }
      if(e.getSource()==rReturn)
       {
       // new  Staff_master_wise_ReturnInformation_Report();
       }
      if(e.getSource()==rFamily)
       {
        // new Staff_master_wise_FamilyInformation_Report();
       }
      if(e.getSource()==rSchool)
       {
        // new Staff_master_wise_School_Report();
       }
       if(e.getSource()==rEducation)
       {
        // new Staff_master_wise_Education_Report();
       }
      
     }
   }
   
   private class timerListener implements ActionListener
   {
   public void actionPerformed(ActionEvent e)
   {	
   		
   		rn.setLocation(r,400);
   			r=r+20;
   			if(r>=750)
   			r=0;

   	}
   
   	
   }
  // void play(String url,String nm)
   //{
   //}


  public static void main(String args[])
    {
//	Thread firstThread=new Thread(new Menu_Page());
	//firstThread.setDeamon(true);
	new Menu_Page("Arcade");
    }
  }
