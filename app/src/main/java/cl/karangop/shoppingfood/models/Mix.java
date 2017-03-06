package cl.karangop.shoppingfood.models;

import com.orm.SugarRecord;

/**
 * Created by karan_000 on 25-02-2017.
 */

public class Mix extends SugarRecord{

    private int dishId;
//    private ArrayList<Mix> mixes;
    private String[] mixes; /*TODO this String[] sirve para listar ingredientes en 2da activity?*/

    public Mix(int dishId, String[] mixes) {
        this.dishId = dishId;
        this.mixes = mixes;
    }

    public Mix() {
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String[] getMixes() {
        return mixes;
    }

    public void setMixes(String[] mixes) {
        this.mixes = mixes;
    }
}
