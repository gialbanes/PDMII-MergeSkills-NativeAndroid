package com.fatec.merge_skills.ui.screens.aula05

// Define os eventos de interação da tela Aula05.
// Cada ação representa algo que o usuário pode fazer, como alterar o nome,
// enviar o formulário ou fechar uma mensagem.
// tudo que o usuário pode fazer

class Aula05Action {
    sealed interface Aula05Action {
        data class OnNameChanged(val name: String) : Aula05Action
        object OnSubmitClicked : Aula05Action
        object OnDismissMessage : Aula05Action
    }
}