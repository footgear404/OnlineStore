package ge.semenchuk.store.app.stroreapp.domain.utils.form_validation

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.google.android.material.textfield.TextInputLayout
import ge.semenchuk.store.app.stroreapp.R
import java.util.regex.Pattern

class InputNameFieldValidation(
    private val binding: TextInputLayout,
    val changeStateLoginButton: () -> Unit
) : TextWatcher {

    var isValid: Boolean = false
    private val pattern = Pattern.compile("\\p{InCyrillic}+")

    override fun afterTextChanged(s: Editable?) {
        if (s.isNullOrEmpty() || !pattern.matcher(s.toString()).matches()) {
            Log.d("TAG", "s not matches: $s")
            showError()
        } else {
            Log.d("TAG", "s is valid: $s")
            hideError()
        }
    }

    private fun hideError() {
        isValid = true
        updateErrorState(false)
    }

    private fun showError() {
        isValid = false
        updateErrorState(true)
    }

    private fun updateErrorState(isError: Boolean) {
        binding.apply {
            isErrorEnabled = isError
            boxStrokeWidthFocused = if (isError) 5 else 0
            error = if (isError) context.getString(R.string.enter_a_cyrillic_only_symbols) else null
        }
        changeStateLoginButton()
    }

    override fun beforeTextChanged(
        s: CharSequence?, start: Int, count: Int, after: Int
    ) = Unit

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit
}