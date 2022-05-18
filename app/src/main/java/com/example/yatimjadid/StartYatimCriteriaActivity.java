package com.example.yatimjadid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.yatimjadid.Models.AllResolutionModels;
import com.example.yatimjadid.databinding.ActivityStartYatimCriteriaBinding;
import com.example.yatimjadid.fragments.FamilyMembersFragment;
import com.example.yatimjadid.fragments.FirstFragment;
import com.example.yatimjadid.fragments.NewYatimsFragment;
import com.example.yatimjadid.fragments.SecondFragment;
import com.example.yatimjadid.fragments.WaterHygieneFragment;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class StartYatimCriteriaActivity extends BaseActivity {

    private ActivityStartYatimCriteriaBinding binding;

//    ViewPager viewPager;

    public AllResolutionModels allResolutionModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStartYatimCriteriaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.mainToolbar);

        allResolutionModels = new AllResolutionModels();

//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

//        binding.toolbarBackBtn.setOnClickListener(view -> {
//            onBackPressed();
//        });

        binding.mainBackBtn.setOnClickListener(view -> {
            onBackPressed();
        });

        binding.viewPager.setPagingEnabled(false);
        binding.viewPager.setOffscreenPageLimit(5);

        setupViewPager(binding.viewPager);

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).setTitle(getString(R.string.exit_criteria)).show();

    }

    public void nextFragment() {
        binding.viewPager.setCurrentItem(binding.viewPager.getCurrentItem() + 1);
    }

    public void prevFragment() {
        binding.viewPager.setCurrentItem(binding.viewPager.getCurrentItem() - 1);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

//        Fragment add1Fragment = new YatimSelectionCriteriaFragment();

        Fragment add1Fragment = new FirstFragment();

        Fragment add2Fragment = new SecondFragment();

        Fragment add3Fragment = new WaterHygieneFragment();

        Fragment add4Fragment = new FamilyMembersFragment();

        Fragment add5Fragment = new NewYatimsFragment();

        adapter.addFragment(add1Fragment, "");
        adapter.addFragment(add2Fragment, "");
        adapter.addFragment(add3Fragment, "");
        adapter.addFragment(add4Fragment, "");
        adapter.addFragment(add5Fragment, "");

        viewPager.setAdapter(adapter);

    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}