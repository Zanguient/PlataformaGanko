package ganko.movil.ganko1.ui.detail.vaccination


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ganko.movil.ganko1.R


/**
 * A simple [Fragment] subclass.
 */
class VaccinationBovineFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_vaccination_bovine, container, false)
    }

    companion object {
        val EXTRA_ID = "id"
        fun instance(idBovine: Int): VaccinationBovineFragment{
            val fragment = VaccinationBovineFragment()
            val args = Bundle()
            args.putInt(EXTRA_ID, idBovine)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
