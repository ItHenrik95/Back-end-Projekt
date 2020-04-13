package project.com.projectarbete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import project.com.projectarbete.dataserver.AssignmentServer;
import project.com.projectarbete.list.Assignment;

import java.util.List;

// could have used @Component instead of @Service. But I read that it is better to be more specific when you use annotations
@Service
public class AssignmentService {

  //calling for the AssignmentServer from the package dataserver
 private final AssignmentServer assignmentServer;

  @Autowired
  //Qualifier is used to quickly change between servers by only changing the interface. Might need to fix(delete) this later but it is here for now so that I know that my HTTP requests works
  public AssignmentService(@Qualifier("dataServer") AssignmentServer assignmentServer) {
    this.assignmentServer = assignmentServer;
  }
   // adding an assignment to the list using a constructor
  public int addAssignment(Assignment assignment){

    return assignmentServer.insertAssignment(assignment);
  }
  //Retrieving the list from DB
  public List<Assignment> getAllAssignments(){
    return assignmentServer.SelectAllAssignments();
  }
}
