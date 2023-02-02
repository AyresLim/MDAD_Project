package mdad.localdata.mdad_project.hiphopfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import mdad.localdata.mdad_project.R;

public class EminemFragment extends AppCompatActivity {

    public static ViewPager2 viewPager;

    private FragmentStateAdapter pagerAdapter;

    private String[] titles = new String[]{"Information", "Top Songs"};

    private static final int NUM_PAGES = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eminem_fragment);

        viewPager = findViewById(R.id.mypager);

        TabLayout tabLayout =(TabLayout) findViewById(R.id.tab_layout);

        pagerAdapter = new EminemFragment.MyPagerAdapter(this);

        viewPager.setAdapter(pagerAdapter);

        TabLayoutMediator tlm = new TabLayoutMediator(tabLayout,viewPager,(tab, position) -> tab.setText(titles[position]));

        tlm.attach();
    }

    private class MyPagerAdapter extends FragmentStateAdapter {

        public MyPagerAdapter(EminemFragment fa) {
            super(fa);
        }
        @Override

        public Fragment createFragment(int pos) {
            switch (pos) {
                case 0: {
                    return FirstEminemFragment.newInstance("fragment 1",null);
                }
                case 1: {
                    return SecondEminemFragment.newInstance("fragment 2",null);

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