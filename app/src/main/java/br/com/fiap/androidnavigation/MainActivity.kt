package br.com.fiap.androidnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.androidnavigation.ui.theme.AndroidNavigationTheme
import android.util.Log
import android.widget.Toast
import android.content.Intent
import br.com.fiap.androidnavigation.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding : ActivityMainBinding
    private val MAIN_ACTIVITY_TAG = getString(R.string.title_activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        
        Log.i(MAIN_ACTIVITY_TAG, "App started")

        binding.btnDiveIn.setOnClickListener{
            Log.i(MAIN_ACTIVITY_TAG, "Button clicked. Diving in...")
            Toast.makeText(this, "Diving in...", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(MAIN_ACTIVITY_TAG, "App started")
    }

    override fun onRestart(){
        super.onRestart()
        Log.i(MAIN_ACTIVITY_TAG, "App restarted")
    }

    override fun onPause(){
        super.onPause()
        Log.i(MAIN_ACTIVITY_TAG, "App paused")
    }

    override fun onResume(){
        super.onResume()
        Log.i(MAIN_ACTIVITY_TAG, "App resumed")
    }

    override fun onStop(){
        super.onStop()
        Log.i(MAIN_ACTIVITY_TAG, "App stopped")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i(MAIN_ACTIVITY_TAG, "App destroyed")
    }
}