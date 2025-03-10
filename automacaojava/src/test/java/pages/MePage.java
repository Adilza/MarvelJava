package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage {

	public MePage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}
	public MePage clicarAbaMoreDataAboutYou() {
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		
		return this;
	}
	
	public AddContactPage clicarBotaoMoreDataAboutYou() {
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
		
		return new AddContactPage(navegador);
	}
	
	public MePage clicarLinkRemoverContato(String telefone) {
		navegador.findElement(By.xpath("//span[text()=\"" + telefone + "\"]/following-sibling::a")).click();
		
		return this;
	}
	
	public MePage aceitarAlerta() {
		 navegador.switchTo().alert().accept();
		 
		 return this;
	}
}
