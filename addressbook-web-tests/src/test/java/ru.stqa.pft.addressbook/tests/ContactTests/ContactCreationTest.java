package ru.stqa.pft.addressbook.tests.ContactTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Set;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.navigationHelper().gotoHomePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("Svetlana").withLastname("Avetisyan").withNickname("Sveta").withCompany("GGG")
            .withAddress( "Ulitsa Yunikh Lenintsev").withMobile("+7915000000000").withEmail( "test@test.com")
            .withBdayDay("7").withBdayMonth("February").withBdayYear("1994").withGroup("Test");

    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);
    contact.withID(after.stream().max(((o1, o2) -> Integer.compare(o1.getId(), o2.getId()))).get().getId());

    before.add(contact.withID(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()));
    Assert.assertEquals(before,after);
  }


}
