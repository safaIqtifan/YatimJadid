package com.example.yatimjadid.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yatimjadid.DataCallBack;
import com.example.yatimjadid.Models.AddYatimModel;
import com.example.yatimjadid.Models.FamilyMembersModel;
import com.example.yatimjadid.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class YatimDataAdapter extends RecyclerView.Adapter<YatimDataAdapter.ViewHolder> {

    Activity context;
    ArrayList<AddYatimModel> data;
    DataCallBack dataCallBack;

    public YatimDataAdapter(Activity context, ArrayList<AddYatimModel> data, DataCallBack callBack) {
        this.context = context;
        this.data = data;
        this.dataCallBack = callBack;
    }

    public void setListData(ArrayList<AddYatimModel> list) {
        data = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(context).inflate(R.layout.yatim_data_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AddYatimModel addYatimModel = data.get(position);

        holder.yatimName.setText(String.valueOf(addYatimModel.getYatimName()));
        holder.age.setText(String.valueOf(addYatimModel.getYatimeAge()));
        Glide.with(context).asBitmap().load(addYatimModel.getYatimPhotoUri()).into(holder.yatimProfileImg);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView yatimName;
        TextView age;
        CircleImageView yatimProfileImg;
        ConstraintLayout cardLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            yatimName = itemView.findViewById(R.id.yatim_name);
            age = itemView.findViewById(R.id.yatim_age);
            yatimProfileImg = itemView.findViewById(R.id.yatim_profile_img);
            cardLayout = itemView.findViewById(R.id.yatim_cardView_layout);

            cardLayout.setOnClickListener(view -> {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("حذف");
                builder.setMessage("هل انت متأكد من الحذف ؟");

                builder.setPositiveButton("نعم", (dialog, which) -> {
                    int position = getAdapterPosition();
                    data.remove(position);
                    notifyItemRemoved(position);
                    dataCallBack.Result(null, "delete", getAdapterPosition());
                });
                builder.setNegativeButton("لا", (dialog, which) -> {
                });
                builder.create().show();
            });

        }
    }
}
