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

  public boolean isThereAContact() {
    return isElementPresent((By.name("selected[]")));
  }

  public void createNewContact(ContactData contactData) {
    NavigationHelper n = new NavigationHelper(wd);
    SessionHelper s = new SessionHelper(wd);
    n.gotoContactPage();
    fillContactForm(contactData,true);
    submitContactCreation();;
    n.gotoHomePage();
  }

  public int contactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {

    List<ContactData> contactData = new ArrayList<ContactData>();
    List<WebElement> webElements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@ name = 'entry']"));
     for(WebElement webelement: webElements){
       String lastName = webelement.findElement(By.xpath(".//td[2]")).getText();
       String  firstName= webelement.findElement(By.xpath(".//td[3]")).getText();
       String address = webelement.findElement(By.xpath(".//td[4]")).getText();
       String email = webelement.findElement(By.xpath(".//td[5]")).getText();
       String mobile = webelement.findElement(By.xpath(".//td[6]")).getText();
       String id = webelement.findElement(By.tagName("input")).getText();

       ContactData contact = new ContactData(id, firstName, lastName, null, null, address, mobile ,email, null, null,null, null);
     contactData.add(contact);
     }
     return contactData;

  }
}

