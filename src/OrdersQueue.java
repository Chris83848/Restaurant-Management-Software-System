import java.util.ArrayList;
import java.util.List;

public class OrdersQueue {
    private static final List<Orders> ordersQueue = new ArrayList<>();

    public static void addOrder(Orders order) {
        ordersQueue.add(order);
    }

    public static List<Orders> getOrders() {
        return ordersQueue;
    }
}