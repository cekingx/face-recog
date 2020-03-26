package xyz.cekingx.facerecog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_detail.*
import xyz.cekingx.facerecog.fragment.DetailFragment
import xyz.cekingx.facerecog.fragment.RiwayatFragment
import java.text.SimpleDateFormat

class DetailActivity : AppCompatActivity() {

    lateinit var detailFragment: DetailFragment
    lateinit var riwayatFragment: RiwayatFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bottomNavigation : BottomNavigationView = findViewById(R.id.btm_nav)

        detailFragment = DetailFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, detailFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.detail_icon -> {
                    detailFragment = DetailFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, detailFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.riwayat_icon -> {
                    riwayatFragment = RiwayatFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, riwayatFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }

            true
        }

    }
}
