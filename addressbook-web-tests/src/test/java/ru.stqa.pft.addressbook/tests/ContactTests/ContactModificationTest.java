package ru.stqa.pft.addressbook.tests.ContactTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Set;

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

            Set<ContactData> before  = app.contact().all();
            ContactData modifiedContact = before.iterator().next();
            ContactData contact = new ContactData()
                    .withID(modifiedContact.getId()).withFirstname("Svetlana").withLastname("Avetisyan").withNickname("Sveta")
                    .withCompany("GGG").withAddress( "Ulitsa Yunikh Lenintsev").withMobile("+7915000000000")
                    .withEmail( "test@test.com").withBdayDay("7").withBdayMonth("February").withBdayYear("1994").withGroup("Test");
            app.contact().modifyContact(contact);
            Set<ContactData> after = app.contact().all();
            Assert.assertEquals(after.size(),before.size());

            before.remove(modifiedContact);
            before.add(contact);
            Assert.assertEquals(after,before);

  }



}
