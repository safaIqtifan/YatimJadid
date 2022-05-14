package com.example.yatimjadid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.yatimjadid.databinding.ActivityAddYatimsBinding;
public class AddYatimsActivity extends BaseActivity {

    ActivityAddYatimsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.toolbarAddActivity.setTitle("الأيتام");
    }
}