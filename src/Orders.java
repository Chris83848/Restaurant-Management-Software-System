import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<String> orderItems;
    private String orderName;

    public Orders(String orderName, List<String> items){
        this.orderItems = new ArrayList<>(items);
        this.orderName = orderName;
    }

    public List<String> getItems(){
        return orderItems;
    }

    public String getOrderName(){
        return orderName;
    }
}
