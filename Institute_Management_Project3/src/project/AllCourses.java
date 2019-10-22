package project;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class AllCourses extends JFrame{

	JLabel title;
	JButton close,mini;
	JPanel container,titlebar,courseContainer,subContainer,contain_all_Course,inner_contain_all_Course;
	JPanel innerCourse;
	JButton down;
	
	static Thread th;
	Thread downth;
	
	int width, height;
	
	CardLayout clayout = new CardLayout();
	private Point initialClick;
	
	public AllCourses()
	{
		setUndecorated(true);
		setVisible(true);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		width = (int) toolkit.getScreenSize().getWidth()-20;
		height = (int) toolkit.getScreenSize().getHeight()-60;
		
		setSize(width,height);
		setLocationRelativeTo(null);
		setLayout(null);
		
		container = new JPanel();
		container.setBounds(0,0,width,height);
		container.setLayout(null);
		container.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(20,66,125)));
		container.setBackground(new Color(255,255,255));
		container.setFocusable(true);
		
		subContainer = new JPanel();
		subContainer.setBounds(2,35,width-4,height-35);
		subContainer.setLayout(null);
	//	subContainer.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.green));
		subContainer.setBackground(Color.white);
		subContainer.setFocusable(true);

		JLabel cbgimgofcac = new JLabel();
		cbgimgofcac.setBounds(0,0,width-4,height-35);
		ImageIcon bgimgofcac = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\wonderful-wallpapers-42.jpg");
		Image bgimgofcac1 = bgimgofcac.getImage();
		Image bgimgofcac2 = bgimgofcac1.getScaledInstance(cbgimgofcac.getWidth(),cbgimgofcac.getHeight(),Image.SCALE_SMOOTH);
		
		ImageIcon i2 = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\pexels-photo-269825.jpeg");
		Image i22 = i2.getImage();
		Image i222 = i22.getScaledInstance(cbgimgofcac.getWidth(),cbgimgofcac.getHeight(),Image.SCALE_SMOOTH);
		
		ImageIcon i3 = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\pexels-photo-207247.jpeg");
		Image i33 = i3.getImage();
		Image i333 = i33.getScaledInstance(cbgimgofcac.getWidth(),cbgimgofcac.getHeight(),Image.SCALE_SMOOTH);
		
		contain_all_Course = new JPanel();
		contain_all_Course.setBounds(2,height,width-4,height-35);
		contain_all_Course.setLayout(null);
		//contain_all_Course.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.green));
		contain_all_Course.setBackground(new Color(50,50,50));
		
		
		inner_contain_all_Course = new JPanel();
		inner_contain_all_Course.setBounds(0,0,width-4,height-35);
		inner_contain_all_Course.setLayout(clayout);
		inner_contain_all_Course.setBackground(new Color(0,0,0));
		
		
		
