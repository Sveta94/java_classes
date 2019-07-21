package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {

    super(wd);
  }
  NavigationHelper n = new NavigationHelper(wd);

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());
    click(By.name("bday"));
    select(By.name("bday"), contactData.getBdayDay());
    click(By.xpath("//option[@value='7']"));
    click(By.name("bmonth"));
    select(By.name("bmonth"), contactData.getBdayMonth());
    click(By.xpath("//option[@value='February']"));
    type(By.name("byear"), contactData.getBdayYear());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText("Test3");
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }


  public void submitContactCreation() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }


  public void editContact(int index) {

   wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public void submitContactModification() {

    click(By.name("update"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContact() {

    click(By.xpath("//input[@value='Delete']"));
  }

  public void deleteContactFromEditPage() {
    click(By.xpath("(//input[@name='update'])[3]"));
  }

  public void confirmDeletion() {
    close();
  }


  public void create(ContactData contactData) {
    n.gotoContactPage();
    fillContactForm(contactData,true);
    submitContactCreation();;
    n.gotoHomePage();
  }

  public void modifyContact(int index, ContactData contact) {
    editContact(index);
    fillContactForm(contact, false);
    submitContactModification();
    n.gotoHomePage();
  }
  public void delete(int index) {
    selectContact(index);
    deleteSelectedContact();
    confirmDeletion();
    n.gotoHomePage();
  }

  public void delete2(int index) {
    editContact(index);
    deleteContactFromEditPage();
    n.gotoHomePage();
  }

  public List<ContactData> list() {

    List<ContactData> contactData = new ArrayList<ContactData>();
    List<WebElement> webElements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@ name = 'entry']"));
     for(WebElement webelement: webElements){
       String lastName = webelement.findElement(By.xpath(".//td[2]")).getText();
       String  firstName= webelement.findElement(By.xpath(".//td[3]")).getText();
       String address = webelement.findElement(By.xpath(".//td[4]")).getText();
       String email = webelement.findElement(By.xpath(".//td[5]")).getText();
       String mobile = webelement.findElement(By.xpath(".//td[6]")).getText();
       int id = Integer.parseInt(webelement.findElement(By.tagName("input")).getAttribute("value"));

        contactData.add(new ContactData()
                .withID(id).withFirstname(firstName).withLastname(lastName)
                .withAddress(address).withMobile(mobile).withEmail(email));
     }
     return contactData;

  }
}

