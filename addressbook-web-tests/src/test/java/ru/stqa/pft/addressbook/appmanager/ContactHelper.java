package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

import static ru.stqa.pft.addressbook.tests.TestBase.app;

public class ContactHelper extends HelperBase {

  NavigationHelper n = new NavigationHelper(wd);
  private Contacts contactCache = null;

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
//    type(By.name("nickname"), contactData.getNickname());
//    attach(By.name("photo"), contactData.getPhoto());
//    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
//    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());
//    click(By.name("bday"));
//    select(By.name("bday"), contactData.getBdayDay());
//    click(By.xpath("//option[@value='7']"));
//    click(By.name("bmonth"));
//    select(By.name("bmonth"), contactData.getBdayMonth());
//    click(By.xpath("//option[@value='February']"));
//    type(By.name("byear"), contactData.getBdayYear());

    if (creation) {
       if(contactData.getGroups().size() > 0){
           Assert.assertTrue(contactData.getGroups().size() == 1);
       }
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
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
      System.out.println(contact.getId());
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
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");

    n.gotoHomePage();
    return new ContactData().withID(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withAddress(address).withMobile(mobile).withHomePhone(home).withWorkPhone(work).withEmail(email)
            .withEmail2(email2).withEmail3(email3);

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
       String allEmails = webelement.findElement(By.xpath(".//td[5]")).getText();
       String allPhones = webelement.findElement(By.xpath(".//td[6]")).getText();
       int id = Integer.parseInt(webelement.findElement(By.tagName("input")).getAttribute("value"));

        contactCache.add(new ContactData()
                .withID(id).withFirstname(firstName).withLastname(lastName).withAddress(address).withAllEmails(allEmails)
                .withAllPhones(allPhones));
     }
     return contactCache;

  }


    public void chooseGroup() {
        Groups groups = app.db().groups();
        wd.findElement(By.name("to_group")).click();
        new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(groups.iterator().next().getName());
    }

    public void addContactToGroup() {

        wd.findElement(By.name("add")).click();
    }
}

