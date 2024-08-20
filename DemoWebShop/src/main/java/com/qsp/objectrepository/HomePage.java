package com.qsp.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Register")
	private WebElement registerLink;
	
	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	
	@FindBy(xpath =  "//span[text()='Shopping cart']")
	private WebElement shoppingLink;
	
	@FindBy(xpath =  "//span[text()='Wishlist']")
	private WebElement wishlistLink;
	
	@FindBy(linkText = "Log out")
	private WebElement loginOutLink;
	
	@FindBy(xpath = "(//a[@class='account'])[1]")
	private WebElement accountLink;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchButton;
	
	@FindBy(partialLinkText =  "Books")
	private WebElement booksLink;
	
	@FindBy(partialLinkText = "Digital downloads")
	private WebElement digitalDownloadsLink;
	
	@FindBy(partialLinkText = "Computers")
	private WebElement computersLink;
	
	@FindBy(partialLinkText = "Electronics")
	private WebElement electronicsLink;
	
	@FindBy(partialLinkText = "Jewelry")
	private WebElement jewelryLink;
	
	@FindBy(xpath =  "(//a[contains(text(),'Apparel & Shoes')])[1]")
	private WebElement apparelAndShoesLink;
	
	@FindBy(partialLinkText = "Gift Cards")
	private WebElement giftCardsLink;
	
	@FindBy(xpath = "//input[@value='Add to cart']")
		private List<WebElement> addToCartButtons;
	

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getShoppingLink() {
		return shoppingLink;
	}

	public WebElement getWishlistLink() {
		return wishlistLink;
	}

	public WebElement getLoginOutLink() {
		return loginOutLink;
	}

	public WebElement getAccountLink() {
		return accountLink;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getBooksLink() {
		return booksLink;
	}

	public WebElement getDigitalDownloadsLink() {
		return digitalDownloadsLink;
	}

	public WebElement getComputersLink() {
		return computersLink;
	}

	public WebElement getElectronicsLink() {
		return electronicsLink;
	}

	public WebElement getJewelryLink() {
		return jewelryLink;
	}

	public WebElement getApparelAndShoesLink() {
		return apparelAndShoesLink;
	}

	public WebElement getGiftCardsLink() {
		return giftCardsLink;
	}

	public List<WebElement> getAddToCartButtons() {
		return addToCartButtons;
	}
	
	
}
