package cl.karangop.shoppingfood.views.dish;

import java.util.List;

import cl.karangop.shoppingfood.models.Dish;

/**
 * Created by karan_000 on 25-02-2017.
 */

public class CreateDish {

    private DishCallback callback;

    public CreateDish(DishCallback callback) {
        this.callback = callback;
    }

    public void validation(int day){

        List<Dish> dishes= Dish.find(Dish.class, "day = ?", String.valueOf(day));
        if (dishes.size() <= 0) {
            callback.empty();
        }
    }
}
