package com.fjord.plant.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id = 1;

  private String name;

  private String surname;

  private String email;

  private String password;

  private boolean isVerified = false;

  private Date creationDate;

  private int timesWatered = 0;

  private int formationsFollowed = 0;

  public Integer getId() {
    return id;
  }

  public int getFormationsFollowed() {
    return formationsFollowed;
  }

  public void setFormationsFollowed(int formationsFollowed) {
    this.formationsFollowed = formationsFollowed;
  }

  public int getTimesWatered() {
    return timesWatered;
  }

  public void setTimesWatered(int timesWatered) {
    this.timesWatered = timesWatered;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getisVerified() {
    return isVerified;
  }

  public void setisVerified(Boolean isVerified) {
    this.isVerified = isVerified;
  }

}