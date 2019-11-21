package pageObjects.forms;

import framework.base.elements.Button;
import framework.utils.propertiesManager.PropertiesRead;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class MainMenu {
    private final String GAMES = PropertiesRead.readFromDictionary("games");
    private String storeNavigationLocator = "//*[@class='store_nav']";
    private String subMenuLocator = "//*[@id='genre_flyout']";
    static final Logger log = Logger.getLogger(MainMenu.class);

    private Button getMenuButton(String buttonName, String locator) {
        By elementLocator = By.xpath(String.format(locator + "//a[contains(text(), '%s')]", buttonName));
        return new Button(buttonName, elementLocator);
    }

    public void gameGenreClick(String genre) {
        Button gamesButton = getMenuButton(GAMES, storeNavigationLocator);
        gamesButton.hover();
        Button genreButton = getMenuButton(genre, subMenuLocator);
        genreButton.click();
    }
}
