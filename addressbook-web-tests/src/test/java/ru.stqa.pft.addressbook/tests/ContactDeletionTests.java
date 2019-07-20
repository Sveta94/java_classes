package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {


  @Test

  public void  testDeleteContactFromHomePage(){

    app.getNavigationHelper().gotoHomePage();

    if(! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createNewContact(new ContactData("Svetlana", "Avetisyan", "Sveta", "GGG", "Ulitsa Yunikh Lenintsev", "+7915000000000", "testemail@example.com", "7", "February", "1994", "Test"));
    }
    int before = app.getContactHelper().contactCount();
    app.getContactHelper().selectContact(0);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().confirmDeletion();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().contactCount();
    Assert.assertEquals(after, before - 1);

  }

  @Test
  public void testDeleteContactFromEditPage(){
    app.getNavigationHelper().gotoHomePage();

    if(! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createNewContact(new ContactData("Svetlana", "Avetisyan", "Sveta", "GGG", "Ulitsa Yunikh Lenintsev", "+7915000000000", "testemail@example.com", "7", "February", "1994", "Test"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContact(0);
    app.getContactHelper().deleteContactFromEditPage();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }
}
