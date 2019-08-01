package ru.stqa.pft.addressbook.tests.ContactTests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.navigationHelper().gotoHomePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/fun.png");
    ContactData contact = new ContactData()
            .withFirstname("Svetlana").withLastname("Avetisyan").withNickname("Sveta").withCompany("GGG")
            .withAddress( "Ulitsa Yunikh Lenintsev").withMobile("+7915000000000").withEmail( "test@test.com")
            .withBdayDay("7").withBdayMonth("February").withBdayYear("1994").withPhoto(photo);

    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before
            .withAdded(contact.withID(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
}

/*@Test (enabled = false)
  public void currentDir(){
    File currentDir = new File(".");
  System.out.println(currentDir.getAbsolutePath());
  File photo = new File("src/test/resources/fun.png");
  System.out.println(photo.getAbsolutePath());
  System.out.println(photo.exists());
   } */
}