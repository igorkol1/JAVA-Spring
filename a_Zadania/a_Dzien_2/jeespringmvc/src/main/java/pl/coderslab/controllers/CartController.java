package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.ProduktDao;
import pl.coderslab.domain.Cart;
import pl.coderslab.domain.CartItem;
import pl.coderslab.domain.Product;

import java.util.Random;
import java.util.UUID;

@Controller
public class CartController {

    private Cart cart;
    private ProduktDao produktDao;

    @Autowired
    public CartController(Cart cart,
                          ProduktDao produktDao) {
        this.cart = cart;
        this.produktDao = produktDao;
    }

    @RequestMapping("/showproducts")
    public String showProducts(Model model) {
        model.addAttribute("productsList", produktDao.getProductList());
        return "products";
    }

    @RequestMapping("/addtocart")
    @ResponseBody
    public String addtocart() {
        Random rand = new Random();
        cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10), rand.nextDouble())));
        return "addtocart";
    }

    @RequestMapping("/addtocart/{uuid}/{quantity}")
    @ResponseBody
    public String addToCart(@PathVariable UUID uuid, @PathVariable int quantity) {
        cart.addToCart(new CartItem(quantity, produktDao.getProductWithUuid(uuid)));
        return "addtocart";
    }

    @RequestMapping("/cart")
    private String showCart(Model model) {
        model.addAttribute("numberOfProducts", cart.getNumberOfProducts());
        model.addAttribute("quantityOfProducts", cart.getQuantityOfProducts());
        model.addAttribute("valueOdProducts", cart.getValue());
        model.addAttribute("cartitems", cart.getCartItems());
        return "cart";
    }
}
