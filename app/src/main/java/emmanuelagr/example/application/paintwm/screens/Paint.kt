package emmanuelagr.example.application.paint.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import emmanuelagr.example.application.paint.components.Canvas
import emmanuelagr.example.application.paint.components.ModalBottomSL
import emmanuelagr.example.application.paint.components.PaintingTools
import emmanuelagr.example.application.paint.models.Painting

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Paint() {
    val painting = remember { mutableStateOf(mutableListOf<Painting>()) }
    val paintColor = remember { mutableStateOf(Color.Black) }
    val paintStroke = remember { mutableStateOf(Stroke(5f)) }

    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    painting.value.add(Painting(Path(), paintColor.value, paintStroke.value))

    ModalBottomSheetLayout(
        sheetContent = { ModalBottomSL(paintColor, paintStroke) },
        sheetState = sheetState,
        sheetBackgroundColor = MaterialTheme.colors.background,
        scrimColor = MaterialTheme.colors.onBackground.copy(alpha = 0.30f)
    ) {
        Scaffold(
            topBar = { PaintingTools(paths = painting, sheetState) },
            backgroundColor = MaterialTheme.colors.background,
            content = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    content = { Canvas(paintColor, paintStroke, paths = painting.value) }
                )
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}