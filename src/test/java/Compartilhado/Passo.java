package Compartilhado;

import org.junit.Assert;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Passo extends JSWaiter{
	WebDriver driver;
	public static WebDriverWait wait;

	public Passo(WebDriver driver) {
		this.driver = driver;
		setDriver(driver);
		wait = new WebDriverWait(driver, 60);
		waitGifLoading();
		waitForLoadPage();
		waitUntilJQueryReady();
		waitJQueryAngular();
		waitGifLoading();
	}

	public Passo digitar(By iArg, String arg) {
		waitUntilJQueryReady();
		wait.until(ExpectedConditions.elementToBeClickable(iArg));
		WebElement senhaAcesso = driver.findElement(iArg);
		senhaAcesso.clear();
		senhaAcesso.sendKeys(arg);
		senhaAcesso.sendKeys(Keys.TAB);
//		AceitaAlert();
		return new Passo(driver);
	}
	
	public Passo digitarComAlerta(By iArg, String arg) {
		waitUntilJQueryReady();
		wait.until(ExpectedConditions.elementToBeClickable(iArg));
		WebElement senhaAcesso = driver.findElement(iArg);
		senhaAcesso.clear();
		senhaAcesso.sendKeys(arg);
		senhaAcesso.sendKeys(Keys.TAB);
		AceitaAlert();
		return new Passo(driver);
	}
	
	public Passo digitarDataAtual(By iArg, String arg) {
		wait.until(ExpectedConditions.elementToBeClickable(iArg));
		if (arg.equals("")) {
			WebElement senhaAcesso = driver.findElement(iArg);
			senhaAcesso.clear();
			senhaAcesso.sendKeys(Keys.TAB);
		} else {
			int result = Integer.valueOf(arg.trim());
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, result);
			SimpleDateFormat dataPasta = new SimpleDateFormat("dd/MM/yyyy");

			WebElement senhaAcesso = driver.findElement(iArg);
			senhaAcesso.clear();
			senhaAcesso.sendKeys(dataPasta.format(calendar.getTime()));
			senhaAcesso.sendKeys(Keys.TAB);
		}
		return new Passo(driver);
	}

	public Passo clicar(By item) {
		wait.until(ExpectedConditions.elementToBeClickable(item));
		driver.switchTo().defaultContent();
		WebElement itemDig = driver.findElement(item);
		itemDig.click();
		return new Passo(driver);
	}
	
	public Passo clicarComAlerta(By item) {
		wait.until(ExpectedConditions.elementToBeClickable(item));
		driver.switchTo().defaultContent();
		WebElement itemDig = driver.findElement(item);
		itemDig.click();
		AceitaAlert();
		return new Passo(driver);
	}

	public Passo clicarJS(By item) {
		

		// wait.until(ExpectedConditions.elementToBeClickable(item));
		WebElement itemDig = driver.findElement(item);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", itemDig);
		// itemDig.click();
		return new Passo(driver);
	}

	public Passo selecionar(By item, String arg1) {
		

		wait.until(ExpectedConditions.elementToBeClickable(item));
		arg1 = arg1.trim();
		WebElement itemSelect = driver.findElement(item);
		Select itemselect = new Select(itemSelect);
		itemselect.selectByVisibleText(arg1);

		return new Passo(driver);
	}

	public Passo AceitaAlert() {
		try {
			wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Passo(driver);
	}

//	public Passo verifTextoPg(String arg1) {
//		
//
//		try {
//			driver.switchTo().defaultContent();
//			boolean validText = driver.getPageSource().contains(arg1);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			Assert.class.equals(obj)
//			assertEquals(true, validText);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return new Passo(driver);
//	}

	public Passo verifTextoItem(By item, String arg1) {
		

		try {
			WebElement itemSelect = driver.findElement(item);
			boolean validText = itemSelect.getAttribute("value").equals(arg1);
			assertEquals(true, validText);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new Passo(driver);
	}

	private void assertEquals(boolean b, boolean validText) {
	// TODO Auto-generated method stub
	
}

	public static String geraCPF() {
		String iniciais = "";
		Integer numero;
		for (int i = 0; i < 9; i++) {
			numero = new Integer((int) (Math.random() * 10));
			iniciais += numero.toString();
		}
		return iniciais + calcDigVerif(iniciais);
	}

	private static String calcDigVerif(String num) {
		Integer primDig, segDig;
		int soma = 0, peso = 10;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;

		if (soma % 11 == 0 | soma % 11 == 1)
			primDig = new Integer(0);
		else
			primDig = new Integer(11 - (soma % 11));

		soma = 0;
		peso = 11;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;

		soma += primDig.intValue() * 2;
		if (soma % 11 == 0 | soma % 11 == 1)
			segDig = new Integer(0);
		else
			segDig = new Integer(11 - (soma % 11));

		return primDig.toString() + segDig.toString();
	}

	public static String cnpj() {
		int n = 9;
		int n1 = randomiza(n);
		int n2 = randomiza(n);
		int n3 = randomiza(n);
		int n4 = randomiza(n);
		int n5 = randomiza(n);
		int n6 = randomiza(n);
		int n7 = randomiza(n);
		int n8 = randomiza(n);
		int n9 = 0;
		int n10 = 0;
		int n11 = 0;
		int n12 = 1;
		int d1 = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4
				+ n1 * 5;
		d1 = 11 - (mod(d1, 11));
		if (d1 >= 10)
			d1 = 0;
		int d2 = d1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4
				+ n2 * 5 + n1 * 6;
		d2 = 11 - (mod(d2, 11));
		if (d2 >= 10)
			d2 = 0;
		String retorno = null;
		if (comPontos)
			retorno = "" + n1 + n2 + "" + n3 + n4 + n5 + "" + n6 + n7 + n8 + "" + n9 + n10 + n11 + n12 + "" + d1 + d2;
		else
			retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10 + n11 + n12 + d1 + d2;
		return retorno;
	}

	private static int mod(int dividendo, int divisor) {
		return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
	}

	private static final boolean comPontos = true;

	private static int randomiza(int n) {
		int ranNum = (int) (Math.random() * n);
		return ranNum;
	}



	public boolean ValExistTexto(By campo) {
		String textoColetado = null;
		JavascriptExecutor jse = (JavascriptExecutor) SetConfiguracao.getDriver();
		textoColetado = (String) jse.executeScript("return arguments[0].value;",
				SetConfiguracao.getDriver().findElement(campo));
		System.out.println("Texto coletado : " + textoColetado);
		if(!textoColetado.equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
	public String ColetaTexto(By campo) {
		String textoColetado = null;
		JavascriptExecutor jse = (JavascriptExecutor) SetConfiguracao.getDriver();
		textoColetado = (String) jse.executeScript("return arguments[0].value;",
				SetConfiguracao.getDriver().findElement(campo));
//		System.out.println("Texto coletado : " + textoColetado);
		return textoColetado;
	}

	public String geraRandon(int tamanho) {
		Random rn = new Random();
		int numRd = rn.nextInt(tamanho);
		String retRand = Integer.toString(numRd);
		return retRand;

	}

	public String geraRandonDDMMAA() {

		try {
			Date now = new Date();
			DateFormat diaf = new SimpleDateFormat("dd");
			DateFormat mesf = new SimpleDateFormat("MM");
			DateFormat anof = new SimpleDateFormat("yy");

			String diaF = diaf.format(now);
			String mesF = mesf.format(now);
			String anoF = anof.format(now);

			String dataPasta = diaF + mesF + anoF;

			Random rn = new Random();
			int numRd = rn.nextInt(9999);
			System.out.println(dataPasta + numRd);

			String retNum = Integer.toString(numRd);
			return retNum;
		} catch (Exception E) {
			return null;
		}
	}

	public String geraDDMMAAhhmmss() {
		String resp = null;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			Date now = new Date();
			DateFormat diaf = new SimpleDateFormat("dd");
			DateFormat mesf = new SimpleDateFormat("MM");
			DateFormat anof = new SimpleDateFormat("yyyy");
			String diaF = diaf.format(now);
			String mesF = mesf.format(now);
			String anoF = anof.format(now);
			String dataPasta = diaF + "_" + mesF + "_" + anoF;
			Calendar calendar = Calendar.getInstance();
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);
			int second = calendar.get(Calendar.SECOND);
			String hms = Integer.toString(hour) + Integer.toString(minute) + Integer.toString(second);
			resp = dataPasta + "_" + hms;
		} catch (Exception e) {
			System.out.println(e);
		}
		return resp;
	}

	public void verifJS() {
		LogEntries jserros = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry error : jserros) {
			if (error.getMessage().contains("TypeError")) {
				System.out.print(error.getMessage());
				System.out.print(" -- " + driver.getCurrentUrl());
				System.out.println("");
				// Assert.assertTrue(false);
			}
		}
	}

	public boolean validaSeCodigoExiste(String arg) {
		
		waitForLoadPage();
		boolean textPagina = driver.getPageSource().contains(arg);
		if (textPagina) {
			return true;
		} else {
			return false;
		}
	}

	
	List<WebElement> rows;
	List<String> linhaList;
	public List<List<String>> getTabela(By tabela, By LC) {
		
		waitForLoadPage();
		List<List<String>> coluna = new ArrayList<List<String>>();
		rows = driver.findElements(tabela);
		for (int i = 0; i < rows.size(); i++) {
			linhaList = new ArrayList<String>();
			WebElement row = rows.get(i);
			List<WebElement> ElementCollectionHead = row.findElements(LC);
			for (WebElement webElement : ElementCollectionHead) {
//				System.out.println(webElement.getText());
				linhaList.add(webElement.getText());
			}
			coluna.add(linhaList);
		}
		return coluna;
	}
	
}