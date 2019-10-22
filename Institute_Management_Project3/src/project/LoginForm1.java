package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class LoginForm1 extends JFrame implements ActionListener{

	JPanel header;
	JPanel containLF;
	JButton login,register,close,minimize,Student,Admin,submit;
	JLabel or;
	JTextField name;
	JPasswordField password;
	JLabel forgetP;
	
	private Point initialClick;
	
	
	public LoginForm1()
	{
		setUndecorated(true);
		setVisible(true);
		
		setSize(new Dimension(400,400));
		setLocationRelativeTo(null);
	
		setLayout(null);
		
		containLF = new JPanel();
		containLF.setBounds(0,0,400,400);
		containLF.setBackground(new Color(42,46,55));
		containLF.setLayout(null);
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
				System.exit(0);
				
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
		
		Student = new JButton("Student");
		Student.setBounds(80,80,100,30);
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
		
		Admin = new JButton("Admin");
		Admin.setBounds(220,80,100,30);
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
		
		
		or = new JLabel("Or");
		or.setBounds(180,80,40,30);
		or.setForeground(new Color(255,255,255));
		or.setFont(new Font("arial",Font.BOLD,17));
		or.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,new Color(255,255,255)));
		or.setHorizontalAlignment(SwingConstants.CENTER);
		or.setEnabled(false);
		
		name = new JTextField(300);
		name.setBounds(50, 150, 300, 35);
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
		password.setBounds(50, 200, 300, 35);
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
		submit.setBounds(50,270,100,30);
		submit.setForeground(new Color(255,255,255));
		submit.setBackground(new Color(42,46,55));
		submit.setFont(new Font("arial",Font.BOLD,17));
		submit.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(6,117,144)));
		submit.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e)
			{
				
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
		forgetP.setBounds(140,320,120,20);
		forgetP.setForeground(new Color(255,255,255));
		forgetP.setHorizontalAlignment(SwingConstants.CENTER);
		forgetP.setFont(new Font("Dialog",Font.BOLD,15));
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
		
		containLF.add(header);
		containLF.add(Student);
		containLF.add(or);
		containLF.add(Admin);
		containLF.add(name);
		containLF.add(password);
		containLF.add(submit);
		containLF.add(forgetP);
		
		
		/*ImageIcon icon = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\apple-computer-desk-209151.jpg");
		Image img = icon.getImage();
		Image img1 = img.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		setContentPane(new JLabel(new ImageIcon(img1)));*/
		
		add(containLF);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Login"))
		{
			login.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(132,209,173)));
			register.setBorder(BorderFactory.createEmptyBorder());
			
		}
		else if(e.getActionCommand().equals("Register"))
		{
			register.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(132,209,173)));
			login.setBorder(BorderFactory.createEmptyBorder());
			
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new LoginForm1();
			}
		});

	}
	

}
