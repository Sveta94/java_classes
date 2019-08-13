package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.AppManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.tests.GroupTests.GroupCreationTest;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {

  Logger logger = LoggerFactory.getLogger(GroupCreationTest.class);

  public static final AppManager app = new AppManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();


  }

  @BeforeMethod (alwaysRun = true)

  public void logTestStart(Method m, Object [] p){
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));

  }

  @AfterMethod(alwaysRun = true)

  public void logTestStop(Method m){

    logger.info("Stop test " + m.getName());
  }

  public void verifyGroupListUi() {
//to use this method add the following to the configurations -> VM options: -DverifyUI=true
    if (Boolean.getBoolean("verifyUI"))  {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream().map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));

    }
  }

  public void verifyContactListUi() {
//to use this method add the following to the configurations -> VM options: -DverifyUI=true
    if (Boolean.getBoolean("verifyUI"))  {
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts = app.contact().all();
      assertThat(uiContacts, equalTo(dbContacts.stream().map((g) -> new ContactData().withID(g.getId()).withFirstname(g.getFirstname())
              .withLastname(g.getLastname()))
              .collect(Collectors.toSet())));

    }
  }

}
