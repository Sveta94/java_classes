package ru.stqa.pft.addressbook.tests.GroupTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeClass
  private void ensurePreconditions() {
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createNewGroup(new GroupData("Test", "test1", "test2"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    int index = 0;
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().deleteGroup(index);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size() - 1);
    before.remove(index);
    Assert.assertEquals(after, before);
    }



}
  
