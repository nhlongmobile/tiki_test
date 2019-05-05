package tiki.com.keyword.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import tiki.com.keyword.model.KeywordModel

open class BaseViewModel : ViewModel() {
    val eventLoading = MutableLiveData<Boolean>()
    val eventFailure = MutableLiveData<Throwable>()
    val eventSuccess = MutableLiveData<List<KeywordModel>>()

    fun showLoading(value: Boolean) {
        eventLoading.value = value
    }

    fun showFailure(throwable: Throwable) {
        eventFailure.value = throwable
    }

    fun showSuccessful(list: ArrayList<KeywordModel>) {
        eventSuccess.value = list

    }
}
