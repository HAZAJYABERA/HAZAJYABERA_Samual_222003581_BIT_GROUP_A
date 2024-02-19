package all.formsenties;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import all.entities.Teacher;
public class TeacherForm implements ActionListener{ 
		JFrame frame;
				JLabel id_lb=new JLabel("Teacher_id");
				JLabel teaname_lb=new JLabel("Teacher_name");
				JLabel phone_lb=new JLabel("Contact");
				JLabel email_lb=new JLabel("Email");
				JLabel course_lb=new JLabel("Course_name");
				JLabel office_lb=new JLabel("Office_hours");
			    JTextField id_txf=new JTextField();
				JTextField teaname_txf=new JTextField();
				JTextField email_txf=new JTextField();
				JTextField phone_txf=new JTextField();
				JTextField course_txf=new JTextField();
				JTextField office_txf=new JTextField();;
				//Buttons CRUD
				JButton insert_btn=new JButton("Insert");
				JButton Read_btn=new JButton("View");
				JButton update_tbtn=new JButton("Update");
				JButton delete_btn=new JButton("Delete");
				Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
				int w=(int) screensize.getWidth();
				int h=(int) screensize.getHeight();
				public TeacherForm() {
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
					frame.setBounds(10, 10, 700, 300);
					frame.getContentPane().setLayout(null);
					frame.getContentPane().setBackground(Color.LIGHT_GRAY);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setResizable(true);
					setLocationandSize();
				}


				private void setLocationandSize() {
					id_lb.setBounds(10, 10, 100, 30);
					teaname_lb.setBounds(10, 50, 100, 30);
					phone_lb.setBounds(10, 90, 100, 30);
					email_lb.setBounds(10, 130, 100, 30);
					course_lb.setBounds(10, 170, 100, 30);
					office_lb.setBounds(10, 210, 100, 30);
				
					
					id_txf.setBounds(160, 10, 130, 30);
					teaname_txf.setBounds(160, 50, 130, 30);
					phone_txf.setBounds(160, 90, 130, 30);
					email_txf.setBounds(160, 130, 130, 30);
				course_txf.setBounds(160, 170, 130, 30);
					office_txf.setBounds(160, 210, 130, 30);
					//Buttons CRUD
					insert_btn.setBounds(10,250, 85, 30);
					Read_btn.setBounds(100,250, 85, 30);
					update_tbtn.setBounds(190,250, 85, 30);
					delete_btn.setBounds(280,250, 85, 30);
					setFontforall();
					addcomponentforFrame();
					}
				private void setFontforall() {
					Font font = new Font("Georgia", Font.BOLD, 18);

					id_lb.setFont(font);
					teaname_lb.setFont(font);
					email_lb.setFont(font);
					phone_lb.setFont(font);
					course_lb.setFont(font);
					office_lb.setFont(font);
                    //text
					id_txf.setFont(font);
					teaname_txf.setFont(font);
					email_txf.setFont(font);
					phone_txf.setFont(font);
					course_txf.setFont(font);
					office_txf.setFont(font);
					//Buttons CRUD
					Font fonti = new Font("Courier New", Font.ITALIC, 12);

					insert_btn.setFont(fonti);
					Read_btn.setFont(fonti);
					update_tbtn.setFont(fonti);
					delete_btn.setFont(fonti);

				}
				private void addcomponentforFrame() {
					frame.add(id_lb);
					frame.add(teaname_lb);
					frame.add(email_lb);
					frame.add(phone_lb);
					frame.add(course_lb);
					frame.add(office_lb);
					//text
					frame.add(id_txf);
					frame.add(teaname_txf);
					frame.add(email_txf);
					frame.add(phone_txf);
					frame.add(course_txf);
					frame.add(office_txf);
					//Buttons CRUD
					frame.add(insert_btn);
					frame.add(Read_btn);
					frame.add(update_tbtn);
					frame.add(delete_btn);
					ActionEvent();
				}
				@Override
			   public void actionPerformed(ActionEvent e) {
					Teacher st=new Teacher();
					if(e.getSource()==insert_btn) {
						st.setTeacher_name(teaname_txf.getText());
						st.setEmail(email_txf.getText());
						st.setContact(phone_txf.getText());
						st.setCourse_name(course_txf.getText());
						st.setOffice_hours(office_txf.getText());
						st.insertData();
					}else if (e.getSource()==Read_btn) {
						int id=Integer.parseInt(id_txf.getText());
						st.readwithID(id);
						id_txf.setText(String.valueOf(st.getTeacher_id()));
						teaname_txf.setText(st.getTeacher_name());
						email_txf.setText(st.getEmail());
						phone_txf.setText(st.getContact());
						course_txf.setText(st.getCourse_name());
						office_txf.setText(st.getOffice_hours());
					    }else if (e.getSource()==update_tbtn) {
						int id=Integer.parseInt(id_txf.getText());
						st.setTeacher_name(teaname_txf.getText());
						st.setEmail(email_txf.getText());
						st.setContact(phone_txf.getText());
						st.setCourse_name(course_txf.getText());
						st.setOffice_hours(office_txf.getText());
						st.update(id);
					}else {
						int id=Integer.parseInt(id_txf.getText());
						st.delete(id);
					}}
				public static void main(String[] args) {
				TeacherForm  teacherForm= new TeacherForm();			
						System.out.println(teacherForm);
				}}

