package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.print.PrinterException;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class OverAllSDetails extends JFrame{

	JPanel container,titlebar;
	JLabel Title;
	JButton mini,close;
	static JTextField searchbox,totalS,Sstudying,leftS;
	static JTable Stable;
	
	static DefaultTableModel model;
	
	static String srn = null;
	static String sfn = null;
	static String sln = null;
	static String sfathern = null;
	static String smothern = null;
	static String sad =  null;
	static String smn = null;
	static String sei = null;
	static String scd = null;
	static String stf = null;
	static String smf = null;
	static String cn = null;
	static String sadate = null;
	static String sdob = null;
	static String sc = null;
	static String sbt = null;
	static String gender = null;
	
	
	private Point initialClick;
	
	public OverAllSDetails()
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
		
		titlebar = new JPanel();
		titlebar.setBounds(0,0,width,35);
		titlebar.setBackground(new Color(20,66,125));
		titlebar.setLayout(null);
		
		Title = new JLabel("<html><font size=5>O</font>verall <font size=5>S</font>tudents <font size=5>D</font>etails</html>");
		Title.setBounds(0,0,1296,35);
		Title.setBackground(Color.red);
		Title.setForeground(new Color(255,255,255));
		Title.setHorizontalAlignment(JLabel.CENTER);
		Title.setFont(new Font("Dialog",Font.BOLD,15));
		titlebar.add(Title);
	

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
		
		searchbox = new JTextField(200);//1346-200=1146/2=573
		searchbox.setBounds(573,55,200,30);
		searchbox.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(20,66,125)));
		searchbox.setHorizontalAlignment(JLabel.CENTER);
		searchbox.setFont(new Font("Arial",Font.PLAIN,15));
		searchbox.setText("Search");
		searchbox.setForeground(Color.gray);
		searchbox.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e)
			{
				String query = searchbox.getText();
				filter(query);
				
			}
		});
		
		searchbox.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				
				searchbox.setText("");
				searchbox.setForeground(Color.darkGray);
			}

			@Override
			public void focusLost(FocusEvent arg0) {

				if(searchbox.getText().equals(""))
				{
					searchbox.setText("Search");
					searchbox.setForeground(Color.gray);
				}
				
			}
			
		});
	
		
		
		String[] SColName = new String[] {"Roll no.","Student First Name","Student Last Name","Father Name","Mother Name","Address"
				, "Mobile Number","Date Of Birth","Gender","Course","Email Id","Course Duration","Total fee","Monthly Fee"
				, "Admission Date","Batch Time","Counseller Name"};
		
		Object SRecords[][] = new Object[][] {};
		
		DefaultTableModel DTableModel = new DefaultTableModel(SRecords,SColName);
		
		DefaultTableCellRenderer DTableRenderer = new DefaultTableCellRenderer();
		DTableRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		Stable = new JTable(DTableModel);
		Stable.setBackground(Color.white);
		Stable.setDefaultRenderer(Object.class,DTableRenderer);
	
		
		JScrollPane STP = new JScrollPane(Stable);
		STP.setPreferredSize(new Dimension(width-100,height-100));
		STP.setBounds(20,100,1306,540);
		STP.setBackground(Color.white);
		
		totalS = new JTextField(100);
		totalS.setBounds(20,650,100,45);
		totalS.setBorder(new TitledBorder(new EtchedBorder(),"Total Students"));
		totalS.setFont(new Font("Arial",Font.BOLD,15));
		totalS.setHorizontalAlignment(JLabel.CENTER);
		totalS.setEditable(false);
		
		Sstudying = new JTextField(100);
		Sstudying.setBounds(130,650,125,45);
		Sstudying.setBorder(new TitledBorder(new EtchedBorder(),"Students Studying"));
		Sstudying.setFont(new Font("Arial",Font.BOLD,15));
		Sstudying.setHorizontalAlignment(JLabel.CENTER);
		Sstudying.setEditable(false);
		
		leftS = new JTextField(100);
		leftS.setBounds(265,650,100,45);
		leftS.setBorder(new TitledBorder(new EtchedBorder(),"Left Students"));
		leftS.setFont(new Font("Arial",Font.BOLD,15));
		leftS.setHorizontalAlignment(JLabel.CENTER);
		leftS.setEditable(false);
		
		
		
		
		container.add(titlebar);
		container.add(searchbox);
		container.add(STP);
		container.add(totalS);
		container.add(Sstudying);
		container.add(leftS);
		
		add(container);
	}
	
	public static OverAllSDetails getOverAllSDetails()
	{
		return new OverAllSDetails();
	}
	
	public static void ShowRecords()
	{
		model = (DefaultTableModel) Stable.getModel();
		
		Object sr[] = new Object[] {srn,sfn,sln,sfathern,smothern,sad,smn,sdob,gender,sc,sei,scd,stf,smf,sadate,sbt,cn};
		model.addRow(sr);
		
		Sstudying.setText(String.valueOf(Stable.getRowCount()));
		
		
		
	}
	
	public void filter(String query)
	{
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		Stable.setRowSorter(tr);
		
		tr.setRowFilter(RowFilter.regexFilter(query));
	}
	
	public static void settotalStudentno(int tstudent)
	{
		totalS.setText(String.valueOf(tstudent));
		int ts = Integer.parseInt(totalS.getText());
		int ss = Integer.parseInt(Sstudying.getText());
		leftS.setText(String.valueOf(ts-ss));
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {	
				new OverAllSDetails();
			}
			
		});

	}

}
