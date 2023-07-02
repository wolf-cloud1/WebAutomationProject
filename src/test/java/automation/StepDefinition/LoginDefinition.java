package automation.StepDefinition;

import automation.Runner.TestRunner;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;

public class LoginDefinition {

    private WebDriver driver;

    @Given("^Abro el navegador \"(.*)\"$")
    public void abrirNavegador(String browser) {
        WebDriver driver = TestRunner.getDriver(browser);


    }

    // Resto de los pasos del escenario
}
