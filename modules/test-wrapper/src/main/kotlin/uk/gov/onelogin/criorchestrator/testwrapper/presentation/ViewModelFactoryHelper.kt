package uk.gov.onelogin.criorchestrator.testwrapper.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

fun <VM: ViewModel> viewModelFactory (initializer: () -> VM): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return initializer() as T
        }
    }
}