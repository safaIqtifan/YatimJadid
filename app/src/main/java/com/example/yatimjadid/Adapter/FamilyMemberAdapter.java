package com.example.yatimjadid.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yatimjadid.DataCallBack;
import com.example.yatimjadid.Models.FamilyMembersModel;
import com.example.yatimjadid.R;

import java.util.ArrayList;

public class FamilyMemberAdapter extends RecyclerView.Adapter<FamilyMemberAdapter.ViewHolder> {

    Activity context;
    ArrayList<FamilyMembersModel> data;
    DataCallBack dataCallBack;
//    FamilyMembersModel familyMembersModel;

    public FamilyMemberAdapter(Activity context, ArrayList<FamilyMembersModel> data, DataCallBack callBack) {
        this.context = context;
        this.data = data;
        this.dataCallBack = callBack;
    }

    public void setListData(ArrayList<FamilyMembersModel> list) {
        data = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(context).inflate(R.layout.family_member_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        FamilyMembersModel familyMembersModel = data.get(position);

        holder.letterName.setText(String.valueOf(familyMembersModel.getMemberName().charAt(0)));
        holder.memberName.setText(String.valueOf(familyMembersModel.getMemberName()));
        holder.age.setText(String.valueOf(familyMembersModel.getAge()));
        holder.relationshipWithYatim.setText(String.valueOf(familyMembersModel.getMemberRelationshipWithYatim()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView memberName;
        TextView letterName;
        TextView age;
        TextView relationshipWithYatim;
        ConstraintLayout cardLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            memberName = itemView.findViewById(R.id.member_name);
            letterName = itemView.findViewById(R.id.letter_name);
            age = itemView.findViewById(R.id.member_age);
            relationshipWithYatim = itemView.findViewById(R.id.member_relationship);
            cardLayout = itemView.findViewById(R.id.cardView_layout);

            cardLayout.setOnClickListener(view -> {
                FamilyMembersModel familyMembersModel = data.get(getAdapterPosition());
                dataCallBack.Result(familyMembersModel, "add", getAdapterPosition());
            });

            cardLayout.setOnLongClickListener(view -> {
//                    FamilyMembersModel familyMembersModel = data.get(getAdapterPosition());

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
                return false;
            });

        }
    }
}
