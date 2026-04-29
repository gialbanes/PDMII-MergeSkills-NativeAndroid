package com.fatec.merge_skills

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fatec.merge_skills.ui.theme.MergeskillskotlinTheme
import com.fatec.merge_skills.ui.screens.auth.LoginScreen
import com.fatec.merge_skills.ui.screens.showcase.ShowcaseScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MergeskillskotlinTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("login") {
                            LoginScreen(
                                onLoginSuccess = {
                                    // mantem o login na pilha, o user pode voltar
                                    navController.navigate("showcase") {
                                        // remove o login da pilha, o usuario nao pode voltar
                                        popUpTo("login") { inclusive = true }
                                    }
                                }
                            )
                        }

                        composable("showcase") {
                            ShowcaseScreen(
                                onBackToLogin = {
                                    navController.navigate("login") {
                                        popUpTo("showcase") { inclusive = true }
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}