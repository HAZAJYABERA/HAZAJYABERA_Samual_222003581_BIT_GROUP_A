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
import all.entities.Attendance;
public class AttendanceForm implements ActionListener{
		JFrame frame;
						JLabel id_lb=new JLabel("Attendance_id");
						JLabel stu_lb=new JLabel("Stu_id");
						JLabel class_lb=new JLabel("Class_id");
						JLabel att_lb=new JLabel("Attendance_date");
						JLabel sta_lb=new JLabel("Status");
					//text
					    JTextField id_txf=new JTextField();
						JTextField stu_txf=new JTextField();
						JTextField class_txf=new JTextField();
						JTextField att_txf=new JTextField();
						JTextField sta_txf=new JTextField();
						//Buttons CRUD
						JButton insert_btn=new JButton("Insert");
						JButton Read_btn=new JButton("View");
						JButton update_tbtn=new JButton("Update");
						JButton delete_btn=new JButton("Delete");
						Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
						int w=(int) screensize.getWidth();
						int h=(int) screensize.getHeight();
						public AttendanceForm() {
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
							frame.setTitle("ATTENDANCE FORM");
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
							stu_lb.setBounds(10, 50, 100, 30);
							class_lb.setBounds(10, 90, 100, 30);
							att_lb.setBounds(10, 130, 100, 30);
							sta_lb.setBounds(10, 170, 100, 30);
							
						
							
							id_txf.setBounds(160, 10, 130, 30);
							stu_txf.setBounds(160, 50, 130, 30);
							class_txf.setBounds(160, 90, 130, 30);
							att_txf.setBounds(160, 130, 130, 30);
						     sta_txf.setBounds(160, 170, 130, 30);
							
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
							stu_lb.setFont(font);
							class_lb.setFont(font);
							att_lb.setFont(font);
							sta_lb.setFont(font);
							
		                    //text
							id_txf.setFont(font);
							stu_txf.setFont(font);
							class_txf.setFont(font);
							att_txf.setFont(font);
							sta_txf.setFont(font);
							
							//Buttons CRUD
							Font fonti = new Font("Courier New", Font.ITALIC, 12);

							insert_btn.setFont(fonti);
							Read_btn.setFont(fonti);
							update_tbtn.setFont(fonti);
							delete_btn.setFont(fonti);

						}
						private void addcomponentforFrame() {
							frame.add(id_lb);
							frame.add(stu_lb);
							frame.add(class_lb);
							frame.add(att_lb);
							frame.add(sta_lb);
							
							//text
							frame.add(id_txf);
							frame.add(stu_txf);
							frame.add(class_txf);
							frame.add(att_txf);
							frame.add(sta_txf);
						
							//Buttons CRUD
							frame.add(insert_btn);
							frame.add(Read_btn);
							frame.add(update_tbtn);
							frame.add(delete_btn);
							ActionEvent();
						}
						@Override
					   public void actionPerformed(ActionEvent e) {
							Attendance att=new Attendance();
							if(e.getSource()==insert_btn) {
								att.setStu_id(stu_txf.getText());
								att.setClass_id(class_txf.getText());
								att.setAttendance_date(att_txf.getText());
								att.setStatus(sta_txf.getText());
								att.insertData();
							}else if (e.getSource()==Read_btn) {
								int id=Integer.parseInt(id_txf.getText());
								att.readwithID(id);
								id_txf.setText(String.valueOf(att.getAttendance_id()));
								stu_txf.setText(att.getStu_id());
								class_txf.setText(att.getClass_id());
								att_txf.setText(att.getAttendance_date());
								sta_txf.setText(att.getStatus());
								
							    }else if (e.getSource()==update_tbtn) {
								int id=Integer.parseInt(id_txf.getText());
								att.setStu_id(stu_txf.getText());
								att.setClass_id(class_txf.getText());
								att.setAttendance_date(att_txf.getText());
								att.setStatus(sta_txf.getText());
								att.update(id);
							}else {
								int id=Integer.parseInt(id_txf.getText());
								att.delete(id);
							}}
						public static void main(String[] args) {
							AttendanceForm attForm= new AttendanceForm();		
								System.out.println(attForm);
						}}





