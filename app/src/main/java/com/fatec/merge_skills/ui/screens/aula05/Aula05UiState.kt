package com.fatec.merge_skills.ui.screens.aula05

// Representa o state atual da tela Aula05.
// Guarda os dados do formulário, o estado de carregamento
// e as mensagens de sucesso ou erro exibidas na interface.
// tudo que a tela pode exibir agora

data class Aula05UiState(
    val userName: String = "",
    val isLoading: Boolean = false,
    val successMessage: String? = null,
    val errorMessage: String? = null
)