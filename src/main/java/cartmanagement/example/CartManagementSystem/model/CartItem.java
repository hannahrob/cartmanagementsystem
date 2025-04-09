package cartmanagement.example.CartManagementSystem.model;

import lombok.*;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private String itemName;
    private int itemQuantity;
    private double itemPrice;
}