package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase{
  @Test

          public void testContactModification(){
            app.getNavigationHelper().gotoHomePage();

            if(! app.getContactHelper().isThereAContact()){
                app.getContactHelper().createNewContact(new ContactData("Svetlana", "Avetisyan", "Sveta", "GGG", "Ulitsa Yunikh Lenintsev", "+7915000000000", "testemail@example.com", "7", "February", "1994", "Test"));
            }
            List<ContactData> before  = app.getContactHelper().getContactList();
            app.getContactHelper().editContact(before.size() - 1);
            ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Svetlana", "Avetisyan", "Sveta", "GGG", "Ulitsa Yunikh Lenintsev", "+7915000000000", "testemail@example.com", "7", "February", "1994", "Test");
            app.getContactHelper().fillContactForm(contact, false);
            app.getContactHelper().submitContactModification();
            app.getNavigationHelper().gotoHomePage();
            List<ContactData> after = app.getContactHelper().getContactList();
             Assert.assertEquals(after.size(),before.size());

             before.remove(before.size() - 1);
             before.add(contact);
             Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }


}
