package example.com.calculator.other;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.com.calculator.BaseActivity;
import example.com.calculator.R;


public class Main2Activity extends BaseActivity implements View.OnClickListener {


    private static final String TAG = "Main2Activity";
    EditText e1,e2,e3;
    Button b1,b2,b3,b4;

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        String tempData = "something";
        outState.putString("data_key",tempData);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if(savedInstanceState != null){
            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG, "onCreate: "+tempData);
        }

        initId();

        e1.setOnClickListener(this);
        e2.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

    }

    private void initId() {
        e1 = (EditText)findViewById(R.id.editText1);
        e2 = (EditText)findViewById(R.id.editText2);
        e3 = (EditText)findViewById(R.id.editText_view);
        b1 = (Button)findViewById(R.id.button2);
        b2 = (Button)findViewById(R.id.button3);
        b3 = (Button)findViewById(R.id.button4);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.editText1:
                e1.setText("");
                break;
            case R.id.editText2:
                e2.setText("");
                break;
            case R.id.button2:
                AlertDialog.Builder dialog = new AlertDialog.Builder(Main2Activity.this);
                dialog.setTitle("提示：");
                dialog.setMessage("是否登陆？");
                dialog.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Main2Activity.this,"确定",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Main2Activity.this,"取消",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setCancelable(false);//阻止按对话框外的地方会退出对话框！！
                //设置按钮颜色
                final AlertDialog alertDialog = dialog.create();//先创建对话框
                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLUE);
                        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.GREEN);
                    }
                });
                alertDialog.show();//显示对话框
                break;
            case R.id.button3:
                ProgressDialog progressDialog = new ProgressDialog(Main2Activity.this);
                progressDialog.setTitle("请稍后");
                progressDialog.setMessage("正在拼命加载中......");
                progressDialog.show();
                break;
            case R.id.button4:
                Intent intent = new Intent(Main2Activity.this,ViewActivity.class);
                intent.putExtra("Inputdata",e3.getText().toString());
                startActivity(intent);
                break;
        }
    }
}
