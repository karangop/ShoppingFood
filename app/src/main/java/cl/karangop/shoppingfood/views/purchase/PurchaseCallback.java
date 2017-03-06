package cl.karangop.shoppingfood.views.purchase;

import cl.karangop.shoppingfood.models.Purchase;

/**
 * Created by karan_000 on 01-03-2017.
 */

public interface PurchaseCallback {

    void created(Purchase purchase);
    void noName();
}
