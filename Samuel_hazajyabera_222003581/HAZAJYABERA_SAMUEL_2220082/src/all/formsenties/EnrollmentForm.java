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
import all.entities.Enrollment;
public class EnrollmentForm implements ActionListener{
			JFrame frame;
							JLabel id_lb=new JLabel("Enrollment_id");
							JLabel stuid=new JLabel("Stu_id");
							JLabel couid=new JLabel("Course_id");
							JLabel enrodate=new JLabel("Enrollment_Date");
						
						//text
						    JTextField id_txf=new JTextField();
							JTextField stuid_txf=new JTextField();
							JTextField couid_txf=new JTextField();
							JTextField enrodate_txf=new JTextField();
							
							//Buttons CRUD
							JButton insert_btn=new JButton("Insert");
							JButton Read_btn=new JButton("View");
							JButton update_tbtn=new JButton("Update");
							JButton delete_btn=new JButton("Delete");
							Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
							int w=(int) screensize.getWidth();
							int h=(int) screensize.getHeight();
							public EnrollmentForm() {
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
								frame.setTitle("ENROLLMENT FORM");
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
								stuid.setBounds(10, 50, 100, 30);
								couid.setBounds(10, 90, 100, 30);
								enrodate.setBounds(10, 130, 100, 30);
								
								
							
								
								id_txf.setBounds(160, 10, 130, 30);
								stuid_txf.setBounds(160, 50, 130, 30);
								couid_txf.setBounds(160, 90, 130, 30);
								enrodate_txf.setBounds(160, 130, 130, 30);
							
								
								//Buttons CRUD
								insert_btn.setBounds(10,170, 85, 30);
								Read_btn.setBounds(100,170, 85, 30);
								update_tbtn.setBounds(190,170, 85, 30);
								delete_btn.setBounds(280,170, 85, 30);
								setFontforall();
								addcomponentforFrame();
								}
							private void setFontforall() {
								Font font = new Font("Georgia", Font.BOLD, 18);

								id_lb.setFont(font);
								stuid.setFont(font);
								couid.setFont(font);
								enrodate.setFont(font);
								
								
			                    //text
								id_txf.setFont(font);
								stuid_txf.setFont(font);
								couid_txf.setFont(font);
								enrodate_txf.setFont(font);
								
								
								//Buttons CRUD
								Font fonti = new Font("Courier New", Font.ITALIC, 12);

								insert_btn.setFont(fonti);
								Read_btn.setFont(fonti);
								update_tbtn.setFont(fonti);
								delete_btn.setFont(fonti);

							}
							private void addcomponentforFrame() {
								frame.add(id_lb);
								frame.add(stuid);
								frame.add(couid);
								frame.add(enrodate);
								
								
								//text
								frame.add(id_txf);
								frame.add(stuid_txf);
								frame.add(couid_txf);
								frame.add(enrodate_txf);
								
							
								//Buttons CRUD
								frame.add(insert_btn);
								frame.add(Read_btn);
								frame.add(update_tbtn);
								frame.add(delete_btn);
								ActionEvent();
							}
							@Override
						   public void actionPerformed(ActionEvent e) {
								Enrollment att=new Enrollment();
								if(e.getSource()==insert_btn) {
									att.setStu_id(stuid_txf.getText());
									att.setCourse_id(couid_txf.getText());
									att.setEnrollment_date(enrodate_txf.getText());
									
									att.insertData();
								}else if (e.getSource()==Read_btn) {
									int id=Integer.parseInt(id_txf.getText());
									att.readwithID(id);
									id_txf.setText(String.valueOf(att.getEnrollment_id()));
									stuid_txf.setText(att.getStu_id());
									couid_txf.setText(att.getCourse_id());
									enrodate_txf.setText(att.getEnrollment_date());
									
									
								    }else if (e.getSource()==update_tbtn) {
									int id=Integer.parseInt(id_txf.getText());
									att.setStu_id(stuid_txf.getText());
									att.setCourse_id(couid_txf.getText());
									att.setEnrollment_date(enrodate_txf.getText());
									
									att.update(id);
								}else {
									int id=Integer.parseInt(id_txf.getText());
									att.delete(id);
								}}
							public static void main(String[] args) {
								EnrollmentForm enroForm= new EnrollmentForm();		
									System.out.println(enroForm);
							}}







