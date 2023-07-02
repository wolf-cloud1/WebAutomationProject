package automation.StepDefinition;

import automation.Page.WebBasePage;
import io.cucumber.java.en.Given;

import static automation.Runner.TestRunner.driver;


public class LoginDefinition {

    static WebBasePage webBasePage;


    @Given("^Abro el navegador \"(.*)\"$")
    public static void abrirNavegador(String browser) {
        WebBasePage.navigateToGoogle(browser);
        driver.navigate().refresh();
        System.out.println("Se abre el navegador: "+ browser +" correctamente.");
        webBasePage.ClearBrowserCache();
        System.out.println("Se elimina el cache del navegador: "+ browser +" correctamente.");
    }

    @Given("^Ingreso a la pagina de busqueda de Google$")
    public void ingresoALaPaginaDeBusquedaDeGoogle() {

    }

    // Resto de los pasos del escenario
}
