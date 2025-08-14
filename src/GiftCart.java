import java.util.HashMap;
import java.util.*;

public class GiftCart {
    private Map<Gift, Integer> cartItems = new HashMap<>();

    public void addGift(Gift gift, int quantity) {
        cartItems.put(gift, cartItems.getOrDefault(gift, 0) + quantity);
    }

    public void removeGift(Gift gift) {
        cartItems.remove(gift);
    }

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your love cart is empty 💔");
            return;
        }
        System.out.println("❤️ Gifts in Your Cart:");
        double total = 0;
        for (Map.Entry<Gift, Integer> entry : cartItems.entrySet()) {
            Gift g = entry.getKey();
            int qty = entry.getValue();
            System.out.println(g.getName() + " x " + qty + " = ₹" + (g.getPrice() * qty));
            total += g.getPrice() * qty;
        }
        System.out.println("Total 💟: ₹" + total);
    }

    public double checkout() {
        double total = 0;
        for (Map.Entry<Gift, Integer> entry : cartItems.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        cartItems.clear();
        return total;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}
