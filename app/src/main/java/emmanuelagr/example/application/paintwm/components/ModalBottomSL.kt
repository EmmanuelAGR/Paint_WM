package emmanuelagr.example.application.paint.components

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LineWeight
import androidx.compose.material.icons.rounded.Brush
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ModalBottomSL(
    paintColor: MutableState<Color>,
    paintStroke: MutableState<Stroke>
) {
    var visibility by remember { mutableStateOf(mutableListOf(true, false)) }

    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = Modifier
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AnimatedVisibility(
                visible = visibility[0],
                enter = expandVertically(
                    expandFrom = Alignment.Top,
                    animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
                ),
                exit = shrinkVertically(
                    shrinkTowards = Alignment.Top,
                    animationSpec = tween(durationMillis = 400, easing = LinearOutSlowInEasing)
                )
            ) {
                ColorPicker(onColorChange = { paintColor.value = it })
            }

            AnimatedVisibility(
                visible = visibility[1],
                enter = expandHorizontally(
                    animationSpec = tween(durationMillis = 800, easing = LinearOutSlowInEasing)
                )
            ) {
                LineStrokes(onChangeStroke = { paintStroke.value = it })
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                IButton(
                    icon = Icons.Rounded.Brush,
                    background = Color.Black,
                    description = "Color items",
                    event = {
                        visibility = listOf(true, false).toMutableList()
                    }
                )

                IButton(
                    icon = Icons.Filled.LineWeight,
                    background = Color.Black,
                    description = "Select stroke",
                    event = {
                        visibility = listOf(false, true).toMutableList()
                    }
                )
            }
        }
    }
}
