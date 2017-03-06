package cl.karangop.shoppingfood.adapters;

import cl.karangop.shoppingfood.models.Purchase;

/**
 * Created by karan_000 on 06-03-2017.
 */

public interface PurchaseClickListener {

    void clickId(long id);
    void clickPurchase(Purchase purchase);

}
