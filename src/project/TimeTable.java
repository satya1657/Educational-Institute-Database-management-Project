package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;

public class TimeTable implements ActionListener {

	static JFrame f;
	static DefaultTableModel model;
	static  JComboBox br,sec,day,fs,ss,al;
	static JButton Add,del;
	
	
	static Connection myconn;
	static Statement mystmt;
	static ResultSet myrs;	
	static  PreparedStatement pstmt;
    static String cls;
    private JButton vt;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton back;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	TimeTable(String st){
		    cls=st;
		try {
 		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
 		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
 		     
 	  }catch(Exception ex) {
 		  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");
 	  }
		
		String s="kapil";
		
		f=new JFrame("Time Table");
		f.getContentPane().setBackground(new Color(204, 255, 204));
		 f.setSize(930,500);
		 
		 JLabel lblTimeTable = new JLabel("Time Table");
		 lblTimeTable.setVerticalAlignment(SwingConstants.TOP);
		 lblTimeTable.setHorizontalAlignment(SwingConstants.CENTER);
		 lblTimeTable.setFont(new Font("Verdana", Font.BOLD, 18));
		 
		 JPanel regpanel = new JPanel();
		 regpanel.setBackground(new Color(255, 255, 204));
		 regpanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		 
		 Add = new JButton("ADD");
		 Add.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 Add.addActionListener(this);
		 
		 JLabel lblNewLabel_1 = new JLabel("Branch");
		 lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 
		 JLabel lblNewLabel_1_1 = new JLabel("Section");
		 lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 
		 JLabel lblNewLabel_1_2 = new JLabel("Day");
		 lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 
		 JLabel lblNewLabel_1_3 = new JLabel("9:00(AM) -10:30(AM)");
		 lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 
		 JLabel lblNewLabel_1_3_1 = new JLabel("10:45(AM) -12:15(PM)");
		 lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 
		 JLabel lblNewLabel_1_3_2 = new JLabel("1:30(PM)- 4:30(PM)");
		 lblNewLabel_1_3_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 
		  br = new JComboBox();
		 br.setModel(new DefaultComboBoxModel(new String[] {"CSE", "IT"}));
		 
		  sec = new JComboBox();
		 sec.setModel(new DefaultComboBoxModel(new String[] {"A", "B"}));
		 
		  day = new JComboBox();
		 day.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"}));
		 
		  fs = new JComboBox();
		 fs.setModel(new DefaultComboBoxModel(new String[] {"CS202", "CS204", "CS206", "CS208", "MA202", "HS202", "IT202"}));
		 
		  ss = new JComboBox();
		 ss.setModel(new DefaultComboBoxModel(new String[] {"CS202", "CS204", "CS206", "CS208", "MA202", "HS202", "IT202"}));
		 
		  al = new JComboBox();
		 al.setModel(new DefaultComboBoxModel(new String[] {"CS202", "CS204", "CS206", "CS208", "MA202", "HS202", "IT202"}));
		 GroupLayout gl_regpanel = new GroupLayout(regpanel);
		 gl_regpanel.setHorizontalGroup(
		 	gl_regpanel.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_regpanel.createSequentialGroup()
		 			.addGap(26)
		 			.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING, false)
		 				.addComponent(lblNewLabel_1_1)
		 				.addComponent(lblNewLabel_1)
		 				.addComponent(lblNewLabel_1_2)
		 				.addComponent(lblNewLabel_1_3)
		 				.addComponent(lblNewLabel_1_3_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		 				.addComponent(lblNewLabel_1_3_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		 			.addGap(18)
		 			.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING)
		 				.addComponent(al, 0, 76, Short.MAX_VALUE)
		 				.addComponent(ss, 0, 76, Short.MAX_VALUE)
		 				.addGroup(Alignment.TRAILING, gl_regpanel.createParallelGroup(Alignment.LEADING, false)
		 					.addComponent(br, 0, 76, Short.MAX_VALUE)
		 					.addComponent(sec, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		 					.addComponent(day, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		 					.addComponent(fs, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		 			.addGap(48))
		 		.addGroup(gl_regpanel.createSequentialGroup()
		 			.addGap(110)
		 			.addComponent(Add, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
		 			.addContainerGap(111, Short.MAX_VALUE))
		 );
		 gl_regpanel.setVerticalGroup(
		 	gl_regpanel.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_regpanel.createSequentialGroup()
		 			.addGap(32)
		 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(br, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		 			.addPreferredGap(ComponentPlacement.UNRELATED)
		 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(sec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		 			.addPreferredGap(ComponentPlacement.UNRELATED)
		 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(day, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		 			.addPreferredGap(ComponentPlacement.UNRELATED)
		 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(fs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		 			.addPreferredGap(ComponentPlacement.UNRELATED)
		 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(ss, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		 			.addPreferredGap(ComponentPlacement.UNRELATED)
		 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(lblNewLabel_1_3_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(al, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		 			.addGap(53)
		 			.addComponent(Add)
		 			.addContainerGap(63, Short.MAX_VALUE))
		 );
		 regpanel.setLayout(gl_regpanel);
		 
		 JPanel tablepanel = new JPanel();
		 tablepanel.setBackground(new Color(255, 255, 204));
		 tablepanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		 
		 
		 model = new DefaultTableModel();
		 
		 scrollPane = new JScrollPane();
		 
		 GroupLayout gl_tablepanel = new GroupLayout(tablepanel);
		 gl_tablepanel.setHorizontalGroup(
		 	gl_tablepanel.createParallelGroup(Alignment.LEADING)
		 		.addGroup(Alignment.TRAILING, gl_tablepanel.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
		 			.addContainerGap())
		 );
		 gl_tablepanel.setVerticalGroup(
		 	gl_tablepanel.createParallelGroup(Alignment.LEADING)
		 		.addGroup(Alignment.TRAILING, gl_tablepanel.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
		 			.addContainerGap())
		 );
		 
		 table = new JTable();
		 table.setBackground(new Color(240, 248, 255));
		  model=new DefaultTableModel(
		 	new Object[][] {
		 		{null, null, null, null, null, null},
		 	},
		 	new String[] {
		 		"Branch", "Section", "Day", "9-10:30(AM)", "11:45-12:15(PM)", "Lab(1:00-4:30 PM)"
		 	}
		 );
		  table.setModel(model);
		 table.getColumnModel().getColumn(4).setPreferredWidth(97);
		 scrollPane.setViewportView(table);
		 tablepanel.setLayout(gl_tablepanel);
		 
		  del = new JButton("Delete");
		 del.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 del.addActionListener(this);
		 
		 vt = new JButton("View Table");
		 vt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 vt.addActionListener(this);
		 
		 back = new JButton("Back");
		 back.addActionListener(this);
		 GroupLayout groupLayout = new GroupLayout(f.getContentPane());
		 groupLayout.setHorizontalGroup(
		 	groupLayout.createParallelGroup(Alignment.TRAILING)
		 		.addGroup(groupLayout.createSequentialGroup()
		 			.addContainerGap(342, Short.MAX_VALUE)
		 			.addComponent(lblTimeTable, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
		 			.addGap(321))
		 		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
		 			.addGap(27)
		 			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		 				.addComponent(back)
		 				.addGroup(groupLayout.createSequentialGroup()
		 					.addComponent(regpanel, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
		 					.addPreferredGap(ComponentPlacement.RELATED)
		 					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		 						.addComponent(tablepanel, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE)
		 						.addGroup(groupLayout.createSequentialGroup()
		 							.addGap(109)
		 							.addComponent(del, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
		 							.addGap(131)
		 							.addComponent(vt, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))))
		 			.addContainerGap(23, Short.MAX_VALUE))
		 );
		 groupLayout.setVerticalGroup(
		 	groupLayout.createParallelGroup(Alignment.LEADING)
		 		.addGroup(groupLayout.createSequentialGroup()
		 			.addContainerGap()
		 			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
		 				.addGroup(groupLayout.createSequentialGroup()
		 					.addComponent(lblTimeTable, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
		 					.addGap(29))
		 				.addGroup(groupLayout.createSequentialGroup()
		 					.addComponent(back)
		 					.addPreferredGap(ComponentPlacement.RELATED)))
		 			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
		 				.addComponent(regpanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
		 				.addComponent(tablepanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
		 			.addPreferredGap(ComponentPlacement.UNRELATED)
		 			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(del, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(vt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
		 			.addContainerGap(24, Short.MAX_VALUE))
		 );
		 f.getContentPane().setLayout(groupLayout);
		    f.setVisible(true); 
	}
	
	
	public static void viewTable() {
    	model.setRowCount(0);
		try {   
				
			   myrs=mystmt.executeQuery("select * from "+cls+" ;");
			   while(myrs.next()) {
				    String brnch=myrs.getString("branch");
				    String sec=myrs.getString("section");
				    String day=myrs.getString("days");
				    String fs=myrs.getString("fstsft");
				    String ss=myrs.getString("sndsft");
				    String al=myrs.getString("aftrlnch1");
					model.addRow(new Object[]{brnch, sec, day, fs, ss, al });				
			   }
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
		}
    }
	
	public void actionPerformed(ActionEvent e){ 
		
		if(e.getSource()==Add) {
			
			String b=(String)br.getSelectedItem();
			String s=(String)sec.getSelectedItem();
			String d=(String)day.getSelectedItem();
			String f=(String)fs.getSelectedItem();
			String snd=(String)ss.getSelectedItem();
			String afl=(String)al.getSelectedItem();
			
			
		try {
			 //mystmt=myconn.createStatement();
			 myconn.setAutoCommit(false);
			
		     pstmt=myconn.prepareStatement("insert into "+cls+" values(?,?,?,?,?,?)");
			 pstmt.setString(1, b);
			 pstmt.setString(2, s);
			 pstmt.setString(3, d);
			 pstmt.setString(4, f);
			 pstmt.setString(5, snd);
			 pstmt.setString(6, afl);
			 
			 pstmt.executeUpdate();
			 myconn.commit();
			 JOptionPane.showMessageDialog(null,"Added Successfully");
	
		
			 
			 viewTable();
			 
		}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"There is some Error to write data into Database");
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
			// System.out.println(colind);
			 // System.out.println(str);
			 String str =(String)table.getValueAt(rowind, 0);
			 String str1 =(String)table.getValueAt(rowind, 1);
			 String str2 =(String)table.getValueAt(rowind, 2);
			 if(str.isEmpty())
				 JOptionPane.showMessageDialog(f,"Select Any element of row which you want to delete");
			 String sql="delete from "+cls+" where branch='"+str+"'and section='"+str1+"' and days='"+str2+"';";
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
		
		
		if(e.getSource()==vt) {
			 viewTable();
		}
		
		
		
	}
	
//	public static void main(String[] args) {
//		
//        new TimeTable("BTech2");
//	}
}
