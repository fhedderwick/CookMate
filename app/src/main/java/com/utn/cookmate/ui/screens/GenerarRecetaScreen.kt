package com.utn.cookmate.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.utn.cookmate.data.UserDataUiEvents
import com.utn.cookmate.ui.ButtonComponent
import com.utn.cookmate.ui.TextComponent
import com.utn.cookmate.ui.TextFieldComponent
import com.utn.cookmate.ui.TopBar
import com.utn.cookmate.ui.UserInputViewModel

@Composable
fun GenerarRecetaScreen (userInputViewModel: UserInputViewModel, navController : NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(18.dp)
    ) {
        Spacer(modifier = Modifier.size(40.dp))
        TextComponent(textValue = "Buscar recetas con ingredientes dados \uD83D\uDCA1", textSize = 24.sp)
        Spacer(modifier = Modifier.size(20.dp))
        TextComponent(textValue = "Ingrediente 1:", textSize = 16.sp)
        TextFieldComponent("Insertar ingrediente...",onTextChanged = {userInputViewModel.onEvent(UserDataUiEvents.IngredienteAgregado(it))})
        Spacer(modifier = Modifier.size(20.dp))
        TextComponent(textValue = "Ingrediente 2:", textSize = 16.sp)
        TextFieldComponent("Insertar ingrediente...",onTextChanged = {userInputViewModel.onEvent(UserDataUiEvents.IngredienteAgregado(it))})
        Spacer(modifier = Modifier.size(20.dp))
        TextComponent(textValue = "Ingrediente 3:", textSize = 16.sp)
        TextFieldComponent("Insertar ingrediente...",onTextChanged = {userInputViewModel.onEvent(UserDataUiEvents.IngredienteAgregado(it))})
        if(userInputViewModel.isValidBusquedaRecetasState()){
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    println("Se buscan recetas con estos ingredientes")
                    //ir a pantalla de RecetasEncontradasScreen
                }
            ) {
                TextComponent(textValue = "Buscar recetas!", textSize = 18.sp,colorValue = Color.White)
            }
        }
    }
}