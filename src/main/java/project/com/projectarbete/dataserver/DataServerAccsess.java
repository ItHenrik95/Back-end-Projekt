package project.com.projectarbete.dataserver;

import org.springframework.stereotype.Repository;
import project.com.projectarbete.list.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
// could have used @Component instead of @Repository. But I read that it is better to be more specific when you use annotations
/*@Repository("dataServer")
public class DataServerAccsess implements AssignmentServer{
  //creating a list that we can store the assignments in!
  private static List<Assignment> DB = new ArrayList<>();

  @Override
  public int insertAssignment(UUID id, Assignment assignment) {
    //returning 1 so that we know that the insertion works!
    DB.add(new Assignment(id, assignment.getAssignment()));
    return 1;
  }
  //Retreving all assignments from the DB
  @Override
  public List<Assignment> SelectAllAssignments() {
    return DB;
  }
  // Filters threw the assignment and returns the first id it gets.
  @Override
  public Optional<Assignment> selectAllById(UUID id) {
    return DB.stream()
      .filter(assignment -> assignment.getId().equals(id))
      .findFirst();
  }
  // if the assignment is there delete it or else return 0.
  @Override
  public int deleteAssignment(UUID id) {
    Optional<Assignment> maybeFoundId = selectAllById(id);
    if (maybeFoundId.isEmpty()){
      return 0;
    }
    DB.remove(maybeFoundId.get());
    return 1;
  }

}*/
