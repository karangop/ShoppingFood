package cl.karangop.shoppingfood.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cl.karangop.shoppingfood.R;
import cl.karangop.shoppingfood.data.QueriesDish;
import cl.karangop.shoppingfood.models.Dish;
import cl.karangop.shoppingfood.models.Mix;

/**
 * Created by karan_000 on 25-02-2017.
 */

public class DishAdapters extends RecyclerView.Adapter<DishAdapters.ViewHolder> {

    private final List<Dish> dishes;
    private List<Mix> mixes= new QueriesDish().mixAll();
//    private List<Dish> dishes= new QueriesDish().listAll();
    private DishClickListener listener;


    public DishAdapters(DishClickListener listener, int day) {
        this.listener = listener;
        dishes = new QueriesDish().byDay(day);
//        dishes = new QueriesDish().listAll();
//        mixes= new QueriesDish().byDish(1);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_dish, parent,false);

        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Dish dish= dishes.get(position);

        holder.imageView.setImageResource(dish.getImage());
//        holder.checkBox.setChecked(dish.isStatus());
        holder.textView.setText(dish.getName());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO esto es de prueba
                listener.dishClicked();


                /*Mix auxDish= mixes.get(holder.getAdapterPosition());
                listener.dishClicked(auxDish.getDishId());
                notifyDataSetChanged();*/
            }
        });

    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }


    //Primero creamos esto, para luego extends DishAdapters
    static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
//        private CheckBox checkBox;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.imgViewDish);
//            checkBox= (CheckBox) itemView.findViewById(R.id.chkSelectDish);
            textView= (TextView) itemView.findViewById(R.id.txtNameDish);
        }
    }
}
