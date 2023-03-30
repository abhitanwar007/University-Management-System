package university.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class UpdateTeacher extends JFrame implements ActionListener{
	JTextField tfaddress,tfphone,tfemail,tfcourse,tfbranch ;
	JLabel labelempid;
	JButton submit, cancel;
	
	Choice cEmpId;
	
	
	UpdateTeacher() {
		
		setSize(900,600);
		setLocation(300,10);
		
		setLayout(null);
		
		JLabel heading = new JLabel("Update Teacher Details");
		heading.setBounds(50,10,500,50);
		heading.setFont(new Font("serif",Font.ITALIC,35));
		add(heading);
		
		JLabel lblrollno= new JLabel("Select Employee Id");
		lblrollno.setBounds(50,70,200,20);
		lblrollno.setFont(new Font("serif",Font.PLAIN,20));
		add(lblrollno);
		
		cEmpId = new Choice();
		cEmpId.setBounds(250, 70, 200, 20);
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
		
		JLabel name = new JLabel("Name");
		name.setBounds(50,100,200,30);
		name.setFont(new Font("serif",Font.BOLD,20));
		add(name);
		
		JLabel labelname = new JLabel();
		labelname.setBounds(200,100,150,30);
		labelname.setFont(new Font("serif",Font.PLAIN,18));
		add(labelname);
		
		JLabel fname = new JLabel("Father's Name");
		fname.setBounds(400,100,200,30);
		fname.setFont(new Font("serif",Font.BOLD,20));
		add(fname);
		
		JLabel labelfname = new JLabel();
		labelfname.setBounds(600,100,150,30);
		labelfname.setFont(new Font("serif",Font.PLAIN,18));
		add(labelfname);
		
		JLabel empid = new JLabel("Employee Id");
		empid.setBounds(50,150,200,30);
		empid.setFont(new Font("serif",Font.BOLD,20));
		add(empid);
		
		labelempid = new JLabel();
		labelempid.setBounds(200,150,150,30);
		labelempid.setFont(new Font("serif",Font.BOLD,20));
		add(labelempid);
		
		JLabel dob = new JLabel("Date Of Birth");
		dob.setBounds(400,150,200,30);
		dob.setFont(new Font("serif",Font.BOLD,20));
		add(dob);
		
		JLabel labeldob = new JLabel();
		labeldob.setBounds(600, 150, 150, 30);
		labeldob.setFont(new Font("serif",Font.PLAIN,18));
		add(labeldob);
		
		JLabel address = new JLabel("Address");
		address.setBounds(50,200,200,30);
		address.setFont(new Font("serif",Font.BOLD,20));
		add(address);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(200,200,150,30);
		add(tfaddress);
		
		JLabel phone = new JLabel("Phone");
		phone.setBounds(400,200,200,30);
		phone.setFont(new Font("serif",Font.BOLD,20));
		add(phone);
		
		tfphone = new JTextField();
		tfphone.setBounds(600,200,150,30);
		add(tfphone);
		
		JLabel email = new JLabel("Email Id");
		email.setBounds(50,250,200,30);
		email.setFont(new Font("serif",Font.BOLD,20));
		add(email);
		
		tfemail = new JTextField();
		tfemail.setBounds(200,250,150,30);
		add(tfemail);
		
		JLabel x = new JLabel("Class X (%)");
		x.setBounds(400,250,200,30);
		x.setFont(new Font("serif",Font.BOLD,20));
		add(x);
		
		JLabel lblx = new JLabel();
		lblx.setBounds(600,250,150,30);
		lblx.setFont(new Font("serif",Font.PLAIN,18));
		add(lblx);
		
		JLabel xii = new JLabel("Class XII (%)");
		xii.setBounds(50,300,200,30);
		xii.setFont(new Font("serif",Font.BOLD,20));
		add(xii);
		
		JLabel lblxii = new JLabel();
		lblxii.setBounds(200,300,150,30);
		lblxii.setFont(new Font("serif",Font.PLAIN,18));
		add(lblxii);
		
		JLabel aadhar = new JLabel("Aadhar Number");
		aadhar.setBounds(400,300,200,30);
		aadhar.setFont(new Font("serif",Font.BOLD,20));
		add(aadhar);
		
		JLabel lblaadhar = new JLabel();
		lblaadhar.setBounds(600,300,150,30);
		lblaadhar.setFont(new Font("serif",Font.PLAIN,18));
		add(lblaadhar);
		
		JLabel course = new JLabel("Education");
		course.setBounds(50,350,200,30);
		course.setFont(new Font("serif",Font.BOLD,20));
		add(course);
		
		
		tfcourse = new JTextField();
		tfcourse.setBounds(200,350,150,30);
		tfcourse.setBackground(Color.WHITE);
		add(tfcourse);
		
		JLabel branch = new JLabel("Department");
		branch.setBounds(400,350,200,30);
		branch.setFont(new Font("serif",Font.BOLD,20));
		add(branch);
		
		
		tfbranch = new JTextField();
		tfbranch.setBounds(600,350,150,30);
		tfbranch.setBackground(Color.WHITE);
		add(tfbranch);
		
		try {
			Conn c = new Conn();
			String query = "select * from teacher where empid='"+cEmpId.getSelectedItem()+"'";
			ResultSet res = c.stmt.executeQuery(query);
			while(res.next()) {
				labelname.setText(res.getString("name"));
				labelfname.setText(res.getString("fname"));
				labeldob.setText(res.getString("dob"));
				labelempid.setText(res.getString("empid"));
				lblx.setText(res.getString("class_x"));
				lblxii.setText(res.getString("class_xii"));
				tfaddress.setText(res.getString("address"));
				tfphone.setText(res.getString("phone"));
				tfemail.setText(res.getString("email"));
				lblaadhar.setText(res.getString("aadhar"));
				tfcourse.setText(res.getString("education"));
				tfbranch.setText(res.getString("department"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cEmpId.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent ie) {
				try {
					Conn c = new Conn();
					String query = "select * from teacher where empid='"+cEmpId.getSelectedItem()+"'";
					ResultSet res = c.stmt.executeQuery(query);
					while(res.next()) {
						labelname.setText(res.getString("name"));
						labelfname.setText(res.getString("fname"));
						labeldob.setText(res.getString("dob"));
						labelempid.setText(res.getString("empid"));
						lblx.setText(res.getString("class_x"));
						lblxii.setText(res.getString("class_xii"));
						tfaddress.setText(res.getString("address"));
						tfphone.setText(res.getString("phone"));
						tfemail.setText(res.getString("email"));
						lblaadhar.setText(res.getString("aadhar"));
						tfcourse.setText(res.getString("education"));
						tfbranch.setText(res.getString("department"));
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		submit = new JButton("Update");
		submit.setBounds(250,450,120,30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Raleway", Font.BOLD,15));
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(450,450,120,30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raleway", Font.BOLD,15));
		cancel.addActionListener(this);
		add(cancel);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()== submit) {

			String rollno = labelempid.getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			String course = tfcourse.getText();
			String branch = tfbranch.getText();
			
			try {
				String query = "update teacher set address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+course+"',department='"+branch+"' where empid='"+rollno+"'";
				Conn c = new Conn();
				c.stmt.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Teacher details updated successfully");
				setVisible(false);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new UpdateTeacher();
	}

}
