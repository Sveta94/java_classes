package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

  @Test
  public void testGroupModification(){

    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){

      app.getGroupHelper().createNewGroup(new GroupData("Test", "test1", "test2"));
    }
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Test3", "test7", null));
    app.getGroupHelper().submitGroupModification();
    app.getSessionHelper().logout();
  }



}
