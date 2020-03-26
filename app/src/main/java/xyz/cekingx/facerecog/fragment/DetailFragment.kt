package xyz.cekingx.facerecog.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.cekingx.facerecog.R
import xyz.cekingx.facerecog.UploadResponse

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    companion object {
        const val ARG_NAME = "data"


        fun newInstance(data: UploadResponse): DetailFragment {
            val fragment = DetailFragment()

            val bundle = Bundle().apply {
                putParcelable(ARG_NAME, data)
            }

            fragment.arguments = bundle

            return fragment
        }
    }

}
