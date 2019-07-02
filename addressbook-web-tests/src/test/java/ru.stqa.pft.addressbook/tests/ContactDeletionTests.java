package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {


  @Test

  public void  testDeleteContactFromHomePage(){

    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().confirmDeletion();
    app.getSessionHelper().logout();

  }

  @Test
  public void testDeleteContactFromEditPage(){
    app.getContactHelper().editContact();
    app.getContactHelper().deleteContactFromEditPage();
    app.getSessionHelper().logout();
  }
}
