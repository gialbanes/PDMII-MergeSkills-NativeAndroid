package com.fatec.merge_skills.ui.components


import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.fatec.merge_skills.ui.theme.Surface

@Composable
fun StitchCard(
    onClick:(()->Unit)? = null,
    modifier: Modifier = Modifier,
    containerColor: Color = Surface,
    content: @Composable ColumnScope.() -> Unit
    ) {
    ElevatedCard(
        onClick = {onClick?.invoke()},
        enabled = onClick != null,
        modifier = modifier
    ) {

    }
}