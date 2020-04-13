package project.com.projectarbete.dataserver;

import project.com.projectarbete.list.Assignment;

import java.util.List;
import java.util.UUID;

public interface AssignmentServer {

  int insertAssignment(UUID id, Assignment assignment);

  default int insertAssignment(Assignment assignment){
    // create a random id
    UUID id = UUID.randomUUID();
    return insertAssignment(id,assignment);
  }

  List<Assignment> SelectAllAssignments();
}
