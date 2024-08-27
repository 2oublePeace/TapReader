package com.example.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.emiryanvl.tapreader.R

val InterFamily = FontFamily(
    Font(resId = R.font.inter_light, weight = FontWeight.Light),
    Font(resId = R.font.inter_medium, weight = FontWeight.Medium),
    Font(resId = R.font.inter_semibold, weight = FontWeight.SemiBold)
)

val DmSansFamily = FontFamily(
    Font(resId = R.font.dm_sans_bold, weight = FontWeight.Bold)
)

val Typography = with(Typography()) {
    Typography(
        displayLarge = displayLarge.copy(
            fontFamily = InterFamily
        ),
        displayMedium = displayMedium.copy(
            fontFamily = InterFamily,
        ),
        displaySmall = displaySmall.copy(
            fontFamily = InterFamily
        ),
        headlineLarge = headlineLarge.copy(
            fontFamily = InterFamily
        ),
        headlineMedium = headlineMedium.copy(
            fontFamily = InterFamily
        ),
        headlineSmall = headlineSmall.copy(
            fontFamily = InterFamily
        ),
        titleLarge = titleLarge.copy(
            fontFamily = InterFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        ),
        titleMedium = titleMedium.copy(
            fontFamily = InterFamily,
            fontWeight = FontWeight.Medium
        ),
        titleSmall = titleSmall.copy(
            fontFamily = InterFamily,
            fontWeight = FontWeight.Light,
            color = Color(0xFF838589)
        ),
        bodyLarge = bodyLarge.copy(
            fontFamily = InterFamily
        ),
        bodyMedium = bodyMedium.copy(
            fontFamily = InterFamily
        ),
        bodySmall = bodySmall.copy(
            fontFamily = InterFamily
        ),
        labelLarge = labelLarge.copy(
            fontFamily = InterFamily
        ),
        labelMedium = labelMedium.copy(
            fontFamily = InterFamily
        ),
        labelSmall = labelSmall.copy(
            fontFamily = DmSansFamily
        )
    )
}