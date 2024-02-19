package all.entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Course {
			private int Course_id;
			private String Course_name;
			private String Credit;
			private String Course_code;
			private String Department;
		
			public Course() {}
			public Course(int Course_id, String Course_name , String Credit, String Department, String Course_code ) {
				super();
				this. Course_id =  Course_id;
				this.Course_name = Course_name;
				this.Credit = Credit;
				this.Course_code = Course_code;
				this.Department = Department;
				
				
			}
			public Course( String course_name, String Credit, String Course_code, String Department) {
				this.Course_name = course_name;
				this.Credit = Credit;
				this.Course_code = Course_code;
				this.Department= Department;
				
				
			}
		
			public int getCourse_id() {
				return Course_id;
			}
			public void setCourse_id(int course_id) {
				Course_id = course_id;
			}
			public String getCourse_name() {
				return Course_name;
			}
			public void setCourse_name(String course_name) {
				Course_name = course_name;
			}
			public String getCredit() {
				return Credit;
			}
			public void setCredit(String credit) {
				Credit = credit;
			}
			public String getCourse_code() {
				return Course_code;
			}
			public void setCourse_code(String course_code) {
				Course_code = course_code;
			}
			public String getDepartment() {
				return Department;
			}
			public void setDepartment(String department) {
				Department = department;
			}
			public void makeconnection() {
			}
			public void insertData(String cou_n, String cou_de,String cr_t,String de_nt) {
				// JDBC URL, username, and password of MySQL server
			    String host = "jdbc:mysql://localhost/hazajyabera_samuel_222003581";
			    String user = "root";
			    String password = "";

			    // SQL query to insert data
		String sql = "INSERT INTO Course (Course_name,Course_code,Credit,Department) VALUES (?,?,?,?)";
			
			    try (
			        // Establish the connection
			        Connection con = DriverManager.getConnection(host, user, password);

			        // Create a prepared statement
						   PreparedStatement preparedStatement = con.prepareStatement(sql);
			    	    ) {
			        // Set the values for the prepared statement
			       preparedStatement.setString(1, cou_n);
			       preparedStatement.setString(2, cou_de);
			        preparedStatement.setString(3, cr_t);
			        preparedStatement.setString(4, de_nt);
			       

			        
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
			    String sql = "INSERT INTO Course (Course_name,Course_code,Credit,Department) VALUES (?,?,?,?)";
				
			    try (
			        // Establish the connection
			        Connection con = DriverManager.getConnection(host, user, password);

			        // Create a prepared statement
			    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
			    	    ) {
			        // Set the values for the prepared statement
			       preparedStatement.setString(1, this.Course_name);
			       preparedStatement.setString(2, this.Department);
			        preparedStatement.setString(3, this.Credit);
			       preparedStatement.setString(4,this.Course_name);

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

			    // SQL query to select all columns from Course where id = ?
			    String sql = "SELECT * FROM courses WHERE Course_id = ?";

			    try (
			        // Establish the connection
			        Connection connection = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement preparedStatement = connection.prepareStatement(sql);
			    ) {
			        // Set the value for the parameterized query
			        //int CourseId = 1; // Replace with the desired Course id
			        //if()
			    	preparedStatement.setInt(1, inputid);

			        // Execute the query and get the result set
			        ResultSet resultSet = preparedStatement.executeQuery();

			        // Process the result set
			        while (resultSet.next()) {
			        	this.setCourse_id(resultSet.getInt("Course_id"));
			           this.setCourse_name(resultSet.getString("Course_name"));
			           this.setDepartment(resultSet.getString("Department"));
			           this.setCredit(resultSet.getString("Credit"));
			           this.setCourse_name(resultSet.getString("Course_code"));
			           
			            }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			}
			public void update(int inputCourseid) {
				// JDBC URL, username, and password of MySQL server
			    String url = "jdbc:mysql://localhost/3306/hazajyabera_samuel_222003581";
			    String user = "root";
			    String password = "";

			    // SQL query to update data
			    String sql = "UPDATE Course SET  Course_name= ?,Course_code=?, Credit = ?,Department = ? WHERE Course_id = ?";

			    try (
			        // Establish the co
			        Connection co = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement tea = co.prepareStatement(sql);
			    ) {
			        // Set the new values for the update
			    	  tea.setString(1, this.getCourse_name());
			    	 tea.setString(2, this.getCourse_code());
			    	 tea.setString(3, this.getCredit());
			        tea.setString(4, this.getDepartment());
			        tea.setInt(5, inputCourseid);
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
			    String sql = "DELETE FROM courses WHERE Course_id = ?";

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






