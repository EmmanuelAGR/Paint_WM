package emmanuelagr.example.application.paint.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import emmanuelagr.example.application.paint.models.Painting
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PaintingTools(
    paths: MutableState<MutableList<Painting>>,
    sheetState: ModalBottomSheetState
) {
    val coroutineScope = rememberCoroutineScope()

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(5.dp)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
            ) {
                IButton(
                    Icons.Rounded.Palette,
                    description = "Color palette",
                    event = {
                        coroutineScope.launch {
                            sheetState.show()
                        }
                    }
                )

                Box(
                    contentAlignment = Alignment.Center,
                    content = {
                        Text(
                            text = "Paint WM",
                            fontSize = 30.sp,
                            color = MaterialTheme.colors.primary,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.Cursive
                        )
                    },
                    modifier = Modifier
                        .height(50.dp),
                )

                IButton(
                    Icons.Rounded.Delete,
                    description = "Clear canvas",
                    event = { paths.value = mutableListOf() }
                )
            }
        }
    }
}