package emmanuelagr.example.application.paint.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Brush
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val colorPalette: List<Color> = listOf(
    Color.Black,
    Color.Gray,
    Color.Red,
    Color.Blue,
    Color.Yellow
)

@Composable
fun ColorPalette(
    paintColor: MutableState<Color>
) {

    LazyRow(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceEvenly,
        content = {
            items(colorPalette.size) {
                IButton(
                    icon = Icons.Rounded.Brush,
                    background = colorPalette[it],
                    description = "Color item",
                    event = { paintColor.value = colorPalette[it] }
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    )
}