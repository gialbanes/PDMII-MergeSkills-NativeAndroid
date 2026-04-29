package com.fatec.merge_skills.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.fatec.merge_skills.ui.theme.Surface

@Composable
fun StitchCard(
    // o redirecionamento dele é responsabilidade de quem chama ele
    // primeira propriedade: seta a cor de fundo
    // segunda chama o content, que quem chama é a tela que usa o stitch
    onClick:(() -> Unit)? = null,
    modifier: Modifier = Modifier,
    containerColor: Color = Surface,
    // o content do card por default ja fica alinhado em coluna
    content: @Composable ColumnScope.() -> Unit
) {
    // nativo do jetPackCompose
    ElevatedCard(
        onClick = {onClick?.invoke()},
        enabled = onClick != null,
        modifier = modifier,
    ) {

    }
}