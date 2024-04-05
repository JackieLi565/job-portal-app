package com.workwise.userservice.repository;

import com.workwise.userservice.common.DatabaseConnection;
import com.workwise.userservice.model.Candidate;
import com.workwise.userservice.model.UserData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CandidateRepository {
    /**
     * @param id userId, returns candidate data
     */
    public static Optional<Candidate> findCandidateById(String id) {
        String query = "select * from candidate c join user u on c.FK_user = u.user_id where u.user_id = ?";

        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getCandidate(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public static Candidate getCandidate(ResultSet resultSet) throws SQLException {
        UserData user = UserDataRepository.getUser(resultSet);

        String id = resultSet.getString("candidate_id");
        String experience = resultSet.getString("experience");
        String skills = resultSet.getString("skills");
        String description = resultSet.getString("description");
        boolean searchable = resultSet.getBoolean("searchable");

        return new Candidate(user, id, experience, skills, description, searchable);
    }
}
