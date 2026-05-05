package com.fatec.merge_skills.ui.screens.showcase

import android.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fatec.merge_skills.ui.components.StitchCard

data class MockCourse(
    val id: String,
    val title: String,
    val description: String,
    val level: String
)

// collection
// scroll e click demanda muit processamento,
val MOCK_COURSES = listOf(
    MockCourse("1", "Layouts com Compose", "Aprendendo Column, Row e Box de forma profunda.", "Básico"),
    MockCourse("2", "Gestão de Estado", "Uso de remember, mutableStateOf e ViewModels.", "Intermediário"),
    MockCourse("3", "Navegação Avançada", "Fluxos complexos com Navigation Compose.", "Intermediário"),
    MockCourse("4", "Animações e Efeitos", "Dando vida aos componentes com Animatable.", "Avançado"),
    MockCourse("5", "Clean Architecture", "Organizando o projeto para escala e testes.", "Avançado")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowcaseScreen(
    onBackToLogin: () -> Unit
) {
    // estrutura padrão da tela com uma barra fixa no topo com o titulo
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Showcase",
                        style = MaterialTheme.typography.displayMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface

                )
            )
        }
    ) { innerPadding -> // propriedade que a funcao scaffold retorna pra não ultrapassar os limites de statusbar e navigationbar
        Column(

        ) {
            // é o que eu faco com o componente dedicado lazycolumn
            for(i in MOCK_COURSES){
                Text(
                    text = "Title" + i.title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            // mostrar listagem de forma performática, paginacao, componente estruturante
            LazyColumn(
                // como se fosse um css
                // se é config geral eu acesso modifier
                modifier = Modifier
                    .fillMaxSize()
                    // a ordem importa
                    // a mesma coisa do spacer com o column
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
            ) { }
        }
    }
}