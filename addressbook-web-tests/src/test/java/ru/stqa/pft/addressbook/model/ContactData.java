package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contacts")
@Entity
@Table(name = "addressbook")
public class ContactData {
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

  @Expose
  @Column(name = "firstname")
  private  String firstname;

  @Expose
  @Column(name = "lastname")
  private  String lastname;

  @Column(name = "nickname")
  private  String nickname;

  @Column(name = "company")
  private  String company;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private  String address;

  @Column(name = "mobile")
  @Type(type = "text")
  private  String mobile;

  @Column(name = "home")
  @Type(type = "text")
  private  String homePhone;

  @Column(name = "work")
  @Type(type = "text")
  private  String workPhone;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private  String email;

  @Column(name = "email2")
  @Type(type = "text")
  private String email2;

  @Column(name = "email3")
  @Type(type = "text")
  private String email3;

  @Transient
  private  String bdayDay;

  @Transient
  private  String bdayMonth;

  @Transient
  private  String bdayYear;

  @Transient
  private  String allPhones;

  @Transient
  private String allEmails;

  @Transient
  private  String group;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private  int id;

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ",lastname='" + lastname + '\'' +
            ",address='" + address + '\'' +
            ",email='" + email + '\'' +
//            ", id=" + id +
            '}';
  }

  public File getPhoto() { return new File(photo); }

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

  public String getMobile() { return mobile; }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
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

  public String getAllPhones() { return allPhones; }

  public String getAllEmails(){ return allEmails; }

  public String getHomePhone() { return homePhone; }

  public String getWorkPhone() { return workPhone; }

  public int getId() { return id; }

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
  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }
  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
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


  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails){
    this.allEmails = allEmails;
    return this;
  }


  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }
}

