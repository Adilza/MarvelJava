package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}

//	private WebDriver navegador;

	public LoginFormPage clicarSignIn() {
		navegador.findElement(By.linkText("Sign in")).click();

		return new LoginFormPage(navegador);
	} 
}


