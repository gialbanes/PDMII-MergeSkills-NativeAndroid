package com.fatec.merge_skills.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.HistoricalChange
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun StitchTextField(
    // TextField precisa de 3 strings para serem passadas
    // propriedades:
    modifier: Modifier = Modifier,
    value: String,
    onValueChange:(String)->Unit,
    label: String,
    placeholder: String? = null,
    isError: Boolean = false, // pra saber se a field fica vermelha de acordo com onValueChange
    errorMessage: String? = null,
    securetextEntry: Boolean = false,
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
            shape = RoundedCornerShape(12.dp)

        )
    }

}