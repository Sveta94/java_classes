package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTest extends TestBase {

  @Test
  public void testGroupModification(){

    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){

      app.getGroupHelper().createNewGroup(new GroupData("Test", "test1", "test2"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().initGroupModification(0);
    app.getGroupHelper().fillGroupForm(new GroupData("Test3", "test7", null));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());
  }



}
