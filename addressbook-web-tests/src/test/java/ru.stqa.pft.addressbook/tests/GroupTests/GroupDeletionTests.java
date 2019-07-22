package ru.stqa.pft.addressbook.tests.GroupTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Set;

public class GroupDeletionTests extends TestBase {

  @BeforeClass
  private void ensurePreconditions() {
    app.navigationHelper().gotoGroupPage();
    if(app.group().all().size() == 0){
      app.group().create(new GroupData().withName("Test1").withHeader("test2").withFooter("test"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(),before.size() - 1);
    before.remove(deletedGroup);
    Assert.assertEquals(after, before);
    }



}
  
