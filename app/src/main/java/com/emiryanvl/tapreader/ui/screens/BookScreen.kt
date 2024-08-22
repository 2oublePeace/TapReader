package com.emiryanvl.tapreader.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.emiryanvl.tapreader.ui.viewModels.BookViewModel

@Composable
fun BookScreen(viewModel: BookViewModel = hiltViewModel()) {

    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = ColorPainter(Color.DarkGray),
                contentDescription = "Черный квадрат",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(300.dp)
                    .padding(8.dp),
            )
            Text(
                text = "viewModel.getText()",
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = """
                    Роман-эпопея «Война и мир» — произведение, поражающее эпическими масштабами повествования,
                    исторической достоверностью, искренностью изображения подлинных человеческих чувств и эмоций,
                    Наполеоновские войны, Россия на переломном этапе истории показаны во взаимосвязи с судьбами и личной
                    жизнью удаленных от нас по времени, но по-человечески близких и понятных нам людей. «Война и мир» —
                    это и исторический роман, и семейная хроника, и психологическая драма.
                """.trimIndent(),
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BookScreenPreview() {
    BookScreen()
}
