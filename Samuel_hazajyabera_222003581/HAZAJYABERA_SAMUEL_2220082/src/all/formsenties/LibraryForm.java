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

import all.entities.Library;
public class LibraryForm  implements ActionListener{
				JFrame frame;
								JLabel id_lb=new JLabel("Book_id");
								JLabel title=new JLabel("Title");
								JLabel year=new JLabel(" Publication_year");
								JLabel auth=new JLabel("Author");
							//text
		                         JTextField id_txf=new JTextField();                                                                                                                                                                                            
								JTextField title_txf=new JTextField();
								JTextField year_txf=new JTextField();
								JTextField auth_txf=new JTextField();
								
								//Buttons CRUD
								JButton insert_btn=new JButton("Insert");
								JButton Read_btn=new JButton("View");
								JButton update_tbtn=new JButton("Update");
								JButton delete_btn=new JButton("Delete");
								Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
								int w=(int) screensize.getWidth();
								int h=(int) screensize.getHeight();
								public LibraryForm() {
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
									frame.setTitle("LIBRARY FORM");
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
									title.setBounds(10, 50, 100, 30);
									year.setBounds(10, 90, 100, 30);
									auth.setBounds(10, 130, 100, 30);
									
									
								
									
									id_txf.setBounds(160, 10, 130, 30);
									title_txf.setBounds(160, 50, 130, 30);
									year_txf.setBounds(160, 90, 130, 30);
									auth_txf.setBounds(160, 130, 130, 30);
								
									
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
									title.setFont(font);
									year.setFont(font);
									auth.setFont(font);
									
									
				                    //text
									id_txf.setFont(font);
									title_txf.setFont(font);
									year_txf.setFont(font);
									auth_txf.setFont(font);
									
									
									//Buttons CRUD
									Font fonti = new Font("Courier New", Font.ITALIC, 12);

									insert_btn.setFont(fonti);
									Read_btn.setFont(fonti);
									update_tbtn.setFont(fonti);
									delete_btn.setFont(fonti);

								}
								private void addcomponentforFrame() {
									frame.add(id_lb);
									frame.add(title);
									frame.add(year);
									frame.add(auth);
									
									
									//text
									frame.add(id_txf);
									frame.add(title_txf);
									frame.add(year_txf);
									frame.add(auth_txf);
									
								
									//Buttons CRUD
									frame.add(insert_btn);
									frame.add(Read_btn);
									frame.add(update_tbtn);
									frame.add(delete_btn);
									ActionEvent();
								}
								@Override
							   public void actionPerformed(ActionEvent e) {
									Library lib=new Library();
									if(e.getSource()==insert_btn) {
										lib.setTitle(title_txf.getText());
										lib.setPublication_year(year_txf.getText());
										lib.setAuthor(auth_txf.getText());
										
										lib.insertData();
									}else if (e.getSource()==Read_btn) {
										int id=Integer.parseInt(id_txf.getText());
										lib.readwithID(id);
										id_txf.setText(String.valueOf(lib.getBook_id()));
										title_txf.setText(lib.getTitle());
										year_txf.setText(lib.getPublication_year());
										auth_txf.setText(lib.getAuthor());
										
										
									    }else if (e.getSource()==update_tbtn) {
										int id=Integer.parseInt(id_txf.getText());
										lib.setTitle(title_txf.getText());
										lib.setPublication_year(year_txf.getText());
										lib.setAuthor(auth_txf.getText());
										
										lib.update(id);
									}else {
										int id=Integer.parseInt(id_txf.getText());
										lib.delete(id);
									}}
								public static void main(String[] args) {
									LibraryForm libForm= new LibraryForm();		
										System.out.println(libForm);
								}}









