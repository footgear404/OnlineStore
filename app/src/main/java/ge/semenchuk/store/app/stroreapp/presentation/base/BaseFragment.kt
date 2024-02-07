package ge.semenchuk.store.app.stroreapp.presentation.base

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseFragment<B : ViewBinding> : Fragment() {

    private var _binding: B? = null
    protected val binding get() = _binding!!

    protected var fragmentTitle: CharSequence? = null

    protected abstract fun initBinding(inflater: LayoutInflater): B?
    protected abstract fun initUI()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = initBinding(inflater)
        fragmentTitle = findNavController().currentDestination?.label
        return binding.root
    }

    protected fun navigateTo(direction: NavDirections) {
        findNavController().navigate(direction)
    }

    protected fun navigateTo(id: Int) {
        findNavController().navigate(id)
    }

    protected fun Fragment.snackIt(@StringRes stringRes: Int) {
        Snackbar.make(binding.root, stringRes, Snackbar.LENGTH_SHORT).show()
    }
    protected fun Fragment.snackIt(message: String, view: View) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
    }

    protected fun Fragment.toast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }


    protected fun Fragment.getDrawable(drawable: Int): Drawable? {
        return AppCompatResources.getDrawable(
            requireContext(),
            drawable
        )
    }


    protected fun <I : Any?> flowObserver(flow: Flow<I>?, action: suspend (it: I) -> Unit) =
        viewLifecycleOwner.lifecycleScope.launch {
            flow?.collect {
                action(it)
            }
        }
}