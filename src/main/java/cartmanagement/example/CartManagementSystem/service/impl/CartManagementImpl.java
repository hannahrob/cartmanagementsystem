package cartmanagement.example.CartManagementSystem.service.impl;

import cartmanagement.example.CartManagementSystem.model.Cart;
import cartmanagement.example.CartManagementSystem.model.CartItem;
import cartmanagement.example.CartManagementSystem.model.ItemToCartDto;
//import cartmanagement.example.CartManagementSystem.repository.CartManagementRepository;
import cartmanagement.example.CartManagementSystem.repository.CartRepository;
import cartmanagement.example.CartManagementSystem.service.CartManagementService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartManagementImpl implements CartManagementService {

//    CartManagementRepository cartManagementRepository;
//    Cart cart = new Cart();
    CartRepository cartRepository;

    public CartManagementImpl( CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public String createACart(Cart cart) {
        cartRepository.save(cart);
        return "Cart Created Successfully";
    }

    @Override
    public String addItemToCart(ItemToCartDto itemToCartDto) {
        // todo: get the particular cart from the DB
        Cart cart = cartRepository.findByEmail(itemToCartDto.getUserEmail());

        // todo: fetch the existing items
        ArrayList<CartItem> existingItems;

        if (cart.getCartItem() != null) {
            existingItems =cart.getCartItem();
        } else {
            existingItems = new ArrayList<>();
        }

        // todo: add the new items to the existing items
        existingItems.addAll(itemToCartDto.getCartItems());

        //todo: save the cart again
        cartRepository.save(cart);

        // todo: return a response to the client
        return "Cart Updated Successfully";
    }

//    @Override
//    public String addItem(Cart cart) {
//        cartRepository.save(cart);
//        return "Success";
//    }

//    @Override
//    public String updateItem(CartItem cartItem) {
//        cartManagementRepository.save(cartItem);
//        return "Success";
//    }

//    @Override
//    public String deleteItem(Long itemId) {
//        cartManagementRepository.deleteById(itemId);
//        return "Success";
//    }

    @Override
    public String checkoutCart() {
        cartRepository.deleteAll();
        return "Success";
    }

//    @Override
//    public CartItem getItem(Long itemId) {
//        return cartManagementRepository.findById(itemId).get();
//    }

//    @Override
//    public List<CartItem> getAllItems() {
//        return cartManagementRepository.findAll();
//    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }
}
