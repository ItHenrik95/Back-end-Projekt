package project.com.projectarbete.list;


import com.fasterxml.jackson.annotation.JsonProperty;


public class Assignment {
  private int id;
  private String assignment;

  //constructor
  // i am using @JsonProperty to make Postman understand what an Assignment is. (Contverting the text from postman to a java class)
  public Assignment(@JsonProperty("id") int id,
                    @JsonProperty("assignment") String assignment) {
    this.id = id;
    this.assignment = assignment;
  }
  public Assignment(){

  }
  public void setId(int id){
    this.id = id;
  }
  public void setAssignment(String assignment){
    this.assignment = assignment;
  }

    //Getters
  public String getAssignment() {
    return assignment;
  }

  public int getId() {
    return id;
  }
}
