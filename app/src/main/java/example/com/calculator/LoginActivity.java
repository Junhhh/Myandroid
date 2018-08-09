package example.com.calculator;



import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import example.com.calculator.example.com.calculator.recyclerview.RecyclerActivity;

public class LoginActivity extends BaseActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private EditText adminEdit;
    private EditText passwordEdit;
    private Button login;
    private CheckBox rememberPwd,canseePwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        adminEdit = (EditText) findViewById(R.id.login_admin);
        passwordEdit = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.login);
        rememberPwd = (CheckBox)findViewById(R.id.rememberPwd_login);
        canseePwd = (CheckBox)findViewById(R.id.cansee_pwd);

        boolean isRemember = pref.getBoolean("remember_password",false);
        boolean isSeePwd = pref.getBoolean("cansee_pwd",false);
        if(isRemember){
            //读取数据
            String admin = pref.getString("admin","");
            String password = pref.getString("password","");
            adminEdit.setText(admin);
            passwordEdit.setText(password);
            rememberPwd.setChecked(true);//如果不设置为true，下次启动时是 没有勾选上的，这样下下次启动就没有保存密码了
        }
        if(isSeePwd){
            passwordEdit.setTransformationMethod(PasswordTransformationMethod.getInstance());//设置密码不可见
            canseePwd.setChecked(true);
        }
        canseePwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    passwordEdit.setTransformationMethod(PasswordTransformationMethod.getInstance());//设置密码不可见
                }else {
                    passwordEdit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String admin = adminEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(admin.equals("admin") && password.equals("123456")){
                    editor = pref.edit();
                    if(rememberPwd.isChecked()){
                        //储存数据
                        editor.putBoolean("remember_password",true);
                        editor.putString("admin",admin);
                        editor.putString("password",password);
                    }else {
                        editor.clear();//如果不清除editor的数据，键为：cansee_pwd的文件永远都是true
                    }
                    if (canseePwd.isChecked()){
                        editor.putBoolean("cansee_pwd",true);
                    }else {
                        editor.clear();//如果不清除editor的数据，键为：cansee_pwd的文件永远都是true
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, RecyclerActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "账号或者密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
