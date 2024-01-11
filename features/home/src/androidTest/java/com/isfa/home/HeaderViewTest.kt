package com.isfa.home

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.isfa.home.ui.HomeScreen
import org.junit.Rule
import org.junit.Test

class HeaderViewTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun test_showWordingMessage_on_HeaderView() {
        // When
        composeRule.setContent {
            HomeScreen(emptyList())
        }

        // Then
        composeRule
            .onNodeWithText("BPS Beritaku!")
            .assertExists()
    }
}