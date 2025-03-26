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
    private ArrayList<CartItemRequest> cartItemRequests;

    public Cart(Long cartId, String ownerName, ArrayList<CartItemRequest> cartItemRequests) {
        this.cartId = cartId;
        this.ownerName = ownerName;
        this.cartItemRequests = cartItemRequests;
    }
    public Cart() {}

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public ArrayList<CartItemRequest> getCartItemRequests() {
        return cartItemRequests;
    }

    public void setCartItemRequests(ArrayList<CartItemRequest> cartItemRequests) {
        this.cartItemRequests = cartItemRequests;
    }
}
