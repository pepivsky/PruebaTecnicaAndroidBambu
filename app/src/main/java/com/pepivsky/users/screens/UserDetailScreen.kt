package com.pepivsky.users.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pepivsky.users.R
import com.pepivsky.users.presentation.UsersScreenViewModel
import com.pepivsky.users.model.response.Address
import com.pepivsky.users.model.response.Company
import com.pepivsky.users.model.response.Geo
import com.pepivsky.users.model.response.UserResponseItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailScreen(
    viewModel: UsersScreenViewModel,
    id: Int,
    navController: NavController
) {
    val userResponseItem = viewModel.users.find { it.id == id }!!

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = userResponseItem.name, fontWeight = FontWeight.Bold)
        }, navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back",
                modifier = Modifier.clickable { navController.popBackStack() })
        })
    }, content = {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            val userProperties = userToList(userResponseItem)
            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.elon),
                        contentDescription = "Profile Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(16.dp)
                            .height(100.dp)
                            .width(100.dp)
                            .clip(CircleShape)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }

            items(userProperties) {
                FieldItem(it)
            }
        }
    })


}


@Composable
fun FieldItem(field: String = "Correo") {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), shape = RoundedCornerShape(100.dp)
        ) {
            Row(
                modifier = Modifier
                    //.background(Color.Transparent)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                //Spacer(modifier = Modifier.pa)
                Icon(
                    modifier = Modifier.padding(start = 20.dp),
                    imageVector = Icons.Default.Face,
                    contentDescription = "face icon"
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = field,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
    }
}

fun userToList(userResponseItem: UserResponseItem): List<String> {
    return listOf(
        userResponseItem.name,
        userResponseItem.username,
        userResponseItem.email,
        userResponseItem.phone,
        userResponseItem.website,
        userResponseItem.company.name,
        userResponseItem.company.bs,
        userResponseItem.company.catchPhrase,
        userResponseItem.address.suite,
        userResponseItem.address.zipcode,
        userResponseItem.address.city,
        userResponseItem.address.street,
        userResponseItem.address.zipcode,
    )
}

