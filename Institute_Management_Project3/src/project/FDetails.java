package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.print.PrinterException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class FDetails extends JFrame{

	JPanel container,titlebar;
	JLabel Title;
	JButton mini,close;
	private Point initialClick;
	
	DefaultTableModel model;
	static JTable ftable;

	static String feecode,rollno,sname,sfathername,course,date,mfee,tfee,pfee,bfee,counseller;
	JButton print;
	
	public FDetails()
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
		
		Title = new JLabel("<html><font size=5>F</font>ee <font size=5>D</font>etails</html>");
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
		
		String fCol[] = new String[] {"Fee Code No.","Roll no.","Student Name","Father name","Course","Date","Monthly Fee","Total Fee","Paid Fee","Balance Fee","Conseller Name"};
		Object fRow[][] = new Object[][] {};
		
		model = new DefaultTableModel(fRow,fCol);
		ftable = new JTable(model);
	
		JScrollPane spftable = new JScrollPane(ftable);
		spftable.setBounds(173,120,1000,400);
		spftable.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(20,66,125)));
		
		JButton print = new JButton("Print");
		print.setBounds(1083,530,90,30);
		print.setBackground(new Color(239,79,43));
		print.setBorder(BorderFactory.createRaisedBevelBorder());
		print.setForeground(Color.white);
		print.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				try {
					ftable.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		
		container.add(spftable);
		container.add(print);
	}
	
	public static FDetails getFDetails()
	{
		return new FDetails();
	}
	
	public static void setFeeDetails()
	{
		DefaultTableModel model = (DefaultTableModel) ftable.getModel();
		
	//	static String feecode,rollno,sname,sfathername,course,date,mfee,tfee,pfee,bfee,counseller;
		Object addfee[] = new Object[] {feecode,rollno,sname,sfathername,course,date,mfee,tfee,pfee,bfee,counseller};
		model.addRow(addfee);
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
			
				new FDetails();
			}
			
		});

	}

}
