package project;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.cj.jdbc.exceptions.PacketTooBigException;

public class StudentsDB {

	private static final String uname = "vinay";
	private static final String upass = "vinay";
	private static final String url = "jdbc:mysql://localhost:3308/institute_management_system";
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static  Connection conn = null;
	static String username,userpassword,userImage;
	static String SContact_no, SEmail_Id;
	static int rollno;
	
	public static boolean selectSomeSRecord(String username,String ucontactno,String ugmail)
	{
		
			try 
			{
				
				Class.forName(driver);
				
				String sql = "select * from student_records where S_name = ? and S_mobile_number = ? and S_Email_id = ?";
				
				conn = DriverManager.getConnection(url,uname,upass);
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, username);
				ps.setString(2, ucontactno);
				ps.setString(3, ugmail);
				
				
				ResultSet rs = ps.executeQuery();
				
				rs.first();
				rollno = rs.getInt(1);
				
				
				
				return true;
			}
			catch (ClassNotFoundException e) 
			{
				System.err.println(e);
			} 
			catch (SQLException e) 
			{
				System.err.println(e);
			}
			finally
			{
				if(conn != null)
				{
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		
			return false;
		
	}
	
	public static boolean insertRegister(String ucontactno,String username,String ugmail,String upassword,String userType)
	{
		try
		{
			Class.forName(driver);
			
			String sql = "insert into register(contact_no,S_rollno,Username,Email_id,Password,userType) values(?,?,?,?,?,?)";
			
			Connection conn = DriverManager.getConnection(url, uname, upass);
			
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setString(1, ucontactno);
			ps.setInt(2, rollno);
			ps.setString(3, username);
			ps.setString(4, ugmail);
			ps.setString(5, upassword);
			ps.setString(6, userType);
			
			
			ps.executeUpdate();
			
			return true;
			
		}
		catch(ClassNotFoundException e1)
		{
			System.err.println(e1);
		}
		catch(SQLIntegrityConstraintViolationException e1)
		{
			JOptionPane.showMessageDialog(null, "You have an already register");
		}
		catch(SQLException e1)
		{
			System.err.println(e1+"ok");
		}
		return false;
	}
	
	
	public static boolean login(String username,String userType)
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "select * from register where Username = ? and userType = ? ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, userType);
			
			ResultSet rs = ps.executeQuery();
			rs.first();
			
		    SContact_no = rs.getString("Contact_no");
		    username = rs.getString("Username");
			SEmail_Id = rs.getString("Email_Id");
			
			return true;
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		} 
		catch(SQLException e) 
		{
			System.err.println(e+"j");
		}
		return false;
	}
	
	public static String confirmPassword(String userpass)
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "select S_rollno, Username , Password ,User_image from register where Password = ? ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, userpass);
		
			ResultSet rs = ps.executeQuery();
			rs.first();
			
			rollno = rs.getInt(1);
			username = rs.getString(2);
			userpassword = rs.getString(3); 
			
			
			BufferedImage img = ImageIO.read(rs.getBinaryStream(4));

			if(img != null)
			{
				ImageIcon img1 = new ImageIcon(img);
				Project.showPic(img1);
			}
			
			return username;
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		} 
		catch(IllegalArgumentException e)
		{
			return username;
		}
		catch(SQLException e) 
		{
			System.err.println(e);
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		}
		return "-1";
	}
	
	public static boolean updatePic(String path)
	{
		
		try
		{
			Class.forName(driver);
			String sql = "update register set user_image = ? where Username = ? and Password = ?";
			
			conn = DriverManager.getConnection(url,uname,upass);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			File img = new File(path);
			FileInputStream fis = new FileInputStream(img);
			
			ps.setBinaryStream(1,fis,(int)img.length());
			ps.setString(2, username);
			ps.setString(3, userpassword);
			
			ps.executeUpdate();
					
			return true;
		}
		catch (ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch (PacketTooBigException e)
		{
			JOptionPane.showMessageDialog(null, "Sorry this is a very large Pic ");
		}
		catch (SQLException e)
		{
			System.err.println(e);
			
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println(e);
		}
		return false;
	}
	
	public static ImageIcon getuserPic()
	{
		
		try
		{
			Class.forName(driver);
			String sql = "select user_image from register where Username = ? and Password = ?";
			
			conn = DriverManager.getConnection(url, uname, upass);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, userpassword);
			
			ResultSet rs = ps.executeQuery();	
			rs.first();
			
			BufferedImage img = ImageIO.read(rs.getBinaryStream(1));
			
			ImageIcon image = new ImageIcon(img);
			
			return image;
			
		}
		catch (ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch (SQLException e)
		{
			System.err.println(e);
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		}
		
		return null;
	}
	
	
	public static boolean selectSomeFRecord(String username,String ucontactno,String ugmail)
	{
		
			try 
			{
				
				Class.forName(driver);
				
				String sql = "select * from faculty_records where facname = ? and Contact_no = ? and Email_id = ?";
				
				conn = DriverManager.getConnection(url,uname,upass);
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, username);
				ps.setString(2, ucontactno);
				ps.setString(3, ugmail);
				
				ResultSet rs = ps.executeQuery();
				
				rs.first();
				System.out.println(rs.getString(1));
				
				
				
				return true;
			}
			catch (ClassNotFoundException e) 
			{
				System.err.println(e);
			} 
			catch (SQLException e) 
			{
				System.err.println(e);
			}
			finally
			{
				if(conn != null)
				{
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		
			return false;
		
	}
	
	public static int getRowCount()
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url,uname,upass);
			
			String sql = "select * from student_records";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.last();
			
			
			
			return rs.getInt("S_rollno"); 
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
		return -1;
		
	}
	
	public static boolean addStudentRecords(String sfn,String sln,String sfathern,String smothern,String sad,String smn,String sei,String selectedGender,String scd,String stf,String smf,String cn,String sadate,String sdob,String sc,String sbt)
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url,uname,upass);
			
			String sql = "insert into student_records(S_name, L_name, S_fathername,S_mothername,S_address, S_mobile_number, S_dateOfBirth, S_gender, S_Email_id, S_course,S_course_dur, S_total_fee,S_monthly_fee, S_batch_time, S_admition_date, counsellor_name) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, sfn);
			ps.setString(2, sln);
			ps.setString(3, sfathern);
			ps.setString(4, smothern);
			ps.setString(5, sad);
			ps.setString(6, smn);
			ps.setString(7, sdob);
			ps.setString(8, selectedGender);
			ps.setString(9, sei);
			ps.setString(10, sc);
			ps.setString(11, scd);
			ps.setString(12, stf);
			ps.setString(13, smf);
			ps.setString(14, sbt);
			ps.setString(15, sadate);
			ps.setString(16, cn);
			
			ps.executeUpdate();
			
			return true;
		
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			JOptionPane.showMessageDialog(null,"You can not save duplicate Records","",JOptionPane.ERROR_MESSAGE);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
		return false;
	}
	
	
	public static int searchRollno(String rollno)
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url,uname,upass);
			
			String sql = "select * from student_records where S_rollno = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			int srollno = Integer.parseInt(rollno);
			ps.setInt(1,srollno);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			String srollnoa =  String.valueOf(rs.getInt(1));
			
			CNRecords.trollno.setText(srollnoa);
			CNRecords.tfname.setText(rs.getString("S_name"));
			CNRecords.tlname.setText(rs.getString("L_name"));
			CNRecords.tfathername.setText(rs.getString("S_fathername"));
			CNRecords.tmothername.setText(rs.getString("S_mothername"));
			CNRecords.taddress.setText(rs.getString("S_address"));
			CNRecords.tmobileNo.setText(rs.getString("S_mobile_number"));
			CNRecords.tdob.setText(rs.getString("S_dateOfBirth"));
			
			String gender = rs.getString("S_gender");
			CNRecords.selectedGender = gender;
			
			if(gender.equals("Male"))
			{
				CNRecords.male.setSelected(true);
			}
			else if(gender.equals("Female"))
			{
				CNRecords.female.setSelected(true);
			}
			
			
			CNRecords.tcourse.setSelectedItem(rs.getString("S_course"));
			CNRecords.temailId.setText(rs.getString("S_Email_id"));
			CNRecords.tcourseDuration.setText(rs.getString("S_course_dur"));
			CNRecords.ttotalFee.setText(rs.getString("S_total_fee"));
			CNRecords.tmonthlyfee.setText(rs.getString("S_monthly_fee"));
			CNRecords.tadmissiondate.setText(rs.getString("S_admition_date"));
			CNRecords.tbatchTime.setSelectedItem(rs.getString("S_batch_time"));
			CNRecords.tcounsellerName.setText(rs.getString("counsellor_name"));
			
			return 1;
			
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"This Roll No. is Not Exist in the records " );
		}
		return 0;
	}
	
	public static boolean updateStudentRecords(String srn, String sfn, String sln, String sfathern,String smothern, String sad, String smn, String sei, String selectedGender, String scd, String stf, String smf, String cn, String sadate, String sdob, String sc, String sbt)
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url,uname,upass);
			
			String sql = "update student_records set S_name = ?,  L_name = ?, S_fathername = ?, S_mothername = ?, S_address = ?, S_mobile_number = ?,  S_dateOfBirth = ?, S_gender = ?, S_Email_id = ?, S_course = ?, S_course_dur = ?, S_total_fee = ?, S_monthly_fee = ?, S_batch_time = ?, S_admition_date = ?, counsellor_name = ? where S_rollno = ?";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, sfn);
			ps.setString(2, sln);
			ps.setString(3, sfathern);
			ps.setString(4, smothern);
			ps.setString(5, sad);
			ps.setString(6, smn);
			ps.setString(7, sdob);
			ps.setString(8, selectedGender);
			ps.setString(9, sei);
			ps.setString(10, sc);
			ps.setString(11, scd);
			ps.setString(12, stf);
			ps.setString(13, smf);
			ps.setString(14, sbt);
			ps.setString(15, sadate);
			ps.setString(16, cn);
			ps.setString(17, srn);
			
			ps.executeUpdate();
			
			return true;
		
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			JOptionPane.showMessageDialog(null,"You can not save duplicate Records","",JOptionPane.ERROR_MESSAGE);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
		return false;
	}
		
	public static boolean deleteRecord(String srollno)
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "delete from student_records where S_rollno = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			int rollno = Integer.parseInt(srollno);
			
			ps.setInt(1, rollno);
			
			ps.executeUpdate();
			
			return true;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		return false;
	}
	
	public static boolean updateBatchTime(String rollno,String btime)
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "update student_records set S_batch_time = ? where S_rollno = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			int srollno = Integer.parseInt(rollno);
			ps.setString(1, btime);
			ps.setInt(2, srollno);
			
			ps.executeUpdate();
			
			return true;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		return false;
	}
	
	public static void overAllStudents()
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "select * from student_records";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
//				String[] SColName = new String[] {"Roll no.","Student First Name","Student Last Name","Father Name","Mother Name","Address"
//						, "Mobile Number","Date Of Birth","Gender","Course","Email Id","Course Duration","Total fee","Monthly Fee"
//						, "Admission Date","Batch Time","Counseller Name"};
				
				OverAllSDetails.srn = String.valueOf(rs.getInt("S_rollno"));
				OverAllSDetails.sfn = rs.getString("S_name");
				OverAllSDetails.sln = rs.getString("L_name");
				OverAllSDetails.sfathern = rs.getString("S_fathername");
				OverAllSDetails.smothern = rs.getString("S_mothername");
				OverAllSDetails.sad =  rs.getString("S_address");
				OverAllSDetails.smn = rs.getString("S_mobile_number");
				OverAllSDetails.sdob = rs.getString("S_dateOfBirth");
				OverAllSDetails.gender = rs.getString("S_gender");
				OverAllSDetails.sc = rs.getString("S_course");
				OverAllSDetails.sei = rs.getString("S_Email_id");
				OverAllSDetails.scd = rs.getString("S_course_dur");
				OverAllSDetails.stf = rs.getString("S_total_fee");
				OverAllSDetails.smf = rs.getString("S_monthly_fee");
				OverAllSDetails.sadate = rs.getString("S_admition_date");
				OverAllSDetails.sbt = rs.getString("S_batch_time");
				OverAllSDetails.cn = rs.getString("counsellor_name");
				
				
				
				OverAllSDetails.ShowRecords();
				
				
				
			}
			
		
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		
	}
	
	public static int getTfaclty()
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "select * from faculty_records";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.last();
			
			return rs.getInt(1);
			
			
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
		return -1;
	}
	
	public static boolean addFacultyRecords(String fId, String fn, String selectGender, String fdept, String fdesi, String fa, String fcno, String fei, String fs, String fdoj)
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uname,upass);
			
			String sql = "insert into faculty_records(facid, facname, Gender, Department, Designation, Address, Contact_no, Email_id, facSalary, DOJ) values(?,?,?,?,?,?,?,?,?,?)";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			
			int fid = Integer.parseInt(fId);
			int fsalary = Integer.parseInt(fs);
			
			ps.setInt(1,fid);
			ps.setString(2, fn);
			ps.setString(3, selectGender);
			ps.setString(4, fdept);
			ps.setString(5, fdesi);
			ps.setString(6, fa);
			ps.setString(7, fcno);
			ps.setString(8, fei);
			ps.setInt(9, fsalary);
			ps.setString(10, fdoj);
			
			ps.executeUpdate();
			
		
			return true;
		
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			JOptionPane.showMessageDialog(null,"This record is already Exist");
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
		return false;

	}	
	
	public static boolean getfacultyRecords()
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "Select * from faculty_records";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				ANFaculty.fId = String.valueOf(rs.getInt("facid"));
				ANFaculty.fn = rs.getString("facname");
				ANFaculty.selectGender = rs.getString("Gender");
				ANFaculty.fdept = rs.getString("Department");
				ANFaculty.fdesi = rs.getString("Designation");
				ANFaculty.fa = rs.getString("Address");
				ANFaculty.fcno = rs.getString("Contact_no");
				ANFaculty.fei = rs.getString("Email_id");
				ANFaculty.fs = rs.getString("facSalary");			
				ANFaculty.fdoj = rs.getString("DOJ");
				
				
				ANFaculty.showRecords();
			}
			return true;
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
		return false;
		
	}
	
	public static void getNewfacultyRecords()
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "Select * from faculty_records";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.last();
			
				ANFaculty.fId = String.valueOf(rs.getInt("facid"));
				ANFaculty.fn = rs.getString("facname");
				ANFaculty.selectGender = rs.getString("Gender");
				ANFaculty.fdept = rs.getString("Department");
				ANFaculty.fdesi = rs.getString("Designation");
				ANFaculty.fa = rs.getString("Address");
				ANFaculty.fcno = rs.getString("Contact_no");
				ANFaculty.fei = rs.getString("Email_id");
				ANFaculty.fs = rs.getString("facSalary");			
				ANFaculty.fdoj = rs.getString("DOJ");
				
				
				ANFaculty.showRecords();
			
			//return true;
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
		//return false;
		
	}
	
	public static boolean updateFacultyRecords(String fId, String fn, String selectGender, String fdept, String fdesi, String fa, String fcno, String fei, String fs, String fdoj)
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uname, upass);
			String sql = "update faculty_records set facname = ?, Gender = ?, Department = ?, Designation = ?, Address = ?, Contact_no = ?, Email_id = ?, facSalary = ?, DOJ = ? where facid = ?";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, fn);
			ps.setString(2, selectGender);
			ps.setString(3, fdept);
			ps.setString(4, fdesi);
			ps.setString(5, fa);
			ps.setString(6, fcno);
			ps.setString(7, fei);
			ps.setString(8, fs);
			ps.setString(9, fdoj);
			ps.setString(10, fId);
			
			ps.executeUpdate();
			
			return true;
			
		
		}
		catch(ClassNotFoundException e)
		{
				System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
		return false;
	}
	
	public static boolean deleteFacultyRecord(String fId)
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uname, upass);
			String sql = "delete from faculty_records where facid = ?";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			
			int fid = Integer.parseInt(fId);
			ps.setInt(1, fid);
			
			ps.executeUpdate();
			
			return true;
			
		
		}
		catch(ClassNotFoundException e)
		{
				System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
		return false;
	}
	

	public static int getFeeLastCode()
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "Select feeCode_no from fee_entry";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.last();
			
			return rs.getInt(1);
			
	
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
		
		return -1;
		
	}

	public static boolean getFeeDetails(String rollno)
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "Select * from student_records where S_rollno = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,rollno);
			
			ResultSet rs = ps.executeQuery();
			
			rs.first();
		
			FeeEntry.sname.setText(rs.getString("S_name"));
			FeeEntry.sfathername.setText(rs.getString("S_fathername"));
			FeeEntry.course.setText(rs.getString("S_course"));
			FeeEntry.mfee.setText(rs.getString("S_monthly_fee"));
			FeeEntry.tfee.setText(rs.getString("S_total_fee"));
			
			getBalance(rollno);
			
			return true;
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
		return false;
	}
	
	public static void getBalance(String rollno)
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "Select min(total_fee) - sum(paid_fee) from fee_entry where rollno = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,rollno);
			
			ResultSet rs = ps.executeQuery();
			
			rs.first();
		
			int balance = rs.getInt("min(total_fee) - sum(paid_fee)");
			
			FeeEntry.bfee.setText(String.valueOf(balance));
			
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
		
	}

	public static boolean addFeeRecord(String rn, String sn, String sfn, String co, String mf, String tf, String pf, String bf,String d,String cn)
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "insert into fee_entry(rollno,name,fathername,course,date,monthly_fee,total_fee,paid_fee,balance_fee,counsellername) values(?,?,?,?,?,?,?,?,?,?)";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,Integer.parseInt(rn));
			ps.setString(2,sn);
			ps.setString(3,sfn);
			ps.setString(4,co);
			ps.setString(5,d);
			ps.setString(6,mf);
			ps.setString(7,tf);
			ps.setString(8,pf);
			ps.setString(9,bf);
			ps.setString(10,cn);
			
			ps.executeUpdate();
			
			
			return true;
		
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
		return false;
		
	}
	

	public static boolean updateFeeRecord(String fc, String d, String pf, String cn)
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "update fee_entry set date = ? ,paid_fee =? ,counsellername = ? where feeCode_no = ? ";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, d);
			ps.setString(2, pf);
			ps.setString(3, cn);
			
			int fcode = Integer.parseInt(fc);
			ps.setInt(4, fcode);
			
			ps.executeUpdate();
			
			
			return true;
		
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}	
		return false;
		
	}
	
	public static boolean deleteFeeRecord(String fc)
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "delete from fee_entry where feeCode_no = ? ";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			
			int fcode = Integer.parseInt(fc);
			ps.setInt(1, fcode);
			
			ps.executeUpdate();
			
			
			return true;
		
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}	
		return false;
		
	}
	
	
	public static void getAllRecordsOffee()
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "select * from fee_entry";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				FeeEntry.fc = String.valueOf(rs.getInt("feeCode_no"));
				FeeEntry.rn = String.valueOf(rs.getInt("rollno"));
				FeeEntry.sn = rs.getString("name");
				FeeEntry.sfn = rs.getString("fathername");
				FeeEntry.co = rs.getString("course");
				FeeEntry.d = rs.getString("date");
				FeeEntry.mf = rs.getString("monthly_fee");
				FeeEntry.tf = rs.getString("total_fee");
				FeeEntry.pf = rs.getString("paid_fee");
				FeeEntry.bf = rs.getString("balance_fee");
				FeeEntry.cn = rs.getString("counsellername");
				
				FeeEntry.showfeeRecords();
			}
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
	}
	
	public static void getLastRecordsOffee()
	{
		try
		{
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "select * from fee_entry";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			rs.last();
			
				FeeEntry.fc = String.valueOf(rs.getInt("feeCode_no"));
				FeeEntry.rn = String.valueOf(rs.getInt("rollno"));
				FeeEntry.sn = rs.getString("name");
				FeeEntry.sfn = rs.getString("fathername");
				FeeEntry.co = rs.getString("course");
				FeeEntry.d = rs.getString("date");
				FeeEntry.mf = rs.getString("monthly_fee");
				FeeEntry.tf = rs.getString("total_fee");
				FeeEntry.pf = rs.getString("paid_fee");
				FeeEntry.bf = rs.getString("balance_fee");
				FeeEntry.cn = rs.getString("counsellername");
				
				FeeEntry.showfeeRecords();
			
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
	}
	
	public static void setSDetails()
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uname, upass);
			
			String sql = "Select * from student_records where S_name = ? and S_mobile_number = ? and S_Email_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, SContact_no);
			ps.setString(3, SEmail_Id);
			
			ResultSet rs = ps.executeQuery();
			
			rs.first();
			
