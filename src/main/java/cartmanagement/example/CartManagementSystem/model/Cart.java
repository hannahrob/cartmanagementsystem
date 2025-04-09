package cartmanagement.example.CartManagementSystem.model;

import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @SequenceGenerator(name = "cart_sequence", sequenceName = "cart_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_sequence")
    private Long cartId;
    private String userEmail;
    private ArrayList<CartItem> cartItems;

    public Cart(Long cartId, String userEmail, ArrayList<CartItem> cartItems) {
        this.cartId = cartId;
        this.userEmail = userEmail;
        this.cartItems = cartItems;
    }
    public Cart() {}

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public ArrayList<CartItem> getCartItem() {
        return cartItems;
    }

    public void setCartItem(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
