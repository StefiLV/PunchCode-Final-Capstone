package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

   private int userId;
   private String name;
   private String username;
   private String birthDate;
   private String phoneNumber;
   private String description;
   private String address;
   private String profilePic;
   private String heroBanner;
   private boolean organization;
   private boolean verified;
   private boolean minor;

   //Question about the password variable.
   // We have password_hash in the table, how does this relate to our password variable?
   @JsonIgnore
   private String password;
   @JsonIgnore
   private boolean activated;
   private Set<Authority> authorities = new HashSet<>();

   public User() { }

   public User(int userId, String name, String username, String birthDate, String phoneNumber, String description, String address, String profilePic, String heroBanner, boolean organization, boolean verified, boolean minor, String password, String authorities, boolean activated) {
      this.userId = userId;
      this.name = name;
      this.username = username;
      this.birthDate = birthDate;
      this.phoneNumber = phoneNumber;
      this.description = description;
      this.address = address;
      this.profilePic = profilePic;
      this.heroBanner = heroBanner;
      this.organization = organization;
      this.verified = verified;
      this.minor = minor;
      this.password = password;
      if(authorities != null) this.setAuthorities(authorities);
      this.activated = true;
   }
// defining getters and setters for all the variables
   public int getUserId() {
      return userId;
   }                                                     //userId get
   public void setUserId(int userId) {
      this.userId = userId;
   }                                   //userId set
   public String getName() { return name; }                                                       //get a name
   public void setName(String name) { this.name = name; }                                         //set a name
   public String getUsername() {
      return username;
   }                                               //username get
   public void setUsername(String username) {
      this.username = username;
   }                       //username set
   public String getBirthDate() { return birthDate; }                                           //birthdate get
   public void setBirthDate(String birthDate) { this.birthDate = birthDate; }                   //birthdate set
   public String getPhoneNumber() { return phoneNumber; }                                       //phone number get
   public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }//phone number set
   public String getDescription(){ return description; }
   public void setDescription(String description){ this.description = description; }
   public String getAddress() { return address; }                                               //address get
   public void setAddress(String address) { this.address = address; }                           //address set
   public String getProfilePic() { return profilePic; }                                         //profile pic get
   public void setProfilePic(String profilePic) { this.profilePic = profilePic; }               //profile pic set
   public String getHeroBanner() { return heroBanner; }                                         //hero banner get
   public void setHeroBanner(String heroBanner) { this.heroBanner = heroBanner; }               //hero banner set
   public boolean isOrganization() { return organization; }                                     //organization is/get
   public void setOrganization(boolean organization) { this.organization = organization; }      //organization set
   public boolean isVerified() { return verified; }                                             //verified is
   public void setVerified(boolean verified) { this.verified = verified; }                      //verified set
   public boolean isMinor() { return minor; }                                             //verified is
   public void setMinor(boolean minor) { this.minor = minor; }
   public String getPassword() {
      return password;
   }                                             //password get
   public void setPassword(String password) {
      this.password = password;
   }                       //password set
   public boolean isActivated() {
      return activated;
   }
   public void setActivated(boolean activated) {
      this.activated = activated;
   }
   public Set<Authority> getAuthorities() {
      return authorities;
   }
   public void setAuthorities(Set<Authority> authorities) {
      this.authorities = authorities;
   }

   public void setAuthorities(String authorities) {
      String[] roles = authorities.split(",");
      for(String role : roles) {
         String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
         this.authorities.add(new Authority(authority));
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return userId == user.userId &&
              activated == user.activated &&
              Objects.equals(username, user.username) &&
              Objects.equals(password, user.password) &&
              Objects.equals(authorities, user.authorities);
   }

   @Override
   //do I add an organization variable to this one at the end?
   public int hashCode() {
      return Objects.hash(userId, username, password, activated, authorities);
   }

   //do I add all the other variables to this?
   @Override
   public String toString() {
      return "User{" +
              "user_id=" + userId +
              ", username='" + username + '\'' +
              ", activated=" + activated +
              ", authorities=" + authorities +
              '}';
   }
}
