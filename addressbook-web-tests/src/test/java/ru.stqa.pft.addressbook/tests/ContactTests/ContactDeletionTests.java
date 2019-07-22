package ru.stqa.pft.addressbook.tests.ContactTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

  @BeforeClass
  private void ensurePreconditions() {
    app.navigationHelper().gotoHomePage();

    if(app.contact().all().size() == 0){
      app.contact().create(new ContactData()
              .withFirstname("Svetlana").withLastname("Avetisyan").withNickname("Sveta").withCompany("GGG")
              .withAddress( "Ulitsa Yunikh Lenintsev").withMobile("+7915000000000").withEmail( "test@test.com")
              .withBdayDay("7").withBdayMonth("February").withBdayYear("1994").withGroup("Test"));
    }
  }

  @Test

  public void  testDeleteContactFromHomePage(){
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(deletedContact);
    Assert.assertEquals(before,after);
  }



  @Test
  public void testDeleteContactFromEditPage(){
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete2(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(deletedContact);
    Assert.assertEquals(before,after);
  }


}
