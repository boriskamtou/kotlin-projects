@file:OptIn(ExperimentalMaterial3Api::class)

package com.wcs.a30proverbs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wcs.a30proverbs.data.ProverbsRepository
import com.wcs.a30proverbs.models.Proverb
import com.wcs.a30proverbs.ui.theme._30ProverbsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30ProverbsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProverbsApp()
                }
            }
        }
    }
}


@Composable
fun ProverbsApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.titleMedium

                    )
                },
            )
        }
    ) {
        ProverbsList(
            proverbs = ProverbsRepository.proverbs,
            modifier = modifier,
            contentPadding = it
        )
    }
}


@Composable
fun ProverbsList(
    proverbs: List<Proverb>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues
) {
    LazyColumn(modifier = modifier, contentPadding = contentPadding) {
        items(proverbs) { proverb ->
            ProverbsItem(
                proverb = proverb, modifier = modifier.padding(
                    dimensionResource(
                        id = R.dimen.padding_medium
                    )
                )
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProverbsItem(proverb: Proverb, modifier: Modifier = Modifier) {
    var expand by remember {
        mutableStateOf(false)
    }
    Card(
        elevation = CardDefaults.cardElevation(
            dimensionResource(id = R.dimen.card_elevation)
        ),
        onClick = {
            expand = !expand
        },
        modifier = modifier
            .animateContentSize()
            .padding(bottom = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(
                    dimensionResource(id = R.dimen.padding_small)
                )
        ) {
            Text(text = stringResource(id = proverb.proverbDay))
            Text(
                text = stringResource(id = proverb.proverbTitle),
                style = MaterialTheme.typography.titleLarge
            )
            Box(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.image_size))
                    .clip(RoundedCornerShape(4.dp))
            ) {
                Image(
                    painter = painterResource(id = proverb.proverbImage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            if (expand) Column {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(id = proverb.proverbDescription),
                    style = MaterialTheme.typography.titleLarge

                )

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _30ProverbsTheme {
        ProverbsApp()
    }
}