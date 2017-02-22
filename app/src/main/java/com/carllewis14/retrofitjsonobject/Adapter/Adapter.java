package com.carllewis14.retrofitjsonobject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.carllewis14.retrofitjsonobject.DataModel.Contact;
import com.carllewis14.retrofitjsonobject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Adapter Class for Data
 * Assigns Data parsed from feed to view created in layouts
 */

public class Adapter extends ArrayAdapter<Contact> {

    private List<Contact> contactList;
    private Context context;
    private LayoutInflater mInflater;

    //Constructors
    public Adapter(Context context,  List<Contact> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        contactList = objects;
    }


    @Override
    public Contact getItem(int position) {
        return contactList.get(position);


    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;

        if (convertView == null) {
            View view = mInflater.inflate(R.layout.row_item, parent, false);
                vh = ViewHolder.create((RelativeLayout) view);
                view.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

           Contact item = getItem(position);

        vh.tvName.setText(item.getName());
        vh.tvEmail.setText(item.getEmail());
        Picasso.with(context).load(item.getProfilePic()).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher).resize(10,10).into(vh.imageView);

        return vh.rootView;

        }


    private static class ViewHolder {
         final RelativeLayout rootView;
         final ImageView imageView;
         final TextView tvName;
         final TextView tvEmail;


        private ViewHolder(RelativeLayout rootView, TextView tvName, TextView tvEmail, ImageView imageView) {

            this.rootView = rootView;
            this.tvName = tvName;
            this.tvEmail = tvEmail;
            this.imageView = imageView;
        }


        public static ViewHolder create(RelativeLayout rootView) {

            TextView tvName = (TextView) rootView.findViewById(R.id.tvName);
            TextView tvEmail = (TextView) rootView.findViewById(R.id.tvEmail);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
            return new ViewHolder(rootView, tvName, tvEmail, imageView);
        }
    }




    }

