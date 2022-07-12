package dev.udhayakumar.dynamiccolortheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.udhayakumar.dynamiccolortheme.ui.theme.DynamicColorThemeTheme


@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicColorThemeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val systemUiController = rememberSystemUiController()
                    systemUiController.setSystemBarsColor(
                        color = MaterialTheme.colorScheme.primary
                    )
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize()
                    ) {

                        Row() {
                            FilledCard()
                        }

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .height(100.dp)) {
                            Column(modifier = Modifier
                                .padding(8.dp)
                                .fillMaxHeight()
                                .weight(3f),
                                verticalArrangement = Arrangement.Center ,
                                horizontalAlignment = Alignment.Start) {
                                Text(text = "Dark Mode" , fontSize = 16.sp)
                            }
                            Column(modifier = Modifier
                                .padding(8.dp)
                                .fillMaxHeight()
                                .weight(1f),
                                verticalArrangement = Arrangement.Center ,
                                horizontalAlignment = Alignment.End) {
                                var checked by remember { mutableStateOf(true) }
                                Switch(checked = checked, onCheckedChange = { checked = it })
                            }
                        }
                    }
                }
            }
        }
    }

}



@ExperimentalMaterial3Api
@Composable
fun FilledCard() {
    Card(onClick = {},
        modifier = Modifier
            .height(175.dp)
            .fillMaxWidth()

    ) {
       Row() {
           Column(modifier = Modifier
               .weight(1f)
               .padding(16.dp)) {
               Image(
                   painter = painterResource(id = R.drawable.ic_android),
                   contentDescription = null,
                   modifier = Modifier
                       .fillMaxHeight()
                       .width(100.dp)
               )

           }
           Column(modifier = Modifier
               .weight(2f)
               .padding(16.dp)) {
               Row() {
                   Column() {
                       Text(text = "Title", fontWeight = FontWeight.Bold , fontSize = 20.sp)
                       Text(text = "If you want to set manually the text alignment of a Text composable, prefer using TextAlign.", fontSize = 14.sp)
                   }

               }
               Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.Bottom , horizontalArrangement = Arrangement.End) {
               }
           }
       }
    }
}






