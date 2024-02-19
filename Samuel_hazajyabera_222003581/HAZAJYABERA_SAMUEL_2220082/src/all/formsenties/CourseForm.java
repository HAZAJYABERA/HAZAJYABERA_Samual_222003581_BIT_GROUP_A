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
import all.entities.Course;
public class CourseForm implements ActionListener{
	JFrame frame;
					JLabel id_lb=new JLabel("Course_id");
					JLabel couname_lb=new JLabel("Course_name");
					JLabel code_lb=new JLabel("Course_code");
					JLabel cr_lb=new JLabel("Credit");
					JLabel depa_lb=new JLabel("Department");
				//text
				    JTextField id_txf=new JTextField();
					JTextField couname_txf=new JTextField();
					JTextField code_txf=new JTextField();
					JTextField cr_txf=new JTextField();
					JTextField depa_txf=new JTextField();
					//Buttons CRUD
					JButton insert_btn=new JButton("Insert");
					JButton Read_btn=new JButton("View");
					JButton update_tbtn=new JButton("Update");
					JButton delete_btn=new JButton("Delete");
					Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
					int w=(int) screensize.getWidth();
					int h=(int) screensize.getHeight();
					public CourseForm() {
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
						frame.setTitle("COURSE FORM");
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
						couname_lb.setBounds(10, 50, 100, 30);
						cr_lb.setBounds(10, 90, 100, 30);
						code_lb.setBounds(10, 130, 100, 30);
						depa_lb.setBounds(10, 170, 100, 30);
						
					
						
						id_txf.setBounds(160, 10, 130, 30);
						couname_txf.setBounds(160, 50, 130, 30);
						cr_txf.setBounds(160, 90, 130, 30);
						code_txf.setBounds(160, 130, 130, 30);
					depa_txf.setBounds(160, 170, 130, 30);
						
						//Buttons CRUD
						insert_btn.setBounds(10,210, 85, 30);
						Read_btn.setBounds(100,210, 85, 30);
						update_tbtn.setBounds(190,210, 85, 30);
						delete_btn.setBounds(280,210, 85, 30);
						setFontforall();
						addcomponentforFrame();
						}
					private void setFontforall() {
						Font font = new Font("Georgia", Font.BOLD, 18);

						id_lb.setFont(font);
						couname_lb.setFont(font);
						code_lb.setFont(font);
						cr_lb.setFont(font);
						depa_lb.setFont(font);
						
	                    //text
						id_txf.setFont(font);
						couname_txf.setFont(font);
						code_txf.setFont(font);
						cr_txf.setFont(font);
						depa_txf.setFont(font);
						
						//Buttons CRUD
						Font fonti = new Font("Courier New", Font.ITALIC, 12);

						insert_btn.setFont(fonti);
						Read_btn.setFont(fonti);
						update_tbtn.setFont(fonti);
						delete_btn.setFont(fonti);

					}
					private void addcomponentforFrame() {
						frame.add(id_lb);
						frame.add(couname_lb);
						frame.add(code_lb);
						frame.add(cr_lb);
						frame.add(depa_lb);
						
						//text
						frame.add(id_txf);
						frame.add(couname_txf);
						frame.add(code_txf);
						frame.add(cr_txf);
						frame.add(depa_txf);
					
						//Buttons CRUD
						frame.add(insert_btn);
						frame.add(Read_btn);
						frame.add(update_tbtn);
						frame.add(delete_btn);
						ActionEvent();
					}
					@Override
				   public void actionPerformed(ActionEvent e) {
						Course course=new Course();
						if(e.getSource()==insert_btn) {
							course.setCourse_name(couname_txf.getText());
							course.setCourse_code(code_txf.getText());
							course.setCredit(cr_txf.getText());
							course.setDepartment(depa_txf.getText());
							course.insertData();
						}else if (e.getSource()==Read_btn) {
							int id=Integer.parseInt(id_txf.getText());
							course.readwithID(id);
							id_txf.setText(String.valueOf(course.getCourse_id()));
							couname_txf.setText(course.getCourse_name());
							code_txf.setText(course.getCourse_code());
							cr_txf.setText(course.getCredit());
							depa_txf.setText(course.getDepartment());
							
						    }else if (e.getSource()==update_tbtn) {
							int id=Integer.parseInt(id_txf.getText());
							course.setCourse_name(couname_txf.getText());
							course.setCourse_code(code_txf.getText());
							course.setCredit(cr_txf.getText());
							course.setDepartment(depa_txf.getText());
							course.update(id);
						}else {
							int id=Integer.parseInt(id_txf.getText());
							course.delete(id);
						}}
					public static void main(String[] args) {
						CourseForm  CourseForm= new CourseForm();		
							System.out.println(CourseForm);
					}}



