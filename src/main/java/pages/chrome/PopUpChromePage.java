package pages.chrome;
import pages.BasePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
//import mobile.pageObjects.BasePage;
import org.openqa.selenium.WebElement;

public class PopUpChromePage extends BasePage {
    @AndroidFindBy(id = "com.android.chrome:id/negative_button")
    private WebElement noThanksBtn;

    public PopUpChromePage(AndroidDriver driver){
        super(driver);

    }

    public GoogleSearchPage noThanksBtnClick(){
        elementToBeClickable(noThanksBtn).click();
        return new GoogleSearchPage(driver);
    }
}
