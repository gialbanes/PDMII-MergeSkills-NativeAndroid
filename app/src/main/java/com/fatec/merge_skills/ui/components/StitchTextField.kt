package com.fatec.merge_skills.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.fatec.merge_skills.ui.theme.StitchError

// Componente reutilizável de campo de texto do app.
// Ele mostra um OutlinedTextField com label, placeholder opcional,
// validação de erro e mensagem de erro abaixo do campo.

@Composable
fun StitchTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange:(String)->Unit,
    label: String,
    placeholder: String? = null,
    isError: Boolean = false, // pra saber se a field fica vermelha de acordo com onValueChange
    errorMessage: String? = null,
    secureTextEntry: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default, // quem consome o componente define o teclado
    visualTransformation: VisualTransformation = VisualTransformation.None // gerencia a alternancia de cor
) {
    Column(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = {
                // garante que vem string
                Text(label)
            },
            placeholder = {
                // aqui pode ver nulo, entao precisa tratar
                // .let: acessa de forma segura se o valor for diferente de nulo
                // it(renomeado para textValido): quando quero referenciar algo dentro de uma funcao em bloco
                placeholder?.let { textValido ->
                    Text(textValido)
                }
            },
            isError = isError,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            singleLine = true
        )
        if (isError && errorMessage != null) {
            Text(
                text = errorMessage,
                color = StitchError,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )
        }
    }

}