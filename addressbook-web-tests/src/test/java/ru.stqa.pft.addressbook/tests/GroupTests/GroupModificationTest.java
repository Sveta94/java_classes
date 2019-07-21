package ru.stqa.pft.addressbook.tests.GroupTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase {

  @BeforeClass
  private void ensurePreconditions() {
    app.navigationHelper().gotoGroupPage();
    if(app.group().list().size() == 0){

      app.group().create(new GroupData("Test", "test1", "test2"));
    }
  }

  @Test
  public void testGroupModification(){

    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(), "Test3", "test7", "test9");
    app.group().modifyGroup(group, index);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(after,before);

  }



}
