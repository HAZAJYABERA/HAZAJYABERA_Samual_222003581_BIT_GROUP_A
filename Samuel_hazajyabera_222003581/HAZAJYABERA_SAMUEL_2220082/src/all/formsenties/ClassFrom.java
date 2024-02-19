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
import all.entities.Class;
public class ClassFrom  implements ActionListener{
	 
		JFrame frame;
						JLabel id_lb=new JLabel("Class_id");
						JLabel clle_lb=new JLabel("Class_level");
						JLabel loc_lb=new JLabel("Location");
						JLabel year_lb=new JLabel("Year");
						JLabel start_lb=new JLabel("started_date");
						JLabel end_lb=new JLabel("ended_date");
					//text
					    JTextField id_txf=new JTextField();
						JTextField clle_txf=new JTextField();
						JTextField loc_txf=new JTextField();
						JTextField year_txf=new JTextField();
						JTextField start_txf=new JTextField();
						JTextField end_txf=new JTextField();
						//Buttons CRUD
						JButton insert_btn=new JButton("Insert");
						JButton Read_btn=new JButton("View");
						JButton update_tbtn=new JButton("Update");
						JButton delete_btn=new JButton("Delete");
						Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
						int w=(int) screensize.getWidth();
						int h=(int) screensize.getHeight();
						public ClassFrom() {
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
							frame.setTitle("CLASS FORM");
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
							clle_lb.setBounds(10, 50, 100, 30);
							loc_lb.setBounds(10, 90, 100, 30);
							year_lb.setBounds(10, 130, 100, 30);
							start_lb.setBounds(10, 170, 100, 30);
							end_lb.setBounds(10, 210, 100, 30);
							
						
							
							id_txf.setBounds(160, 10, 130, 30);
							clle_txf.setBounds(160, 50, 130, 30);
							loc_txf.setBounds(160, 90, 130, 30);
							year_txf.setBounds(160, 130, 130, 30);
						start_txf.setBounds(160, 170, 130, 30);
						end_txf.setBounds(160, 210, 130, 30);
							
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
							clle_lb.setFont(font);
							loc_lb.setFont(font);
							year_lb.setFont(font);
							start_lb.setFont(font);
							end_lb.setFont(font);
							
		                    //text
							id_txf.setFont(font);
							clle_txf.setFont(font);
							loc_txf.setFont(font);
						    year_txf.setFont(font);
							start_txf.setFont(font);
							end_txf.setFont(font);
							//Buttons CRUD
							Font fonti = new Font("Courier New", Font.ITALIC, 12);

							insert_btn.setFont(fonti);
							Read_btn.setFont(fonti);
							update_tbtn.setFont(fonti);
							delete_btn.setFont(fonti);

						}
						private void addcomponentforFrame() {
							frame.add(id_lb);
							frame.add(clle_lb);
							frame.add(loc_lb);
							frame.add(year_lb);
							frame.add(start_lb);
							frame.add(end_lb);
							//text
							frame.add(id_txf);
							frame.add(clle_txf);
							frame.add(loc_txf);
							frame.add(year_txf);
							frame.add(start_txf);
							frame.add(end_txf);
							//Buttons CRUD
							frame.add(insert_btn);
							frame.add(Read_btn);
							frame.add(update_tbtn);
							frame.add(delete_btn);
							ActionEvent();
						}
						@Override
					   public void actionPerformed(ActionEvent e) {
							Class cl=new Class();
							if(e.getSource()==insert_btn) {
								cl.setClass_level(clle_txf.getText());
								cl.setLocation(loc_txf.getText());
								cl.setYear(year_txf.getText());
								cl.setStarted_date(start_txf.getText());
								cl.setEnded_date(end_txf.getText());
								cl.insertData();
							}else if (e.getSource()==Read_btn) {
								int id=Integer.parseInt(id_txf.getText());
								cl.readwithID(id);
								id_txf.setText(String.valueOf(cl.getClass_id()));
								clle_txf.setText(cl.getClass_level());
								loc_txf.setText(cl.getLocation());
								year_txf.setText(cl.getYear());
								start_txf.setText(cl.getStarted_date());
								end_txf.setText(cl.getEnded_date());
								
							    }else if (e.getSource()==update_tbtn) {
								int id=Integer.parseInt(id_txf.getText());
								cl.setClass_level(clle_txf.getText());
								cl.setLocation(loc_txf.getText());
								cl.setYear(year_txf.getText());
								cl.setStarted_date(start_txf.getText());
								cl.setEnded_date(end_txf.getText());
								cl.update(id);
							}else {
								int id=Integer.parseInt(id_txf.getText());
								cl.delete(id);
							}}
						public static void main(String[] args) {
							ClassFrom  ClassForm= new ClassFrom();		
								System.out.println(ClassForm);
						}}





