package passos.paginas;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Compartilhado.Passo;

public class PassosTestes {

	private final By btncriarconta = By
			.xpath("//div[@id='view_container']/div/div/div[2]/div/div[2]/div/div[2]/div/div/content/span");
	private final By vNome = By.id("firstName");
	private final By vSobreNome = By.id("lastName");
	private final By vNomeUsuario = By.id("username");
	private final By vSenha = By.name("Passwd");
	private final By vConfirmarSenha = By.name("ConfirmPasswd");
	private final By Proximo = By.xpath("//div[@id='accountDetailsNext']/content/span");
	private final By vTelefone = By.id("phoneNumberId");
	private final By vEmailRecu = By.xpath("//input[@type='text']");
	private final By vDia = By.id("day");
	private final By vMes = By.id("month");
	private final By vAno = By.id("year");
	private final By vGenero = By.id("gender");
	private final By vProximo2 = By.xpath("//div[@id='personalDetailsNext']/content/span");
	private final By vAgoraNao = By.xpath("//div[@id='view_container']/form/div[2]/div/div[3]/div/div[2]/button");
	private final By vIproximo = By.cssSelector("span > svg");
    private final By vIproximo2 = By.cssSelector("span > svg");
    private final By vIproximo3 = By.cssSelector("span > svg");
	private final By vConcordo = By.xpath("//div[2]/div/div/div/content/span");
	private final By vProximoFim = By.name("welcome_dialog_next");
	private final By vOk = By.name("ok");
	WebDriver driver;
	Passo passo;

	WebDriverWait wait;

	public PassosTestes(WebDriver driver) {
		this.driver = driver;
		passo = new Passo(driver);
		wait = new WebDriverWait(driver, 30);
	}

	public PassosTestes AcessaPagina(String arg) {
		try {
			driver.switchTo().defaultContent();
			driver.manage().deleteAllCookies();

			driver.navigate().to("http://www.gmail.com");

		} catch (Exception e) {
			System.err.println(e);
		}

		return new PassosTestes(driver);
	}

	public PassosTestes CriarConta() {
		passo.clicar(btncriarconta);
		return new PassosTestes(driver);
	}

	public PassosTestes vNome(String argPg) {
		passo.digitar(vNome, argPg);
		return new PassosTestes(driver);
	}

	public PassosTestes vSobreNome(String argPg) {
		passo.digitar(vSobreNome, argPg);
		return new PassosTestes(driver);
	}

	public PassosTestes vNomeUsuario(String argPg) {
		passo.digitar(vNomeUsuario, argPg);
		return new PassosTestes(driver);
	}

	public PassosTestes vSenha(String argPg) {
		passo.digitar(vSenha, argPg);
		return new PassosTestes(driver);
	}

	public PassosTestes vConfirmarSenha(String argPg) {
		passo.digitar(vConfirmarSenha, argPg);
		return new PassosTestes(driver);
	}

	public PassosTestes Proximo() {
		passo.clicar(Proximo);
		return new PassosTestes(driver);
	}

	public PassosTestes vTelefone(String argPg) {
		passo.digitar(vTelefone, argPg);
		return new PassosTestes(driver);
	}

	public PassosTestes vEmailRecu(String argPg) {
		passo.digitar(vEmailRecu, argPg);
		return new PassosTestes(driver);
	}

	public PassosTestes vDia(String argPg) {
		passo.digitar(vDia, argPg);
		return new PassosTestes(driver);
	}

	public PassosTestes vMes(String arg, String arg1) {
		// By itemFiltro = By.id("filtros0.tipoPessoa");
		passo.selecionar(vMes, arg1);
		return new PassosTestes(driver);
	}

	public PassosTestes vAno(String argPg) {
		passo.digitar(vAno, argPg);
		return new PassosTestes(driver);
	}

	public PassosTestes vGenero(String arg, String arg1) {
		// By itemFiltro = By.id("filtros0.tipoPessoa");
		passo.selecionar(vGenero, arg1);
		return new PassosTestes(driver);
	}

	public PassosTestes vProximo2() {
		passo.clicar(vProximo2);
		return new PassosTestes(driver);
	}

	public PassosTestes vAgoraNao() {
		passo.clicar(vAgoraNao);
		return new PassosTestes(driver);
	}
	public PassosTestes vIproximo() {
		passo.clicar(vIproximo);
		return new PassosTestes(driver);
	}
	public PassosTestes vIproximo2() {
		passo.clicar(vIproximo2);
		return new PassosTestes(driver);
	}
	public PassosTestes vIproximo3() {
		passo.clicar(vIproximo3);
		return new PassosTestes(driver);
	}
	public PassosTestes vConcordo() {
		passo.clicar(vConcordo);
		return new PassosTestes(driver);
	}

	public PassosTestes vProximoFim() {
		passo.clicar(vProximoFim);
		return new PassosTestes(driver);
	}

	public PassosTestes vOk() {
		passo.clicar(vOk);
		return new PassosTestes(driver);
	}
}
