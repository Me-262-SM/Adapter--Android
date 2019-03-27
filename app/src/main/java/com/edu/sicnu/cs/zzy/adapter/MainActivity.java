package com.edu.sicnu.cs.zzy.adapter;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //为ArrayAdapter准备数据
        String[] names = getResources().getStringArray(R.array.names);  //获取资源
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);


        //为simpleAdapterda准备数据
//        ArrayList<HashMap<String,String>> persons = new ArrayList<>();
//        HashMap<String,String> person = new HashMap<>();
//        person.put("name","zzy");
//        person.put("age","22");
//        person.put("gender","man");
//        persons.add(person);
//
//        person = new HashMap<>();
//        person.put("name","zsh");
//        person.put("age","22");
//        person.put("gender","man");
//        persons.add(person);
//
//        person = new HashMap<>();
//        person.put("name","xs");
//        person.put("age","22");
//        person.put("gender","man");
//        persons.add(person);
//
//        person = new HashMap<>();
//        person.put("name","caojun");
//        person.put("age","22");
//        person.put("gender","woman");
//        persons.add(person);
//
//        SimpleAdapter simpleAdapter = new SimpleAdapter(this, persons, R.layout.personlayout, new String[]{"name", "age","gender"}, new int[]{R.id.textView1,R.id.textView2,R.id.textView3});

        //自定义Adapter
        final ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("zzy",22,true));
        persons.add(new Person("zsh",21,true));
        persons.add(new Person("xs",21,true));
        persons.add(new Person("yzw",21,true));
        persons.add(new Person("caomeili",21,false));
        persons.add(new Person("zzy",22,true));
        persons.add(new Person("zsh",21,true));
        persons.add(new Person("xs",21,true));
        persons.add(new Person("yzw",21,true));
        persons.add(new Person("caomeili",21,false));
        persons.add(new Person("zzy",22,true));
        persons.add(new Person("zsh",21,true));
        persons.add(new Person("xs",21,true));
        persons.add(new Person("yzw",21,true));
        persons.add(new Person("caomeili",21,false));
        persons.add(new Person("zzy",22,true));
        persons.add(new Person("zsh",21,true));
        persons.add(new Person("xs",21,true));
        persons.add(new Person("yzw",21,true));
        persons.add(new Person("caomeili",21,false));



        final PersonAdapter personAdapter = new PersonAdapter(this,persons);


        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(personAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"pos:"+position,Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final int index = position; //记录下位置
                builder.setTitle("删除");
                builder.setMessage("是否要删除？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        persons.remove(index);
                        personAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Fail to Delete",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();

                return true;    //使其不处理点击事件，如果为false,执行长按事件之后会继续执行单击事件
            }
        });

    }
}
