package com.invenzo.daggerandroid.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.invenzo.daggerandroid.MyApp
import com.invenzo.daggerandroid.ui.theme.DaggerAndroidTheme
import com.invenzo.daggerandroid.viewmodel.LoginViewModel
import javax.inject.Inject

class LoginActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApp).appComponent.inject(this)
        enableEdgeToEdge()
        loginViewModel = ViewModelProvider(this, viewModelFactory)[LoginViewModel::class.java]

        setContent {
            DaggerAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    login(
                        loginViewModel, modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ScreenContainer(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // or your theme background
            .padding(10.dp)          // optional padding
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun login(viewModel: LoginViewModel?, modifier: Modifier) {

    var email = remember { mutableStateOf(TextFieldValue("")) }
    var password = remember { mutableStateOf(TextFieldValue("")) }

    val passwordFocusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    ScreenContainer {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .imePadding(),
            verticalArrangement = Arrangement.Top,

            ) {

            Text(
                text = "Login",
                color = Color.Black,
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(all = 0.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Email",
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(all = 0.dp)

            )

            TextField(colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFEDEDED), // <-- Background color
                focusedIndicatorColor = Color.Transparent, // removes underline
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
                placeholder = {
                    Text(
                        text = "Enter your email", modifier = Modifier.padding(0.dp)
                    )
                },
                onValueChange = { newText ->
                    email.value = newText
                },
                value = email.value,
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small.copy(all = ZeroCornerSize),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next, keyboardType = KeyboardType.Email
                ),
                keyboardActions = KeyboardActions(onNext = { passwordFocusRequester.requestFocus() })

            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Password",
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(all = 0.dp)
            )
            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFEDEDED), // <-- Background color
                    focusedIndicatorColor = Color.Transparent, // removes underline
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                placeholder = { Text(text = "Enter your password") },
                onValueChange = { newText ->
                    password.value = newText
                },
                value = password.value,
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small.copy(all = ZeroCornerSize),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next, keyboardType = KeyboardType.Password
                ),
                keyboardActions = KeyboardActions(onNext = { focusManager.clearFocus() }),

                )
            Spacer(modifier = Modifier.height(20.dp))
            Button(modifier = Modifier
                .align(Alignment.End)
                .requiredWidth(150.dp),
                onClick = { /* Do something */ }) {
                Text("Login")
            }

        }
    }


}

@Preview(showBackground = true)
@Composable
fun loginPreview() {

    DaggerAndroidTheme {
        login(null, modifier = Modifier.padding(10.dp))
    }
}