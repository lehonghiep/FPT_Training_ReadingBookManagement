package fa.edu.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fa.edu.util.DBConnection;
import fa.edu.pojo.*;
public class UserRepositoryImp implements UserRepository{
	
	@Override
	public POJO_User getProfile(int userID) {
		String sql = "SELECT First_Name, Last_Name, Gender, Birth_date, Image_Data, Email, Phone, Authority, ID, Username, Passwords\r\n" + 
				"	FROM Users JOIN Profiles ON Users.Profile_ID = Profiles.Profile_ID \r\n" + 
				"			JOIN Contact ON Users.Contact_ID = Contact.Contact_ID \r\n" + 
				"			JOIN Role ON Users.Role_ID = Role.Role_ID\r\n" + 
				"	WHERE ID = ?";
		POJO_User user = new POJO_User();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, userID);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String firstname = rs.getString("First_Name");
				String lastname = rs.getString("Last_Name"); 
				int gender = rs.getInt("Gender"); 
				String birthdate = rs.getString("Birth_Date"); 
				String email = rs.getString("Email"); 
				String phone = rs.getString("Phone");
				int userid = rs.getInt("UserID"); 
				String username = rs.getString("Username"); 
				String password = rs.getString("Passwords");
				user = new POJO_User(firstname, lastname, gender, birthdate, email, phone,
						userid, username, password);
			}
			return user;
		}
		catch (SQLException ex) {
	        ex.printStackTrace();
	        return user;
	    }

	}	
	
	public static void main(String[] args) {
		UserRepositoryImp ur1=new UserRepositoryImp();
		POJO_User user = ur1.getProfile(1);
		System.out.println(user);
		
	
	}
}