//		673
//		1342
//		System.out.println(inner_contain_all_Course.getHeight());
//		System.out.println(inner_contain_all_Course.getWidth());
		contain_all_Course.add(inner_contain_all_Course);
	//	contain_all_Course.add(cbgimgofcac);
		
		JPanel clist1 = new JPanel();
		clist1.setLayout(null);
		clist1.setBackground(Color.white);
		
		JLabel bgimg = new JLabel(new ImageIcon(bgimgofcac2));
		bgimg.setBounds(0, 0, 1342, 673);
		
		JLabel cifa = new JLabel("<html><body><h1 style='text-align:right;font-size:35px;color:black;'>Cerficate in Financial<br>Accounting</h1>"
				+ "<p style='text-align:right;font-size:20px;'>Duration : 3 Months</p>"
				+ "</body></html>");
		cifa.setBounds(0,0,1332,180);
	//	cifa.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.green));
		cifa.setHorizontalAlignment(JLabel.RIGHT);
		
		JLabel te = new JLabel("<html><body><p style='text-align:center;padding:10px 0 0 0;font-size:20px;font-family:Arial;background:black;color:white;'>TALLY ERP 9.0</p>"
				+ "<ul style='text-align:left;font-size:15px;font-family:sans-serif;color:black'>"
				+ "<li>Computer Account Creation</li>"
				+ "<li>Group Acounts</li>"
				+ "<li>Backup & Restore</li>"
				+ "<li>Ledger</li>"
				+ "<li>Cost Category Center</li>"
				+ "<li>Stock Inventory</li>"
				+ "<li>Payroll</li>"
				+ "<li>CST / VAT / TDS TCS</li>"
				+ "<li>Balance Sheets</li>"
				+ "</ul>"
				+ "</body></html>");
		te.setBounds(1014,250,318,300);
		te.setBackground(Color.black);
		te.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0,0,0,50)));
		
		
		JLabel bca = new JLabel("<html><body><p style='text-align:center;padding:10px 0 0 0;font-size:20px;font-family:Arial;background:black;color:white;'>BASIC COMPUTER APPLICATION</p>"
				+ "<ul style='text-align:left;font-size:15px;font-family:sans-serif;color:black;'>"
				+ "<li>Ms PAINT</li>"
				+ "<li>Notepad</li>"
				+ "<li>Wordpad</li>"
				+ "<li>Ms Word</li>"
				+ "<li>Ms Excel</li>"
				+ "<li>Ms Power Point</li>"
				+ "<li>Internet Explorer</li>"
				+ "</ul>"
				+ "</body></html>");
		bca.setBounds(642,250,318,265);
		bca.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0,0,0,50)));
		bca.setBackground(Color.black);
		
		JButton nextclist1 = new JButton("<html><body>&#9002;</body></html>");
		nextclist1.setBounds(1252,633,80,30);
		nextclist1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		nextclist1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clayout.next(inner_contain_all_Course);
				
			}
			
		});
		
		
		clist1.add(nextclist1);
		clist1.add(cifa);
		clist1.add(te);
		clist1.add(bca);
		clist1.add(bgimg);
		
		JPanel clist2 = new JPanel();
		clist2.setLayout(null);
		clist2.setBackground(Color.blue);
		
		JLabel bgimg2 = new JLabel(new ImageIcon(i222));
		bgimg2.setBounds(0, 0, 1342, 673);
		
		JLabel dica = new JLabel("<html><body><h1 style='text-align:center;font-size:50px;color:black;'>DICA</h1></body></html>");
		dica.setBounds(10,0,170,80);
		
		JLabel dicafull = new JLabel("<html><body><h1 style='text-align:right;font-size:22px;color:black;padding:10px;background:green;'>Diploma in Integrated Computer Application</h1>"
				+ "<p style='text-align:right;font-size:20px;color:white'>Duration : 1 Months</p>"
				+ "</body></html>");
		dicafull.setBounds(560,0,772,130);
		dicafull.setHorizontalAlignment(JLabel.RIGHT);
		
		JLabel itad = new JLabel("<html><body><p style='width:350px;text-align:center;padding:10px;font-size:18px;font-family:Arial;background:black;color:white;'>Information Technology and Database</p>"
				+ "<ul style='text-align:left;font-size:15px;font-family:sans-serif;color:black;'>"
				+ "<li>Computer Fundamentals</li>"
				+ "<li>computer architecture</li>"
				+ "<li>Operating System</li>"
				+ "<li>(Ms word)</li>"
				+ "<li>(Ms Excel)</li>"
				+ "<li>(Ms Power Point)</li>"
				+ "<li>Data Base Operation with (Ms Access)</li>"
				+ "</ul>"
				+ "</body></html>");
		itad.setBounds(10,100,453,245);
		itad.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0,0,0,50)));
		
		JLabel mad = new JLabel("<html><body><p style='width:380px;text-align:center;padding:10px;font-size:18px;font-family:Arial;background:black;color:white;'>Multimedia Animation & Design</p>"
				+ "<ul style='text-align:left;font-size:15px;font-family:sans-serif;color:black;'>"
				+ "<li>Elements of Design</li>"
				+ "<li>Composition and Layout</li>"
				+ "<li>Digital Printing</li>"
				+ "<li>Collage Making</li>"
				+ "<li>Adv & Brochure Designing</li>"
				+ "<li>Preparing art work for print</li>"
				+ "</ul>"
				+ "</body></html>");
		mad.setBounds(473,100,453,235);
		mad.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0,0,0,50)));
		
		JLabel ea = new JLabel("<html><body><p style='width:380px;text-align:center;padding:10px;font-size:18px;font-family:Arial;background:black;color:white;'>E-Accounting</p>"
				+ "<ul style='text-align:left;font-size:15px;font-family:sans-serif;color:black;'>"
				+ "<li>Tally 9.0 with ERP</li>"
				+ "<li>Account Fundamental</li>"
				+ "<li>Stock Group Categories, Measure</li>"
				+ "<li>Introduction to Vat</li>"
				+ "<li>TDS (Tax Deducted at Source)</li>"
				+ "<li>Service Tax</li>"
				+ "<li>Balance sheet</li>"
				+ "<li>Depreciation</li>"
				+ "<li>Profit & Loss</li>"
				+ "</ul>"
				+ "</body></html>");
		ea.setBounds(10,365,453,295);
		ea.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0,0,0,50)));
		
		JLabel hw = new JLabel("<html><body><p style='width:380px;text-align:center;padding:10px;font-size:18px;font-family:Arial;background:black;color:white;'>Hardware</p>"
				+ "<ul style='text-align:left;font-size:15px;font-family:sans-serif;color:black;'>"
				+ "<li>Fundamental of Computer Hardware</li>"
				+ "<li>Assembling & Dissembling</li>"
				+ "<li>Trouble shooting</li>"
				+ "<li>Introduction of Electronic<br>(Analog & Digital)</li>"
				+ "<li>Introduction & Checking of Electronic Component</li>"
				+ "<li>Introduction & User of Multi meter</li>"
				+ "<li>Soldering & Desoldering</li>"
				+ "</ul>"
				+ "</body></html>");
		hw.setBounds(473,365,453,295);
		hw.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0,0,0,50)));
		
		JButton preclist2 = new JButton("<html><body>&#9001;</body></html>");
		preclist2.setBounds(1252-80,633,80,30);
		preclist2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		preclist2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clayout.previous(inner_contain_all_Course);
				
			}
			
		});
		
		JButton nextclist2 = new JButton("<html><body>&#9002;</body></html>");
		nextclist2.setBounds(1252,633,80,30);
		nextclist2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		nextclist2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clayout.next(inner_contain_all_Course);
				
			}
			
		});
		
		clist2.add(preclist2);
		clist2.add(nextclist2);
		clist2.add(dica);
		clist2.add(dicafull);
		clist2.add(itad);
		clist2.add(mad);
		clist2.add(ea);
		clist2.add(hw);
		clist2.add(bgimg2);
		
		JPanel clist3 = new JPanel();
		clist3.setBackground(Color.green);
		clist3.setLayout(null);
		
		JLabel bgimg3 = new JLabel(new ImageIcon(i333));
		bgimg3.setBounds(0, 0, 1342, 673);
		
		JLabel dcap = new JLabel("<html><body><h1 style='text-align:center;font-size:50px;color:darkcyan;'>DCAP</h1></body></html>");
		dcap.setBounds(10,0,190,80);
		
		JLabel dcapfull = new JLabel("<html><body><h1 style='text-align:right;font-size:22px;color:black;padding:10px;background:yellow;'>Diploma in Computer Application & Programming</h1>"
				+ "<p style='text-align:right;font-size:20px;color:black'>Duration : 1 Months</p>"
				+ "</body></html>");
		dcapfull.setBounds(560,0,772,130);
		dcapfull.setHorizontalAlignment(JLabel.RIGHT);
		
		JLabel itad2 = new JLabel("<html><body><p style='width:350px;text-align:center;padding:10px;font-size:18px;font-family:Arial;background:black;color:white;'>Information Technology and Database</p>"
				+ "<ul style='text-align:left;font-size:15px;font-family:sans-serif;color:black;'>"
				+ "<li>Computer Fundamentals</li>"
				+ "<li>computer architecture</li>"
				+ "<li>Operating System</li>"
				+ "<li>(Ms word)</li>"
				+ "<li>(Ms Excel)</li>"
				+ "<li>(Ms Power Point)</li>"
				+ "<li>Data Base Operation with (Ms Access)</li>"
				+ "</ul>"
				+ "</body></html>");
		itad2.setBounds(10,100,453,245);
		itad2.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0,0,0,50)));
		
		JLabel ntawa = new JLabel("<html><body><p style='width:350px;text-align:center;padding:10px;font-size:18px;font-family:Arial;background:black;color:white;'>Network Technology and Web Application</p>"
				+ "<ul style='text-align:left;font-size:15px;font-family:sans-serif;color:black;'>"
				+ "<li>Introduction to Internet</li>"
				+ "<li>OSI and TCP/IP Model</li>"
				+ "<li>Internet Protocals</li>"
				+ "<li>Electronic Mail</li>"
				+ "<li>Current Trends on Internet</li>"
				+ "<li>Web Publishing and Browsing</li>"
				+ "<li>Scripting</li>"
				+ "<li>Interactivity Tools</li>"
				+ "<li>Internet Security Management Concepts</li>"
				+ "</ul>"
				+ "</body></html>");
		ntawa.setBounds(473,100,413,330);
		ntawa.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0,0,0,50)));
		
		JLabel ppstcl = new JLabel("<html><body><p style='width:343px;text-align:center;padding:10px;font-size:15px;font-family:Arial;background:black;color:white;'>Programming & Problem Solving through<br>'C' Language</p>"
				+ "<ul style='text-align:left;font-size:15px;font-family:sans-serif;color:black;'>"
				+ "<li>Introduction to Programming</li>"
				+ "<li>Algorithms and flow chart for problem solving</li>"
				+ "<li>Introduction to 'C' Languange</li>"
				+ "<li>Decision and condition statement</li>"
				+ "<li>Array</li>"
				+ "<li>Function</li>"
				+ "<li>Strorage Classes</li>"
				+ "<li>Structure and Unions</li>"
				+ "<li>Pointer</li>"
				+ "<li>Linked Lists</li>"
				+ "<li>File Processing</li>"
				+ "</ul>"
				+ "</body></html>");
		ppstcl.setBounds(900,245,425,390);
		ppstcl.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0,0,0,50)));
		
		JLabel mad2 = new JLabel("<html><body><p style='width:380px;text-align:center;padding:10px;font-size:18px;font-family:Arial;background:black;color:white;'>Multimedia Animation & Design</p>"
				+ "<ul style='text-align:left;font-size:15px;font-family:sans-serif;color:black;'>"
				+ "<li>Elements of Design</li>"
				+ "<li>Composition and Layout</li>"
				+ "<li>Digital Printing</li>"
				+ "<li>Collage Making</li>"
				+ "<li>Adv & Brochure Designing</li>"
				+ "<li>Preparing art work for print</li>"
				+ "</ul>"
				+ "</body></html>");
		//mad2.setBounds(473,365,453,295);
		mad2.setBounds(10,365,453,235);
		mad2.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0,0,0,50)));
		

		
		JButton preclist3 = new JButton("<html><body>&#9001;</body></html>");
		preclist3.setBounds(1252-80,633,80,30);
		preclist3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		preclist3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clayout.previous(inner_contain_all_Course);
				
			}
			
		});
		
		JButton nextclist3 = new JButton("<html><body>&#9002;</body></html>");
		nextclist3.setBounds(1252,633,80,30);
		nextclist3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		nextclist3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clayout.next(inner_contain_all_Course);
				
			}
			
		});
		
		
		clist3.add(dcap);
		clist3.add(dcapfull);
		clist3.add(itad2);
		clist3.add(ntawa);
		clist3.add(ppstcl);
		clist3.add(mad2);
		clist3.add(preclist3);
		clist3.add(nextclist3);
		clist3.add(bgimg3);
		
		inner_contain_all_Course.add(clist1);
		inner_contain_all_Course.add(clist2);
		inner_contain_all_Course.add(clist3);
		
		
		down = new JButton("down");
		down.setBounds(width-100,height-100,80,30);
		down.setBackground(new Color(255,250,250));
		down.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
					
				TopDown downObj = new TopDown();
				
				downth = new Thread(downObj);
				downth.start();
				
				
			}
			
		});
	
		
		titlebar = new JPanel();
		titlebar.setBounds(0,0,width,35);
		titlebar.setBackground(new Color(20,66,125));
		titlebar.setLayout(null);
		
		title = new JLabel("<html><font size=5>C</font>ourse</html>");
		title.setBounds(0,0,1296,35);
		title.setBackground(Color.red);
		title.setForeground(new Color(255,255,255));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("Dialog",Font.BOLD,15));
		titlebar.add(title);
	

		addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e)
			{
				initialClick = e.getPoint();
				getComponentAt(initialClick);
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {
			
			public void mouseDragged(MouseEvent e)
			{
				//get location of window
				int thisX = getLocation().x;
				int thisY = getLocation().y;
				
				//Determine how much the mouse moved since
				int xMoved = e.getX() - initialClick.x;
				int yMoved = e.getY() - initialClick.y;
				
				//Move window to this position
				int X = thisX + xMoved;
				int Y = thisY + yMoved;
				setLocation(X,Y);
				
				
			}
		});
		
		mini = new JButton("<html>&minus</html>");
		mini.setBounds(1276,0,35,35);
		mini.setBackground(new Color(20,66,125));
		mini.setBorder(BorderFactory.createEmptyBorder());
		mini.setForeground(Color.white);
		mini.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				setState(JFrame.ICONIFIED);
			}
		});
		
		close = new JButton("<html>X</html>");
		close.setBounds(1311,0,35,35);
		close.setBackground(new Color(20,66,125));
		close.setBorder(BorderFactory.createEmptyBorder());
		close.setForeground(Color.white);
		close.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				//System.exit(0);
				setVisible(false);
				Project.jf.setVisible(true);
			}
			
			public void mouseEntered(MouseEvent e)
			{
				close.setBackground(new Color(177,14,14));
			}
			public void mouseExited(MouseEvent e)
			{
				close.setBackground(new Color(20,66,125));
				
			}
			
			
		});

		titlebar.add(mini);
		titlebar.add(close);
		
		container.add(titlebar);
		add(container);
		//System.out.println(container.getWidth());
		
		courseContainer = new JPanel();
		courseContainer.setBounds(173,200,1000,300);
		courseContainer.setBackground(new Color(14,81,0,80));
		courseContainer.setLayout(null);
	
		
		JLabel bgimage = new JLabel();
		bgimage.setBounds(0,0,1000,300);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\imageBack.jpg");
		Image img = icon.getImage();
		Image image = img.getScaledInstance(bgimage.getWidth(), bgimage.getHeight(), Image.SCALE_SMOOTH);
		
		bgimage.setIcon(new ImageIcon(image));
	
		
		innerCourse = new JPanel();
		innerCourse.setBounds(0,0,4000,300);
		innerCourse.setLayout(null);
		innerCourse.setBackground(new Color(255,255,255,170));
		
		
		
		JLabel c1 = new JLabel("<html><body width=1000><div style='margin-left:200px;font-size:20px;color:rgb(129,20,20);'><h1 style='font-size:30px;color:rgb(0,187,212);'>ADCE</h1><p>Advance Diploma In Computer Engineer</p></div></body></html>");
		c1.setForeground(Color.white);
		c1.setBounds(0,0,1000,300);
		c1.setBorder(BorderFactory.createMatteBorder(0,0,0,0,new Color(0,0,0,200)));
		
		JLabel c2 = new JLabel("<html><body width=1000><div style='margin-left:200px;font-size:20px;color:rgb(0,198,247);'><h1 style='font-size:30px;color:rgb(0,187,212);'>MDCE</h1><p>Master Diploma In Computer Engineer</p></div></body></html>");
		c2.setForeground(Color.white);
		c2.setBounds(1000,0,1000,300);
		c2.setBorder(BorderFactory.createMatteBorder(0,0,0,0,new Color(0,198,247)));
		
		JLabel c3 = new JLabel("<html><body width=1000><div style='margin-left:200px;font-size:20px;color:rgb(213,0,80);'><h1 style='font-size:30px;color:rgb(0,187,212);'>Multimedia</h1><p></p></div></body></html>");
		c3.setForeground(Color.white);
		c3.setBounds(2000,0,1000,300);
		c3.setBorder(BorderFactory.createMatteBorder(0,0,0,0,new Color(213,0,80)));
		
		JLabel c4 = new JLabel("<html><body width=1000><div style='margin-left:200px;font-size:20px;color:rgb(227,59,92);'><h1 style='font-size:30px;color:rgb(0,187,212);'>Web Design</h1><p></p></div></body></html>");
		c4.setForeground(Color.white);
		c4.setBounds(3000,0,1000,300);
		c4.setBorder(BorderFactory.createMatteBorder(0,0,0,0,new Color(227,59,92)));
		
		
		
		innerCourse.add(c1);
		innerCourse.add(c2);
		innerCourse.add(c3);
		innerCourse.add(c4);
		
		courseContainer.add(innerCourse);
		courseContainer.add(bgimage);
		subContainer.add(down);
		
		subContainer.add(courseContainer);
	
		container.add(subContainer);
		
		
		
		
		
		container.add(contain_all_Course);
		animation();
	}
	
	class Th implements Runnable
	{
		
		public void run()
		{
			int i=0,j=0;
			while(i<3000)
			{
				try
				{
					th.sleep(2);
					innerCourse.setBounds(-i,0,4000,300);
					i++;
					j++;
					if(j == 150)
					{
						innerCourse.setBackground(new Color((int) (Math.random()*100),(int) (Math.random()*100),(int) (Math.random()*100),j));
						
						j=0;
					}
					
				}
				catch(Exception e) {}
				
			}
			run();
			
		}
		
	
	}
	
	class TopDown implements Runnable
	{
		public void run()
		{
			int h = height-35;
			int t = 35;
			while(t < h)
			{
				try
				{
					downth.sleep(1);
					subContainer.setBounds(2,-t,width-4,height-35);
					contain_all_Course.setBounds(2,height-t,width-4,height-35);
				
				}
				catch(Exception e) {}
				
				t++;
			}
		}
			
		
	}
	
	public void animation()
	{
		try
		{
			th = new Thread(new Th());
			th.start();
		}
		catch(Exception e) {}
			
	}	
	
	public static AllCourses getAllCourses()
	{
		return new AllCourses();
	}
	
				
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			
			public void run()
			{
				new AllCourses();
				
			}
		});
	}

}
