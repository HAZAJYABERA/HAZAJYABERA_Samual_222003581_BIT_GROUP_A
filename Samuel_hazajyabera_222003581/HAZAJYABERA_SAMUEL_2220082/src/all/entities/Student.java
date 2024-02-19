package all.entities;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Student  {
	private int Stu_id;
	private String Student_name;
	private String Email;
	private String Course_name;
	private String contact;
	private Object Gender;
	private String Enrollment_date;
	private String Nationality;
	private String date_of_birth;
	private String  Parents;
	public Student() {}
	public Student(int Stu_id, String student_name , String Email, String telephone, String course_name , Object gender ,String Enrollment_date,String Nationality,String date_of_birth,String Parents ) {
		super();
		this. Stu_id =  Stu_id;
		this.Student_name = student_name;
		this.Email = Email;
		this.Course_name = course_name;
		this.contact = telephone;
		this.Gender=gender;
		this.Enrollment_date=Enrollment_date;
		this.Nationality=Nationality;
		this.date_of_birth=date_of_birth;
		this.Parents=Parents;
	}
	
	public Object getGender() {
		return Gender;
	}
	public void setGender(Object gender) {
		Gender = gender;
	}
	public Student( String stname, String email, String coursename, String telephone,Object gender, String enrollementdate,String nationality,String date_of_birth,String parents) {
		this.Student_name = stname;
		this.Email = email;
		this.Course_name = coursename;
		this.contact= telephone;
		this.Gender=gender;
		this.Enrollment_date=enrollementdate;
		this.Nationality=nationality;
		this.date_of_birth=date_of_birth;
		this.Parents=parents;
	}
	
	
	public int getStu_id() {
		return Stu_id;
	}
	public void setStu_id(int stu_id) {
		Stu_id = stu_id;
	}
	public String getStudent_name() {
		return Student_name;
	}
	public void setStudent_name(String student_name) {
		Student_name = student_name;
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
	public String getEnrollment_date() {
		return Enrollment_date;
	}
	public void setEnrollment_date(String enrollment_date) {
		Enrollment_date = enrollment_date;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getParents() {
		return Parents;
	}
	public void setParents(String parents) {
		Parents = parents;
	}
	public void makeconnection() {
	}
	public void insertData(String st_n,String e_m, String te_ne,Date dob,String ge_r,String national,String gender,String cou_na,Date enro_da,String pa_nt) {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/hazajyabera_samuel_222003581";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
String sql = "INSERT INTO Student (Student_name,Email,Telephone,Date_of_birth,Nationality,Gender,Course_name,Enrollment_date,Parents) VALUES (?, ?, ?, ?,?,?,?,?,?)";
	
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
				   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, st_n);
	        preparedStatement.setString(2, e_m);
	        preparedStatement.setString(3, te_ne);
	        preparedStatement.setDate(4, dob);
	        preparedStatement.setString(5, national);
	        preparedStatement.setString(6, ge_r);
	        preparedStatement.setString(7, cou_na);
	        preparedStatement.setDate(8, enro_da);
	        preparedStatement.setString(9, pa_nt);
	        
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
	    String sql = "INSERT INTO Student (Student_name,Email,Telephone,Date_of_birth,Nationality,Gender,Course_name,Enrollment_date,Parents) VALUES (?, ?, ?, ?,?,?,?,?,?)";
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.Student_name);
	        preparedStatement.setString(2, this.Email);
	        preparedStatement.setString(3, this.contact);
	        preparedStatement.setString(4, this.date_of_birth);
	        preparedStatement.setObject(5, (String) this.Gender);
	        preparedStatement.setString(6, this.Nationality);
	        preparedStatement.setString(7,this.Course_name);
	        preparedStatement.setString(6, this.Enrollment_date);
	        preparedStatement.setString(7,this.Parents);
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

	    // SQL query to select all columns from student where id = ?
	    String sql = "SELECT * FROM students WHERE stu_id = ?";

	    try (
	        // Establish the connection
	        Connection connection = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    ) {
	        // Set the value for the parameterized query
	        //int studentId = 1; // Replace with the desired student id
	        //if()
	    	preparedStatement.setInt(1, inputid);

	        // Execute the query and get the result set
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // Process the result set
	        while (resultSet.next()) {
	        	this.setStu_id(resultSet.getInt("Stu_id"));
	           this.setStudent_name(resultSet.getString("student_name"));
	           this.setEmail(resultSet.getString("Email"));
	           this.setContact(resultSet.getString("Telephone"));
	            this.setDate_of_birth(resultSet.getString("date_of_birth"));
	            this.setGender(resultSet.getString("Gender"));
	            this.setCourse_name(resultSet.getString("Course_name"));
	            this.setNationality(resultSet.getString("Nationality"));
	            this.setEnrollment_date(resultSet.getString("Enrollment_date"));
	            this.setParents(resultSet.getString("parents"));
	            }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void update(int inputstudentid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/hazajyabera_samuel_222003581";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE students SET  student_name= ?, Email = ?,Telephone = ?, Date_of_birth = ?, Nationality=?,Gender=?,Course_name=?,Enrollment_date=?,Parents=? WHERE Stu_id = ?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement st = co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  st.setString(1, this.getStudent_name());
	        st.setString(2, this.getEmail());
	       st.setString(3, this.getContact()); // Assuming there is a column named 'id' for the WHERE clause
	        st.setString(4, this.getDate_of_birth());
	        st.setObject(5, this.getGender());
	        st.setString(6, this.getNationality());
	        st.setString(7, this.getCourse_name());
	        st.setString(8, this.getEnrollment_date());
	        st.setString(9, this.getParents());
	        st.setInt(10, inputstudentid);
	        // Execute the update
	        int rowsAffected = st.executeUpdate();

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
	    String sql = "DELETE FROM students WHERE stu_id = ?";

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


