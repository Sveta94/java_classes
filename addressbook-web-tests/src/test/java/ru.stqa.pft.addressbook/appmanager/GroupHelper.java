package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

public class GroupHelper extends HelperBase{

  public GroupHelper(WebDriver wd) {
    super(wd);

  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"),groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }


  public void submitGroupCreation() {

    click(By.name("submit"));
  }


  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroup() {
    click(By.name("delete"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  private void selectGroupByID(int id) {
    wd.findElement(By.cssSelector("input[value ='" + id + "']")).click();

  }


  public void initGroupModification() {
    click(By.name("edit"));
  }


  public void submitGroupModification() {
    click(By.name("update"));

  }

  public void create(GroupData groupData) {

    initGroupCreation();
    fillGroupForm(groupData);
    submitGroupCreation();
    returnToGroupPage();

  }

  public void modifyGroup(GroupData group) {
    selectGroupByID(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }

  public void delete(GroupData group) {
    selectGroupByID(group.getId());
    deleteSelectedGroup();
    returnToGroupPage();

  }


  public Groups all() {
    Groups groupData = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for(WebElement element:elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupData.add(new GroupData().withId(id).withName(name));
    }
    return groupData;


  }



}
