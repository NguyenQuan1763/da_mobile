package com.example.da_mobile;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    TextView tvUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewCategory = findViewById(R.id.recyclerViewCategory);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategory.setLayoutManager(layoutManager);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        //toggle.setDrawerIndicatorEnabled(false); // Vô hiệu hóa icon mặc định
        toggle.syncState();

        // Đặt icon mong muốn
        //toolbar.setNavigationIcon(R.drawable.logo_menu); // Thay ic_custom_menu bằng icon của bạn


        // Xử lý sự kiện khi nhấn vào icon menu
        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

       // if (savedInstanceState == null) {
           // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
           // navigationView.setCheckedItem(R.id.nav_home);
       // }
        // Lấy header view từ NavigationView
        View headerView = navigationView.getHeaderView(0);
        tvUserName = headerView.findViewById(R.id.tvUserName);
        tvUserName.setText("Quân Nguyễn"); // Set tên người dùng thực tế

        ImageView btnBack = headerView.findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> drawerLayout.closeDrawer(GravityCompat.START));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    // giỏ hàng
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_cart_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_cart) {
            Toast.makeText(this, "Giỏ hàng được chọn", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}