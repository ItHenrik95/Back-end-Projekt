package project.com.projectarbete.list;


import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.UUID;


public class Assignment {
  private UUID id;
  private String assignment;

  //constructor
  // i am using @JsonProperty to make Postman understand what an Assignment is. (Contverting the text from postman to a java class)
  public Assignment(@JsonProperty("id") UUID id,
                    @JsonProperty("assignment") String assignment) {
    this.id = id;
    this.assignment = assignment;
  }
  public Assignment(){

  }
  public void setId(UUID id){
    this.id = id;
  }
  public void setAssignment(String assignment){
    this.assignment = assignment;
  }

    //Getters
  public String getAssignment() {
    return assignment;
  }

  public UUID getId() {
    return id;
  }
}
