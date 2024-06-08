package com.utn.cookmate.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.utn.cookmate.R

@Composable
fun RecetaEnLista(value: String, funBorrar : (idReceta:String) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = value,
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.clickable { println("click en receta") }
        )
        Spacer(modifier = Modifier.weight(1f).clickable { println("click en receta")})
        Text(
            modifier = Modifier.clickable { funBorrar(value) },
            text = "\uD83D\uDDD1\uFE0F",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun RecetaCard(idRecetaElegida: String, funcionRecetaElegida : (idReceta:String) -> Unit){
    var localFocusManager = LocalFocusManager.current
    Card (
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(24.dp).size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = Color.Green,// else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                ).clickable {
                    //ir a la otra pantalla
                    funcionRecetaElegida(idRecetaElegida) //llama a la funcion que recibio por parametro
                    localFocusManager.clearFocus()
                }){

        }

    }
}

@Composable
fun TopBar(value: String) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = value,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de CookMate"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar("Preview Text")
}

@Composable
fun TextComponent(
    textValue: String,
    textSize: TextUnit,
    colorValue: Color = Color.Black
) { //por default usara color negro
    Text(text = textValue, fontSize = textSize, color = colorValue, fontWeight = FontWeight.Light)
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(textValue = "Preview texto", textSize = 24.sp)
}

@Composable
fun TextFieldComponent(
    placeholderText : String,
    onTextChanged : (name:String) -> Unit
) {
    var currentValue by remember {
        mutableStateOf("")
    }
    var localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChanged(it)  //it es el valor que puso el usuario
                        },
        placeholder = { Text(text = placeholderText, fontSize = 18.sp) },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        }
        )
}

@Composable
fun FoodCard(image:Int, selected: Boolean, foodSelected : (foodName:String) -> Unit){
    var localFocusManager = LocalFocusManager.current
    Card (
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        width = 1.dp,
                        color = if (selected) Color.Green else Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )){
                    Image(
                        modifier =
                        Modifier
                            .padding(16.dp)
                            .wrapContentHeight()
                            .wrapContentWidth()
                            .clickable {
                                val foodName =
                                    if (image == R.drawable.pizza) "pizza" else "hamburguesa"
                                foodSelected(foodName)
                                localFocusManager.clearFocus()
                            },
                            painter = painterResource(id = image),
                            contentDescription = "imagen de hamburguesa"
                    )
                }

    }
}

@Preview
@Composable
fun FoodCardPreview(){
    FoodCard(R.drawable.pizza,true, {})
}

//@Preview(showBackground = true)
//@Composable
//fun TextFieldComponentPreview() {
//    TextFieldComponent()
//}

@Composable
fun ButtonComponent(
        goToDetailsScreen : () -> Unit   //funcion que no recibe nada y devuelve Unit
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {goToDetailsScreen()}
    ) {
        TextComponent(textValue = "Go to details screen", textSize = 18.sp,colorValue = Color.White)
    }

}