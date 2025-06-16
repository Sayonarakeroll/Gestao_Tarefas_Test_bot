package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.pages.PaginaLogin;
import org.pages.PaginaPrincipal;
import org.pages.PaginaRegistro;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistroTests {

    private WebDriver driver;
    private PaginaLogin paginaLogin;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("credentials_Password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("http://localhost:5173/login");
        paginaLogin = new PaginaLogin(driver);

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    @DisplayName("Cenario 101: Registro com credenciais válidas")
    void testeRegistroComSucesso() {
        PaginaRegistro paginaRegistro = paginaLogin.navegarParaRegistro();

        String nome = "Hanna" + System.currentTimeMillis();
        String sobrenome = "Fonte";
        String email = "fonte" + System.currentTimeMillis() + "@teste.com";
        String senha = "123456";
        String funcao = "Administrador";
        String entidade = "SerEducacional";

        paginaRegistro.realizarRegistro(nome,sobrenome,email,senha, funcao,entidade);

    }
    @Test
    @Order(2)
    @DisplayName("Cenario 102: Registro campo nome em branco")
    void testeRegistroCampoNomeEmBranco(){
        PaginaRegistro paginaRegistro = paginaLogin.navegarParaRegistro();

        String nome= "";
        String sobrenome = "Fonte";
        String email = "fonte" + System.currentTimeMillis() + "@teste.com";
        String senha = "senha12345";
        String funcao = "Administrador";
        String entidade = "SerEducacional";


        paginaRegistro.realizarRegistro("", sobrenome, email, senha, funcao, entidade);
    }
    @Test
    @Order(3)
    @DisplayName("Cenario 103: Registro todos campos em branco")
    void testeRegistroTodosCamposEmBrancos(){
        PaginaRegistro paginaRegistro = paginaLogin.navegarParaRegistro();

        String nome= "";
        String sobrenome = "";
        String email = "";
        String senha = "";
        String funcao = "Administrador";
        String entidade = "SerEducacional";

        paginaRegistro.realizarRegistro("","","","", funcao,entidade);
    }
}