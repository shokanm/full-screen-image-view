package com.github.tntkhang.fullscreenimageview.library;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private List<String> imagesUri = new ArrayList<>();

    PagerAdapter(FragmentManager fragmentManager, List<String> images) {
        super(fragmentManager);
        for (String image : images) {
            this.imagesUri.add(image);
        }
    }

    @Override
    public Fragment getItem(int position) {
        String item = imagesUri.get(position);
        return ImageFragment.newInstance(item);
    }

    @Override
    public int getCount() {
        return imagesUri.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }
}
