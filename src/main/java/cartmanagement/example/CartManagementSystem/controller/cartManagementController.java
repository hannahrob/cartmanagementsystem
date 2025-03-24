package cartmanagement.example.CartManagementSystem.controller;

import cartmanagement.example.CartManagementSystem.model.Cart;
import cartmanagement.example.CartManagementSystem.model.CartItemRequest;
import cartmanagement.example.CartManagementSystem.service.CartManagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class cartManagementController {
    CartManagementService cartManagementService;

    public cartManagementController(CartManagementService cartManagementService) {
        this.cartManagementService = cartManagementService;
    }
    @PostMapping("/create-cart")
    public String createCart(@RequestBody Cart cart){
        cartManagementService.createACart(cart);
        return "Cart Created successfully";
    }
    @GetMapping("/get-all-carts")
    public List<Cart> getCarts(){
        return cartManagementService.getAllCarts();
    }
    @PostMapping
    public String addItemToCart(@RequestBody CartItemRequest cartItemRequest){
        cartManagementService.addItem(cartItemRequest);
        return "Item added to cart successfully";
    }

    @GetMapping("{itemId}")
    public CartItemRequest getCartItem(@PathVariable("itemId") Long itemId){
        return cartManagementService.getItem(itemId);
    }
    @GetMapping()
    public List<CartItemRequest> getAllCartItem(){
        return cartManagementService.getAllItems();
    }
    @PutMapping
    public String updateCartItem(@RequestBody CartItemRequest cartItemRequest){
        cartManagementService.updateItem(cartItemRequest);
        return "Cart Item Updated successfully";
    }
    @DeleteMapping("{itemId}")
    public String deleteCartItem(@PathVariable Long itemId){
        cartManagementService.deleteItem(itemId);
        return "Cart Item Deleted successfully";
    }
    @DeleteMapping("/api/cart/checkout-item")
    public String checkoutCart(){
      cartManagementService.checkoutCart();
        return "Cart Cleared successfully";
    }
}
