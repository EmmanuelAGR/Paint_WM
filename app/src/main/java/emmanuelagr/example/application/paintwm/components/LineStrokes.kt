package emmanuelagr.example.application.paint.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

data class Select(
    val stroke: Float,
    var isSelected: Boolean

)

@Composable
fun LineStrokes(
    onChangeStroke: (Stroke) -> Unit
) {
    var lineStrokes by remember {
        mutableStateOf(
            (15..60 step 5).map {
                Select(
                    stroke = it.toFloat(),
                    isSelected = it == 15
                )
            }
        )
    }

    LazyRow(
        content = {
            items(
                lineStrokes.size,
                itemContent = { item ->
                    ButtonGroup(
                        description = "Stroke LvL: ${lineStrokes[item].stroke}",
                        borderStroke = lineStrokes[item].stroke.toInt() / 5,
                        event = {
                            lineStrokes = lineStrokes.mapIndexed { i, lineStroke ->
                                if (item == i && lineStrokes.count { it.isSelected == false } == lineStrokes.count()) {

                                    onChangeStroke(Stroke(lineStroke.stroke))
                                    lineStroke.copy(isSelected = !lineStroke.isSelected)
                                } else {
                                    lineStrokes.map {
                                        if (it.isSelected == true) {
                                            it.isSelected = !it.isSelected
                                        }
                                    }
                                    lineStroke
                                }
                            }
                        },
                        isSelected = lineStrokes[item].isSelected,
                        icon = Icons.Filled.Done
                    )
                    Spacer(modifier = Modifier.padding(end = 15.dp))
                })
        }
    )
}