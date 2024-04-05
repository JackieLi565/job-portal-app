package com.workwise.userservice.repository;

import com.workwise.userservice.common.DatabaseConnection;
import com.workwise.userservice.model.Role;
import com.workwise.userservice.model.UserData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDataRepository {
    public static Optional<UserData> findByEmail(String userEmail) throws SQLException {
        String query = "SELECT * FROM user WHERE user.email = ?";

        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, userEmail);

            ResultSet rs = statement.getResultSet();
            if (rs.next()) {
                return Optional.of(getUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public static UserData getUser(ResultSet rs) throws SQLException {
        String id = rs.getString("user_id");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String fName = rs.getString("f_name");
        String lName = rs.getString("l_name");
        String image = rs.getString("image");

        if (password == null) {
            return new UserData(Role.OAUTH, id, email, fName, lName, image);
        } else {
            return new UserData(Role.EMAIL_PASSWORD, id, email, password, fName, lName, image);
        }
    }
}
