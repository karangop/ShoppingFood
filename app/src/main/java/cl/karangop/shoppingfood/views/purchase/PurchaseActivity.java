package cl.karangop.shoppingfood.views.purchase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import cl.karangop.shoppingfood.R;
import cl.karangop.shoppingfood.models.Purchase;

public class PurchaseActivity extends AppCompatActivity implements PurchaseCallback {

    private PurchaseListFragment purchaseListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        purchaseListFragment= (PurchaseListFragment) getSupportFragmentManager().findFragmentById(R.id.purchaseListFragment);

        /*TODO pasa mixes desde mainactivity a purchaseactivity*/
        /*int id= getIntent().getIntExtra("idDish",0);
        Mix mix= Mix.findById(Mix.class, id);
        Toast.makeText(this, mix.getDishId(), Toast.LENGTH_SHORT).show();*/

        ImageButton btnAdd= (ImageButton) findViewById(R.id.imgBtnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input= (EditText) findViewById(R.id.etInput);
                String name= input.getText().toString();

                CreatePurchase createPurchase= new CreatePurchase(PurchaseActivity.this);
                createPurchase.validation(name);
                input.setText(null);
            }
        });

    }

    @Override
    public void created(Purchase purchase) {
        purchaseListFragment.addPurchase(purchase);
    }

    @Override
    public void noName() {
        Toast.makeText(this, "Ingrese texto, por favor", Toast.LENGTH_SHORT).show();

    }
}
