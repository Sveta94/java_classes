package ru.stqa.pft.addressbook;

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
  private final String notes;
  private final String address2;
  private final String phone2;

  public ContactData(String firstname, String lastname, String nickname, String company, String address, String mobile, String email, String bdayDay, String bdayMonth, String bdayYear, String notes, String address2, String phone2) {
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
    this.notes = notes;
    this.address2 = address2;
    this.phone2 = phone2;
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

  public String getNotes() {
    return notes;
  }

  public String getAddress2() {
    return address2;
  }

  public String getPhone2() {
    return phone2;
  }
}
