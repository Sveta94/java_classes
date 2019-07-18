package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
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


  public void editContact() {

    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {

    click(By.name("update"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
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
    return wd.findElements(By.name("entry")).size();
  }
}

