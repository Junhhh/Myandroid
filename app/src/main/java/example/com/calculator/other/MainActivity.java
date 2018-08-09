package example.com.calculator.other;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import example.com.calculator.BaseActivity;
import example.com.calculator.R;
import example.com.calculator.example.com.calculator.recyclerview.RecyclerActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    Button b1,b3;
    EditText e1,e2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        e1.setOnClickListener(this);
        e2.setOnClickListener(this);
        b1.setOnClickListener(this);
        b3.setOnClickListener(this);

    }

    private void initView() {
        b1 = (Button)findViewById(R.id.button);
        b3 =(Button)findViewById(R.id.recycler_button);
        e1 = (EditText) findViewById(R.id.edit1);
        e2 = (EditText) findViewById(R.id.edit2);
        t1 = (TextView) findViewById(R.id.text_view);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.edit1:
                e1.setText("");
                break;
            case R.id.edit2:
                e2.setText("");
                break;
            case R.id.button:
                int result;
                try{
                    if(CheckEmpty()){
                        throw new Exception("请输入数据！");
                    }
                    int first = Integer.parseInt(e1.getText().toString());
                    int second = Integer.parseInt(e2.getText().toString());
                    result = first + second;
                    t1.setText(Integer.toString(result));

                }catch(NumberFormatException e){
                    Toast.makeText(MainActivity.this,"请输入有效的数字",Toast.LENGTH_SHORT).show();

                }catch(Exception e){
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.recycler_button:
                Intent intent1 = new Intent("com.example.calculator.FORCE_OFFLINE");
                sendBroadcast(intent1);//发送广播
        }
    }


    public boolean CheckEmpty(){
        if(TextUtils.isEmpty(e1.getText())){
            return true;
        }
        if (TextUtils.isEmpty(e2.getText())) {
            return true;
        }else {
            return false;
        }
    }
}
