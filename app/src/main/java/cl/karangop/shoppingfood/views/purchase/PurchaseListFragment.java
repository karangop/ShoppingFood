package cl.karangop.shoppingfood.views.purchase;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.karangop.shoppingfood.R;
import cl.karangop.shoppingfood.adapters.PurchaseClickListener;
import cl.karangop.shoppingfood.adapters.PurchasesAdapter;
import cl.karangop.shoppingfood.models.Purchase;
import cl.karangop.shoppingfood.views.details.DetailsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PurchaseListFragment extends Fragment implements PurchaseClickListener {


    private PurchasesAdapter adapter;

    public PurchaseListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_purchase_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.rvPurchase);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter= new PurchasesAdapter(this);
        recyclerView.setAdapter(adapter);


        /*TODO revisar para que los item ok se ordenen al ultimo de la lista*/
        final SwipeRefreshLayout reload= (SwipeRefreshLayout) view.findViewById(R.id.srPurchase);
        reload.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.resetEverything();
                        reload.setRefreshing(false);

                    }
                },600);
            }
        });
    }

    public void addPurchase(Purchase purchase){
        adapter.addPurchase(purchase);
    }

    @Override
    public void clickId(long id) {
        Intent intent= new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("id",id); //"id" es la clave
        startActivity(intent);
    }

    @Override
    public void clickPurchase(Purchase purchase) {

    }
}
