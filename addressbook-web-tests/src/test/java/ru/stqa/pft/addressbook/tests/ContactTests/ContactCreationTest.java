package ru.stqa.pft.addressbook.tests.ContactTests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.tests.TestBase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTest extends TestBase {

  @DataProvider
  public Iterator <Object[]> validContactsCsv() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")))){
      String line = reader.readLine();
      while (line != null) {
        String[] split = line.split(";");
        list.add(new Object[]{new ContactData().withFirstname(split[0]).withLastname(split[1]).withAddress(split[2]).withEmail(split[3])});
        line = reader.readLine();
      }
      return list.iterator();
    }
  }

  @DataProvider
  public Iterator <Object[]> validContactsXml() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
   try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
     String xml = "";
     String line = reader.readLine();
     while (line != null) {
       xml += line;
       line = reader.readLine();
     }
     XStream xstream = new XStream();
     xstream.processAnnotations(ContactData.class);
     List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
     return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
   }

  }

  @DataProvider
  public Iterator <Object[]> validContactsJson() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
   try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
     String json = "";
     String line = reader.readLine();
     while (line != null) {
       json += line;
       line = reader.readLine();
     }
       Gson gson = new Gson();
       List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
       return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
     }
   }


  @Test (dataProvider = "validContactsJson")
  public void testContactCreation(ContactData contact) throws Exception {
    app.navigationHelper().gotoHomePage();
    Contacts before = app.db().contacts();
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before
            .withAdded(contact.withID(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
}

@Test (enabled = false)
  public void currentDir(){
    File currentDir = new File(".");
  System.out.println(currentDir.getAbsolutePath());
  File photo = new File("src/test/resources/fun.png");
  System.out.println(photo.getAbsolutePath());
  System.out.println(photo.exists());
   }
}