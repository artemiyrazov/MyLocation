package com.example.mylocation;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.Menu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private int id;
    private Fragment fragment = null;
    private Class fragmentClass = null;
    private String name;
    private String messages;
    private ArrayList<String> contacts = new ArrayList<String>();
    private ArrayList<Image> photos = new ArrayList<Image>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        id = R.id.nav_deviceinfo;
        fragmentClass = DeviceInfoFragment.class;
        tryInstance();
        Intent intent = new Intent(this, DeviceInfoActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        id = item.getItemId();

        if (id == R.id.nav_deviceinfo) {
            fragmentClass = DeviceInfoFragment.class;
            tryInstance();

            Intent intent = new Intent(this, DeviceInfoActivity.class);
            startActivityForResult(intent, 1);

        } else if (id == R.id.nav_messages) {
            fragmentClass = MessagesFragment.class;
            tryInstance();
            Intent intent = new Intent(this, MessagesActivity.class);
            startActivityForResult(intent, 1);

        } else if (id == R.id.nav_photos) {
            fragmentClass = PhotosFragment.class;
            tryInstance();
            Intent intent = new Intent(this, PhotosActivity.class);
            startActivityForResult(intent, 1);


        } else if (id == R.id.nav_contacts) {
            fragmentClass = ContactsFragment.class;
            tryInstance();
            Intent intent = new Intent(this, ContactsActivity.class);
            startActivityForResult(intent, 1);
        }

        item.setChecked(true);
        setTitle(item.getTitle());



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (id == R.id.nav_deviceinfo) {
            name = data.getStringExtra("info");
            Bundle bundle = new Bundle();
            bundle.putString("info", name);
            fragment.setArguments(bundle);

        } else if (id == R.id.nav_messages) {
            messages = data.getStringExtra("messages");
            Bundle bundle = new Bundle();
            bundle.putString("messages", messages);
            fragment.setArguments(bundle);

        } else if (id == R.id.nav_photos) {
            photos = data.getParcelableArrayListExtra("photos");
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("photos", photos);
            fragment.setArguments(bundle);

        } else if (id == R.id.nav_contacts) {
            contacts = data.getStringArrayListExtra("contacts");
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("contacts", contacts);
            fragment.setArguments(bundle);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    protected void tryInstance() {
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            Log.e("MyLocation", "Exception with try to make instance.", e);
        }
    }
}
