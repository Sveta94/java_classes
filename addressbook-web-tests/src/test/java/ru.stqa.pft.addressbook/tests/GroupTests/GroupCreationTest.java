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
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("Test1").withHeader("test2").withFooter("test3");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1 ));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.withAdded
                              (group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));



  }

  @Test
  public void testBadGroupCreation() throws Exception {

    app.navigationHelper().gotoGroupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("Test1'").withHeader("test2").withFooter("test3");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() ));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));



  }


}
