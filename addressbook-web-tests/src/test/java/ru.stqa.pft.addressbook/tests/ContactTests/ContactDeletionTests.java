package ru.stqa.pft.addressbook.tests.ContactTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.HashSet;
import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeClass
  private void ensurePreconditions() {
    app.navigationHelper().gotoHomePage();

    if(app.contact().list().size() == 0){
      app.contact().create(new ContactData("Svetlana", "Avetisyan", "Sveta", "GGG", "Ulitsa Yunikh Lenintsev", "+7915000000000", "testemail@example.com", "7", "February", "1994", "Test"));
    }
  }

  @Test

  public void  testDeleteContactFromHomePage(){
    int index = 0;
    List<ContactData> before = app.contact().list();
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(0);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }



  @Test
  public void testDeleteContactFromEditPage(){
    int index = 0;
    List<ContactData> before = app.contact().list();
    app.contact().delete2(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(0);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }


}
