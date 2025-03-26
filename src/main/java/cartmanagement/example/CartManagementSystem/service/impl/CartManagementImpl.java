package cartmanagement.example.CartManagementSystem.service.impl;

import cartmanagement.example.CartManagementSystem.model.Cart;
import cartmanagement.example.CartManagementSystem.model.CartItemRequest;
import cartmanagement.example.CartManagementSystem.model.ItemToCartDto;
import cartmanagement.example.CartManagementSystem.repository.CartManagementRepository;
import cartmanagement.example.CartManagementSystem.repository.CartRepository;
import cartmanagement.example.CartManagementSystem.service.CartManagementService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartManagementImpl implements CartManagementService {

    CartManagementRepository cartManagementRepository;
    CartRepository cartRepository;

    public CartManagementImpl(CartManagementRepository cartManagementRepository, CartRepository cartRepository) {
        this.cartManagementRepository = cartManagementRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public String createACart(Cart cart) {
        cartRepository.save(cart);
        return "Cart Created Successfully";
    }

    @Override
    public String updateCart(ItemToCartDto itemToCartDto) {
        // todo: get the particular cart from the DB
        Cart cart = cartRepository.findByEmail(itemToCartDto.getUserEmail());

        // todo: fetch the existing items
        ArrayList<CartItemRequest> existingItems = cart.getCartItemRequests();

        // todo: add the new items to the existing items
        for (CartItemRequest item: itemToCartDto.getCartItems()) {
            existingItems.add(item);
        }

        //todo: save the cart again
        cartRepository.save(cart);

        // todo: return a response to the client
        return "Cart Updated Successfully";
    }

    @Override
    public String addItem(CartItemRequest cartItemRequest) {
        cartManagementRepository.save(cartItemRequest);
        return "Success";
    }

    @Override
    public String updateItem(CartItemRequest cartItemRequest) {
        cartManagementRepository.save(cartItemRequest);
        return "Success";
    }

    @Override
    public String deleteItem(Long itemId) {
        cartManagementRepository.deleteById(itemId);
        return "Success";
    }

    @Override
    public String checkoutCart() {
        cartManagementRepository.deleteAll();
        return "Success";
    }

    @Override
    public CartItemRequest getItem(Long itemId) {
        return cartManagementRepository.findById(itemId).get();
    }

    @Override
    public List<CartItemRequest> getAllItems() {
        return cartManagementRepository.findAll();
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }
}
