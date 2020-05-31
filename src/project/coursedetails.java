package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class coursedetails implements ActionListener {
	
	static JFrame f;
	private JTextField cnm;
	private JTextField cno;
	static DefaultTableModel model;
	JComboBox cid,cre;
	 private JButton Add,update,edit,del,search,btnViewTable;
	
	static Connection myconn;
	static Statement mystmt;
	static ResultSet myrs;	
	static  PreparedStatement pstmt;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton back;
	
	coursedetails(){
		
		   try {
	  		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
	  		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	  		    
	  	  }catch(Exception ex) {
	  		  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");
	  	  }
		
		 f=new JFrame("Course Details");
		 f.getContentPane().setBackground(new Color(153, 153, 255));
		    f.setSize(902,512);
		    
		    JLabel lblFacultydetails = new JLabel("Course Details");
		    lblFacultydetails.setVerticalAlignment(SwingConstants.TOP);
		    lblFacultydetails.setHorizontalAlignment(SwingConstants.CENTER);
		    lblFacultydetails.setFont(new Font("Verdana", Font.BOLD, 18));
		    
		    JPanel regpanel = new JPanel();
		    regpanel.setBackground(new Color(255, 255, 153));
		    regpanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		    
		    JLabel lblNewLabel_1_2 = new JLabel("Credits");
		    lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		    
		    JLabel lblNewLabel_1_1 = new JLabel("Course Name");
		    lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		    
		    cnm = new JTextField();
		    cnm.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		    cnm.setColumns(10);
		    
		    JLabel lblNewLabel_1 = new JLabel("Course ID");
		    lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		    
		     update = new JButton("UPDATE");
		    update.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		    update.addActionListener(this);
		    
		    Add = new JButton("ADD");
		    Add.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		    Add.addActionListener(this);
		    
		    cre = new JComboBox();
		    cre.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		    
		     cid = new JComboBox();
		    cid.setModel(new DefaultComboBoxModel(new String[] {"MA114", "PH120", "EE110", "CS112", "HS112", "CS204", "HS202", "CS206", "CS208", "MA202", "CS202", "IT202", "IT306", "IT309", "IT307", "IT310", "CS306", "CS308", "CS309", "CS310", "PC401"}));
		    GroupLayout gl_regpanel = new GroupLayout(regpanel);
		    gl_regpanel.setHorizontalGroup(
		    	gl_regpanel.createParallelGroup(Alignment.LEADING)
		    		.addGroup(gl_regpanel.createSequentialGroup()
		    			.addContainerGap()
		    			.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING)
		    				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
		    			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		    			.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING)
		    				.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING, false)
		    					.addComponent(cre, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		    					.addComponent(cnm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		    				.addComponent(cid, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
		    			.addGap(49))
		    		.addGroup(gl_regpanel.createSequentialGroup()
		    			.addGap(20)
		    			.addComponent(update, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
		    			.addGap(18)
		    			.addComponent(Add, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
		    			.addGap(35))
		    );
		    gl_regpanel.setVerticalGroup(
		    	gl_regpanel.createParallelGroup(Alignment.LEADING)
		    		.addGroup(gl_regpanel.createSequentialGroup()
		    			.addGap(37)
		    			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		    				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(cid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		    			.addGap(18)
		    			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		    				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(cnm, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
		    			.addGap(18)
		    			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		    				.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(cre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		    			.addGap(82)
		    			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		    				.addComponent(update, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(Add))
		    			.addContainerGap(28, Short.MAX_VALUE))
		    );
		    regpanel.setLayout(gl_regpanel);
		    
		    JLabel lblNewLabel = new JLabel("For Edit OR Delete please Select from Table\r\n");
		    lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		    
		    JPanel tablepanel = new JPanel();
		    tablepanel.setBackground(new Color(255, 255, 153));
		    tablepanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		    
		    
		    model = new DefaultTableModel();
			 
		    
		    scrollPane = new JScrollPane();

		    
//		    table = new JTable();
//		    table.setSurrendersFocusOnKeystroke(true);
//		    table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
//		    table.setFillsViewportHeight(true);
//		    table.setColumnSelectionAllowed(true);
//		    table.setCellSelectionEnabled(true);
//		    table.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
//		    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		    GroupLayout gl_tablepanel = new GroupLayout(tablepanel);
		    gl_tablepanel.setHorizontalGroup(
		    	gl_tablepanel.createParallelGroup(Alignment.LEADING)
		    		.addGroup(Alignment.TRAILING, gl_tablepanel.createSequentialGroup()
		    			.addContainerGap()
		    			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
		    			.addContainerGap())
		    );
		    gl_tablepanel.setVerticalGroup(
		    	gl_tablepanel.createParallelGroup(Alignment.LEADING)
		    		.addGroup(Alignment.TRAILING, gl_tablepanel.createSequentialGroup()
		    			.addContainerGap()
		    			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
		    			.addContainerGap())
		    );
		    
		    table = new JTable();
		    table.setBackground(new Color(255, 204, 204));
		    table.setColumnSelectionAllowed(true);
			table.setCellSelectionEnabled(true);
		    model=new DefaultTableModel(
		    	new Object[][] {
		    		{null, null, null},
		    	},
		    	new String[] {
		    		"Course ID", "Course Name", "Credits"
		    	}
		    );
		    table.setModel(model);
		    scrollPane.setViewportView(table);
		    tablepanel.setLayout(gl_tablepanel);
		    
		    JLabel lblNewLabel_2 = new JLabel("Course ID");
		    
		    cno = new JTextField();
		    cno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		    cno.setColumns(10);
		    
		    search = new JButton("Search");
		    search.setFont(new Font("Tahoma", Font.PLAIN, 12));
		    search.addActionListener(this);
		    
		    edit = new JButton("EDIT");
		    edit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		    edit.addActionListener(this);
		    
		     del = new JButton("DELETE");
		    del.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		    del.addActionListener(this);
		    
		    btnViewTable = new JButton("VIEW FULL TABLE");
		    btnViewTable.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		    btnViewTable.addActionListener(this);
		    
		    back = new JButton("Back");
		    back.addActionListener(this);
		    GroupLayout groupLayout = new GroupLayout(f.getContentPane());
		    groupLayout.setHorizontalGroup(
		    	groupLayout.createParallelGroup(Alignment.LEADING)
		    		.addGroup(groupLayout.createSequentialGroup()
		    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		    				.addGroup(groupLayout.createSequentialGroup()
		    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		    						.addGroup(groupLayout.createSequentialGroup()
		    							.addGap(20)
		    							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
		    						.addGroup(groupLayout.createSequentialGroup()
		    							.addContainerGap()
		    							.addComponent(regpanel, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
		    						.addGroup(groupLayout.createSequentialGroup()
		    							.addContainerGap()
		    							.addComponent(back)))
		    					.addGap(22)
		    					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
		    						.addGroup(groupLayout.createSequentialGroup()
		    							.addGap(213)
		    							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
		    							.addPreferredGap(ComponentPlacement.RELATED)
		    							.addComponent(cno, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
		    							.addPreferredGap(ComponentPlacement.RELATED)
		    							.addComponent(search, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
		    						.addGroup(groupLayout.createSequentialGroup()
		    							.addComponent(edit, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
		    							.addGap(18)
		    							.addComponent(del, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
		    							.addGap(18)
		    							.addComponent(btnViewTable, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
		    						.addGroup(groupLayout.createSequentialGroup()
		    							.addPreferredGap(ComponentPlacement.RELATED)
		    							.addComponent(tablepanel, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))))
		    				.addGroup(groupLayout.createSequentialGroup()
		    					.addGap(302)
		    					.addComponent(lblFacultydetails, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)))
		    			.addContainerGap())
		    );
		    groupLayout.setVerticalGroup(
		    	groupLayout.createParallelGroup(Alignment.TRAILING)
		    		.addGroup(groupLayout.createSequentialGroup()
		    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		    				.addGroup(groupLayout.createSequentialGroup()
		    					.addGap(44)
		    					.addComponent(back)
		    					.addPreferredGap(ComponentPlacement.RELATED)
		    					.addComponent(regpanel, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
		    				.addGroup(groupLayout.createSequentialGroup()
		    					.addContainerGap()
		    					.addComponent(lblFacultydetails, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
		    					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
		    					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		    						.addComponent(lblNewLabel_2)
		    						.addComponent(cno, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
		    						.addComponent(search, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		    					.addPreferredGap(ComponentPlacement.RELATED)
		    					.addComponent(tablepanel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)))
		    			.addPreferredGap(ComponentPlacement.UNRELATED)
		    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		    				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(btnViewTable, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(del, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(edit, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
		    			.addContainerGap())
		    );
		    f.getContentPane().setLayout(groupLayout);
		    f.setVisible(true);  
		    viewTable();
	}

	 public static void viewTable() {
	    model.setRowCount(0);
			try {   
					
				   myrs=mystmt.executeQuery("select * from course;");
				   while(myrs.next()) {
					    String ID=myrs.getString("cID");
					    String cnm=myrs.getString("cname");
					    String c=myrs.getString("cred");
					    
						model.addRow(new Object[]{ID, cnm, c});				
				   }
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
			}
	    }
	
	public void actionPerformed(ActionEvent e){ 
		
		if(e.getSource()==Add) {
			 
			String ID=(String)cid.getSelectedItem();
			String cname=(String)cnm.getText();
			String c=(String)cre.getSelectedItem();
		try {
			 myconn.setAutoCommit(false);
			
		     pstmt=myconn.prepareStatement("insert into course values(?,?,?)");
			 pstmt.setString(1, ID);
			 pstmt.setString(2, cname);
			 pstmt.setString(3, c);
			 
			 
			 pstmt.executeUpdate();
			 myconn.commit();
			 JOptionPane.showMessageDialog(f,"Added Successfully");
	
			 cnm.setText("");
			 
			 viewTable();
		}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error to write data into Database");
			}
		}
		
		if(e.getSource()==back) {
			 try {
	       			
    			 JDialog.setDefaultLookAndFeelDecorated(true);
    			    int response = JOptionPane.showConfirmDialog(null, "Do you want to Go Back?", "Confirm",
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
		
		if(e.getSource()==del) {
			 
			 int rowind =table.getSelectedRow();
			 int colind=table.getSelectedColumn();
			 String str =(String)table.getValueAt(rowind, 0);
			 if(str.isEmpty())
				 JOptionPane.showMessageDialog(f,"Select Any element of row which you want to delete");
			 String sql="delete from course where cid='"+str+"';";
		try {
			
			 JDialog.setDefaultLookAndFeelDecorated(true);
			    int response = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Confirm",
			        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			    if (response == JOptionPane.NO_OPTION) {
			    } else if (response == JOptionPane.YES_OPTION) {
			    	 myconn.setAutoCommit(false);
					 mystmt.executeUpdate(sql);
					 myconn.commit();
					 JOptionPane.showMessageDialog(f,"Successfully deleted");
			    } else if (response == JOptionPane.CLOSED_OPTION) {
					
			         
			    }
			 viewTable();
			 }catch(Exception ex) {
				 JOptionPane.showMessageDialog(f,"Error! You have selected wrong column probably");
			 }
		
		
		}
	
		if(e.getSource()==edit) {
			 
			int rowno =table.getSelectedRow();
			
			String id=(String)table.getValueAt(rowno, 0);
			String nm=(String)table.getValueAt(rowno, 1);
			
			 cnm.setText(nm);
			
			 
			 String sql="delete from course where cid='"+id+"';";
		try {
			
			    	 myconn.setAutoCommit(false);
					 mystmt.executeUpdate(sql);
					 myconn.commit();
		}catch(Exception ex) {
			 JOptionPane.showMessageDialog(f,"Error!");
		 }
			 
		}
		
		if(e.getSource()==update) {
			 
			
			String ID=(String)cid.getSelectedItem();
			String cname=(String)cnm.getText();
			String c=(String)cre.getSelectedItem();
		try {
			 myconn.setAutoCommit(false);
			
		     pstmt=myconn.prepareStatement("insert into course values(?,?,?)");
			 pstmt.setString(1, ID);
			 pstmt.setString(2, cname);
			 pstmt.setString(3, c);
			 
			 
			 pstmt.executeUpdate();
			 myconn.commit();
			 JOptionPane.showMessageDialog(f,"updated Successfully");
	
			 cnm.setText("");
			 
			 viewTable();
		}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error to write data into Database");
			}
		}
		
if(e.getSource()==search) {
			         
			String st = (String)cno.getText();
			model.setRowCount(0);
			try {   
				System.out.println(st);
				String q="select * from course where cid = '"+st+"';";
				   myrs=mystmt.executeQuery(q);
				   System.out.println(q);
				   while(myrs.next()) {
					    String ID=myrs.getString("cID");
					    String cna=myrs.getString("cname");
					    String c=myrs.getString("cred ");
					    System.out.println(ID+"  "+cna+"  "+c);
						model.addRow(new Object[]{ID, cna, c });				
				   }
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
			}
			
		}
	
		if(e.getSource()==btnViewTable) {
	
				viewTable();
				}
		
	}

		
	
	

//	public static void main(String[] args) {
//		
//           new coursedetails();
//           
//           try {
//  		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
//  		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//  		     viewTable();
//  	  }catch(Exception ex) {
//  		  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");
//  	  }
//	}

	
}
