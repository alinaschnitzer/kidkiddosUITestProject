import Pages.*;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest extends UseCaseBase {
    private static MainPage mainPage;
    private static BooksResultPage booksResultPage;
    public static final Logger logger = LogManager.getLogger(MainPageTest.class);

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToMainPage();
    }

    @Test
    public void mainPageLoadPage() {
        logger.info("Main page load test");
        Boolean success = mainPage.isLogoVisible();
        mainPage.takeScreenshot("MainPageTest");
        assertTrue(success);
    }

    @Test
    public void openContactUsPage() {
        ContactUsPage contactUsPage = mainPage.openContactUsTab();
        boolean isLoaded = contactUsPage.isPageTitleVisible();
        assertTrue(isLoaded);

    }

    @Test
    public void openLoginPageTest() {
        LoginPage loginPage = mainPage.clickLoginPageButton();
        boolean isLoaded = loginPage.isPageHeaderVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void emptyUsernameAndPasswordBoxText() {
        LoginPage loginPage = mainPage.clickLoginPageButton();
        loginPage.clickSingInButton();
        boolean isLoaded = loginPage.isErrorMessageVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void logInWithIncorrectCredential() {
        LoginPage loginPage = mainPage.clickLoginPageButton();
        loginPage.enterCredential();
        boolean isLoaded = loginPage.isErrorMessageVisible();
        assertTrue(isLoaded);
    }
    @Test
    public void chooseBookByLanguage () throws InterruptedException {
        BooksResultPage booksResultPage = mainPage.openDropDownMenu();
        mainPage.chooseEnglishOnly();
        boolean isEnglishBookPageLoaded = booksResultPage.isProductEnglishPageVisible();
        assertTrue(isEnglishBookPageLoaded);

        ProductPage productPage = booksResultPage.chooseBook();
        boolean isBookPageLoaded = productPage.isPageVisible();
        assertTrue(isBookPageLoaded);
        productPage.chooseFormat();
        productPage.changeNumber();
        Thread.sleep(2000);

        CartPage cartPage = productPage.addToCart();
        boolean isCartPageLoaded = productPage.isCartPageOpened();
        assertTrue(isCartPageLoaded);
        cartPage.changeQuantityInCart();
        Thread.sleep(2000);
        cartPage.updatedPage();
        boolean isQtyUpdated = cartPage.verifyUpdatedQty();
        assertTrue(isQtyUpdated);

        String isSubtotalUpd = cartPage.verifyUpdatedSubtotal();
        assertEquals("203.94", isSubtotalUpd);
    }
}



