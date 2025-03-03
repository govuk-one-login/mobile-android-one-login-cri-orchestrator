package uk.gov.onelogin.criorchestrator.testwrapper.devmenu

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uk.gov.android.ui.theme.smallPadding

@Composable
internal fun DevMenuOpenButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier =
            modifier
                .padding(smallPadding),
    ) {
        Text("Open Developer Menu")
    }
}
