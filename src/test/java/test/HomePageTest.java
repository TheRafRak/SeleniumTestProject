package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PopularItemsPage;
import utils.PageTitleUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends BaseTest {

    private PopularItemsPage popularItemsPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        popularItemsPage = new PopularItemsPage(driver);
    }

    @Test
    public void ShouldDisplayPopularItemsOnHomePage() {
        List<String> itemLinks = popularItemsPage.getItemLinks();

        List<String> invisibleElements = itemLinks.stream().filter(element -> !element.isEmpty()).collect(Collectors.toList());

        assertThat(invisibleElements).isEmpty();
    }
}
