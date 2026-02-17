package co.com.qa.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {

    @FindBy(id = "user-name")
    WebElementFacade txtUsuario;

    @FindBy(id = "password")
    WebElementFacade txtClave;

    @FindBy(id = "login-button")
    WebElementFacade btnLogin;

    @FindBy(css = "h3[data-test='error']")
    WebElementFacade lblError;

    public void ingresarUsuario(String usuario) {
        txtUsuario.type(usuario);
    }

    public void ingresarClave(String clave) {
        txtClave.type(clave);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public String obtenerMensajeError() {
        return lblError.getText();
    }
}
