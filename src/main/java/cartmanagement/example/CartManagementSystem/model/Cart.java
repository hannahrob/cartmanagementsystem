package cartmanagement.example.CartManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@Entity(name = "Cart")
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @SequenceGenerator(name = "cart_sequence", sequenceName = "cart_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_sequence")
    private Long cartId;
    private String userEmail;
    private ArrayList<CartItem> cartItems;
}
