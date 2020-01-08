package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.page_object.BaseWebPage;

/**
 * Page Object de Shop
 * 
 * @author Carlos Moreira
 */
public class ShopPO extends BaseWebPage {

	private static By BTN_CHECKOUT = By.xpath(".//*[contains(text(),'Checkout')]");
	private static By BTN_PURCHASE = By.xpath("//input[@value='Purchase']");
	private static By MSG_COMPRA_COM_SUCESSO = By.xpath(".//*[text()='Success!']");
	private static By PAGE_FINALIZA_COMPRA = By.xpath("//label[@for='country']");
	private static By NAVBAR_BTN_CHECKOUT = By.xpath("//span[@class='navbar-toggler-icon']/..");
	private static By INPUT_LOCAL_ENTREGA = By.xpath("//input[@id='country']");
	private static By CHK_TERMOS_CONDICOES = By.xpath("//label[@for='checkbox2']");
	private static By LBL_SHOP = By.xpath(".//*[text()='Shop Name']");

	public ShopPO(WebDriver webDriver) {
		super(webDriver);
	}

	@Override
	public boolean isDisplayed() {
		return searchElement.existsNoLog(LBL_SHOP, "Elemento usado para validacao da pagina 'Shop'", 1);
	}

	/**
	 * Botão 'Adicionar ao carrinho'
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement btnAddCarrinho(String item) throws Exception {

		By BTN_ADICIONAR_AO_CARRINHO = By.xpath("//a[text()='" + item + "']/../../..//button");
		return searchElement.findElementBy(BTN_ADICIONAR_AO_CARRINHO, "Botao 'Adicionar ao carrinho'");
	}

	/**
	 * Botão 'Checkout'
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement btnCheckout() throws Exception {
		return searchElement.findElementBy(BTN_CHECKOUT, "Botao 'Checkout'");
	}

	/**
	 * Retorna a existência do Navbar que esconde o botão 'Checkout'
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean existsNavbarBtnCheckout() throws Exception {
		return searchElement.existsNoLog(NAVBAR_BTN_CHECKOUT,
				"Retorna a existencia do Navbar que esconde o botao 'Checkout'", 1);
	}

	/**
	 * Navbar que esconde o botão 'Checkout'
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement navbarBtnCheckout() throws Exception {
		return searchElement.findElementBy(NAVBAR_BTN_CHECKOUT, "Navbar que esconde o botao 'Checkout'");
	}

	/**
	 * Input do local de entrega
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement inputLocalEntrega() throws Exception {
		return searchElement.findElementBy(INPUT_LOCAL_ENTREGA, "Input do local de entrega");
	}

	/**
	 * Checkbox 'Termos e condições'
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement chkTermosCondicoes() throws Exception {
		return searchElement.findElementBy(CHK_TERMOS_CONDICOES, "Checkbox 'Termos e condicoes'");
	}

	/**
	 * Botão 'Purchase'
	 * 
	 * @return
	 * @throws Exception
	 */
	public WebElement btnPurchase() throws Exception {
		return searchElement.findElementBy(BTN_PURCHASE, "Botao 'Purchase'");
	}

	/**
	 * Retorna a existência da mensagem de sucesso
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean existsMsgSucesso() throws Exception {
		return searchElement.existsNoLog(MSG_COMPRA_COM_SUCESSO, "Retorna a existencia da mensagem de sucesso", 1);
	}

	/**
	 * Retorna a existência da página que finaliza a compra
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean existsPaginaFinalizaCompra() throws Exception {
		return searchElement.existsNoLog(PAGE_FINALIZA_COMPRA, "Retorna a existencia da pagina que finaliza a compra",
				1);
	}
}