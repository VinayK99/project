package project;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.FileDialog;

import javax.swing.*;


public class Project implements MouseListener{

	 static JFrame jf;
	private final Toolkit toolkit;
	private final int JfWidth;
	private final int JfHeight;
	  JPanel menubar;
	private final JButton menuIcon;
	 JPanel sidebar;
	private final JPanel mainContainer;
	private final JPanel child1;
	private final JPanel child2;
	private final JPanel child3;
	private final JPanel child4;
	private final JPanel child5;
	
	private Thread thread;
	 int AlignLeft=250;
	private final CardLayout cLayout = new CardLayout();
	static CardLayout ItemsCLaout = new CardLayout();
	
	static JLabel userPic;
	private final JPanel containUserPic;
	static JLabel fLetter;
	static JLabel userName;
	
	static JPanel containMenuItems;
	private final JPanel studentMenuItems;
	private final JPanel adminMenuItems;
	String path = null;
	
	LoginForm login = LoginForm.getLoginForm();
	JButton LogoutB,LoginB;
	JButton IICSLOBO;
	JLabel iicsname;
	
	public Project() {
	
		jf = new JFrame("Project");
		jf.setVisible(true);
		jf.setLayout(null);
		
		toolkit = Toolkit.getDefaultToolkit();
		JfWidth = (int) toolkit.getScreenSize().getWidth();
		JfHeight = (int) toolkit.getScreenSize().getHeight()-30;
		
		jf.setSize(JfWidth, JfHeight);

				
		menubar = new JPanel();
		menubar.setBounds(0,0,JfWidth,50);
		menubar.setBackground(new Color(53,53,53));
		menubar.setLayout(null);
		
		menuIcon = new JButton("<html><body><font size=5>&#9776;</body></html>"); 
		menuIcon.setBounds(8,7,50,36);
		menuIcon.setBorder(BorderFactory.createEmptyBorder());
		menuIcon.setBackground(new Color(13,58,247));
		menuIcon.setForeground(Color.white);
		menuIcon.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

				
				thread = new Thread(new Transition());
				thread.start();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				menuIcon.setBorder(BorderFactory.createLineBorder(Color.white));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				menuIcon.setBorder(BorderFactory.createEmptyBorder());
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		IICSLOBO = new JButton();
		IICSLOBO.setBounds(600,7,120,36);
		IICSLOBO.setBackground(new Color(255,255,255));
	//	IICSLOBO.setBorder(BorderFactory.createLineBorder(Color.red));
		IICSLOBO.setForeground(Color.white);
		ImageIcon iicsimag = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\logo_29668.png");
		Image iicsimag1 = iicsimag.getImage();
		Image iicsimag2 = iicsimag1.getScaledInstance(IICSLOBO.getWidth(), IICSLOBO.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon iicsimag3 = new ImageIcon(iicsimag2);
		IICSLOBO.setIcon(iicsimag3);
		
//		iicsname = new JLabel("<html><body><font size=15>I</font>ndia Institute Of Computer Science</body></html>");
//		iicsname.setBounds(300,7,500,36);
//		iicsname.setForeground(Color.white);
		
		LoginB = new JButton("Login");
		LoginB.setBounds(1260,7,88,36);
		LoginB.setBackground(new Color(53,53,53));
		LoginB.setForeground(Color.white);
		LoginB.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		LoginB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(userName.getText().equals(""))
				{
					LoginB.setBorder(BorderFactory.createRaisedBevelBorder());
					login.setVisible(true);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You have an already Login","Login",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		
		LogoutB = new JButton("Logout");
		LogoutB.setBounds(1170,7,88,36);
		LogoutB.setBackground(new Color(53,53,53));
		LogoutB.setForeground(Color.white);
		LogoutB.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		LogoutB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!userName.getText().equals(""))
				{
					
					ImageIcon userpicpath = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\avatar2.png");
					Image getpic1 = userpicpath.getImage();
					Image resizepic = getpic1.getScaledInstance(userPic.getWidth(), userPic.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon userpic = new ImageIcon(resizepic);
					userPic.setIcon(userpic);
					
					fLetter.setText("");
					userName.setText("");
					
					ItemsCLaout.show(containMenuItems,"sitems");
					
				}
				else
				{
					
				}
			}
			
		});
		
		
		menubar.add(menuIcon);
		menubar.add(IICSLOBO);
		menubar.add(LogoutB);
		menubar.add(LoginB);
		
		
		sidebar = new JPanel();
		sidebar.setBounds(-AlignLeft,50,250,JfHeight-50);
		sidebar.setBackground(new Color(53,53,53));
		sidebar.setLayout(null);
		
