package cartmanagement.example.CartManagementSystem.service;

import cartmanagement.example.CartManagementSystem.model.Cart;
import cartmanagement.example.CartManagementSystem.model.CartItemRequest;

import java.util.List;

public interface CartManagementService {
    public String createACart(Cart cart);
    public String addItem(CartItemRequest cartItemRequest);
    public String updateItem(CartItemRequest cartItemRequest);
    public String deleteItem(Long itemId);
    public String checkoutCart();
    public CartItemRequest getItem(Long itemId);
    public List<CartItemRequest> getAllItems();
    public List<Cart> getAllCarts();

}
