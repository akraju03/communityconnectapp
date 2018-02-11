package com.sourcey.materiallogindemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends ActionBarActivity {

    private ListView lvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPhone = (ListView)findViewById(R.id.listPhone);

        List<PhoneBook> listPhoneBook = new ArrayList<PhoneBook>();
        listPhoneBook.add(new PhoneBook(
                BitmapFactory.decodeResource(getResources(), R.drawable.logo),
                "Pete Houston", "010-9817-6331", "pete.houston.17187@gmail.com"));
        listPhoneBook.add(new PhoneBook(
                BitmapFactory.decodeResource(getResources(), R.drawable.logo),
                "Lina Cheng", "046-7764-1142", "lina.cheng011@sunny.com"));
        listPhoneBook.add(new PhoneBook(
                BitmapFactory.decodeResource(getResources(), R.drawable.logo),
                "Jenny Nguyen", "0913-223-498", "jenny_in_love98@yahoo.com"));
        PhoneBookAdapter adapter = new PhoneBookAdapter(this, listPhoneBook);
        lvPhone.setAdapter(adapter);

        Intent intent = new Intent(this, LoginActivity.class);

        startActivity(intent);

        lvPhone.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("clicked");
                String name = ((TextView) view.findViewById(R.id.tvName)).getText().toString();
                String email = ((TextView) view.findViewById(R.id.tvEmail)).getText().toString();
                String phone = ((TextView) view.findViewById(R.id.tvPhone)).getText().toString();

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("phone", phone);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