		containUserPic = new JPanel();
		//containUserPic.setBorder(BorderFactory.createLineBorder(Color.red));
		containUserPic.setBounds(0,0,250,160);
		containUserPic.setBackground(new Color(53,53,53));
		containUserPic.setLayout(null);
		
		userPic = new JLabel();
		userPic.setBounds(10,10,100,100);
		userPic.setBorder(BorderFactory.createLineBorder(Color.red));
		
		JPopupMenu popuppic = new JPopupMenu();
		popuppic.setBackground(new Color(255,255,255));
		JMenuItem change = new JMenuItem("Change Image");
		change.setBorder(BorderFactory.createEmptyBorder());
		change.setBackground(new Color(255,255,255));
		change.setForeground(new Color(41,46,52));
		
		popuppic.add(change);
		
		userPic.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				if(userName.getText().equals(""))
				{
					login.setVisible(true);
				}
				else
				{
					popuppic.show(e.getComponent(),e.getX(),e.getY());
				}
			}
			
		});
		
		change.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				FileDialog f = new FileDialog(jf);
				f.show();
				path = f.getDirectory()+f.getFile();
				System.out.println(path);
				
				if(path != null)
				{
					boolean pic = StudentsDB.updatePic(path);
					
					if(pic == true)
					{
						ImageIcon userpic = StudentsDB.getuserPic();
						Image img2 = userpic.getImage();
						Image img3 = img2.getScaledInstance(userPic.getWidth(),userPic.getHeight(),Image.SCALE_SMOOTH);
						
						userPic.setIcon(new ImageIcon(img3));
						
					}
				}
			}
				
			
			
		});
		