//			JTextField rollnot,namet,lastnamet,fathernamet,mothernamet,emailidt,mobilet,DOBt,gendert,courset,coursedurationt,totalfeet,monthlyfeet,admissiondatet,batchtimet;
//			JTextArea addresst;
			SDetails.rollnot.setText(String.valueOf(rs.getInt("S_rollno")));
			SDetails.namet.setText(rs.getString("S_name"));
			SDetails.lastnamet.setText(rs.getString("L_name"));
			SDetails.fathernamet.setText(rs.getString("S_fathername"));
			SDetails.mothernamet.setText(rs.getString("S_mothername"));
			SDetails.addresst.setText(rs.getString("S_address"));
			SDetails.emailidt.setText(rs.getString("S_Email_id"));
			SDetails.mobilet.setText(rs.getString("S_mobile_number"));
			SDetails.DOBt.setText(rs.getString("S_dateOfBirth"));
			SDetails.gendert.setText(rs.getString("S_gender"));
			SDetails.courset.setText(rs.getString("S_course"));
			SDetails.coursedurationt.setText(rs.getString("S_course_dur"));
			SDetails.totalfeet.setText(rs.getString("S_total_fee"));
			SDetails.monthlyfeet.setText(rs.getString("S_monthly_fee"));
			SDetails.admissiondatet.setText(rs.getString("S_admition_date"));
			SDetails.batchtimet.setText(rs.getString("S_batch_time"));
			
	
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
		
	}
	
	public static void getFeeDetails()
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uname, upass);
			String sql = "Select * from fee_entry where rollno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, rollno);
			
			ResultSet rs = ps.executeQuery();
		
			while(rs.next())
			{

				//	static String feecode,rollno,sname,sfathername,course,date,mfee,tfee,pfee,bfee,counseller;
				FDetails.feecode = String.valueOf(rs.getInt("feeCode_no"));
				FDetails.rollno = String.valueOf(rs.getInt("rollno"));
				FDetails.sname = rs.getString("name");
				FDetails.sfathername = rs.getString("fathername");
				FDetails.course = rs.getString("course");
				FDetails.date = rs.getString("date");
				FDetails.mfee = rs.getString("monthly_fee");
				FDetails.tfee = rs.getString("total_fee");
				FDetails.pfee = rs.getString("paid_fee");
				FDetails.bfee = rs.getString("balance_fee");
				FDetails.counseller = rs.getString("counsellername");
				
				FDetails.setFeeDetails();
			}
		}
		catch(ClassNotFoundException e)
		{
			System.err.println(e);
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
	}
	
}
