package com.example.firstaid.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.firstaid.data.EMERGENCY_NUMBER

/**
 * Big red call button. Permission granted -> dials at once;
 * otherwise asks once, and if denied opens the dialer with the number filled in.
 */
@Composable
fun CallButton(modifier: Modifier = Modifier, big: Boolean = false) {
    val context = LocalContext.current

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted -> placeCall(context, direct = granted) }

    Button(
        onClick = {
            val hasPermission = ContextCompat.checkSelfPermission(
                context, Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED
            if (hasPermission) placeCall(context, direct = true)
            else permissionLauncher.launch(Manifest.permission.CALL_PHONE)
        },
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Brand.Red, contentColor = Color.White),
        modifier = modifier
            .fillMaxWidth()
            .height(if (big) 72.dp else 60.dp)
    ) {
        Text(
            "📞  Call $EMERGENCY_NUMBER",
            fontSize = if (big) 24.sp else 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

fun placeCall(context: Context, direct: Boolean) {
    val uri = Uri.parse("tel:$EMERGENCY_NUMBER")
    try {
        context.startActivity(Intent(if (direct) Intent.ACTION_CALL else Intent.ACTION_DIAL, uri))
    } catch (e: Exception) {
        try {
            context.startActivity(Intent(Intent.ACTION_DIAL, uri))
        } catch (_: Exception) {
            // Device cannot place calls. Nothing more to do.
        }
    }
}