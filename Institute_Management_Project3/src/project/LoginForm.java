package project;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
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

import javax.swing.*;

public class LoginForm extends JFrame implements ActionListener{

	JPanel header;
	JPanel containLF;
	JPanel coL;
	JPanel coR;
	JButton login,register,close,minimize,Student,Admin,submit;
	JButton StudentR,AdminR,submitR;
	JLabel or,orR;
	JTextField name,nameR,contact,gmail;
	JPasswordField password,passwordR,againPasswordR;
	JLabel forgetP;
	CardLayout cLayout = new CardLayout();
	
	private String username,ucontactno,upass,urepass,ugmail,userType=null;
	
	private Point initialClick;
	
	public LoginForm()
	{
		setUndecorated(true);
	//	setVisible(true);
		
		setSize(new Dimension(400,400));
		setLocation(330,130);
	
		setLayout(null);
		
		containLF = new JPanel();
		containLF.setBounds(0,30,400,400);
		containLF.setBackground(new Color(42,46,55));
		containLF.setLayout(cLayout);
		containLF.setFocusable(true);
		
		header = new JPanel();
		header.setBounds(0,0,400,30);
		header.setBackground(new Color(53,53,53));
		header.setLayout(null);
		
		login = new JButton("Login");
		login.setBounds(0,0,70,30);
		login.setForeground(new Color(255,255,255));
		login.setBackground(new Color(53,53,53));
		login.setFont(new Font("arial",Font.BOLD,16));
		login.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(132,209,173)));
		login.addActionListener(this);
	
		register = new JButton("Register");
		register.setBounds(72,0,90,30);
		register.setForeground(new Color(255,255,255));
		register.setBackground(new Color(53,53,53));
		register.setFont(new Font("arial",Font.BOLD,16));
		register.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,new Color(255,255,255)));
		register.addActionListener(this);
		
		minimize = new JButton("<html>&minus</html>");
		minimize.setBounds(338,0,30,30);
		minimize.setForeground(new Color(255,255,255));
		minimize.setBackground(new Color(53,53,53));
		minimize.setFont(new Font("arial",Font.BOLD,17));
		minimize.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,new Color(255,255,255)));
		minimize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setState(JFrame.ICONIFIED);
			}
			
		});
		
		close = new JButton("<html>X</html>");
		close.setBounds(368,0,32,30);
		close.setForeground(new Color(255,255,255));
		close.setBackground(new Color(53,53,53));
		close.setFont(new Font("arial",Font.BOLD,17));
		close.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,new Color(255,255,255)));
		close.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e)
			{
				//System.exit(0);
				setVisible(false);
				
			}
			public void mouseEntered(MouseEvent e)
			{
				close.setBackground(new Color(177,14,14));
			}
			public void mouseExited(MouseEvent e)
			{
				close.setBackground(new Color(53,53,53));
			}
			
		});
		
		
		
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
		
		coL = new JPanel();
		coL.setLayout(null);
		coL.setBackground(new Color(42,46,55));
		
		Student = new JButton("Student");
		Student.setBounds(80,50,100,30);
		Student.setForeground(new Color(255,255,255));
		Student.setBackground(new Color(132,209,173));
		Student.setFont(new Font("arial",Font.BOLD,17));
		Student.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(132,209,173)));
		Student.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e)
			{
				Student.setForeground(new Color(6,117,144));
				Student.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(6,117,144)));
				Admin.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(132,209,173)));
				Admin.setForeground(new Color(255,255,255));
			}
			
			public void mouseEntered(MouseEvent e)
			{
				Student.setBackground(new Color(132,209,173));
				
			}
			
			public void mouseExited(MouseEvent e)
			{
				Student.setBackground(new Color(42,46,55));
			}
		});
		
		Student.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				userType = e.getActionCommand();
				
			}
			
		});
		
		Admin = new JButton("Admin");
		Admin.setBounds(220,50,100,30);
		Admin.setForeground(new Color(255,255,255));
		Admin.setBackground(new Color(42,46,55));
		Admin.setFont(new Font("arial",Font.BOLD,17));
		Admin.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(132,209,173)));
		Admin.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e)
			{
				Admin.setForeground(new Color(6,117,144));
				Admin.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(6,117,144)));
				Student.setForeground(new Color(255,255,255));
				Student.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(132,209,173)));
			}
			
			public void mouseEntered(MouseEvent e)
			{
				Admin.setBackground(new Color(132,209,173));
			}
			
			public void mouseExited(MouseEvent e)
			{
				Admin.setBackground(new Color(42,46,55));
			}
		});
		
		Admin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				userType = e.getActionCommand();
				
			}
			
		});
		
		
		or = new JLabel("Or");
		or.setBounds(180,50,40,30);
		or.setForeground(new Color(255,255,255));
		or.setFont(new Font("arial",Font.BOLD,17));
		or.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,new Color(255,255,255)));
		or.setHorizontalAlignment(SwingConstants.CENTER);
		or.setEnabled(false);
		
		name = new JTextField(300);
		name.setBounds(50, 130, 300, 35);
		name.setForeground(new Color(190,190,190));
		name.setBackground(new Color(42,46,55));
		name.setFont(new Font("arial",Font.BOLD,17));
		name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(190,190,190)));
		name.setText("Username");
		name.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				if(name.getText().trim().equals("Username"))
				{
					name.setText("");
				}
		
				name.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(6,117,144)));
				name.setForeground(new Color(255,255,255));
			}

		
			public void focusLost(FocusEvent e) {

				if(name.getText().trim().equals(""))
				{
					name.setText("Username");
					name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(190,190,190)));
					name.setForeground(new Color(190,190,190));
				}
				
				
				
			}

			
		});
		
		password = new JPasswordField(300);
		password.setBounds(50, 170, 300, 35);
		password.setForeground(new Color(190,190,190));
		password.setBackground(new Color(42,46,55));
		password.setFont(new Font("arial",Font.BOLD,17));
		password.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(190,190,190)));
		password.setText("Password");
		password.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				if(password.getText().trim().equals("Password"))
				{
					password.setText("");
				}
		
				password.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(6,117,144)));
				password.setForeground(new Color(255,255,255));
			}

		
			public void focusLost(FocusEvent e) {

				if(password.getText().trim().equals(""))
				{
					password.setText("Password");
					password.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(190,190,190)));
					password.setForeground(new Color(190,190,190));
				}
				
				
				
			}

			
		});
		
		submit = new JButton("Submit");
		submit.setBounds(50,240,100,30);
		submit.setForeground(new Color(255,255,255));
		submit.setBackground(new Color(42,46,55));
		submit.setFont(new Font("arial",Font.BOLD,17));
		submit.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(6,117,144)));
		submit.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e)
			{
				username = name.getText();
				upass = password.getText();
				
				if(username.equals("Username"))
				{
					JOptionPane.showMessageDialog(null, "Enter Name");
				}
				else if(upass.equals("Password"))
				{
					JOptionPane.showMessageDialog(null, "Enter Password");
				}
				else if(userType == null)
				{
					JOptionPane.showMessageDialog(null, "Choose User Type");
				}
				else
				{
					if(StudentsDB.login(username,userType))
					{
						String uname = StudentsDB.confirmPassword(upass);
				
						if(uname.equals(username))
						{
							Project.userName.setText(uname);
							Project.fLetter.setText(uname.substring(0,1));
							setVisible(false);
							if(userType.equals("Admin"))
							{
								Project.controllLayout();
							}
							if(userType.equals("Student"))
							{
								StudentsDB.setSDetails();
							}
							
						}				
						else if(uname.equals("-1"))
						{
							JOptionPane.showMessageDialog(null,"Wrong Password");
						}
					}
					else
					{
//						JOptionPane.showMessageDialog(null, "Invalid Id");
						JOptionPane.showMessageDialog(null, "You Don't Register");
					}
				}
				
				
			}
			
			public void mouseEntered(MouseEvent e)
			{
				submit.setBackground(new Color(6,117,144));
			}
			
			public void mouseExited(MouseEvent e)
			{
				submit.setBackground(new Color(42,46,55));
			}
		});
		
		
		forgetP = new JLabel("Foget Password");
		forgetP.setBounds(140,300,120,20);
		forgetP.setForeground(new Color(255,255,255));
		forgetP.setHorizontalAlignment(SwingConstants.CENTER);
		forgetP.setFont(new Font("Dialog",Font.BOLD,15));
		forgetP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		forgetP.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e)
			{
				
			}
			
			public void mouseEntered(MouseEvent e)
			{
				forgetP.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(6,117,144)));
				
			}
			
			public void mouseExited(MouseEvent e)
			{
				forgetP.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,new Color(6,117,144)));
			}
		});
		
		
		header.add(login);
		header.add(register);
		header.add(minimize);
		header.add(close);
	
		
		coL.add(Student);
		coL.add(or);
		coL.add(Admin);
		coL.add(name);
		coL.add(password);
		coL.add(submit);
		coL.add(forgetP);
		
		//card 2
		coR = new JPanel();
		coR.setLayout(null);
		coR.setBackground(new Color(42,46,55));
		
		
		StudentR = new JButton("Student");
		StudentR.setBounds(80,50,100,30);
		StudentR.setForeground(new Color(255,255,255));
		StudentR.setBackground(new Color(132,209,173));
		StudentR.setFont(new Font("arial",Font.BOLD,17));
		StudentR.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(132,209,173)));
		StudentR.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e)
			{
				StudentR.setForeground(new Color(6,117,144));
				StudentR.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(6,117,144)));
				AdminR.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(132,209,173)));
				AdminR.setForeground(new Color(255,255,255));
			}
			
			public void mouseEntered(MouseEvent e)
			{
				StudentR.setBackground(new Color(132,209,173));
				
			}
			
			public void mouseExited(MouseEvent e)
			{
				StudentR.setBackground(new Color(42,46,55));
			}
		});
		
		StudentR.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				userType = e.getActionCommand();
				
			}
			
		});
		
		AdminR = new JButton("Admin");
		AdminR.setBounds(220,50,100,30);
		AdminR.setForeground(new Color(255,255,255));
		AdminR.setBackground(new Color(42,46,55));
		AdminR.setFont(new Font("arial",Font.BOLD,17));
		AdminR.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(132,209,173)));
		AdminR.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e)
			{
				AdminR.setForeground(new Color(6,117,144));
				AdminR.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(6,117,144)));
				StudentR.setForeground(new Color(255,255,255));
				StudentR.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(132,209,173)));
			}
			
			public void mouseEntered(MouseEvent e)
			{
				AdminR.setBackground(new Color(132,209,173));
			}
			
			public void mouseExited(MouseEvent e)
			{
				AdminR.setBackground(new Color(42,46,55));
			}
		});
		
		AdminR.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				userType = e.getActionCommand();
				
			}
			
		});
		
		orR = new JLabel("Or");
		orR.setBounds(180,50,40,30);
		orR.setForeground(new Color(255,255,255));
		orR.setFont(new Font("arial",Font.BOLD,17));
		orR.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,new Color(255,255,255)));
		orR.setHorizontalAlignment(SwingConstants.CENTER);
		orR.setEnabled(false);
		
		nameR = new JTextField(300);
		nameR.setBounds(50, 130, 300, 35);
		nameR.setForeground(new Color(190,190,190));
		nameR.setBackground(new Color(42,46,55));
		nameR.setFont(new Font("arial",Font.BOLD,17));
		nameR.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(190,190,190)));
		nameR.setText("Username");
		nameR.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				if(nameR.getText().trim().equals("Username"))
				{
					nameR.setText("");
				}
		
				nameR.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(6,117,144)));
				nameR.setForeground(new Color(255,255,255));
			}

		
			public void focusLost(FocusEvent e) {

				if(nameR.getText().trim().equals(""))
				{
					nameR.setText("Username");
					nameR.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(190,190,190)));
					nameR.setForeground(new Color(190,190,190));
				}
				
				
				
			}

			
		});
		
		contact = new JTextField(300);
		contact.setBounds(50, 170, 300, 35);
		contact.setForeground(new Color(190,190,190));
		contact.setBackground(new Color(42,46,55));
		contact.setFont(new Font("arial",Font.BOLD,17));
		contact.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(190,190,190)));
		contact.setText("Contact");
		contact.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				if(contact.getText().trim().equals("Contact"))
				{
					contact.setText("");
				}
		
				contact.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(6,117,144)));
				contact.setForeground(new Color(255,255,255));
			}

		
			public void focusLost(FocusEvent e) {

				if(contact.getText().trim().equals(""))
				{
					contact.setText("Contact");
					contact.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(190,190,190)));
					contact.setForeground(new Color(190,190,190));
				}
				
				
				
			}

			
		});
		
		contact.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();
				if(!Character.isDigit(c))
				{
					e.consume();
				}
				if(contact.getText().length() >= 10)
				{
					e.consume();
				}
			}
			
		});


		gmail = new JTextField(300);
		gmail.setBounds(50, 210, 300, 35);
		gmail.setForeground(new Color(190,190,190));
		gmail.setBackground(new Color(42,46,55));
		gmail.setFont(new Font("arial",Font.BOLD,17));
		gmail.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(190,190,190)));
		gmail.setText("Gmail-Id");
		gmail.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				if(gmail.getText().trim().equals("Gmail-Id"))
				{
					gmail.setText("");
				}
		
				gmail.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(6,117,144)));
				gmail.setForeground(new Color(255,255,255));
			}

		
			public void focusLost(FocusEvent e) {

				if(gmail.getText().trim().equals(""))
				{
					gmail.setText("Gmail-Id");
					gmail.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(190,190,190)));
					gmail.setForeground(new Color(190,190,190));
				}
				
				
				
			}

			
		});
		
		
		passwordR = new JPasswordField(300);
		passwordR.setBounds(50, 250, 300, 35);
		passwordR.setForeground(new Color(190,190,190));
		passwordR.setBackground(new Color(42,46,55));
		passwordR.setFont(new Font("arial",Font.BOLD,17));
		passwordR.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(190,190,190)));
		passwordR.setText("Password");
		passwordR.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				if(passwordR.getText().trim().equals("Password"))
				{
					passwordR.setText("");
				}
		
				passwordR.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(6,117,144)));
				passwordR.setForeground(new Color(255,255,255));
			}

		
			public void focusLost(FocusEvent e) {

				if(passwordR.getText().trim().equals(""))
				{
					passwordR.setText("Password");
					passwordR.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(190,190,190)));
					passwordR.setForeground(new Color(190,190,190));
				}
				
				
				
			}

			
		});

		
		againPasswordR = new JPasswordField(300);
		againPasswordR.setBounds(50, 290, 300, 35);
		againPasswordR.setForeground(new Color(190,190,190));
		againPasswordR.setBackground(new Color(42,46,55));
		againPasswordR.setFont(new Font("arial",Font.BOLD,17));
		againPasswordR.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(190,190,190)));
		againPasswordR.setText("Password");
		againPasswordR.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				if(againPasswordR.getText().trim().equals("Password"))
				{
					againPasswordR.setText("");
				}
		
				againPasswordR.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(6,117,144)));
				againPasswordR.setForeground(new Color(255,255,255));
			}

		
			public void focusLost(FocusEvent e) {

				if(againPasswordR.getText().trim().equals(""))
				{
					againPasswordR.setText("Password");
					againPasswordR.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(190,190,190)));
					againPasswordR.setForeground(new Color(190,190,190));
				}
				
				
				
			}

			
		});

		submitR = new JButton("Submit");
		submitR.setBounds(50,355,100,30);
		submitR.setForeground(new Color(255,255,255));
		submitR.setBackground(new Color(42,46,55));
		submitR.setFont(new Font("arial",Font.BOLD,17));
		submitR.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(6,117,144)));
		submitR.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e)
			{
				username = nameR.getText();
				ucontactno = contact.getText();
				ugmail = gmail.getText();
				upass = passwordR.getText();
				urepass = againPasswordR.getText();
				
				
				
					if(username.equals("Username"))
					{
						JOptionPane.showMessageDialog(null, "Enter Name !!!");
					}
					else if(ucontactno.equals("Contact"))
					{
						JOptionPane.showMessageDialog(null, "Enter Contact Number !!!");
					}
					else if(ugmail.equals("Gmail-Id"))
					{
						JOptionPane.showMessageDialog(null, "Enter Gmail-ID !!!");
					}
					else if(upass.equals("Password"))
					{
						JOptionPane.showMessageDialog(null, "Enter Password !!!");
					}
					else if(urepass.equals("Password"))
					{
						JOptionPane.showMessageDialog(null, "Enter Re-Password !!!");
					}
					else if(userType == null)
					{
						JOptionPane.showMessageDialog(null, "Choose UserType");
					}
					else if(!urepass.equals(upass))
					{
						JOptionPane.showMessageDialog(null, "Re-Password is not a Same !!!");
					}
					else
					{
						if(userType.equals("Student"))
						{
							if(StudentsDB.selectSomeSRecord(username,ucontactno,ugmail))
							{
								if(StudentsDB.insertRegister(ucontactno,username,ugmail,upass,userType))
								{
									JOptionPane.showMessageDialog(null, "Register Successfully !!!");
									cLayout.show(containLF, "login");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Invalid user");
							}
						}
						if(userType.equals("Admin"))
						{

							if(StudentsDB.selectSomeFRecord(username,ucontactno,ugmail))
							{
								if(StudentsDB.insertRegister(ucontactno,username,ugmail,upass,userType))
								{
									JOptionPane.showMessageDialog(null, "Register Successfully !!!");
									cLayout.show(containLF, "login");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Invalid user");
							}
						}
						
					}
				
				
				
				
				
			}
			
			public void mouseEntered(MouseEvent e)
			{
				submitR.setBackground(new Color(6,117,144));
			}
			
			public void mouseExited(MouseEvent e)
			{
				submitR.setBackground(new Color(42,46,55));
			}
		});



		

		coR.add(StudentR);
		coR.add(orR);
		coR.add(AdminR);
		coR.add(nameR);
		coR.add(contact);
		coR.add(gmail);
		coR.add(passwordR);
		coR.add(againPasswordR);
		coR.add(submitR);
		
		
		containLF.add(coL,"login");
		containLF.add(coR,"register");
				
		/*ImageIcon icon = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\apple-computer-desk-209151.jpg");
		Image img = icon.getImage();
		Image img1 = img.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		setContentPane(new JLabel(new ImageIcon(img1)));*/
		
		add(header);
		add(containLF);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Login"))
		{
			login.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(132,209,173)));
			register.setBorder(BorderFactory.createEmptyBorder());
			cLayout.show(containLF, "login");
			
			setSize(new Dimension(400,400));
			containLF.setBounds(0,30,400,400);
			
		}
		else if(e.getActionCommand().equals("Register"))
		{
			register.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(132,209,173)));
			login.setBorder(BorderFactory.createEmptyBorder());
			cLayout.show(containLF, "register");
			
			setSize(new Dimension(400,450));
			containLF.setBounds(0,30,400,450);
			
		}
	}
	
	
	public static LoginForm getLoginForm()
	{
		return new LoginForm();
	}
	
	
	
	
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new LoginForm();
			}
		});

	}
	

}
