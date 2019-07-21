package ru.stqa.pft.addressbook.tests.ContactTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.navigationHelper().gotoHomePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData()
            .withFirstname("Svetlana").withLastname("Avetisyan").withNickname("Sveta").withCompany("GGG")
            .withAddress( "Ulitsa Yunikh Lenintsev").withMobile("+7915000000000").withEmail( "test@test.com")
            .withBdayDay("7").withBdayMonth("February").withBdayYear("1994").withGroup("Test");

    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);
    contact.withID(after.stream().max(((o1, o2) -> Integer.compare(o1.getId(), o2.getId()))).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byID = (g1,g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before,after);
  }


}
