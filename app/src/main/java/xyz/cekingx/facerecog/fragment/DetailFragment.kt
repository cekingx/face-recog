package xyz.cekingx.facerecog.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.w3c.dom.Text
import xyz.cekingx.facerecog.R
import xyz.cekingx.facerecog.Entity.UploadResponse
import java.text.SimpleDateFormat

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    lateinit var data: UploadResponse

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)
        if (arguments != null) {
            data = arguments!!.getParcelable("data")!!

            val ttlValue: TextView = rootView.findViewById(R.id.ttl_value) as TextView
            val jenisKelaminValue: TextView = rootView.findViewById(R.id.jenis_kelamin_value) as TextView
            val golDarahValue: TextView = rootView.findViewById(R.id.gol_darah_value) as TextView
            val agamaValue: TextView = rootView.findViewById(R.id.agama_value) as TextView
            val statusPerkawinanValue: TextView = rootView.findViewById(R.id.status_perkawinan_value) as TextView
            val pekerjaanValue: TextView = rootView.findViewById(R.id.pekerjaan_value) as TextView
            val kewarganegaraanValue: TextView = rootView.findViewById(R.id.kewarganegaraan_value) as TextView
            val kabupatenValue: TextView = rootView.findViewById(R.id.kabupaten_value) as TextView
            val kecamatanValue: TextView = rootView.findViewById(R.id.kecamatan_value) as TextView
            val desaValue: TextView = rootView.findViewById(R.id.desa_value) as TextView
            val alamatValue: TextView = rootView.findViewById(R.id.alamat_value) as TextView

            val statusKawin = if (data.status_perkawinan == "kawin") "Kawin" else "Belum Kawin"
            val jenisKelamin = if (data.jenis_kelamin == "laki-laki") "Laki-laki" else "Perempuan"
            val golDarah = data.gol_darah.toUpperCase()

            val tanggal = SimpleDateFormat("yyyy-MM-dd").parse(data.tanggal_lahir);
            val formatter = SimpleDateFormat("dd MMM yyyy")
            val tanggalLahir = formatter.format(tanggal)

            ttlValue.text = "${data.tempat_lahir}, ${tanggalLahir}"
            jenisKelaminValue.text = jenisKelamin
            golDarahValue.text = golDarah
            agamaValue.text = data.agama
            statusPerkawinanValue.text = statusKawin
            pekerjaanValue.text = data.pekerjaan
            kewarganegaraanValue.text = data.kewarganegaraan
            kabupatenValue.text = data.kabupaten
            kecamatanValue.text = data.kecamatan
            desaValue.text = data.desa
            alamatValue.text = data.alamat
        }

        return rootView
    }


    companion object {
        const val ARG_NAME = "data"


        fun detailData(data: UploadResponse): DetailFragment {
            val fragment = DetailFragment()

            val bundle = Bundle().apply {
                putParcelable(ARG_NAME, data)
            }

            fragment.arguments = bundle

            return fragment
        }
    }

}
