package ge.semenchuk.store.app.stroreapp.presentation.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.vicmikhailau.maskededittext.doAfterMaskedTextChanged
import ge.semenchuk.store.app.stroreapp.databinding.FragmentAuthBinding
import ge.semenchuk.store.app.stroreapp.domain.utils.Constants
import ge.semenchuk.store.app.stroreapp.domain.utils.form_validation.InputNameFieldValidation
import ge.semenchuk.store.app.stroreapp.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment : BaseFragment<FragmentAuthBinding>() {

    private val authViewModel by viewModel<AuthFragmentViewModel>()
    private var inputNameFieldValidation: InputNameFieldValidation? = null
    private var inputSNameFieldValidation: InputNameFieldValidation? = null
    private var inputPhoneFieldValidation: Boolean = false

    override fun initBinding(inflater: LayoutInflater): FragmentAuthBinding =
        FragmentAuthBinding.inflate(inflater)

    override fun initUI() {
        with(binding) {
            actionBar.toolBar.title = fragmentTitle

            phoneInput.setMask(Constants.Auth.PHONE_MASK)

            inputNameFieldValidation =
                InputNameFieldValidation(nameInputLayout, ::changeStateLoginButton)
            inputSNameFieldValidation =
                InputNameFieldValidation(sNameInputLayout, ::changeStateLoginButton)

            nameInput.addTextChangedListener(inputNameFieldValidation)
            sNameInput.addTextChangedListener(inputSNameFieldValidation)
            phoneInput.doAfterMaskedTextChanged {
                inputPhoneFieldValidation =
                    phoneInput.unMaskedText?.length == Constants.Auth.PHONE_NUM_LEN
                changeStateLoginButton()
            }

            login.setOnClickListener {
                authViewModel.registerUser(
                    name = binding.nameInput.text.toString(),
                    sName = binding.sNameInput.text.toString(),
                    phone = binding.phoneInput.text.toString()
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

        flowObserver(authViewModel.isAuthorized) { isAuthorised ->
            when (isAuthorised) {
                true -> navigateTo(HOME)
                false -> Unit
            }
        }
    }

    private fun changeStateLoginButton() {
        binding.login.isEnabled =
            inputNameFieldValidation?.isValid ?: false && inputSNameFieldValidation?.isValid ?: false
                    && inputPhoneFieldValidation
    }

    companion object {
        private val HOME = AuthFragmentDirections.actionNavigationAuthToHomeFragment()
    }
}