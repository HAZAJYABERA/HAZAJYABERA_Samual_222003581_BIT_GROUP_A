package all.formsenties;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Spring;

import all.entities.Student;
public class StundentForm implements ActionListener{ 
	JFrame frame;
			JLabel id_lb=new JLabel("stu_id");
			JLabel stname_lb=new JLabel("student_name");
			JLabel email_lb=new JLabel("Email");
			JLabel phone_lb=new JLabel("Telephone");
			JLabel dob_lb=new JLabel("Date_of_birth");
			JLabel national_lb=new JLabel("Nationality");
			JLabel ge_lb=new JLabel("Gender");
			JLabel couse_lb=new JLabel("Course_name");
			JLabel edo_lb=new JLabel("Enrollment_date");
			JLabel pa_lb=new JLabel("Parents");
		    JTextField id_txf=new JTextField();
			JTextField stname_txf=new JTextField();
			JTextField email_txf=new JTextField();
			JTextField phone_txf=new JTextField();
			JTextField dob_txf=new JTextField();
			JTextField national_txf=new JTextField();
			JTextField gend_txf=new JTextField();
			JTextField course_txf=new JTextField();
			JTextField edo_txf=new JTextField();
			JTextField pa_txf=new JTextField();
			String []gender={"Male","Female"};
			JComboBox<String> genderBox = new JComboBox<>(gender);

			//Buttons CRUD
			JButton insert_btn=new JButton("Insert");
			JButton Read_btn=new JButton("View");
			JButton update_tbtn=new JButton("Update");
			JButton delete_btn=new JButton("Delete");
			Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
			int w=(int) screensize.getWidth();
			int h=(int) screensize.getHeight();
			public StundentForm() {
				createForm();

			}
			private <insertbtn, delete_btn> void ActionEvent() {
				insert_btn.addActionListener(this);
				Read_btn.addActionListener(this);
				update_tbtn.addActionListener(this);
				delete_btn.addActionListener(this);
			}
			private void createForm() {
				frame=new JFrame();
				frame.setTitle("STUDENT FORM");
				frame.setBounds(10, 10, 400, 400);
				frame.getContentPane().setLayout(null);
				frame.getContentPane().setBackground(Color.LIGHT_GRAY);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(true);
				setLocationandSize();
			}


