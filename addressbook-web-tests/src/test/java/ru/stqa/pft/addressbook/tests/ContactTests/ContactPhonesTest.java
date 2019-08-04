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
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactFromEditPage)));

    }
  public static String mergePhones(ContactData contact){
    return Arrays.asList(contact.getHomePhone(),contact.getMobile(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhonesTest::cleanedPhone)
            .collect(Collectors.joining("\n"));

  }
  public static String mergeEmails(ContactData contact){
    return Arrays.asList(contact.getEmail(),contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhonesTest::cleanedEmail)
            .collect(Collectors.joining("\n"));

  }
  public static String cleanedPhone(String phone){
    return phone.replaceAll("\\s", "").replaceAll("[- ()]", "");
  }
  public static String cleanedEmail(String email){
    return email.replaceAll("\\s", "");
  }

}
