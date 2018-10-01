package Compartilhado;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.runtime.junit.ExecutionUnitRunner;
import cucumber.runtime.junit.JUnitReporter;
import gherkin.formatter.model.Step;

public class SetConfiguracao {
	
	private static WebDriver driver = null;
//	public static WebDriverWait waitVar = null;
	String gridAddress ="10.199.1.143:4477/";

	
	DesiredCapabilities capability;
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		SetConfiguracao.driver = driver;
	}

	public SetConfiguracao(){
		
	}
	public SetConfiguracao(int browserType) {
	    try {
			driver = getWebDriver(browserType);
//			waitVar = new WebDriverWait(driver, 30);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void closeBrowser() {
//		driver.close();
	    driver.quit();
//	    driver = null;
	}

	public WebDriver getWebDriver(int browserType) throws MalformedURLException {
//		if(driver == null){
			switch (browserType) {
//		     case "Firefox":
			case 1:
				FirefoxOptions optionsF = new FirefoxOptions();
				optionsF.addArguments("--start-maximized");
		    	capability = DesiredCapabilities.firefox();
		    	capability.setCapability("marionette", true);
		    	optionsF.merge(capability);
		    	 return new RemoteWebDriver(new URL("http://" + gridAddress + "/wd/hub"), optionsF);
//		 	case "IE":
			case 2:
		 		capability = DesiredCapabilities.internetExplorer();
		 		capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		    	 return new RemoteWebDriver(new URL("http://" + gridAddress + "/wd/hub"), capability);
//		     case "Chrome":
			case 3:
				ChromeOptions optionsC = new ChromeOptions(); 
				optionsC.addArguments("--start-maximized");
				optionsC.addArguments("use-fake-ui-for-media-stream");	    	 
		    	 capability = DesiredCapabilities.chrome();
		    	 capability.setBrowserName("chrome");
		    	 capability.setCapability(ChromeOptions.CAPABILITY, optionsC); 
		    	 return new RemoteWebDriver(new URL("http://" + gridAddress + "/wd/hub"), capability);
		     default:
		         throw new RuntimeException("Browser Não Suportado!!!!");
		    }
//		}else {
//			return driver;
//		}
	}
	
	
	static String resp = "";
	private Map<Integer, String> elementos = new HashMap<Integer, String>();

	@SuppressWarnings("unchecked")
	public String getSteps(Scenario scenario) {
		resp = "";
		for (Field campo : scenario.getClass().getDeclaredFields()) {
			if (campo.getName().equals("reporter")) {
				campo.setAccessible(true);
				try {
//					TestNgReporter reporter = (TestNgReporter) campo.get(scenario);
					JUnitReporter reporter = (JUnitReporter) campo.get(scenario);
					// ******************************************************************
					for (Field campoExecutionUnitRunner : reporter.getClass().getDeclaredFields()) {
						if (campoExecutionUnitRunner.getName().equals("executionUnitRunner")) {
							campoExecutionUnitRunner.setAccessible(true);
							ExecutionUnitRunner executionUnitRunner = (ExecutionUnitRunner) campoExecutionUnitRunner
									.get(reporter);
							// ******************************************************************
							for (Field campoStepDescriptions : executionUnitRunner.getClass().getDeclaredFields()) {
								if (campoStepDescriptions.getName().equals("stepDescriptions")) {
									campoStepDescriptions.setAccessible(true);
									Map<Step, Description> stepDescriptions = (Map<Step, Description>) campoStepDescriptions
											.get(executionUnitRunner);
									for (Step descr : stepDescriptions.keySet()) {
										// System.out.println(descr.getName());
										// System.out.println(descr.getLine());
										elementos.put(descr.getLine(), descr.getName());
									}

									Map<Integer, String> treeMap = new TreeMap<Integer, String>(elementos);
									resp = printMap(treeMap);
									// Map<Integer, String> sortedNewMap = elementos.entrySet().stream().
									// sorted((e1,e2)->e1.getKey().compareTo(e2.getKey())).collect(Collectors.
									// toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e1,
									// LinkedHashMap::new));
									// sortedNewMap.forEach((key,val)->{
									//// System.out.println(key+ " = "+ val.toString());
									// resp += val.toString() + "\n";
									// });
								}

							}
						}
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// System.out.println(resp);
		return resp;
	}

	public static <K, V> String printMap(Map<K, V> map) {
		String arg = "";
		for (Map.Entry<K, V> entry : map.entrySet()) {
			// System.out.println("Key : " + entry.getKey() + " Value : " +
			// entry.getValue());
			arg += "<p>" + entry.getValue() + "</p>";
		}
		return arg;
	}

}


