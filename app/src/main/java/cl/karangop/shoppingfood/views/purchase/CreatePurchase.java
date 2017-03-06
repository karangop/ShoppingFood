package cl.karangop.shoppingfood.views.purchase;

import cl.karangop.shoppingfood.models.Purchase;

/**
 * Created by karan_000 on 01-03-2017.
 */

public class CreatePurchase {

    private PurchaseCallback callback;

    public CreatePurchase(PurchaseCallback callback) {
        this.callback = callback;
    }

    public void validation(String name)
    {
        if (name.trim().length() > 0)
        {
            Purchase purchase= new Purchase();
            purchase.setName(name);
            purchase.setPrice(0);
            purchase.setDone(false);
            purchase.save();
            callback.created(purchase);
        }
        else{
            callback.noName();
        }
    }
}
