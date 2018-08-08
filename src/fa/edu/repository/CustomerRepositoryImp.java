package fa.edu.repository;

import fa.edu.model.Users;
import fa.edu.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImp implements CustomerRepository {
    @Override
    public Users login(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM USER WHERE Username=(?) AND PASSWORD=(?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            Users user=null;
            if (rs.next()) {
                user=new Users();
                user.setId(rs.getInt("ID"));
                user.setProfileID(rs.getInt("Profile_ID"));
                user.setContactID(rs.getInt("Contact_ID"));
                user.setRoleID(rs.getInt("Role_ID"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
