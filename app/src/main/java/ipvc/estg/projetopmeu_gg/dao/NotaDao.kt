package ipvc.estg.projetopmeu_gg.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ipvc.estg.projetopmeu_gg.entities.Nota


@Dao
interface NotaDao {

    @Query("SELECT * from nota_table ORDER BY id ASC")
    fun getAllNotas(): LiveData<List<Nota>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(nota: Nota)

    @Update
    suspend fun updateNota(nota: Nota)

    @Query("DELETE FROM nota_table")
    suspend fun deleteAll()

    @Query("DELETE FROM nota_table where id == :id")
    suspend fun deleteById(id: Int)

    @Query("UPDATE nota_table SET descricao=:descricao WHERE id == :id")
    suspend fun updateDescricao(id: Int, descricao: String)
}