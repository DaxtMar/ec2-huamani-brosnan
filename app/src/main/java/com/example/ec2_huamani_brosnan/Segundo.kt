package com.example.ec2_huamani_brosnan


import com.example.ec2_huamani_brosnan.modelo.Evento
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun listado(modifier: Modifier = Modifier) {
    //LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(listarEvento()) { evento ->
            ItemRecycler(mascota = evento)
        }
    }
}

@Composable
fun ItemRecycler(mascota: Evento) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = mascota.imagen), contentDescription = "img",
                modifier = Modifier.width(200.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = mascota.titulo, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = mascota.descripcion)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = mascota.fecha)
            }

        }
    }
}

fun listarEvento(): List<Evento> {
    return listOf(
        Evento("primero", "etccc", "12/12/24", R.drawable.ic_launcher_background),
        Evento("segundo", "etccc", "12/12/24", R.drawable.ic_launcher_background),
        Evento("tercero", "etccc", "12/12/24", R.drawable.ic_launcher_background),
        Evento("cuarto", "etccc", "12/12/24", R.drawable.ic_launcher_background),
    )
}