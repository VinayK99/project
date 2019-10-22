package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class ContactUs extends JFrame{

	JPanel container,titlebar;
	JLabel Title;
	JButton mini,close;
	private Point initialClick;
	
	public ContactUs()
	{
		setUndecorated(true);
		setVisible(true);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int width = (int) toolkit.getScreenSize().getWidth()-20;
		int height = (int) toolkit.getScreenSize().getHeight()-60;
		
		
		setSize(width,height);
		setLocationRelativeTo(null);
		setLayout(null);
		
//		ImageIcon icon = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\pexels-photo-582428.jpeg");
//		Image im =	icon.getImage();
//		Image img = im.getScaledInstance(650, 400, Image.SCALE_SMOOTH);
//		
//		setContentPane(new JLabel(new ImageIcon(img)));
		
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
		
		Title = new JLabel("<html><font size=5>C</font>ontact <font size=5>U</font>s</html>");
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
		
		JPanel contactC = new JPanel();
		contactC.setBounds(1,35,width-2,height-37);
		contactC.setLayout(null);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\backimage.jpg");
		Image im =	icon.getImage();
		Image img = im.getScaledInstance(contactC.getWidth(), contactC.getHeight(), Image.SCALE_SMOOTH);
		
		JLabel bigIcon = new JLabel(new ImageIcon(img));
		bigIcon.setBounds(1,0,contactC.getWidth(),contactC.getHeight()); 	
		
		JPanel imgBlur = new JPanel();
		imgBlur.setBounds(1,0,contactC.getWidth(),contactC.getHeight()); 
		imgBlur.setBackground(new Color(0,0,0,180));
		imgBlur.setLayout(null);
		imgBlur.setFocusable(true);
		
		
		JLabel contactT = new JLabel("Contact Us");
		contactT.setBounds(0,30,imgBlur.getWidth()-10,40);
		contactT.setForeground(Color.white);
		//contactT.setBorder(BorderFactory.createLineBorder(Color.red));
		contactT.setHorizontalAlignment(JLabel.CENTER);
		contactT.setFont(new Font("Arial",Font.BOLD,30));
		
		
		JPanel namePanel = new JPanel();
		namePanel.setBounds(432,100,480,40);
		namePanel.setBackground(Color.darkGray);
		namePanel.setLayout(null);
		
		JTextField name = new JTextField(470);
		name.setBounds(10,1,469,38);
		name.setBorder(BorderFactory.createEmptyBorder());
		name.setBackground(Color.darkGray);
		name.setForeground(Color.white);
		name.setFont(new Font("Sans-serif",Font.BOLD,16));
		name.setText("Your name");
		name.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
					
				namePanel.setBorder(BorderFactory.createLineBorder(Color.white));
				if(name.getText().equals("Your name"))
				{
					name.setText("");
				}
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {

				if(name.getText().equals(""))
				{
					name.setText("Your name");
					namePanel.setBorder(BorderFactory.createEmptyBorder());
				}
			}
			
		});
		
		namePanel.add(name);
		
		JPanel emailPanel = new JPanel();
		emailPanel.setBounds(432,150,480,40);
		emailPanel.setBackground(Color.darkGray);
		emailPanel.setLayout(null);
		
		JTextField email = new JTextField(470);
		email.setBounds(10,1,469,38);
		email.setBorder(BorderFactory.createEmptyBorder());
		email.setBackground(Color.darkGray);
		email.setForeground(Color.white);
		email.setFont(new Font("Sans-serif",Font.BOLD,16));
		email.setText("Your email");
		email.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
					
				emailPanel.setBorder(BorderFactory.createLineBorder(Color.white));
				if(email.getText().equals("Your email"))
				{
					email.setText("");
				}
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {

				if(email.getText().equals(""))
				{
					email.setText("Your email");
					emailPanel.setBorder(BorderFactory.createEmptyBorder());
				}
			}
			
		});
		
		emailPanel.add(email);
		
		JPanel ContactPanel = new JPanel();
		ContactPanel.setBounds(432,200,480,40);
		ContactPanel.setBackground(Color.darkGray);
		ContactPanel.setLayout(null);
		
		JTextField contact = new JTextField(470);
		contact.setBounds(10,1,469,38);
		contact.setBorder(BorderFactory.createEmptyBorder());
		contact.setBackground(Color.darkGray);
		contact.setForeground(Color.white);
		contact.setFont(new Font("Sans-serif",Font.BOLD,16));
		contact.setText("Your contact");
		contact.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
					
				ContactPanel.setBorder(BorderFactory.createLineBorder(Color.white));
				if(contact.getText().equals("Your contact"))
				{
					contact.setText("");
				}
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {

				if(contact.getText().equals(""))
				{
					contact.setText("Your contact");
					ContactPanel.setBorder(BorderFactory.createEmptyBorder());
				}
			}
			
		});
		
		ContactPanel.add(contact);
		
		JPanel coursePanel = new JPanel();
		coursePanel.setBounds(432,250,480,40);
		coursePanel.setBackground(Color.darkGray);
		coursePanel.setLayout(null);
		
		JTextField course = new JTextField(470);
		course.setBounds(10,1,469,38);
		course.setBorder(BorderFactory.createEmptyBorder());
		course.setBackground(Color.darkGray);
		course.setForeground(Color.white);
		course.setFont(new Font("Sans-serif",Font.BOLD,16));
		course.setText("Your course");
		course.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
					
				coursePanel.setBorder(BorderFactory.createLineBorder(Color.white));
				if(course.getText().equals("Your course"))
				{
					course.setText("");
				}
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {

				if(course.getText().equals(""))
				{
					course.setText("Your course");
					coursePanel.setBorder(BorderFactory.createEmptyBorder());
				}
			}
			
		});
		
		coursePanel.add(course);
		

		JPanel messagePanel = new JPanel();
		messagePanel.setBounds(432,300,480,80);
		messagePanel.setBackground(Color.darkGray);
		messagePanel.setLayout(null);
		
		JTextArea message = new JTextArea(2,1);
		message.setBackground(Color.darkGray);
		message.setForeground(Color.white);
		message.setFont(new Font("Sans-serif",Font.BOLD,16));
		message.setText("Your message");
		message.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
					
				messagePanel.setBorder(BorderFactory.createLineBorder(Color.white));
				if(message.getText().equals("Your message"))
				{
					message.setText("");
				}
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {

				if(message.getText().equals(""))
				{
					message.setText("Your message");
					messagePanel.setBorder(BorderFactory.createEmptyBorder());
				}
			}
			
		});
		
		JScrollPane messageScroll = new JScrollPane(message);
		messageScroll.setBounds(10,1,469,78);
		messageScroll.setBorder(BorderFactory.createEmptyBorder());
		
		messagePanel.add(messageScroll);
		
		JButton send = new JButton("Send");
		send.setBounds(822,420,90,30);
		send.setBorder(BorderFactory.createRaisedBevelBorder());
		send.setBackground(Color.darkGray);
		send.setForeground(Color.white);
		send.setFont(new Font("Sans-serif",Font.BOLD,14));
		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(name.getText().equalsIgnoreCase("Your name") || name.getText().equals(" "))
				{
					JOptionPane.showMessageDialog(null,"Name is required");
				}
				else if(email.getText().equalsIgnoreCase("Your email") || email.getText().equals(" "))
				{
					JOptionPane.showMessageDialog(null,"Email is required");
				}
				else if(contact.getText().equalsIgnoreCase("Your contact") || contact.getText().equals(" "))
				{
					JOptionPane.showMessageDialog(null,"Contact is required");
				}
				else if(course.getText().equalsIgnoreCase("Your course") || course.getText().equals(" "))
				{
					JOptionPane.showMessageDialog(null,"Course is required");
				}
				else if(message.getText().equalsIgnoreCase("Your message") || message.getText().equals(" "))
				{
					JOptionPane.showMessageDialog(null,"You don't entered message");
				}
			}
			
		});
		
		//1344
		
		imgBlur.add(contactT);
		imgBlur.add(namePanel);
		imgBlur.add(emailPanel);
		imgBlur.add(ContactPanel);
		imgBlur.add(coursePanel);
		imgBlur.add(messagePanel);
		imgBlur.add(send);
		
		contactC.add(imgBlur);
		contactC.add(bigIcon);
		
		
		container.add(titlebar);
		container.add(contactC);
		
		add(container);
		
		
	
	}
	
	public static ContactUs getContactUs()
	{
		return new ContactUs();
	}
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new ContactUs();
			}
		});
	}

}
