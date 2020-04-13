package project.com.projectarbete.list;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

//using UUID as an id is good cus of the unik id you get. Then you can use many databases and no risk of getting a double id
public class Assignment {
  private final UUID id;
  private final String assignment;
  //constructor
  // i am using @JsonProperty to make Postman understand what an Assignment is. (Contverting the text from postman to a java class)
  public Assignment(@JsonProperty("id") UUID id,
                    @JsonProperty("assignment") String assignment) {
    this.id = id;
    this.assignment = assignment;
  }

  public String getAssignment() {
    return assignment;
  }

  public UUID getId() {
    return id;
  }
}
