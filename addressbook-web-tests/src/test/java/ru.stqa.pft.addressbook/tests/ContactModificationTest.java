package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{
  @Test

          public void testContactModification(){
            app.getNavigationHelper().gotoHomePage();

            if(! app.getContactHelper().isThereAContact()){
                app.getContactHelper().createNewContact(new ContactData("Svetlana", "Avetisyan", "Sveta", "GGG", "Ulitsa Yunikh Lenintsev", "+7915000000000", "testemail@example.com", "7", "February", "1994", "Test"));
            }

            int before = app.getContactHelper().contactCount();
            app.getContactHelper().editContact(0);
            app.getContactHelper().fillContactForm(new ContactData("Svetlana", "Avetisyan", "Sveta", null, null, null, "testemail@example.com", "7", "February", "1994", null), false);
            app.getContactHelper().submitContactModification();
            app.getNavigationHelper().gotoHomePage();
            int after = app.getContactHelper().contactCount();
             Assert.assertEquals(after,before);

  }


}
