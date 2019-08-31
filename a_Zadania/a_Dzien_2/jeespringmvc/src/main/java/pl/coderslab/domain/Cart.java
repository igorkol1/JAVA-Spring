package pl.coderslab.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public void addToCart(CartItem cartItem) {
        Optional<CartItem> optionalCartItem = cartItems.stream()
                .filter(item -> item.getProduct().getUuid().equals(cartItem.getProduct().getUuid()))
                .findFirst();
        if (optionalCartItem.isPresent()) {
            optionalCartItem.get().increaseQuantity(1);
        } else {
            this.cartItems.add(cartItem);
        }
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public int getNumberOfProducts() {
        return cartItems.size();
    }

    public int getQuantityOfProducts() {
        int quantity = 0;
        for (CartItem item : cartItems) {
            quantity += item.getQuantity();
        }
        return quantity;
    }

    public double getValue() {
        double value = 0;
        for (CartItem item : cartItems) {
            value += (double) item.getQuantity() * item.getProduct().getPrice();
        }
        return value;
    }

}
