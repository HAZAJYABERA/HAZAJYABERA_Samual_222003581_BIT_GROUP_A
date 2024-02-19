package all.entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Teacher {
		private int Teacher_id;
		private String Teacher_name;
		private String Email;
		private String Course_name;
		private String contact;
		private String Office_hours;
		public Teacher() {}
		public Teacher(int Teacher_id, String Teacher_name , String Email, String telephone, String course_name  ,String Office_hours ) {
			super();
			this. Teacher_id =  Teacher_id;
			this.Teacher_name = Teacher_name;
			this.Email = Email;
			this.Course_name = course_name;
			this.contact = telephone;
			this.Office_hours=Office_hours;
			
		}
		public Teacher( String stname, String email, String coursename, String telephone,Object gender, String Office_hours) {
			this.Teacher_name = stname;
			this.Email = email;
			this.Course_name = coursename;
			this.contact= telephone;
			this.Office_hours=Office_hours;
			
		}
		public int getTeacher_id() {
			return Teacher_id;
		}
		public void setTeacher_id(int teacher_id) {
			Teacher_id = teacher_id;
		}
		public String getTeacher_name() {
			return Teacher_name;
		}
		public void setTeacher_name(String teacher_name) {
			Teacher_name = teacher_name;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getCourse_name() {
			return Course_name;
		}
		public void setCourse_name(String course_name) {
			Course_name = course_name;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public String getOffice_hours() {
			return Office_hours;
		}
		public void setOffice_hours(String office_hours) {
			Office_hours = office_hours;
		}
		public void makeconnection() {
		}
		public void insertData(String st_n, String te_ne,String e_m,String cou_na,String of_ha) {
			// JDBC URL, username, and password of MySQL server
		    String host = "jdbc:mysql://localhost/hazajyabera_samuel_222003581";
		    String user = "root";
		    String password = "";

		    // SQL query to insert data
	String sql = "INSERT INTO Teacher (Teacher_name,Contact,Email,Course_name,Office_hours) VALUES (?,?,?,?,?)";
		
		    try (
		        // Establish the connection
		        Connection con = DriverManager.getConnection(host, user, password);

		        // Create a prepared statement
					   PreparedStatement preparedStatement = con.prepareStatement(sql);
		    	    ) {
		        // Set the values for the prepared statement
		       preparedStatement.setString(1, st_n);
		       preparedStatement.setString(2, te_ne);
		        preparedStatement.setString(3, e_m);
		        preparedStatement.setString(4, cou_na);
		        preparedStatement.setString(5, of_ha);
		       ;
		        
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
		    String sql = "INSERT INTO teachers (Teacher_name,Contact,Email,Course_name,Office_hours) VALUES (?,?,?,?,?)";
		    try (
		        // Establish the connection
		        Connection con = DriverManager.getConnection(host, user, password);

		        // Create a prepared statement
		    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
		    	    ) {
		        // Set the values for the prepared statement
		       preparedStatement.setString(1, this.Teacher_name);
		       preparedStatement.setString(2, this.contact);
		        preparedStatement.setString(3, this.Email);
		       preparedStatement.setString(4,this.Course_name);
		        preparedStatement.setString(5, this.Office_hours);
		       
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

		    // SQL query to select all columns from Teacher where id = ?
		    String sql = "SELECT * FROM teachers WHERE Teacher_id = ?";

		    try (
		        // Establish the connection
		        Connection connection = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement preparedStatement = connection.prepareStatement(sql);
		    ) {
		        // Set the value for the parameterized query
		        //int TeacherId = 1; // Replace with the desired Teacher id
		        //if()
		    	preparedStatement.setInt(1, inputid);

		        // Execute the query and get the result set
		        ResultSet resultSet = preparedStatement.executeQuery();

		        // Process the result set
		        while (resultSet.next()) {
		        	this.setTeacher_id(resultSet.getInt("Teacher_id"));
		           this.setTeacher_name(resultSet.getString("Teacher_name"));
		           this.setContact(resultSet.getString("Contact"));
		           this.setEmail(resultSet.getString("Email"));
		           this.setCourse_name(resultSet.getString("Course_name"));
		            this.setOffice_hours(resultSet.getString("Office_hours"));
		            }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		public void update(int inputTeacherid) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/hazajyabera_samuel_222003581";
		    String user = "root";
		    String password = "";

		    // SQL query to update data
		    String sql = "UPDATE teachers SET  Teacher_name= ?, Email = ?,Contact = ?,Course_name=?,Office_hours=? WHERE Teacher_id= ?";

		    try (
		        // Establish the co
		        Connection co = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement tea = co.prepareStatement(sql);
		    ) {
		        // Set the new values for the update
		    	  tea.setString(1, this.getTeacher_name());
		    	  tea.setString(2, this.getContact());
		        tea.setString(3, this.getEmail());
		        tea.setString(4, this.getCourse_name());
		        tea.setString(5, this.getOffice_hours());
		        tea.setInt(6, inputTeacherid);
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
		    String sql = "DELETE FROM teachers WHERE Teacher_id = ?";

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




