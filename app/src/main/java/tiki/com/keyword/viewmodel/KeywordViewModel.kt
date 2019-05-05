package tiki.com.keyword.viewmodel

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import tiki.com.keyword.model.KeywordModel
import tiki.com.keyword.service.ApiBuilder

class KeywordViewModel: BaseViewModel() {

    private val disposables = CompositeDisposable()

    fun loadKeyword() {
        disposables.add(ApiBuilder.create().getKeyword()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showLoading(true) }
                .doFinally { showLoading(false) }
                .subscribe({listResponse ->

                    val list = ArrayList<KeywordModel>()
                    for (title in listResponse) {
                        list.add(KeywordModel(title))
                    }

                    showSuccessful(list)

                }, {
                    showFailure(it)
                }))
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared ()
    }
}
