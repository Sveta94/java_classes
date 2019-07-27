package ru.stqa.pft.addressbook.tests.ContactTests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhonesTest extends TestBase {


  @Test

  public void testContactPhones(){

    app.navigationHelper().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactFromEditPage = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactFromEditPage)));
    assertThat(contact.getAddress(), equalTo(contactFromEditPage.getAddress()));

    }
  public static String mergePhones(ContactData contact){
    return Arrays.asList(contact.getHomePhone(),contact.getMobile(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhonesTest::cleaned)
            .collect(Collectors.joining("\n"));

  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s", "").replaceAll("[- ()]", "");
  }
}
