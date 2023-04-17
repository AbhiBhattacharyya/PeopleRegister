package com.ab.directory.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * PeopleChildern
 */

public class Child implements Comparable<Child> {

  private String name = null;


  private String dob = null;

  public Child name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/

  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Child dob(String dob) {
    this.dob = dob;
    return this;
  }

  /**
   * Get dob
   * @return dob
   **/

  
    public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Child peopleChild = (Child) o;
    return Objects.equals(this.name, peopleChild.name) &&
        Objects.equals(this.dob, peopleChild.dob);
  }



  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Child {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    dob: ").append(toIndentedString(dob)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @Override
  public int compareTo(Child that) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
      if(simpleDateFormat.parse(this.getDob()).before(simpleDateFormat.parse(that.getDob()))){
        return -1;
      }else {
        return 1;
      }
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }
}
