import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


public class ViewFull extends  DBConnection  {
	
	
	
	
	
	
	
	JButton[] Viewbtn =new JButton[100];
	int count=0;
	ResultSet rsa;
	ResultSet rsa1;
	ResultSet rsa2;
	ResultSet rsa3;
	 JFrame j=new JFrame();
	ViewFull(String id){
	
		
		String q= "SELECT * FROM student WHERE id='"+id+"'";
		//System.out.print(q);
		//String id = "";
		//ResultSet rs;
		try {
			rsa=s.executeQuery(q);
			//System.out.println(rsa.getString("name"));
			
			
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel cp= new JPanel();
		//setting grid layout of 3 rows and 3 columns
		cp.setLayout(new FlowLayout());
		j.add(cp);
		UIManager.put("Label.font", UIManager.getFont("Label.font").deriveFont((float) 50.0));
		SwingUtilities.updateComponentTreeUI(j);
		//cp.add(s);
		
		/*Grid wala tareeka
		 * JPanel cp1=new JPanel();
		cp1.setLayout(new GridLayout(3,4));
		cp.add(cp1);
		*/
		//table
		DefaultTableModel model = new DefaultTableModel(); 
		JTable table = new JTable(model);
		//table.setBackground(Color.BLUE);
		
		
		table.setRowHeight(30);   
		table.getTableHeader().setDefaultRenderer(new SimpleHeaderRenderer());
		//table.setSize(100, 100);
		
		// Create a couple of columns 
		model.addColumn("Name"); 
		model.addColumn("SSSMID");
		model.addColumn("Aadhar"); 
		model.addColumn("Class");
		model.addColumn("Admission No."); 
		model.addColumn("Year");
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setWidth(2000);
		columnModel.getColumn(1).setWidth(100);
		columnModel.getColumn(2).setWidth(100);
		columnModel.getColumn(3).setWidth(100);
		columnModel.getColumn(4).setWidth(100);
		columnModel.getColumn(5).setWidth(100);
		
		//model.setRowCount(1);
	

		// Append a row
		try {
		if(rsa.next()){
		model.addRow(new Object[]{rsa.getString("name"), rsa.getString("sssmid"),rsa.getString("aadhar"),rsa.getString("class"),rsa.getString("addmission_num"),rsa.getString("year")});
		
		cp.add(new JScrollPane(table));
		/* Grid wala tareeka
		 * try {
			if(rsa.next()){
			cp1.add(new JLabel("Name"));
			cp1.add(new JLabel(rsa.getString("name")));
			
			cp1.add(new JLabel("SSSMID"));
			cp1.add(new JLabel(rsa.getString("sssmid")));
			
			cp1.add(new JLabel("Aadhar"));
			cp1.add(new JLabel(rsa.getString("aadhar")));
			
			cp1.add(new JLabel("Class"));
			cp1.add(new JLabel(rsa.getString("class")));
			
			cp1.add(new JLabel("Admission Number"));
			cp1.add(new JLabel(rsa.getString("addmission_num")));
			
			cp1.add(new JLabel("Year"));
			cp1.add(new JLabel(rsa.getString("year")));
			*/
			String adm = rsa.getString("addmission_num");
			String yr = rsa.getString("year");
			
			rsa.close();
			String q1= "SELECT * FROM first WHERE addmission_num='"+adm+"' AND year='"+yr+"'";
			String q2= "SELECT * FROM second WHERE addmission_num='"+adm+"' AND year='"+yr+"'";
			String q3= "SELECT * FROM final WHERE addmission_num='"+adm+"' AND year='"+yr+"'";
			
			
			DefaultTableModel model1 = new DefaultTableModel(); 
			JTable table1 = new JTable(model1);
			//table.setBackground(Color.BLUE);
			
			
			table1.setRowHeight(30);   
			table1.getTableHeader().setDefaultRenderer(new SimpleHeaderRenderer());
			
			model1.addColumn("Term"); 
			model1.addColumn("English"); 
			model1.addColumn("Hindi");
			model1.addColumn("Maths"); 
			model1.addColumn("Evs");
			model1.addColumn("GK"); 
			model1.addColumn("Computer");
			
			
			
				try {
					rsa1=s.executeQuery(q1);
					//System.out.println(rsa.getString("name"));
				/*	grid
				 * 
				 * JPanel cp2=new JPanel();
					cp2.setLayout(new GridLayout(3,4));
					cp.add(cp2);
					*/
					
					if(rsa1.next()){
						
						model1.addRow(new Object[]{"I",rsa1.getString("english"), rsa1.getString("hindi"),rsa1.getString("maths"),rsa1.getString("evs"),rsa1.getString("gk"),rsa1.getString("computer")});
						cp.add(new JScrollPane(table1));
						/* grid		
						cp2.add(new JLabel("english"));
						cp2.add(new JLabel(rsa1.getString("english")));
						
						cp2.add(new JLabel("hindi"));
						cp2.add(new JLabel(rsa1.getString("hindi")));
						
						cp2.add(new JLabel("maths"));
						cp2.add(new JLabel(rsa1.getString("maths")));
						
						cp2.add(new JLabel("evs"));
						cp2.add(new JLabel(rsa1.getString("evs")));
						
						cp2.add(new JLabel("gk"));
						cp2.add(new JLabel(rsa1.getString("gk")));
						
						cp2.add(new JLabel("computer"));
						cp2.add(new JLabel(rsa1.getString("computer")));
						*/
						//System.out.println(rsa1.getString("english"));
					}
					rsa1.close();
					rsa2=s.executeQuery(q2);
					
				/*	DefaultTableModel model12 = new DefaultTableModel(); 
					JTable table12 = new JTable(model12);
					//table.setBackground(Color.BLUE);
					
					
					table12.setRowHeight(30);   
					table12.getTableHeader().setDefaultRenderer(new SimpleHeaderRenderer());
					
					model12.addColumn("English"); 
					model12.addColumn("Hindi");
					model12.addColumn("Maths"); 
					model12.addColumn("Evs");
					model12.addColumn("GK"); 
					model12.addColumn("Computer");
					*/
					
					if(rsa2.next()){
						model1.addRow(new Object[]{"II",rsa2.getString("english"), rsa2.getString("hindi"),rsa2.getString("maths"),rsa2.getString("evs"),rsa2.getString("gk"),rsa2.getString("computer")});
						//cp.add(new JScrollPane(table12));
						
						System.out.println(rsa2.getString("english"));
					}
					rsa2.close();
					rsa3=s.executeQuery(q3);
					
					while(rsa3.next()){
						model1.addRow(new Object[]{"III",rsa3.getString("english"), rsa3.getString("hindi"),rsa3.getString("maths"),rsa3.getString("evs"),rsa3.getString("gk"),rsa3.getString("computer")});
						
						System.out.println(rsa3.getString("english"));
					}
					rsa3.close();
					
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			
			
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    j.setSize(1600,200);  
	  
	    //ListenerView o = new ListenerView(this);

	    /* JLabel b1=new JLabel("SSSMID");  
	    JLabel b2=new JLabel("NAME");  
	    JLabel b3=new JLabel("VIEW PROFILE");  
	    JLabel b4=new JLabel("4");  
	    JLabel b5=new JLabel("5");  
	        JLabel b6=new JLabel("6");  
	        JLabel b7=new JLabel("7");  
	    JLabel b8=new JLabel("8");  
	        JLabel b9=new JLabel("9");  
	      */    
	    /* b1.setFont(new Font("Courier", Font.BOLD,42));
	    b2.setFont(new Font("Courier", Font.BOLD,42));
	    b3.setFont(new Font("Courier", Font.BOLD,42));
	    cp.add(b1);cp.add(b2);cp.add(b3);
	    add(b4);add(b5);  
	    add(b6);add(b7);add(b8);add(b9);*/
	    
	    
	/*    try {
			int i=0;
			while(rs.next()){
					Viewbtn[i]=new JButton("View");
					
					Viewbtn[i].setActionCommand(rs.getString("id"));
					Viewbtn[i].addActionListener(o);
					 cp.add(new JLabel(rs.getString("sssmid")));
					 cp.add(new JLabel(rs.getString("name")));
					 cp.add(Viewbtn[i]);
					
			        //jt.getColumn("SALARY").setCellEditor(new ButtonEditor(new JCheckBox()));
	                //dtm.addRow(new Object[]{rs.getString("aadhar"),rs.getString("sssmid"),Viewbtn[i]});
	                i++;
			System.out.println(rs.getString("name"));
			}
			//addNumtf.setText(rs.getString("name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	    
	    
	    
	    
	    
	    
	    
	  
	      j.setVisible(true);  
	}  
	
}

class SimpleHeaderRenderer extends JLabel implements TableCellRenderer {
	 
    public SimpleHeaderRenderer() {
        setFont(new Font("Consolas", Font.BOLD, 24));
        setForeground(Color.black);
        setBorder(BorderFactory.createEtchedBorder());
        //setWidth(100);
    }
     
   
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
 
}