package cartmanagement.example.CartManagementSystem.model;


import java.util.ArrayList;

public class ItemToCartDto {
    String userEmail;
    ArrayList<CartItemRequest> cartItems;

    public ItemToCartDto(String userEmail, ArrayList<CartItemRequest> cartItems) {
        this.userEmail = userEmail;
        this.cartItems = cartItems;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public ArrayList<CartItemRequest> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItemRequest> cartItems) {
        this.cartItems = cartItems;
    }
}
