package br.com.baseapplication.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    /**
     * Implement a ViewModel to handle unit logic and trigger LiveData
     */
    abstract val viewModel: BaseViewModel

    /**
     * Implement this method to inflate layout and set data binding
     */
    abstract fun onCreate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
        onCreate()
        setupScreen()
        subscribeUi()
    }

    /**
     * Implement this method to do initial views setup
     */
    abstract fun setupScreen()

    /**
     * Implement this method with LifecycleOwner bind extension to respond to LiveData values
     */
    abstract fun subscribeUi()

    override fun onDestroy() {
        lifecycle.removeObserver(viewModel)
        super.onDestroy()
    }
}