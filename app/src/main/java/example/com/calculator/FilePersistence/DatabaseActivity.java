package example.com.calculator.FilePersistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import example.com.calculator.R;

/**
 *   SQLite
 */
public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener {

    private MyDatabaseHelper dbHelper;

    private Button create,add,update,delete,select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        dbHelper = new MyDatabaseHelper(this,"BookStore.db",null,3);
        create = (Button) findViewById(R.id.create_database);
        add = (Button) findViewById(R.id.add_database);
        update = (Button)findViewById(R.id.update_database);
        delete = (Button)findViewById(R.id.delete_database);
        select = (Button)findViewById(R.id.select_database);
        create.setOnClickListener(this);
        add.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        select.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create_database:
                dbHelper.getWritableDatabase();
                break;
            case R.id.add_database:
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                ContentValues values = new ContentValues();
                //插入第一条数据
                values.put("author","Dan Brow");
                values.put("name","huahuahua");
                values.put("price",49.9);
                values.put("pages",654);
                db.insert("Book",null,values);
                values.clear();
                //插入第二条数据
                values.put("name","The last");
                values.put("author","qianjunhua");
                values.put("price",19.9);
                values.put("pages",388);
                db.insert("Book",null,values);

                break;
            case R.id.update_database:
                db = dbHelper.getReadableDatabase();
                values = new ContentValues();
                values.put("price",25.9);
                db.update("Book",values,"name=?",new String[]{"The last"});
                break;
            case R.id.delete_database:
                db = dbHelper.getReadableDatabase();
                db.delete("Book","name=?",new String[]{"huahuahua"});
                break;
            case R.id.select_database:
                db = dbHelper.getReadableDatabase();
                Cursor cursor = db.query("Book",null,null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("DatabaseActivity", "书名："+name);
                        Log.d("DatabaseActivity", "作者："+author);
                        Log.d("DatabaseActivity", "页数："+pages);
                        Log.d("DatabaseActivity", "价格："+price);

                    }while (cursor.moveToNext());
                }
                cursor.close();
                break;
        }
    }
}
