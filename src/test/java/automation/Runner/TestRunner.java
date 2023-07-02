package automation.Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Ruta de las carpetas que contienen las features
        glue = {"StepDefinition"}, // Ruta de las carpetas que contienen los Step Definitions
        plugin = {
                "pretty", // Reporte en formato legible para humanos
                "html:target/cucumber-reports", // Genera reportes HTML
                "json:target/cucumber-reports/cucumber.json" // Genera reportes JSON
        },
        tags = "@smoke", // Etiquetas de los escenarios que se ejecutarán (puedes usar @smoke, @regression, etc.)
        monochrome = true
)


//clase donde van a correr nuestras pruebas
public class TestRunner  {
        // Este archivo se utilizará para ejecutar los escenarios de Cucumber
        public static WebDriver driver;

        public static WebDriver getDriver(String browser) {
                //Dentro del método getDriver(), se utiliza una declaración de interruptor (switch) para determinar qué controlador de navegador debe utilizarse según el nombre del navegador pasado como argumento.
                if (driver == null) {
                        switch (browser.toLowerCase()) {
                                case "chrome":
                                        // Configuración del ChromeDriver
                                        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
                                        driver = new ChromeDriver();
                                        break;
                                case "firefox":
                                        // Configuración del FirefoxDriver
                                        System.setProperty("webdriver.gecko.driver", "ruta/al/geckodriver");
                                        driver = new FirefoxDriver();
                                        break;
                                case "edge":
                                        // Configuración del EdgeDriver
                                        System.setProperty("webdriver.edge.driver", "ruta/al/msedgedriver");
                                        driver = new EdgeDriver();
                                        break;
                                default:
                                        throw new IllegalArgumentException("El navegador especificado no es compatible: " + browser);
                        }
                }
                return driver;
        }
}
