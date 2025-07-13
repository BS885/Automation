package pages.chrome;
import pages.BasePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
//import mobile.pageObjects.BasePage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPage extends BasePage {
    @AndroidFindBy(id = "com.android.chrome:id/search_provider_logo")
    private WebElement title;

    @AndroidFindBy(id = "com.android.chrome:id/search_box_text")
    private WebElement searchInput;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'com.android.chrome:id/line_1')]")
    private List<WebElement> searchResultList;

    public GoogleSearchPage(AndroidDriver driver){
        super(driver);
    }

    public boolean isOnPage(){
        try{
            visibilityOf(title).isDisplayed();
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public void searchInputSendKeys(String str){
        visibilityOf(searchInput).sendKeys(str);
    }

    public void selectIndexInSearchResultList(int index){
        visibilityOfAllElements(searchResultList).get(index).click();
    }





}
