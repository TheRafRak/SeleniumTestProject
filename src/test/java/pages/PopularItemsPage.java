package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class PopularItemsPage extends BasePage {

    public PopularItemsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#htmlcontent_home .item-link")
    List<WebElement> itemLinks;

    public List<String> getItemLinks() {
        return itemLinks.stream()
                .map(element -> element.getText().trim())
                .collect(Collectors.toList());
    }
}
