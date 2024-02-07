package ge.semenchuk.store.app.stroreapp.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import ge.semenchuk.store.app.stroreapp.databinding.FragmentHomeBinding
import ge.semenchuk.store.app.stroreapp.presentation.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun initBinding(inflater: LayoutInflater): FragmentHomeBinding =
        FragmentHomeBinding.inflate(inflater)

    override fun initUI() {
        with(binding) {
            actionBar.toolBar.title = fragmentTitle
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }
}