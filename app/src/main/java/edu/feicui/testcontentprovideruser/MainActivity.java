package edu.feicui.testcontentprovideruser;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //访问者  访问
        ContentResolver resolver=getContentResolver();
        //解析
        Uri uri=Uri.parse("content://edu.feicui.testcontentprovider.MY_PROVIDER/stu");
        ContentValues values=new ContentValues();
        values.put("_id","1");
        values.put("name","默默默默磨");
        values.put("level","21");
        Uri resultUri=resolver.insert(uri,values);
        Log.e("aaa", "onCreate: resultUri=="+resultUri );


        //查询
        Cursor cursor=resolver.query(uri,null,null,null,null);
        while (cursor.moveToNext()){
            int id=cursor.getInt(cursor.getColumnIndex("_id"));
            String name=cursor.getString(cursor.getColumnIndex("name"));
            int level=cursor.getInt(cursor.getColumnIndex("level"));
            Log.e("aaa", "onCreate: id=="+id+"--name=="+name+"--level=="+level );
        }
        cursor.close();
    }
}