			private void setLocationandSize() {
				id_lb.setBounds(10, 10, 100, 30);
				stname_lb.setBounds(10, 50, 100, 30);
				email_lb.setBounds(10, 90, 100, 30);
				phone_lb.setBounds(10, 130, 100, 30);
				dob_lb.setBounds(10, 170, 100, 30);
				national_lb.setBounds(10, 210, 100, 30);
				ge_lb.setBounds(10, 250, 100, 30);
				couse_lb.setBounds(10, 290, 100, 30);
				edo_lb.setBounds(10, 330, 100, 30);
				pa_lb.setBounds(10, 370, 100, 30);
				
				id_txf.setBounds(160, 10, 130, 30);
				stname_txf.setBounds(160, 50, 130, 30);
				email_txf.setBounds(160, 90, 130, 30);
				phone_txf.setBounds(160, 130, 130, 30);
				dob_txf.setBounds(160, 170, 130, 30);
				national_txf.setBounds(160, 210, 130, 30);
				genderBox.setBounds(160, 250, 130, 30);
				course_txf.setBounds(160, 290, 130, 30);
				edo_txf.setBounds(160, 330, 130, 30);
				pa_txf.setBounds(160, 370, 130, 30);
				
				    //Buttons CRUD
				insert_btn.setBounds(10,410, 85, 30);
				Read_btn.setBounds(100,410, 85, 30);
				update_tbtn.setBounds(190,410, 85, 30);
				delete_btn.setBounds(280,410, 85, 30);
				setFontforall();
				addcomponentforFrame();
				}
			private void setFontforall() {
				Font font = new Font("Georgia", Font.BOLD, 18);

				id_lb.setFont(font);
				stname_lb.setFont(font);
				email_lb.setFont(font);
				phone_lb.setFont(font);
				dob_lb.setFont(font);
				national_lb.setFont(font);
				ge_lb.setFont(font);
				couse_lb.setFont(font);
				edo_lb.setFont(font);
				pa_lb.setFont(font);

				id_txf.setFont(font);
				stname_txf.setFont(font);
				email_txf.setFont(font);
				phone_txf.setFont(font);
				dob_txf.setFont(font);
				national_txf.setFont(font);
				genderBox.setFont(font);
				course_txf.setFont(font);
				edo_txf.setFont(font);
				pa_txf.setFont(font);
				//Buttons CRUD
				Font fonti = new Font("Courier New", Font.ITALIC, 12);

				insert_btn.setFont(fonti);
				Read_btn.setFont(fonti);
				update_tbtn.setFont(fonti);
				delete_btn.setFont(fonti);

			}
			private void addcomponentforFrame() {
				frame.add(id_lb);
				frame.add(stname_lb);
				frame.add(email_lb);
				frame.add(phone_lb);
				frame.add(dob_lb);
				frame.add(national_lb);
				frame.add(ge_lb);
				frame.add(couse_lb);
				frame.add(edo_lb);
				frame.add(pa_lb);
				//text
				frame.add(id_txf);
				frame.add(stname_txf);
				frame.add(email_txf);
				frame.add(phone_txf);
				frame.add(dob_txf);
				frame.add(national_txf);
				frame.add(genderBox);
				frame.add(course_txf);
				frame.add(edo_txf);
				frame.add(pa_txf);
				//Buttons CRUD
				frame.add(insert_btn);
				frame.add(Read_btn);
				frame.add(update_tbtn);
				frame.add(delete_btn);
				ActionEvent();
			}
			@Override
		   public void actionPerformed(ActionEvent e) {
				Student st=new Student();
				if(e.getSource()==insert_btn) {
					st.setStudent_name(stname_txf.getText());
					st.setEmail(email_txf.getText());
					st.setContact(phone_txf.getText());
					st.setDate_of_birth(dob_txf.getText());
					st.setNationality(national_txf.getText());
					Spring selectedOption = (Spring) genderBox.getSelectedItem();
					st.setGender(selectedOption);
					st.setCourse_name(course_txf.getText());
					st.setEnrollment_date(edo_txf.getText());
					st.setParents(pa_txf.getText());
					st.insertData();
				}else if (e.getSource()==Read_btn) {
					int id=Integer.parseInt(id_txf.getText());
					st.readwithID(id);
					id_txf.setText(String.valueOf(st.getStu_id()));
					stname_txf.setText(st.getStudent_name());
					email_txf.setText(st.getEmail());
					phone_txf.setText(st.getContact());
					dob_txf.setText(st.getDate_of_birth());
					national_txf.setText(st.getNationality());
					st.setGender(st.getGender());
					course_txf.setText(st.getCourse_name());
					edo_txf.setText(st.getEnrollment_date());
					pa_txf.setText(st.getParents());
				    }else if (e.getSource()==update_tbtn) {
					int id=Integer.parseInt(id_txf.getText());
					st.setStudent_name(stname_txf.getText());
					st.setEmail(email_txf.getText());
					st.setContact(phone_txf.getText());
					st.setNationality(national_txf.getText());
					st.setGender((Spring)genderBox.getSelectedItem());
					st.setCourse_name(course_txf.getText());
					st.setEnrollment_date(edo_txf.getText());
					st.setParents(pa_txf.getText());
					st.update(id);
				}else {
					int id=Integer.parseInt(id_txf.getText());
					st.delete(id);
				}}
			public static void main(String[] args) {
			StundentForm  stundentForm= new StundentForm();
			System.out.println(stundentForm);
			}}








