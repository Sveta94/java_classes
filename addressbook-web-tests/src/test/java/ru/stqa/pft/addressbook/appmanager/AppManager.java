package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppManager {
  private final Properties properties;

  public WebDriver wd;

  public AppManager(String browser) {
    if(browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    }
    else if (browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
    }
    else if(browser.equals(BrowserType.IE)){
      wd = new InternetExplorerDriver();

    }
    properties = new Properties();
  }


  private GroupHelper groupHelper;
  private ContactHelper contactHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private DbHelper db;

  public NavigationHelper navigationHelper() {
    return navigationHelper;
  }
  public DbHelper db(){return db;}
  public GroupHelper group() { return groupHelper; }
  public ContactHelper contact(){
    return contactHelper;
  }
  public SessionHelper getSessionHelper(){
    return sessionHelper;
  }


  public void init() throws IOException {

    String target =  System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    db = new DbHelper();
    wd.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
    wd.get( properties.getProperty("web.baseUrl"));
    groupHelper = new GroupHelper(wd);
    contactHelper = new ContactHelper(wd);
    sessionHelper = new SessionHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper.login(properties.getProperty("web.adminLogin"),(properties.getProperty("web.adminPassword")));
  }

  public void stop() {

    wd.quit();
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
