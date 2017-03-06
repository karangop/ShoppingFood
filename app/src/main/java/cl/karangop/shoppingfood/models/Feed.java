package cl.karangop.shoppingfood.models;

import cl.karangop.shoppingfood.R;

/**
 * Created by karan_000 on 27-02-2017.
 */

public class Feed{

    /*TODO add images of dish and more foods, and mixes*/

    private int image= R.mipmap.shopping_food;

    //    LUNES
    private String dish1Day1 = "Tortilla de porotos verdes con papas cocidas";
    private String[] mixdish1Day1 = {"Porotos verdes", "Huevos", "Papas"};
    private int imgDish1Day1= R.mipmap.ic_launcher;

    //    MARTES
    private String dish1Day2 = "Pollo arvejado con puré";
    private String[] urlDish1Day2 = {"Pollo","Arvejas", "Papas","Mantequilla","Leche","Cebolla"};

    //    MIERCOLES
    private String dish1Day3 = "Guiso zapallo italiano con papas fritas";
    private String urlDish1Day3 = "https://cookpad.com/cl/recetas/910593-guiso-de-zapallo-italiano";

    //    JUEVES
    private String dish1Day4 = "Lentejas con huevo duro";
    private String urlDish1Day4 = "https://cookpad.com/cl/recetas/851701-lentejas-con-arroz";

    //    VIERNES
    private String dish1Day5 = "Pastel de papas";
    private String urlDish1Day5 = "https://cookpad.com/cl/recetas/1895690-pastel-de-papa-super-rico-y-facil";

    //    SABADO
    private String dish1Day6 = "Bistec con arroz primavera";
    private String urlDish1Day6 = "https://cookpad.com/cl/recetas/1582012-bistec-de-res-en-coccion-15-minutos";

    //    DOMINGO
    private String dish1Day7 = "Pescado al horno con papas mayo";
    private String urlDish1Day7 = "https://cookpad.com/cl/recetas/1849983-pescado-al-horno-con-verduras";


    //   Platos Lunes
    Dish dish1= new Dish(1,dish1Day1,2, image,false);
    Mix mix1= new Mix(1,mixdish1Day1);

    //   Platos martes
    Dish dish2= new Dish(2,dish1Day2,3,image,false);

    //   Platos miercoles
    Dish dish3= new Dish(3,dish1Day3,4,image,false);

    //   Platos jueves
    Dish dish4= new Dish(4,dish1Day4,5,image,false);

    //   Platos viernes
    Dish dish5= new Dish(5,dish1Day5,6,image,false);

    //   Platos sabado
    Dish dish6= new Dish(6,dish1Day6,7,image,false);

    //   Platos domingo
    Dish dish7= new Dish(7,dish1Day7,1,image,true);

    public void saveDish(){

//        Platos
        dish1.save();
        dish2.save();
        dish3.save();
        dish4.save();
        dish5.save();
        dish6.save();
        dish7.save();

//        Ingredientes
        mix1.save();
    }


}