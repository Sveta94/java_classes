package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().groupCount();
    app.getGroupHelper().createNewGroup(new GroupData("Test", "test1", "test2"));
    int after = app.getGroupHelper().groupCount();
    Assert.assertEquals(after, before + 1);
  }


}
