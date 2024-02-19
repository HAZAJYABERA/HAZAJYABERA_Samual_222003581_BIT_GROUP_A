package all.entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Class{
				private int Class_id;
				private String Class_level;
				private String Location;
				private String Year;
				private String started_date;
				private String ended_date;
			   public Class() {}
				public Class(int Class_id, String Class_level ,String Location, String Year, String started_date,String ended  ) {
					super();
					this. Class_id =  Class_id;
					this.Class_level = Class_level;
					this.Year = Year;
					this.Location = Location;
					this.started_date = started_date;
					this.ended_date = ended;
					
				}
				public Class( String Class_level, String Year, String Location, String started_date,String ended) {
					this.Class_level = Class_level;
					this.Year = Year;
					this.Location = Location;
					this.started_date= started_date;
					this.ended_date= ended;
					
				}
		
			
				public int getClass_id() {
					return Class_id;
				}
				public void setClass_id(int class_id) {
					Class_id = class_id;
				}
				public String getClass_level() {
					return Class_level;
				}
				public void setClass_level(String class_level) {
					Class_level = class_level;
				}
				public String getLocation() {
					return Location;
				}
				public void setLocation(String location) {
					Location = location;
				}
				public String getYear() {
					return Year;
				}
				public void setYear(String year) {
					Year = year;
				}
				public String getStarted_date() {
					return started_date;
				}
				public void setStarted_date(String started_date) {
					this.started_date = started_date;
				}
				public String getEnded_date() {
					return ended_date;
				}
				public void setEnded_date(String ended_date) {
					this.ended_date = ended_date;
				}
				public void makeconnection() {
				}
				public void insertData(String cl_le, String loc,String year,String started,String ended) {
					// JDBC URL, username, and password of MySQL server
				    String host = "jdbc:mysql://localhost/hazajyabera_samuel_222003581";
				    String user = "root";
				    String password = "";

				    // SQL query to insert data
			String sql = "INSERT INTO classes (Class_level,Location,Year,started_date,ended_date) VALUES (?,?,?,?,?)";
				
				    try (
				        // Establish the connection
				        Connection con = DriverManager.getConnection(host, user, password);

				        // Create a prepared statement
							   PreparedStatement preparedStatement = con.prepareStatement(sql);
				    	    ) {
				        // Set the values for the prepared statement
				       preparedStatement.setString(1, cl_le);
				       preparedStatement.setString(2, loc);
				        preparedStatement.setString(3, year);
				        preparedStatement.setString(4, started);
				        preparedStatement.setString(5, ended);

				        
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
				    String sql = "INSERT INTO classes (Class_level,Location,Year,started_date, ended_date) VALUES (?,?,?,?,?)";
					
				    try (
				        // Establish the connection
				        Connection con = DriverManager.getConnection(host, user, password);

				        // Create a prepared statement
				    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
				    	    ) {
				        // Set the values for the prepared statement
				       preparedStatement.setString(1, this.Class_level);
				       preparedStatement.setString(2,this.Location);
				     preparedStatement.setString(3, this.Year);
				        preparedStatement.setString(4, this.started_date);
				        preparedStatement.setString(5, this.ended_date);

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

				    // SQL query to select all columns from Class where id = ?
				    String sql = "SELECT * FROM classes WHERE Class_id = ?";

				    try (
				        // Establish the connection
				        Connection connection = DriverManager.getConnection(url, user, password);

				        // Create a prepared statement
				        PreparedStatement preparedStatement = connection.prepareStatement(sql);
				    ) {
				        // Set the value for the parameterized query
				        //int ClassId = 1; // Replace with the desired Class id
				        //if()
				    	preparedStatement.setInt(1, inputid);

				        // Execute the query and get the result set
				        ResultSet resultSet = preparedStatement.executeQuery();

				        // Process the result set
				        while (resultSet.next()) {
				        	this.setClass_id(resultSet.getInt("Class_id"));
				           this.setClass_level(resultSet.getString("Class_level"));
				           this.setStarted_date(resultSet.getString("started_date"));
				           this.setYear(resultSet.getString("Year"));
				           this.setClass_level(resultSet.getString("Location"));
				           this.setEnded_date(resultSet.getString("ended_date"));
				            }

				    } catch (SQLException e) {
				        e.printStackTrace();
				    }
				}
				public void update(int inputClassid) {
					// JDBC URL, username, and password of MySQL server
				    String url = "jdbc:mysql://localhost/3306/hazajyabera_samuel_222003581";
				    String user = "root";
				    String password = "";

				    // SQL query to update data
				    String sql = "UPDATE classes SET  Class_level= ?,Location=?, Year = ?,started_date = ?, ended_date=? WHERE Class_id = ?";

				    try (
				        // Establish the co
				        Connection co = DriverManager.getConnection(url, user, password);

				        // Create a prepared statement
				        PreparedStatement statement = co.prepareStatement(sql);
				    ) {
				        // Set the new values for the update
				    	  statement.setString(1, this.getClass_level());
				    	 statement.setString(2, this.getLocation());
				    	 statement.setString(3, this.getYear());
				        statement.setString(4, this.getStarted_date());
				        statement.setString(5, this.getEnded_date());
				        statement.setInt(6, inputClassid);
				        // Execute the update
				        int rowsAffected = statement.executeUpdate();

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
				    String sql = "DELETE FROM classs WHERE Class_id = ?";

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








