//package com.example.yatimjadid.Adapter;
//
//import android.app.Activity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import com.example.yatimjadid.Models.SpinnerMaterialsNeedModels;
//import com.example.yatimjadid.R;
//
//import java.util.ArrayList;
//
//public class SpinnerMaterialsNeedAdapter extends ArrayAdapter<SpinnerMaterialsNeedModels> {
//
////    Activity context;
////    ArrayList<SpinnerMaterialsNeedAdapter> materialsNeedList;
//
//    public SpinnerMaterialsNeedAdapter(Activity context, ArrayList<SpinnerMaterialsNeedModels> materialsNeedList) {
//        super(context, 0, materialsNeedList);
//
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return initView(position, convertView, parent);
//    }
//
//    @Override
//    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return initView(position, convertView, parent);
//    }
//
//    private View initView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(
//                    R.layout.spinner_item, parent, false
//            );
//        }
//
////        TextView textViewName = convertView.findViewById(R.id.spinner_item);
//
//        SpinnerMaterialsNeedModels spinnerMaterialsNeedModels = getItem(position);
//
//        if (spinnerMaterialsNeedModels != null) {
//            textViewName.setText(spinnerMaterialsNeedModels.getMaterialsNeeds());
//        }
//
//        return convertView;
//    }
//}
