package com.example.ec2_huamani_brosnan

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun Cuestionario(modifier: Modifier = Modifier) {

    var selectedHabilidades by remember { mutableStateOf(listOf<String>()) }
    var trabajoSignificativo by remember { mutableStateOf("") }
    var pagoTrabajo by remember { mutableStateOf("") }
    var trabajaBajoPresion by remember { mutableStateOf(false) }
    var crecimientoTrabajo by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    var estado = remember {
        SnackbarHostState()
    }
    Column(modifier = Modifier
        .padding(5.dp)
        .verticalScroll(rememberScrollState())) {
        Text(text="CUESTIONARIO",Modifier.wrapContentSize(align = Alignment.Center))
        Spacer(modifier = Modifier.height(5.dp))

        Text("1. Marque sus habilidades.")
        val habilidades = listOf(
            "Autoconocimiento", "Empatía", "Comunicación asertiva",
            "Toma de decisiones", "Pensamiento crítico", "Ninguno"
        )
        habilidades.forEach { habilidad ->
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Checkbox(
                    checked = selectedHabilidades.contains(habilidad),
                    onCheckedChange = {
                        selectedHabilidades = if (it) {
                            selectedHabilidades + habilidad
                        } else {
                            selectedHabilidades - habilidad
                        }
                    }
                )
                Text(habilidad)
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text("2. ¿Cuán significativo es tu trabajo?")
        val opcionesSignificativo = listOf("Mucho", "Más o menos", "Poco")
        opcionesSignificativo.forEach { opcion ->
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                RadioButton(
                    selected = trabajoSignificativo == opcion,
                    onClick = { trabajoSignificativo = opcion }
                )
                Text(opcion)
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text("3. ¿Qué tan bien te pagan en el trabajo que haces?")
        val opcionesPago = listOf("Bien", "Regular", "Mal")
        opcionesPago.forEach { opcion ->
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                RadioButton(
                    selected = pagoTrabajo == opcion,
                    onClick = { pagoTrabajo = opcion }
                )
                Text(opcion)
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text("4. ¿Trabajas bajo presión?")
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            RadioButton(
                selected = trabajaBajoPresion,
                onClick = { trabajaBajoPresion = true }
            )
            Text("SI")
            RadioButton(
                selected = !trabajaBajoPresion,
                onClick = { trabajaBajoPresion = false }
            )
            Text("NO")
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text("5. ¿Tienes oportunidad de crecimiento en tu trabajo?")
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            RadioButton(
                selected = crecimientoTrabajo,
                onClick = { crecimientoTrabajo = true }
            )
            Text("SI")
            RadioButton(
                selected = !crecimientoTrabajo,
                onClick = { crecimientoTrabajo = false }
            )
            Text("NO")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            scope.launch {
                estado.showSnackbar(
                    "Mensaje guardado",
                    actionLabel = "OK",
                    duration = SnackbarDuration.Long
                )
            }
        }) {
            Text("Resolver")
        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}