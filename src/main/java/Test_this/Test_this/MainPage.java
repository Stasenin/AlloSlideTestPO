package Test_this.Test_this;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static Test_this.DriverWrapper.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainPage {

//    private WebDriver driver;


//    public MainPage(WebDriver driver) {
//        this.driver = driver;
//    }

    public void open() throws IOException {
        getDriver().get("http://allo.ua/");
    }
    private boolean b,a;
    private final By StopSlidePlay =  By.cssSelector("li[class=pause]");
    private final By CancelModalWindow = By.cssSelector(".push-notification-disallow-btn");
    public static ArrayList<String>  listofSlides () {
        ArrayList<String> list = new ArrayList<String>();
        list.add(0, "//img[contains(@src, 'http://img.allo.ua/media//top_banner/PROMO_1_W.JPG')]");
        list.add(1,"//img[contains(@src, 'http://img.allo.ua/media//top_banner/A-Series_W_2.JPG')]");
        list.add(2,"//img[contains(@src, 'http://img.allo.ua/media//top_banner/A-Series_W_vje_1.jpg')]");
        list.add(3,"//*[contains(@src, 'http://img.allo.ua/media//top_banner/iPhone_7_W_19.JPG')]");
        list.add(4,"//*[contains(@src, 'http://img.allo.ua/media//top_banner/iPhone_6s_32Gb_W_1.JPG')]");
        list.add(5,"//*[contains(@src, 'http://img.allo.ua/media//top_banner/Xiaomi-Redmi-4__W.JPG')]");
        list.add(6, "//*[contains(@src, 'http://img.allo.ua/media//top_banner/Xiaomi-Mi5_W.jpg')]");
        list.add(7,"//*[contains(@src, 'http://img.allo.ua/media//top_banner/Sony-Xperia-XA_W.jpg')]");
        list.add(8,"//*[contains(@src, 'http://img.allo.ua/media//top_banner/AppleWatch1_W_1.JPG')]");
        list.add(9,"//*[contains(@src, 'http://img.allo.ua/media//top_banner/Samsung-Galaxy-Tab-A_W.JPG')]");
        list.add(10,"//*[contains(@src, 'http://img.allo.ua/media//top_banner/Lenovo-TAB2-X30_W_3.JPG')]");
        list.add(11,"//*[contains(@src, 'http://img.allo.ua/media//top_banner/__W_1.JPG')]");
        list.add(12,"//*[contains(@src, 'http://img.allo.ua/media//top_banner/rassrochka20pl_W.JPG')]");
        return list;
    }
    public void HeaderImageNavigation (ArrayList<String> list) throws Exception {
        for (int i = 0; i<13; i++) {
            String id = "control"+i;
            Thread.sleep(100);
            getDriver().findElement(By.id(id)).click();
            //getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            Thread.sleep(500);
            //WebDriverWait wait = new WebDriverWait(getDriver(),5);
           // wait.until(ExpectedConditions.elementToBeSelected(By.id(id)));

            try{assertTrue(getDriver().findElement(By.xpath(list.get(i))).isDisplayed());}
            catch (Exception e) {System.out.println(e+"Assertion Error in index"+i);}
        }

    }
    public void HeaderImageSlider(ArrayList<String> list)  throws Exception {

    for (int i = 0; i<13;i++) {
            Date date = new Date();
            WebDriverWait wait = new WebDriverWait(getDriver(),5);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(list.get(i))));
            Date date1 = new Date();
            long d= date1.getTime()-date.getTime(); // milliseconds
            System.out.println(d);
            if (d<5500&&d>3500 || d<100 && d>0 ){
                b = true;
            } else b = false;
            assertEquals(true, b);
        }


    }


    public void stopSlidePlay() throws IOException {
        getDriver().findElement(StopSlidePlay).click();
    }
    public void modalWindowcancel() throws IOException {
        getDriver().findElement(CancelModalWindow).click();
    }



}
