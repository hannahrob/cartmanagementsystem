package cartmanagement.example.CartManagementSystem.repository;

import cartmanagement.example.CartManagementSystem.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository <Cart, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM CART WHERE user_email =:email")
    Cart findByEmail(@Param("email") String email);
}
