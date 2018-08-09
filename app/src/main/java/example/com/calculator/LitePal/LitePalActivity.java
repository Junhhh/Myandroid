package example.com.calculator.LitePal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

import example.com.calculator.R;

public class LitePalActivity extends AppCompatActivity implements View.OnClickListener{

    private Button create,add,update,delete,select;

    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);
        create = (Button)findViewById(R.id.create_litepal);
        add = (Button)findViewById(R.id.add_litepal);
        update = (Button)findViewById(R.id.update_litepal);
        delete = (Button)findViewById(R.id.delete_litepal);
        select = (Button)findViewById(R.id.select_litepal);
        initonclick();
    }

    private void initonclick() {
        create.setOnClickListener(this);
        add.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        select.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create_litepal:
                Connector.getDatabase();
                break;
            case R.id.add_litepal:
                book = new Book();
                book.setName("三体");
                book.setAuthor("不明");
                book.setPages(1042);
                book.setPrice(88.9);
                book.save();
                break;
            case R.id.update_litepal:
                book = new Book();
                book.setPrice(79.9);
                book.updateAll("name = ?","三体");
                break;
            case R.id.delete_litepal:
                LitePal.deleteAll(Book.class,"name = ?","三体");
                break;
            case R.id.select_litepal:
                List<Book> books = LitePal.findAll(Book.class);
                for(Book book:books){
                    Log.d("LitePalActivity", "name:"+book.getName());
                    Log.d("LitePalActivity", "Author:"+book.getAuthor());
                    Log.d("LitePalActivity", "Pages:"+book.getPages());
                    Log.d("LitePalActivity", "price:"+book.getPrice());
                }
                break;
        }
    }

}
