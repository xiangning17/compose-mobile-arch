import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext

actual fun getPlatformName(): String = "Android"

@Composable fun MainView() = AppWrapper()

@Composable fun AppWrapper() {
    LocalConfiguration.current
    App(LocalContext.current.resources)
}