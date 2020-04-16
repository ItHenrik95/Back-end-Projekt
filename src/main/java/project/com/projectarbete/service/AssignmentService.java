package project.com.projectarbete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import project.com.projectarbete.dataserver.AssignmentServer;
import project.com.projectarbete.list.Assignment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// could have used @Component instead of @Service. But I read that it is better to be more specific when you use annotations
@Service
public class AssignmentService {

  //calling for the AssignmentServer from the package dataserver
 private final AssignmentServer assignmentServer;

  @Autowired
  //Qualifier is used to quickly change between DB by only changing the class.
  public AssignmentService(@Qualifier("MySql") AssignmentServer assignmentServer) {
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

  public Optional<Assignment> getAssignmentById(UUID id){
    return assignmentServer.selectAllById(id);
  }
    //Method to delete an assignemnt
  public int deleteAssignment(UUID id){
    return assignmentServer.deleteAssignment(id);
  }
}
