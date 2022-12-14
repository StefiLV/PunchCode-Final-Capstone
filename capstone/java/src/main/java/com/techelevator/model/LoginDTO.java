package com.techelevator.model;

/**
 * DTO for storing a user's credentials.
 */
public class LoginDTO {

   private String username;
   private String password;

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public String toString() {
      return "LoginDTO{" +
              "email='" + username + '\'' +    //changed to email from username
              ", password='" + password + '\'' +
              '}';
   }
}
