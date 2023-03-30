
package university.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.*;

public class StudentLeaveDetails extends JFrame implements ActionListener{
	
	Choice crollno;
	JTable table;
	JButton search, print, cancel;
	
	StudentLeaveDetails() {
		
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel heading = new JLabel("Search By Roll Number");
		heading.setBounds(20,20,150,20);
		add(heading);
		
		crollno = new Choice();
		crollno.setBounds(180, 20, 150, 20);
		add(crollno);
		
		try {
			Conn c = new Conn();
			ResultSet res = c.stmt.executeQuery("select * from student");
			while(res.next()) {
				crollno.add(res.getString("rollno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		table = new JTable();
		
		try {
			Conn c = new Conn();
			ResultSet res = c.stmt.executeQuery("select * from studentleave");
			table.setModel(DbUtils.resultSetToTableModel(res));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 100, 900, 600);
		add(jsp);
		
		search= new JButton("Search");
		search.setBounds(20, 70, 80, 20);
		search.addActionListener(this);
		add(search);
		
		print= new JButton("Print");
		print.setBounds(120, 70, 80, 20);
		print.addActionListener(this);
		add(print);
		
		cancel= new JButton("cancel");
		cancel.setBounds(220, 70, 80, 20);
		cancel.addActionListener(this);
		add(cancel);
		
		setSize(900,700);
		setLocation(300, 10);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==search) {
			String query ="select * from studentleave where rollno= '"+crollno.getSelectedItem()+"'";
			try {
				Conn c = new Conn();
				ResultSet res = c.stmt.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(res));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==print) {
			try {
				table.print();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new StudentLeaveDetails();
	}
}
