package platform;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import setup.BasePage;
import setup.Wait;

public class PackagePage extends BasePage {

    private By cityFromInput = By.id("cityFrom");
    private By cityToInput = By.id("cityTo");
    private By weightInput = By.name("parcelWeight");
    private By submitBtn = By.xpath("//button[@class='btn btn-primary btn-block mt-3']");
    private By choosePackageBtn = By.xpath("//*[@id='js-calculator-content']/section[2]/div[1]/div[1]/div/div/div[2]/div/div[3]/button");
    private By senderNameInput = By.id("senderName");
    private By senderPostalCodeInput = By.id("senderPostalCode");
    private By senderCityInput = By.id("senderCity");
    private By senderStreetInput = By.id("senderStreet");
    private By senderHouseNumberInput = By.id("senderHouseNumber");
    private By senderFlatNumberInput = By.id("senderFlatNumber");
    private By senderPhoneInput = By.id("senderPhone");
    private By senderEmailInput = By.id("senderEmail");
    private By receiverNameInput = By.id("receiverName");
    private By receiverCompanyInput = By.id("receiverCompanyName");
    private By receiverPostalCodeInput = By.id("recipientPostalCode");
    private By receiverCityInput = By.xpath("//*[@id=\"collapseTwo\"]/div/div/div[2]/fieldset/div/div[4]/input[1]");
    private By receiverStreetInput = By.xpath("//*[@id=\"collapseTwo\"]/div/div/div[2]/fieldset/div/div[5]/input[1]");
    private By receiverHouseNumberInput = By.id("receiverHouseNumber");
    private By receiverFlatNumberInput = By.id("receiverFlatNumber");
    private By receiverPhoneInput = By.id("receiverPhone");
    private By receiverEmailInput = By.id("receiverEmail");
    private By headingDrp = By.id("headingTwo");
    private By deliveryCheckbox = By.xpath("//*[@id=\"collapseTwoAndHalf\"]/div/div/div/fieldset/div/div[2]/div/label");
    private By deliveryPlaceDrp = By.xpath("//*[@id=\"collapseTwoAndHalf\"]/div/section/div[2]/div[2]/div/div[1]/div[1]");
    private By deliveryInput = By.xpath("//*[@id=\"collapseTwoAndHalf\"]/div/section/div[2]/div[2]/div[1]/div[1]/div[1]/input");
    private By chornobiDrp = By.xpath("//*[@id=\"collapseTwoAndHalf\"]/div/section/div[2]/div[2]/div/div[1]/div[2]/div/div/div[3]/div");
    private By itemDescriptionInput = By.id("parcelItemDescription");
    private By itemQuantityInput = By.id("parcelItemQuantity");
    private By itemWeightInput = By.id("parcelItemWeight");
    private By itemValueInput = By.id("parcelItemValueClientCurrency");
    private By firstCheckbox = By.xpath("//*[@id=\"js-calculator-content\"]/section[2]/form/fieldset/div[2]");
    private By secondCheckbox = By.xpath("//*[@id=\"js-calculator-content\"]/section[2]/form/fieldset/div[3]");
    private By thirdCheckbox = By.xpath("//*[@id=\"js-calculator-content\"]/section[2]/form/fieldset/div[4]");
    private By nextStepBtn = By.xpath("//*[@id=\"js-calculator-content\"]/section[2]/form/fieldset/div[6]/div[2]/button");

    PackageModel packageModel = new PackageModel();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public PackagePage() {
        setLogger(PackagePage.class.getName());
    }

    public void completeCheckPrice() {
        waitSendkeys(Wait.VISIBLE, cityFromInput, packageModel.getCityFrom(), "Kielce");
        waitSendkeys(Wait.VISIBLE, cityToInput, packageModel.getCityTo(), "Chornobai");
        waitSendkeys(Wait.VISIBLE, weightInput, packageModel.getWeight(), "11");
        waitClick(Wait.VISIBLE, submitBtn, packageModel.getSubmit());
        clickable(choosePackageBtn);
        waitClick(Wait.VISIBLE, choosePackageBtn, packageModel.getChoosePackage());
    }

