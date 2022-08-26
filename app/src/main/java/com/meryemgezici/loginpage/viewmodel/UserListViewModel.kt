package com.meryemgezici.loginpage.viewmodel

/*import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.meryemgezici.loginpage.model.User
import com.meryemgezici.loginpage.service.UserAPIService
import com.meryemgezici.loginpage.service.UserDatabase
import com.meryemgezici.loginpage.util.TimeSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class UserListViewModel(application: Application) : BaseViewModel(application) {
    val users = MutableLiveData<List<User>>()
    val userErrorMessage = MutableLiveData<Boolean>()
    val userLoading = MutableLiveData<Boolean>()
    //private var guncellemeZamani = 0.2 * 60 * 1000 * 1000 * 1000L

    private val userApiService = UserAPIService()
    private val disposable = CompositeDisposable()
    private val timeSharedPreferences = TimeSharedPreferences(getApplication())

    fun refreshFromSqlite() {
        /*val kaydedilmeZamani = timeSharedPreferences.getTime()
        if (kaydedilmeZamani != null && kaydedilmeZamani != 0L && System.nanoTime() - kaydedilmeZamani < guncellemeZamani) {
            //Sqlite'tan çek
            getSQLite()
        } else {
            getDataFromInternet()
        }*/
        getSQLite()
    }

    fun refreshFromInternet() {
        getDataFromInternet()
    }

    private fun getSQLite() {
        userLoading.value = true

        launch {

            val usersList = UserDatabase(getApplication()).userDao().getAllUser()
            showUsers(usersList)
            Toast.makeText(getApplication(), "Çalışanları Room'dan Aldık", Toast.LENGTH_LONG).show()

        }

    }

    private fun getDataFromInternet() {
        disposable.add(
            userApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<User>>() {
                    override fun onSuccess(t: List<User>) {
                        saveSqlite(t)
                        Toast.makeText(
                            getApplication(),
                            "Çalışanları Internet'ten Aldık",
                            Toast.LENGTH_LONG
                        ).show()

                        //showUsers(t)
                    }

                    override fun onError(e: Throwable) {
                        userLoading.value = false
                        userErrorMessage.value = true
                        e.printStackTrace()
                    }

                })
        )
    }

    private fun showUsers(usersList: List<User>) {
        users.value = usersList
        userLoading.value = false
        userErrorMessage.value = false
    }

    private fun saveSqlite(usersList: List<User>) {
        launch {
            val dao = UserDatabase(getApplication()).userDao()
            dao.deleteAllUser()
            val idList = dao.insertAll(*usersList.toTypedArray())

            var i = 0
            while (i < usersList.size) {
                usersList[i].uuid = idList[i].toInt()
                i += 1
            }
            showUsers(usersList)
        }

        timeSharedPreferences.saveTime(System.nanoTime())
    }
}*/

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.meryemgezici.loginpage.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    repository: UserRepository
) : ViewModel() {

    val users = repository.getUsers().asLiveData()
}




