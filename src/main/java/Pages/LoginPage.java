package Pages;

import Consts.Consts;

public class LoginPage extends BasePage{
    private static final String LOGIN_HEADER = "//h1[text()= 'Login']";
    private static final String ERROR_MESSAGE = "//li[text()= 'Incorrect email or password.']";
    private static final String SIGN_IN = "//input[@value = 'Sign In']";
    private static final String EMAIL_BOX = "//input[@id ='CustomerEmail']";
    private static final String PASSWORD_BOX = "//input[@id ='CustomerPassword']";

    public boolean isPageHeaderVisible (){
        return elementExists(LOGIN_HEADER);}


    public boolean isErrorMessageVisible (){
        return elementExists(ERROR_MESSAGE);}

    public LoginPage clickSingInButton() {
        clickElementByXpath(SIGN_IN);
        return new LoginPage();}

    public void  enterCredential() {
        sendTextToElementByXpath(EMAIL_BOX,"adfdkdjdfd@gmail.com");
        sendTextToElementByXpath(PASSWORD_BOX,"adfdkdjdfd");
        clickElementByXpath(SIGN_IN);}


}
