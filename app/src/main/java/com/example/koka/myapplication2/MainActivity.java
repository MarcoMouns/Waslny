package com.example.koka.myapplication2;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.koka.myapplication2.Fragments.AboutFragment;
import com.example.koka.myapplication2.Fragments.ContactsFragment;
import com.example.koka.myapplication2.Fragments.HomeFragment;
import com.example.koka.myapplication2.Fragments.SettingFragment;
import com.example.koka.myapplication2.Helper.LocaleHelper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    HomeFragment homeFragment = new HomeFragment();
    AboutFragment aboutFragment = new AboutFragment();
    ContactsFragment contactsFragment = new ContactsFragment();
    SettingFragment settingFragment = new SettingFragment();
    boolean test_fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        showFragment(homeFragment);


        test_fab = true;
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (test_fab == true) {
                    showFragment(aboutFragment);
                    fab.setImageResource(R.drawable.home);
                    Snackbar.make(view, getResources().getString(R.string.fababout), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    test_fab = false;
                } else {
                    showFragment(homeFragment);
                    fab.setImageResource(R.drawable.about);
                    Snackbar.make(view, getResources().getString(R.string.fabhome), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    test_fab = true;
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        final FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab);

        if (id == R.id.nav_home) {
            showFragment(homeFragment);
            test_fab=true;
            fab2.setImageResource(R.drawable.about);

        } else if (id == R.id.nav_setting) {
            showFragment(settingFragment);
        } else if (id == R.id.nav_about) {
            test_fab=false;
            showFragment(aboutFragment);
            fab2.setImageResource(R.drawable.home);
        } else if (id == R.id.nav_contact) {
            showFragment(contactsFragment);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.commit();
    }
}
