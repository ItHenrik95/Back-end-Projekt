package project.com.projectarbete.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.com.projectarbete.list.Assignment;
import project.com.projectarbete.service.AssignmentService;

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
  @PostMapping
  public void addAssignment(@RequestBody Assignment assignment){
    assignmentService.addAssignment(assignment);
  }
}
