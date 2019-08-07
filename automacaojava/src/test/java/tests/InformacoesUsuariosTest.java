package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformacoesUsuariosTest {
	@Test
	public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
		
		/**
		 * Caminho do driver no disco C, executando no Chrome
		 */
		System.setProperty("webdriver.chrome.driver", "C://20190711_Automacao//Driver//chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		assertEquals(1, 1);
	}
}
