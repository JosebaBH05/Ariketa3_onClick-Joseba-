package com.example.ariketa2zoriontzekotxartela

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ariketa2zoriontzekotxartela.ui.theme.Ariketa2ZoriontzekoTxartelaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ariketa2ZoriontzekoTxartelaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NotaAppEkintza(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun NotaAppEkintza(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize()) {
        ZorionakIrudia()
        NotaEdukia(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun NotaEdukia(modifier: Modifier = Modifier) {

    var nota by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Ikaslearen nota",
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )


        Text(
            text = nota.toString(),
            fontSize = 60.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        if(nota >= 10){
        } else {
            Button(
                onClick = {
                    nota++
                }
            ) {
                Text(text = "Nota Igo (+1)", fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun ZorionakIrudia(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidirudia)
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier.fillMaxSize(),
        contentScale = androidx.compose.ui.layout.ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun NotaAppPreview() {
    Ariketa2ZoriontzekoTxartelaTheme {
        NotaAppEkintza()
    }
}