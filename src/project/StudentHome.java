     package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class StudentHome extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField spi;
	
	static Connection myconn;
	static Statement mystmt;
	static ResultSet myrs;	
	static  PreparedStatement pstmt;
	StudentHome frame;
	static JFrame f;
    static JButton course,tt,bussch,att;
    private JTextArea output;
    private JLabel lblNewLabel_2;
    
    private JComboBox sec,sem,cors;
    private JButton logout;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JButton res,back;
    static String rolno;
    static JLabel strno;
    static JTextArea resar;
    static JLabel naam,id,sect,seme;
    
     /**
      * @wbp.parser.entryPoint
      */
    
    
   public StudentHome(int n) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		 back = new JButton("Back");
		 back.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblResult, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(174))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(back))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblResult, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 120, Short.MAX_VALUE)
						.addComponent(back))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		
		JLabel lblCourse = new JLabel("Course");
		
		JLabel lblInSem = new JLabel("In Sem1");
		
		JLabel lblInSem_1 = new JLabel("In Sem2");
		
		JLabel lblEndsem = new JLabel("EndSem");
		
		JLabel lblTotal = new JLabel("Total");
		
		JLabel lblGrade = new JLabel("Grade");
		
		 resar = new JTextArea();
		
		JLabel lblSpi = new JLabel("SPI : ");
		
		spi = new JTextField();
		spi.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(resar, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(34)
							.addComponent(lblCourse, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(lblInSem)
							.addGap(28)
							.addComponent(lblInSem_1)
							.addGap(26)
							.addComponent(lblEndsem)
							.addGap(29)
							.addComponent(lblTotal)
							.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
							.addComponent(lblGrade)
							.addGap(40)))
					.addGap(19))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(283, Short.MAX_VALUE)
					.addComponent(lblSpi, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(spi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourse)
						.addComponent(lblInSem)
						.addComponent(lblInSem_1)
						.addComponent(lblGrade)
						.addComponent(lblEndsem)
						.addComponent(lblTotal))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(resar, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpi)
						.addComponent(spi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(4, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblNewLabel = new JLabel("Roll No");
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lblSection = new JLabel("Section");
		
		JLabel lblSemester = new JLabel("Semester");
		
		 id = new JLabel("");
		
		 naam = new JLabel("");
		
		 sect = new JLabel("");
		
		 seme = new JLabel("");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
									.addGap(31))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblName)
									.addGap(51)))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblSection)
								.addGap(43)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblSemester)
							.addGap(33)))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(seme)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(sect)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(naam)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(id)
							.addGap(62))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(id))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(naam))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSection)
						.addComponent(sect))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSemester)
						.addComponent(seme))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}

    
    
    
    
    
    
    
     StudentHome(String Rollno, String sc,String sm){
    	rolno=Rollno;
    	 try {
		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		     
	  }catch(Exception ex) {
		  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");}
		

	
    	 
	    f=  new JFrame("Student Home"); 
	    f.getContentPane().setBackground(new Color(255, 255, 204));
	    
	    f.setSize(780,500);
	    
	    JLabel lblNewLabel = new JLabel("Student Home");
	    lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
	    
	     course = new JButton("");
	     course.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\project DBMS\\courseenroll.png"));
	     course.setForeground(new Color(0, 0, 0));
	     course.setBackground(new Color(255, 255, 255));
	    course.setFont(new Font("Verdana", Font.PLAIN, 15));
	    course.addActionListener(this);
	    
	     att = new JButton("");
	     att.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\project DBMS\\attendence.png"));
	    att.setFont(new Font("Verdana", Font.PLAIN, 15));
	    att.addActionListener(this);
	    
	     bussch = new JButton("");
	     bussch.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\project DBMS\\bus 100px.png"));
	    bussch.setFont(new Font("Verdana", Font.PLAIN, 15));
	    bussch.addActionListener(this);
	    
	     tt = new JButton("");
	     tt.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\project DBMS\\timetable.png"));
	    tt.setFont(new Font("Verdana", Font.PLAIN, 15));
	    tt.addActionListener(this);
	    
	    JLabel lblNewLabel_1 = new JLabel("Welcome :");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
	    
	     strno = new JLabel(".........................");
	    strno.setFont(new Font("Tahoma", Font.PLAIN, 17));
	    strno.setText(Rollno);
	    output = new JTextArea();
	    output.setBackground(new Color(204, 255, 204));
	    output.setFont(new Font("Monospaced", Font.PLAIN, 16));
	    
	    lblNewLabel_2 = new JLabel("Section ");
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    
	    JLabel lblNewLabel_2_1 = new JLabel("Sem");
	    lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    
	    JLabel lblNewLabel_2_2 = new JLabel("course");
	    lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    
	     sec = new JComboBox();
	    sec.setModel(new DefaultComboBoxModel(new String[] {sc}));
	    
	     sem = new JComboBox();
	    sem.setModel(new DefaultComboBoxModel(new String[] {sm}));
	    
	     cors = new JComboBox();
	    cors.setModel(new DefaultComboBoxModel(new String[] {"select", "BTech", "MTech"}));
	    
	    logout = new JButton("Logout");
	    logout.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    logout.addActionListener(this);
	    
	    lblNewLabel_3 = new JLabel("Courses");
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
	    
	    lblNewLabel_4 = new JLabel("Bus Schedule");
	    lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
	    
	    lblNewLabel_5 = new JLabel("Attendance");
	    lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
	    
	    lblNewLabel_6 = new JLabel("Time Table");
	    lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
	    
	    res = new JButton("");
	    res.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\project DBMS\\result100.png"));
	    res.addActionListener(this);
	    
	    GroupLayout groupLayout = new GroupLayout(f.getContentPane());
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addContainerGap(268, Short.MAX_VALUE)
	    					.addComponent(lblNewLabel)
	    					.addGap(242))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(37)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    						.addGroup(groupLayout.createSequentialGroup()
	    							.addComponent(lblNewLabel_1)
	    							.addPreferredGap(ComponentPlacement.RELATED)
	    							.addComponent(strno, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
	    							.addPreferredGap(ComponentPlacement.RELATED))
	    						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    							.addGroup(groupLayout.createSequentialGroup()
	    								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    									.addGroup(groupLayout.createSequentialGroup()
	    										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    											.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
	    											.addComponent(lblNewLabel_2))
	    										.addPreferredGap(ComponentPlacement.RELATED))
	    									.addGroup(groupLayout.createSequentialGroup()
	    										.addComponent(lblNewLabel_2_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    										.addGap(12)))
	    								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    									.addComponent(cors, Alignment.TRAILING, 0, 94, Short.MAX_VALUE)
	    									.addComponent(sem, 0, 94, Short.MAX_VALUE)
	    									.addComponent(sec, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
	    								.addGap(53))
	    							.addGroup(groupLayout.createSequentialGroup()
	    								.addComponent(res, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
	    								.addPreferredGap(ComponentPlacement.RELATED))))
	    					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    						.addGroup(groupLayout.createSequentialGroup()
	    							.addPreferredGap(ComponentPlacement.RELATED)
	    							.addComponent(output, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
	    						.addComponent(logout)
	    						.addGroup(groupLayout.createSequentialGroup()
	    							.addComponent(course, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
	    							.addGap(14)
	    							.addComponent(bussch, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
	    							.addPreferredGap(ComponentPlacement.UNRELATED)
	    							.addComponent(att, GroupLayout.PREFERRED_SIZE, 104, Short.MAX_VALUE)
	    							.addGap(18)
	    							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    								.addGroup(groupLayout.createSequentialGroup()
	    									.addGap(20)
	    									.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
	    								.addGroup(groupLayout.createSequentialGroup()
	    									.addPreferredGap(ComponentPlacement.UNRELATED)
	    									.addComponent(tt, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))))
	    					.addPreferredGap(ComponentPlacement.RELATED)))
	    			.addGap(69))
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(275)
	    			.addComponent(lblNewLabel_3)
	    			.addGap(55)
	    			.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
	    			.addGap(188))
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addContainerGap()
	    					.addComponent(lblNewLabel))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(43)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    							.addComponent(lblNewLabel_1)
	    							.addComponent(strno, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
	    						.addComponent(logout))))
	    			.addGap(86)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    				.addComponent(att, GroupLayout.PREFERRED_SIZE, 94, Short.MAX_VALUE)
	    				.addComponent(bussch, GroupLayout.PREFERRED_SIZE, 94, Short.MAX_VALUE)
	    				.addComponent(course, GroupLayout.PREFERRED_SIZE, 94, Short.MAX_VALUE)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    						.addComponent(lblNewLabel_2)
	    						.addComponent(sec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    					.addPreferredGap(ComponentPlacement.UNRELATED)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(sem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    					.addGap(14)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    						.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(cors, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	    				.addComponent(tt, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 94, Short.MAX_VALUE))
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addComponent(lblNewLabel_3)
	    				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
	    					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
	    					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(27)
	    					.addComponent(res, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addPreferredGap(ComponentPlacement.UNRELATED)
	    					.addComponent(output, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
	    			.addGap(49))
	    );
	    f.getContentPane().setLayout(groupLayout);
	    f.setVisible(true);  
     }
     
     public void actionPerformed(ActionEvent e){ 
    	  if(e.getSource()==course) {
    		  
    		  String rno=(String)strno.getText();
    		    try { 
    		    	  myrs=mystmt.executeQuery("select * from courseenroll where rolno='"+rno+"';");
    				
    				 while(myrs.next()) {
    				                 output.append(myrs.getString("coID"));
    				                 output.append("\n");
    				                // System.out.println(myrs.getString("rolno")+  " ," +myrs.getString("coID"));
    				  }
    		    }catch(Exception exc) {
    		    	exc.printStackTrace();
    		    }
    	  }
    	  
    	 if(e.getSource()==bussch) {
    		 new BusTT();
    		
    	 }
    	 
    	 if(e.getSource()==res) {
    		 
    		 String section=(String)sec.getSelectedItem();
    		 String semester=(String)sem.getSelectedItem();
    		 String rno=(String)strno.getText();
    		  frame = new StudentHome(3);
    		 frame.id.setText(rno);
    		 frame.seme.setText(semester);
    		 frame.sect.setText(section);
    		 ArrayList<String> arr =new ArrayList<String>();
    		 
    		 try { 
		    	  myrs=mystmt.executeQuery("select * from courseenroll where rolno='"+rno+"';");
				  
				 while(myrs.next()) {
				                       String ts= myrs.getString("coID");
                                       ts=ts+section+semester;
                                       arr.add(ts);
				  }
		    }catch(Exception exc) {
		    	exc.printStackTrace();
		    }
    		 
    		// System.out.println(arr);
    		 
    		 int size=arr.size();int tsum=0;int i=0;
    		for(;i<size;i++) {
    			 String temp=arr.get(i);
    			// System.out.println(temp);
    			 try { 
   		    	  myrs=mystmt.executeQuery("select * from "+temp+" where roln='"+rno+"';");
   		    	//System.out.println("query cross");
   				 while(myrs.next()) {
   					 String ID=myrs.getString("roln");
					    String Sname=myrs.getString("nam");
					    String is1=myrs.getString("insem1");
					    String is2=myrs.getString("insem2");
					    String es=myrs.getString("endsem");
					    String st=temp.substring(0,5);
					    
					    int sum=Integer.parseInt(is1)+Integer.parseInt(is2)+Integer.parseInt(es);
					    String str= "      "+st+"                 "+is1+"                     "+is2+"                     "+es+"                        "+sum+"           "+grade(sum);
					  //  System.out.println(str);
   				                      frame.resar.append(str+"\n");
					   // System.out.println();
                          tsum+=sum;       				                      
   				                      frame.setVisible(true);
					    
   				  }
   		    }catch(Exception exc) {
   		    	exc.printStackTrace();
   		    }
    			 
    			 
    		}
    		  double per=(double)tsum/(i*10);
    		  String no=Double.toString(per);
    		  frame.spi.setText(no);
    		  
    	 }
    	 
    	 
    	 if(e.getSource()==tt) {
    		 String s=(String)sem.getSelectedItem();     //s=semester
   		  String c=(String)cors.getSelectedItem(); // c=course 
   		  
   		 String com=c+s;
   		    new timetableStu(com);
    	 }
    	 if(e.getSource()==back) {
    		 try {
	       			
    			 JDialog.setDefaultLookAndFeelDecorated(true);
    			    int response = JOptionPane.showConfirmDialog(null, "Do you want to Go back?", "Confirm",
    			        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    			    if (response == JOptionPane.NO_OPTION) {
    			    } else if (response == JOptionPane.YES_OPTION) {
    			    	// frame.setVisible(false);
    			    	frame.dispose();
    			  	// JOptionPane.showMessageDialog(f,"Successfully deleted");
    			    } else if (response == JOptionPane.CLOSED_OPTION) {
    					
    			         
    			    }
    			 }catch(Exception ex) {
    				 JOptionPane.showMessageDialog(f,"Error! ");
    			 }
    	 }

    	 if(e.getSource()==logout) {
    		// new front();
    		 try {
	       			
    			 JDialog.setDefaultLookAndFeelDecorated(true);
    			    int response = JOptionPane.showConfirmDialog(null, "Do you want to LogOut?", "Confirm",
    			        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    			    if (response == JOptionPane.NO_OPTION) {
    			    } else if (response == JOptionPane.YES_OPTION) {
    			    	f.dispose();
    			  	// JOptionPane.showMessageDialog(f,"Successfully deleted");
    			    } else if (response == JOptionPane.CLOSED_OPTION) {
    					
    			         
    			    }
    			 }catch(Exception ex) {
    				 JOptionPane.showMessageDialog(f,"Error! ");
    			 }
    	 }
     } 

     public char grade(int num){
    	   char c;
    	  if(num>=90)
    		  c='A';
    	  else if(num>=80)
    		  c='B';
    	  else if(num>=70)
    		  c='C';
    	  else if(num>=60)
    		  c='D';
    	  else if(num>=50)
    		  c='E';
    	  else if(num>=40)
    		  c='F';
    	  else if(num>=30)
    		  c='G';
    	  else if(num>=20)
    		  c='H';
    	  else if(num>=10)
    		  c='I';
    	  else 
    		  c='J';
    	 return c; 
    	  
     }
     
//	public static void main(String[] args) {
//		 new StudentHome("201851112","A","2");
//	}	
}
