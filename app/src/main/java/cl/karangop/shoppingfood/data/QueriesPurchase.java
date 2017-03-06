package cl.karangop.shoppingfood.data;

import java.util.ArrayList;
import java.util.List;

import cl.karangop.shoppingfood.models.Purchase;

/**
 * Created by karan_000 on 01-03-2017.
 */

public class QueriesPurchase {

    /*public List<Purchase> listAllPurchases(){

        List<Purchase> purchases= new ArrayList<>();
        List<Purchase> purchaseList = Purchase.listAll(Purchase.class);

        if (purchaseList != null && purchaseList.size() > 0){
            purchases.addAll(purchaseList);
            Log.d("PURCHASE", "listAllPurchases: ");
        } else {

        }


        return purchases;

    }*/

    public List<Purchase> listAllPurchases() {

        List<Purchase> purchases = new ArrayList<>();
        List<Purchase> purchaseList = Purchase.listAll(Purchase.class, "done = 1"); //order by done

        if (purchaseList != null && purchaseList.size() > 0) {
            purchases.addAll(purchaseList);
        } else {

        }


        return purchases;

    }
}