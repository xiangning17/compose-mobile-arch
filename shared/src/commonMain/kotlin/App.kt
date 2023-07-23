import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xiangning.resource.SharedRes
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource as composePaintResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(input: Any? = null) {
    MaterialTheme {
        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                Modifier.fillMaxWidth().height(50.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painterResource(SharedRes.images.ic_ai_avatar), null
                )
                Image(
                    painterResource(SharedRes.images.ic_reopen_24), null
                )
            }

            input.toString()
            val text = stringResource(SharedRes.strings.my_string)
            Button(onClick = {
//                greetingText = "Hello, ${input.ifEmpty { greetingText }}, 本地化：$text"
                showImage = !showImage
            }) {
                Text("Hello $text")
            }
            AnimatedVisibility(showImage) {
                Image(
                    composePaintResource("drawable/compose-multiplatform.xml"),
                    null
                )
            }
        }
    }
}

expect fun getPlatformName(): String