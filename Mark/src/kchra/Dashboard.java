import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Dashboard extends JFrame{

	JButton addBtn,findBtn,promoteBtn,logoutBtn;

	public Dashboard(){
            

		setSize(600,600);

		Container cp = getContentPane();
		cp.setBackground(new Color(44,62,80));
		cp.setLayout(new FlowLayout());
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
                

		ListenerDashboard o2 = new ListenerDashboard(this);

		addBtn = new JButton("Add New Student");
		addBtn.addActionListener(o2);
		cp.add(addBtn);

		findBtn = new JButton("Find Student");
		findBtn.addActionListener(o2);
		cp.add(findBtn);

		promoteBtn = new JButton("Promote All Students");
		promoteBtn.addActionListener(o2);
		cp.add(promoteBtn);

		logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(o2);
		cp.add(logoutBtn);

		setVisible(true);
	}

}

class ListenerDashboard implements ActionListener{

	Dashboard db;

	ListenerDashboard(Dashboard db){
			this.db = db;
	}

	public void actionPerformed(ActionEvent e){

		if( e.getSource() == db.addBtn ){
			System.out.println("Add");
			new AddStudent();
			db.setVisible(false);
		}
		else if( e.getSource() == db.findBtn ){
			new FindStudent();
			db.setVisible(false);
			System.out.println("Find");
		}
		else if( e.getSource() == db.promoteBtn ){
			System.out.println("Promote All");
		}
		else if( e.getSource() == db.logoutBtn ){
			System.out.println("Logout");
		}

	}


}