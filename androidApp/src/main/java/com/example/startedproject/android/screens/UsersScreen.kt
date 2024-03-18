package com.example.startedproject.android.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.startedproject.users.domain.User
import com.example.startedproject.users.presentation.UserViewModel

@Composable
fun UsersScreen(
    userViewModel: UserViewModel,
    onUpButtonClick: () -> Unit,
    onUser: () -> Unit,
) {
    Column {
        Toolbar(onUpButtonClick)
        ContentUserView(userViewModel, onUser)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(
    onUpButtonClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "Users") },
        navigationIcon = {
            IconButton(onClick = onUpButtonClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Up Button",
                )
            }
        }
    )
}

@Composable
private fun ContentUserView(userViewModel: UserViewModel, onUser: () -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(userViewModel.usersState.value.users) { row ->
            RowUserView(row, userViewModel, onUser)
        }
    }
}

@Composable
private fun RowUserView(
    user: User,
    userViewModel: UserViewModel,
    onUser: () -> Unit
) {
    Column(
        Modifier
            .padding(16.dp)
            .clickable {
                userViewModel.selectUser(user)
                onUser()
            }) {
        Text(
            text = "Name: " + user.name,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
        )
        Text(
            text = "LastName: " + user.lastName,
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = "Email: " + user.email,
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = "BirthDate: " + user.birthDate,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
    Divider()
}