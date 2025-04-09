package cartmanagement.example.CartManagementSystem.controller;
import cartmanagement.example.CartManagementSystem.model.Cart;
import cartmanagement.example.CartManagementSystem.model.CartItem;
import cartmanagement.example.CartManagementSystem.model.ItemToCartDto;
import cartmanagement.example.CartManagementSystem.model.Response;
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

    @PutMapping("/add-item-to-cart")
    public String updateCart(@RequestBody ItemToCartDto itemToCartDto){
        return cartManagementService.addItemToCart(itemToCartDto);
    }


//    @GetMapping("{itemId}")
//    public CartItem getCartItem(@PathVariable("itemId") Long itemId){
//        return cartManagementService.getItem(itemId);
//    }


//    @GetMapping()
//    public Response getAllCartItem(){
//        List<CartItem> listResponse =  cartManagementService.getAllItems();
//        Response finalResponse = new Response("00", "Successful", listResponse);
//        return finalResponse;
//    }

//    @PostMapping
//    public Response addItemToCart(@RequestBody CartItem cartItem){
//        String cartResponse = cartManagementService.addItem(cartItem);
//        return new Response(cartResponse, "Item added to cart successfully", cartItem);
//    }


//    @PutMapping
//    public Response updateCartItem(@RequestBody CartItem cartItem){
//        String cartItemRequest1 = cartManagementService.updateItem(cartItem);
//        return new Response(cartItemRequest1, "Item updated successfully", cartItem);
//    }


//    @DeleteMapping("{itemId}")
//    public Response deleteCartItem(@PathVariable Long itemId){
//       String cartResponse =  cartManagementService.deleteItem(itemId);
//        return new Response(cartResponse, "Item deleted successfully", null);
//    }


    @DeleteMapping("/api/cart/checkout-item")
    public Response checkoutCart(){
     String cartResponse = cartManagementService.checkoutCart();
        return new Response(cartResponse, "Item checked out successfully", null);
    }
}
