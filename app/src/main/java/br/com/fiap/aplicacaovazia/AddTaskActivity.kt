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
import br.com.fiap.aplicacaovazia.databinding.ActivityAddTaskBinding

class AddTaskActivity : ComponentActivity() {

    private lateinit var binding : ActivityAddTaskBinding
    private lateinit var ACTIVITY_TAG : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ACTIVITY_TAG = getString(R.string.title_activity_add_task)

        binding = ActivityAddTaskBinding.inflate(layoutInflater)

        setContentView(binding.root)
        
        Log.i(ACTIVITY_TAG, "App created")


        binding.btnBack.setOnClickListener {
            Log.i(ACTIVITY_TAG, "Moving back to MainActivity")
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(ACTIVITY_TAG, "App started")
    }

    override fun onRestart(){
        super.onRestart()
        Log.i(ACTIVITY_TAG, "App restarted")
    }

    override fun onPause(){
        super.onPause()
        Log.i(ACTIVITY_TAG, "App paused")
    }

    override fun onResume(){
        super.onResume()
        Log.i(ACTIVITY_TAG, "App resumed")
    }

    override fun onStop(){
        super.onStop()
        Log.i(ACTIVITY_TAG, "App stopped")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i(ACTIVITY_TAG, "App destroyed")
    }
}
