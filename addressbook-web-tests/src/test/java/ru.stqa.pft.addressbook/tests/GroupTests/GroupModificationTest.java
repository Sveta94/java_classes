package ru.stqa.pft.addressbook.tests.GroupTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Set;

public class GroupModificationTest extends TestBase {

  @BeforeClass
  private void ensurePreconditions() {
    app.navigationHelper().gotoGroupPage();
    if(app.group().list().size() == 0){

      app.group().create(new GroupData().withName("Test1").withHeader("test2").withFooter("test3"));
    }
  }

  @Test
  public void testGroupModification(){

    Set<GroupData> before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("Test1").withHeader("test2").withFooter("test3");
    app.group().modifyGroup(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(after,before);

  }



}
