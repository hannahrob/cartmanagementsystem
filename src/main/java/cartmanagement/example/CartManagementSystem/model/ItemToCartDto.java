package cartmanagement.example.CartManagementSystem.model;

import lombok.*;
import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemToCartDto {
    String userEmail;
    ArrayList<CartItem> cartItems;
}
