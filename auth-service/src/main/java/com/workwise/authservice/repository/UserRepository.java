package com.workwise.authservice.repository;

import com.workwise.authservice.common.DatabaseConnection;
import com.workwise.authservice.model.Role;
import com.workwise.authservice.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository {

    public static Optional<User> findUserByEmail(String email) {
        PreparedStatement preparedStatement;
        try {
            String query = String.format("select * from user where email = '%s'", email);
            Connection connection = DatabaseConnection.getInstance();
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String uid = resultSet.getString("user_id");
                String fName = resultSet.getString("f_name");
                String lName = resultSet.getString("l_name");
                String uEmail = resultSet.getString("email");
                String password = resultSet.getString("password");
                String imageURL = resultSet.getString("image");

                if (password == null) return Optional.of(new User(uid, uEmail, fName, lName, Role.OAUTH, imageURL));

                return Optional.of(new User(uid, uEmail, fName, lName, Role.EMAIL_PASSWORD, imageURL));
            }

            return Optional.empty();
        } catch (SQLException e) {
            return Optional.empty();
        }
    }
}
