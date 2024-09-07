package org.app.appfilm.Utils;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.stream.FileCacheImageOutputStream;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploaderFilm {
  private static boolean login() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://helvid.com/login");

    WebElement userName = driver.findElement(By.className("username username_class_input"));
    WebElement password = driver.findElement(By.id("passwordField"));

    userName.sendKeys("hieudz");
    password.sendKeys("Khongco2004@");

    WebElement loginBtn = driver.findElement(By.id("loginButton"));

    WebElement verifiCode = driver.findElement(By.className("verifyimg"));

    loginBtn.click();
    return true;
  }

  public static void main(String[] args) throws Exception {
    Document document = Jsoup.connect("https://helvid.com/login").get();

    Element verifyImg = document.getElementsByClass("verifyimg").first();

    String imgUrl = verifyImg.absUrl("src");

    InputStream inputStreamImgUrl = new URL(imgUrl).openStream();

    Path tempFile = Files.createTempFile("verifyImg", ".jpeg");

    OutputStream outputStream = Files.newOutputStream(tempFile);

    byte[] buffer = new byte[4096];

    int n;
    while((n = inputStreamImgUrl.read(buffer)) != -1) {
      outputStream.write(buffer, 0, n);
    }

    inputStreamImgUrl.close();

    File file = tempFile.toFile();
    Tesseract tesseract = new Tesseract();
    tesseract.setDatapath("/usr/local/Cellar/tesseract/5.4.1/share/tessdata");
    tesseract.setLanguage("eng");
    try {
      System.out.println(tesseract.doOCR(file));
    } catch (TesseractException e) {
      e.printStackTrace();
    }
  }
}
