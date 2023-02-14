package Pages;

public class CartPage extends BasePage{
    private static final String CART_QTY_BOX = "//input[@class='cart__qty-input']";
    private static final String UPDATE_BUTTON = "//*[@class='btn btn--secondary cart__update cart__update--large small--hide']";
    private static final String SUBTOTAL_CART ="//*[text() = '203.94']";
    private static final String QTY_UPDATED = "//input[@value='6']";

    public CartPage changeQuantityInCart (){
        findElementByXpath(CART_QTY_BOX).clear();
        sendTextToElementByXpath(CART_QTY_BOX,"6");
        return new CartPage();}

    public CartPage updatedPage (){
        findElementByXpath(UPDATE_BUTTON).click();
        return new CartPage();}

    public boolean verifyUpdatedQty (){
        return elementExists(QTY_UPDATED);}

    public String verifyUpdatedSubtotal (){
       String updValue =  findElementByXpath(SUBTOTAL_CART).getText();
        return updValue;}
}