//		userPic.addMouseListener(new MouseAdapter() {
//				
//			public void mouseClicked(MouseEvent e)
//			{
//				FileDialog f = new FileDialog(jf);
//				f.show();
//				path = f.getDirectory()+f.getFile();
//				System.out.println(path);
//				
//				if(path != null)
//				{
//					boolean pic = StudentsDB.updatePic(path);
//					
//					if(pic == true)
//					{
//						ImageIcon userpic = StudentsDB.getuserPic();
//						Image img2 = userpic.getImage();
//						Image img3 = img2.getScaledInstance(userPic.getWidth(),userPic.getHeight(),Image.SCALE_SMOOTH);
//						
//						userPic.setIcon(new ImageIcon(img3));
//						
//					}
//				}
//			}
//			
//		});
//	
		ImageIcon userpicpath = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\avatar2.png");
		Image getpic1 = userpicpath.getImage();
		Image resizepic = getpic1.getScaledInstance(userPic.getWidth(), userPic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon userpic = new ImageIcon(resizepic);
		userPic.setIcon(userpic);
		
		userPic.addMouseListener(this);
		userPic.setName("userPic");
		
		fLetter = new JLabel();
		fLetter.setBounds(210,10,30,30);
		fLetter.setForeground(Color.white);
		fLetter.setHorizontalAlignment(SwingConstants.CENTER);
		fLetter.setBorder(BorderFactory.createLineBorder(Color.red));
		fLetter.setFont(new Font("sans-seri",Font.BOLD,18));
		
		userName = new JLabel();
		userName.setBounds(10,120,230,30);
		userName.setForeground(Color.white);
		userName.setFont(new Font("sans-seri",Font.BOLD,17));
		userName.setHorizontalAlignment(SwingConstants.LEFT);
		userName.setBorder(BorderFactory.createLineBorder(Color.red));
	
		
		
		containUserPic.add(userPic);
		containUserPic.add(fLetter);
		containUserPic.add(userName);
		
		
		containMenuItems = new JPanel();
		containMenuItems.setBounds(0,170,250,JfHeight-50-150);
		//containMenuItems.setBorder(BorderFactory.createLineBorder(Color.red));
		containMenuItems.setLayout(ItemsCLaout);
		
		studentMenuItems = new JPanel();
		//studentMenuItems.setBorder(BorderFactory.createLineBorder(Color.blue));
		studentMenuItems.setLayout(null);
		studentMenuItems.setBackground(new Color(53,53,53));
		
		JPanel contactP = new JPanel();
		contactP.setBounds(0,0,250,30);
		contactP.setBackground(new Color(53,53,53));
		contactP.setLayout(null);
		
		JLabel contact = new JLabel("<html><body style='margin-left:20px'>Contact Us</body></html>");
		contact.setBounds(10,0,230,30);
		contact.setForeground(Color.white);
		contact.setFont(new Font("sans-seri",Font.BOLD,17));
		//contact.addMouseListener(this);
		contact.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
		
				ContactUs.getContactUs().setVisible(true);
				jf.setVisible(false);
	
			}
			
		});
		
		contactP.add(contact);
		
		JPanel aboutP = new JPanel();
		aboutP.setBounds(0,30,250,30);
		aboutP.setBackground(new Color(53,53,53));
		aboutP.setLayout(null);
		
		JLabel about = new JLabel("<html><body style='margin-left:20px'>About Us</body></html>");
		about.setBounds(10,0,230,30);
		about.setForeground(Color.white);
		about.setFont(new Font("sans-seri",Font.BOLD,17));
		about.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
		
				AboutUs.getAboutUs().setVisible(true);
				jf.setVisible(false);
	
			}
			
		});
		
		aboutP.add(about);
		
		JPanel settingP = new JPanel();
		settingP.setBounds(0,60,250,30);
		settingP.setBackground(new Color(53,53,53));
		settingP.setLayout(null);
		
		JLabel setting = new JLabel("<html><body style='margin-left:20px'>Setting</body></html>");
		setting.setBounds(10,0,230,30);
		setting.setForeground(Color.white);
		setting.setFont(new Font("sans-seri",Font.BOLD,17));
		
		settingP.add(setting);
		
		JPanel admitCardP = new JPanel();
		admitCardP.setBounds(0,90,250,30);
		admitCardP.setBackground(new Color(53,53,53));
		admitCardP.setLayout(null);
		
		JLabel admitCard = new JLabel("<html><body style='margin-left:20px'>Admit Card</body></html>");
		admitCard.setBounds(10,0,230,30);
		admitCard.setForeground(Color.white);
		admitCard.setFont(new Font("sans-seri",Font.BOLD,17));
		admitCard.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				if(userName.getText().equals(""))
				{
					login.setVisible(true);
				}
			}
			
		});
		
		admitCardP.add(admitCard);
		
		JPanel sDetailsP = new JPanel();
		sDetailsP.setBounds(0,120,250,30);
		sDetailsP.setBackground(new Color(53,53,53));
		sDetailsP.setLayout(null);
		
		JLabel sDetails = new JLabel("<html><body style='margin-left:20px'>Students Details</body></html>");
		sDetails.setBounds(10,0,230,30);
		sDetails.setForeground(Color.white);
		sDetails.setFont(new Font("sans-seri",Font.BOLD,17));
		sDetails.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				if(userName.getText().equals(""))
				{
					login.setVisible(true);
				}
				else
				{
					SDetails.getSDetails().setVisible(true);
					StudentsDB.setSDetails();
					jf.setVisible(false);
				}
			}
			
		});
		
		sDetailsP.add(sDetails);
		
		JPanel fDetailsP = new JPanel();
		fDetailsP.setBounds(0,150,250,30);
		fDetailsP.setBackground(new Color(53,53,53));
		fDetailsP.setLayout(null);
		
		JLabel fDetails = new JLabel("<html><body style='margin-left:20px'>Fees Details</body></html>");
		fDetails.setBounds(10,0,230,30);
		fDetails.setForeground(Color.white);
		fDetails.setFont(new Font("sans-seri",Font.BOLD,17));
		fDetails.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				if(userName.getText().equals(""))
				{
					login.setVisible(true);
				}
				else
				{
					FDetails.getFDetails().setVisible(true);
					StudentsDB.getFeeDetails();
					jf.setVisible(false);
				}
			}
			
		});
		
		fDetailsP.add(fDetails);
		
		JPanel ALLCP = new JPanel();
		ALLCP.setBounds(0,180,250,30);
		ALLCP.setBackground(new Color(53,53,53));
		ALLCP.setLayout(null);
		
		JLabel ALLC = new JLabel("<html><body style='margin-left:20px'>Prospectas</body></html>");
		ALLC.setBounds(10,0,230,30);
		ALLC.setForeground(Color.white);
		ALLC.setFont(new Font("sans-seri",Font.BOLD,17));
		ALLC.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				AllCourses.getAllCourses().setVisible(true);
				jf.setVisible(false);
			}
			
		});
		
		ALLCP.add(ALLC);
		
		studentMenuItems.add(contactP);
		studentMenuItems.add(aboutP);
		studentMenuItems.add(settingP);
		studentMenuItems.add(admitCardP);
		studentMenuItems.add(sDetailsP);
		studentMenuItems.add(fDetailsP);
		studentMenuItems.add(ALLCP);
		
		
		//
		adminMenuItems = new JPanel();
		//adminMenuItems.setBorder(BorderFactory.createLineBorder(Color.blue));
		adminMenuItems.setLayout(null);
		adminMenuItems.setBackground(new Color(53,53,53));
		
		
		JPanel contactPA = new JPanel();
		contactPA.setBounds(0,0,250,30);
		contactPA.setBackground(new Color(53,53,53));
		contactPA.setLayout(null);
		
		JLabel contactA = new JLabel("<html><body style='margin-left:20px'>Contact Us</body></html>");
		contactA.setBounds(10,0,230,30);
		contactA.setForeground(Color.white);
		contactA.setFont(new Font("sans-seri",Font.BOLD,17));
		contactA.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
		
				ContactUs.getContactUs().setVisible(true);
				jf.setVisible(false);
	
			}
			
		});

		contactPA.add(contactA);
		
		JPanel aboutPA = new JPanel();
		aboutPA.setBounds(0,30,250,30);
		aboutPA.setBackground(new Color(53,53,53));
		aboutPA.setLayout(null);
		
		JLabel aboutA = new JLabel("<html><body style='margin-left:20px'>About Us</body></html>");
		aboutA.setBounds(10,0,230,30);
		aboutA.setForeground(Color.white);
		aboutA.setFont(new Font("sans-seri",Font.BOLD,17));
		aboutA.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
		
				AboutUs.getAboutUs().setVisible(true);
				jf.setVisible(false);
	
			}
			
		});
		
		aboutPA.add(aboutA);
		
		JPanel settingPA = new JPanel();
		settingPA.setBounds(0,60,250,30);
		settingPA.setBackground(new Color(53,53,53));
		settingPA.setLayout(null);
		
		JLabel settingA = new JLabel("<html><body style='margin-left:20px'>Setting</body></html>");
		settingA.setBounds(10,0,230,30);
		settingA.setForeground(Color.white);
		settingA.setFont(new Font("sans-seri",Font.BOLD,17));
		
		settingPA.add(settingA);
		
		JPanel admitCardPA = new JPanel();
		admitCardPA.setBounds(0,90,250,30);
		admitCardPA.setBackground(new Color(53,53,53));
		admitCardPA.setLayout(null);
		
		JLabel admitCardA = new JLabel("<html><body style='margin-left:20px'>Admit Card</body></html>");
		admitCardA.setBounds(10,0,230,30);
		admitCardA.setForeground(Color.white);
		admitCardA.setFont(new Font("sans-seri",Font.BOLD,17));
		
		admitCardPA.add(admitCardA);
		
		JPanel sDetailsPA = new JPanel();
		sDetailsPA.setBounds(0,120,250,30);
		sDetailsPA.setBackground(new Color(53,53,53));
		sDetailsPA.setLayout(null);
		
		JLabel sDetailsA = new JLabel("<html><body style='margin-left:20px'>Students Details</body></html>");
		sDetailsA.setBounds(10,0,230,30);
		sDetailsA.setForeground(Color.white);
		sDetailsA.setFont(new Font("sans-seri",Font.BOLD,17));
		
		sDetailsPA.add(sDetailsA);
		
		JPanel subItems = new JPanel();
		subItems.setBounds(0,150,250,90);
		subItems.setBounds(0,150,250,120);
		subItems.setBackground(new Color(0,0,0,50));
		subItems.setBackground(new Color(0,191,162));
		subItems.setLayout(null);
		
		JLabel CNRecord = new JLabel("<html><body style='margin-left:20px'>Create New Record</body></html>");
		CNRecord.setBounds(10,0,230,30);
		CNRecord.setForeground(Color.white);
		CNRecord.setFont(new Font("sans-seri",Font.BOLD,17));
		CNRecord.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				UBTiming.getUBTiming().setVisible(false);
				int tstudent = StudentsDB.getRowCount();
				if(tstudent != -1)
				{
					System.out.println("ok");
				
					CNRecords.getCNRecords().setVisible(true);
					CNRecords.settotalStudentno(tstudent);
					jf.setVisible(false);
				}
				
			}
			
		});
		
		subItems.add(CNRecord);
		
		JLabel UBTime = new JLabel("<html><body style='margin-left:20px'>Update Batch Timing</body></html>");
		UBTime.setBounds(10,30,230,30);
		UBTime.setForeground(Color.white);
		UBTime.setFont(new Font("sans-seri",Font.BOLD,17));
		UBTime.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				UBTiming.getUBTiming().setVisible(true);
				
				
			}
			
		});
		
		subItems.add(UBTime);
		
		JLabel OASDetails = new JLabel("<html><body style='margin-left:20px'>Overall Students Details</body></html>");
		OASDetails.setBounds(10,60,230,30);
		OASDetails.setForeground(Color.white);
		OASDetails.setFont(new Font("sans-seri",Font.BOLD,17));
		OASDetails.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				UBTiming.getUBTiming().setVisible(false);
				int tstudent = StudentsDB.getRowCount();
				if(tstudent != -1)
				{
					
					OverAllSDetails.getOverAllSDetails().setVisible(true);
					StudentsDB.overAllStudents();
					OverAllSDetails.settotalStudentno(tstudent);
					jf.setVisible(false);
				}
			}
		});
		
		subItems.add(OASDetails); 

		JLabel feeEntery = new JLabel("<html><body style='margin-left:20px'>Fee Entery</body></html>");
		feeEntery.setBounds(10,90,230,30);
		feeEntery.setForeground(Color.white);
		feeEntery.setFont(new Font("sans-seri",Font.BOLD,17));
		feeEntery.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				
					int feeCode = StudentsDB.getFeeLastCode();
					
					if(feeCode != -1)
					{
						
						FeeEntry.getFeeEntry().setVisible(true);
						FeeEntry.feecode.setText(String.valueOf(feeCode+1));
						StudentsDB.getAllRecordsOffee();
						
						jf.setVisible(false);
					}
					
			
			}
		});
		
		subItems.add(feeEntery); 
		
		JPanel ANEFacultyP = new JPanel();
		ANEFacultyP.setBounds(0,270,250,30);
		ANEFacultyP.setBackground(new Color(53,53,53));
		ANEFacultyP.setLayout(null);
		
		JLabel ANEFaculty = new JLabel("<html><body style='margin-left:20px'>Add New Faculty</body></html>");
		ANEFaculty.setBounds(10,0,230,30);
		ANEFaculty.setForeground(Color.white);
		ANEFaculty.setFont(new Font("sans-seri",Font.BOLD,17));
		ANEFaculty.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				UBTiming.getUBTiming().setVisible(false);
				int tfaculty = StudentsDB.getTfaclty();
				if(tfaculty != -1)
				{
					System.out.println("ok");
				
					ANFaculty.getANFaculty().setVisible(true);
					ANFaculty.settotalFacultyno(tfaculty);
					boolean ok = StudentsDB.getfacultyRecords();
					if(ok == true)
					{
						jf.setVisible(false);
					}
				}
				
			}
			
		});

		ANEFacultyP.add(ANEFaculty);
		
		JPanel ALLCPA = new JPanel();
		ALLCPA.setBounds(0,300,250,30);
		ALLCPA.setBackground(new Color(53,53,53));
		ALLCPA.setLayout(null);
		
		JLabel ALLCA = new JLabel("<html><body style='margin-left:20px'>Prospectas</body></html>");
		ALLCA.setBounds(10,0,230,30);
		ALLCA.setForeground(Color.white);
		ALLCA.setFont(new Font("sans-seri",Font.BOLD,17));
		ALLCA.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				AllCourses.getAllCourses().setVisible(true);
				jf.setVisible(false);
			}
			
		});
		
		ALLCPA.add(ALLCA);
		
		adminMenuItems.add(contactPA);
		adminMenuItems.add(aboutPA);
		adminMenuItems.add(settingPA);
		adminMenuItems.add(admitCardPA);
		adminMenuItems.add(sDetailsPA);
		adminMenuItems.add(subItems);
		adminMenuItems.add(ANEFacultyP);
		adminMenuItems.add(ALLCPA);
		
		containMenuItems.add("sitems",studentMenuItems);
		containMenuItems.add("aitems",adminMenuItems);
		ItemsCLaout.show(containMenuItems,"sitems");
		
		
		sidebar.add(containUserPic);
		sidebar.add(containMenuItems);
		
		
		
		
		
		
		
		
		
		mainContainer = new JPanel();
		mainContainer.setBounds(0,50,JfWidth,JfHeight-50);
		mainContainer.setBackground(Color.red);
		mainContainer.setLayout(cLayout);
		
		child1 = new JPanel();
		child1.setBounds(0,0,JfWidth,JfHeight-50);
		child1.setLayout(null);
		
		JLabel IconLabel1 = new JLabel();
		IconLabel1.setBounds(0,0,JfWidth,JfHeight-50);
		ImageIcon path1 = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\apple-computer-desk-209151.jpg");
		Image img1 = path1.getImage();
		Image resize1 = img1.getScaledInstance(IconLabel1.getWidth(), IconLabel1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon1 = new ImageIcon(resize1);
		IconLabel1.setIcon(icon1);
	
		//System.out.println(c1.getWidth());
		JButton child1pre = new JButton("<html><body>&#9001;</body></html>");
		child1pre.setBackground(new Color(13,58,247));
		child1pre.setForeground(Color.white);
		child1pre.setFont(new Font("Arial",Font.BOLD,20));
		child1pre.setBorder(BorderFactory.createEmptyBorder());
		child1pre.setBounds(10,286,50,50);
		child1pre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				cLayout.previous(mainContainer);
				
			}
			
		});
		
		JButton child1next = new JButton("<html><body>&#9002;</body></html>");
		child1next.setBackground(new Color(13,58,247));
		child1next.setForeground(Color.white);
		child1next.setFont(new Font("Arial",Font.BOLD,20));
		child1next.setBorder(BorderFactory.createEmptyBorder());
		child1next.setBounds(1290,286,50,50);
		child1next.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				cLayout.next(mainContainer);
			}
			
		});
		
		
		
		child1.add(child1pre);
		child1.add(child1next);
		child1.add(IconLabel1);
		
		
		child2 = new JPanel();
		child2.setBounds(0,0,JfWidth,JfHeight-50);
		child2.setLayout(null);
		
		JLabel IconLabel2 = new JLabel();
		IconLabel2.setBounds(0,0,JfWidth,JfHeight-50);
		ImageIcon path2 = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\pexels-photo-920381.jpeg");
		Image img2 = path2.getImage();
		Image resize2 = img2.getScaledInstance(IconLabel2.getWidth(), IconLabel2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(resize2);
		IconLabel2.setIcon(icon2);
		
		JButton child2pre = new JButton("<html><body>&#9001;</body></html>");
		child2pre.setBackground(new Color(13,58,247));
		child2pre.setForeground(Color.white);
		child2pre.setFont(new Font("Arial",Font.BOLD,20));
		child2pre.setBorder(BorderFactory.createEmptyBorder());
		child2pre.setBounds(10,286,50,50);
		child2pre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				cLayout.previous(mainContainer);
				
			}
			
		});
		
		JButton child2next = new JButton("<html><body>&#9002;</body></html>");
		child2next.setBackground(new Color(13,58,247));
		child2next.setForeground(Color.white);
		child2next.setFont(new Font("Arial",Font.BOLD,20));
		child2next.setBorder(BorderFactory.createEmptyBorder());
		child2next.setBounds(1290,286,50,50);
		child2next.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				cLayout.next(mainContainer);
			}
			
		});
	
		child2.add(child2pre);
		child2.add(child2next);
		child2.add(IconLabel2);
		
		child3 = new JPanel();
		child3.setBounds(0,0,JfWidth,JfHeight-50);
		child3.setLayout(null);
		
		JLabel IconLabel3 = new JLabel();
		IconLabel3.setBounds(0,0,JfWidth,JfHeight-50);
		ImageIcon path3 = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\pexels-photo-582428.jpeg");
		Image img3 = path3.getImage();
		Image resize3 = img3.getScaledInstance(IconLabel3.getWidth(), IconLabel3.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon3 = new ImageIcon(resize3);
		IconLabel3.setIcon(icon3);
		
		JButton child3pre = new JButton("<html><body>&#9001;</body></html>");
		child3pre.setBackground(new Color(13,58,247));
		child3pre.setForeground(Color.white);
		child3pre.setFont(new Font("Arial",Font.BOLD,20));
		child3pre.setBorder(BorderFactory.createEmptyBorder());
		child3pre.setBounds(10,286,50,50);
		child3pre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				cLayout.previous(mainContainer);
				
			}
			
		});
		
		JButton child3next = new JButton("<html><body>&#9002;</body></html>");
		child3next.setBackground(new Color(13,58,247));
		child3next.setForeground(Color.white);
		child3next.setFont(new Font("Arial",Font.BOLD,20));
		child3next.setBorder(BorderFactory.createEmptyBorder());
		child3next.setBounds(1290,286,50,50);
		child3next.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				cLayout.next(mainContainer);
			}
			
		});

	
		child3.add(child3pre);
		child3.add(child3next);
		child3.add(IconLabel3);
		
		
		child4 = new JPanel();
		child4.setBounds(0,0,JfWidth,JfHeight-50);
		child4.setLayout(null);
		
		JLabel IconLabel4 = new JLabel();
		IconLabel4.setBounds(0,0,JfWidth,JfHeight-50);
		ImageIcon path4 = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\pexels-photo-461497.jpeg");
		Image img4 = path4.getImage();
		Image resize4 = img4.getScaledInstance(IconLabel4.getWidth(), IconLabel4.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon4 = new ImageIcon(resize4);
		IconLabel4.setIcon(icon4);
		
		JButton child4pre = new JButton("<html><body>&#9001;</body></html>");
		child4pre.setBackground(new Color(13,58,247));
		child4pre.setForeground(Color.white);
		child4pre.setFont(new Font("Arial",Font.BOLD,20));
		child4pre.setBorder(BorderFactory.createEmptyBorder());
		child4pre.setBounds(10,286,50,50);
		child4pre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				cLayout.previous(mainContainer);
				
			}
			
		});
		
		JButton child4next = new JButton("<html><body>&#9002;</body></html>");
		child4next.setBackground(new Color(13,58,247));
		child4next.setForeground(Color.white);
		child4next.setFont(new Font("Arial",Font.BOLD,20));
		child4next.setBorder(BorderFactory.createEmptyBorder());
		child4next.setBounds(1290,286,50,50);
		child4next.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				cLayout.next(mainContainer);
			}
			
		});

	
		child4.add(child4pre);
		child4.add(child4next);
		child4.add(IconLabel4);
		
		
		child5 = new JPanel();
		child5.setBounds(0,0,JfWidth,JfHeight-50);
		child5.setLayout(null);
		
		JLabel IconLabel5 = new JLabel();
		IconLabel5.setBounds(0,0,JfWidth,JfHeight-50);
		ImageIcon path5 = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\chairs-chalk-chalkboard-159844.jpg");
		Image img5 = path5.getImage();
		Image resize5 = img5.getScaledInstance(IconLabel5.getWidth(), IconLabel5.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon5 = new ImageIcon(resize5);
		IconLabel5.setIcon(icon5);
		
		JButton child5pre = new JButton("<html><body>&#9001;</body></html>");
		child5pre.setBackground(new Color(13,58,247));
		child5pre.setForeground(Color.white);
		child5pre.setFont(new Font("Arial",Font.BOLD,20));
		child5pre.setBorder(BorderFactory.createEmptyBorder());
		child5pre.setBounds(10,286,50,50);
		child5pre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				cLayout.previous(mainContainer);
				
			}
			
		});
		
		JButton child5next = new JButton("<html><body>&#9002;</body></html>");
		child5next.setBackground(new Color(13,58,247));
		child5next.setForeground(Color.white);
		child5next.setFont(new Font("Arial",Font.BOLD,20));
		child5next.setBorder(BorderFactory.createEmptyBorder());
		child5next.setBounds(1290,286,50,50);
		child5next.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				cLayout.next(mainContainer);
			}
			
		});

	
		child5.add(child5pre);
		child5.add(child5next);
		child5.add(IconLabel5);


		
		mainContainer.add("child1",child1);
		mainContainer.add("child2",child2);
		mainContainer.add("child3",child3);
		mainContainer.add("child4",child4);
		mainContainer.add("child5",child5);
		
		cLayout.show(mainContainer,"child5");
		
		
		
		
		jf.add(menubar);
		jf.add(sidebar);
		jf.add(mainContainer);
		
		
	}

	private class Transition implements Runnable
	{
		int i,maincAlign;
		int j;
		
		public void run()
		{
			if(String.valueOf(AlignLeft).equals("250"))
			{
				for(i=250; i>0; i--)
				{
					j = 250-i;
					try
					{
						thread.sleep(1/2);
						sidebar.setBounds(-i,50,250,JfHeight-50);
						mainContainer.setBounds(j,50,JfWidth,JfHeight-50);
					}
					catch(Exception e)
					{
						
					}
				}
				AlignLeft = i;
				j = j+1;
			//	System.out.println(j);
				
			}
			
			else if(String.valueOf(AlignLeft).equals("0"))
			{
				for(i=0; i<250; i++)
				{
					j = 250-i;
					try
					{
						thread.sleep(1/2);
						sidebar.setBounds(-i,50,250,JfHeight-50);
						mainContainer.setBounds(j,50,JfWidth,JfHeight-50);
					}
					catch(Exception e)
					{
						
					}
				}
				AlignLeft = i;
			
			}
		}
	}
	
	public static Project getClassProject()
	{
		return new Project();
	}
	
	public static void showPic(ImageIcon pic)
	{
		Image img2 = pic.getImage();
		Image img3 = img2.getScaledInstance(userPic.getWidth(),userPic.getHeight(),Image.SCALE_SMOOTH);
		
		userPic.setIcon(new ImageIcon(img3));
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {

		
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public static Project getProject()
	{
		return new Project();
	}
	
	public static void controllLayout()
	{
		ItemsCLaout.show(containMenuItems,"aitems");
	}
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new Project();
			}
		});

	}


	
	

}
