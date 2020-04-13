package project.com.projectarbete.dataserver;

import org.springframework.stereotype.Repository;
import project.com.projectarbete.list.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
// could have used @Component instead of @Repository. But I read that it is better to be more specific when you use annotations
@Repository("dataServer")
public class DataServerAccsess implements AssignmentServer{
  //creating a list that we can store the assignments in!
  private static List<Assignment> DB = new ArrayList<>();

  @Override
  public int insertAssignment(UUID id, Assignment assignment) {
    //returning 1 so that we know that the insertion works!
    DB.add(new Assignment(id, assignment.getAssignment()));
    return 1;
  }
}
