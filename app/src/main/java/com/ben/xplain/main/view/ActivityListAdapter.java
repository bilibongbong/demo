package com.ben.xplain.main.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ben.xplain.R;

import java.util.ArrayList;

/**
 * Created by wangshuhe on 2017/4/7.
 */
public class ActivityListAdapter extends RecyclerView.Adapter<ActivityListAdapter.ItemHolder> {
    private final static String TAG = "ActivityListAdapter";
    private ArrayList<Class<? extends Activity>> classArrayList;


    public ActivityListAdapter(){
        classArrayList = new ArrayList<>();
    }

    public ActivityListAdapter addItem(Class<? extends Activity> activityClass){
        if(!classArrayList.contains(activityClass)){
            classArrayList.add(activityClass);
        }
        return this;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.setItemData(classArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return classArrayList.size();
    }


    public static class ItemHolder extends RecyclerView.ViewHolder{
        Class<? extends Activity> aClass;
        public ItemHolder(View itemView) {
            super(itemView);
        }

        public void setItemData(Class<? extends Activity> activityClass){
            aClass = activityClass;
            ((TextView)itemView).setText(activityClass.getSimpleName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), aClass);
                    v.getContext().startActivity(intent);

                    Intent i = new Intent("android.intent.action");
                    i.setPackage(v.getContext().getPackageName());
                    //ComponentName name = i.resolveActivity(v.getContext().getPackageManager());
                    ComponentName name = v.getContext().startService(i);
                    Log.v(TAG, name.toString());

                }
            });
        }
    }
}
