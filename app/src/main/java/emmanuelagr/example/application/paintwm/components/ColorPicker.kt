package emmanuelagr.example.application.paint.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun ColorPicker(
    onColorChange: (Color) -> Unit
) {
    var r by remember { mutableStateOf(0f) }
    var g by remember { mutableStateOf(0f) }
    var b by remember { mutableStateOf(0f) }

    var colorRGB = Color(r.toInt(), g.toInt(), b.toInt())

    onColorChange(colorRGB)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // SHOW COLOR
        Surface(
            elevation = 25.dp,
            shape = RoundedCornerShape(10.dp),
            color = colorRGB,
            content = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .border(3.dp, MaterialTheme.colors.primary, shape = RoundedCornerShape(10.dp))
        )

        // RED
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Row(modifier = Modifier.weight(1f)) {
                Slider(
                    value = r,
                    onValueChange = { r = it },
                    enabled = true,
                    valueRange = 0f..255f,
                    steps = 255,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTickColor = Color(r.toInt(), 0, 0),
                        inactiveTickColor = Color.Gray,
                    ),
                )
            }

            Spacer(modifier = Modifier.padding(end = 10.dp))

            TextField(
                value = r.roundToInt().toString(),
                onValueChange = { r = it.toFloat() },
                label = { Text(text = "Red", color = MaterialTheme.colors.primary) },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedLabelColor = MaterialTheme.colors.primary,
                    textColor = MaterialTheme.colors.primary,
                ),
                enabled = false,
                modifier = Modifier.width(70.dp),
            )
        }

        // GREEN
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Row(modifier = Modifier.weight(1f)) {
                Slider(
                    value = g,
                    onValueChange = { g = it },
                    enabled = true,
                    valueRange = 0f..255f,
                    steps = 255,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Green,
                        activeTickColor = Color(0, g.toInt(), 0),
                        inactiveTickColor = Color.Gray,
                    ),
                )
            }

            Spacer(modifier = Modifier.padding(end = 10.dp))

            TextField(
                value = g.roundToInt().toString(),
                onValueChange = { g = it.toFloat() },
                label = { Text(text = "Green", color = MaterialTheme.colors.primary) },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedLabelColor = MaterialTheme.colors.primary,
                    textColor = MaterialTheme.colors.primary,
                ),
                enabled = false,
                modifier = Modifier.width(70.dp),
            )
        }

        // BLUE
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Row(modifier = Modifier.weight(1f)) {
                Slider(
                    value = b,
                    onValueChange = { b = it },
                    enabled = true,
                    valueRange = 0f..255f,
                    steps = 255,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Blue,
                        activeTickColor = Color(0, 0, b.toInt()),
                        inactiveTickColor = Color.Gray,
                    ),
                )
            }

            Spacer(modifier = Modifier.padding(end = 10.dp))

            TextField(
                value = b.roundToInt().toString(),
                onValueChange = { b = it.toFloat() },
                label = { Text(text = "Blue", color = MaterialTheme.colors.primary) },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedLabelColor = MaterialTheme.colors.primary,
                    textColor = MaterialTheme.colors.primary,
                ),
                enabled = false,
                modifier = Modifier.width(70.dp),
            )
        }
    }
}