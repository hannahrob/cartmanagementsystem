package cartmanagement.example.CartManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItemRequest {
    @Id
    @JsonIgnore
    @SequenceGenerator(name = "cartItem_sequence", sequenceName = "cartItem_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartItem_sequence")
    private Long itemId;
    private String itemName;
    private int itemQuantity;
    private double itemPrice;

    public CartItemRequest(Long itemId, String itemName, int itemQuantity, double itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }

    public CartItemRequest() {}

    public Long getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}