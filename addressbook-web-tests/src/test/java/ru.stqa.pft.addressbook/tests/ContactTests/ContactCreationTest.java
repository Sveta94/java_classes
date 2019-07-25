package ru.stqa.pft.addressbook.tests.ContactTests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.navigationHelper().gotoHomePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("Svetlana").withLastname("Avetisyan").withNickname("Sveta").withCompany("GGG")
            .withAddress( "Ulitsa Yunikh Lenintsev").withMobile("+7915000000000").withEmail( "test@test.com")
            .withBdayDay("7").withBdayMonth("February").withBdayYear("1994").withGroup("Test");

    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before
            .withAdded(contact.withID(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
}


}
