package com.ab.directory.model;

import java.util.*;

/**
 * People
 */

public class People   {

  private String ssn = null;


  private String name = null;


  private String spouceName = null;


  private TreeSet<Child> children = null;


  /**
   * Get ssn
   * @return ssn
   **/

    public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  public People name(String name) {
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

  public People spouceName(String spouceName) {
    this.spouceName = spouceName;
    return this;
  }

  /**
   * Get spouceName
   * @return spouceName
   **/

  
    public String getSpouceName() {
    return spouceName;
  }

  public void setSpouceName(String spouceName) {
    this.spouceName = spouceName;
  }

  public People childern(TreeSet<Child> children) {
    this.children = children;
    return this;
  }

  public People addChildernItem(Child childItem) {
    if (this.children == null) {
      this.children = new TreeSet<Child>();
    }
    this.children.add(childItem);
    return this;
  }

  /**
   * Get childern
   * @return childern
   **/

    public TreeSet<Child> getChildern() {
    return children;
  }

  public void setChildern(TreeSet<Child> children) {
    this.children = children;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    People people = (People) o;
    return Objects.equals(this.ssn, people.ssn) &&
        Objects.equals(this.name, people.name) &&
        Objects.equals(this.spouceName, people.spouceName) &&
        Objects.equals(this.children, people.children);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class People {\n");
    
    sb.append("    ssn: ").append(toIndentedString(ssn)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    spouceName: ").append(toIndentedString(spouceName)).append("\n");
    sb.append("    childern: ").append(toIndentedString(children)).append("\n");
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
}
