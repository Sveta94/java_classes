package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {


  @Test

  public void  testDeleteContactFromHomePage(){

    if(! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createNewContact(new ContactData("Svetlana", "Avetisyan", "Sveta", "GGG", "Ulitsa Yunikh Lenintsev", "+7915000000000", "testemail@example.com", "7", "February", "1994", "Test"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().confirmDeletion();
    app.getSessionHelper().logout();

  }

  @Test
  public void testDeleteContactFromEditPage(){

    if(! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createNewContact(new ContactData("Svetlana", "Avetisyan", "Sveta", "GGG", "Ulitsa Yunikh Lenintsev", "+7915000000000", "testemail@example.com", "7", "February", "1994", "Test"));
    }
    app.getContactHelper().editContact();
    app.getContactHelper().deleteContactFromEditPage();
    app.getSessionHelper().logout();
  }
}
