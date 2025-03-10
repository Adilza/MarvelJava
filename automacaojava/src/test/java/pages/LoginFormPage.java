package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {

	public LoginFormPage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}

	// Metodo Estrutural
	public LoginFormPage digitarLogin(String login) {
		navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

		return this;
	}

	public LoginFormPage digitarPassword(String password) {
		navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);

		return this;
	}

	public SecretaPage clicarSignIn() {
		navegador.findElement(By.linkText("SIGN IN")).click();

		return new SecretaPage(navegador);
	}

	// Metodo Funcional
	public SecretaPage fazerLogin(String login, String senha) {
		return digitarLogin(login)
				.digitarPassword(senha)
				.clicarSignIn();
	}

}
