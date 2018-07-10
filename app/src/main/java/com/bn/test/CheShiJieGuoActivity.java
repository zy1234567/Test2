package com.bn.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


import com.bn.test.adapter.CheshiJieguoAdapter;

import java.util.ArrayList;

/**
 * Created by JD on 2017/12/2.
 */

public class CheShiJieGuoActivity extends Activity {
    CheshiJieguoAdapter cheshiJieguoAdapter;
    GridView gridView;
    ArrayList<String>ls;
    ImageView kaishi;
    TextView textView;
    ImageView back;
    Button jixu;
    public static Activity activity;
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.cheshi_jieguo_activity);
        activity=this;
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        ls=bundle.getStringArrayList("jieguo");
        initView();
    }
    public void initView(){
        gridView=(GridView)this.findViewById(R.id.gview) ;
        kaishi=(ImageView)this.findViewById(R.id.back);
        textView=(TextView)this.findViewById(R.id.btname);
        back=(ImageView)this.findViewById(R.id.back);
        back.setVisibility(View.GONE);
        jixu=(Button)this.findViewById(R.id.jixu);
        textView.setText("在线测试结果报告");
        kaishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(CheShiJieGuoActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
            }
        });
        cheshiJieguoAdapter=new CheshiJieguoAdapter(getApplicationContext(),ls);
        gridView.setAdapter(cheshiJieguoAdapter);
        jixu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            Intent intent=new Intent(CheShiJieGuoActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
            }
        });
    }
}
