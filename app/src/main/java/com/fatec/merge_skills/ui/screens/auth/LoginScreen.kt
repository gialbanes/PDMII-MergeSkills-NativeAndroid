package com.fatec.merge_skills.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fatec.merge_skills.ui.components.StitchTextField

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    viewModel: LoginViewModel = viewModel()
) {

    // antes usava remember, mas agora preciso buscar na viewmodel
    val uiState by viewModel.uiState.collectAsState()

    // LaunchedEffect observa estado na tela, no caso observar se o redirect de login teve sucesso
    LaunchedEffect(uiState.isLoginSuccess) {
        if (uiState.isLoginSuccess) {
            onLoginSuccess() // callback na tela de login para a proxima tela que ela chama
        }
    }

    // componente estruturante para sobrepor elementos
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // aplicando como se fosse h1, h2, h3...
            Text(
                text = "MergeSkills ",
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Bem-vindo de volta \uD83D\uDC4B " ,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface,
            )
            Text(
                text = "Entre para continuar...   ",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            Spacer(
                // espaçamento entre os componetes
                // add mais 16dp ao spacedBy no Column
                modifier = Modifier.height(16.dp)
            )
            StitchTextField(
                value = uiState.email,
                onValueChange = {viewModel.onEmailChange(it)},
                label = "E-mail",
                placeholder = "email@gmail.com",
                // proximo pasos e add teclado, vou add no botao de ok do teclado uma funcionalida, pq geralmente no ok ele so abaixa
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                isError = uiState.error?.contains("Senha") == true || uiState.error?.contains("6 caracteres") == true,
                errorMessage = if (uiState.error?.contains("Senha") == true || uiState.error?.contains("6 caracteres") == true) uiState.error else null
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { viewModel.onLoginClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                enabled = !uiState.isLoading,
                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(24.dp),
                        strokeWidth = 2.dp
                    )
                } else {
                    Text(
                        text = "Entrar",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}