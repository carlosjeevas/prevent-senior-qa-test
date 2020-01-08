package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object.model.ShopModel;
import runner.TestRule;
import utils.ReporterUtils;

public class ComprarProdutoSteps {

	private static ShopModel shop = new ShopModel(TestRule.getDriver());

	@When("Adiciono um (.*) ao carrinho")
	public void adiciono_um_produto_ao_carrinho(String item) throws Exception {
		shop.btnAddCarrinho(item);
	}

	@When("Clico no botão que leva ao carrinho")
	public void clico_no_botao_que_leva_ao_carrinho() throws Exception {
		shop.btnCheckout();
		ReporterUtils.logPrint("Itens no carrinho");
	}

	@When("Clico no botão que confirma os itens do carrinho")
	public void clico_no_botao_que_confirma_os_itens_do_carrinho() throws Exception {
		shop.btnCheckout();
	}

	@When("Insiro o local de entrega como sendo (.*)")
	public void seleciono_o_local_de_entrega(String localEntrega) throws Exception {
		shop.inputLocalEntrega(localEntrega);
		ReporterUtils.logPrint("Local de entrega inserido");
	}

	@When("Concordo com os termos")
	public void concordo_com_os_termos() throws Exception {
		shop.chkTermosCondicoes();
		ReporterUtils.logPrint("Termos e condições aceitos");
	}

	@When("Clico para efetuar a compra")
	public void clico_para_efetuar_a_compra() throws Exception {
		shop.btnPurchase();
	}

	@Then("Devo visualizar uma mensagem de sucesso")
	public void devo_visualizar_uma_mensagem_de_sucesso() throws Exception {
		shop.validaCompra();
	}
}