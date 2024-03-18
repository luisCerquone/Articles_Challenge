package com.example.startedproject.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.startedproject.users.presentation.UserViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun UserMapsScreen(
    userViewModel: UserViewModel,
    onUpButtonClick: () -> Unit
) {
    Column {
        Toolbar(onUpButtonClick)
        ContentMapView(userViewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(
    onUpButtonClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "User location") },
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
private fun ContentMapView(userViewModel: UserViewModel) {
    val user = userViewModel.selectedUser.value

    val marker = user?.address?.location?.lat?.let { lat ->
        LatLng(
            lat.toDouble(),
            user.address.location.lng.toDouble()
        )
    }

    val cameraPositionState = rememberCameraPositionState {
        position = marker?.let { CameraPosition.fromLatLngZoom(it, 10f) }!!
    }

    GoogleMap(modifier = Modifier.fillMaxSize(), cameraPositionState = cameraPositionState) {
        marker?.let { MarkerState(position = it) }?.let { position ->
            Marker(
                state = position,
                title = "User",
                snippet = "Marker in user"
            )
        }
    }
}