package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class SDetails extends JFrame{

	JPanel container,titlebar;
	JLabel Title;
	JButton mini,close;
	
	public static JTextField rollnot,namet,lastnamet,fathernamet,mothernamet,emailidt,mobilet,DOBt,gendert,courset,coursedurationt,totalfeet,monthlyfeet,admissiondatet,batchtimet;
	static JTextArea addresst;
	
	private Point initialClick;
	
	public SDetails()
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
		
		Title = new JLabel("<html><font size=5>S</font>tudent <font size=5>D</font>etail</html>");
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
	
		container.add(titlebar);
		add(container);
		
		
		
		
		JLabel rollno = new JLabel("Roll No");
		rollno.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		rollno.setBounds(498,50,150,30);
		
		rollnot = new JTextField(200);
		rollnot.setBounds(648,50,200,30);
		rollnot.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		rollnot.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel name = new JLabel("Name");
		name.setBounds(498,90,150,30);
		name.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		namet = new JTextField(200);
		namet.setBounds(648,90,200,30);
		namet.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		namet.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel lastname = new JLabel("Last Name");
		lastname.setBounds(498,130,150,30);
		lastname.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		lastnamet = new JTextField(200);
		lastnamet.setBounds(648,130,200,30);
		lastnamet.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		lastnamet.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel fathername = new JLabel("Father name");
		fathername.setBounds(498,170,150,30);
		fathername.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		fathernamet = new JTextField(200);
		fathernamet.setBounds(648,170,200,30);
		fathernamet.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		fathernamet.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel mothername = new JLabel("Mother name");
		mothername.setBounds(498,210,150,30);
		mothername.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		mothernamet = new JTextField(200);
		mothernamet.setBounds(648,210,200,30);
		mothernamet.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		mothernamet.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel address = new JLabel("Address");
		address.setBounds(498,250,150,30);
		address.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		addresst = new JTextArea(2,1);
		addresst.setLineWrap(true);
		addresst.setBorder(BorderFactory.createEmptyBorder());
		JScrollPane sp = new JScrollPane(addresst);
		sp.setBounds(648,250,250,40);
		sp.setBorder(BorderFactory.createEmptyBorder());
		addresst.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		JLabel emailid = new JLabel("Email Id");
		emailid.setBounds(498,300,150,30);
		emailid.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		emailidt = new JTextField(200);
		emailidt.setBounds(648,300,200,30);
		emailidt.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		emailidt.setBorder(BorderFactory.createEmptyBorder());
		
		
		JLabel mobile = new JLabel("Mobile number");
		mobile.setBounds(498,340,150,30);
		mobile.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		mobilet = new JTextField(200);
		mobilet.setBounds(648,340,200,30);
		mobilet.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		mobilet.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel DOB = new JLabel("DOB");
		DOB.setBounds(498,380,150,30);
		DOB.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		DOBt = new JTextField(200);
		DOBt.setBounds(648,380,200,30);
		DOBt.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		DOBt.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(498,420,150,30);
		gender.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		gendert = new JTextField(200);
		gendert.setBounds(648,420,200,30);
		gendert.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		gendert.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel course = new JLabel("Course");
		course.setBounds(498,460,150,30);
		course.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		courset = new JTextField(200);
		courset.setBounds(648,460,200,30);
		courset.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		courset.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel courseduration = new JLabel("Course Duration");
		courseduration.setBounds(498,500,150,30);
		courseduration.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		coursedurationt = new JTextField(200);
		coursedurationt.setBounds(648,500,200,30);
		coursedurationt.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		coursedurationt.setBorder(BorderFactory.createEmptyBorder());
		

		JLabel totalfee = new JLabel("Total Fee");
		totalfee.setBounds(498,540,150,30);
		totalfee.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		totalfeet = new JTextField(200);
		totalfeet.setBounds(648,540,200,30);
		totalfeet.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		totalfeet.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel monthlyfee = new JLabel("Monthly Fee");
		monthlyfee.setBounds(498,580,150,30);
		monthlyfee.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		monthlyfeet = new JTextField(200);
		monthlyfeet.setBounds(648,580,200,30);
		monthlyfeet.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		monthlyfeet.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel admissiondate = new JLabel("Addmission Date");
		admissiondate.setBounds(498,620,150,30);
		admissiondate.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		admissiondatet = new JTextField(200);
		admissiondatet.setBounds(648,620,200,30);
		admissiondatet.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		admissiondatet.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel batchtime = new JLabel("Batch Time");
		batchtime.setBounds(498,660,150,30);
		batchtime.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		
		batchtimet = new JTextField(200);
		batchtimet.setBounds(648,660,200,30);
		batchtimet.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,15));
		batchtimet.setBorder(BorderFactory.createEmptyBorder());
		
		container.add(rollno);
		container.add(rollnot);
		container.add(name);
		container.add(namet);
		container.add(lastname);
		container.add(lastnamet);
		container.add(fathername);
		container.add(fathernamet);
		container.add(mothername);
		container.add(mothernamet);
		container.add(address);
		container.add(sp);
		container.add(DOB);
		container.add(DOBt);
		container.add(gender);
		container.add(gendert);
		container.add(course);
		container.add(courset);
		container.add(emailid);
		container.add(emailidt);
		container.add(mobile);
		container.add(mobilet);
		container.add(courseduration);
		container.add(coursedurationt);
		container.add(totalfee);
		container.add(totalfeet);
		container.add(monthlyfee);
		container.add(monthlyfeet);
		container.add(admissiondate);
		container.add(admissiondatet);
		container.add(batchtime);
		container.add(batchtimet);
		
		
	}
	
	public static SDetails getSDetails()
	{
		return new SDetails();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new SDetails();
				
			}
			
		});

	}

}
