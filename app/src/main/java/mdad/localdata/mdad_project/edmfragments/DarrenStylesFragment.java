package mdad.localdata.mdad_project.edmfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import mdad.localdata.mdad_project.EDMActivity;
import mdad.localdata.mdad_project.R;
import mdad.localdata.mdad_project.darrensongs.DLMDActivity;
import mdad.localdata.mdad_project.darrensongs.DYSLYMActivity;
import mdad.localdata.mdad_project.darrensongs.SwitchActivity;
import mdad.localdata.mdad_project.darrensongs.UAWActivity;

public class DarrenStylesFragment extends AppCompatActivity {

    public static ViewPager2 viewPager;

    private FragmentStateAdapter pagerAdapter;

    private String[] titles = new String[]{"Information", "Top Songs"};

    private static final int NUM_PAGES = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darren_styles_fragment);

        viewPager = findViewById(R.id.mypager);

        TabLayout tabLayout =(TabLayout) findViewById(R.id.tab_layout);

        pagerAdapter = new DarrenStylesFragment.MyPagerAdapter(this);

        viewPager.setAdapter(pagerAdapter);

        TabLayoutMediator tlm = new TabLayoutMediator(tabLayout,viewPager,(tab, position) -> tab.setText(titles[position]));

        tlm.attach();
    }

    private class MyPagerAdapter extends FragmentStateAdapter {

        public MyPagerAdapter(DarrenStylesFragment fa) {
            super(fa);
        }
        @Override

        public Fragment createFragment(int pos) {
            switch (pos) {
                case 0: {
                    return FirstDarrenStylesFragment.newInstance("fragment 1",null);
                }
                case 1: {
                    return SecondDarrenStylesFragment.newInstance("fragment 2",null);

                }
                default:
                    return new Fragment();
            }
        }
        @Override

        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}