package com.classroom.app1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.classroom.app1.Model.Product;
import com.classroom.app1.UI.ClickListeners.RecyclerViewClickListenerProduct;

import java.util.ArrayList;

public class ProductRVAdapter extends RecyclerView.Adapter<ProductRVAdapter.ViewHolder> {

    private ArrayList<Product> products;
    private Context context;
    private RecyclerViewClickListenerProduct mClickListener;

    public ProductRVAdapter(ArrayList<Product> products, Context context, RecyclerViewClickListenerProduct mClickListener) {
        this.products = products;
        this.context = context;
        this.mClickListener = mClickListener;
    }

    @Override
    public ProductRVAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_view, viewGroup, false);
        return new ProductRVAdapter.ViewHolder(v);
    }

    public ArrayList<Product> getItems() {
        return products;
    }

    @Override
    public void onBindViewHolder(ProductRVAdapter.ViewHolder viewHolder, int position) {
        viewHolder.bindModel(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Product mProduct;
        ImageView productImg;
        TextView productname;
        TextView productprice;


        ViewHolder(View v) {
            super(v);
            productImg = itemView.findViewById(R.id.image_single_view);
            productname = itemView.findViewById(R.id.name_single_view);
            productprice = itemView.findViewById(R.id.price_single_view);

            v.setOnClickListener(this);
        }

        @SuppressLint("SetTextI18n")
        void bindModel(Product products) {

            this.mProduct = products;
            productname.setText(mProduct.getfname());
            productprice.setText(" Rs:"+mProduct.getPrice());


            Glide
                    .with(context)
                    .load(mProduct.getImg().get(0).toString())
                    //.asBitmap()
                    .into(productImg);
        }

        @Override
        public void onClick(View view) {
            mClickListener.onClick(view, mProduct);
        }
    }
}

