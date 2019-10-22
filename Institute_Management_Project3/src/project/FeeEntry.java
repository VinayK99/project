package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FeeEntry extends JFrame {

	JPanel container,titlebar;
	JLabel Title;
	JButton mini,close;
	
	JLabel feeEntryTitle;
	static JTextField feecode,rollno,sname,sfathername,course,mfee,tfee,pfee,bfee,amountIW,date,counseller;
	JPanel inputp;
	JButton add,update,delete,clear;

	JPanel searchC;
	JTextField searchbox;
	static JTable ftable;
	static DefaultTableModel model;
	
	boolean dateCorrect=true;
	
	static String fc = null;
	static String rn = null;
	static String sn = null;
	static String sfn = null;
	static String mf = null;
	static String tf = null;
	static String pf = null;
	static String bf = null;
	static String d = null;
	static String cn = null ;
	static String co = null;
	
	String desideToAdd ="";
	
	private Point initialClick;
	
	public FeeEntry()
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
		
		Title = new JLabel("<html><font size=5>F</font>ee <font size=5>E</font>ntry</html>");
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
		
	//	JTextField feecode,rollno,sname,sfathername,mfee,tfee,pfee,amountIW,date;
//		feeEntryTitle = new JLabel("Fee Entry");
//		feeEntryTitle.setBounds(15,60,400,40);
//		feeEntryTitle.setHorizontalAlignment(JLabel.LEFT);
//		feeEntryTitle.setFont(new Font("Aria",Font.BOLD,25));
		
		
		
		inputp = new JPanel();
		inputp.setBounds(15,60,380,620);
		inputp.setBorder(BorderFactory.createEmptyBorder());
		inputp.setBackground(Color.white);
		inputp.setLayout(null);
		
		rollno = new JTextField(100);
		rollno.setBounds(10,10,110,50);
		rollno.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(20,66,125)),"Student Roll No."));
		rollno.setHorizontalAlignment(JLabel.CENTER);
		rollno.setFont(new Font("Arial",Font.ROMAN_BASELINE,15));
		rollno.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e)
			{
				char ch = e.getKeyChar();
				if(!Character.isDigit(ch))
				{
					e.consume();
				}
			}
		});
		
		rollno.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {

				
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {

				if(!rollno.getText().equals(""))
				{
					String rn = rollno.getText();
					
					if(StudentsDB.getFeeDetails(rn))
					{
						//StudentsDB.getBalance(rn);
//						String fc = feecode.getText();
//						
//						String sn = sname.getText();
//						String sfn = sfathername.getText();
//						String mf = mfee.getText();
//						String tf = tfee.getText();
//						String pf = pfee.getText();
//						String bf = bfee.getText();
//						String d = date.getText();
//						String cn = counseller.getText();
//						String co =course.getText();
					}
				}
				
				
				
				
			}
			
			
		});
		
		Border line = BorderFactory.createLineBorder(new Color(20,66,125));
		TitledBorder title = BorderFactory.createTitledBorder(line,"Fee Code No.");
		title.setTitleJustification(TitledBorder.CENTER);
		
		feecode = new JTextField(110);
		feecode.setBounds(260,10,110,50);
		feecode.setBorder(title);
		feecode.setHorizontalAlignment(JLabel.CENTER);
		feecode.setFont(new Font("Arial",Font.ROMAN_BASELINE,15));
		feecode.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				
				e.consume();
				
			}
			public void keyTyped(KeyEvent e) {
				
				e.consume();
				JOptionPane.showMessageDialog(null,"Sorry you can not modify these value");
			}
			
		});
		
		sname = new JTextField(360);
		sname.setBounds(10,80,360,50);
		sname.setBorder(BorderFactory.createTitledBorder(line,"Student Name"));
		sname.setFont(new Font("Arial",Font.ROMAN_BASELINE,15));
		sname.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				
				e.consume();
			
			}
			public void keyTyped(KeyEvent e) {
				
				e.consume();
				JOptionPane.showMessageDialog(null,"Sorry you can not modify these value");
			}
			
		});
		
		
		sfathername = new JTextField(360);
		sfathername.setBounds(10,140,360,50);
		sfathername.setBorder(BorderFactory.createTitledBorder(line,"Father Name"));
		sfathername.setFont(new Font("Arial",Font.ROMAN_BASELINE,15));
		sfathername.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				
				e.consume();
				
			}
			public void keyTyped(KeyEvent e) {
				
				e.consume();
				JOptionPane.showMessageDialog(null,"Sorry you can not modify these value");
			}
			
		});
		
		
		
