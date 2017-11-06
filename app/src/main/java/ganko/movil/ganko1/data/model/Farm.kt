package ganko.movil.ganko1.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

/**
 * Created by jlbel on 11/10/2017.
 */
@Entity
data class Farm(@PrimaryKey(autoGenerate = true) var localId:Long? = 0,
                 var id: Long?,
                 var nombre:String,
                 var ubicacion:String,
                 var hectareas:Long,
                 var sync: Boolean?
            ){
    @Ignore
    constructor(nombre: String, ubicacion: String, hectareas: Long): this(null,null, nombre, ubicacion, hectareas, null)
}