package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class Timer extends BasePage{
    @AndroidFindBy(id = "com.google.android.deskclock:id/toolbar")
    private WebElement toolbar;

    @AndroidFindBy(id = "com.google.android.deskclock:id/tab_menu_timer")
    private WebElement buttomTimer;


    public Timer(AndroidDriver driver){
        super(driver);
    }

    public boolean isOnPage(){
        try{
            visibilityOf(toolbar).isDisplayed();
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public void OnClick()
    {
       buttomTimer.click();
    }
}
