package emmanuelagr.example.application.paint.models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke

data class Painting(
    val path: Path,
    val color: Color = Color.Black,
    val stroke: Stroke
)