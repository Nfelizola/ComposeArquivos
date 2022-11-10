package envuvem.com.br.composearquivos

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import envuvem.com.br.composearquivos.ui.theme.ComposeArquivosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArquivosTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {

                    gravararquivo("felizola", "  *** JSON  ****  (Voorhees)  ")
                    Greeting(lerarquivo("felizola"))


                }
            }
        }
    }

    fun st(texto: String, tempo: Int) {
        Toast.makeText(this, texto, tempo)
    }

    fun lerarquivo(filename: String): String {
        val reader = openFileInput(filename).bufferedReader()
        var conteudo = reader.readLines()
        return conteudo.toString()
        }

    fun gravararquivo(filename: String, conteudo: String) {
            // funcão para gravar arquivo
            val arqdestino = openFileOutput(filename, Context.MODE_PRIVATE)
            arqdestino.use {
                it.write(conteudo.toByteArray())
                it.write(conteudo.toByteArray())
                it.write(conteudo.toByteArray())
                Toast.makeText(this,
                    "Gravei no arquivo $filename o Conteudo fornecido: $conteudo",
                    Toast.LENGTH_LONG).show()
            }
            arqdestino.close()
        }

    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeArquivosTheme {
            Greeting("Android")
        }
    }
