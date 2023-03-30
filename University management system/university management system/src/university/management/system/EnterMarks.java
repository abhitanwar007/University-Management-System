package university.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class EnterMarks extends JFrame implements ActionListener{
	
	Choice crollno;
	JComboBox csemester;
	JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmark1,tfmark2,tfmark3,tfmark4,tfmark5;
	JButton submit ,cancel;
	
	EnterMarks(){
		
		setSize(1000,500);
		setLocation(250,10);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(500, 50, 400, 300);
		add(image);
		
		JLabel heading = new JLabel("Enter marks of Student");
		heading.setBounds(50,0,500,50);
		heading.setFont(new Font("serif",Font.BOLD,25));
		add(heading);
		
		JLabel lblrollno= new JLabel("Select Roll Number");
		lblrollno.setBounds(50,70,200,20);
		lblrollno.setFont(new Font("serif",Font.PLAIN,20));
		add(lblrollno);
		
		crollno = new Choice();
		crollno.setBounds(250, 70, 200, 20);
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
		
		JLabel lblsemester= new JLabel("Select Semester");
		lblsemester.setBounds(50,120,200,20);
		lblsemester.setFont(new Font("serif",Font.PLAIN,20));
		add(lblsemester);
		
		String sem[] = {"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester"};
		csemester = new JComboBox(sem);
		csemester.setBounds(250, 120, 200, 20);
		add(csemester);
		
		JLabel lblentersubject= new JLabel("Enter Subject");
		lblentersubject.setBounds(100,150,200,40);
		add(lblentersubject);
		
		JLabel lblentermarks= new JLabel("Enter Marks");
		lblentermarks.setBounds(300,150,200,40);
		add(lblentermarks);
		
		tfsub1 = new JTextField();
		tfsub1.setBounds(50,200,200,20);
		add(tfsub1);
		tfmark1 = new JTextField();
		tfmark1.setBounds(250,200,200,20);
		add(tfmark1);
		
		tfsub2 = new JTextField();
		tfsub2.setBounds(50,230,200,20);
		add(tfsub2);
		tfmark2 = new JTextField();
		tfmark2.setBounds(250,230,200,20);
		add(tfmark2);
		
		tfsub3 = new JTextField();
		tfsub3.setBounds(50,260,200,20);
		add(tfsub3);
		tfmark3 = new JTextField();
		tfmark3.setBounds(250,260,200,20);
		add(tfmark3);
		
		tfsub4 = new JTextField();
		tfsub4.setBounds(50,290,200,20);
		add(tfsub4);
		tfmark4 = new JTextField();
		tfmark4.setBounds(250,290,200,20);
		add(tfmark4);
		
		tfsub5 = new JTextField();
		tfsub5.setBounds(50,320,200,20);
		add(tfsub5);
		tfmark5 = new JTextField();
		tfmark5.setBounds(250,320,200,20);
		add(tfmark5);
		
		submit = new JButton("Submit");
		submit.setBounds(100,360,120,30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Raleway", Font.BOLD,15));
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(300,360,120,30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raleway", Font.BOLD,15));
		cancel.addActionListener(this);
		add(cancel);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit) {
			try {
				Conn c = new Conn();
				
				String s1="insert into subject values('"+crollno.getSelectedItem()+"','"+csemester.getSelectedIndex()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"')";
				String s2="insert into marks values('"+crollno.getSelectedItem()+"','"+csemester.getSelectedIndex()+"','"+tfmark1.getText()+"','"+tfmark2.getText()+"','"+tfmark3.getText()+"','"+tfmark4.getText()+"','"+tfmark5.getText()+"')";

				c.stmt.executeUpdate(s1);
				c.stmt.executeUpdate(s2);
				
				JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new EnterMarks();
	}
}
