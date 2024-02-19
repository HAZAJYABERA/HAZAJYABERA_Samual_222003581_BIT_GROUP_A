package all.entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Library {
		private int Book_id;
						private String Title;
						private String  Publication_year;
						private String  Author;
					
					
						public Library() {}
						public Library(int Book_id, String Title , String  Publication_year, String  Author ) {
							super();
							this. Book_id =  Book_id;
							this.Title = Title;
							this. Publication_year =  Publication_year;
							this. Author =  Author;
						
							
							
						}
						public Library( String Title, String  Publication_year, String  Author) {
							this.Title = Title;
							this. Publication_year =  Publication_year;
							this. Author =  Author;
							
							}
					
				
						public int getBook_id() {
							return Book_id;
						}
						public void setBook_id(int book_id) {
							Book_id = book_id;
						}
						public String getTitle() {
							return Title;
						}
						public void setTitle(String title) {
							Title = title;
						}
						public String getPublication_year() {
							return Publication_year;
						}
						public void setPublication_year(String publication_year) {
							Publication_year = publication_year;
						}
						public String getAuthor() {
							return Author;
						}
						public void setAuthor(String author) {
							Author = author;
						}
						public void makeconnection() {
						}
						public void insertData(String title, String year,String auth) {
							// JDBC URL, username, and password of MySQL server
						    String host = "jdbc:mysql://localhost/hazajyabera_samuel_222003581";
						    String user = "root";
						    String password = "";

						    // SQL query to insert data
					String sql = "INSERT INTO Library (Title, Author, Publication_year,Department) VALUES (?,?,?,?)";
						
						    try (
						        // Establish the connection
						        Connection con = DriverManager.getConnection(host, user, password);

						        // Create a prepared statement
									   PreparedStatement preparedStatement = con.prepareStatement(sql);
						    	    ) {
						        // Set the values for the prepared statement
						       preparedStatement.setString(1, title);
						       preparedStatement.setString(2, year);
						        preparedStatement.setString(3, auth);
						       

						        
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
						    String sql = "INSERT INTO librarys (Title, Publication_year, Author) VALUES (?,?,?)";
							
						    try (
						        // Establish the connection
						        Connection con = DriverManager.getConnection(host, user, password);

						        // Create a prepared statement
						    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
						    	    ) {
						        // Set the values for the prepared statement
						       preparedStatement.setString(1, this.Title);
						       preparedStatement.setString(2, this.Publication_year);
						        preparedStatement.setString(3, this. Author);
						      

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

						    // SQL query to select all columns from Library where id = ?
						    String sql = "SELECT * FROM librarys WHERE Book_id = ?";

						    try (
						        // Establish the connection
						        Connection connection = DriverManager.getConnection(url, user, password);

						        // Create a prepared statement
						        PreparedStatement preparedStatement = connection.prepareStatement(sql);
						    ) {
						        // Set the value for the parameterized query
						        //int LibraryId = 1; // Replace with the desired Library id
						        //if()
						    	preparedStatement.setInt(1, inputid);

						        // Execute the query and get the result set
						        ResultSet resultSet = preparedStatement.executeQuery();

						        // Process the result set
						        while (resultSet.next()) {
						        	this.setBook_id(resultSet.getInt("Book_id"));
						           this.setTitle(resultSet.getString("Title"));
						           this.setPublication_year(resultSet.getString(" Publication_year"));
						           this.setAuthor(resultSet.getString(" Author"));
						           
						            }

						    } catch (SQLException e) {
						        e.printStackTrace();
						    }
						}
						public void update(int inputLibraryid) {
							// JDBC URL, username, and password of MySQL server
						    String url = "jdbc:mysql://localhost/3306/hazajyabera_samuel_222003581";
						    String user = "root";
						    String password = "";

						    // SQL query to update data
						    String sql = "UPDATE librarys SET  Title= ?, Author=?,  Publication_year = ?,Status = ? WHERE Book_id = ?";

						    try (
						        // Establish the co
						        Connection co = DriverManager.getConnection(url, user, password);

						        // Create a prepared statement
						        PreparedStatement tea = co.prepareStatement(sql);
						    ) {
						        // Set the new values for the update
						    	  tea.setString(1, this.getTitle());
						    	 tea.setString(3, this.getAuthor());
						    	 tea.setString(2, this.getPublication_year());
						        tea.setInt(4, inputLibraryid);
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
						    String sql = "DELETE FROM librarys WHERE Book_id = ?";

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











