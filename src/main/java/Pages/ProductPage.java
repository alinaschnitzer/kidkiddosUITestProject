package Pages;

public class ProductPage extends BasePage {

    private static final String IMG_OF_BOOK = "//img[@id = 'FeaturedImage-product-template']";
    private static final String FORMAT = "//*[@data-index='option1']//following-sibling::*[@value='Hardcover']";
    private static final String QUANTITY = "//input[@id='Quantity']";
    private static final String ADD_CART_BUTTON = "//button[@id='AddToCart-product-template']";
    private static final String YOUR_CART_HEADER = "//*[text()='Your cart']";


    public boolean isPageVisible (){
        return elementExists(IMG_OF_BOOK);}

    public ProductPage chooseFormat (){
      findElementByXpath(FORMAT).click();
      return new ProductPage();}

    public ProductPage changeNumber (){
        findElementByXpath(QUANTITY).clear();
        sendTextToElementByXpath(QUANTITY,"5");
        return new ProductPage();}

    public CartPage addToCart (){
        findElementByXpath(ADD_CART_BUTTON).click();
        return new CartPage();}

    public boolean  isCartPageOpened (){ return elementExists(YOUR_CART_HEADER);}

}
