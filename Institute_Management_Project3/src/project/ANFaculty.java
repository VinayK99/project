package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
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

public class ANFaculty extends JFrame{
	
	JPanel container,titlebar,searchContainer;
	JLabel Title,anfTitle,frTitle;
	JButton mini,close,search;
	JLabel gender;
	static JCheckBox male;
	static JCheckBox female;
	static JTextField fid,nofaculty,fname,fsalary,fdateOfJoining,fContactno,femailId,searchbox;
	JComboBox<String> department;
	JComboBox<String> designation;
	JTextArea faddress;
	JButton add,update,delete,clear,print;
	static JTable Ftable;
	JRadioButton searchmale,searchfemale;
	
	static int selectRowNumber = -1;
	static String selectGender = null;
	
	static String fId;
	static String fn;
	static String fs;
	static String fcno;
	static String fei;
	static String fdoj;
	static String fa;
	static String fdept;
	static String fdesi;
	
	DefaultTableModel DTModel;
	
	String desideToAdd ="";
	
	private Point initialClick ;
	
	public ANFaculty()
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
		
		JPanel inputp = new JPanel();
		inputp.setBounds(15,110,400,530);
		inputp.setLayout(null);
		
		inputp.setBorder(BorderFactory.createLineBorder(new Color(20,66,125)));
//		inputp.setLayout(null);
//		JScrollPane spi = new JScrollPane(inputp);
////		spi.setBounds(15,120,300,450);
////		spi.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		anfTitle = new JLabel("Add New Faculty");
		anfTitle.setBounds(15,60,400,40);
		anfTitle.setHorizontalAlignment(JLabel.LEFT);
		anfTitle.setFont(new Font("Aria",Font.BOLD,25));
		
		
		frTitle = new JLabel("Faculty Records");
		frTitle.setBounds(430,60,900,40);
		frTitle.setHorizontalAlignment(JLabel.CENTER);
		frTitle.setFont(new Font("Aria",Font.BOLD,25));
	//	frTitle.setBorder(BorderFactory.createLineBorder(Color.black));
		
		searchContainer  = new JPanel();
		searchContainer.setBounds(430,110,900,50);
		searchContainer.setBackground(new Color(20,66,125));
		searchContainer.setLayout(null);
		
