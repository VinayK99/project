package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class CNRecords extends JFrame{

	JPanel titlebar;
	JPanel container;
	JButton mini,close;
	JLabel Title;
	JPanel leftPane;
	JPanel rightPane;
	JPanel containerC; //container of component
	JLabel rollno;
	JLabel fname,lname,fathername,mothername,address,mobileNo,dob,gender,emailId,batchTime,admissiondate,course,courseDuration,startingDate,endingDate,totalFee,monthlyfee,counsellerName;
	static JTextField tfname,tlname,tfathername,tmothername,tmobileNo,temailId,tcourseDuration,ttotalFee,tmonthlyfee,tcounsellerName;
	static JTextField trollno,totalStudent;
	static JTextArea taddress;
	static JTextField tstartingDate,tendingDate,tdob,tadmissiondate;
	static JComboBox<String> tcourse,tbatchTime; 
	static JCheckBox male,female;
	JTextField searchbox;
	
	JButton search;
	JButton save,delete,update,cencel;
	
	static String selectedGender,totalStudentno;
	String dd=null, mm=null, yyyy=null;
	String dd1=null, mm1=null, yyyy1=null;
	
	String desideToPerform = "";
	
	private Point initialClick;
	
	public CNRecords()
	{
		setUndecorated(true);
		setVisible(true);
		System.out.println("roll no ="+totalStudentno);
			
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int width = (int) toolkit.getScreenSize().getWidth()-20;
		int height = (int) toolkit.getScreenSize().getHeight()-60;
		
		setSize(width,height);
		setLocationRelativeTo(null);
		setLayout(null);
		
		container = new JPanel();
		container.setBounds(0,0,width,height);
		container.setLayout(null);
		container.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(20,66,125)));
		container.setBackground(Color.white);
		container.setFocusable(true);
		
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
		
		titlebar = new JPanel();
		titlebar.setBounds(0,0,width,35);
		titlebar.setBackground(new Color(20,66,125));
		titlebar.setLayout(null);
		
		Title = new JLabel("<html><font size=5>C</font>reate <font size=5>N</font>ew <font size=5>R</font>ecord</html>");
		Title.setBounds(0,0,1296,35);
		Title.setBackground(Color.red);
		Title.setForeground(new Color(255,255,255));
		Title.setHorizontalAlignment(JLabel.CENTER);
		Title.setFont(new Font("Dialog",Font.BOLD,15));
		titlebar.add(Title);
	
		//1366
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
			//	System.exit(0);
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
		

		trollno = new JTextField(30);
		trollno.setBounds(10,10,120,50);
		trollno.setBorder(new TitledBorder(new EtchedBorder(),"Student Roll No."));
		trollno.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		trollno.setEditable(false);
		trollno.setHorizontalAlignment(JLabel.CENTER);
		
		
		totalStudent = new JTextField(30);
		totalStudent.setBounds(533,10,120,50);
		totalStudent.setBorder(new TitledBorder(new EtchedBorder(),"Total Student"));
		totalStudent.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		totalStudent.setHorizontalAlignment(JLabel.CENTER);
		totalStudent.setEditable(false);
		totalStudent.addMouseListener(new MouseAdapter() {



			@Override
			public void mouseEntered(MouseEvent arg0) {

			//	totalStudent.setEditable(false);
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			//	totalStudent.setEditable(true);
			}

			

		});
		
		fname = new JLabel("Student Name");
		fname.setBounds(10,90,100,30);
		fname.setFont(new Font("Arial",Font.BOLD,13));
	
		
		tfname = new JTextField(200);
		tfname.setBounds(110,90,200,30);
		tfname.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		tfname.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		tfname.setText(null);
		tfname.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				tfname.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				
			}

			@Override
			public void focusLost(FocusEvent e) {

				if(tfname.getText().equals(""))
				{
					tfname.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
				}
				
			}
			
		});
		
		lname = new JLabel("Student Last Name");
		lname.setBounds(320,90,130,30);
		lname.setFont(new Font("Arial",Font.BOLD,13));
		
		tlname = new JTextField(200);
		tlname.setBounds(450,90,200,30);
		tlname.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		tlname.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		tlname.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				tlname.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				
			}

			@Override
			public void focusLost(FocusEvent e) {

				if(tfname.getText().equals(""))
				{
					tlname.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
				}
				
			}
			
		});
		
		fathername = new JLabel("Father Name");
		fathername.setBounds(10,130,100,30);
		fathername.setFont(new Font("Arial",Font.BOLD,13));
		
		tfathername = new JTextField(200);
		tfathername.setBounds(110,130,200,30);
		tfathername.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		tfathername.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		tfathername.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				tfathername.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				
			}

			@Override
			public void focusLost(FocusEvent e) {

				if(tfathername.getText().equals(""))
				{
					tfathername.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
				}
				
			}
			
		});
		
		mothername = new JLabel("Mother Name");
		mothername.setBounds(320,130,100,30);
		mothername.setFont(new Font("Arial",Font.BOLD,13));
		
		tmothername = new JTextField(200);
		tmothername.setBounds(450,130,200,30);
		tmothername.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		tmothername.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		tmothername.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				tmothername.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				
			}

			@Override
			public void focusLost(FocusEvent e) {

				if(tmothername.getText().equals(""))
				{
					tmothername.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
				}
				
			}
			
		});
		
		address = new JLabel("Address");
		address.setBounds(10,170,100,30);
		address.setFont(new Font("Arial",Font.BOLD,13));
		

		taddress = new JTextArea(2,1);
		taddress.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		taddress.setLineWrap(true);
		
		
	
		JScrollPane staddress = new JScrollPane(taddress);
	//	staddress.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		staddress.setBounds(110,170,540,40);
		staddress.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		taddress.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				staddress.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				
			}

			@Override
			public void focusLost(FocusEvent e) {

				if(taddress.getText().equals(""))
				{
					staddress.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
				}
				
			}
			
		});
		
		mobileNo = new JLabel("Mobile Number");
		mobileNo.setBounds(10,220,100,30);
		mobileNo.setFont(new Font("Arial",Font.BOLD,13));
		
		tmobileNo = new JTextField(200);
		tmobileNo.setBounds(110,220,200,30);
		tmobileNo.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		tmobileNo.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		tmobileNo.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				tmobileNo.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				
			}

			@Override
			public void focusLost(FocusEvent e) {

				if(tmobileNo.getText().equals(""))
				{
					tmobileNo.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
				}
				
			}
			
		});
		
		tmobileNo.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();
				if(!Character.isDigit(c))
				{
					e.consume();
				}
				if(tmobileNo.getText().length() >= 10)
				{
					e.consume();
					JOptionPane.showMessageDialog(null,"You have don't enter more than 10 Digits","",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
		dob = new JLabel("Date Of Birth");
		dob.setBounds(320,220,100,30);
		dob.setFont(new Font("Arial",Font.BOLD,13));
		
		tdob = new JTextField();
		tdob.setBounds(450,220,200,30);
		tdob.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		tdob.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		
		tdob.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e)
			{
				String m = "-";
				
				
				if(tdob.getText().length()==2)
				{
					int v = Integer.parseInt( tdob.getText());
					dd = tdob.getText();
					if(v > 31)
					{
						e.consume();
						tdob.setBorder(BorderFactory.createLineBorder(Color.red));
						tdob.setForeground(Color.red);
					}
					else
					{
						tdob.setText(tdob.getText()+m);
						tdob.setBorder(BorderFactory.createLineBorder(Color.black));
						tdob.setForeground(Color.black);
					}
					
					
				}
				else if(tdob.getText().length()==5)
				{
				
					String value = tdob.getText();
					String sub = value.substring(3,5);
					
					mm = sub;
					
					int v = Integer.parseInt(sub);
					
					if( v > 12)
					{
						e.consume();
						tdob.setBorder(BorderFactory.createLineBorder(Color.red));
						tdob.setForeground(Color.red);
					}
					else
					{
						tdob.setText(tdob.getText()+m);
						tdob.setBorder(BorderFactory.createLineBorder(Color.black));
						tdob.setForeground(Color.black);
					}
					
				}
				else if(tdob.getText().length()==10)
				{
					
					e.consume();	
				}
			
			}
			
			
		});
		
		tdob.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				tdob.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				
			}

			@Override
			public void focusLost(FocusEvent e) {

				if(tdob.getText().equals(""))
				{
					tdob.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
				}
				else
				{
					String value = tdob.getText();
					try
					{
						String sub = value.substring(6,10);
						yyyy = sub;
					}
					catch(StringIndexOutOfBoundsException e1)
					{
						JOptionPane.showMessageDialog(null,"You Not Enter valid Date at Date Of Birth ","", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
			}
			
		});
		
//		tdob.addFocusListener(new FocusListener() {
//
//			@Override
//			public void focusGained(FocusEvent e) {
//
//				tdob.setBorder(BorderFactory.createLineBorder(Color.black));
//				tdob.setForeground(Color.black);
//				
//			}
//
//			@Override
//			public void focusLost(FocusEvent e) {
//
//				tdob.setBorder(BorderFactory.createLineBorder(Color.black));
//				tdob.setForeground(Color.black);
//				
//				String value = tdob.getText();
//				String sub = value.substring(6,10);
//				
//				yyyy = sub;
//			}
//			
//		});
		
		
		
		gender = new JLabel("Gender");
		gender.setBounds(10,260,100,30);
		gender.setFont(new Font("Arial",Font.BOLD,13));
		
		male = new JCheckBox("Male");
		male.setBounds(110,260,55,30);
		male.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				selectedGender = male.getText();
				female.setSelected(false);
	
				System.out.println(dd+mm+yyyy);
				System.out.println(dd1+mm1+yyyy1);
			}
			
		});
		
		female = new JCheckBox("Female");
		female.setBounds(165,260,70,30);
		female.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				selectedGender = female.getText();
				male.setSelected(false);
				
			}
			
		});
		System.out.println(selectedGender);
		
		course = new JLabel("Course");
		course.setBounds(320,260,100,30);
		course.setFont(new Font("Arial",Font.BOLD,13));
		
		String courseitems[] = new String[] {"","ADCE","MDCE"};
		
		tcourse = new JComboBox<String>(courseitems);
		tcourse.setBounds(450,260,200,30);
		tcourse.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		tcourse.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		tmobileNo.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				tcourse.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				
			}

			@Override
			public void focusLost(FocusEvent e) {

				if(tcourse.getSelectedItem().equals(""))
				{
					tcourse.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
				}
				
			}
			
		});
		
		emailId = new JLabel("Email ID");
		emailId.setBounds(10,300,100,30);
		emailId.setFont(new Font("Arial",Font.BOLD,13));
		
		temailId = new JTextField(200);
		temailId.setBounds(110,300,200,30);
		temailId.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		temailId.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		temailId.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				temailId.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				
			}

			@Override
			public void focusLost(FocusEvent e) {

				if(temailId.getText().equals(""))
				{
					temailId.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
				}
				
			}
			
		});
		
		
		courseDuration = new JLabel("Course Duration");
		courseDuration.setBounds(320,300,120,30);
		courseDuration.setFont(new Font("Arial",Font.BOLD,13));
		
		tcourseDuration = new JTextField();
		tcourseDuration.setBounds(450,300,200,30);
		tcourseDuration.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		tcourseDuration.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		tcourseDuration.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		tcourseDuration.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				tcourseDuration.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				
			}

			@Override
			public void focusLost(FocusEvent e) {

				if(tcourseDuration.getText().equals(""))
				{
					tcourseDuration.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
				}
				
			}
			
		});
		
		totalFee = new JLabel("Total Fee");
		totalFee.setBounds(10,340,100,30);
		totalFee.setFont(new Font("Arial",Font.BOLD,13));
		
		ttotalFee = new JTextField();
		ttotalFee.setBounds(110,340,200,30);
		ttotalFee.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		ttotalFee.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		ttotalFee.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				ttotalFee.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				
			}

			@Override
			public void focusLost(FocusEvent e) {

				if(ttotalFee.getText().equals(""))
				{
					ttotalFee.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
				}
				
			}
			
		});
		
		
		monthlyfee = new JLabel("Monthly Fee");
		monthlyfee.setBounds(320,340,120,30);
		monthlyfee.setFont(new Font("Arial",Font.BOLD,13));
		
		tmonthlyfee = new JTextField();
		tmonthlyfee.setBounds(450,340,200,30);
		tmonthlyfee.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		tmonthlyfee.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		tmonthlyfee.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				tmonthlyfee.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				
			}

			@Override
			public void focusLost(FocusEvent e) {

				if(tmonthlyfee.getText().equals(""))
				{
					tmonthlyfee.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
				}
				
			}
			
		});
		
		admissiondate = new JLabel("Admission Date");
		admissiondate.setBounds(10,380,100,30);
		admissiondate.setFont(new Font("Arial",Font.BOLD,13));
		
		tadmissiondate = new JTextField();
		tadmissiondate.setBounds(110,380,200,30);
		tadmissiondate.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		tadmissiondate.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		tadmissiondate.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				tadmissiondate.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				
			}

			@Override
			public void focusLost(FocusEvent e) {

				if(tadmissiondate.getText().equals(""))
				{
					tadmissiondate.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
				}
				else
				{
					String value = tdob.getText();
					try
					{
						String sub = value.substring(6,10);
						yyyy1 = sub;
					}
					catch(StringIndexOutOfBoundsException e1)
					{
						JOptionPane.showMessageDialog(null,"You Not Enter valid Date at Admission Date ","", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}
		
		});
		
		tadmissiondate.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e)
			{
				String m = "-";
				
				if(tadmissiondate.getText().length()==2)
				{
					int v = Integer.parseInt( tadmissiondate.getText());
					dd1 = tadmissiondate.getText();
					if(v > 31)
					{
						e.consume();
						tadmissiondate.setBorder(BorderFactory.createLineBorder(Color.red));
						tadmissiondate.setForeground(Color.red);
					}
					else
					{
						tadmissiondate.setText(tadmissiondate.getText()+m);
						tadmissiondate.setBorder(BorderFactory.createLineBorder(Color.black));
						tadmissiondate.setForeground(Color.black);
					}
					
					
				}
				else if(tadmissiondate.getText().length()==5)
				{
					
					String value = tadmissiondate.getText();
					String sub = value.substring(3,5);
					mm1 = sub;
					
					int v = Integer.parseInt(sub);
					
					if( v > 12)
					{
						e.consume();
						tadmissiondate.setBorder(BorderFactory.createLineBorder(Color.red));
						tadmissiondate.setForeground(Color.red);
					}
					else
					{
						tadmissiondate.setText(tadmissiondate.getText()+m);
						tadmissiondate.setBorder(BorderFactory.createLineBorder(Color.black));
						tadmissiondate.setForeground(Color.black);
					}
					
				}
				else if(tadmissiondate.getText().length()==10)
				{
					e.consume();	
				}
			}
		});
		
		batchTime = new JLabel("Batch Timing");
		batchTime.setBounds(320,380,100,30);
		batchTime.setFont(new Font("Arial",Font.BOLD,13));
	
		
		String BatchTime[] = new String[]{"","7:30 To 9:00","9:00 To 10:30","10:30 To 12:00","12:00 To 1:30","3:30 To 5:00","5:00 To 6:30"};
		
		tbatchTime = new JComboBox<String>(BatchTime);
		tbatchTime.setBounds(450,380,200,30);
		tbatchTime.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		tbatchTime.setBorder(BorderFactory.createLineBorder(Color.black));
		tbatchTime.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		tbatchTime.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				tbatchTime.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				
			}

			@Override
			public void focusLost(FocusEvent e) {

				if(tbatchTime.getSelectedItem().equals(""))
				{
					tbatchTime.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
				}
				
			}
			
		});
		
		
		tcounsellerName = new JTextField(190);
		tcounsellerName.setBounds(10,430,190,50);
		tcounsellerName.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		tcounsellerName.setBorder(new TitledBorder(new EtchedBorder(),"Counseller Name"));
		tcounsellerName.setHorizontalAlignment(JLabel.CENTER);
			
		
	
		
		
		containerC = new JPanel();
		containerC.setBounds(321,80,663,500);
		containerC.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,100)));
		containerC.setBackground(Color.white);
		containerC.setLayout(null);
		
	
		
		
		containerC.add(trollno);
		containerC.add(totalStudent);
		containerC.add(fname);
		containerC.add(tfname);
		containerC.add(lname);
		containerC.add(tlname);
		containerC.add(fathername);
		containerC.add(tfathername);
		containerC.add(mothername);
		containerC.add(tmothername);
		containerC.add(address);
		containerC.add(staddress);
		containerC.add(mobileNo);
		containerC.add(tmobileNo);
		containerC.add(dob);
		containerC.add(tdob);
		containerC.add(gender);
		containerC.add(male);
		containerC.add(female);
		containerC.add(course);
		containerC.add(tcourse);
		containerC.add(emailId);
		containerC.add(temailId);
		containerC.add(courseDuration);
		containerC.add(tcourseDuration);
		containerC.add(totalFee);
		containerC.add(ttotalFee);
		containerC.add(monthlyfee);
		containerC.add(tmonthlyfee);
		containerC.add(admissiondate);
		containerC.add(tadmissiondate);
		containerC.add(batchTime);
		containerC.add(tbatchTime);
		containerC.add(tcounsellerName);
		
		JPanel searchC = new JPanel();
		searchC.setBounds(1022,80,240,32);
		searchC.setLayout(null);
		searchC.setBorder(BorderFactory.createLineBorder(new Color(76,72,72)));
		searchC.setFocusable(true);
	
		searchbox = new JTextField(150);
		searchbox.setBounds(1,1,149,30);
		searchbox.setHorizontalAlignment(JLabel.CENTER);
		searchbox.setBorder(BorderFactory.createEmptyBorder());
		searchbox.setText("Roll no.");
		searchbox.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		searchbox.setForeground(Color.gray);
		searchbox.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
					
				searchbox.setText("");
				searchC.setBorder(BorderFactory.createLineBorder(new Color(20,66,125)));
				searchbox.setForeground(Color.black);
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				
				if(searchbox.getText().equals(""))
				{
					searchbox.setText("Roll no.");
				}
				searchC.setBorder(BorderFactory.createLineBorder(new Color(76,72,72)));
				searchbox.setForeground(Color.gray);
				
				
			}
			
		});
		
		searchbox.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e)
			{
				char ch = e.getKeyChar();
				if(!Character.isDigit(ch))
				{
					e.consume();
				}
			}
		});
		
		
		search = new JButton("Search");
		search.setBounds(150,1,89,30);
		search.setBorder(BorderFactory.createEmptyBorder());
		search.setBackground(new Color(103,189,40));
		search.setBorder(BorderFactory.createMatteBorder(0,1,0,0,new Color(76,72,72)));
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(searchbox.getText().equals("Roll no."))
				{
					JOptionPane.showMessageDialog(searchC, "Please Enter the Roll No.");
				}
				else
				{
					int rollno = StudentsDB.searchRollno(searchbox.getText());
					if(rollno != 0)
					{
						System.out.println(rollno);
						desideToPerform = "search";
					}
				}
			}
			
		});
		
		searchC.add(searchbox);
		searchC.add(search);
		
		save = new JButton("Save");
		save.setBounds(321,600,90,30);
		save.setBackground(new Color(20,66,125));
		save.setForeground(Color.white);
		save.setFont(new Font("Arial",Font.BOLD,14));
		save.setBorder(BorderFactory.createEmptyBorder());
		save.addActionListener(new ActionListener() {

		
			public void actionPerformed(ActionEvent e) {
	
				
//				String sfn = null;
//				String sln = null;
//				String sfathern = null;
//				String smothern = null;
//				String sad =  null;
//				String smn = null;
//				String sei = null;
//				String scd = null;
//				String stf = null;
//				String smf = null;
//				String cn = null;
//				String sadate = null;
//				String sdob = null;
//				String sc = null;
//				String sbt = null;
				
				String sfn = tfname.getText();
				String sln = tlname.getText();
				String sfathern = tfathername.getText();
				String smothern = tmothername.getText();
				String sad =  taddress.getText();
				String smn = tmobileNo.getText();
				String sei = temailId.getText();
				String scd = tcourseDuration.getText();
				String stf = ttotalFee.getText();
				String smf = tmonthlyfee.getText();
				String cn = tcounsellerName.getText();
				String sadate = tadmissiondate.getText();
				String sdob = tdob.getText();
				String sc = String.valueOf(tcourse.getSelectedItem());
				String sbt = String.valueOf(tbatchTime.getSelectedItem());
				
				
				if(sfn.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Name is Required");
				}
				else if(sfathern.equals("") && smothern.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Parents Name is Required both or any one");
				}
				else if(sad.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Address is Required");
				}
				else if(smn.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Mobile Number is Required");
				}
				else if(sdob.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Date Of Birth is Required");
				}
				else if(selectedGender == null)
				{
					JOptionPane.showMessageDialog(null,"Gender is Required");
				}
				else if(sc.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Course is Required");
				}
				else if(sei.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Email-Id is Required");
				}
				else if(scd.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Course Duration is Required");
				}
				else if(stf.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Total fee is Required");
				}
				else if(smf.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Monthly fee is Required");
				}
				else if(sadate.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Admission Date is Required");
				}
				else if(sbt.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Batch Time is Required");
				}
				else if(cn.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Counseller Number is Required");
				}
				else
				{
					if(StudentsDB.addStudentRecords(sfn,sln,sfathern,smothern,sad,smn,sei,selectedGender,scd,stf,smf,cn,sadate,sdob,sc,sbt))
					{
						JOptionPane.showMessageDialog(null,"Add Record Successfully");
						
						 
						tfname.setText("");
						tlname.setText("");
						tfathername.setText("");
						tmothername.setText("");
						taddress.setText("");
						tmobileNo.setText("");
						temailId.setText("");
						tcourseDuration.setText("");
						ttotalFee.setText("");
						tmonthlyfee.setText("");
						tcounsellerName.setText("");
						tadmissiondate.setText("");
						tdob.setText("");
						male.setSelected(false);
						female.setSelected(false);
						
						tcourse.setSelectedIndex(0);
						tbatchTime.setSelectedIndex(0);
						
						int tstudent = StudentsDB.getRowCount();
						if(tstudent != -1)
						{
							settotalStudentno(tstudent);
						}
					}
					else
					{
						System.out.println("no");
					}
				}
				
				

//				if(StudentsDB.addStudentRecords(sfn,sln,sfathern,smothern,sad,smn,sei,selectedGender,scd,stf,smf,cn,sadate,sdob,sc,sbt))
//				{
//					JOptionPane.showMessageDialog(null,"Add Record Successfully");
//				}
//				else
//				{
//					System.out.println("no");
//				}
//				
			}
			
		});
		
		update = new JButton("Update");
		update.setBounds(421,600,90,30);
		update.setBackground(new Color(20,66,125));
		update.setForeground(Color.white);
		update.setFont(new Font("Arial",Font.BOLD,14));
		update.setBorder(BorderFactory.createEmptyBorder());
		update.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
			
				String sfn = tfname.getText();
				String sln = tlname.getText();
				String sfathern = tfathername.getText();
				String smothern = tmothername.getText();
				String sad =  taddress.getText();
				String smn = tmobileNo.getText();
				String sei = temailId.getText();
				String scd = tcourseDuration.getText();
				String stf = ttotalFee.getText();
				String smf = tmonthlyfee.getText();
				String cn = tcounsellerName.getText();
				String sadate = tadmissiondate.getText();
				String sdob = tdob.getText();
				String sc = String.valueOf(tcourse.getSelectedItem());
				String sbt = String.valueOf(tbatchTime.getSelectedItem());
				String srn = trollno.getText();
				
				
			
				if(desideToPerform.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Search Roll number");
				}
				else if(sfn.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Name is Required");
				}
				else if(sfathern.equals("") && smothern.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Parents Name is Required both or any one");
				}
				else if(sad.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Address is Required");
				}
				else if(smn.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Mobile Number is Required");
				}
				else if(sdob.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Date Of Birth is Required");
				}
				else if(selectedGender == null)
				{
					JOptionPane.showMessageDialog(null,"Gender is Required");
				}
				else if(sc.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Course is Required");
				}
				else if(sei.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Email-Id is Required");
				}
				else if(scd.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Course Duration is Required");
				}
				else if(stf.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Total fee is Required");
				}
				else if(smf.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Monthly fee is Required");
				}
				else if(sadate.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Admission Date is Required");
				}
				else if(sbt.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Batch Time is Required");
				}
				else if(cn.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Counseller Number is Required");
				}
				else
				{
					if(StudentsDB.updateStudentRecords(srn,sfn,sln,sfathern,smothern,sad,smn,sei,selectedGender,scd,stf,smf,cn,sadate,sdob,sc,sbt))
					{
						JOptionPane.showMessageDialog(null,"Update Record Successfully");
						
						 
						tfname.setText("");
						tlname.setText("");
						tfathername.setText("");
						tmothername.setText("");
						taddress.setText("");
						tmobileNo.setText("");
						temailId.setText("");
						tcourseDuration.setText("");
						ttotalFee.setText("");
						tmonthlyfee.setText("");
						tcounsellerName.setText("");
						tadmissiondate.setText("");
						tdob.setText("");
						male.setSelected(false);
						female.setSelected(false);
						
						tcourse.setSelectedIndex(0);
						tbatchTime.setSelectedIndex(0);
						
						int tstudent = StudentsDB.getRowCount();
						if(tstudent != -1)
						{
							settotalStudentno(tstudent);
							desideToPerform = "";
						}
					}
					else
					{
						System.out.println("no");
					}
				}
				
			}
			
		});

		
		delete = new JButton("Delete");
		delete.setBounds(521,600,90,30);
		delete.setBackground(new Color(20,66,125));
		delete.setForeground(Color.white);
		delete.setFont(new Font("Arial",Font.BOLD,14));
		delete.setBorder(BorderFactory.createEmptyBorder());
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String srollno = trollno.getText();
				
				if(desideToPerform.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Search Roll number");
				}
				else
				{
					int dec = JOptionPane.showConfirmDialog(null, "Do you to want delete record","Confirmation",JOptionPane.OK_CANCEL_OPTION);
			
					if(dec == 0)
					{
						System.out.println(dec);
						System.out.println(srollno);
						
						if(StudentsDB.deleteRecord(srollno))
						{
							JOptionPane.showMessageDialog(null, "Record Delete Successfully");
							
							tfname.setText("");
							tlname.setText("");
							tfathername.setText("");
							tmothername.setText("");
							taddress.setText("");
							tmobileNo.setText("");
							temailId.setText("");
							tcourseDuration.setText("");
							ttotalFee.setText("");
							tmonthlyfee.setText("");
							tcounsellerName.setText("");
							tadmissiondate.setText("");
							tdob.setText("");
							male.setSelected(false);
							female.setSelected(false);
							
							tcourse.setSelectedIndex(0);
							tbatchTime.setSelectedIndex(0);
							
							int tstudent = StudentsDB.getRowCount();
							if(tstudent != -1)
							{
								settotalStudentno(tstudent);
								desideToPerform = "";
							}
						}
					
					}
					else
					{
						System.out.println("no");
					}
				}	
			}
			
		});
		
		cencel = new JButton("Cencel");
		cencel.setBounds(621,600,90,30);
		cencel.setBackground(new Color(20,66,125));
		cencel.setForeground(Color.white);
		cencel.setFont(new Font("Arial",Font.BOLD,14));
		cencel.setBorder(BorderFactory.createEmptyBorder());
		cencel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				tfname.setText("");
				tlname.setText("");
				tfathername.setText("");
				tmothername.setText("");
				taddress.setText("");
				tmobileNo.setText("");
				temailId.setText("");
				tcourseDuration.setText("");
				ttotalFee.setText("");
				tmonthlyfee.setText("");
				tcounsellerName.setText("");
				tadmissiondate.setText("");
				tdob.setText("");
				male.setSelected(false);
				female.setSelected(false);
				
				tcourse.setSelectedIndex(0);
				tbatchTime.setSelectedIndex(0);
				
				int tstudent = StudentsDB.getRowCount();
				if(tstudent != -1)
				{
					settotalStudentno(tstudent);
					desideToPerform = "";
				}
			}
			
		});
		
		container.add(titlebar);
		container.add(containerC);
		container.add(searchC);
		container.add(save);
		container.add(update);
		container.add(delete);
		container.add(cencel);
		
		
		
		
		
		add(container);
		
		
	}
	
	public static CNRecords getCNRecords()
	{
		return new CNRecords();
	}
	
	public static void settotalStudentno(int ts)
	{
		totalStudent.setText(String.valueOf(ts));
		trollno.setText(String.valueOf(ts+1));
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new CNRecords();
			}
		});

	}
	
	

}
