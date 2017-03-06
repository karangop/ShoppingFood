package cl.karangop.shoppingfood.views.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cl.karangop.shoppingfood.R;
import cl.karangop.shoppingfood.models.Purchase;
import cl.karangop.shoppingfood.views.purchase.PurchaseActivity;

public class DetailsActivity extends AppCompatActivity {

    private Purchase purchase;
    private EditText name;
    private EditText price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        long id= getIntent().getLongExtra("id",0); //0 es el valor por defecto
        final Purchase purchase= Purchase.findById(Purchase.class, id);
//        Toast.makeText(this, purchase.getName(), Toast.LENGTH_SHORT).show();

        name= (EditText) findViewById(R.id.editName);
        price= (EditText) findViewById(R.id.editPrice);
        Button save= (Button) findViewById(R.id.btnSaveDetail);

        name.setText(purchase.getName());
        price.setText(String.valueOf(purchase.getPrice()));

        //boton guardar detalles
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre= name.getText().toString();
                int precio= Integer.parseInt(price.getText().toString());

                purchase.setName(nombre);
                purchase.setPrice(precio);
                purchase.save();

                startActivity(new Intent(DetailsActivity.this, PurchaseActivity.class));

            }
        });




    }
}
