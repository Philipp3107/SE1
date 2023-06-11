import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<String> items;


    public Cart(){
        this.items = new ArrayList<>();

    }

    public void addItem(String item){
        if(!items.contains("Buch")){
            items.add(item);
            System.out.println("Item hinzugefügt");
        }else{
            System.out.println("Buch schon vorhanden");
        }
    }
    public int getDiscountPercentage(){
        if(items.contains(new String("Buch"))){
            return 5;
        }else{
            return 0;
        }
    }

    public List<String> getItems(){
        return this.items;
    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addItem("Banane");
        cart.addItem("Apfel");
        cart.addItem("Buch");
        cart.addItem("Buch");
        System.out.println(cart.getItems());
        System.out.println(cart.getDiscountPercentage());
    }

}
