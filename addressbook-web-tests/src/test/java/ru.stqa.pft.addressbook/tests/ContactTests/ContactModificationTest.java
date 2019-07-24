package ru.stqa.pft.addressbook.tests.ContactTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {

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

          public void testContactModification(){

           Contacts before  = app.contact().all();
            ContactData modifiedContact = before.iterator().next();
            ContactData contact = new ContactData()
                    .withID(modifiedContact.getId()).withFirstname("Svetlana").withLastname("Avetisyan").withNickname("Sveta")
                    .withCompany("GGG").withAddress( "Ulitsa Yunikh Lenintsev").withMobile("+7915000000000")
                    .withEmail( "test@test.com").withBdayDay("7").withBdayMonth("February").withBdayYear("1994").withGroup("Test");
            app.contact().modifyContact(contact);
            Contacts after = app.contact().all();
            assertThat(after.size(),equalTo(before.size()));
            assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));


  }



}
