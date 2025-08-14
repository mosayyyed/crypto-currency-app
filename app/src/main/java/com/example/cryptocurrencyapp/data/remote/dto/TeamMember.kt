package com.example.cryptocurrencyapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TeamMember(
    val id: String,
    val name: String,
    val position: String
)

fun TeamMember.toTeamMember(): com.example.cryptocurrencyapp.domain.model.TeamMember {
    return com.example.cryptocurrencyapp.domain.model.TeamMember(
        id = id,
        name = name,
        position = position
    )
}
