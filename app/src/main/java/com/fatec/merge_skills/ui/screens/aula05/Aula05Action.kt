package com.fatec.merge_skills.ui.screens.aula05

class Aula05Action {
    sealed interface Aula05Action {
        data class OnNameChanged(val name: String) : Aula05Action
        object OnSubmitClicked : Aula05Action
        object OnDismissMessage : Aula05Action
    }
}