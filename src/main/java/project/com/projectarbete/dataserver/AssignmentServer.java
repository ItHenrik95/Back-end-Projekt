package project.com.projectarbete.dataserver;

import project.com.projectarbete.list.Assignment;

import java.util.List;


public interface AssignmentServer {

  int insertAssignment(int id, Assignment assignment);

  default int insertAssignment(Assignment assignment){
    // create a random id
    int id = 0;
    return insertAssignment(id,assignment);
  }

  List<Assignment> SelectAllAssignments();

  // Optional is to be able to use stream method.
  public Assignment selectAssignmentById(int id);

    // method for deleting an assignment by the ID.
  int deleteAssignment(int id);



}
