package steps;

import io.cucumber.java.en.Then;
import page_object.model.ShopModel;
import runner.TestRule;

public class ValidarCarrinhoSteps {

	private static ShopModel shop = new ShopModel(TestRule.getDriver());

	@Then("Não devo ir para a página que finaliza a compra")
	public void não_devo_ir_para_a_página_que_finaliza_a_compra() throws Exception {
		shop.validaCarrinho();
	}
}