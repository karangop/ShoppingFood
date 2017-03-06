package cl.karangop.shoppingfood.views.dish;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cl.karangop.shoppingfood.R;
import cl.karangop.shoppingfood.data.CurrentDay;
import cl.karangop.shoppingfood.views.purchase.PurchaseActivity;

public class MainActivity extends AppCompatActivity implements DishCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LLamo al metodo de validacion si es que la lista esta vacia
        new CreateDish(this).validation(new CurrentDay().dayNum());

//        seteamos texto con el nombre de hoy
        TextView textView = (TextView) findViewById(R.id.txtDay);
        textView.setText(new CurrentDay().dayOfWeek());


//        TODO Pasar datos de ingredientes a Purchase activity desde fragment
        /*int id= getIntent().getIntExtra("idDish",0);
        Mix mix = Mix.findById(Mix.class, id);*/
//        Toast.makeText(this, mix.getDishId(), Toast.LENGTH_SHORT).show();






        Button jump= (Button) findViewById(R.id.btnJumpStep);
//        Button next= (Button) findViewById(R.id.btnNext);

        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,PurchaseActivity.class);
                startActivity(intent);
            }
        });

        /*next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*
                //Intent
                Intent intent = new Intent(MainActivity.this,PurchaseActivity.class);
                List<String> strings = new ArrayList<String>();
                String[] ides = strings.toArray(new String[strings.size()]);
//                intent.putStringArrayListExtra("", ides);
                startActivity(new Intent(MainActivity.this,PurchaseActivity.class));
            }
        });*/



    }


    @Override
    public void empty() {
        Toast.makeText(this, "No hay registros de platos para hoy", Toast.LENGTH_SHORT).show();
    }
}
