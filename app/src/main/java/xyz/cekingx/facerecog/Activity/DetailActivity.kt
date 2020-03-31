package xyz.cekingx.facerecog.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.cekingx.facerecog.R
import xyz.cekingx.facerecog.fragment.DetailFragment
import xyz.cekingx.facerecog.fragment.RiwayatFragment

class DetailActivity : AppCompatActivity() {

    lateinit var detailFragment: DetailFragment
    lateinit var riwayatFragment: RiwayatFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

//        val bottomNavigation : BottomNavigationView = findViewById(R.id.btm_nav)
//
//        val data = intent.getParcelableExtra<UploadResponse>("data")
//        val image_uri = intent.getParcelableExtra<Uri?>("image_uri")
//
//        detailFragment = DetailFragment.detailData(data)
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.frame_layout, detailFragment)
//            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//            .commit()
//
//        bottomNavigation.setOnNavigationItemSelectedListener { item ->
//            when(item.itemId) {
//                R.id.detail_icon -> {
//                    detailFragment = DetailFragment.detailData(data)
//                    supportFragmentManager
//                        .beginTransaction()
//                        .replace(R.id.frame_layout, detailFragment)
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                        .commit()
//                }
//                R.id.riwayat_icon -> {
//                    riwayatFragment = RiwayatFragment()
//                    supportFragmentManager
//                        .beginTransaction()
//                        .replace(R.id.frame_layout, riwayatFragment)
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                        .commit()
//                }
//            }
//
//            true
//        }
//
//        nama_value.text = data.nama
//        nik_value.text = data.nik
//        confidence_value.text = data.confidence
//        foto.setImageURI(image_uri)
    }
}
