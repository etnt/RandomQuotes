package se.kruskakli.quotes2


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import se.kruskakli.quotes2.ui.theme.Quotes2Theme

@Composable
fun QuoteScreen(
    quote: MutableState<String>,
    author: MutableState<String>,
    onAction: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color.Black)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = quote.value,
            modifier = modifier
                .fillMaxWidth()
                .padding(32.dp),
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            color = Color.White
        )
        Box(modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
        ){
            Text(
                text = author.value,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp),
                textAlign = TextAlign.Right,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Italic,
                ),
                color = Color.Red
            )
        }
        Button(
            modifier = modifier
                .background(Color.Black),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.Green
            ),
            onClick = { onAction() }
        ) {
            Text(
                text = "Get New Quote",
                modifier = modifier
                    .padding(top = 32.dp),
                fontSize = 20.sp
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun QuoteScreenPreview() {
    Quotes2Theme {
        val quote = mutableStateOf("Tomma tunnor skramlar mest.")
        val author = mutableStateOf("Anononym.")

        QuoteScreen(quote, author)
    }
}
