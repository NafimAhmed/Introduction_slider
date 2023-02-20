package com.example.viewpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPageAdapter extends PagerAdapter {


    Context context;

    int image[]={
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground
    };

    int headings[]={
            R.string.app_name,
            R.string.app_name,
            R.string.app_name,
            R.string.app_name
    };

    int description[]={

            R.string.app_name,
            R.string.app_name,
            R.string.app_name,
            R.string.app_name

    };

    public ViewPageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       // return super.instantiateItem(container, position);

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view=layoutInflater.inflate(R.layout.slder_layout,container,false);


        ImageView slideTitle=(ImageView) view.findViewById(R.id.titleImage);
        TextView slideHeading=(TextView) view.findViewById(R.id.texttitle);
        TextView slidedescription=(TextView) view.findViewById(R.id.textdescription);


        slideTitle.setImageResource(image[position]);
        slideHeading.setText(headings[position]);
        slidedescription.setText(description[position]);

        container.addView(view);

        return view;

    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);

        container.removeView((LinearLayout)object);


    }
}
