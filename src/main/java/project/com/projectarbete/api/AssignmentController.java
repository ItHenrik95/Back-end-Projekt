package project.com.projectarbete.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.com.projectarbete.list.Assignment;
import project.com.projectarbete.service.AssignmentService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

//@RestController is waiting for us to use a HTTP request like Post or Get.
//@RequestMapping is simply showing the path.
@RequestMapping("api/v1/assignment")
@RestController
public class AssignmentController {

  //Calling for the AssignmentService from the package Service
  private final AssignmentService assignmentService;

  @Autowired
  public AssignmentController(AssignmentService assignmentService) {
    this.assignmentService = assignmentService;
  }

  //@PostMapping is used to send a Http POST request. (Sending data)
  //@RequestBody. We are telling Postman that we wanna put the @RequestBody into the Assignment
  //@Vaild and @NotNull makes sure that the String (Assignment) is not empty.
  @PostMapping
  @ResponseBody
  public void addAssignment(@Valid @NotNull @RequestBody Assignment assignment){
    assignmentService.addAssignment(assignment);
  }

  //@GetMapping is Retrieving the data from the DB
  @GetMapping
  public List<Assignment> getAllAssignments(){
    return assignmentService.getAllAssignments();
  }

   //Taking the id and turn it into an UUID id that our program can work with. if not found return null.
  @GetMapping(path = "{id}")
  public Assignment getAssignmentById(@PathVariable("id") UUID id){
    return assignmentService.getAssignmentById(id).orElse(null);
  }

  // Finding the assignment threw the id and deleting it.
  @DeleteMapping(path = "{id}")
  public void deleteAssignment(@PathVariable("id") UUID id){
    assignmentService.deleteAssignment(id);
  }
}
