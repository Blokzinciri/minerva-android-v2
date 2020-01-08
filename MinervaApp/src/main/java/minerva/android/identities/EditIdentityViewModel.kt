package minerva.android.identities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import minerva.android.kotlinUtils.event.Event
import minerva.android.kotlinUtils.viewmodel.BaseViewModel
import minerva.android.walletmanager.manager.WalletManager
import minerva.android.walletmanager.model.Identity

class EditIdentityViewModel(private val walletManager: WalletManager) : BaseViewModel() {

    private val _editIdentityLiveData = MutableLiveData<Event<Identity>>()
    val editIdentityLiveData: LiveData<Event<Identity>> get() = _editIdentityLiveData

    private val _saveCompletedLiveData = MutableLiveData<Event<Int>>()
    val saveCompletedLiveData: LiveData<Event<Int>> get() = _saveCompletedLiveData

    private val _saveErrorLiveData = MutableLiveData<Event<Throwable>>()
    val saveErrorLiveData: LiveData<Event<Throwable>> get() = _saveErrorLiveData

    fun loadIdentity(index: Int, defaultName: String) {
        _editIdentityLiveData.value = Event(walletManager.loadIdentity(index, defaultName))
    }

    fun saveIdentity(identity: Identity) {
        launchDisposable {
            walletManager.saveIdentity(identity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onComplete = { _saveCompletedLiveData.value = Event(identity.index) },
                    onError = { _saveErrorLiveData.value = Event(Throwable(it.message)) }
                )
        }
    }
}