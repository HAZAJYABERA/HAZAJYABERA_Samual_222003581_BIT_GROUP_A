package all.entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Attendance {

				private int Attendance_id;
				private String Stu_id;
				private String  Class_id;
				private String  Attendance_date;
				private String    Status;
			
				public Attendance() {}
				public Attendance(int Attendance_id, String Stu_id , String  Class_id, String Status, String  Attendance_date ) {
					super();
					this. Attendance_id =  Attendance_id;
					this.Stu_id = Stu_id;
					this. Class_id =  Class_id;
					this. Attendance_date =  Attendance_date;
					this.Status =Status;
					
					
				}
				public Attendance( String Stu_id, String  Class_id, String  Attendance_date, String Status) {
					this.Stu_id = Stu_id;
					this. Class_id =  Class_id;
					this. Attendance_date =  Attendance_date;
					this.Status=Status;
					}
			
				public int getAttendance_id() {
					return Attendance_id;
				}
				public void setAttendance_id(int attendance_id) {
					Attendance_id = attendance_id;
				}
				public String getStu_id() {
					return Stu_id;
				}
				public void setStu_id(String stu_id) {
					Stu_id = stu_id;
				}
				public String getClass_id() {
					return Class_id;
				}
				public void setClass_id(String class_id) {
					Class_id = class_id;
				}
				public String getAttendance_date() {
					return Attendance_date;
				}
				public void setAttendance_date(String attendance_date) {
					Attendance_date = attendance_date;
				}
				public String getStatus() {
					return Status;
				}
				public void setStatus(String status) {
					Status = status;
				}
				public void makeconnection() {
				}
				
				public void insertData() {
					// JDBC URL, username, and password of MySQL server
				    String host = "jdbc:mysql://localhost/hazajyabera_samuel_222003581";
				    String user = "root";
				    String password = "";

				    // SQL query to insert data
				    String sql = "INSERT INTO attendance (Stu_id,Class_id,Attendance_date,Status) VALUES (?,?,?,?)";
					
				    try (
				        // Establish the connection
				        Connection con = DriverManager.getConnection(host, user, password);

				        // Create a prepared statement
				    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
				    	    ) {
				        // Set the values for the prepared statement
				       preparedStatement.setString(1, this.Stu_id);
				       preparedStatement.setString(2, this.Class_id);
				        preparedStatement.setString(3, this. Attendance_date);
				       preparedStatement.setString(4,this.Status);

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

				    // SQL query to select all columns from Attendance where id = ?
				    String sql = "SELECT * FROM attendance WHERE Attendance_id = ?";

				    try (
				        // Establish the connection
				        Connection connection = DriverManager.getConnection(url, user, password);

				        // Create a prepared statement
				        PreparedStatement preparedStatement = connection.prepareStatement(sql);
				    ) {
				        // Set the value for the parameterized query
				        //int AttendanceId = 1; // Replace with the desired Attendance id
				        //if()
				    	preparedStatement.setInt(1, inputid);

				        // Execute the query and get the result set
				        ResultSet resultSet = preparedStatement.executeQuery();

				        // Process the result set
				        while (resultSet.next()) {
				        	this.setAttendance_id(resultSet.getInt("Attendance_id"));
				           this.setStu_id(resultSet.getString("Stu_id"));
				           this.setStatus(resultSet.getString("Status"));
				           this.setClass_id(resultSet.getString(" Class_id"));
				           this.setAttendance_date(resultSet.getString(" Attendance_date"));
				           
				            }

				    } catch (SQLException e) {
				        e.printStackTrace();
				    }
				}
				public void update(int inputAttendanceid) {
					// JDBC URL, username, and password of MySQL server
				    String url = "jdbc:mysql://localhost/3306/hazajyabera_samuel_222003581";
				    String user = "root";
				    String password = "";

				    // SQL query to update data
				    String sql = "UPDATE attendance SET  Stu_id= ?, Attendance_date=?,  Class_id = ?,Status = ? WHERE Attendance_id = ?";

				    try (
				        // Establish the co
				        Connection co = DriverManager.getConnection(url, user, password);

				        // Create a prepared statement
				        PreparedStatement tea = co.prepareStatement(sql);
				    ) {
				        // Set the new values for the update
				    	  tea.setString(1, this.getStu_id());
				    	 tea.setString(3, this.getAttendance_date());
				    	 tea.setString(2, this.getClass_id());
				        tea.setString(4, this.getStatus());
				        tea.setInt(5, inputAttendanceid);
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
				    String sql = "DELETE FROM attendance WHERE Attendance_id = ?";

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








