package notepad;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class NotePad implements ActionListener{

	
	JFrame jf;
	JPanel container,conoftext;
	JMenuBar menubar;
	JMenu file,edit,format,view,help;
	JMenuItem newfile,open,save,saveas,pagesetup,print,exit;
	JMenuItem wordwrap,font,fcolor;
	JMenuItem statusbar;
	JMenuItem vwhelp,abnotepad;
	JTextArea textarea;
	JPanel p_file1,p_file2;
	
	JFileChooser filec; 
	FileInputStream fileInput;
	FileOutputStream fileOut;
	FileOutputStream copy;
	File copy2 = null;
	
	String cpy= null;
	JDialog Exit;
	JDialog FontD;
	
	String textareadata = null;
	
	public NotePad() 
	{
		jf = new JFrame("Untitled-NotePad");
		jf.setVisible(true);
		jf.setSize(new Dimension(300*2+132,200*2+52));
		jf.setLocation(250,20);
		jf.setIconImage(new ImageIcon("D:\\notpadicon.jpg").getImage());
	
		
		//panel
		container = new JPanel();
		container.setBackground(new Color(0,130,156));
		//container.setBorder(BorderFactory.createLineBorder(new Color(0,130,156)));
		container.setLayout(new BorderLayout());
		
		
		//Panel of textares
		conoftext = new JPanel();
		conoftext.setBorder(BorderFactory.createLineBorder(new Color(0,130,156,100)));
		conoftext.setLayout(new BorderLayout());
		
		//menubar
		menubar = new JMenuBar();
		menubar.setBackground(new Color(255,255,255));
		menubar.setBorder(BorderFactory.createLineBorder(new Color(255,255,255	)));
		container.add(menubar,BorderLayout.NORTH);
		
		//textarea
		textarea = new JTextArea();
		textarea.setFont(new Font("Arial",Font.PLAIN,18));
		textarea.setBorder(BorderFactory.createEmptyBorder());
		JScrollPane sp = new JScrollPane(textarea);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//add scrollpane in conoftext
		conoftext.add(sp);
		
		//add conoftext in container
		container.add(conoftext,BorderLayout.CENTER);
		
		
		
		//menu
		file = new JMenu("File");
		file.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,12));
		file.setForeground(Color.BLACK);
		
		
		
		edit = new JMenu("Edit");
		edit.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,12));
		edit.setForeground(Color.BLACK);
		
		format = new JMenu("Format");
		format.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,12));
		format.setForeground(Color.BLACK);
		
		view = new JMenu("View");
		view.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,12));
		view.setForeground(Color.BLACK);
		
		help = new JMenu("Help");
		help.setFont(new Font("sans-serif",Font.ROMAN_BASELINE,12));
		help.setForeground(Color.BLACK);
		
		
				
		//items 
		newfile = new JMenuItem("          New                         Ctrl+N");
		newfile.setBackground(Color.white);
		newfile.setFont(new Font("Sans-reif",Font.PLAIN,12));
		newfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("          New                         Ctrl+N"))
				{
					jf.setTitle("Untitled-NotePad");
					textarea.setText("");
				}
				
			}
			
		});
		
		open = new JMenuItem("          Open                        Ctrl+O");
		open.setBackground(Color.white);
		open.setFont(new Font("Sans-reif",Font.PLAIN,12));
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getActionCommand().equals("          Open                        Ctrl+O"));
				{
					filec = new JFileChooser("open file");
					int value = filec.showOpenDialog(jf);
					if(value == filec.APPROVE_OPTION)
					{
						File file = filec.getSelectedFile();
						copy2 = new File(file.getAbsolutePath());
						cpy = file.getAbsolutePath();
						
						try {
								
								fileInput = new FileInputStream(file.getAbsolutePath());
					
								StringBuilder add = new StringBuilder();
								int i;
								do {
									i = fileInput.read();
									if(i != -1)
									{
								
										add.append(String.valueOf((char)i));
									
									}
								}while(i != -1);
								
								textarea.setText(add.toString());
								jf.setTitle(file.getName()+" - NotePad");
							}
							catch (FileNotFoundException e1) 
							{
								e1.printStackTrace();
							} 
							catch (IOException e1)
							{
								e1.printStackTrace();
							}
					}
				}
				
			}

	
			
		});
		save = new JMenuItem("          Save                        Ctrl+S");
		save.setBackground(Color.white);
		save.setFont(new Font("Sans-reif",Font.PLAIN,12));
		save.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				if(e.getActionCommand().equals("          Save                        Ctrl+S"))
				{
					if(jf.getTitle().equals("Untitled-NotePad")) 
					{
						String Directory = null;
					   
						Directory = JOptionPane.showInputDialog(jf,"Select Directory : C , D, E", "");
						if(Directory.equalsIgnoreCase("C") || Directory.equalsIgnoreCase("D") || Directory.equalsIgnoreCase("E"))
						{
							String FileName = JOptionPane.showInputDialog(jf, "Enter File Name");
							
							if(FileName.length() > 0)
							{
								
								String Extension = JOptionPane.showInputDialog(jf,"You Can Enter Here Extension Otherwise Bydefaoult create .txt file");
								
								if(Extension.equalsIgnoreCase("CSS") || Extension.equalsIgnoreCase("TXT") || Extension.equalsIgnoreCase("PHP") || Extension.equalsIgnoreCase("HTML"))
								{
									try
									{
								
										copy2 = new File(Directory+":/"+FileName+"."+Extension);
										copy2.createNewFile();
										fileOut = new FileOutputStream(Directory+":/"+FileName+"."+Extension);
										
										String textareaData = textarea.getText();
										char data[] = textareaData.toCharArray();
										
										for(int i=0; textareaData.length() > i;  i++)
										{
											fileOut.write(data[i]);
										}
										
										jf.setTitle(FileName+" - NotePad");
										fileOut.close();
										
										cpy = Directory+":/"+FileName+"."+Extension;
										//this.cpy(Directory,FileName,Extension);
									}
									catch (FileNotFoundException e1) {
									
										System.err.println(e);
									} 
									catch (IOException e1) {
										
										System.err.println(e);
									}
								
								}
								
								else
								{
									if(Extension.length() > 0)
									{
										JOptionPane.showMessageDialog(jf,"Invalide Extension !!!","", JOptionPane.ERROR_MESSAGE);
									}
									else
									{
										try 
										{
											copy2 = new File(Directory+":/"+FileName+".txt");
											copy2.createNewFile();
											fileOut = new FileOutputStream(Directory+":/"+FileName+".txt");
											
											String textareaData = textarea.getText();
											char data[] = textareaData.toCharArray();
											
											for(int i=0; textareaData.length() > i;  i++)
											{
												fileOut.write(data[i]);
											}
											
											jf.setTitle(FileName+" - NotePad");
											cpy = Directory+":/"+FileName+".txt";//
											fileOut.close();
											
										} 
										catch (FileNotFoundException e1) 
										{
											
											e1.printStackTrace();
										} 
										catch (IOException e1) {
										
											e1.printStackTrace();
										}
									}
									
								}
									
					
							}
							else
							{
								JOptionPane.showMessageDialog(jf,"You Don't Enter File Name..","", JOptionPane.ERROR_MESSAGE);
							}
							
						}
						else
						{
							if(Directory.length() > 0)
							{
								JOptionPane.showMessageDialog(jf,"Invalide Directory !!!","ERROR",JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								JOptionPane.showMessageDialog(jf,"You Don't Enter Directoyr !!!","", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					
					else
					{
						
						
						copy2.delete();
					
						try 
						{
							fileOut = new FileOutputStream(cpy);
						
							String textareaData = textarea.getText();
							char data[] = textareaData.toCharArray();
						
							for(int i=0; textareaData.length() > i;  i++)
							{
								fileOut.write(data[i]);
							}
						}
						catch (FileNotFoundException e1) 
						{
							System.err.println(e);
						} 
						catch (IOException e1)
						{
							e1.printStackTrace();
						}
					}
				
				}
			}

//			private void cpy(String fd, String fn, String fex) {
//				
//				 cpy = fd+":/"+fn+"."+fex;
//				 
//			}

			
		});
		
		saveas = new JMenuItem("          Save as...                        ");
		saveas.setBackground(Color.white);
		saveas.setFont(new Font("Sans-reif",Font.PLAIN,12));
		saveas.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				if(e.getActionCommand().equals("          Save as...                        "))
				{
					
						String Directory = null;
					   
						Directory = JOptionPane.showInputDialog(jf,"Select Directory : C , D, E", "");
						if(Directory.equalsIgnoreCase("C") || Directory.equalsIgnoreCase("D") || Directory.equalsIgnoreCase("E"))
						{
							String FileName = JOptionPane.showInputDialog(jf, "Enter File Name");
							
							if(FileName.length() > 0)
							{
								
								String Extension = JOptionPane.showInputDialog(jf,"You Can Enter Here Extension Otherwise Bydefaoult create .txt file");
								
								if(Extension.equalsIgnoreCase("CSS") || Extension.equalsIgnoreCase("TXT") || Extension.equalsIgnoreCase("PHP") || Extension.equalsIgnoreCase("HTML"))
								{
									try
									{
								
										copy2 = new File(Directory+":/"+FileName+"."+Extension);
										copy2.createNewFile();
										fileOut = new FileOutputStream(Directory+":/"+FileName+"."+Extension);
										
										String textareaData = textarea.getText();
										char data[] = textareaData.toCharArray();
										
										for(int i=0; textareaData.length() > i;  i++)
										{
											fileOut.write(data[i]);
										}
										
										jf.setTitle(FileName+" - NotePad");
										fileOut.close();
										
										cpy = Directory+":/"+FileName+"."+Extension;
										//this.cpy(Directory,FileName,Extension);
									}
									catch (FileNotFoundException e1) {
									
										System.err.println(e);
									} 
									catch (IOException e1) {
										
										System.err.println(e);
									}
								
								}
								
								else
								{
									if(Extension.length() > 0)
									{
										JOptionPane.showMessageDialog(jf,"Invalide Extension !!!","", JOptionPane.ERROR_MESSAGE);
									}
									else
									{
										try 
										{
											fileOut = new FileOutputStream(Directory+":/"+FileName+".txt");
											String textareaData = textarea.getText();
											char data[] = textareaData.toCharArray();
											
											for(int i=0; textareaData.length() > i;  i++)
											{
												fileOut.write(data[i]);
											}
											jf.setTitle(FileName+" - NotePad");
										} 
										catch (FileNotFoundException e1) 
										{
											
											e1.printStackTrace();
										} 
										catch (IOException e1) {
										
											e1.printStackTrace();
										}
									}
									
								}
									
					
							}
							else
							{
								JOptionPane.showMessageDialog(jf,"You Don't Enter File Name..","", JOptionPane.ERROR_MESSAGE);
							}
							
						}
						else
						{
							if(Directory.length() > 0)
							{
								JOptionPane.showMessageDialog(jf,"Invalide Directory !!!","ERROR",JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								JOptionPane.showMessageDialog(jf,"You Don't Enter Directoyr !!!","", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					
					else
					{
						
						
						copy2.delete();
					
						try 
						{
							fileOut = new FileOutputStream(cpy);
						} 
						catch (FileNotFoundException e2) {
							
							e2.printStackTrace();
						}
						String textareaData = textarea.getText();
						char data[] = textareaData.toCharArray();
					
						for(int i=0; textareaData.length() > i;  i++)
						{
							try 
							{
								
								fileOut.write(data[i]);
								
							} 
							catch (IOException e1) {
								
								e1.printStackTrace();
							}
						}
					}
				
				
			}

//			private void cpy(String fd, String fn, String fex) {
//				
//				 cpy = fd+":/"+fn+"."+fex;
//				 
//			}

			
		});
		
		pagesetup = new JMenuItem("          Pagesetup...                        ");
		pagesetup.setBackground(Color.white);
		pagesetup.setFont(new Font("Sans-reif",Font.PLAIN,12));
		print = new JMenuItem("          Print...                      Ctrl+P");
		print.setBackground(Color.white);
		print.setFont(new Font("Sans-reif",Font.PLAIN,12));
		print.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					boolean complete = textarea.print();
					if(complete)
					{
						JOptionPane.showMessageDialog(jf, "Done Printing", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(jf, "Printing!", "Printer", JOptionPane.ERROR_MESSAGE);
					}
				} 
				catch (PrinterException e1)
				{
					JOptionPane.showMessageDialog(null,e1);
				}
				
			}
			
		});
		
		
		exit = new JMenuItem("          Exit                          ");
		exit.setBackground(Color.white);
		exit.setFont(new Font("Sans-reif",Font.PLAIN,12));
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("          Exit                          "))
				{
					if(textarea.getText().length() > 0)
					{
						Exit = new JDialog(jf,"NotePad");
						Exit.setVisible(true);
						Exit.setLocationRelativeTo(null);
						//Exit.setLocation(jf.getX()+100,jf.getY()+200);
						Exit.setSize(new Dimension(400,145));
						Exit.setLayout(null);
						
						JLabel message = new JLabel("   Do you want to save change to Untitled?");
						message.setFont(new Font("Sans-reif",Font.PLAIN,16));
						message.setForeground(Color.blue);
						message.setBounds(10,10,400,20);
						
						JPanel msg = new JPanel();
						msg.setBounds(0,0,400,70);
						msg.setBackground(Color.white);
						msg.setLayout(null);
						msg.add(message);
						
						JPanel button = new JPanel();
						button.setBounds(0,70,400,35);
						
						button.setLayout(null);
						
						
						JButton savec = new JButton("Save");
						savec.setBackground(Color.white);
						savec.setBounds(115,5,70,25);
						savec.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e)
							{
								if(e.getActionCommand().equals("Save"))
								{
									Exit.setVisible(false);
									
									if(jf.getTitle().equals("Untitled-NotePad")) 
									{
										String Directory = null;
									   
										Directory = JOptionPane.showInputDialog(jf,"Select Directory : C , D, E", "");
										if(Directory.equalsIgnoreCase("C") || Directory.equalsIgnoreCase("D") || Directory.equalsIgnoreCase("E"))
										{
											String FileName = JOptionPane.showInputDialog(jf, "Enter File Name");
											
											if(FileName.length() > 0)
											{
												
												String Extension = JOptionPane.showInputDialog(jf,"You Can Enter Here Extension Otherwise Bydefaoult create .txt file");
												
												if(Extension.equalsIgnoreCase("CSS") || Extension.equalsIgnoreCase("TXT") || Extension.equalsIgnoreCase("PHP") || Extension.equalsIgnoreCase("HTML"))
												{
													try
													{
												
														copy2 = new File(Directory+":/"+FileName+"."+Extension);
														copy2.createNewFile();
														fileOut = new FileOutputStream(Directory+":/"+FileName+"."+Extension);
														
														String textareaData = textarea.getText();
														char data[] = textareaData.toCharArray();
														
														for(int i=0; textareaData.length() > i;  i++)
														{
															fileOut.write(data[i]);
														}
														
														jf.setTitle(FileName+" - NotePad");
														fileOut.close();
														
														cpy = Directory+":/"+FileName+"."+Extension;
														//this.cpy(Directory,FileName,Extension);
													}
													catch (FileNotFoundException e1) {
													
														System.err.println(e);
													} 
													catch (IOException e1) {
														
														System.err.println(e);
													}
												
												}
												
												else
												{
													if(Extension.length() > 0)
													{
														JOptionPane.showMessageDialog(jf,"Invalide Extension !!!","", JOptionPane.ERROR_MESSAGE);
													}
													else
													{
														try 
														{
															copy2 = new File(Directory+":/"+FileName+".txt");
															copy2.createNewFile();
															fileOut = new FileOutputStream(Directory+":/"+FileName+".txt");
															
															String textareaData = textarea.getText();
															char data[] = textareaData.toCharArray();
															
															for(int i=0; textareaData.length() > i;  i++)
															{
																fileOut.write(data[i]);
															}
															
															jf.setTitle(FileName+" - NotePad");
															cpy = Directory+":/"+FileName+".txt";//
															fileOut.close();
															
														} 
														catch (FileNotFoundException e1) 
														{
															
															e1.printStackTrace();
														} 
														catch (IOException e1) {
														
															e1.printStackTrace();
														}
													}
													
												}
													
									
											}
											else
											{
												JOptionPane.showMessageDialog(jf,"You Don't Enter File Name..","", JOptionPane.ERROR_MESSAGE);
											}
											
										}
										else
										{
											if(Directory.length() > 0)
											{
												JOptionPane.showMessageDialog(jf,"Invalide Directory !!!","ERROR",JOptionPane.ERROR_MESSAGE);
											}
											else
											{
												JOptionPane.showMessageDialog(jf,"You Don't Enter Directoyr !!!","", JOptionPane.ERROR_MESSAGE);
											}
										}
									}
									
									else
									{
										
										
										copy2.delete();
									
										try 
										{
											fileOut = new FileOutputStream(cpy);
										
											String textareaData = textarea.getText();
											char data[] = textareaData.toCharArray();
										
											for(int i=0; textareaData.length() > i;  i++)
											{
												fileOut.write(data[i]);
											}
											System.exit(0);
										}
										catch (FileNotFoundException e1) 
										{
											System.err.println(e);
										} 
										catch (IOException e1)
										{
											e1.printStackTrace();
										}
									}
								
								}
								
							}
							
							

//							private void cpy(String fd, String fn, String fex) {
//								
//								 cpy = fd+":/"+fn+"."+fex;
//								 
//							}

							
						});
						

						
						JButton dontsave = new JButton("Don't Save");
						dontsave.setBackground(Color.white);
						dontsave.setBounds(190,5,95,25);
						dontsave.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e)
							{
								System.exit(0);
							}
						});
						
						JButton cencel = new JButton("Cencel");
						cencel.setBackground(Color.white);
						cencel.setBounds(290,5,75,25);
						cencel.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e)
							{
								Exit.setVisible(false);
							}
						});
						
						
						button.add(savec);
						button.add(dontsave);
						button.add(cencel);
					
						
						Exit.add(msg);
						Exit.add(button);
						
					}
					else
					{
					
							System.exit(0);
						
					}
				}
					
			}
			
		});
		
		
		file.add(newfile);
		file.add(open);
		file.add(save);
		file.add(saveas);
		file.add(pagesetup);
		file.add(print);
		file.add(exit);
		
		
		//items
		
		wordwrap = new JMenuItem("          Word Wrap       ");
		wordwrap.setBackground(Color.white);
		wordwrap.setFont(new Font("Sans-reif",Font.PLAIN,12));
	
		font = new JMenuItem("          Font...");
		font.setBackground(Color.white);
		font.setFont(new Font("Sans-reif",Font.PLAIN,12));
		font.addActionListener(new ActionListener() {

			JLabel fontTitle1;
			JLabel fontFTitle1;
			JPanel panel1;
			JList<String> listF;
			JLabel fontTitle2 ;
			JLabel fontSTitle2 ;
			JPanel panel2;
			JList<String> listS ;
			JLabel fontTitle3;
			JLabel fontSizeTitle3;
			JPanel panel3;
			JList<String> listSize;
			JLabel sample;
			JPanel panel4;
			JLabel live;
			JLabel Script;
			JPanel panel5;
			JLabel moreFont;
			
			String ffamily ;
			int fStyle;
			int fsize=18 ;
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FontD = new JDialog(jf, "Font");
				FontD.setVisible(true);
				FontD.setLocation(jf.getX()+100,jf.getY()+150);
				FontD.setSize(new Dimension(150*2+160,200*2+70));
				FontD.setLayout(null);
				FontD.setIconImage(new ImageIcon("D:\\notpadicon.jpg").getImage());
				
				fontTitle1 = new JLabel("Font:");
				fontTitle1.setBounds(10,10,172,20);
				fontTitle1.setFont(new Font("Candara",Font.PLAIN,14));
				fontTitle1.setForeground(new Color(0,0,0,240));
				
				fontFTitle1 = new JLabel("Arial");
				fontFTitle1.setBorder(BorderFactory.createLineBorder(new Color(23,125,191)));
				fontFTitle1.setFont(new Font("Candara",Font.PLAIN,14));
				fontFTitle1.setBounds(10,30,172,20);
				
				panel1 = new JPanel();
				panel1.setBorder(BorderFactory.createEmptyBorder());
				panel1.setBounds(10,50,172,120);
				panel1.setLayout(new BorderLayout());
				
				String fontfamily[] = new String[] {"Agency FB","ALGERIAN","Arial","Arial Rounded MT","Arial Unicod MS","Baskerville Old Face","Bauhause 93"};
				
				listF = new JList<String>(fontfamily);
				listF.setFont(new Font("Arial",Font.PLAIN,14));
				JScrollPane spane = new JScrollPane(listF); 
				panel1.add(spane,BorderLayout.CENTER);
				listF.addListSelectionListener(new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						
						fontFTitle1.setText(listF.getSelectedValue());
						ffamily = fontFTitle1.getText();
						
						live.setFont(new Font(ffamily,fStyle,fsize));
						listS.setFont(new Font(ffamily,Font.PLAIN,14));
					}
					
				});
				
				
				
				
				
				//FontStyle
				fontTitle2 = new JLabel("Font Style:");
				fontTitle2.setBounds(192,10,172,20);
				fontTitle2.setFont(new Font("Candara",Font.PLAIN,14));
				fontTitle2.setForeground(new Color(0,0,0,240));
				
				fontSTitle2 = new JLabel("Regular");
				fontSTitle2.setBorder(BorderFactory.createLineBorder(new Color(23,125,191)));
				fontSTitle2.setFont(new Font("Candara",Font.PLAIN,14));
				fontSTitle2.setBounds(192,30,172,20);
				
				
				panel2 = new JPanel();
				panel2.setBorder(BorderFactory.createEmptyBorder());
				panel2.setBounds(192,50,172,120);
				panel2.setLayout(new BorderLayout());
				
			
				String fontStyle[] = new String[] {"Regular","Bold","Oblique","Bold Oblique"};
				listS = new JList<String>(fontStyle);
				listS.setFont(new Font("Arial",Font.PLAIN,14));
				JScrollPane spane2 = new JScrollPane(listS); 
				spane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				panel2.add(spane2,BorderLayout.CENTER);
				listS.addListSelectionListener(new ListSelectionListener() {
					
					public void valueChanged(ListSelectionEvent e)
					{
						fontSTitle2.setText(listS.getSelectedValue());
						
						if(listS.getSelectedValue().equals("Regular"))
						{
							fStyle = Font.PLAIN;
						}
						else if(listS.getSelectedValue().equals("Bold"))
						{
							fStyle = Font.BOLD;
						}
						else if(listS.getSelectedValue().equals("Oblique"))
						{
							fStyle = Font.ITALIC;
						}
						else if(listS.getSelectedValue().equals("Bold Oblique"))
						{
							fStyle = Font.ITALIC+Font.BOLD;
						}
						
						live.setFont(new Font(ffamily,fStyle,fsize));
					}

					
				});
				
				
				
				//fontsize
				fontTitle3 = new JLabel("Size:");
				fontTitle3.setBounds(374,10,60,20);
				fontTitle3.setFont(new Font("Candara",Font.PLAIN,14));
				fontTitle3.setForeground(new Color(0,0,0,240));
				
				fontSizeTitle3 = new JLabel("18");
				fontSizeTitle3.setBorder(BorderFactory.createLineBorder(new Color(23,125,191)));
				fontSizeTitle3.setFont(new Font("Candara",Font.PLAIN,14));
				fontSizeTitle3.setBounds(374,30,60,20);
				
				panel3 = new JPanel();
				panel3.setBorder(BorderFactory.createEmptyBorder());
				panel3.setBounds(374,50,60,120);
				panel3.setLayout(new BorderLayout());
				
				String fontSize[] = new String[72];
				for(int i=0; i<fontSize.length; i++)
				{
					fontSize[i] = String.valueOf(i+1);
				}
				
				
				listSize = new JList<String>(fontSize);
				listSize.setFont(new Font("Arial",Font.PLAIN,14));
				listSize.setBorder(BorderFactory.createEmptyBorder());
				JScrollPane spane3 = new JScrollPane(listSize); 
				panel3.add(spane3,BorderLayout.CENTER);
				listSize.addListSelectionListener(new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						
						fontSizeTitle3.setText(listSize.getSelectedValue());
						fsize = Integer.parseInt(fontSizeTitle3.getText());
						
						live.setFont(new Font(ffamily,fStyle,fsize));
						
					}
					
				});
				
				
				//
				sample = new JLabel("Sample");
				sample.setBounds(192,180,100,20);
				sample.setFont(new Font("Candara",Font.PLAIN,14));
				
				panel4 = new JPanel();
				panel4.setBounds(192,200,242,80);
				panel4.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,30)));
				panel4.setLayout(new BorderLayout());
				
				live = new JLabel("<html><body width=242><center>AaBbYyZz</center></body></html>");
				live.setFont(new Font(ffamily,fStyle,fsize));
				panel4.add(live,BorderLayout.CENTER);
				
				
				
				//
				
				Script = new JLabel("Script:");
				Script.setBounds(192,290,100,20);
				Script.setFont(new Font("Candara",Font.PLAIN,14));
				
				panel5 = new JPanel();
				panel5.setBounds(192,310,242,20);
				panel5.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,00)));
				panel5.setLayout(new BorderLayout());
				
				String choose[] = new  String[] {"Western","Centeral Uropean"};	
				JComboBox western = new JComboBox(choose);
				
				western.setFont(new Font("Candara",Font.PLAIN,14));
				panel5.add(western,BorderLayout.CENTER);
				
				//
				
				moreFont = new JLabel("<html><a href='#'><font color='blue'>show more fonts</font></a></html>");
				moreFont.setBounds(10,350,100,20);
				
				JButton ok = new JButton("Ok");
				ok.setBounds(250,385,90,25	);
				ok.setBackground(Color.white);
				ok.setBorder(BorderFactory.createLineBorder(new Color(23,125,191)));
				
				
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						textarea.setFont(new Font(ffamily,fStyle,fsize));
						FontD.setVisible(false);
					}
					
				});
				
				
				JButton cencel = new JButton("Cencel");
				cencel.setBounds(350,385,80,25);
				cencel.setBackground(Color.white);
				
				//by default it already set 
				
				listF.setSelectedIndex(2);
				fontFTitle1.setText(listF.getSelectedValue());
				ffamily = fontFTitle1.getText();
				
				listS.setSelectedIndex(0);
				fontSTitle2.setText(listS.getSelectedValue());
				fStyle = Font.PLAIN;
				
				listSize.setSelectedIndex(17);
				fontSizeTitle3.setText(listSize.getSelectedValue());
				fsize = 18;
				
				//////////////
				
				FontD.add(fontTitle1);
				FontD.add(fontFTitle1);
				FontD.add(panel1);	
				
				FontD.add(fontTitle2);
				FontD.add(fontSTitle2);
				FontD.add(panel2);
				
				FontD.add(fontTitle3);
				FontD.add(fontSizeTitle3);
				FontD.add(panel3);
				
				
				FontD.add(panel4);
				FontD.add(sample);
				
				FontD.add(Script);
				FontD.add(panel5);
				
				FontD.add(moreFont);
				FontD.add(ok);
				FontD.add(cencel);
			}
			
		});
		
		//font color and background color create item
		fcolor = new JMenuItem("          Color...");
		fcolor.setBackground(Color.white);
		fcolor.setFont(new Font("Sans-reif",Font.PLAIN,12));
		fcolor.addActionListener(new ActionListener() {

			JLabel fcolor,bgcolor;
			JButton fcb,bgcb;
			JPanel Livebgc;
			JLabel Livefc;
			JDialog ColorD;
			JColorChooser crf,crb;
			Color colorf = textarea.getCaretColor(),colorb = textarea.getBackground();
			JButton OkColor,CencelColor;
			
			public void actionPerformed(ActionEvent arg0) {
				ColorD = new JDialog(jf,"Color");
				ColorD.setVisible(true);
				ColorD.setLocation(jf.getX()+100,jf.getY()+150);
				ColorD.setSize(new Dimension(150*2+160,220));
				ColorD.setLayout(null);
				
				fcolor = new JLabel("Font Color:");
				fcolor.setBounds(10,10,100,20);
				fcolor.setFont(new Font("Candara",Font.PLAIN,14));
				
				fcb = new JButton("Click");
				fcb.setBounds(10,30,90,25);
				fcb.setBackground(Color.white);
				fcb.setForeground(new Color(0,0,0,200));
				fcb.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				fcb.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e)
					{
						crf = new JColorChooser();
						colorf = JColorChooser.showDialog(ColorD,"Font Color",Color.black);
						Livefc.setForeground(colorf);
						
					}
				});
				
				bgcolor = new JLabel("Background Color:");
				bgcolor.setBounds(10,65,150,20);
				bgcolor.setFont(new Font("Candara",Font.PLAIN,14));
				
				bgcb = new JButton("Click");
				bgcb.setBounds(10,85,90,25);
				bgcb.setBackground(new Color(0,0,0,200));
				bgcb.setForeground(Color.white);
				bgcb.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				bgcb.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e)
					{
						crb = new JColorChooser();
						colorb = JColorChooser.showDialog(ColorD,"Font Color",Color.white);
						Livebgc.setBackground(colorb);
					}
					
				});
				
				
				Livebgc = new JPanel();
				Livebgc.setBounds(230,10,200,100);
				Livebgc.setBackground(colorb);
				Livebgc.setLayout(new BorderLayout());
				Livebgc.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,200)));
				
				
				Livefc = new JLabel("<html><body width=200><center><Font size=5>AaBbXxYy</div></center></body></html>");
				Livefc.setForeground(colorf);
				Livebgc.add(Livefc,BorderLayout.CENTER);
				
				OkColor = new JButton("Ok");
				OkColor.setBounds(240,145,90,25);
				OkColor.setBackground(Color.white);
				OkColor.setBorder(BorderFactory.createLineBorder(new Color(23,125,191)));
				OkColor.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e)
					{
						textarea.setBackground(colorb);
						textarea.setForeground(colorf);
						ColorD.setVisible(false);
					}

				});
				
				CencelColor = new JButton("Cencel");
				CencelColor.setBounds(340,145,90,25);
				CencelColor.setBackground(Color.white);
			
				
				
				ColorD.add(fcolor);
				ColorD.add(bgcolor);
				ColorD.add(fcb);
				ColorD.add(bgcb);
				ColorD.add(Livebgc);
				ColorD.add(OkColor);
				ColorD.add(CencelColor);
				
				
				
			}
			
		});
		
		//add in formate
		format.add(wordwrap);
		format.add(font);
		format.add(fcolor);
		//item of View
		statusbar = new JMenuItem("          Status Bar          ");
		statusbar.setBackground(Color.white);
		statusbar.setFont(new Font("Sans-reif",Font.PLAIN,12));
		
		//add in View
		view.add(statusbar);
		
		//item of help
		vwhelp = new JMenuItem("          View Help");
		vwhelp.setBackground(Color.white);
		vwhelp.setFont(new Font("Sans-reif",Font.PLAIN,12));
		abnotepad = new JMenuItem("          About NotePad");
		abnotepad.setBackground(Color.white);
		abnotepad.setFont(new Font("Sans-reif",Font.PLAIN,12));
		
		//add in help
		help.add(vwhelp);
		help.add(abnotepad);
		
		
		menubar.add(file);
		menubar.add(edit);
		menubar.add(format);
		menubar.add(view);
		menubar.add(help);
		
	//Right click
		
		
		
		//create Poppupmenu object of right
		JPopupMenu popmenu = new JPopupMenu();
		JSeparator spe = new JSeparator();
		
		spe.setBorder(BorderFactory.createLineBorder(new Color(23,125,191,10)));
		//create menuitems of right
		JMenuItem undo = new JMenuItem("          Undo        ");
		undo.setBackground(Color.white);
		undo.setFont(new Font("Sans-reif",Font.PLAIN,12));
		undo.setForeground(Color.gray);
		undo.addActionListener(this);
		
		JMenuItem cut = new JMenuItem("          Cut        ");
		cut.setBackground(Color.white);
		cut.setFont(new Font("Sans-reif",Font.PLAIN,12));
		cut.setForeground(Color.gray);
		
		JMenuItem copy = new JMenuItem("          Copy        ");
		copy.setBackground(Color.white);
		copy.setFont(new Font("Sans-reif",Font.PLAIN,12));
		copy.setForeground(Color.gray);
		
		JMenuItem paste = new JMenuItem("          Paste        ");
		paste.setBackground(Color.white);
		paste.setFont(new Font("Sans-reif",Font.PLAIN,12));
		paste.setForeground(Color.gray);
		
		JMenuItem delete = new JMenuItem("          Delete        ");
		delete.setBackground(Color.white);
		delete.setFont(new Font("Sans-reif",Font.PLAIN,12));
		delete.setForeground(Color.gray);
		delete.addActionListener(this);
		
		JMenuItem selectAll = new JMenuItem("          Select All        ");
		selectAll.setBackground(Color.white);
		selectAll.setFont(new Font("Sans-reif",Font.PLAIN,12));
		selectAll.setForeground(Color.gray);
	
		
		JMenuItem rtlROrder = new JMenuItem("          Right To Left Reading Order        ");
		rtlROrder.setBackground(Color.white);
		rtlROrder.setFont(new Font("Sans-reif",Font.PLAIN,12));
		
		JMenuItem succharacters = new JMenuItem("          Show Unicode Control Characters        ");
		succharacters.setBackground(Color.white);
		succharacters.setFont(new Font("Sans-reif",Font.PLAIN,12));
		
		//JMenu iuccharacter = new JMenu("<html><body><Table style='margin-left:24px;' cellspacing=0 cellpadding=0><tr><td>Insert Unicode Control Character</td><td width=50 align=right>&#62;</td></tr></Table></body><html>");

		JMenu iuccharacter = new JMenu("<html><body><Table style='margin-left:24px;' cellspacing=0 cellpadding=0><tr><td>Insert Unicode Control Character</td></tr></Table></body></html>");
		iuccharacter.setBackground(Color.white);
		iuccharacter.setFont(new Font("Sans-reif",Font.PLAIN,12));
		
		JMenuItem oime = new JMenuItem("          Open IME        ");
		oime.setBackground(Color.white);
		oime.setFont(new Font("Sans-reif",Font.PLAIN,12));
		
		JMenuItem reconversion = new JMenuItem("          Reconversion        ");
		reconversion.setBackground(Color.white);
		reconversion.setFont(new Font("Sans-reif",Font.PLAIN,12));
		
		
		//add items in popupmenu
		popmenu.add(undo);
		popmenu.add(spe);
		popmenu.add(cut);
		popmenu.add(copy);
		popmenu.add(paste);
		popmenu.add(delete);
		popmenu.add(new JSeparator());
		popmenu.add(selectAll);
		popmenu.add(new JSeparator());
		popmenu.add(rtlROrder);
		popmenu.add(succharacters);
		popmenu.add(iuccharacter);
		popmenu.add(new JSeparator());
		popmenu.add(oime);
		popmenu.add(reconversion);
		
		textarea.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me)
			{
				if(SwingUtilities.isRightMouseButton(me))
				{
					popmenu.show(me.getComponent(),me.getX(),me.getY());
					
					if(textarea.getText().length()>0)
					{
						undo.setForeground(Color.black);
						selectAll.setForeground(Color.black);
						
						textareadata = textarea.getText();
					}
					
					try
					{
						if(textarea.getSelectedText().length()>0)
						{
							cut.setForeground(Color.black);
							copy.setForeground(Color.black);
							delete.setForeground(Color.black);
							
					
							
						}
					}
					catch(NullPointerException e)
					{
						
					}
				}
				
			}
		});
		
		
		//
		JMenuItem LRM = new JMenuItem("<html><body><Table style='margin-left:24px;' cellspacing=0 cellpadding=0><tr><td width=50>LRM</td><td width=200 align=right><u>L</u>eft-to-right-mark</td></tr></Table></body></html>");
		JMenuItem RLM = new JMenuItem("<html><body><Table style='margin-left:24px;' cellspacing=0 cellpadding=0><tr><td width=50>RLM</td><td width=200 align=right><u>R</u>ight-to-left-mark</td></tr></Table></body></html>");
		JMenuItem ZWJ = new JMenuItem("<html><body><Table style='margin-left:24px;' cellspacing=0 cellpadding=0><tr><td width=50>ZWJ</td><td width=200 align=right>Zero width join</td></tr></Table></body></html>");
		JMenuItem ZWNJ = new JMenuItem("<html><body><Table style='margin-left:24px;' cellspacing=0 cellpadding=0><tr><td width=50>ZWNJ</td><td width=200 align=right>Zero width non-joiner</td></tr></Table></body></html>");
		JMenuItem LRE = new JMenuItem("<html><body><Table style='margin-left:24px;' cellspacing=0 cellpadding=0><tr><td width=50>LRE</td><td width=200 align=right>Start of left-to-right embeding</td></tr></Table></body></html>");
		JMenuItem RLE = new JMenuItem("<html><body><Table style='margin-left:24px;' cellspacing=0 cellpadding=0><tr><td width=50>RLE</td><td width=200 align=right>Start of Right-to-left embedding</td></tr></Table></body></html>");
		JMenuItem LRO = new JMenuItem("<html><body><Table style='margin-left:24px;' cellspacing=0 cellpadding=0><tr><td width=50>LRO</td><td width=200 align=right>Start of left-to-right override</td></tr></Table></body></html>");
		JMenuItem RLO = new JMenuItem("<html><body><Table style='margin-left:24px;' cellspacing=0 cellpadding=0><tr><td width=50>RLO</td><td width=200 align=right>Start of Right-to-left override</td></tr></Table></body></html>");




		iuccharacter.add(LRM);
		iuccharacter.add(RLM);
		iuccharacter.add(ZWJ);
		iuccharacter.add(ZWNJ);
		iuccharacter.add(LRE);
		iuccharacter.add(RLE);
		iuccharacter.add(LRO);
		iuccharacter.add(RLO);
		
		
		//
		
		
		
		textarea.addMouseMotionListener(new MouseMotionListener(){

			
			
			public void mouseDragged(MouseEvent arg0) {
				
				//textareadata = textarea.getText();
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				
				
			}

			
	
			
		});
		
		//
		
	//and Right click
		
		
		
		jf.add(container);
		
		
	}
 
	






	@Override
	public void actionPerformed(ActionEvent e) {


		if(e.getActionCommand().equals("          Undo        "))
		{
			textarea.setText(textareadata);


		}
		
		if(e.getActionCommand().equals("          Delete        "))
		{
			textarea.getSelectedText().replaceAll(textareadata, "vk");
			
			

		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


























	

























































	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run()
			{
				new NotePad();
			}
			
		});

	}



}


