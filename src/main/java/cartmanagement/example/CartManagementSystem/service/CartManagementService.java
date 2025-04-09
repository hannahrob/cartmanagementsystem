package cartmanagement.example.CartManagementSystem.service;

import cartmanagement.example.CartManagementSystem.model.Cart;
import cartmanagement.example.CartManagementSystem.model.CartItem;
import cartmanagement.example.CartManagementSystem.model.ItemToCartDto;

import java.util.List;

public interface CartManagementService {
    public String createACart(Cart cart);
    public String addItemToCart(ItemToCartDto cart);
//    public String addItem(Cart cart);
//    public String updateItem(CartItem cartItem);
//    public String deleteItem(Long itemId);
    public String checkoutCart();
//    public CartItem getItem(Long itemId);
//    public List<CartItem> getAllItems();
    public List<Cart> getAllCarts();

}
