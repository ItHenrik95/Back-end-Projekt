package project.com.projectarbete.dataserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import project.com.projectarbete.list.Assignment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository("MySql")
@Configuration
public class MySqlDataAccess implements AssignmentServer {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  // RowMapper class so I dont have to write the same sql statements over and over again.
  private static class AssignmentRowMapper implements RowMapper<Assignment>{

    @Override
    public Assignment mapRow(ResultSet resultSet, int i) throws SQLException {
      Assignment assignment = new Assignment();
      assignment.setId(resultSet.getInt("id"));
      assignment.setAssignment(resultSet.getString("assignment"));

      return assignment;
    }
  }
  //Inserts/adds and Assignment
  public int insertAssignment(int id, Assignment assignment) {
    //INSERT INTO table_name (column1, column2, column3,...)
    //VALUES (value1, value2, value3,...)
    final String sql = "INSERT INTO assignments(id,assignment)VALUES (?,?)";
    final String task = assignment.getAssignment();
    
    jdbcTemplate.update(sql, new Object[] {id,task});
    return 1;
  }
  //Selects all of the id and assignment from the databas.
  @Override
  public List<Assignment> SelectAllAssignments() {
    //SELECT * FROM table_name
    final String sql = "SELECT id, assignment FROM assignments";
    List<Assignment> assignments = jdbcTemplate.query(sql, new AssignmentRowMapper());
    return assignments;
  }
    // Selects the id form the databas in case we wanna look for a specific id.
  @Override
  public Assignment selectAssignmentById(int id) {
    //SELECT column_name FROM table_name where column = value
    //? = id.
    final String sql = "SELECT id, assignment FROM assignments where id = ?";
      Assignment assignment =  jdbcTemplate.queryForObject(sql, new AssignmentRowMapper(),id);
    return assignment;
  }
  //Delets and assignment
  @Override
  public int deleteAssignment(int id) {
    //DELETE FROM table_name
    //WHERE some_column = some_value
    jdbcTemplate.update("DELETE FROM assignments WHERE id = ?", id);
    return 1;
  }
}
