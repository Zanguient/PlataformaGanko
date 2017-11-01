package ganko.movil.ganko1.ui.farm.add

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding2.view.clicks

import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Farm
import ganko.movil.ganko1.databinding.ActivityAddFarmBinding
import ganko.movil.ganko1.di.Injectable
import ganko.movil.ganko1.utils.buildViewModel
import ganko.movil.ganko1.utils.subscribeByShot
import ganko.movil.ganko1.utils.text
import ganko.movil.ganko1.utils.validateForm
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_add_farm.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class AddFarmActivity : AppCompatActivity(), Injectable {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    val addFarmViewModel: AddFarmViewModel by lazy { buildViewModel(factory, AddFarmViewModel::class) }

    lateinit var binding: ActivityAddFarmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_farm)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Agregar finca"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun onResume() {
        super.onResume()
        fabAddFarm.clicks()
                .flatMap { validateForm(R.string.empty_fields, farm_name.text(), farm_location.text(), farm_size.text()) }
//                .flatMap { addFarmViewModel.insertRemoteFarm(Farm(it[0],it[1],it[2].toLong())) }
//                .subscribeByShot(
//                        onNext = {
//                            finish()
//                        },
//                        onHttpError = this::toast,
//                        onError = {toast(it.message!!)}
//                )
                .flatMap { addFarmViewModel.insertLocalFarm(Farm(it[0],it[1],it[2].toLong())) }
                .subscribeBy(
                        onNext = {
                            finish()
                        }
                )
    }

}
