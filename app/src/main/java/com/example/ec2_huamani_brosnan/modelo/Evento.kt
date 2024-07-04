package com.example.ec2_huamani_brosnan.modelo
import androidx.annotation.DrawableRes
data class Evento(
    var titulo:String,
    var descripcion:String,
    var fecha:String,
    @DrawableRes var imagen:Int
)
