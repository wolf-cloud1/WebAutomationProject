package automation.Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class webBasePage {

    private static final int WAIT_TIMEOUT = 30;
    private static final int POLLING = 100;

    protected static final String BASE_URL = "https://www.google.com";
    final WebDriver driver;
    private final WebDriverWait wait;

    public webBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, WAIT_TIMEOUT, POLLING);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForTextToDisappear(WebElement element, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, text)));
    }

    protected boolean isVisible(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isInvisible(WebElement element) {
        try {
            return !element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEnabled(WebElement webElement){
        try {
            return webElement.isEnabled();
        } catch (Exception e){
            return false;
        }
    }

    protected void waitFor(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ignored) {

        }
    }

    public void scrollUp() {
        try {
            ((JavascriptExecutor) driver).executeScript("scroll(0,-500)");
            ((JavascriptExecutor) driver).executeScript("scroll(0,-500)");
        } catch (Exception ignored) {

        }
    }

    public void scrollDown() {
        Dimension size = this.getDriver().manage().window().getSize();
        int startPoint = (int)((double)size.getHeight() * 0.7D);
        int endPoint = (int)((double)size.getHeight() * 0.4D);
        ((JavascriptExecutor)driver).executeScript("scroll("+startPoint+","+endPoint+")");
    }

    public void scrollDownToElement(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String getTextViaJavascript(WebElement element) {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) getDriver());
        Object stringRetorno = javascriptExecutor.executeScript("return arguments[0].value;", element);
        return String.valueOf(stringRetorno);
    }

    public void enmarcarObjeto(WebElement element) {
        try {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '5px solid LimeGreen;';", element);
        } catch (Exception ignored) {
            System.out.println("Error: Al ejecutar JavaScript para modificar propiedad css del elemento. ");
        }
    }

    public void ClearBrowserCache ()
    {
        driver.manage().deleteAllCookies();
    }
}
