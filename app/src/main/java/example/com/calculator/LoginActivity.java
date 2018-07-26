package example.com.calculator;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.com.calculator.example.com.calculator.recyclerview.RecyclerActivity;

public class LoginActivity extends BaseActivity {

    private EditText adminEdit;
    private EditText passwordEdit;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        adminEdit = (EditText) findViewById(R.id.login_admin);
        passwordEdit = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String admin = adminEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(admin.equals("admin") && password.equals("123456")){
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
