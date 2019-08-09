package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Adilza
 *
 */
public class InformacoesUsuariosTest {
	private WebDriver navegador;

	@Before
	public void setUp() {
		/**
		 * Caminho do driver no disco C, executando no Chrome; Abrindo o navegador
		 */
		System.setProperty("webdriver.chrome.driver", "C://20190711_Automacao//Driver//chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // tempo default de espera por elementos na
																			// tela
		navegador.manage().window().maximize(); // Maximizando a tela
		/**
		 * Acessando a pagina web
		 */
		navegador.get("http://www.juliodelima.com.br/taskit");
		/**
		 * 
		 */

	}

	@Test
	public void testAdicionarUmaInformacaoAdicionalDoUsuario() {

//		Efetuar login
		/**
		 * Clicar no link "Sign in"
		 */
		navegador.findElement(By.linkText("Sign in")).click();

		/**
		 * Identificar o form de id "signinbox"
		 */
		WebElement formSinginbox = navegador.findElement(By.id("signinbox"));

		/**
		 * Digitar no campo com nome "login" que esta dentro do form de id "signinbox"o
		 * texto "julio0001"
		 */
		formSinginbox.findElement(By.name("login")).sendKeys("julio0001");

		/**
		 * Digitar no campo com nome "password" que esta dentro do form de id
		 * "signinbox" o texto "123456"
		 */
		formSinginbox.findElement(By.name("password")).sendKeys("123456");

		/**
		 * Clicar no link "SIGN IN"
		 */
		navegador.findElement(By.linkText("SIGN IN")).click();

		/**
		 * Validar que dentro do elemento com class "me" esta o texto "Hi, Julio"
		 */
		WebElement me = navegador.findElement(By.className("me"));
		String textoNoElementoMe = me.getText();
		assertEquals("Hi, Julio", textoNoElementoMe);
		
		/**
		 * Clicar em um link que possui a class "me"
		 */
		navegador.findElement(By.className("me")).click();
		
		/**
		 * Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
		 */
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		/**
		 * Clicar no botão atraves do seu xpath //button[@data-target="addmoredata"]
		 */
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
		/**
		 * Identificar  a popup onde esta o formulario de id addmoredata 
		 */
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));
		/**
		 * No combo de name "type" escolher a opção "Phone"
		 */
		WebElement campoType= popupAddMoreData.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText("Phone");
		/**
		 * No campo de name  "contact" digitar o numero +5571999998888
		 */
		popupAddMoreData.findElement(By.name("contact")).sendKeys("+5571988887777");
		/**
		 * Clicar no link de text "SAVE" que esta na popup
		 */
		popupAddMoreData.findElement(By.linkText("SAVE")).click();
		/**
		 * Validar na mensagem de id "toast-container" que o texto é "Your contact has been added!"
		 */
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Your contact has been added!", mensagem);
	}

	@After
	public void tearDown() {
		/**
		 * Fechar navegador
		 */
		navegador.quit(); // fecha todas as abas
		// navegador.close(); //fecha apenas uma aba

	}
//testando
}
