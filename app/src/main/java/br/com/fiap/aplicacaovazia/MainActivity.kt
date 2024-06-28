package br.com.fiap.aplicacaovazia

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
import br.com.fiap.aplicacaovazia.ui.theme.AplicacaoVaziaTheme
import android.util.Log
import android.widget.Toast
import android.content.Intent
import br.com.fiap.aplicacaovazia.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var MAIN_ACTIVITY_TAG : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MAIN_ACTIVITY_TAG = getString(R.string.title_activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        
        Log.i(MAIN_ACTIVITY_TAG, "Activity created")

        binding.btnAddTask.setOnClickListener {
            Log.i(MAIN_ACTIVITY_TAG, "Moving to AddTaskActivity")
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }
        binding.btnAddUser.setOnClickListener {
            Log.i(MAIN_ACTIVITY_TAG, "Moving to AddUserActivity")
            val intent = Intent(this, AddUserActivity::class.java)
            startActivity(intent)
        }
        binding.btnConsultUser.setOnClickListener {
            Log.i(MAIN_ACTIVITY_TAG, "Moving to ConsultUserActivity")
            val intent = Intent(this, ConsultUserActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(MAIN_ACTIVITY_TAG, "Activity started")
    }

    override fun onRestart(){
        super.onRestart()
        Log.i(MAIN_ACTIVITY_TAG, "Activity restarted")
    }

    override fun onPause(){
        super.onPause()
        Log.i(MAIN_ACTIVITY_TAG, "Activity paused")
    }

    override fun onResume(){
        super.onResume()
        Log.i(MAIN_ACTIVITY_TAG, "Activity resumed")
    }

    override fun onStop(){
        super.onStop()
        Log.i(MAIN_ACTIVITY_TAG, "Activity stopped")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i(MAIN_ACTIVITY_TAG, "Activity destroyed")
    }
}
