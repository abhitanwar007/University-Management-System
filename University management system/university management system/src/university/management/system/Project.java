package university.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

public class Project extends JFrame implements ActionListener{
	
	Project(){
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1380, 650, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);

		JMenuBar mb = new JMenuBar();
		
		JMenu newInformation = new JMenu("New Information");
		newInformation.setForeground(Color.BLUE);
		mb.add(newInformation);
		
		JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
		facultyInfo.setBackground(Color.WHITE);
		facultyInfo.addActionListener(this);
		newInformation.add(facultyInfo);
		
		JMenuItem studentInfo = new JMenuItem("New Student Information");
		studentInfo.setBackground(Color.WHITE);
		studentInfo.addActionListener(this);
		newInformation.add(studentInfo);
		
		// details
		JMenu details = new JMenu("View Details");
		details.setForeground(Color.RED);
		mb.add(details);
		
		JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
		facultyDetails.setBackground(Color.WHITE);
		facultyDetails.addActionListener(this);
		details.add(facultyDetails);
		
		JMenuItem studentDetails = new JMenuItem("View Student Details");
		studentDetails.setBackground(Color.WHITE);
		studentDetails.addActionListener(this);
		details.add(studentDetails);
		
		// leave
		JMenu Leave = new JMenu("Apply Leave");
		Leave.setForeground(Color.BLUE);
		mb.add(Leave);
		
		JMenuItem facultyleave= new JMenuItem("Faculty Leave");
		facultyleave.setBackground(Color.WHITE);
		facultyleave.addActionListener(this);
		Leave.add(facultyleave);
		
		JMenuItem studentleave = new JMenuItem("Student Leave");
		studentleave.setBackground(Color.WHITE);
		studentleave.addActionListener(this);
		Leave.add(studentleave);
		
		JMenu LeaveDetails = new JMenu("Leave Details");
		LeaveDetails.setForeground(Color.RED);
		mb.add(LeaveDetails);
		
		JMenuItem facultyleavedetails= new JMenuItem("Faculty Leave Details");
		facultyleavedetails.setBackground(Color.WHITE);
		facultyleavedetails.addActionListener(this);
		LeaveDetails.add(facultyleavedetails);
		
		JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
		studentleavedetails.setBackground(Color.WHITE);
		studentleavedetails.addActionListener(this);
		LeaveDetails.add(studentleavedetails);
		
		// exams
		JMenu exam = new JMenu("Examination");
		exam.setForeground(Color.BLUE);
		mb.add(exam);
		
		JMenuItem examinationdetails= new JMenuItem("Examination Result");
		examinationdetails.setBackground(Color.WHITE);
		exam.add(examinationdetails);
		
		JMenuItem entermarks = new JMenuItem("Enter Marks");
		entermarks.setBackground(Color.WHITE);
		entermarks.addActionListener(this);
		exam.add(entermarks);
		
		// update info
		JMenu updateinfo = new JMenu("Update Details");
		updateinfo.setForeground(Color.RED);
		mb.add(updateinfo);
		
		JMenuItem updatefacultyinfo= new JMenuItem("Update Faculty Details");
		updatefacultyinfo.setBackground(Color.WHITE);
		updatefacultyinfo.addActionListener(this);
		updateinfo.add(updatefacultyinfo);
		
		JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
		updatestudentinfo.setBackground(Color.WHITE);
		updatestudentinfo.addActionListener(this);
		updateinfo.add(updatestudentinfo);

		// Fee
		JMenu fee = new JMenu("Fee Details");
		fee.setForeground(Color.BLUE);
		mb.add(fee);
		
		JMenuItem feestructure= new JMenuItem("Fee Structure");
		feestructure.setBackground(Color.WHITE);
		fee.add(feestructure);
		
		JMenuItem feeform = new JMenuItem("Student Fee Form");
		feeform.setBackground(Color.WHITE);
		fee.add(feeform);
		
		// Utility
		JMenu utility = new JMenu("Utility");
		utility.setForeground(Color.RED);
		mb.add(utility);
		
		JMenuItem notepad= new JMenuItem("Notepad");
		notepad.setBackground(Color.WHITE);
		notepad.addActionListener(this);
		utility.add(notepad);
		
		JMenuItem calc = new JMenuItem("Calculator");
		calc.setBackground(Color.WHITE);
		calc.addActionListener(this);
		utility.add(calc);
		
		// Exit
		JMenu exit = new JMenu("Exit");
		exit.setForeground(Color.BLUE);
		mb.add(exit);
		
		JMenuItem ex = new JMenuItem("Exit");
		ex.setBackground(Color.WHITE);
		ex.addActionListener(this);
		exit.add(ex);
		
		setJMenuBar(mb);
		
		setSize(1380,740);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		String msg = ae.getActionCommand();
		
		if(msg.equals("Exit")) {
			setVisible(false);
		}else if(msg.equals("Calculator")) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			} catch (Exception e) {
				System.out.println(e);
			}
		}else if(msg.equals("Notepad")) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		else if(msg.equals("New Student Information")) {
			new AddStudent();
		}
		else if(msg.equals("New Faculty Information")) {
			new AddTeacher();
		}
		else if(msg.equals("View Student Details")) {
			new StudentDetails();
		}
		else if(msg.equals("View Faculty Details")) {
			new TeacherDetails();
		}
		else if(msg.equals("Faculty Leave")) {
			new TeacherLeave();
		}
		else if(msg.equals("Student Leave")) {
			new StudentLeave();
		}
		else if(msg.equals("Faculty Leave Details")) {
			new TeacherLeaveDetails();
		}
		else if(msg.equals("Student Leave Details")) {
			new StudentLeaveDetails();
		}
		else if(msg.equals("Update Student Details")) {
			new UpdateStudent();
		}
		else if(msg.equals("Update Faculty Details")) {
			new UpdateTeacher();
		}
		else if(msg.equals("Enter Marks")) {
			new EnterMarks();
		}
		
	}
	
	public static void main(String[] args) {
		new Project();
	}
}
