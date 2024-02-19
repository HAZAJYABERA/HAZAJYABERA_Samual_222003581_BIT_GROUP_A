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

import all.entities.Payment;
public class PaymentForm implements ActionListener{
	 JFrame frame;
					JLabel id_lb=new JLabel("Payment_id");
					JLabel Stu_id_lb=new JLabel("Stu_id");
					JLabel Payment_date_lb=new JLabel("Payment_date");
					JLabel Payment_amaunt_lb=new JLabel("Payment_amaunt");
					JLabel Payment_method_lb=new JLabel("Payment_method");
					JLabel Status_lb=new JLabel("Status");
				    JTextField id_txf=new JTextField();
					JTextField Stu_id_txf=new JTextField();
					JTextField Payment_date_txf=new JTextField();
					JTextField Payment_amaunt_txf=new JTextField();
					String []method_payment={"BK","MTN", "TIGO","EQUITY BANK"};
					JComboBox<String> method_paymentBox = new JComboBox<>(method_payment);
					JTextField Status_txf=new JTextField();;
					//Buttons CRUD
					JButton insert_btn=new JButton("Insert");
					JButton Read_btn=new JButton("View");
					JButton update_tbtn=new JButton("Update");
					JButton delete_btn=new JButton("Delete");
					Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
					int w=(int) screensize.getWidth();
					int h=(int) screensize.getHeight();
					public PaymentForm() {
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
						frame.setTitle("PAYMENT FORM");
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
						Stu_id_lb.setBounds(10, 50, 100, 30);
						Payment_date_lb.setBounds(10, 90, 100, 30);
						Payment_amaunt_lb.setBounds(10, 130, 100, 30);
						Payment_method_lb.setBounds(10, 170, 100, 30);
						Status_lb.setBounds(10, 210, 100, 30);
					
						
						id_txf.setBounds(160, 10, 130, 30);
						Stu_id_txf.setBounds(160, 50, 130, 30);
						Payment_date_txf.setBounds(160, 90, 130, 30);
						Payment_amaunt_txf.setBounds(160, 130, 130, 30);
					method_paymentBox.setBounds(160, 170, 130, 30);
						Status_txf.setBounds(160, 210, 130, 30);
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
						Stu_id_lb.setFont(font);
						Payment_date_lb.setFont(font);
						Payment_amaunt_lb.setFont(font);
						Payment_method_lb.setFont(font);
						Status_lb.setFont(font);
	                    //text
						id_txf.setFont(font);
						Stu_id_txf.setFont(font);
						Payment_date_txf.setFont(font);
						Payment_amaunt_txf.setFont(font);
						method_paymentBox.setFont(font);
						Status_txf.setFont(font);
						//Buttons CRUD
						Font fonti = new Font("Courier New", Font.ITALIC, 12);

						insert_btn.setFont(fonti);
						Read_btn.setFont(fonti);
						update_tbtn.setFont(fonti);
						delete_btn.setFont(fonti);

					}
					private void addcomponentforFrame() {
						frame.add(id_lb);
						frame.add(Stu_id_lb);
						frame.add(Payment_date_lb);
						frame.add(Payment_amaunt_lb);
						frame.add(Payment_method_lb);
						frame.add(Status_lb);
						//text
						frame.add(id_txf);
						frame.add(Stu_id_txf);
						frame.add(Payment_date_txf);
						frame.add(Payment_amaunt_txf);
						frame.add(method_paymentBox);
						frame.add(Status_txf);
						//Buttons CRUD
						frame.add(insert_btn);
						frame.add(Read_btn);
						frame.add(update_tbtn);
						frame.add(delete_btn);
						ActionEvent();
					}
					@Override
				   public void actionPerformed(ActionEvent e) {
						Payment st=new Payment();
						if(e.getSource()==insert_btn) {
							st.setStu_id(Integer.parseInt(Stu_id_txf.getText()));
							//st.setStu_id(Stu_id_txf.setText(String.valueOf(st.getStu_id())));
							st.setPayment_date(Payment_date_txf.getText());
							st.setPayment_amaunt(Payment_amaunt_txf.getText());
							st.setPayment_method(method_paymentBox.getSelectedObjects());
							st.setStatus(Status_txf.getText());
							st.insertData();
						}else if (e.getSource()==Read_btn) {
							int id=Integer.parseInt(id_txf.getText());
							st.readwithID(id);
							id_txf.setText(String.valueOf(st.getPayment_id()));
							Payment_date_txf.setText(st.getPayment_date());
							Payment_amaunt_txf.setText(st.getPayment_amaunt());
							method_paymentBox.setSelectedItem(st.getPayment_method());
							Stu_id_txf.setText(String.valueOf(st.getStu_id()));
							Status_txf.setText(st.getStatus());
						    }else if (e.getSource()==update_tbtn) {
							int id=Integer.parseInt(id_txf.getText());
							st.setPayment_date(Payment_date_txf.getText());
							st.setPayment_amaunt(Payment_amaunt_txf.getText());
							//st.setStu_id(Stu_id_txf.getText());
							st.setPayment_method(method_paymentBox.getSelectedObjects());
							st.setStatus(Status_txf.getText());
							int stid=Integer.parseInt(Stu_id_txf.getText());
							st.update(id);
							st.update(stid);
						}else {
							int id=Integer.parseInt(id_txf.getText());
							st.delete(id);
						}}
					public static void main(String[] args) {
					PaymentForm  paymentForm= new PaymentForm();			
							System.out.println(paymentForm);
					}}



