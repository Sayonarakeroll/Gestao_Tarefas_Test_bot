package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PaginaRegistro extends Pagina {

    @FindBy(name = "first_name")
    private WebElement campoPrimeiroNome;

    @FindBy(name = "last_name")
    private WebElement campoSegundoNome;

    @FindBy(name ="email")
    private WebElement campoEmail;

    @FindBy(name = "password")
    private WebElement campoSenha;

    @FindBy(name = "role")
    private WebElement dropdownFuncao;

    @FindBy(css ="button.btn.btn-primary")
    private WebElement botaoRegistrar;

    @FindBy(name = "newEntityName")
    private WebElement campoEntidade;

    public PaginaRegistro(WebDriver driver) {
        super(driver);
    }

    public PaginaLogin realizarRegistro(String nome,String sobrenome, String email, String senha, String funcao, String entidade) {
        wait.until(ExpectedConditions.visibilityOf(campoPrimeiroNome));
        campoPrimeiroNome.sendKeys(nome);
        campoSegundoNome.sendKeys(sobrenome);
        campoEmail.sendKeys(email);
        campoSenha.sendKeys(senha);
        Select dropdown = new Select(dropdownFuncao);
        dropdown.selectByVisibleText(funcao);
        campoEntidade.sendKeys(entidade);
        botaoRegistrar.click();

        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        return new PaginaLogin(driver);
    }
}