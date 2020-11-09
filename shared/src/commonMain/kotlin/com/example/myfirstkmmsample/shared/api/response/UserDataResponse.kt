package com.example.myfirstkmmsample.shared.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDataResponse(
    @SerialName("results")
    val users: List<UserData>,
    @SerialName("info")
    val info: Info,
)

@Serializable
data class Info(
    @SerialName("seed")
    val seed: String,
    @SerialName("results")
    val results: Int,
    @SerialName("page")
    val page: Int,
    @SerialName("version")
    val version: String,
)

@Serializable
data class UserData(
    @SerialName("gender")
    val gender: String,
    @SerialName("name")
    val name: Name,
    @SerialName("location")
    val location: Location,
    @SerialName("email")
    val email: String,
    @SerialName("login")
    val login: Login,
    @SerialName("dob")
    val dob: Dob,
    @SerialName("registered")
    val registered: Registered,
    @SerialName("phone")
    val phone: String,
    @SerialName("cell")
    val cell: String,
    @SerialName("id")
    val id: Id,
    @SerialName("picture")
    val picture: Picture,
    @SerialName("nat")
    val nat: String,
)

@Serializable
data class Name(
    @SerialName("title")
    val title: String,
    @SerialName("first")
    val first: String,
    @SerialName("last")
    val last: String
) {
    fun getFullName(): String {
        return this.last + this.first
    }
}

@Serializable
data class Location(
    @SerialName("street")
    val street: Street,
    @SerialName("city")
    val city: String,
    @SerialName("state")
    val state: String,
    @SerialName("postcode")
    val postcode: String,
    @SerialName("coordinates")
    val coordinates: Coordinates,
    @SerialName("timezone")
    val timezone: Timezone
)

@Serializable
data class Street(
    @SerialName("number")
    val number: Int,
    @SerialName("name")
    val name: String,
)

@Serializable
data class Coordinates(
    @SerialName("latitude")
    val latitude: String,
    @SerialName("longitude")
    val longitude: String,
)

@Serializable
data class Timezone(
    @SerialName("offset")
    val offset: String,
    @SerialName("description")
    val description: String,
)

@Serializable
data class Login(
    @SerialName("uuid")
    val uuid: String,
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String,
    @SerialName("salt")
    val salt: String,
    @SerialName("md5")
    val md5: String,
    @SerialName("sha256")
    val sha256: String,
    @SerialName("sha1")
    val sha1: String
)

@Serializable
data class Dob(
    @SerialName("date")
    val date: String,
    @SerialName("age")
    val age: Int,
)

@Serializable
data class Registered(
    @SerialName("date")
    val date: String,
    @SerialName("age")
    val age: Int,
)

@Serializable
data class Id(
    @SerialName("name")
    val name: String,
    @SerialName("value")
    val value: String?,
)

@Serializable
data class Picture(
    @SerialName("large")
    val large: String,
    @SerialName("medium")
    val medium: String,
    @SerialName("thumbnail")
    val thumbnail: String,
)