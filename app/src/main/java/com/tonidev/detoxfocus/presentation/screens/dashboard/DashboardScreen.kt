package com.tonidev.detoxfocus.presentation.screens.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tonidev.detoxfocus.presentation.theme.AccentProgress
import com.tonidev.detoxfocus.presentation.theme.TextSecondary

/**
 * MÓDULO 3: Panel de Analíticas (Dashboard Premium)
 * Placeholder inicial — pendiente: gráfico de 24 barras horarias y datos reales desde Room.
 */
@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Hoy",
            style = MaterialTheme.typography.headlineMedium
        )

        MetricCard(label = "Tiempo total de uso", value = "—")
        MetricCard(label = "Minutos bloqueados/evitados", value = "—")
        MetricCard(label = "Racha de días", value = "—")

        // TODO: sustituir por gráfico de 24 barras (Eje X horas 0-24h, Eje Y minutos)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Gráfico de uso por hora (pendiente)",
                    color = TextSecondary,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun MetricCard(label: String, value: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = value,
                style = MaterialTheme.typography.displayLarge,
                color = AccentProgress
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )
        }
    }
}