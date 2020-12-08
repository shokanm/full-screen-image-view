package com.github.tntkhang.fullscreenimageview.library;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImageFragment extends Fragment {
    private String url;
    private static final String EXTRA_URI = "EXTRA_URI";

    public static ImageFragment newInstance(String uri) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_URI, uri);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getArguments() != null) {
            String path = getArguments().getString(EXTRA_URI);
            url = path;
        }
        View view = inflater.inflate(R.layout.full_image_item, container, false);

        if (view instanceof TouchImageView) {
            Glide.with(this)
                    .load(url)
                    .apply(RequestOptions.placeholderOf(R.drawable.nopic_placeholder))
                    .into((TouchImageView)view);
        }

        return view;
    }

}
