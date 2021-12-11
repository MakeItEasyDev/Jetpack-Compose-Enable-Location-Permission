package com.jetpack.locationpermission.permission

sealed class PermissionAction {
    object OnPermissionGranted: PermissionAction()
    object OnPermissionDenied: PermissionAction()
}
