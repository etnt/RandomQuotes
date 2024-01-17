package se.kruskakli.quotes2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import se.kruskakli.quotes2.ui.theme.Quotes2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val TAG = "MainActivity"

            val quote = mutableStateOf("Tomma tunnor skramlar mest.")
            val author = mutableStateOf("Anononym.")

            Quotes2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuoteScreen(
                        quote,
                        author,
                        onAction = fun() {
                            GlobalScope.launch(Dispatchers.IO) {
                                val response = RetrofitInstance.api.getRandomQuote()
                                if (response.isSuccessful) {
                                    withContext(Dispatchers.Main) {
                                        response.body()?.let {
                                            //Log.d(TAG, "onCreate: ${it[0].q}")
                                            quote.value = it[0].q
                                            author.value = it[0].a
                                        }
                                    }
                                }
                            }
                        }
                    )
                }
            }




        }
    }
}