    public void completeSender() {
        waitSendkeys(Wait.VISIBLE, senderNameInput, packageModel.getSenderName(), "Mobisense Maciej Balasiński");
        waitSendkeys(Wait.VISIBLE, senderPostalCodeInput, packageModel.getSenderPostalCodeInput(), "25-663");
        waitSendkeys(Wait.VISIBLE, senderCityInput, packageModel.getSenderCityInput(), "Kielce");
        waitSendkeys(Wait.VISIBLE, senderStreetInput, packageModel.getSenderStreetInput(), "Olszewskiego");
        waitSendkeys(Wait.VISIBLE, senderHouseNumberInput, packageModel.getSenderHouseNumberInput(), "6");
        waitSendkeys(Wait.VISIBLE, senderFlatNumberInput, packageModel.getSenderFlatNumberInput(), "313");
        waitSendkeys(Wait.VISIBLE, senderPhoneInput, packageModel.getSenderPhoneInput(), "+48505032236");
        waitSendkeys(Wait.VISIBLE, senderEmailInput, packageModel.getSenderEmailInput(), "maciej@sourceful");
    }

    public void completeReceiver() {
        waitSendkeys(Wait.VISIBLE, receiverNameInput, packageModel.getReceiverNameInput(), "Natalia Ivanova");
        waitSendkeys(Wait.VISIBLE, receiverCompanyInput, packageModel.getReceiverCompany(), "Natalia");
        waitSendkeys(Wait.VISIBLE, receiverPostalCodeInput, packageModel.getReceiverPostalCodeInput(), "19900");
        waitSendkeys(Wait.VISIBLE, receiverCityInput, packageModel.getReceiverCityInput(), "Chornobai");
        waitSendkeys(Wait.VISIBLE, receiverStreetInput, packageModel.getReceiverStreetInput(), "Lenina St");
        waitSendkeys(Wait.VISIBLE, receiverHouseNumberInput, packageModel.getReceiverHouseNumberInput(), "1");
        waitSendkeys(Wait.VISIBLE, receiverFlatNumberInput, packageModel.getReceiverFlatNumberInput(), "1");
        waitSendkeys(Wait.VISIBLE, receiverPhoneInput, packageModel.getReceiverPhoneInput(), "+48505032236");
        waitSendkeys(Wait.VISIBLE, receiverEmailInput, packageModel.getReceiverEmailInput(), "natalia@ivanova");
    }

    public void completeDelivery() {
        waitClick(Wait.VISIBLE, deliveryCheckbox, packageModel.getDeliveryCheckbox());
        js.executeScript("window.scrollBy(0,500)");
        waitClick(Wait.CLICKABLE, deliveryPlaceDrp,packageModel.getDeliveryPlaceDrp());
        waitSendkeys(Wait.CLICKABLE, deliveryInput, packageModel.getDeliveryPlaceDrp(), "Chornobai");
        waitClick(Wait.CLICKABLE, deliveryInput, packageModel.getDeliveryPlaceDrp());
        waitClick(Wait.VISIBLE, chornobiDrp, packageModel.getChornobiDrp());
    }

    public void completeItem() {
        js.executeScript("window.scrollBy(0,500)");
        waitSendkeys(Wait.VISIBLE, itemDescriptionInput, packageModel.getItemDescriptionInput(), "Czekoladki");
        waitSendkeys(Wait.VISIBLE, itemQuantityInput, packageModel.getItemQuantityInput(), "2");
        waitSendkeys(Wait.VISIBLE, itemWeightInput, packageModel.getItemWeightInput(), "10");
        waitSendkeys(Wait.VISIBLE, itemValueInput, packageModel.getItemValueInput(), "20");
    }

    public void completeCheckboxes() {
        js.executeScript("window.scrollBy(0,500)");
        waitClick(Wait.VISIBLE, firstCheckbox, packageModel.getFirstCheckbox());
        waitClick(Wait.VISIBLE, secondCheckbox, packageModel.getSecondCheckbox());
        waitClick(Wait.VISIBLE, thirdCheckbox, packageModel.getThirdCheckbox());
    }

    public void completeNext() {
        waitClick(Wait.VISIBLE, nextStepBtn, packageModel.getNextStepBtn());
    }
}
