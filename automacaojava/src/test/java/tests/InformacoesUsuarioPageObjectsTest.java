package tests;

import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;
import pages.MePage;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioPageObjectsTest.csv")
public class InformacoesUsuarioPageObjectsTest {
	private WebDriver navegador;

	@Rule
	public TestName test = new TestName();

	@Before
	public void setUp() {
		//navegador = Web.createChrome();
		navegador = Web.createBrowserStack(); //na nuvem
	}

	@Test
	public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name = "login") String login,
			@Param(name = "senha") String senha, @Param(name = "tipo") String tipo,
			@Param(name = "contato") String contato, @Param(name = "mensagem") String mensagemEsperada) {
		String textoToast = new LoginPage(navegador).clicarSignIn().fazerLogin(login, senha).clicarMe()
				.clicarAbaMoreDataAboutYou().clicarBotaoMoreDataAboutYou().adicionarContato(tipo, contato)
				.capturarTextoToast();

		assertEquals(mensagemEsperada, textoToast);
		Screenshot.tirar(navegador, "C:\\Adilza\\20190711_Automacao\\Test-report\\taskit"
				+ Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
	}

	/*
	 * @Test public void testReremoverUmContatoDeUmUsuario(
	 * 
	 * @Param(name="telefone")String telefone,
	 * 
	 * @Param(name="mensagem")String mensagemEsperada ) { String txtToast =new
	 * MePage(navegador) .clicarLinkRemoverContato(telefone) .aceitarAlerta()
	 * .capturarTextoToast();
	 * 
	 * assertEquals(mensagemEsperada, txtToast); Screenshot.tirar(navegador,
	 * "C:\\Adilza\\20190711_Automacao\\Test-report\\taskit" +
	 * Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");
	 * 
	 * }
	 */
	@After
	public void tearDown() {
		navegador.quit();
	}
}
