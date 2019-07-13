package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{
  @Test

          public void testContactModification(){
            app.getContactHelper().editContact();
            app.getContactHelper().fillContactForm(new ContactData("Svetlana", "Avetisyan", "Sveta", "GGG", "Ulitsa Yunikh Lenintsev", "+7915000000000", "testemail@example.com", "7", "February", "1994", "test", "test", "test"));
            app.getContactHelper().submitContactModification();
            app.getSessionHelper().logout();

  }


}