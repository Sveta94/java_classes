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
    app.navigationHelper().gotoGroupPage();
    if(app.group().list().size() == 0){
      app.group().create(new GroupData().withName("Test1").withHeader("test2").withFooter("test"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    int index = 0;
    List<GroupData> before = app.group().list();
    app.group().delete(index);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(),before.size() - 1);
    before.remove(index);
    Assert.assertEquals(after, before);
    }



}
  
