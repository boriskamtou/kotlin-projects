package com.wcs.lemonde

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wcs.lemonde.ui.theme.LemondeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemondeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    // This variable is used as stepper
    var resourceNumber by remember {
        mutableIntStateOf(1)
    }

    val randomPressedNumber = (2..4).random() // generate a random number

    // Get the resource of the corresponding image according to the stepper
    val imageResourceId = when (resourceNumber) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    // Get the resource of the corresponding title according to the stepper
    val titleResourceId = when (resourceNumber) {
        1 -> R.string.lemon_tree_title
        2 -> R.string.lemon_squeeze_title
        3 -> R.string.lemonade_drink_title
        4 -> R.string.lemonade_glass_empty
        else -> R.string.lemon_tree_title
    }
// Get the resource of the corresponding content description according to the stepper
    val imageContentDescriptionResourceId = when (resourceNumber) {
        1 -> R.string.lemon_tree_content_description
        2 -> R.string.lemon_content_description
        3 -> R.string.glass_of_lemonade_description
        4 -> R.string.empty_glass_description
        else -> R.string.lemon_tree_content_description
    }

    var pressedCount = 0

    ButtonAndTextLemonade(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(
                align = Alignment.Center
            ),
        onClick = {
            if (resourceNumber != 4) {
                if (resourceNumber == 2) {
                    pressedCount++
                    if (pressedCount == randomPressedNumber) {
                        resourceNumber++
                    }
                } else {
                    resourceNumber++
                }
            } else {
                resourceNumber = 1
            }
        },
        imageResourceId = imageResourceId,
        imageContentDescriptionResourceId = imageContentDescriptionResourceId,
        titleResourceId = titleResourceId,
    )
}

@Composable
fun ButtonAndTextLemonade(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    imageResourceId: Int,
    imageContentDescriptionResourceId: Int,
    titleResourceId: Int
) {

    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onClick,
            shape = RoundedCornerShape(16.dp),
        ) {
            Image(
                painter = painterResource(id = imageResourceId),
                contentDescription = stringResource(
                    id = imageContentDescriptionResourceId
                ),
                modifier = Modifier.width(150.dp).height(150.dp).padding(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = titleResourceId),
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}