package xyz.cekingx.facerecog.Old

//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import kotlinx.android.synthetic.main.activity_detail.*
//import java.text.SimpleDateFormat
//
//class DetailActivityOld  : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail)
//
//        val data = intent.getParcelableExtra<UploadResponse>("data")
//
//        val statusKawin = if (data.status_perkawinan == "kawin") "Kawin" else "Belum Kawin"
//        val jenisKelamin = if (data.jenis_kelamin == "laki-laki") "Laki-laki" else "Perempuan"
//        val golDarah = data.gol_darah.toUpperCase()
//
//        val tanggal = SimpleDateFormat("yyyy-MM-dd").parse(data.tanggal_lahir);
//        val formatter = SimpleDateFormat("dd MMM yyyy")
//        val tanggalLahir = formatter.format(tanggal)
//
//        nama_value.text = data.nama
//        nik_value.text = data.nik
//        ttl_value.text = "${data.tempat_lahir}, ${tanggalLahir}"
//        jenis_kelamin_value.text = jenisKelamin
//        gol_darah_value.text = golDarah
//        agama_value.text = data.agama
//        status_perkawinan_value.text = statusKawin
//        pekerjaan_value.text = data.pekerjaan
//        kewarganegaraan_value.text = data.kewarganegaraan
//        alamat_value.text = data.alamat
//        confidence_value.text = data.confidence
//
//        mRecyclerView.setHasFixedSize(true)
//        mRecyclerView.layoutManager = LinearLayoutManager(this)
//
//        val list:ArrayList<Riwayat> = data.riwayat
//        val adapter = Adapter(list)
//        adapter.notifyDataSetChanged()
//
//        //tampilkan data dalam recycler view
//        mRecyclerView.adapter = adapter
//
//
//    }
//}