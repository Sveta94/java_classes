package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String mobile;
  private final String email;
  private final String bdayDay;
  private final String bdayMonth;
  private final String bdayYear;
  private final String group;
  private final int id;

  public ContactData(int  id, String firstName, String lastName, String nickname, String company, String address, String mobile, String email, String bdayDay, String bdayMonth, String bdayYear, String group) {
    this.firstname = firstName;
    this.lastname = lastName;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.bdayDay = bdayDay;
    this.bdayMonth = bdayMonth;
    this.bdayYear = bdayYear;
    this.group = group;
    this.id = id;
  }

  public ContactData(String firstName, String lastName, String nickname, String company, String address, String mobile, String email, String bdayDay, String bdayMonth, String bdayYear, String group) {
    this.firstname = firstName;
    this.lastname = lastName;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.bdayDay = bdayDay;
    this.bdayMonth = bdayMonth;
    this.bdayYear = bdayYear;
    this.group = group;
    this.id = 0;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            ", mobile='" + mobile + '\'' +
            ", email='" + email + '\'' +
            ", id=" + id +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(address, that.address) &&
            Objects.equals(mobile, that.mobile) &&
            Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, address, mobile, email, id);
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public String getBdayDay() {
    return bdayDay;
  }

  public String getBdayMonth() {
    return bdayMonth;
  }

  public String getBdayYear() {
    return bdayYear;
  }

  public String getGroup() { return group; }

  public int getId() { return id; }


}

