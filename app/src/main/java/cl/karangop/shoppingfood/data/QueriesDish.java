package cl.karangop.shoppingfood.data;

import java.util.ArrayList;
import java.util.List;

import cl.karangop.shoppingfood.models.Dish;
import cl.karangop.shoppingfood.models.Feed;
import cl.karangop.shoppingfood.models.Mix;

/**
 * Created by karan_000 on 25-02-2017.
 */

public class QueriesDish {

    public void createData(){

        Feed feed= new Feed();

        List<Dish> dishList= Dish.listAll(Dish.class);
        if(dishList.size() <= 0 ){
            feed.saveDish();
        }
    }

    public List<Dish> listAll(){

        List<Dish> dishes= new ArrayList<>();
        List<Dish> dishList= Dish.listAll(Dish.class);
        if (dishList != null && dishList.size() > 0){
            dishes.addAll(dishList);
        }
        else{
            List<Dish> dish= new ArrayList<>();
            return dish;
        }
        return dishes;
    }

    //List of Dishes by day
    public List<Dish> byDay(int day){
        List<Dish> dishes= new ArrayList<>();
        List<Dish> dishesList= Dish.find(Dish.class, "day = ?", String.valueOf(day));
        if (dishesList != null && dishesList.size() > 0){
            dishes.addAll(dishesList);
        }
        return dishes;
    }

    //List of Mix by Dish
    public List<Mix> byDish(int dish){
        List<Mix> mixes= new ArrayList<>();

        List<Mix> mixList= Mix.find(Mix.class,"dishId = ? ", String.valueOf(dish));
        if (mixList != null && mixList.size() > 0){
            mixes.addAll(mixList);
        }
        return mixes;
    }

//    List all de mixes
    public List<Mix> mixAll(){
        List<Mix> mixes= new ArrayList<>();
        List<Mix> mixList= Mix.listAll(Mix.class);
        if (mixList != null && mixList.size() > 0){
            mixes.addAll(mixList);
        }
        else{
            List<Mix> mix= new ArrayList<>();
            return mix;
        }
        return mixes;
    }
}
