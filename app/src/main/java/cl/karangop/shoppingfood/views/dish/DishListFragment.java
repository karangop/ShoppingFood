package cl.karangop.shoppingfood.views.dish;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cl.karangop.shoppingfood.R;
import cl.karangop.shoppingfood.adapters.DishAdapters;
import cl.karangop.shoppingfood.adapters.DishClickListener;
import cl.karangop.shoppingfood.data.CurrentDay;
import cl.karangop.shoppingfood.views.purchase.PurchaseActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DishListFragment extends Fragment implements DishClickListener {

//    private DishAdapters adapter;

    private List<String> ids = new ArrayList<>();

    public DishListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_dish_list, container, false);
        return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.rvDish_);
        recyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);

        DishAdapters adapter = new DishAdapters(this, new CurrentDay().dayNum()); // this
        recyclerView.setAdapter(adapter);

        final SwipeRefreshLayout refreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.SrReload);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefreshing(false);
                    }
                },600);
            }
        });
    }

    /*TODO add cambio de total de precios*/
    /*@Override
    public void dishClicked(int id) {

//        ids.add(String.valueOf(id));

        *//*Intent intent= new Intent(getActivity(), PurchaseActivity.class);
        intent.putExtra("idDish",id);
        startActivity(intent);*//*
    }*/

    public List<String> getIds() {
        return ids;
    }

    @Override
    public void dishClicked() {
        startActivity(new Intent(getActivity(),PurchaseActivity.class));
    }
}
