package project.com.projectarbete.dataserver;

import project.com.projectarbete.list.Assignment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AssignmentServer {

  int insertAssignment(UUID id, Assignment assignment);

  default int insertAssignment(Assignment assignment){
    // create a random id
    UUID id = UUID.randomUUID();
    return insertAssignment(id,assignment);
  }

  List<Assignment> SelectAllAssignments();

  // Optional is to be able to use stream method.
  Optional<Assignment> selectAllById(UUID id);

    // method for deleting an assignment by the ID.
  int deleteAssignment(UUID id);



}
