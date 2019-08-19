package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
	public static WebDriver  createChrome() {
		/**
		 * Caminho do driver no disco C, executando no Chrome; Abrindo o navegador
		 */
		System.setProperty("webdriver.chrome.driver", "C://Windows//chromedriver.exe");
	
		WebDriver navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // tempo default de espera por elementos na
																			// tela
		navegador.manage().window().maximize(); // Maximizando a tela
		/**
		 * Acessando a pagina web
		 */
		navegador.get("http://www.juliodelima.com.br/taskit");
		return navegador;
	}
}
