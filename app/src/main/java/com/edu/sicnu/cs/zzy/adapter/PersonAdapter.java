package com.edu.sicnu.cs.zzy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.ContentHandler;
import java.util.ArrayList;

public class PersonAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Person> persons;

    public PersonAdapter(Context context, ArrayList<Person> persons) {
        this.context = context;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        //节约内存，优化性能,这样做可以重用对象空间
        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.personlayout,null);    //恢复视图
            viewHolder = new ViewHolder();
            viewHolder.textView_name = view.findViewById(R.id.textView1);
            viewHolder.textView_age = view.findViewById(R.id.textView2);
            viewHolder.textView_gender = view.findViewById(R.id.textView3);
            viewHolder.imageView = view.findViewById(R.id.imageView);
            view.setTag(viewHolder);    //设置”标签“，因为内部类运行后就会消失
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        //各属性设置
        Person person = (Person) getItem(position);
        viewHolder.textView_name.setText(person.getName());
        viewHolder.textView_age.setText(""+person.getAge());
        viewHolder.textView_gender.setText(person.isGender()?"man":"woman");
        viewHolder.imageView.setAdjustViewBounds(true);
        if(person.isGender()){
            viewHolder.imageView.setImageResource(R.drawable.bg_black_small);
        }else{
            viewHolder.imageView.setImageResource(R.drawable.bg_pink_small);
        }
        return view;
    }

    class ViewHolder{
        TextView textView_name;
        TextView textView_age;
        TextView textView_gender;
        ImageView imageView;
    }
}
