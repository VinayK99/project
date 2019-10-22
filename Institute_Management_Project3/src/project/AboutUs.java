package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class AboutUs extends JFrame{

	JPanel container,titlebar;
	JLabel Title;
	JButton mini,close;
	private Point initialClick;
	
	public AboutUs()
	{
		setUndecorated(true);
		setVisible(true);
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
		
		Title = new JLabel("<html><font size=5>A</font>bout <font size=5>U</font>s</html>");
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
		
		
		
		JPanel textAreaAbout = new JPanel();
		textAreaAbout.setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane(textAreaAbout);
		sp.setBounds(2,35,width-4,height-37);
		
		JPanel p = new JPanel();
		p.setBackground(Color.white);
		
		JLabel aboutT = new JLabel("<html><body width=1300><p style='font-size:20px; color:blue; margin-top:10px;'>About IICS</p>"
				+ "<p style='font-size:13px;margin-top:10px;'>IICS stands for Indian Intitute Of Computer Science. It is the best <b>IT traning institute in delhi<b>, which provides a varity of"
				+ "programs and courses at an affordable cost. We are the <b>Best DOEACC Institute in delhi</b>, known for the excellence, quality and"
				+ "consistency. We have well qualified ad experience faculties in various streams, who doesn't only provide computer courses, but also helps in"
				+ "personality development of the student.</p>"
				
				+"<p style='font-size:13px;margin-top:10px;'>IICS is the Best NIELIT institute in delhi, which provides quaity training in software development, hardware and networking,"
				+ "multimedia and animatin and short term courses. IICS provides diploma, advance diploma and master diploma in various career oriented"
				+ "courses. All programs have different fee stucture and time duration. The academics of all courses are up-to-date and specially designed for a better career"
				+ "of the students. </p>"
				
				+"<p style='font-size:13px;margin:10px 0px 70px;'>IICS has a state-of-the-art-infrastructure with sufficient space and relevent environment."
				+ "In our institute, we have separate system of every students for every student, so that he/she can lear better. We are the leader in providing the animation courses in Delhi."
				+ "So if you are looking for a leading Max training institute in Delhi and Maya tranining institute in Delhi, then grap your seats aat IICS. We are well eatablished are"
				+ "technically skilled, as they work on a daily basis to maintain their expetise and knowledge. One can approach us direcltly by reaching our institute and get the admission in placement based "
				+ "courses. After completing course from IICS, you will definitely get good career opportunities in life.</p>"
				+ "</p></body></html>");
		
		p.add(aboutT);
		
		JPanel p2 = new JPanel();
		JPanel innerp2 = new JPanel();
		p2.setBackground(Color.white);
		innerp2.setBackground(Color.white);
		innerp2.setLayout(new BorderLayout());
		
		ImageIcon icon = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\pexels-photo-582428.jpeg");
		Image im =	icon.getImage();
		Image img = im.getScaledInstance(650, 400, Image.SCALE_SMOOTH);
		
		ImageIcon icon2 = new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Institute_Management_Project\\src\\image\\pexels-photo-920381.jpeg");
		Image im2 =	icon2.getImage();
		Image img2 = im2.getScaledInstance(650, 400, Image.SCALE_SMOOTH);
		
		JLabel image1 = new JLabel(new ImageIcon(img));
		JLabel breakImg = new JLabel("<html><br><br><br><br><br><br></html>");
		JLabel image2 = new JLabel(new ImageIcon(img2));
		
	
		innerp2.add(image1,BorderLayout.NORTH);
		innerp2.add(breakImg,BorderLayout.CENTER);
		innerp2.add(image2,BorderLayout.SOUTH);
		
		p2.add(innerp2);
		
		JPanel p3 = new JPanel();
		p3.setBackground(Color.white);
		
		JLabel mission = new JLabel("<html><body width=1300><p style='font-size:20px; color:blue; margin:40px 0px 10px'>Mission</p>"
				+ "<p style='font-size:13px;'>We aspire to be the premier educational institute, which works to build active and creative minds with a sence of better"
				+ "technology understanding. we have a ready skilled manpower to help our student in spiritual, technical, physical, emotional, instellenctual"
				+ "and moral development.</p>"
				+ "<p style='font-size:20px; color:blue; margin:40px 0px 10px'>Vision</p>"
				+ "<p style='font-size:13px;margin-bottom:50px;'>We want to achieve unparalleled standards of quality It education in an inexpensive fee stucture."
				+ "We are working to create leading It profession of global standards that will contribute towads the technical and economical growth og our country."
				+ "Life is all about making the right choices, so choose your career at IICS and become an IT professional.</p>"
				+ "</body></html>");
		
		p3.add(mission);
		
		textAreaAbout.add(p,BorderLayout.NORTH);
		textAreaAbout.add(p2,BorderLayout.CENTER);
		textAreaAbout.add(p3,BorderLayout.SOUTH);
		
		container.add(titlebar);
		container.add(sp);
		
		add(container);

	}
	
	public static AboutUs getAboutUs()
	{
		return new AboutUs();
	}
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			
			public void run()
			{
				new AboutUs();
			}
		});
		
	}

}
