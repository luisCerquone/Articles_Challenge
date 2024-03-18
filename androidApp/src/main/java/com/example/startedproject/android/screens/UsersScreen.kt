package com.example.startedproject.android.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
        ToolbarComponent("Users", onUpButtonClick)
        ContentUserView(userViewModel, onUser)
    }
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
            color = Color.Gray
        )
        Text(
            text = "LastName: " + user.lastName,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Email: " + user.email,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "BirthDate: " + user.birthDate,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "see location!",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
    }
    Divider()
}