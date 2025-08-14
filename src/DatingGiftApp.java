import java.util.*;


public class DatingGiftApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Gift> gifts = new ArrayList<>();
        GiftCart cart = new GiftCart();


        gifts.add(new Gift(1, "Red Rose Bouquet 🌹", 249));
        gifts.add(new Gift(2, "Chocolates box 🍫", 299));
        gifts.add(new Gift(3, "Plushy Teddy Bear 🧸", 399));
        gifts.add(new Gift(4, "Couple Mug Set ☕☕", 349));
        gifts.add(new Gift(5, "Love Letter Scroll 💌", 149));
        gifts.add(new Gift(6, "Date Night Kit(All Inc.)🎁", 1199));

        while (true) {
            System.out.println("\n💕  Welcome to the Dating Gift Cart  💕");
            System.out.println("1. View Romantic Gifts");
            System.out.println("2. Add a Gift to Cart");
            System.out.println("3. Remove a Gift from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n🎁 Romantic Gifts Available:");
                    for (Gift g : gifts)
                        System.out.println(g);
                    break;

                case 2:
                    System.out.print("Enter Gift ID to add 😍: ");
                    int gid = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    Gift selected = getGiftById(gifts, gid);
                    if (selected != null)
                        cart.addGift(selected, qty);
                    else
                        System.out.println("Invalid Gift ID 🤨");
                    break;

                case 3:
                    System.out.print("Enter Gift ID to remove 😪: ");
                    gid = sc.nextInt();
                    selected = getGiftById(gifts, gid);
                    if (selected != null)
                        cart.removeGift(selected);
                    else
                        System.out.println("Invalid Gift ID 🤨");
                    break;

                case 4:
                    cart.viewCart();
                    break;

                case 5:
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty, but your heart is full 💖");
                    } else {
                        double total = cart.checkout();
                        System.out.println("💝 Checkout complete! Total: ₹" + total);
                        System.out.println("Send it with love 💋");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for spreading love 💞");
                    System.out.println("Goodbye👋");
                    return;

                default:
                    System.out.println("Invalid option. Try again 🤨");
            }
        }
    }

    private static Gift getGiftById(List<Gift> gifts, int id) {
        for (Gift g : gifts)
            if (g.getId() == id)
                return g;
        return null;
    }
}
