package com.fatec.merge_skills.ui.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// Estado da tela de login.
// Guarda os dados digitados, o estado de carregamento,
// mensagens de erro e se o login foi concluído com sucesso.
data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isLoginSuccess: Boolean = false
)

// ViewModel responsável por controlar o login.
// Ele recebe as alterações dos campos, valida os dados e simula o envio,
// atualizando o estado que a tela exibe.
class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onEmailChange(newValue: String) {
        _uiState.update { it.copy(email = newValue, error = null) }
    }

    fun onPasswordChange(newValue: String) {
        _uiState.update { it.copy(password = newValue, error = null) }
    }

    fun onLoginClick() {
        val currentEmail = _uiState.value.email
        val currentPassword = _uiState.value.password

        // Validação básica didática
        if (!currentEmail.contains("@")) {
            _uiState.update { it.copy(error = "Digite um e-mail válido") }
            return
        }

        if (currentPassword.length < 6) {
            _uiState.update { it.copy(error = "Mínimo 6 caracteres") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            // Simulação de delay de rede
            delay(1500)

            _uiState.update {
                it.copy(
                    isLoading = false,
                    isLoginSuccess = true
                )
            }
        }
    }
}