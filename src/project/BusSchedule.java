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
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Color;

public class BusSchedule implements ActionListener {
	
	static JFrame f;
	static DefaultTableModel model;
	static  JComboBox day;
	static JButton Add,del;
	
	
	static Connection myconn;
	static Statement mystmt;
	static ResultSet myrs;	
	static  PreparedStatement pstmt;
    static String cls;
    private JButton vt;
    private JScrollPane scrollPane;
    private JTable table;
    private JTextField morn;
    private JTextField eve1;
    private JTextField eve2;
    private JButton lgout;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	BusSchedule(){
		 try {
		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		    
	  }catch(Exception ex) {
		  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");
	  }   
		f=new JFrame("Bus Time Table");
		f.getContentPane().setBackground(new Color(204, 204, 255));
		 f.setSize(930,500);
		 
		 JLabel lblTimeTable = new JLabel("Bus Time Table");
		 lblTimeTable.setVerticalAlignment(SwingConstants.TOP);
		 lblTimeTable.setHorizontalAlignment(SwingConstants.CENTER);
		 lblTimeTable.setFont(new Font("Verdana", Font.BOLD, 18));
		 
		 JPanel regpanel = new JPanel();
		 regpanel.setBackground(new Color(204, 255, 204));
		 regpanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		 
		 Add = new JButton("ADD");
		 Add.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 Add.addActionListener(this);
		 
		 JLabel lblNewLabel_1 = new JLabel("Day");
		 lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 
		 JLabel lblNewLabel_1_1 = new JLabel("Morning");
		 lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 
		 JLabel lblNewLabel_1_2 = new JLabel("Evening1");
		 lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 
		 JLabel lblNewLabel_1_3 = new JLabel("Evening2");
		 lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 
		  day = new JComboBox();
		 day.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}));
		 
		 morn = new JTextField();
		 morn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 morn.setColumns(10);
		 
		 eve1 = new JTextField();
		 eve1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 eve1.setColumns(10);
		 
		 eve2 = new JTextField();
		 eve2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 eve2.setColumns(10);
		 GroupLayout gl_regpanel = new GroupLayout(regpanel);
		 gl_regpanel.setHorizontalGroup(
		 	gl_regpanel.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_regpanel.createSequentialGroup()
		 			.addGap(26)
		 			.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING)
		 				.addComponent(lblNewLabel_1_1)
		 				.addComponent(lblNewLabel_1)
		 				.addComponent(lblNewLabel_1_2)
		 				.addComponent(lblNewLabel_1_3))
		 			.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
		 			.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING, false)
		 				.addComponent(day, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		 				.addComponent(eve1, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
		 				.addComponent(morn, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
		 				.addComponent(eve2, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
		 			.addGap(25))
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
		 				.addComponent(day, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		 			.addPreferredGap(ComponentPlacement.UNRELATED)
		 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(morn, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
		 			.addPreferredGap(ComponentPlacement.UNRELATED)
		 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(eve1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
		 			.addPreferredGap(ComponentPlacement.UNRELATED)
		 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(eve2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
		 			.addGap(67)
		 			.addComponent(Add)
		 			.addContainerGap(69, Short.MAX_VALUE))
		 );
		 regpanel.setLayout(gl_regpanel);
		 
		 JPanel tablepanel = new JPanel();
		 tablepanel.setBackground(new Color(204, 255, 204));
		 tablepanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		 
		 
		 model = new DefaultTableModel();
		 
		 scrollPane = new JScrollPane();
		 
		 GroupLayout gl_tablepanel = new GroupLayout(tablepanel);
		 gl_tablepanel.setHorizontalGroup(
		 	gl_tablepanel.createParallelGroup(Alignment.TRAILING)
		 		.addGroup(Alignment.LEADING, gl_tablepanel.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
		 			.addContainerGap())
		 );
		 gl_tablepanel.setVerticalGroup(
		 	gl_tablepanel.createParallelGroup(Alignment.TRAILING)
		 		.addGroup(Alignment.LEADING, gl_tablepanel.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
		 			.addContainerGap(129, Short.MAX_VALUE))
		 );
		 
		 table = new JTable();
		 table.setBackground(new Color(255, 255, 153));
			  model=new DefaultTableModel(
		  	new Object[][] {
		  		{null, null, null, null},
		  	},
		  	new String[] {
		  		"Day", "Morning", "Evening1", "Evening2"
		  	}
		  );
				  table.setModel(model);
		 scrollPane.setViewportView(table);
		 tablepanel.setLayout(gl_tablepanel);
		 
		  del = new JButton("Delete");
		 del.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 del.addActionListener(this);
		 
		 vt = new JButton("View Table");
		 vt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 vt.addActionListener(this);
		 
		 lgout = new JButton("Log Out");
		 lgout.addActionListener(this);
		 GroupLayout groupLayout = new GroupLayout(f.getContentPane());
		 groupLayout.setHorizontalGroup(
		 	groupLayout.createParallelGroup(Alignment.TRAILING)
		 		.addGroup(groupLayout.createSequentialGroup()
		 			.addContainerGap(342, Short.MAX_VALUE)
		 			.addComponent(lblTimeTable, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
		 			.addGap(321))
		 		.addGroup(groupLayout.createSequentialGroup()
		 			.addGap(27)
		 			.addComponent(regpanel, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
		 			.addPreferredGap(ComponentPlacement.RELATED)
		 			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		 				.addGroup(groupLayout.createSequentialGroup()
		 					.addGap(109)
		 					.addComponent(del, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
		 					.addGap(131)
		 					.addComponent(vt, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
		 				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
		 					.addComponent(lgout)
		 					.addComponent(tablepanel, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE)))
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
		 					.addComponent(lgout)
		 					.addGap(18)))
		 			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		 				.addComponent(regpanel, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
		 				.addGroup(groupLayout.createSequentialGroup()
		 					.addComponent(tablepanel, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
		 					.addPreferredGap(ComponentPlacement.UNRELATED)
		 					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		 						.addComponent(del, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		 						.addComponent(vt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
		 			.addContainerGap(24, Short.MAX_VALUE))
		 );
		 f.getContentPane().setLayout(groupLayout);
		    f.setVisible(true);
		    viewTable();
	}

	public static void viewTable() {
    	model.setRowCount(0);
		try {   
				
			   myrs=mystmt.executeQuery("select * from bus ;");
			   while(myrs.next()) {
				    String day=myrs.getString("days");
				    String m=myrs.getString("morn");
				    String e1=myrs.getString("even1");
				    String e2=myrs.getString("even2");
					model.addRow(new Object[]{day, m, e1, e2 });				
			   }
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
		}
    }
	

	
	public void actionPerformed(ActionEvent e){
		
if(e.getSource()==Add) {
			
			String b=(String)day.getSelectedItem();
			String m=(String)morn.getText();
			String e1=(String)eve1.getText();
			String e2=(String)eve2.getText();
			
		try {
			 myconn.setAutoCommit(false);
			
		     pstmt=myconn.prepareStatement("insert into bus values(?,?,?,?)");
			 pstmt.setString(1, b);
			 pstmt.setString(2, m);
			 pstmt.setString(3, e1);
			 pstmt.setString(4, e2);
			 
			 pstmt.executeUpdate();
			 myconn.commit();
			 JOptionPane.showMessageDialog(null,"Added Successfully");
	
		
			 
			 viewTable();
			 
		}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"There is some Error to write data into Database");
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

		if(e.getSource()==del) {
			 
			 int rowind =table.getSelectedRow();
			 int colind=table.getSelectedColumn();
			 String str =(String)table.getValueAt(rowind, 0);
			 if(str.isEmpty())
				 JOptionPane.showMessageDialog(f,"Select Any element of row which you want to delete");
			 String sql="delete from bus where days='"+str+"';";
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
//        new BusSchedule();
//        try {
//		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
//		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//		     viewTable();
//	  }catch(Exception ex) {
//		  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");
//	  }
//	}

}
