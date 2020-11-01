package ipvc.estg.projetopmeu_gg.db

import androidx.lifecycle.LiveData
import ipvc.estg.projetopmeu_gg.dao.NotaDao
import ipvc.estg.projetopmeu_gg.entities.Nota


// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class NotaRepository(private val notaDao: NotaDao) {

    val allNotas: LiveData<List<Nota>> = notaDao.getAllNotas()

    suspend fun insert(nota: Nota) {
        notaDao.insert(nota)
    }

    suspend fun deleteAll(){
        notaDao.deleteAll()
    }

    suspend fun deleteById(id: Int){
        notaDao.deleteById(id)
    }

    suspend fun updateNota(nota: Nota) {
        notaDao.updateNota(nota)
    }

    suspend fun updateDescricao(id: Int, descricao: String){
        notaDao.updateDescricao(id, descricao)
    }
}