//		String courses[] = new String[] {"ADCE","MDCE"};
//		course = new JComboBox<String>(courses);
		course = new JTextField(360);
		course.setBounds(10,200,360,50);
		course.setBorder(BorderFactory.createTitledBorder(line,"Course"));
		course.setFont(new Font("Arial",Font.ROMAN_BASELINE,15));
		course.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				
				e.consume();
				
			}
			public void keyTyped(KeyEvent e) {
				
				e.consume();
				JOptionPane.showMessageDialog(null,"Sorry you can not modify these value");
			}
			
		});
		
		
		date = new JTextField(360);
		date.setBounds(10,260,360,50);
		date.setBorder(BorderFactory.createTitledBorder(line,"Date"));
		date.setFont(new Font("Arial",Font.ROMAN_BASELINE,15));
		date.addKeyListener(new KeyAdapter() {
			
			int dCorrect,mCorrect,yCorrect;
			
			public void keyTyped(KeyEvent e)
			{
				if(date.getText().length() == 2)
				{
					String d = date.getText();
					
					if(Integer.parseInt(d) > 31)
					{
						date.setForeground(Color.red);
						dCorrect = 1;
						dateCorrect = false;
					}
					else
					{
						date.setForeground(Color.black);
						dCorrect = 0;
						dateCorrect = true;
					}
					date.setText(d+"-");
				}
				
				if(date.getText().length() == 5)
				{
					String m = date.getText();
					String m1 = m.substring(3,5);
					System.out.println(m1);
					if(Integer.parseInt(m1) > 12)
					{
						date.setForeground(Color.red);
						mCorrect = 1;
						dateCorrect = false;
					}
					else
					{
						date.setForeground(Color.black);
						mCorrect = 0;
						dateCorrect = true;
					}
					date.setText(m+"-");
				}
				
				if(date.getText().length() >= 10)
				{

					e.consume();
					
				}
				
				if(dCorrect != 0 && mCorrect != 0 )
				{
					dateCorrect = false;
				}
				
			
			}
		});
		
		
		mfee = new JTextField(360);
		mfee.setBounds(10,320,360,50);
		mfee.setBorder(BorderFactory.createTitledBorder(line,"Monthly Fee"));
		mfee.setFont(new Font("Arial",Font.ROMAN_BASELINE,15));
		mfee.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				
				e.consume();
				
			}
			public void keyTyped(KeyEvent e) {
				
				e.consume();
				JOptionPane.showMessageDialog(null,"Sorry you can not modify these value");
			}
			
		});
		
		
		tfee = new JTextField(360);
		tfee.setBounds(10,380,360,50);
		tfee.setBorder(BorderFactory.createTitledBorder(line,"Total Fee"));
		tfee.setFont(new Font("Arial",Font.ROMAN_BASELINE,15));
		tfee.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				
				e.consume();
				
			}
			public void keyTyped(KeyEvent e) {
				
				e.consume();
				JOptionPane.showMessageDialog(null,"Sorry you can not modify these value");
			}
			
		});
		
		
		pfee = new JTextField(360);
		pfee.setBounds(10,440,360,50);
		pfee.setBorder(BorderFactory.createTitledBorder(line,"Paid Fee"));
		pfee.setFont(new Font("Arial",Font.ROMAN_BASELINE,15));
		
		
		
		bfee = new JTextField(360);
		bfee.setBounds(10,500,360,50);
		bfee.setBorder(BorderFactory.createTitledBorder(line,"Balance Fee"));
		bfee.setFont(new Font("Arial",Font.ROMAN_BASELINE,15));
		bfee.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				
				e.consume();
				
			}
			public void keyTyped(KeyEvent e) {
				
				e.consume();
				JOptionPane.showMessageDialog(null,"Sorry you can not modify these value");
			}
		});
		
		
		counseller = new JTextField(360);
		counseller.setBounds(10,560,360,50);
		counseller.setBorder(BorderFactory.createTitledBorder(line,"Counseller name"));
		counseller.setFont(new Font("Arial",Font.ROMAN_BASELINE,15));
		
		searchC = new JPanel();
		searchC.setBounds(420,60,910,50);
		searchC.setBackground(new Color(20,66,125));
		searchC.setLayout(null);
		
		searchbox = new JTextField(100);
		searchbox.setBounds(355,10,200,30);
		searchbox.setBorder(BorderFactory.createEmptyBorder());
		searchbox.setText("Search");
		searchbox.setHorizontalAlignment(JLabel.CENTER);
		searchbox.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {

				if(searchbox.getText().equals("Search"))
				{
					searchbox.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				
				if(searchbox.getText().equals(""))
				{
					searchbox.setText("Search");
				}
				
			}
			
		});
		
		searchbox.addKeyListener(new KeyAdapter() {
			
//			public void keyTyped(KeyEvent e)
//			{
//				char ch = e.getKeyChar();
//				if(!Character.isDigit(ch))
//				{
//					e.consume();
//				}
//			}
//			
			public void keyReleased(KeyEvent e)
			{
				String srollno = searchbox.getText();
				filter(srollno);
			}
			
		});
		
		searchC.add(searchbox);
		
		String fCol[] = new String[] {"Fee Code No.","Roll no.","Student Name","Father name","Course","Date","Monthly Fee","Total Fee","Paid Fee","Balance Fee","Conseller Name"};
		Object fRow[][] = new Object[][] {};
		
		model = new DefaultTableModel(fRow,fCol);
		ftable = new JTable(model);
		
		ftable.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e)
			{
				int selectRow = ftable.getSelectedRow();
				
				if(selectRow >= 0 )
				{
					
					if(SwingUtilities.isRightMouseButton(e))
					{
						ShowMenu menu = new ShowMenu();
						menu.show(e.getComponent(),e.getX(),e.getY());
					}
				}
				
			}
			
			
		});
		
		JScrollPane spftable = new JScrollPane(ftable);
		spftable.setBounds(420,120,910,370);
		spftable.setBorder(BorderFactory.createLineBorder(new Color(20,66,125)));
	
		inputp.add(rollno);
		inputp.add(feecode);
		inputp.add(sname);
		inputp.add(sfathername);
		inputp.add(course);
		inputp.add(date);
		inputp.add(mfee);
		inputp.add(tfee);
		inputp.add(pfee);
		inputp.add(bfee);
		inputp.add(counseller);
		
		add = new JButton("Add");
		add.setBounds(400,513,90,35);
		add.setBackground(new Color(20,66,125));
		add.setBorder(BorderFactory.createRaisedBevelBorder());
		add.setForeground(Color.white);
		add.addActionListener(new ActionListener() {

//			@Override	JTextField feecode,rollno,sname,sfathername,mfee,tfee,pfee,bfee,amountIW,date,counseller;
//			JPanel inputp;
//			JButton add,update,delete,clear;
//			JComboBox<String> course;
			public void actionPerformed(ActionEvent arg0) {
				
				String fc = feecode.getText();
				String rn = rollno.getText();
				String sn = sname.getText();
				String sfn = sfathername.getText();
				String mf = mfee.getText();
				String tf = tfee.getText();
				String pf = pfee.getText();
				String bf = bfee.getText();
				String d = date.getText();
				String cn = counseller.getText();
				String co =course.getText();
				
				if(rn.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter roll Number");
				}
				else if(d.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter date");
				}
				else if(dateCorrect == false)
				{
					JOptionPane.showMessageDialog(null, "Invalid Date");
				}
				else if(date.getText().length() < 10)
				{
					JOptionPane.showMessageDialog(null, "Invalid Date");
				}
				else if(pf.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter Paid Fee");
				}
				else if(cn.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter counseller Name");
				}
				else if(desideToAdd.equals("selectRow"))
				{
					JOptionPane.showMessageDialog(null, "You Can not Add Record");
				}
				else
				{
//					String fc = feecode.getText();
//					String rn = rollno.getText();
//					String sn = sname.getText();
//					String sfn = sfathername.getText();
//					String mf = mfee.getText();
//					String tf = tfee.getText();
//					String pf = pfee.getText();
//					String bf = bfee.getText();
//					String d = date.getText();
//					String cn = counseller.getText();
//					String co =course.getText();
					
					if(StudentsDB.addFeeRecord(rn,sn,sfn,co,mf,tf,pf,bf,d,cn))
					{
						JOptionPane.showMessageDialog(null, "Add fee details Successfuly");
						
						
						if(printFeeSlip())
						{
						
							rollno.setText("");
							sname.setText("");
							sfathername.setText("");
							mfee.setText("");
							tfee.setText("");
							pfee.setText("");
							bfee.setText("");
							date.setText("");
							counseller.setText("");
							course.setText("");
							
							int feeCode = StudentsDB.getFeeLastCode();
							if(feeCode != -1)
							{
								feecode.setText(String.valueOf(feeCode+1));
								StudentsDB.getLastRecordsOffee();
							}
						}
					}
				}
			}
			
			
		});
		
		update = new JButton("Update");
		update.setBounds(400,553,90,35);
		update.setBackground(new Color(20,66,125));
		update.setBorder(BorderFactory.createRaisedBevelBorder());
		update.setForeground(Color.white);
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String fc = feecode.getText();
				String rn = rollno.getText();
				String sn = sname.getText();
				String sfn = sfathername.getText();
				String mf = mfee.getText();
				String tf = tfee.getText();
				String pf = pfee.getText();
				String bf = bfee.getText();
				String d = date.getText();
				String cn = counseller.getText();
				String co =course.getText();
				
				if(desideToAdd.equals("selectRow"))
				{
					if(rn.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Enter roll Number");
					}
					else if(d.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Enter date");
					}
					else if(dateCorrect == false)
					{
						JOptionPane.showMessageDialog(null, "Invalid Date");
					}
					else if(date.getText().length() < 10)
					{
						JOptionPane.showMessageDialog(null, "Invalid Date");
					}
					else if(pf.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Enter Paid Fee");
					}
					else if(cn.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Enter counseller Name");
					}
					else
					{
						fc = feecode.getText();
						rn = rollno.getText();
						sn = sname.getText();
						sfn = sfathername.getText();
						mf = mfee.getText();
						tf = tfee.getText();
						pf = pfee.getText();
						bf = bfee.getText();
						d = date.getText();
						cn = counseller.getText();
						co =course.getText();
						
						if(StudentsDB.updateFeeRecord(fc,d,pf,cn))
						{
							JOptionPane.showMessageDialog(null, "Update Successfuly");
							
							
							rollno.setText("");
							sname.setText("");
							sfathername.setText("");
							mfee.setText("");
							tfee.setText("");
							pfee.setText("");
							bfee.setText("");
							date.setText("");
							counseller.setText("");
							course.setText("");
							
							int feeCode = StudentsDB.getFeeLastCode();
							if(feeCode != -1)
							{
								feecode.setText(String.valueOf(feeCode+1));
							}
						}
					}
				}
			}
				
			
			
		});
		
		delete = new JButton("Delete");
		delete.setBounds(400,600-8,90,35);
		delete.setBackground(new Color(20,66,125));
		delete.setBorder(BorderFactory.createRaisedBevelBorder());
		delete.setForeground(Color.white);
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(!rollno.getText().equals("") && !date.getText().equals("") && !counseller.getText().equals(""))
				{
					int option = JOptionPane.showConfirmDialog(null, "Do you want to delete","Confirmation",JOptionPane.OK_CANCEL_OPTION);
	
					if(option == 0)
					{
						fc = feecode.getText();
						
						if(StudentsDB.deleteFeeRecord(fc))
						{
							JOptionPane.showMessageDialog(null, "Delete Successfuly");
							
							
							rollno.setText("");
							sname.setText("");
							sfathername.setText("");
							mfee.setText("");
							tfee.setText("");
							pfee.setText("");
							bfee.setText("");
							date.setText("");
							counseller.setText("");
							course.setText("");
							
							int feeCode = StudentsDB.getFeeLastCode();
							if(feeCode != -1)
							{
								feecode.setText(String.valueOf(feeCode+1));
							}
						}
						
					}
				}
			}
			
		});
		
		clear = new JButton("Clear");
		clear.setBounds(400,632,90,35);
		clear.setBackground(new Color(20,66,125));
		clear.setBorder(BorderFactory.createRaisedBevelBorder());
		clear.setForeground(Color.white);
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				rollno.setText("");
				sname.setText("");
				sfathername.setText("");
				mfee.setText("");
				tfee.setText("");
				pfee.setText("");
				bfee.setText("");
				date.setText("");
				counseller.setText("");
				course.setText("");
				
				desideToAdd = "notselectRow";
			}
			
		});
		
		container.add(titlebar);
		container.add(add);
		container.add(update);
		container.add(delete);
		container.add(clear);
		container.add(inputp);
		container.add(searchC);
		container.add(spftable);
		
		
		add(container);
		
	}
	
	public static FeeEntry getFeeEntry()
	{
		return new FeeEntry();
	}
	
	public static void showfeeRecords()
	{
//		FeeEntry.fc = String.valueOf(rs.getInt("feeCode_no"));
//		FeeEntry.rn = String.valueOf(rs.getInt("rollno"));
//		FeeEntry.sn = rs.getString("name");
//		FeeEntry.sfn = rs.getString("fathername");
//		FeeEntry.co = rs.getString("course");
//		FeeEntry.d = rs.getString("date");
//		FeeEntry.mf = rs.getString("monthly_fee");
//		FeeEntry.tf = rs.getString("total_fee");
//		FeeEntry.pf = rs.getString("paid_fee");
//		FeeEntry.bf = rs.getString("balance_fee");
//		FeeEntry.cn = rs.getString("counsellername");
		
		DefaultTableModel model = (DefaultTableModel) ftable.getModel();
		String addRow[] = new String[] {fc,rn,sn,sfn,co,d,mf,tf,pf,bf,cn};
		
		model.addRow(addRow);
	}
	
	class ShowMenu extends JPopupMenu
	{
		ShowMenu()
		{
			JMenuItem update = new JMenuItem("Update");
			update.setBackground(Color.white);
			update.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					int indexNumber = ftable.getSelectedRow();
					desideToAdd = "selectRow";
//					String fc = feecode.getText();
//					String rn = rollno.getText();
//					String sn = sname.getText();
//					String sfn = sfathername.getText();
//					String mf = mfee.getText();
//					String tf = tfee.getText();
//					String pf = pfee.getText();
//					String bf = bfee.getText();
//					String d = date.getText();
//					String cn = counseller.getText();
//					String co =course.getText();
					
					feecode.setText((String) ftable.getValueAt(indexNumber, 0));
					rollno.setText((String) ftable.getValueAt(indexNumber, 1));
					sname.setText((String) ftable.getValueAt(indexNumber, 2));
					sfathername.setText((String) ftable.getValueAt(indexNumber, 3));
					course.setText((String) ftable.getValueAt(indexNumber, 4));
					date.setText((String) ftable.getValueAt(indexNumber, 5));
					mfee.setText((String) ftable.getValueAt(indexNumber, 6));
					tfee.setText((String) ftable.getValueAt(indexNumber, 7));
					pfee.setText((String) ftable.getValueAt(indexNumber, 8));
					bfee.setText((String) ftable.getValueAt(indexNumber, 9));
					counseller.setText((String) ftable.getValueAt(indexNumber, 10));
					
					
				}
				
			});
			
//			JMenuItem delete = new JMenuItem("Delete");
//			delete.setBackground(Color.white);
			
			
			add(update);
//			add(delete);
			setBackground(Color.white);
		}
		
	}
	
	public boolean printFeeSlip()
	{
		Toolkit tkp = inputp.getToolkit();
		PrintJob pjp = tkp.getPrintJob(this, null, null);
		Graphics g = pjp.getGraphics();
		inputp.print(g);
		g.dispose();
		pjp.end();
		
		return true;
	}
	
	public void filter(String srollno)
	{
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		ftable.setRowSorter(tr);
		
		tr.setRowFilter(RowFilter.regexFilter(srollno));
	}
	
	public static void main(String[] args) {
			
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new FeeEntry();
			}
		});

	}

}
