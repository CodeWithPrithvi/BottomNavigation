package com.prithviraj.bottomnavigation;

import static com.prithviraj.bottomnavigation.R.id.chats;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    Chats chats = new Chats();
    Calls calls = new Calls();
    Updates updates = new Updates();
    Community community = new Community();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bottomNavigationView = findViewById(R.id.navbar);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.chats);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.chats) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentHolder, chats).commit();
            return true;
        } else if (itemId == R.id.updates) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentHolder, updates).commit();
            return true;
        } else if (itemId == R.id.community) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentHolder, community).commit();
            return true;
        } else if (itemId == R.id.call) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentHolder, calls).commit();
            return true;
        }
        return false;

    }
}
