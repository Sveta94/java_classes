package ru.stqa.pft.addressbook.tests.GroupTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase {

  @BeforeClass
  private void ensurePreconditions() {
    if(app.db().groups().size() == 0){
      app.navigationHelper().gotoGroupPage();
      app.group().create(new GroupData().withName("Test1").withHeader("test2").withFooter("test"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.navigationHelper().gotoGroupPage();
    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size() -1 ));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(deletedGroup)));

    }



}
  
