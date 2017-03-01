package com.louisamoros.model;

import java.util.Objects;

/**
 * Created by louis on 01/03/17.
 */
public class User {

  private String firstName;
  private String lastName;

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  // CHECKSTYLE_OFF
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(lastName, user.lastName) &&
        Objects.equals(firstName, user.firstName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastName, firstName);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("User{");
    sb.append("firstName='").append(firstName);
    sb.append(", lastName='").append(lastName);
    sb.append('}');
    return sb.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private final User user;

    private Builder() {
      user = new User();
    }

    public Builder firstName(String firstName) {
      user.setFirstName(firstName);
      return this;
    }

    public Builder lastName(String lastName) {
      user.setLastName(lastName);
      return this;
    }

    public User build() {
      return user;
    }

  }
  // CHECKSTYLE_ON

}
