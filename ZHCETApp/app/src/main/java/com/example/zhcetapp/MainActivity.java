package com.example.zhcetapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.zhcetapp.ebook.EbookActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView =findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this,R.id.frame_layout);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(toggle.onOptionsItemSelected(item)){
            return  true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch ( item.getItemId()){
            case R.id.navigation_video:
               getUrl("https://www.youtube.com/@EngineeringFunda");
                break;
            case R.id.navigation_ebook:
               startActivity(new Intent(this, EbookActivity.class));
                break;

            case R.id.navigation_website:
                getUrl("https://amu.ac.in/colleges/zakir-husain-college-of-engineering-and-technology");
                break;

            case R.id.navigation_share:
                share();

                break;
            case R.id.navigation_developers:
                startActivity(new Intent(this, DevelopersActivity.class));
                break;



        }
        return true;
    }

    private void getUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    private void share() {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);

        // type of the content to be shared
        sharingIntent.setType("text/plain");

        // Body of the content
        String shareBody = "Your Body Here";

        // subject of the content. you can share anything
        String shareSubject = "Your Subject Here";

        // passing body of the content
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

        // passing subject of the content
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
        startActivity(Intent.createChooser(sharingIntent, "Share using"));
    }
}