package ru.stqa.pft.addressbook.tests.ContactTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTest extends TestBase {



    @BeforeTest
    private void ensurePreconditions() {

        if(app.db().contacts().size() == 0){
            app.navigationHelper().gotoHomePage();
            Groups groups = app.db().groups();
            app.contact().create(new ContactData()
                    .withFirstname("Svetlana").withLastname("Avetisyan").withNickname("Sveta").withCompany("GGG")
                    .withAddress( "Ulitsa Yunikh Lenintsev").withMobile("+7915000000000").withEmail( "test@test.com")
                    .withBdayDay("7").withBdayMonth("February").withBdayYear("1994").inGroup(groups.iterator().next()));
        }
    }


    @Test
    public void testAddContactToGroup(){

        Contacts contacts = app.db().contacts();
        ContactData selectedContact = contacts.iterator().next();
        Groups contactInGroupsBefore = selectedContact.getGroups();
        app.navigationHelper().gotoHomePage();
        app.contact().selectContact(selectedContact.getId());
        app.contact().chooseGroup();
        app.contact().addContactToGroup();
        Groups contactInGroupsAfter = selectedContact.getGroups();
        assertThat(contactInGroupsAfter, equalTo(contactInGroupsBefore));

    }
}
