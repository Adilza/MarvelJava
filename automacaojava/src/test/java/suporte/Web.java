package suporte;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Web {
	public static final String USERNAME = "adilzamattos1";
	public static final String AUTOMATE_KEY = "ytzpWscMbzFcXgzjNraq";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static WebDriver createChrome() {
		/**
		 * Caminho do driver no disco C, executando no Chrome; Abrindo o navegador
		 */
		System.setProperty("webdriver.chrome.driver", "C://Windows//chromedriver.exe");

		WebDriver navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //tempo de espera
		navegador.manage().window().maximize(); // Maximizando a tela
		/**
		 * Acessando a pagina web
		 */
		navegador.get("http://www.juliodelima.com.br/taskit");
		return navegador;
	}

	public static WebDriver createBrowserStack() {
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "76.0");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "7");
	    caps.setCapability("resolution", "1024x768");
	    caps.setCapability("name", "Bstack-[Java] Sample Test");

	    WebDriver navegador = null;
	    try {
	    	navegador =new RemoteWebDriver(new URL(URL), caps);
	    	navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	    	 navegador.get("http://www.juliodelima.com.br/taskit");
		} catch (MalformedURLException e) {
			System.out.println("Hoveram problemas com a url" + e.getMessage());
		}
	    		
	    
	    return navegador;
	}
}
