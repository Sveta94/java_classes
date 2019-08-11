package ru.stqa.pft.addressbook.tests.GroupTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase {

  @BeforeClass
  private void ensurePreconditions() {

    if(app.db().groups().size() == 0){
      app.navigationHelper().gotoGroupPage();
      app.group().create(new GroupData().withName("Test1").withHeader("test2").withFooter("test3"));
    }
  }

  @Test
  public void testGroupModification(){

    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    app.navigationHelper().gotoGroupPage();
    GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("Test1").withHeader("test2").withFooter("test3");
    app.group().modifyGroup(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    verifyGroupListUi();
  }


}
