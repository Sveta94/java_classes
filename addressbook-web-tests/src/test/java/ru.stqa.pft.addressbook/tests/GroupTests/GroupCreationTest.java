package ru.stqa.pft.addressbook.tests.GroupTests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.navigationHelper().gotoGroupPage();
    Groups before = (Groups) app.group().all();
    GroupData group = new GroupData().withName("Test1").withHeader("test2").withFooter("test3");
    app.group().create(group);
    Groups after = (Groups) app.group().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded
                              (group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));



  }



}
