package com.wcs.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wcs.visitcard.ui.theme.VisitCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisitCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    VisitCardApp()
                }
            }
        }
    }
}

@Composable
fun VisitCardApp() {
    Surface(color = Color(0xFFbdd3c0)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1F))
            ProfileImage()
            Spacer(modifier = Modifier.weight(1F))
            ContactInfos()
            Spacer(modifier = Modifier.size(36.dp))
        }
    }
}

@Composable
fun ProfileImage(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(color = Color(0xFF073042)) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .padding(10.dp)
            )
        }
        Text(
            text = "Jennifer Doe",
            fontSize = 20.sp,
            letterSpacing = 3.sp,
            modifier = Modifier.padding(bottom = 4.dp, top = 8.dp)
        )
        Text(
            text = "Senior Android Developer",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4e966d)
        )
    }
}

@Composable
fun ContactInfos() {
    Column {
        RowContactInfo(imageVector = Icons.Rounded.Call, contactInfo = "(+237) 659 460 125")
        RowContactInfo(imageVector = Icons.Rounded.Share, contactInfo = "@AndroidDev")
        RowContactInfo(imageVector = Icons.Rounded.Email, contactInfo = "jendoe@android.com")
    }
}

@Composable
fun RowContactInfo(imageVector: ImageVector, contactInfo: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 12.dp)
    ) {
        Icon(imageVector = imageVector, contentDescription = null, Modifier.size(18.dp))
        Text(
            text = contactInfo,
            fontSize = 12.sp,
            color = Color(0xFF073042),
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VisitCardTheme {
        VisitCardApp()
    }
}
