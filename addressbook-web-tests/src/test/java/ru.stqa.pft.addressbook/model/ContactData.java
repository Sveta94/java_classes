package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private  String firstname;
  private  String lastname;
  private  String nickname;
  private  String company;
  private  String address;
  private  String mobile;
  private  String email;
  private  String bdayDay;
  private  String bdayMonth;
  private  String bdayYear;
  private  String group;


  private  int id;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, id);
  }

  public ContactData withID(int id) {
    this.id = id;
    return this;
  }
  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withBdayDay(String bdayDay) {
    this.bdayDay = bdayDay;
    return this;
  }

  public ContactData withBdayMonth(String bdayMonth) {
    this.bdayMonth = bdayMonth;
    return this;
  }

  public ContactData withBdayYear(String bdayYear) {
    this.bdayYear = bdayYear;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }



}

