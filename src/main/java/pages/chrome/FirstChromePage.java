package pages.chrome;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
//import mobile.pageObjects.BasePage;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class FirstChromePage extends BasePage {

    @iOSXCUITFindBy(accessibility = "fre_logo")
    @AndroidFindBy(id = "com.android.chrome:id/fre_logo")
    private WebElement titleLogo;

    @AndroidFindBy(id = "com.android.chrome:id/signin_fre_dismiss_button")
    private WebElement useWithoutAccountBtn;

    public FirstChromePage(AndroidDriver driver){
        super(driver);
    }

    public boolean isOnPage(){
        try{
            visibilityOf(titleLogo).isDisplayed();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public PopUpChromePage useWithoutAccountBtnClick(){
        elementToBeClickable(useWithoutAccountBtn).click();
        return new PopUpChromePage(driver);
    }


}
