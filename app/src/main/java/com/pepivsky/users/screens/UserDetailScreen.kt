package com.pepivsky.users.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pepivsky.users.presentation.UsersScreenViewModel
import com.pepivsky.users.model.response.Address
import com.pepivsky.users.model.response.Company
import com.pepivsky.users.model.response.Geo
import com.pepivsky.users.model.response.UserResponseItem


@Composable
fun UserDetailScreen(
    viewModel: UsersScreenViewModel,
    id: Int,
    navController: NavController
) {
    val contact = viewModel.users.find { it.id == id }!!
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(text = "ID: ${contact.id}", style = TextStyle(fontSize = 18.sp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Name: ${contact.name}", style = TextStyle(fontSize = 18.sp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Username: ${contact.username}", style = TextStyle(fontSize = 18.sp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Email: ${contact.email}", style = TextStyle(fontSize = 18.sp))
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text(
                text = "Address",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Street: ${contact.address.street}", style = TextStyle(fontSize = 18.sp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Suite: ${contact.address.suite}", style = TextStyle(fontSize = 18.sp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "City: ${contact.address.city}", style = TextStyle(fontSize = 18.sp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Zipcode: ${contact.address.zipcode}", style = TextStyle(fontSize = 18.sp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Lat: ${contact.address.geo.lat}", style = TextStyle(fontSize = 18.sp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Lng: ${contact.address.geo.lng}", style = TextStyle(fontSize = 18.sp))
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text(
                text = "Phone: ${contact.phone}",
                style = TextStyle(fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Website: ${contact.website}",
                style = TextStyle(fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text(
                text = "Company",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Name: ${contact.company.name}",
                style = TextStyle(fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Catch Phrase: ${contact.company.catchPhrase}",
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "BS: ${contact.company.bs}",
                style = TextStyle(fontSize = 18.sp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserDetailScreen() {
    //UserDetailScreen(contact = createDummyUser())
}

fun createDummyUser(): UserResponseItem {
    val dummyAddress = Address(
        city = "DummyCity",
        geo = Geo(lat = "0.0", lng = "0.0"),
        street = "DummyStreet",
        suite = "DummySuite",
        zipcode = "00000"
    )

    val dummyCompany = Company(
        bs = "DummyBS",
        catchPhrase = "DummyCatchPhrase",
        name = "DummyCompanyName"
    )

    return UserResponseItem(
        address = dummyAddress,
        company = dummyCompany,
        email = "dummy@email.com",
        id = 1,
        name = "DummyName",
        phone = "123-456-7890",
        username = "DummyUsername",
        website = "dummywebsite.com"
    )
}