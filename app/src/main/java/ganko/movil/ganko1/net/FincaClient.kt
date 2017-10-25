package ganko.movil.ganko1.net

import ganko.movil.ganko1.data.model.Finca
import ganko.movil.ganko1.data.model.FincaResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

/**
 * Created by jlbeltran94 on 19/10/17.
 */
interface FincaClient {

    @GET("finca/get-fincas/")
    fun getAllFincas(@Header("Authorization") token:String): Observable<ResponseData<List<Finca>>>

    @POST("finca/add-finca/")
    fun insertFinca(
            @Header("Authorization") token: String,
            @Body finca: Finca): Observable<ResponseData<FincaResponse>>

}