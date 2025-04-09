package cartmanagement.example.CartManagementSystem.model;


import java.util.ArrayList;
import java.util.List;

public class ItemToCartDto {
    String userEmail;
    List<CartItem> cartItems;

    public ItemToCartDto(String userEmail, ArrayList<CartItem> cartItems) {
        this.userEmail = userEmail;
        this.cartItems = cartItems;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
