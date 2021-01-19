package com.example.datamea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up nav menu
        drawerLayout = (DrawerLayout)findViewById(R.id.activity_main);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer);
        navView = (NavigationView)findViewById(R.id.nv);

        handleNavMenu();

        //get and show table info
        showTableInfo();
    }

    //________________________________________________VIEWS ONCLICK___________________________________________
    public void addTable_btnOclick(View v)
    {
        Toast.makeText(this, "Make a new table!", Toast.LENGTH_LONG).show();
    }


    //________________________________________________TABLE CARDVIEWS STUFF____________________________________
    //puts info of tables into cardviews then adds them to the homepage
    private void showTableInfo()
    {
        LinearLayout homeLayout = (LinearLayout) findViewById(R.id.home_linLay);
        ArrayList<TableInfo> info = getTableInfo();
        final Context context = this;
        for(int i = 0; i < info.size(); ++i)
        {
            TableInfo table = info.get(i);

            LinearLayout card = (LinearLayout)getLayoutInflater().inflate(R.layout.table_home_card, null);
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "You clicked a table!", Toast.LENGTH_LONG).show();
                }
            });

            //set table name
            TextView tablename = (TextView)card.findViewById(R.id.table_name);
            tablename.setText(table.getName());

            //set number of rows
            TextView nr_rows = (TextView)card.findViewById(R.id.curr_rows);
            nr_rows.setText("number of rows: "+ table.getNr_rows());

            homeLayout.addView(card);

        }
    }

    private ArrayList<TableInfo> getTableInfo()
    {
        ArrayList<TableInfo> output = new ArrayList<>();

        TableInfo t1 = new TableInfo("Table1");
        TableInfo t2 = new TableInfo("Table2");
        output.add(t1);
        output.add(t2);


        return output;
    }


    //________________________________________________NAVIGATION VIEW STUFF____________________________________
    private void handleNavMenu()
    {
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.settings:
                        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.backup:
                        Toast.makeText(MainActivity.this, "Back up data", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.about:
                        Toast.makeText(MainActivity.this, "About us", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        return true;
                }

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(drawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        {
            super.onBackPressed();
        }
    }
}