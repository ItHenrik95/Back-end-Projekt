package project.com.projectarbete.dataserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import project.com.projectarbete.list.Assignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MySql")
@Configuration
public class MySqlDataAccess implements AssignmentServer {

  @Autowired
  private JdbcTemplate jdbcTemplate;


  @Override
  public int insertAssignment(UUID id, Assignment assignment) {
    return 0;
  }
  //Selects the id and assignment from the databas and gives it back so we can read it.
  @Override
  public List<Assignment> SelectAllAssignments() {
    //SELECT * FROM table_name
    final String sql = "SELECT id, assignment FROM assignment";
    List<Assignment> assignments = jdbcTemplate.query(sql, new RowMapper<Assignment>() {
      @Override
      public Assignment mapRow(ResultSet resultSet, int i) throws SQLException {
        Assignment assignment = new Assignment();
        assignment.setId((UUID) resultSet.getObject("id"));
        assignment.setAssignment(resultSet.getString("assignment"));

        return assignment;
      }
    });
    return assignments;
  }

  @Override
  public Optional<Assignment> selectAllById(UUID id) {
    return Optional.empty();
  }

  @Override
  public int deleteAssignment(UUID id) {
    return 0;
  }
}
