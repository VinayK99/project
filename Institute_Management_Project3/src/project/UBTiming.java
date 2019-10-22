package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class UBTiming extends JFrame{

	JLabel rollno,updateTime,title;
	JTextField trollno;
	JComboBox<String> tupdateTime;
	JButton close,cencel,update;
	
	private Point initialClick;
	
	public UBTiming()
	{
		setUndecorated(true);
		setVisible(true);
		setSize(300,300);
		setLocationRelativeTo(null);
		setLayout(null);
		
		JPanel container = new JPanel();
		container.setBounds(0,0,300,300);
		container.setLayout(null);
		container.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(20,66,125)));
		container.setBackground(Color.white);
		container.setFocusable(true);
		
		JPanel titlebar = new JPanel();
		titlebar.setBounds(0,0,300,35);
		titlebar.setBackground(new Color(20,66,125));
		titlebar.setLayout(null);
		
		title = new JLabel("<html><font size='6'>u</font>pdate <font size='5'>B</font>atch <font size='5'>T</font>ime</html>");
		title.setForeground(new Color(255,255,255));
		title.setFont(new Font("Dialog",Font.BOLD,15));
		title.setBounds(10,0,200,35);
		
		close = new JButton("<html>X</html>");
		close.setBounds(258,0,42,35);
		close.setBackground(new Color(20,66,125));
		close.setBorder(BorderFactory.createEmptyBorder());
		close.setForeground(Color.white);
		close.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				//System.exit(0);
				setVisible(false);
//				Project.jf.setVisible(true);
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
		
		
		titlebar.add(title);
		titlebar.add(close);
		
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
		
		
		rollno = new JLabel("Enter Roll No.");
		rollno.setBounds(20,55,260,20);
		rollno.setFont(new Font("Dialog",Font.BOLD,15));
		
		trollno = new JTextField(260);
		trollno.setBounds(20,80,260,30);
		trollno.setFont(new Font("Arial",Font.BOLD,15));
		trollno.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e)
			{
				char ch = e.getKeyChar();
				if(!Character.isDigit(ch))
				{
					e.consume();
				}
			}
		});
		
		
		updateTime = new JLabel("Batch Time");
		updateTime.setBounds(20,130,260,20);
		updateTime.setFont(new Font("Dialog",Font.BOLD,15));
		
		String BatchTime[] = new String[]{"","7:30 To 9:00","9:00 To 10:30","10:30 To 12:00","12:00 To 1:30","3:30 To 5:00","5:00 To 6:30"};
		tupdateTime = new JComboBox<String>(BatchTime);
		tupdateTime.setBounds(20,155,260,30);
		tupdateTime.setFont(new Font("Arial",Font.BOLD,15));
		
		
		update = new JButton("Update");
		update.setBounds(20,230,90,30);
		update.setBackground(new Color(20,66,125));
		update.setBorder(BorderFactory.createEmptyBorder());
		update.setForeground(Color.white);
		update.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
					try
					{
						String rollno = trollno.getText();
						String btime = (String) tupdateTime.getSelectedItem();
						
						if(StudentsDB.updateBatchTime(rollno,btime))
						{
							JOptionPane.showMessageDialog(container, "Batch  Time update successfully");
							trollno.setText("");
							tupdateTime.setSelectedIndex(0);
							
						}
					}
					catch(Exception e1)
					{
						
					}
			}
			
			public void mouseEntered(MouseEvent e)
			{
				//update.setBackground(new Color(177,14,14));
				update.setBackground(new Color(255,255,255));
				update.setForeground(new Color(20,66,125));
				update.setBorder(BorderFactory.createMatteBorder(1,1,1,1, new Color(20,66,125)));
			}
			public void mouseExited(MouseEvent e)
			{
				update.setBackground(new Color(20,66,125));
				update.setForeground(Color.white);
			}
			
			
		});
		
		cencel = new JButton("Cencel");
		cencel.setBounds(190,230,90,30);
		cencel.setBackground(new Color(20,66,125));
		cencel.setBorder(BorderFactory.createEmptyBorder());
		cencel.setForeground(Color.white);
		cencel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				trollno.setText("");
				tupdateTime.setSelectedIndex(0);
			}
			
			public void mouseEntered(MouseEvent e)
			{
				cencel.setBackground(new Color(255,255,255));
				cencel.setForeground(new Color(20,66,125));
				cencel.setBorder(BorderFactory.createMatteBorder(1,1,1,1, new Color(20,66,125)));
			}
			public void mouseExited(MouseEvent e)
			{
				cencel.setBackground(new Color(20,66,125));
				cencel.setForeground(Color.white);
			}
			
			
		});
		
		
		container.add(titlebar);
		container.add(rollno);
		container.add(trollno);
		container.add(updateTime);
		container.add(tupdateTime);
		container.add(update);
		container.add(cencel);
		
		add(container);
		
	}
	
	
	public static UBTiming getUBTiming()
	{
		return new UBTiming();
	}
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new UBTiming();
				
			}
			
		});

	}

}
