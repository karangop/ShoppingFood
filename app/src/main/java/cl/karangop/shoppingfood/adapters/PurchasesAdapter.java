package cl.karangop.shoppingfood.adapters;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import cl.karangop.shoppingfood.R;
import cl.karangop.shoppingfood.data.QueriesPurchase;
import cl.karangop.shoppingfood.models.Purchase;

/**
 * Created by karan_000 on 01-03-2017.
 */

public class PurchasesAdapter extends RecyclerView.Adapter<PurchasesAdapter.ViewHolder> {

//    private List<Purchase> purchases;
    private List<Purchase> purchases= new QueriesPurchase().listAllPurchases();
    private PurchaseClickListener listener;

    public PurchasesAdapter(PurchaseClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_purchase, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Purchase purchase= purchases.get(position);
        holder.checkBox.setChecked(purchase.isDone());
        holder.textView1.setText(purchase.getName());
        holder.textView2.setText(String.valueOf(purchase.getPrice()));


//        inicializar cuando los checkbox esten seleccionados y que se tachen
        if (holder.checkBox.isChecked()){
            holder.textView1.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }

//        cambiar estado cuando se chequea
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                int adapterPosition= holder.getAdapterPosition();
                Purchase auxPurchase= purchases.get(adapterPosition);

                if (isChecked){

//                    Para poner texto tachado
                    holder.textView1.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

                    auxPurchase.setDone(true);
                    auxPurchase.save();


//                    Para eliminar item de la lista
//                    purchases.remove(adapterPosition);
                    /*purchases.remove(adapterPosition);
                    notifyItemRemoved(adapterPosition);*/

                }
                else if (!isChecked){

                    auxPurchase.setDone(false);
                    auxPurchase.save();
                    holder.textView1.setPaintFlags(Paint.ANTI_ALIAS_FLAG);


                    /*purchases.remove(adapterPosition);
                    notifyItemRemoved(adapterPosition);*/


                }

            }
        });


//        Al hacer click nos direcciona a otra activity para ver detalles
        holder.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Purchase auxPurchase= purchases.get(holder.getAdapterPosition());
                listener.clickId(auxPurchase.getId());
                notifyDataSetChanged();


            }
        });

    }

    @Override
    public int getItemCount() {
        return purchases.size();
    }

    public void addPurchase(Purchase purchase){
        purchases.add(purchase);
        notifyDataSetChanged();
    }

//    reset loading
    /*TODO revisar reset*/
    public void resetEverything()
    {
        new QueriesPurchase().listAllPurchases();

        notifyDataSetChanged();
//        notifyItemRangeInserted(listSize, purchases.size());

    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private final CheckBox checkBox;
        private final TextView textView1;
        private final TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);

            checkBox= (CheckBox) itemView.findViewById(R.id.chkPurchase);
            textView1= (TextView) itemView.findViewById(R.id.txtPurchase);
            textView2= (TextView) itemView.findViewById(R.id.txtPrice);
        }
    }
}
