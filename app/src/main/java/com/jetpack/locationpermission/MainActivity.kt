package com.jetpack.locationpermission

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.jetpack.locationpermission.snackbar.DefaultSnackBar
import com.jetpack.locationpermission.ui.theme.LocationPermissionTheme
import com.jetpack.locationpermission.viewmodel.PermissionViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val scaffoldState = rememberScaffoldState()
            val permissionViewModel = PermissionViewModel()

            LocationPermissionTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Location Permission",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        },
                        scaffoldState = scaffoldState,
                        snackbarHost = { scaffoldState.snackbarHostState },
                        content = { innerPadding ->
                            Column {
                                Box(modifier = Modifier.padding(innerPadding)) {
                                    EnablePermissionUI(
                                        scaffoldState = scaffoldState,
                                        permissionViewModel = permissionViewModel
                                    )

                                    DefaultSnackBar(
                                        snackbarHostState = scaffoldState.snackbarHostState,
                                        modifier = Modifier.align(Alignment.BottomCenter),
                                        onAction = {
                                            scaffoldState.snackbarHostState.currentSnackbarData?.performAction()
                                        }
                                    )
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}













