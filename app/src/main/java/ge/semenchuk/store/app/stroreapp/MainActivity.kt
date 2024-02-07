package ge.semenchuk.store.app.stroreapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import ge.semenchuk.store.app.stroreapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val hideNavBarList: List<Int> = listOf(R.id.navigation_auth)

        binding.navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            Log.d("DESTINATION", destination.label.toString())
            binding.navView.visibility =
                if (destination.id in hideNavBarList) View.GONE else View.VISIBLE
        }
    }
}
