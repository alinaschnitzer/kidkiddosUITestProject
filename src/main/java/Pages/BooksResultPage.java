package Pages;

public class BooksResultPage extends BasePage {

    public static final String ENGLISH_ONLY_HEADER = "//h1[text()= 'English Only']";
    private static final String BOOK = "/html/body/div[3]/main/div/div/div/div/div[1]/div/a/div[1]";


    public boolean isProductEnglishPageVisible() {
        return elementExists(ENGLISH_ONLY_HEADER);}

    public ProductPage chooseBook() {
        findElementByXpath(BOOK).click();
        return new ProductPage();}





}
