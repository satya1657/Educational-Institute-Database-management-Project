package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class HostelManagement implements ActionListener {

	static JFrame f;
	private JTextField id;
	private JTextField room;
    private JButton Add,edit,del,search;
    
    static DefaultTableModel model;
    
    static Connection myconn;
	static Statement mystmt;
	static ResultSet myrs;	
	static  PreparedStatement pstmt;
	private JTextField rlno;
	private JButton btnViewTable;
	private JButton update;
    private JComboBox Bno,fee,mode;
    private JScrollPane scrollPane;
    private JTable STable;
    private JTextField tid;
    private JButton lgout;
    
    HostelManagement(){
    	 try {
		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		   
	  }catch(Exception ex) {
		  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");
	  }
    	f= new JFrame("Hostel Allotement"); 
    	f.getContentPane().setBackground(new Color(51, 204, 204));
    	 f.setSize(930,510);
    	 
    	 JLabel topic = new JLabel("Hostel Management");
    	 topic.setVerticalAlignment(SwingConstants.TOP);
    	 topic.setHorizontalAlignment(SwingConstants.CENTER);
    	 topic.setFont(new Font("Verdana", Font.BOLD, 18));
    	 
    	 JPanel regpanel = new JPanel();
    	 regpanel.setBackground(new Color(204, 255, 204));
    	 regpanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    	 
    	 JLabel lblNewLabel_1 = new JLabel("Roll No.");
    	 lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 
    	 id = new JTextField();
    	 id.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    	 id.setColumns(10);
    	 
    	 JLabel lblNewLabel_1_1 = new JLabel("Room No");
    	 lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 
    	 JLabel lblNewLabel_1_3 = new JLabel("Fees");
    	 lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 
    	 room = new JTextField();
    	 room.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    	 room.setColumns(10);
    	 
    	 Add = new JButton("ADD");
    	 Add.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 Add.addActionListener(this);
    	 
    	 update = new JButton("UPDATE");
    	 update.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 update.addActionListener(this);
    	 
    	 fee = new JComboBox();
    	 fee.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    	 fee.setModel(new DefaultComboBoxModel(new String[] {"Paid", "Not Paid"}));
    	 
    	 JLabel lblNewLabel_1_2 = new JLabel("Block No");
    	 lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 
    	 Bno = new JComboBox();
    	 Bno.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    	 Bno.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
    	 
    	 JLabel lblNewLabel_1_3_1 = new JLabel("Mode ");
    	 lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 
    	 mode = new JComboBox();
    	 mode.setModel(new DefaultComboBoxModel(new String[] {"Check", "NEFT", "Others"}));
    	 mode.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    	 
    	 JLabel lblNewLabel_1_3_1_1 = new JLabel("TransactionID");
    	 lblNewLabel_1_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 
    	 tid = new JTextField();
    	 tid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    	 tid.setColumns(10);
    	 GroupLayout gl_regpanel = new GroupLayout(regpanel);
    	 gl_regpanel.setHorizontalGroup(
    	 	gl_regpanel.createParallelGroup(Alignment.LEADING)
    	 		.addGroup(gl_regpanel.createSequentialGroup()
    	 			.addContainerGap()
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.TRAILING)
    	 				.addGroup(gl_regpanel.createSequentialGroup()
    	 					.addComponent(update, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
    	 					.addGap(18)
    	 					.addComponent(Add, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
    	 					.addGap(35))
    	 				.addGroup(gl_regpanel.createSequentialGroup()
    	 					.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING)
    	 						.addGroup(gl_regpanel.createSequentialGroup()
    	 							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
    	 							.addPreferredGap(ComponentPlacement.RELATED)
    	 							.addComponent(room, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
    	 						.addGroup(gl_regpanel.createSequentialGroup()
    	 							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
    	 							.addPreferredGap(ComponentPlacement.RELATED)
    	 							.addComponent(fee, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
    	 						.addGroup(gl_regpanel.createSequentialGroup()
    	 							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
    	 							.addPreferredGap(ComponentPlacement.RELATED)
    	 							.addComponent(id, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
    	 						.addGroup(gl_regpanel.createSequentialGroup()
    	 							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
    	 							.addPreferredGap(ComponentPlacement.RELATED)
    	 							.addComponent(Bno, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
    	 					.addGap(45))
    	 				.addGroup(gl_regpanel.createSequentialGroup()
    	 					.addComponent(lblNewLabel_1_3_1, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
    	 					.addPreferredGap(ComponentPlacement.RELATED)
    	 					.addComponent(mode, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
    	 					.addGap(46))
    	 				.addGroup(gl_regpanel.createSequentialGroup()
    	 					.addComponent(lblNewLabel_1_3_1_1)
    	 					.addPreferredGap(ComponentPlacement.UNRELATED)
    	 					.addComponent(tid, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
    	 					.addGap(29))))
    	 );
    	 gl_regpanel.setVerticalGroup(
    	 	gl_regpanel.createParallelGroup(Alignment.LEADING)
    	 		.addGroup(gl_regpanel.createSequentialGroup()
    	 			.addGap(38)
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    	 			.addGap(15)
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(Bno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    	 			.addGap(18)
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(room, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
    	 			.addGap(18)
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(fee, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
    	 			.addGap(18)
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(mode, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
    	 			.addPreferredGap(ComponentPlacement.UNRELATED)
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(lblNewLabel_1_3_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(tid, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
    	 			.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(update, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(Add))
    	 			.addGap(19))
    	 );
    	 regpanel.setLayout(gl_regpanel);
    	 
    	 JPanel tablepanel = new JPanel();
    	 tablepanel.setBackground(new Color(204, 255, 204));
    	 tablepanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    	
    	 
    	
    	 
    	 scrollPane = new JScrollPane();
    	 
    	 GroupLayout gl_tablepanel = new GroupLayout(tablepanel);
    	 gl_tablepanel.setHorizontalGroup(
    	 	gl_tablepanel.createParallelGroup(Alignment.LEADING)
    	 		.addGroup(gl_tablepanel.createSequentialGroup()
    	 			.addContainerGap()
    	 			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
    	 			.addContainerGap())
    	 );
    	 gl_tablepanel.setVerticalGroup(
    	 	gl_tablepanel.createParallelGroup(Alignment.TRAILING)
    	 		.addGroup(gl_tablepanel.createSequentialGroup()
    	 			.addContainerGap(28, Short.MAX_VALUE)
    	 			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
    	 			.addGap(29))
    	 );
    	 
    	 STable = new JTable();
    	 STable.setBackground(new Color(255, 255, 204));
    	 STable.setColumnSelectionAllowed(true);
		 STable.setCellSelectionEnabled(true);
		 
    	 model=new DefaultTableModel(
    	 	new Object[][] {
    	 		{null, null, null, null, null, null},
    	 	},
    	 	new String[] {
    	 		"Roll No", "Block No", "Room No", "Fees", "Mode", "TransactionID"
    	 	}
    	 );
    	 STable.setModel(model);
    	 STable.getColumnModel().getColumn(5).setPreferredWidth(92);
    	
    	// STable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    	 scrollPane.setViewportView(STable);
    	 tablepanel.setLayout(gl_tablepanel);
    	 
    	 rlno = new JTextField();
    	 rlno.setFont(new Font("Tahoma", Font.PLAIN, 12));
    	 rlno.setColumns(10);
    	 
    	 search = new JButton("Search");
    	 search.setFont(new Font("Tahoma", Font.PLAIN, 12));
    	 search.addActionListener(this);
    	 
    	 JLabel lblNewLabel_2 = new JLabel("Roll No");
    	 
    	 btnViewTable = new JButton("VIEW FULL TABLE");
    	 btnViewTable.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 btnViewTable.addActionListener(this);
    	 
    	 edit = new JButton("EDIT");
    	 edit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 edit.addActionListener(this);
    	 
    	  del = new JButton("DELETE");
    	  del.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	  del.addActionListener(this);
    	 
    	 JLabel lblNewLabel = new JLabel("For Edit OR Delete please Select from Table\r\n");
    	 lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
    	 
    	 lgout = new JButton("LogOut");
    	 lgout.addActionListener(this);
    	 GroupLayout groupLayout = new GroupLayout(f.getContentPane());
    	 groupLayout.setHorizontalGroup(
    	 	groupLayout.createParallelGroup(Alignment.TRAILING)
    	 		.addGroup(groupLayout.createSequentialGroup()
    	 			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    	 				.addGroup(groupLayout.createSequentialGroup()
    	 					.addGap(349)
    	 					.addComponent(topic, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))
    	 				.addGroup(groupLayout.createSequentialGroup()
    	 					.addContainerGap()
    	 					.addComponent(regpanel, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
    	 					.addGap(18)
    	 					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    	 						.addComponent(lblNewLabel)
    	 						.addComponent(tablepanel, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))))
    	 			.addContainerGap())
    	 		.addGroup(groupLayout.createSequentialGroup()
    	 			.addContainerGap()
    	 			.addComponent(lgout)
    	 			.addPreferredGap(ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
    	 			.addComponent(lblNewLabel_2)
    	 			.addPreferredGap(ComponentPlacement.RELATED)
    	 			.addComponent(rlno, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
    	 			.addPreferredGap(ComponentPlacement.RELATED)
    	 			.addComponent(search)
    	 			.addGap(53))
    	 		.addGroup(groupLayout.createSequentialGroup()
    	 			.addContainerGap(502, Short.MAX_VALUE)
    	 			.addComponent(edit, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
    	 			.addGap(18)
    	 			.addComponent(del)
    	 			.addGap(18)
    	 			.addComponent(btnViewTable)
    	 			.addGap(47))
    	 );
    	 groupLayout.setVerticalGroup(
    	 	groupLayout.createParallelGroup(Alignment.LEADING)
    	 		.addGroup(groupLayout.createSequentialGroup()
    	 			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    	 				.addGroup(groupLayout.createSequentialGroup()
    	 					.addGap(31)
    	 					.addComponent(lgout)
    	 					.addPreferredGap(ComponentPlacement.UNRELATED)
    	 					.addComponent(regpanel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE))
    	 				.addGroup(groupLayout.createSequentialGroup()
    	 					.addGap(4)
    	 					.addComponent(topic, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
    	 					.addGap(9)
    	 					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
    	 						.addComponent(search, 0, 0, Short.MAX_VALUE)
    	 						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
    	 							.addComponent(rlno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    	 							.addComponent(lblNewLabel_2)))
    	 					.addGap(8)
    	 					.addComponent(tablepanel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)))
    	 			.addPreferredGap(ComponentPlacement.UNRELATED)
    	 			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(btnViewTable, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(del)
    	 				.addComponent(edit)
    	 				.addComponent(lblNewLabel))
    	 			.addContainerGap(14, Short.MAX_VALUE))
    	 );
    	 f.getContentPane().setLayout(groupLayout);
 	    f.setVisible(true); 
 	   viewTable();
    }
	
    public static void viewTable() {
    	model.setRowCount(0);
		try {   
				
			   myrs=mystmt.executeQuery("select * from hostel;");
			   while(myrs.next()) {
				    String ID=myrs.getString("rolno");
				    String blck=myrs.getString("Bno");
				    String room=myrs.getString("rno");
				    String f=myrs.getString("fee");
				    String m=myrs.getString("md");
				    String tr=myrs.getString("Tid");
					model.addRow(new Object[]{ID, blck, room, f , m , tr  });				
			   }
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
		}
    }
    
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==Add) {
			 
			String ID=(String)id.getText();
			String blck=(String)Bno.getSelectedItem();
			String r=(String)room.getText();
			String f=(String)fee.getSelectedItem();
			String m=(String)mode.getSelectedItem();
			String t=(String)tid.getText();
		try {
			 //mystmt=myconn.createStatement();
			 myconn.setAutoCommit(false);
			
		     pstmt=myconn.prepareStatement("insert into hostel values(?,?,?,?,?,?)");
			 pstmt.setString(1, ID);
			 pstmt.setString(2, blck);
			 pstmt.setString(3, r);
			 pstmt.setString(4, f);
			 pstmt.setString(5, m);
			 pstmt.setString(6, t);
			 
			 pstmt.executeUpdate();
			 myconn.commit();
			 JOptionPane.showMessageDialog(null,"Added Successfully");
	
			id.setText("");
		    room.setText("");
		    tid.setText("");
			
			 viewTable();
		}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"There is some Error to write data into Database");
			}
		}
		
		if(e.getSource()==del) {
			 
			 int rowind =STable.getSelectedRow();
			 int colind=STable.getSelectedColumn();
			// System.out.println(colind);
			 // System.out.println(str);
			 String str =(String)STable.getValueAt(rowind, 0);
			 if(str.isEmpty())
				 JOptionPane.showMessageDialog(f,"Select Any element of row which you want to delete");
			 String sql="delete from hostel where rolno='"+str+"';";
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
		if(e.getSource()==lgout) {
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
		if(e.getSource()==edit) {
			 
			int rowno =STable.getSelectedRow();
			
			String rno=(String)STable.getValueAt(rowno, 0);
			String r=(String)STable.getValueAt(rowno, 2);
			String t=(String)STable.getValueAt(rowno, 5);
			
			 id.setText(rno);
			 room.setText(r);
			 tid.setText(t);
			
			 
			 String sql="delete from hostel where rolno='"+rno+"';";
		try {
			
			    	 myconn.setAutoCommit(false);
					 mystmt.executeUpdate(sql);
					 myconn.commit();
		}catch(Exception ex) {
			 JOptionPane.showMessageDialog(f,"Error!");
		 }
			 
		}
		
		if(e.getSource()==search) {
			
            
			String st = (String)rlno.getText();
			
			
			model.setRowCount(0);
			try {   
			
				   myrs=mystmt.executeQuery("select * from hostel where rolno="+st);
				   while(myrs.next()) {
					   String ID=myrs.getString("rolno");
					    String blck=myrs.getString("Bno");
					    String room=myrs.getString("rno");
					    String f=myrs.getString("fee");
					    String m=myrs.getString("md");
					    String tr=myrs.getString("Tid");
						model.addRow(new Object[]{ID, blck, room, f , m , tr  });				
				   }
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
			}
			
		}
		
		if(e.getSource()==update) {
			 
			String ID=(String)id.getText();
			String blck=(String)Bno.getSelectedItem();
			String r=(String)room.getText();
			String f=(String)fee.getSelectedItem();
			String m=(String)mode.getSelectedItem();
			String t=(String)tid.getText();
		try {
			 //mystmt=myconn.createStatement();
			 myconn.setAutoCommit(false);
			
		     pstmt=myconn.prepareStatement("insert into hostel values(?,?,?,?,?,?)");
			 pstmt.setString(1, ID);
			 pstmt.setString(2, blck);
			 pstmt.setString(3, r);
			 pstmt.setString(4, f);
			 pstmt.setString(5, m);
			 pstmt.setString(6, t);
			 
			 pstmt.executeUpdate();
			 myconn.commit();
			 JOptionPane.showMessageDialog(null,"Updated Successfully");
	
			id.setText("");
		    room.setText("");
		    tid.setText("");
			
			 viewTable();
		}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"There is some Error to write data into Database");
			}
		
		}	
		if(e.getSource()==btnViewTable) {
			
			 viewTable();
		}
		

		
	}
//	public static void main(String[] args) {
//		 new HostelManagement();
//			
//		  try {
//			     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
//			     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			     viewTable();
//		  }catch(Exception ex) {
//			  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");
//		  }
//
//		 
//	}
}
