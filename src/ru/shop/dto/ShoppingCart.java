package ru.shop.dto;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<Long> goodsIdCart = new ArrayList<Long>();
	private int amount = 0;
	public ArrayList<Long> getGoodsInCart() {
		return goodsIdCart;
	}

	public void addToCart(String goodId){
		goodsIdCart.add(Long.valueOf(goodId));
		amount++;
	}
	
	public void removeFromCart(String goodId){
		goodsIdCart.remove(Long.valueOf(goodId));
		amount--;		
	}
	
	public void removeAll(){
		amount = 0;
		goodsIdCart.clear();
	}

	public ArrayList<Long> getGoodsIdCart() {
		return goodsIdCart;
	}

	public void setGoodsIdCart(ArrayList<Long> goodsIdCart) {
		this.goodsIdCart = goodsIdCart;		
	}

	public int getAmount() {
		return amount;
	}
}
