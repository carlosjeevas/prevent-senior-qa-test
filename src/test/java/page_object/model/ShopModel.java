package page_object.model;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import page_object.ShopPO;
import selenium.page_object.BaseWebPage;
import utils.ReporterUtils;

public class ShopModel extends BaseWebPage {

	Actions actions = new Actions(webDriver);
	private ShopPO shop;

	public ShopModel(WebDriver webDriver) {
		super(webDriver);
		shop = new ShopPO(webDriver);
	}

	@Override
	public boolean isDisplayed() {
		return shop.isDisplayed();
	}

	/**
	 * Clica no botão 'Adicionar ao carrinho'
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public void btnAddCarrinho(String item) throws Exception {
		if (item != null) {
			command.click(shop.btnAddCarrinho(item));
		}
	}

	/**
	 * Clica no botão 'Checkout'
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public void btnCheckout() throws Exception {
		if (existsNavbarBtnCheckout()) {
			navbarBtnCheckout();
		}
		command.click(shop.btnCheckout());
	}

	/**
	 * Clica no navbar para exibir o botão 'Checkout'
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	private void navbarBtnCheckout() throws Exception {
		command.click(shop.navbarBtnCheckout());
	}

	/**
	 * Verifica a existência do Navbar que esconde o botão 'Checkout'
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	private boolean existsNavbarBtnCheckout() throws Exception {
		return shop.existsNavbarBtnCheckout();
	}

	/**
	 * Insere o local de entrega
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public void inputLocalEntrega(String local) throws Exception {
		if (local != null) {
			command.send(shop.inputLocalEntrega(), local);
		}
	}

	/**
	 * Clica no checkbox 'Termos e condições'
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public void chkTermosCondicoes() throws Exception {
		command.click(shop.chkTermosCondicoes());
	}

	/**
	 * Clica no botão 'Purchase'
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public void btnPurchase() throws Exception {
		command.focus(shop.btnPurchase());
		ReporterUtils.logPrint("Click para comprar o item");
		command.click(shop.btnPurchase());
	}

	/**
	 * Verifica a existência da mensagem de sucesso para a compra do item
	 * 
	 * @author Carlos Moreira
	 * @throws Exception
	 */
	public void validaCompra() throws Exception {
		if (shop.existsMsgSucesso()) {
			ReporterUtils.logPass("Compra realizada com sucesso");
		} else {
			ReporterUtils.logFail("Compra não realizada");
		}
		Assert.assertTrue("Mensagem de sucesso não exibida", shop.existsMsgSucesso());
	}

	public void validaCarrinho() throws Exception {
		if (!shop.existsPaginaFinalizaCompra()) {
			ReporterUtils.logPass("Página que finaliza compra não foi exibiba");
		} else {
			ReporterUtils.logFail("Página que finaliza a compra foi exibiba");
		}
		Assert.assertFalse("A página que finaliza compra foi exibiba sem ter itens no carrinho",
				shop.existsPaginaFinalizaCompra());
	}
}