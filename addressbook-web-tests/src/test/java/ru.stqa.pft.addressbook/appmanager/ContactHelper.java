package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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


  public void editContact(int id) {

    wd.findElement(By.cssSelector("a[href = 'edit.php?id=" + id + "']")).click();
  }



  public void submitContactModification() {

    click(By.name("update"));
  }


  public void selectContact(int id) {
    wd.findElement(By.cssSelector(String.format("input[id = '%s']", id))).click();
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
 public int count(){
    return wd.findElements(By.name("selected[]")).size();
 }

  public void create(ContactData contactData) {
    n.gotoContactPage();
    fillContactForm(contactData,true);
    submitContactCreation();
    contactCache = null;
    n.gotoHomePage();
  }

  public void modifyContact(ContactData contact) {
    editContact(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    n.gotoHomePage();
  }

  public void delete(ContactData contact) {
    selectContact(contact.getId());
    deleteSelectedContact();
    confirmDeletion();
    contactCache = null;
    n.gotoHomePage();
  }
  public void delete2(ContactData contact) {
    editContact(contact.getId());
    deleteContactFromEditPage();
    contactCache = null;
    n.gotoHomePage();
  }


  public ContactData infoFromEditForm(ContactData contact){
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    n.gotoHomePage();
    return new ContactData().withID(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withAddress(address).withMobile(mobile).withHomePhone(home).withWorkPhone(work);

  }


  public void initContactModificationById(int id){

    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value ='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath(".//..//.."));   // .. goto parent element
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

//    wd.findElement(By.xpath(String.format("//input[@value = '%s']/../../td[8]/a", id))).click();
//    wd.findElement(By.xpath(String.format("//tr[//input[@value = '%s']}/td[8]/a", id))).click();
//    wd.findElement(By.cssSelector(String.format("a[href = 'edit.php?id='%s']", id))).click();


  }
  private Contacts contactCache = null;



  public Contacts all() {
    if (contactCache != null){
      return contactCache;
    }

    contactCache = new Contacts();
    List<WebElement> webElements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@ name = 'entry']"));
     for(WebElement webelement: webElements){
       String lastName = webelement.findElement(By.xpath(".//td[2]")).getText();
       String  firstName= webelement.findElement(By.xpath(".//td[3]")).getText();
       String address = webelement.findElement(By.xpath(".//td[4]")).getText();
       String email = webelement.findElement(By.xpath(".//td[5]")).getText();
       String allPhones = webelement.findElement(By.xpath(".//td[6]")).getText();
       int id = Integer.parseInt(webelement.findElement(By.tagName("input")).getAttribute("value"));

        contactCache.add(new ContactData()
                .withID(id).withFirstname(firstName).withLastname(lastName).withAddress(address)
                .withAllPhones(allPhones));
     }
     return contactCache;

  }


}

