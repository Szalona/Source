package step;

import cucumber.api.java.en.*;
import platform.PackagePage;

public class PackageStep {
    PackagePage pricePage = new PackagePage();

    @Given("^user complete first form$")
    public void completeMainPage() {
        pricePage.completeCheckPrice();
    }

    @When ("^user write user data$")
    public void completeUserData() {
        pricePage.completeSender();
    }

    @And ("^user write recipient data$")
    public void completeReceiverData() {
        pricePage.completeReceiver();
    }

    @And ("^user choose delivery place$")
    public void completeDelivery() {
        pricePage.completeDelivery();
    }

    @And ("^user write declaration$")
    public void completeItem() {
        pricePage.completeItem();
    }

    @And ("^user choose three checkbox$")
    public void completeCheckbox() {
        pricePage.completeCheckboxes();
    }

    @Then ("^user go to next page$")
    public void completeNext() {
        pricePage.completeNext();
    }
}