		searchbox = new JTextField(200);
		searchbox.setBounds(250,11,200,28);
		searchbox.setBorder(BorderFactory.createEmptyBorder());
		searchbox.setHorizontalAlignment(JLabel.CENTER);
		searchbox.setForeground(Color.darkGray);
		searchbox.setText("Search");
		searchbox.addFocusListener(new FocusListener() {
		
			@Override
			public void focusGained(FocusEvent arg0) {

				searchbox.setText("");
				
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
			
			public void keyReleased(KeyEvent e)
			{
				String search = searchbox.getText();

				filter(search);
						
			}
			
//			public void keyTyped(KeyEvent e)
//			{
//				char ch = e.getKeyChar();
//				if(!Character.isDigit(ch))
//				{
//					e.consume();
//				}
//			}
		});

		
		searchmale = new JRadioButton("Male");
		searchmale.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				searchfemale.setSelected(false);
				filter(selectGender);
				
			}
			
		});
		searchmale.setBounds(455,11,100,28);
		
		searchfemale = new JRadioButton("Female");
		searchfemale.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				searchmale.setSelected(false);
				filter(selectGender);
				
			}
			
		});
		searchfemale.setBounds(555,11,100,28);
		

		searchContainer.add(searchbox);
		searchContainer.add(searchmale);
		searchContainer.add(searchfemale);
		
		fid = new JTextField(100);
		fid.setBorder(new TitledBorder(new EtchedBorder(),"Faculty Id"));
		fid.setHorizontalAlignment(JLabel.CENTER);
		fid.setBounds(10,10,100,45);
		fid.addMouseListener(new MouseAdapter() {

			@Override	
			public void mouseClicked(MouseEvent e) {

				fid.setEditable(false);
				JOptionPane.showMessageDialog(null,"You don't modify Faculty Id");
				
			}
			
		});
		
		nofaculty = new JTextField(100);
		nofaculty.setBorder(new TitledBorder(new EtchedBorder(),"No Of faculty"));
		nofaculty.setHorizontalAlignment(JLabel.CENTER);
		nofaculty.setBounds(290,10,100,45);
		nofaculty.setEditable(false);
		
		fname = new JTextField(100);
		fname.setBorder(new TitledBorder(new EtchedBorder(),"Faculty Name"));
		fname.setHorizontalAlignment(JLabel.CENTER);
		fname.setBounds(10,60,380,45);
		fname.setFont(new Font("Dialog",Font.BOLD,15));
		
		gender = new JLabel("Gender");
		gender.setBounds(10,115,100,20);
		
		male = new JCheckBox("Male");
		male.setBounds(100,115,95,20);
		male.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				selectGender = male.getText(); 
				female.setSelected(false);
				
				
			}
			
		});
		
		female = new JCheckBox("Female");
		female.setBounds(195,115,95,20);
		female.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				selectGender = female.getText(); 
				male.setSelected(false);
			}
			
		});
		
		String departmentdata[] = new String[] {"Select","Admin","Receptionist","Software Faculty","Hardware Faculty","Counseller"}; 
		department = new JComboBox<String>(departmentdata);
		department.setBorder(new TitledBorder(new EtchedBorder(),"Department"));
		department.setBounds(10,145,380,50);
		
		String designationdata[] = new String[] {"Select","Teacher","Centeral Head"}; 
		designation = new JComboBox<String>(designationdata);
		designation.setBorder(new TitledBorder(new EtchedBorder(),"Designation"));
		designation.setBounds(10,210,380,50);
		
		faddress = new JTextArea(1,1);
		faddress.setBorder(new TitledBorder(new EtchedBorder(),"Faculty address"));
		JScrollPane sfa = new JScrollPane(faddress);
		sfa.setBounds(10,270,380,45);
		
		fContactno = new JTextField(100);
		fContactno.setBorder(new TitledBorder(new EtchedBorder(),"Contact Number"));
		fContactno.setHorizontalAlignment(JLabel.CENTER);
		fContactno.setBounds(10,325,380,45);

		femailId = new JTextField(100);
		femailId.setBorder(new TitledBorder(new EtchedBorder(),"Email Id"));
		femailId.setHorizontalAlignment(JLabel.CENTER);
		femailId.setBounds(10,375,380,45);
		
		fsalary = new JTextField(100);
		fsalary.setBorder(new TitledBorder(new EtchedBorder(),"Faculty Salary"));
		fsalary.setHorizontalAlignment(JLabel.CENTER);
		fsalary.setBounds(10,425,380,45);
		
		fdateOfJoining = new JTextField(100);
		fdateOfJoining.setBorder(new TitledBorder(new EtchedBorder(),"Date of Goining"));
		fdateOfJoining.setHorizontalAlignment(JLabel.CENTER);
		fdateOfJoining.setBounds(10,475,380,45);
		
		
		inputp.add(fid);
		inputp.add(nofaculty);
		inputp.add(fname);
		inputp.add(gender);
		inputp.add(male);
		inputp.add(female);
		inputp.add(department);
		inputp.add(designation);
		inputp.add(sfa);
		inputp.add(fContactno);
		inputp.add(femailId);
		inputp.add(fsalary);
		inputp.add(fdateOfJoining);
		
		add = new JButton("Add");
		add.setBounds(15,650,90,30);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String fId = fid.getText();
				String fn = fname.getText();
				String fs = fsalary.getText();
				String fcno = fContactno.getText();
				String fei =  femailId.getText();
				String fdoj = fdateOfJoining.getText();
				String fa = faddress.getText();
				String fdept = (String) department.getSelectedItem();
				String fdesi = (String) designation.getSelectedItem();
				
				
				if(	desideToAdd.equals("selectRow"))
				{
					JOptionPane.showMessageDialog(null,"You can not add");
				}
				else if(fn.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Name is Required");
				}
				else if(selectGender == null || selectGender.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Gender is Required");
				}
				else if(fdept.equals("Select"))
				{
					JOptionPane.showMessageDialog(null,"Department is Required");
				}
				else if(fdesi.equals("Select"))
				{
					JOptionPane.showMessageDialog(null,"Designation is Required");
				}
				else if(fcno.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Contact Number is Required");
				}
				else if(fei.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Email Id is Required");
				}
				else if(fs.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Salary is Required");
				}
				else if(fdoj.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Date of Joining is Required");
				}
				else
				{
					if(StudentsDB.addFacultyRecords(fId,fn,selectGender,fdept,fdesi,fa,fcno,fei,fs,fdoj))
					{
						JOptionPane.showMessageDialog(null,"Add Record Successfully");
						
				
						fname.setText("");
						fsalary.setText("");
						fdateOfJoining.setText("");
						fContactno.setText("");
						femailId.setText("");
						department.setSelectedIndex(0);
						designation.setSelectedIndex(0);
						faddress.setText("");
						
						male.setSelected(false);
						female.setSelected(false);

						
						int tfaculty = StudentsDB.getTfaclty();
						if(tfaculty != -1)
						{
							settotalFacultyno(tfaculty);
							
							StudentsDB.getNewfacultyRecords();
							
						}
					}
					else
					{
						System.out.println("no");
					}
				}
				
			}
			
		});
		
		update = new JButton("update");
		update.setBounds(115,650,90,30);
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String fId = fid.getText();
				String fn = fname.getText();
				String fs = fsalary.getText();
				String fcno = fContactno.getText();
				String fei =  femailId.getText();
				String fdoj = fdateOfJoining.getText();
				String fa = faddress.getText();
				String fdept = (String) department.getSelectedItem();
				String fdesi = (String) designation.getSelectedItem();
				
				
				if(!desideToAdd.equals("selectRow"))
				{
					JOptionPane.showMessageDialog(null,"You can not update");
				}
				else if(fn.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Name is Required");
				}
				else if(selectGender == null || selectGender.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Gender is Required");
				}
				else if(fdept.equals("Select"))
				{
					JOptionPane.showMessageDialog(null,"Department is Required");
				}
				else if(fdesi.equals("Select"))
				{
					JOptionPane.showMessageDialog(null,"Designation is Required");
				}
				else if(fcno.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Contact Number is Required");
				}
				else if(fei.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Email Id is Required");
				}
				else if(fs.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Salary is Required");
				}
				else if(fdoj.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Date of Joining is Required");
				}
				else
				{
					if(StudentsDB.updateFacultyRecords(fId,fn,selectGender,fdept,fdesi,fa,fcno,fei,fs,fdoj))
					{
						JOptionPane.showMessageDialog(null,"Update Record Successfully");
						
				
						fname.setText("");
						fsalary.setText("");
						fdateOfJoining.setText("");
						fContactno.setText("");
						femailId.setText("");
						department.setSelectedIndex(0);
						designation.setSelectedIndex(0);
						faddress.setText("");
						
						male.setSelected(false);
						female.setSelected(false);

						desideToAdd = "notselectRow";
						
						int tfaculty = StudentsDB.getTfaclty();
						if(tfaculty != -1)
						{
							settotalFacultyno(tfaculty);
							
							StudentsDB.getNewfacultyRecords();
							
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
		delete.setBounds(215,650,90,30);
		delete.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				
				String fId = fid.getText();
				String fn = fname.getText();
				String fs = fsalary.getText();
				String fcno = fContactno.getText();
				String fei =  femailId.getText();
				String fdoj = fdateOfJoining.getText();
				String fa = faddress.getText();
				String fdept = (String) department.getSelectedItem();
				String fdesi = (String) designation.getSelectedItem();
				
				if(desideToAdd.equals("selectRow"))
				{
					if(StudentsDB.deleteFacultyRecord(fId))
					{
						JOptionPane.showMessageDialog(null, "Delete Successfully");
						
						fname.setText("");
						fsalary.setText("");
						fdateOfJoining.setText("");
						fContactno.setText("");
						femailId.setText("");
						department.setSelectedIndex(0);
						designation.setSelectedIndex(0);
						faddress.setText("");
						
						male.setSelected(false);
						female.setSelected(false);

						desideToAdd = "notselectRow";
						
						int tfaculty = StudentsDB.getTfaclty();
						if(tfaculty != -1)
						{
							settotalFacultyno(tfaculty);				
						}
					}
				}
			}
			
		});
		
		clear= new JButton("Clear");
		clear.setBounds(315,650,90,30);
		clear.setBackground(new Color(20,66,125));
		clear.setForeground(Color.white);
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int index = Ftable.getSelectedRow();
				
				fid.setText("");
				fname.setText("");
				fsalary.setText("");
				fContactno.setText("");
				femailId.setText("");
				fdateOfJoining.setText("");
				faddress.setText("");
				department.setSelectedIndex(0);
				designation.setSelectedIndex(0);
				
				desideToAdd = "notselectRow";
				
			}
			
		});
		
		
		String fcoln[] = new String[] {"Faculty  Id","Faculty Name","Gender","Department","Designation","Faculty Address","Contact No.","Email Id","Faculty Salary","Date of Joining"};
		Object frown[][] = new Object[][] {};
		
		DTModel = new DefaultTableModel(frown,fcoln);
		DefaultTableCellRenderer DRenderer = new DefaultTableCellRenderer();
		DRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		final Pop pop = new Pop();
		
		
		Ftable = new JTable(DTModel);
		Ftable.setDefaultRenderer(Object.class, DRenderer);
		Ftable.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				selectRowNumber = Ftable.getSelectedRow();
				
				//System.out.println(selectRowNumber);
				if(selectRowNumber != -1)
				{
					if(SwingUtilities.isRightMouseButton(e))
					{
						pop.show(e.getComponent(),e.getX(),e.getY());
					}
				}
					
			}
			
		});
		

		JScrollPane fs = new JScrollPane(Ftable);
		fs.setBounds(430,170,900,470);
		
	
		System.out.println("ok");
		print= new JButton("Print");
		print.setBounds(1240,650,90,30);
		print.setBackground(new Color(20,66,125));
		print.setForeground(Color.white);
		print.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					Ftable.print();
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		container.add(titlebar);
		container.add(anfTitle);
		container.add(inputp);
		container.add(add);
		container.add(update);
		container.add(delete);
		container.add(clear);
		container.add(frTitle);
		container.add(searchContainer);
		container.add(fs);
		container.add(print);
	
		add(container);
	}

	public static ANFaculty getANFaculty()
	{
		return new ANFaculty();
	}
	
	public static void settotalFacultyno(int tfaculty)
	{
		nofaculty.setText(String.valueOf(tfaculty));
		
		fid.setText(String.valueOf(tfaculty+1));
	}
	
	public static void showRecords()
	{
	
		DefaultTableModel model = (DefaultTableModel) Ftable.getModel();
		Object addrow[] = new Object[] {fId,fn,selectGender,fdept,fdesi,fa,fcno,fei,fs,fdoj};
		model.addRow(addrow);
	}
	
	class Pop extends JPopupMenu
	{
		public Pop()
		{
			
			
			JMenuItem update = new JMenuItem("Update");
			JMenuItem delete = new JMenuItem("Delete");
			update.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e)
				{
					DefaultTableModel model = (DefaultTableModel) Ftable.getModel();
					
					desideToAdd = "selectRow";
					
//					fId = (String) model.getValueAt(selectRowNumber, 0);
//					fn = (String) model.getValueAt(selectRowNumber, 1);
//					selectGender = (String) model.getValueAt(selectRowNumber, 2);
//					fdept = (String) model.getValueAt(selectRowNumber, 3);
//					fdesi = (String) model.getValueAt(selectRowNumber, 4);
//					fa = (String) model.getValueAt(selectRowNumber, 5);
//					fcno = (String) model.getValueAt(selectRowNumber, 6);
//					fei = (String) model.getValueAt(selectRowNumber, 7);
//					fs = (String) model.getValueAt(selectRowNumber, 8);
//					fdoj = (String) model.getValueAt(selectRowNumber, 9);
					fId = (String) Ftable.getValueAt(selectRowNumber, 0);
					fn = (String) Ftable.getValueAt(selectRowNumber, 1);
					selectGender = (String) Ftable.getValueAt(selectRowNumber, 2);
					fdept = (String) Ftable.getValueAt(selectRowNumber, 3);
					fdesi = (String) Ftable.getValueAt(selectRowNumber, 4);
					fa = (String) Ftable.getValueAt(selectRowNumber, 5);
					fcno = (String) Ftable.getValueAt(selectRowNumber, 6);
					fei = (String) Ftable.getValueAt(selectRowNumber, 7);
					fs = (String) Ftable.getValueAt(selectRowNumber, 8);
					fdoj = (String) Ftable.getValueAt(selectRowNumber, 9);
					
					
					fid.setText(fId);
					fname.setText(fn);
					
					if(selectGender.equals("Male"))
					{
						male.setSelected(true);
						selectGender = "Male";
					}
					else if(selectGender.equals("female"))
					{
						female.setSelected(true);
						selectGender = "female";
					}
					
					department.setSelectedItem(fdept);
					designation.setSelectedItem(fdesi);
					faddress.setText(fa);
					fContactno.setText(fcno);
					femailId.setText(fei);
					fsalary.setText(fs);
					fdateOfJoining.setText(fdoj);
					
					
					
					
				}
			});
			
			
			
			add(update);
			add(delete);
		}
	}
	
	public void filter(String search)
	{
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(DTModel);
		Ftable.setRowSorter(tr);
		
		tr.setRowFilter(RowFilter.regexFilter(search));
	}
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			
			public void run()
			{
				new ANFaculty();
			}
		});

	}

}


