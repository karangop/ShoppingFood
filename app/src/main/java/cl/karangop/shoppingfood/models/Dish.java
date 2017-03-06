package cl.karangop.shoppingfood.models;

import com.orm.SugarRecord;

/**
 * Created by karan_000 on 25-02-2017.
 */

public class Dish extends SugarRecord{

    private int idDish;
    private String name;
    private int day;
    private int image;
    private boolean status;

    public Dish(int idDish, String name, int day, int image, boolean status) {
        this.idDish = idDish;
        this.name = name;
        this.day = day;
        this.image = image;
        this.status = status;
    }

    public Dish() {
    }

    public int getIdDish() {
        return idDish;
    }

    public void setIdDish(int idDish) {
        this.idDish = idDish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

