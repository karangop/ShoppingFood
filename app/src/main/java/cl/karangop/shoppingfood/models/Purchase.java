package cl.karangop.shoppingfood.models;

import com.orm.SugarRecord;

/**
 * Created by karan_000 on 01-03-2017.
 */

public class Purchase extends SugarRecord {
    private String name;
    private boolean done;
    private int price;

    public Purchase() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
