package pl.coderslab.domain;

public class CartItem {

    private int quantity;
    private Product product;

    public CartItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "quantity=" + quantity +
                ", product=" + product.getName() +
                '}';
    }

    public void increaseQuantity(int i) {
        this.quantity = this.quantity + i;
    }
}
