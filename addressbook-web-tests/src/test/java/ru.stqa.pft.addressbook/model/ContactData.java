package ru.stqa.pft.addressbook.model;

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

  public ContactData(String firstname, String lastname, String nickname, String company, String address, String mobile, String email, String bdayDay, String bdayMonth, String bdayYear,  String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.bdayDay = bdayDay;
    this.bdayMonth = bdayMonth;
    this.bdayYear = bdayYear;
    this.group = group;
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
}

