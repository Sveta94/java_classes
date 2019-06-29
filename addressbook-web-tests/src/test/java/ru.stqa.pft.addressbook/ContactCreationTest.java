package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {

    gotoContactPage("add new");
    fillContactForm(new ContactData("Svetlana", "Avetisyan", "Sveta", "GGG", "Ulitsa Yunikh Lenintsev", "+7915000000000", "testemail@example.com", "7", "February", "1994", "test", "test", "test"));
    submitContactCreation("(//input[@name='submit'])[2]");
    returnToContactPage("home page");
    logout("Logout");
  }


}
