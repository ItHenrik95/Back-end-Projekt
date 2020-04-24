package project.com.projectarbete.dataserver;

import project.com.projectarbete.list.Assignment;

import java.util.List;


public interface AssignmentServer {

  int insertAssignment(int id, Assignment assignment);

  default int insertAssignment(Assignment assignment){
    int id = 0;
    return insertAssignment(id,assignment);
  }

  List<Assignment> SelectAllAssignments();

  public Assignment selectAssignmentById(int id);

    // method for deleting an assignment by the ID.
  int deleteAssignment(int id);



}
