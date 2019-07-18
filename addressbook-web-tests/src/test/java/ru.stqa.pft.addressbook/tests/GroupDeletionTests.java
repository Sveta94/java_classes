package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {


  @Test
  public void testGroupDeletion() throws Exception {

    app.getNavigationHelper().gotoGroupPage();

    if(! app.getGroupHelper().isThereAGroup()){

      app.getGroupHelper().createNewGroup(new GroupData("Test", "test1", "test2"));
    }
    int before = app.getGroupHelper().groupCount();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().groupCount();
    Assert.assertEquals(after,before - 1);
  }


}
