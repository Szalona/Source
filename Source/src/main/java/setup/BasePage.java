package setup;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;

public abstract class BasePage extends Base {

    public WebElement waitBy;

    public WebElement visible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean invisible(By by) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement presence(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement clickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    private WebElement chooseWait(Wait wait, By by) {
        switch (wait) {
            case VISIBLE:
                waitBy = visible(by);
                break;
            case PRESENCE:
                waitBy = presence(by);
            case CLICKABLE:
                waitBy = clickable(by);
                break;
        }
        return waitBy;
    }

    public void visibleInvisible(By by) {
        visible(by);
        invisible(by);
    }

    public boolean display(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public void waitClick(Wait wait, By by, String elementName) {
        chooseWait(wait, by).click();
        log.debug(String.format("'%s' button has been clicked", elementName));
    }

    public void waitSendkeys(Wait wait, By by, String elementName, String text) {
        chooseWait(wait, by).sendKeys(text);
        log.debug(String.format("'%s' input has been filled by '%s' data", elementName, text));
    }

    public void waitClear(Wait wait, By by, String elementName) {
        chooseWait(wait, by).clear();
        log.debug(String.format("'%s' input has been cleared", elementName));
    }

    public void waitClearSendkeys(Wait wait, By by, String elementName, String text) {
        waitClear(wait, by, elementName);
        waitSendkeys(wait, by, elementName, text);
    }

    public void expandDropDownAndClickOption(Wait wait, By by, String element) {
        WebElement dropDownElement = driver.findElement(by);
        dropDownElement.click();
        dropDownElement.findElement(By.xpath("//md-option[@value='" + element + "']")).click();
        // //md-option[@value='SRV']"
    }

    public void assertText(Wait wait, By by, Elements elements, String elementName, String expected) {
        String actual = null;
        switch (elements) {
            case TEXT:
                actual = chooseWait(wait, by).getText();
                break;
            case ATTRIBUTE:
                actual = chooseWait(wait, by).getAttribute("value");
                break;
        }
        Assert.assertEquals(expected, actual);
        log.info(String.format("'%s' appeared properly as '%s'", actual, elementName));
    }

    public void assertContainText(Wait wait, By by, String elementName, String expected) {
        String fullText = chooseWait(wait, by).getAttribute("value");
        Assert.assertTrue(String.format("'%s' didn't appear as '%s'", expected, elementName), fullText.contains(expected));
        log.info(String.format("'%s' appeared properly as '%s'", expected, elementName));
    }

    public String getLastMonthDate() {
        return LocalDate.now().minusMonths(1).toString().substring(0, 7);
    }
}
