package com.fatec.merge_skills.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.fatec.merge_skills.ui.theme.Surface

// Componente reutilizável de card do app.
// Ele exibe um ElevatedCard com cor de fundo personalizada e, se receber onClick,
// permite clique para navegar ou executar alguma ação. O conteúdo é renderizado em coluna.

@Composable
fun StitchCard(
    // o redirecionamento dele é responsabilidade de quem chama ele
    onClick:(() -> Unit)? = null, // null = card nao clicavel
    modifier: Modifier = Modifier,
    containerColor: Color = Surface, // seta a cor de fundo
    content: @Composable ColumnScope.() -> Unit // o conteudo é setado pela tela que usa o componente
) {
    // nativo do jetPackCompose
    ElevatedCard(
        onClick = {onClick?.invoke()}, // execute o invoke() se o onClick não for nulo
        enabled = onClick != null, // se for diferente de null, o card é clicavel
        modifier = modifier,
    ) {

    }
}