package Test_this;

import Test_this.Test_this.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Test_this.DriverWrapper.getDriver;

public class AlloTest {
    MainPage mainPage;

    @Before
    public void precondition(){
        mainPage = new MainPage();
    }

    @Test
    public void NegativeRegistrationTest() throws  Exception {
        mainPage.open();
        mainPage.stopSlidePlay();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage.modalWindowcancel();
        mainPage.HeaderImageNavigation(MainPage.listofSlides());

        System.out.println("Passed: All elements are present.");
    }

   @After
   public void poscondition() throws IOException {
       getDriver().quit();
   }

}
