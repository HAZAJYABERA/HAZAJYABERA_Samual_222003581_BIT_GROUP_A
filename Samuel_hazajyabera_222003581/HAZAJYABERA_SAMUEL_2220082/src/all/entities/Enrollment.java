package all.entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Enrollment {
	private int Enrollment_id;
					private String Stu_id;
					private String  Course_id;
					private String  Enrollment_date;
				
				
					public Enrollment() {}
					public Enrollment(int Enrollment_id, String Stu_id , String  Course_id, String  Enrollment_date ) {
						super();
						this. Enrollment_id =  Enrollment_id;
						this.Stu_id = Stu_id;
						this. Course_id =  Course_id;
						this. Enrollment_date =  Enrollment_date;
					
						
						
					}
					public Enrollment( String Stu_id, String  Course_id, String  Enrollment_date) {
						this.Stu_id = Stu_id;
						this. Course_id =  Course_id;
						this. Enrollment_date =  Enrollment_date;
						
						}
				
					public int getEnrollment_id() {
						return Enrollment_id;
					}
					public void setEnrollment_id(int enrollment_id) {
						Enrollment_id = enrollment_id;
					}
					public String getStu_id() {
						return Stu_id;
					}
					public void setStu_id(String stu_id) {
						Stu_id = stu_id;
					}
					public String getCourse_id() {
						return Course_id;
					}
					public void setCourse_id(String course_id) {
						Course_id = course_id;
					}
					public String getEnrollment_date() {
						return Enrollment_date;
					}
					public void setEnrollment_date(String enrollment_date) {
						Enrollment_date = enrollment_date;
					}
					public void makeconnection() {
					}
					public void insertData(String stid, String couid,String erdate) {
						// JDBC URL, username, and password of MySQL server
					    String host = "jdbc:mysql://localhost/hazajyabera_samuel_222003581";
					    String user = "root";
					    String password = "";

					    // SQL query to insert data
				String sql = "INSERT INTO enrollment (Stu_id, Enrollment_date, Course_id,Department) VALUES (?,?,?,?)";
					
					    try (
					        // Establish the connection
					        Connection con = DriverManager.getConnection(host, user, password);

					        // Create a prepared statement
								   PreparedStatement preparedStatement = con.prepareStatement(sql);
					    	    ) {
					        // Set the values for the prepared statement
					       preparedStatement.setString(1, stid);
					       preparedStatement.setString(2, couid);
					        preparedStatement.setString(3, erdate);
					       

					        
					        // Execute the query
					        int rowsAffected = preparedStatement.executeUpdate();

					        // Check the result
					        if (rowsAffected > 0) {
					        	System.out.println("Data inserted successfully!");
					            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
					        } else {
					            System.out.println("Failed to insert data.");
					            JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

					        }

					    } catch (SQLException e) {
					        e.printStackTrace();
					    }	
					}
					public void insertData() {
						// JDBC URL, username, and password of MySQL server
					    String host = "jdbc:mysql://localhost/hazajyabera_samuel_222003581";
					    String user = "root";
					    String password = "";

					    // SQL query to insert data
					    String sql = "INSERT INTO enrollment (Stu_id, Course_id, Enrollment_date,Status) VALUES (?,?,?,?)";
						
					    try (
					        // Establish the connection
					        Connection con = DriverManager.getConnection(host, user, password);

					        // Create a prepared statement
					    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
					    	    ) {
					        // Set the values for the prepared statement
					       preparedStatement.setString(1, this.Stu_id);
					       preparedStatement.setString(2, this.Course_id);
					        preparedStatement.setString(3, this. Enrollment_date);
					      

					        // Execute the query
					        int rowsAffected = preparedStatement.executeUpdate();

					        // Check the result
					        if (rowsAffected > 0) {
					        	System.out.println("Data inserted successfully!");
					            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
					        } else {
					            System.out.println("Failed to insert data.");
					            JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

					        }

					    } catch (SQLException e) {
					        e.printStackTrace();
					    }	
					}

					public void readwithID(int inputid) {
						// JDBC URL, username, and password of MySQL server
					    String url = "jdbc:mysql://localhost/hazajyabera_samuel_222003581";
					    String user = "root";
					    String password = "";

					    // SQL query to select all columns from Enrollment where id = ?
					    String sql = "SELECT * FROM enrollment WHERE Enrollment_id = ?";

					    try (
					        // Establish the connection
					        Connection connection = DriverManager.getConnection(url, user, password);

					        // Create a prepared statement
					        PreparedStatement preparedStatement = connection.prepareStatement(sql);
					    ) {
					        // Set the value for the parameterized query
					        //int EnrollmentId = 1; // Replace with the desired Enrollment id
					        //if()
					    	preparedStatement.setInt(1, inputid);

					        // Execute the query and get the result set
					        ResultSet resultSet = preparedStatement.executeQuery();

					        // Process the result set
					        while (resultSet.next()) {
					        	this.setEnrollment_id(resultSet.getInt("Enrollment_id"));
					           this.setStu_id(resultSet.getString("Stu_id"));
					           this.setCourse_id(resultSet.getString(" Course_id"));
					           this.setEnrollment_date(resultSet.getString(" Enrollment_date"));
					           
					            }

					    } catch (SQLException e) {
					        e.printStackTrace();
					    }
					}
					public void update(int inputEnrollmentid) {
						// JDBC URL, username, and password of MySQL server
					    String url = "jdbc:mysql://localhost/3306/hazajyabera_samuel_222003581";
					    String user = "root";
					    String password = "";

					    // SQL query to update data
					    String sql = "UPDATE enrollment SET  Stu_id= ?, Enrollment_date=?,  Course_id = ?,Status = ? WHERE Enrollment_id = ?";

					    try (
					        // Establish the co
					        Connection co = DriverManager.getConnection(url, user, password);

					        // Create a prepared statement
					        PreparedStatement tea = co.prepareStatement(sql);
					    ) {
					        // Set the new values for the update
					    	  tea.setString(1, this.getStu_id());
					    	 tea.setString(3, this.getEnrollment_date());
					    	 tea.setString(2, this.getCourse_id());
					        tea.setInt(4, inputEnrollmentid);
					        // Execute the update
					        int rowsAffected = tea.executeUpdate();

					        // Check the result
					        if (rowsAffected > 0) {
					            System.out.println("Data updated successfully!");
					        } else {
					            System.out.println("Failed to update data. No matching record found.");
					        }

					    } catch (SQLException e) {
					        e.printStackTrace();
					    }   
					}
					public void delete(int inputid) {
						// JDBC URL, username, and password of MySQL server
					    String url = "jdbc:mysql://localhost/hazajyabera_samuel_222003581";
					    String user = "root";
					    String password = "";

					    // SQL query to delete data
					    String sql = "DELETE FROM enrollment WHERE Enrollment_id = ?";

					    try (
					        // Establish the 
					        Connection co = DriverManager.getConnection(url, user, password);

					        // Create a prepared statement
					        PreparedStatement st = co.prepareStatement(sql);
					    ) {
					        // Set the value for the WHERE clause
					        st.setInt(1, inputid); // Assuming there is a column named 'id' for the WHERE clause

					        // Execute the delete
					        int rowsAffected = st.executeUpdate();

					        // Check the result
					        if (rowsAffected > 0) {
					            System.out.println("Data deleted successfully!");
					        } else {
					            System.out.println("Failed to delete data. No matching record found.");
					        }

					    } catch (SQLException e) {
					        e.printStackTrace();
					    }
					}
					}










