package com.pepivsky.users.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pepivsky.users.HomeUiState
import com.pepivsky.users.R
import com.pepivsky.users.UsersScreenViewModel
import com.pepivsky.users.model.UserResponseItem
import com.pepivsky.users.ui.theme.UsersTheme
import androidx.compose.ui.text.style.TextAlign
import com.pepivsky.users.util.InternetConnectivityManger
import com.pepivsky.users.navigation.AppScreens


@Composable
fun UsersScreen(
    modifier: Modifier = Modifier,
    viewModel: UsersScreenViewModel,
    navController: NavController
) {

    val uiState = viewModel.homeUiState
    val users = viewModel.users
    Box(modifier = Modifier.fillMaxSize()) {
        when (uiState) {
            is HomeUiState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            is HomeUiState.Success -> {
                LazyColumn(content = {
                    items(users, key = { it.id }) { user ->
                        UserItem(
                            user = user,
                            onClick = { navController.navigate(route = AppScreens.DetailScreen.route + "/" + user.id) })
                    }
                })
            }

            is HomeUiState.Error -> {
                /*Text(
                    text = "error",
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )*/
                ErrorScreen()
                InternetConnectivityManger {
                    viewModel.getUsers()
                }

            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun UserItem(user: UserResponseItem, onClick: () -> Unit) {
    Row(
        Modifier
            .clickable(onClick = onClick)
            .fillMaxWidth()
            .padding(10.dp), verticalAlignment = Alignment.CenterVertically
    )
    {
        Image(
            painter = painterResource(id = R.drawable.elon),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(70.dp)
                .width(70.dp)
                .clip(CircleShape)

        )
        Spacer(
            modifier = Modifier
                .width(16.dp)
        )

        Column {
            Text(text = user.name, fontWeight = FontWeight.Bold, fontSize = 26.sp, maxLines = 1)
            Text(text = user.username, fontWeight = FontWeight.Light, fontSize = 14.sp)
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UsersTheme {

    }
}