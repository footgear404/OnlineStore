package ge.semenchuk.store.app.stroreapp.domain.utils.form_validation

import android.text.Editable
import android.text.TextWatcher
import android.util.Log

class InputPhoneFieldValidation(
    val changeStateLoginButton: () -> Unit
) : TextWatcher {

    var isValid: Boolean = false
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }
    override fun afterTextChanged(s: Editable?) {
        Log.d("TAG", "beforeTextChanged: ${s?.length}")
    }
}