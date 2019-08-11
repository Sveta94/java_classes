package ru.stqa.pft.addressbook.tests.ContactTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeTest
  private void ensurePreconditions() {

    if(app.db().contacts().size() == 0){
      app.navigationHelper().gotoHomePage();
      app.contact().create(new ContactData()
              .withFirstname("Svetlana").withLastname("Avetisyan").withNickname("Sveta").withCompany("GGG")
              .withAddress( "Ulitsa Yunikh Lenintsev").withMobile("+7915000000000").withEmail( "test@test.com")
              .withBdayDay("7").withBdayMonth("February").withBdayYear("1994").withGroup("Test"));
    }
  }

  @Test

  public void  testDeleteContactFromHomePage(){
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.navigationHelper().gotoHomePage();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size()-1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
  }



  @Test
  public void testDeleteContactFromEditPage(){
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.navigationHelper().gotoHomePage();
    app.contact().delete2(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size()-1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));

  }


}
