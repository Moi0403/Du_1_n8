package anhntph36936.fpoly.sanpham_du1.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import anhntph36936.fpoly.sanpham_du1.Fragment.Frag_home_du1;
import anhntph36936.fpoly.sanpham_du1.Fragment.Frag_phim_du1;
import anhntph36936.fpoly.sanpham_du1.Fragment.Frag_user_du1;
import anhntph36936.fpoly.sanpham_du1.Fragment.Frag_ve_du1;
import anhntph36936.fpoly.sanpham_du1.R;

public class Khachhang_du1 extends AppCompatActivity {
    DrawerLayout layout_khachhang;
    BottomNavigationView bottom_khachhang;
    Frag_home_du1 frag_home;
    Frag_phim_du1 frag_phim;
    Frag_ve_du1 frag_ve;
    Frag_user_du1 frag_user;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khachhang_du1);
        layout_khachhang = findViewById(R.id.layout_khachhang);
        bottom_khachhang = findViewById(R.id.bottom_khachhang);

        frag_home = new Frag_home_du1();
        frag_phim = new Frag_phim_du1();
        frag_ve = new Frag_ve_du1();
        frag_user = new Frag_user_du1();

        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.frag_khachhang, frag_home).commit();

        bottom_khachhang.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.home_bt){
                    fm.beginTransaction().replace(R.id.frag_khachhang, frag_home).commit();
                } else if (item.getItemId() == R.id.phim_bt) {
                    fm.beginTransaction().replace(R.id.frag_khachhang, frag_phim).commit();
                } else if (item.getItemId() == R.id.ve_bt) {
                    fm.beginTransaction().replace(R.id.frag_khachhang, frag_ve).commit();
                } else if (item.getItemId() == R.id.user_bt) {
                    fm.beginTransaction().replace(R.id.frag_khachhang, frag_user).commit();
                }
                return true;
            }
        });
    }
}