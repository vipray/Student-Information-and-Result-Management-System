import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

class FindStudent extends JFrame{

	JLabel addNuml,sssmidl,aadharl,namel,father_namel,mother_namel,contactl,genderl;
	JTextArea addNumtf,sssmidtf,aadhartf,nametf,father_nametf,mother_nametf,contacttf;
	JList genderlist;
	JButton findbtn;

	public FindStudent(){

		setSize(600,600);

		Container cp=getContentPane();
		cp.setBackground(Color.cyan);
		cp.setLayout(new FlowLayout());

		addNuml = new JLabel("Admission Number");
		cp.add(addNuml);

		addNumtf = new JTextArea(1,40);
		cp.add(addNumtf);

		sssmidl = new JLabel("SSSM-ID");
		cp.add(sssmidl);

		sssmidtf = new JTextArea(1,46);
		cp.add(sssmidtf);

		aadharl = new JLabel("Aadhar Number");
		cp.add(aadharl);

		aadhartf = new JTextArea(1,46);
		cp.add(aadhartf);

		namel = new JLabel("Name        ");
		cp.add(namel);

		nametf = new JTextArea(1,46);
		cp.add(nametf);

		father_namel = new JLabel("Father Name");
		cp.add(father_namel);

		father_nametf = new JTextArea(1,46);
		cp.add(father_nametf);

		mother_namel = new JLabel("Mother Name");
		cp.add(mother_namel);

		mother_nametf = new JTextArea(1,46);
		cp.add(mother_nametf);

		genderl = new JLabel("Gender");
		cp.add(genderl);

		String[] entries = {"Male","Female"};

		genderlist = new JList(entries);
		genderlist.setVisibleRowCount(3);
		JScrollPane jsp = new JScrollPane(genderlist);
		cp.add(genderlist);

		contactl = new JLabel("Contact");
		cp.add(contactl);

		contacttf = new JTextArea(1,46);
		cp.add(contacttf);

		ListenerFind o = new ListenerFind(this);

		findbtn = new JButton("Find");
		findbtn.addActionListener(o);
		cp.add(findbtn);


		setVisible(true);
	}


	public static void main(String args[]){
		new FindStudent();
	}

}

class ListenerFind extends DBConnection implements ActionListener{

	FindStudent as;

	ListenerFind(FindStudent as){
			this.as = as;
	}

	public void actionPerformed(ActionEvent e1){

		if( e1.getSource() == as.findbtn ){
			
			String a=as.addNumtf.getText(),b=as.sssmidtf.getText(),c=as.aadhartf.getText(),d=as.nametf.getText(),e=as.father_nametf.getText(),f=as.mother_nametf.getText(),g=as.contacttf.getText();
			String q= "SELECT * FROM student";// WHERE addmission_num='"+a+"' OR sssmid='"+b+"' OR aadhar='"+c+"' OR name='"+d+"' OR father_name='"+e+"' OR mother_name='"+f+"' OR contact='"+g+"'";
			System.out.print(q);
			//String id = "";
			//ResultSet rs;
			try {
				rs=s.executeQuery(q);
				System.out.println("DATA: \n");
				
				new Result(rs);
				
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}

	}


}