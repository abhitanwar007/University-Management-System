package university.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener{
	
	Choice cEmpId;
	JTable table;
	JButton search, print, cancel;
	
	TeacherLeaveDetails() {
		
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel heading = new JLabel("Search By Employee Id");
		heading.setBounds(20,20,150,20);
		add(heading);
		
		cEmpId = new Choice();
		cEmpId.setBounds(180, 20, 150, 20);
		add(cEmpId);
		
		try {
			Conn c = new Conn();
			ResultSet res = c.stmt.executeQuery("select * from teacher");
			while(res.next()) {
				cEmpId.add(res.getString("empid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		table = new JTable();
		
		try {
			Conn c = new Conn();
			ResultSet res = c.stmt.executeQuery("select * from teacherleave");
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
			String query ="select * from teacherleave where empid= '"+cEmpId.getSelectedItem()+"'";
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
		new TeacherLeaveDetails();
	}
}
