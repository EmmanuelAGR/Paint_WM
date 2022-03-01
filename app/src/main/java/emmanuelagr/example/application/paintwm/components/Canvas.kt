package emmanuelagr.example.application.paint.components

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import emmanuelagr.example.application.paint.models.Painting

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Canvas(
    paintColor: MutableState<Color>,
    paintStroke: MutableState<Stroke>,
    paths: MutableList<Painting>
) {
    var coordinates2D by remember { mutableStateOf<Offset?>(null) }
    val currentPath = paths.last().path

    Canvas(modifier = Modifier
        .fillMaxSize()
        .pointerInteropFilter {
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    coordinates2D = Offset(it.x, it.y)
                    currentPath.moveTo(it.x, it.y)
                }
                MotionEvent.ACTION_MOVE -> {
                    coordinates2D = Offset(it.x, it.y)
                }
                else -> {
                    coordinates2D = null
                }
            }
            true
        }
    ) {
        coordinates2D?.let {
            currentPath.lineTo(it.x, it.y)
            drawPath(
                path = currentPath,
                color = paintColor.value,
                style = paintStroke.value
            )
        }
        paths.forEach {
            drawPath(
                path = it.path,
                color = it.color,
                style = it.stroke
            )
        }
    }
}