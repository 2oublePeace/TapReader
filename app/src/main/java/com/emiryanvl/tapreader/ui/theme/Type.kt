package com.example.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.emiryanvl.tapreader.R

val interFamily = FontFamily(
    Font(resId = R.font.inter_light, weight = FontWeight.Light),
    Font(resId = R.font.inter_medium, weight = FontWeight.Medium),
    Font(resId = R.font.inter_semibold, weight = FontWeight.SemiBold)
)

val dmSansFamily = FontFamily(
    Font(resId = R.font.dm_sans_bold, weight = FontWeight.Bold)
)

val baseline = Typography()

val Typography = with(baseline) {
    Typography(
        displayLarge = displayLarge.copy(fontFamily = interFamily),
        displayMedium = displayMedium.copy(fontFamily = interFamily),
        displaySmall = displaySmall.copy(fontFamily = interFamily),
        headlineLarge = headlineLarge.copy(fontFamily = interFamily),
        headlineMedium = headlineMedium.copy(
            fontFamily = interFamily,
            fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
            fontSize = 24.sp,
            lineHeight = 20.sp
        ),
        headlineSmall = headlineSmall.copy(
            fontFamily = interFamily,
            fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
            fontSize = 18.sp,
            lineHeight = 20.sp
        ),
        titleLarge = titleLarge.copy(
            fontFamily = interFamily,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 20.sp
        ),
        titleMedium = titleMedium.copy(
            fontFamily = interFamily,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 17.sp
        ),
        titleSmall = titleSmall.copy(
            fontFamily = interFamily,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Light,
            fontSize = 13.sp,
            lineHeight = 16.sp
        ),
        bodyLarge = bodyLarge.copy(
            fontFamily = interFamily,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Light,
            fontSize = 16.sp,
            lineHeight = 17.sp
        ),
        bodyMedium = bodyMedium.copy(
            fontFamily = interFamily,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Light,
            fontSize = 14.sp,
            lineHeight = 17.sp
        ),
        bodySmall = bodySmall.copy(
            fontFamily = interFamily,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 17.sp
        ),
        labelLarge = labelLarge.copy(
            fontFamily = interFamily,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 20.sp
        ),
        labelMedium = labelMedium.copy(
            fontFamily = interFamily,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
            fontSize = 13.sp,
            lineHeight = 16.sp
        ),
        labelSmall = labelSmall.copy(
            fontFamily = dmSansFamily,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
            fontSize = 10.sp,
            lineHeight = 13.sp
        )
    )
}