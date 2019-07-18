package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().contactCount();
    app.getContactHelper().createNewContact(new ContactData("Svetlana", "Avetisyan", "Sveta", "GGG", "Ulitsa Yunikh Lenintsev", "+7915000000000", "testemail@example.com", "7", "February", "1994", "Test"));
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().contactCount();
    Assert.assertEquals(after, before + 1);
  }


}
