package com.aseel.examapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // إدارة التبويبات الثلاثة وعرض الـ Fragment المناسب لكل تبويب
        switch (position) {
            case 0:
                return new FirstFragment();  // التبويب الأول (First)
            case 1:
                return new SecondFragment(); // التبويب الثاني (Second)
            case 2:
                return new ThirdFragment();  // التبويب الثالث (Third)
            default:
                return new FirstFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // عدد التبويبات الكلي المطلوب في الامتحان
    }
}
