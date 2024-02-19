package all.entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Payment {
			private int Payment_id;
			private int Stu_id;
			private String Payment_date;
			private String Payment_amaunt;
			private Object Payment_method;
			private String Status;
			public Payment() {}
			public Payment(int Payment_id, int Stu_id , String Payment_date, Object Payment_method, String Payment_amaunt  ,String Status ) {
				super();
				this. Payment_id =  Payment_id;
				this.Stu_id = Stu_id;
				this.Payment_date = Payment_date;
				this.Payment_amaunt = Payment_amaunt;
				this.Payment_method = Payment_method;
				this.Status=Status;
				
			}
			public Payment( int stid, String Payment_date, String payment_amount,Object  Payment_method, String Status) {
				this.Stu_id = stid;
				this.Payment_date = Payment_date;
				this.Payment_amaunt =  payment_amount;
				this.Payment_method= Payment_method;
				this.Status=Status;
				
			}
		
			public int getPayment_id() {
				return Payment_id;
			}
			public void setPayment_id(int payment_id) {
				Payment_id = payment_id;
			}
			public int getStu_id() {
				return Stu_id;
			}
			public void setStu_id(int stu_id) {
				Stu_id = stu_id;
			}
			public String getPayment_date() {
				return Payment_date;
			}
			public void setPayment_date(String payment_date) {
				Payment_date = payment_date;
			}
			public String getPayment_amaunt() {
				return Payment_amaunt;
			}
			public void setPayment_amaunt(String payment_amaunt) {
				Payment_amaunt = payment_amaunt;
			}
			public Object getPayment_method() {
				return Payment_method;
			}
			public void setPayment_method(Object payment_method) {
				Payment_method = payment_method;
			}
			public String getStatus() {
				return Status;
			}
			public void setStatus(String status) {
				Status = status;
			}
			public void makeconnection() {
			}
			public void insertData(int st_id, String pay_date,String pay_am,String pay_me,String ts_as) {
				// JDBC URL, username, and password of MySQL server
			    String host = "jdbc:mysql://localhost/hazajyabera_samuel_222003581";
			    String user = "root";
			    String password = "";

			    // SQL query to insert data
			    String sql = "INSERT INTO Payment (Stu_id,Payment_date,Payment_amaunt,Payment_method,Status) VALUES (?,?,?,?,?)";
			    try (
			        // Establish the connection
			        Connection con = DriverManager.getConnection(host, user, password);

			        // Create a prepared statement
						   PreparedStatement preparedStatement = con.prepareStatement(sql);
			    	    ) {
			        // Set the values for the prepared statement
			       preparedStatement.setInt(1, st_id);
			       preparedStatement.setString(2, pay_date);
			        preparedStatement.setString(3, pay_am);
			        preparedStatement.setObject(4, pay_me);
			        preparedStatement.setString(5, ts_as);
			       
			        
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
			    String sql = "INSERT INTO Payments (Stu_id, Payment_date, Payment_amaunt, Payment_method, Status) VALUES (?,?,?,?,?)";

			    try (
			        // Establish the connection
			        Connection con = DriverManager.getConnection(host, user, password);

			        // Create a prepared statement
			        PreparedStatement preparedStatement = con.prepareStatement(sql);
			    ) {
			        // Set the values for the prepared statement
			        preparedStatement.setInt(1, this.Stu_id);
			        preparedStatement.setObject(4, this.Payment_method);
			        preparedStatement.setString(2, this.Payment_date);
			        preparedStatement.setString(3, this.Payment_amaunt);
			        preparedStatement.setString(5, this.Status);

			        // Execute the query
			        int rowsAffected = preparedStatement.executeUpdate();

			        // Check the result
			        if (rowsAffected > 0) {
			            System.out.println("Data inserted successfully!");
			            JOptionPane.showMessageDialog(null, "Data inserted successfully!", "After insert", JOptionPane.INFORMATION_MESSAGE);
			        } else {
			            System.out.println("Failed to insert data.");
			            JOptionPane.showMessageDialog(null, "Failed to insert data.!", "After insert", JOptionPane.ERROR_MESSAGE);
			        }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }}


			public void readwithID(int inputid) {
				// JDBC URL, username, and password of MySQL server
			    String url = "jdbc:mysql://localhost/hazajyabera_samuel_222003581";
			    String user = "root";
			    String password = "";

			    // SQL query to select all columns from Payment where id = ?
			    String sql = "SELECT * FROM Payments WHERE Payment_id = ?";

			    try (
			        // Establish the connection
			        Connection connection = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement preparedStatement = connection.prepareStatement(sql);
			    ) {
			        // Set the value for the parameterized query
			        //int PaymentId = 1; // Replace with the desired Payment id
			        //if()
			    	preparedStatement.setInt(1, inputid);

			        // Execute the query and get the result set
			        ResultSet resultSet = preparedStatement.executeQuery();

			        // Process the result set
			        while (resultSet.next()) {
			        	this.setPayment_id(resultSet.getInt("Payment_id"));
			           this.setStu_id(resultSet.getInt("Stu_id"));
			           this.setPayment_method(resultSet.getString("Payment_method"));
			           this.setPayment_date(resultSet.getString("Payment_date"));
			           this.setPayment_amaunt(resultSet.getString("Payment_amaunt"));
			            this.setStatus(resultSet.getString("Status"));
			            }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			}
			public void update(int inputPaymentid) {
				// JDBC URL, username, and password of MySQL server
			    String url = "jdbc:mysql://localhost/hazajyabera_samuel_222003581";
			    String user = "root";
			    String password = "";

			    // SQL query to update data
			    String sql = "UPDATE Payment SET  Stu_id= ?, Payment_date = ?,Payment_method = ?,Payment_amaunt=?,Status=? WHERE Payment_id = ?";

			    try (
			        // Establish the co
			        Connection co = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement tea = co.prepareStatement(sql);
			    ) {
			        // Set the new values for the update
			    	  tea.setInt(1, this.getStu_id());
			    	  tea.setObject(4, this.getPayment_method());
			        tea.setString(2, this.getPayment_date());
			        tea.setString(3, this.getPayment_amaunt());
			        tea.setString(5, this.getStatus());
			        tea.setInt(6, inputPaymentid);
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
			    String sql = "DELETE FROM Payments WHERE Payment_id = ?";

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

