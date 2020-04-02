package xyz.cekingx.facerecog.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_riwayat.*
import xyz.cekingx.facerecog.Adapter
import xyz.cekingx.facerecog.Entity.UploadResponse

import xyz.cekingx.facerecog.R

/**
 * A simple [Fragment] subclass.
 */
class RiwayatFragment : Fragment() {

    lateinit var data: UploadResponse

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_riwayat, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            data = arguments!!.getParcelable("data")!!
            list_recycler_view.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = Adapter(data.riwayat)
            }
        }
    }

    companion object {
        const val ARG_NAME = "data"


        fun riwayatData(data: UploadResponse): RiwayatFragment {
            val fragment = RiwayatFragment()

            val bundle = Bundle().apply {
                putParcelable(ARG_NAME, data)
            }

            fragment.arguments = bundle

            return fragment
        }
    }

}
