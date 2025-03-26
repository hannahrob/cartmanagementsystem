package cartmanagement.example.CartManagementSystem.repository;

import cartmanagement.example.CartManagementSystem.model.Cart;
import cartmanagement.example.CartManagementSystem.model.CartItemRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartManagementRepository extends JpaRepository  <CartItemRequest, Long> {
}

