package com.example.yassin.emiratesapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.yassin.emiratesapp.R;
import com.example.yassin.emiratesapp.model.Car;
import java.util.List;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 *Created by yassin on 7/10/18.
 */

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.MyViewHolder> {
    private Context mContext;
    private List<Car> carJsonList;
    private boolean isEnglish;
    private boolean isRed;


    public CarsAdapter(Context mContext, List<Car> carJsonList, boolean isEnglish, boolean isRed) {
        this.mContext = mContext;
        this.carJsonList = carJsonList;
        this.isEnglish = isEnglish;
        this.isRed = isRed;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Car car = carJsonList.get(position);
        if (isEnglish) {
            holder.carsName.setText(car.getMakeEn());
            holder.carsTimeLeft.setText(car.getAuctionInfo().getEndDateEn());
            holder.carsPrice.setText(car.getAuctionInfo().getCurrentPrice() + car.getAuctionInfo().getCurrencyEn());
            if (isRed) {
                holder.carsTimeLeft.setTextColor(Color.RED);
            } else {
                holder.carsTimeLeft.setTextColor(Color.BLUE);

            }

        } else {
            holder.carsName.setText(car.getMakeAr());
            holder.carsTimeLeft.setText(car.getAuctionInfo().getEndDateAr());
            holder.carsPrice.setText(car.getAuctionInfo().getCurrentPrice() + car.getAuctionInfo().getCurrencyAr());

        }
        holder.carsBids.setText("" + car.getAuctionInfo().getBids());
        holder.carsLot.setText("" + car.getAuctionInfo().getLot());
        Glide.with(mContext).load(car.getImage().replace("[w]", "0").replace("[h]", "0")).into(holder.carsPic);
        final ScaleAnimation animation = new ScaleAnimation(0f, 1f, 0f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(165);
        holder.carFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.carFav.setVisibility(GONE);
                holder.carUnFav.startAnimation(animation);
                holder.carUnFav.setVisibility(VISIBLE);
            }
        });
        holder.carUnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.carUnFav.setVisibility(GONE);
                holder.carFav.startAnimation(animation);
                holder.carFav.setVisibility(VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carJsonList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView carsName, carsBids, carsTimeLeft, carsLot, carsPrice;
        ImageView carsPic, carFav, carUnFav;

        MyViewHolder(View view) {
            super(view);
            carsName = view.findViewById(R.id.car_name);
            carsBids = view.findViewById(R.id.bids_tv);
            carsTimeLeft = view.findViewById(R.id.time_tv);
            carsLot = view.findViewById(R.id.lot_tv);
            carsPrice = view.findViewById(R.id.car_price);
            carsPic = view.findViewById(R.id.car_image);
            carFav = view.findViewById(R.id.posterFav);
            carUnFav = view.findViewById(R.id.posterUnFav);
        }
    }

    public void updateCars(List<Car> carJsons, boolean isRed) {
        carJsonList = carJsons;
        this.isRed = isRed;
        notifyDataSetChanged();
    }
}
