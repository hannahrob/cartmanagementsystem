package cartmanagement.example.CartManagementSystem.service.impl;

import cartmanagement.example.CartManagementSystem.model.Cart;
import cartmanagement.example.CartManagementSystem.model.CartItem;
import cartmanagement.example.CartManagementSystem.model.ItemToCartDto;
import cartmanagement.example.CartManagementSystem.repository.CartRepository;
import cartmanagement.example.CartManagementSystem.service.CartManagementService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartManagementImpl implements CartManagementService {
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
        System.out.println("Incoming request: " +  itemToCartDto.toString());
        // todo: get the particular cart from the DB
        Cart cart = cartRepository.findByEmail(itemToCartDto.getUserEmail());
        System.out.println("cart object from DB: " + cart );

        // todo: fetch the existing items
        ArrayList<CartItem> existingItems;

        if (cart.getCartItems() != null) {
            System.out.println("cart from db is not null");
            existingItems =cart.getCartItems();
        } else {
            System.out.println("cart from db is null");
            existingItems = new ArrayList<>();
        }

        // todo: add the new items to the existing items
        for (CartItem item : itemToCartDto.getCartItems()) {
            System.out.println("adding item to list => " + item.toString());
            existingItems.add(item);
        }

        cart.setCartItems(existingItems);

        //todo: save the cart again
        System.out.println("saving cart back to the db: " + cart.toString());
        cartRepository.save(cart);
        System.out.println("Cart Updated Successfully");

        // todo: return a response to the client
        return "Cart Updated Successfully";
    }

    @Override
    public String checkoutCart() {
        cartRepository.deleteAll();
        return "Success";
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }
}
