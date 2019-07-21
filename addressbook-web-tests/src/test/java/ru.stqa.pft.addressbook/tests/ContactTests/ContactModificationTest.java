package ru.stqa.pft.addressbook.tests.ContactTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;
import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @BeforeClass
  private void ensurePreconditions() {
    app.navigationHelper().gotoHomePage();

    if(app.contact().list().size() == 0){
      app.contact().create(new ContactData("Svetlana", "Avetisyan", "Sveta", "GGG", "Ulitsa Yunikh Lenintsev", "+7915000000000", "testemail@example.com", "7", "February", "1994", "Test"));
    }
  }
  @Test

          public void testContactModification(){

            List<ContactData> before  = app.contact().list();
             int index = before.size() - 1;
            ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Svetlana", "Avetisyan", "Sveta", "GGG", "Ulitsa Yunikh Lenintsev", "+7915000000000", "testemail@example.com", "7", "February", "1994", "Test");
            app.contact().modifyContact(index, contact);
            List<ContactData> after = app.contact().list();
            Assert.assertEquals(after.size(),before.size());

            before.remove(before.size() - 1);
            before.add(contact);
            Comparator<? super ContactData> byID = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
            before.sort(byID);
            after.sort(byID);
            Assert.assertEquals(after,before);

  }



}
