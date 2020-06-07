package br.com.baseapplication.ui.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.baseapplication.data.utils.RequestException
import br.com.baseapplication.utils.extensions.nullableCast
import br.com.baseapplication.utils.extensions.trigger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

abstract class BaseViewModel : ViewModel(), LifecycleObserver, KoinComponent {

    val loading: LiveData<Boolean> get() = baseLoading

    protected val baseLoading = MutableLiveData<Boolean>()

    private val uiScope = CoroutineScope(Dispatchers.Main + Job())

    /**
     * Creates a coroutine request using launch build
     *
     * @param errorHandler a function that receives a [RequestException] with the
     * request error as argument
     * @param loadingLiveData a live data to trigger loading state
     * @param block a suspended function to executes in coroutine scope
     *
     * @return a coroutine job to be cancelled if needed
     */
    // TODO: check internet connection before request
    protected fun launch(
        errorHandler: ((RequestException) -> Unit)? = null,
        loadingLiveData: MutableLiveData<Boolean>? = null,
        block: suspend CoroutineScope.() -> Unit
    ) = uiScope.launch {
        try {
            loadingLiveData?.trigger()
            block()
        } catch (e: Exception) {
            e.nullableCast<RequestException>()?.let { errorHandler?.invoke(it) }
        } finally {
            loadingLiveData?.value = false
        }
    }
}
