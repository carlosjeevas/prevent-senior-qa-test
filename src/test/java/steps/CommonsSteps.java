package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import page_object.model.ShopModel;
import runner.TestRule;

public class CommonsSteps {

	private static ShopModel shop = new ShopModel(TestRule.getDriver());
	
	@Given("Que estou na página Shop")
	public void que_estou_na_pagina_shop() throws Exception {
		Assert.assertEquals(true, shop.isDisplayed());
	}
}