package co.com.qa.stepdefinitions;

import co.com.qa.pages.LoginPage;
import co.com.qa.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class LoginStepDefinitions {

    LoginPage loginPage;
    ProductsPage productsPage;

    @Managed
    WebDriver driver;

    @Given("que el usuario esta en la pagina de login")
    public void queElUsuarioEstaEnLaPaginaDeLogin() {
        loginPage.open();
    }

    @When("ingresa usuario {string} y clave {string}")
    public void ingresaUsuarioYClave(String usuario, String clave) {
        loginPage.ingresarUsuario(usuario);
        loginPage.ingresarClave(clave);
        loginPage.clickLogin();
    }

    @Then("deberia ver la pagina principal")
    public void deberiaVerLaPaginaPrincipal() {
        assertTrue("No se visualiza el titulo en Products",
                productsPage.isTitleVisible());
        assertEquals("El titulo no es Products",
                "Products", productsPage.getTitleText());
    }

    @Then("deberia ver un mensaje de error")
    public void deberiaVerUnMensajeDeError() {
        String error = loginPage.obtenerMensajeError().toLowerCase();
        assertTrue("No apareció mensaje de error o no coincide. Mensaje: " + error,
                error.contains("username and password") || error.contains("do not match"));
    }

    @Then("deberia ver mensajes de campos requeridos")
    public void deberiaVerMensajesDeCamposRequeridos() {
        String error = loginPage.obtenerMensajeError().toLowerCase();

        // cubre ambos casos:
        // "Username is required" o "Password is required"
        assertTrue("No aparecio el mensaje requerido. Mensaje: " + error,
                error.contains("required") && (error.contains("username") || error.contains("password")));
    }
}
