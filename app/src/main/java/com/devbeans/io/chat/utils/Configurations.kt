package com.devbeans.io.chat.utils

import com.devbeans.io.chat.network.Config
import com.devbeans.io.chat.utils.Configurations.Environments
import com.devbeans.io.chat.utils.Configurations
import okhttp3.CertificatePinner
import java.lang.Exception
import java.nio.charset.StandardCharsets
import java.util.*

object Configurations {
    val environment = Environments.Development
    const val DB_VERSION: Long = 1
    const val PIN = "sha256/t1UYWLBeg+bdSqKQBRGxB6yIg+dAwyXSdWkStwJ6JWU="
    val isProduction: Boolean
        get() {
            val isProduction: Boolean
            isProduction = try {
                environment == Environments.Production
            } catch (e: Exception) {
                false
            }
            return isProduction
        }


    val certPinner: CertificatePinner
        get() {
            return CertificatePinner.Builder()
                .add(
                    "int-chatapp.devbeans.io",
                    PIN
                )
                .add(
                    "int-websocket.devbeans.io",
                    PIN
                ).add(
                    "int-kds.devbeans.io",
                    PIN
                )
                .add(
                    "stage-chatapp.devbeans.io",
                    PIN
                )
                .add(
                    "stage-websocket.devbeans.io",
                    PIN
                ).add(
                    "stage-kds.devbeans.io",
                    PIN
                )
                .build()
        }


    val isDevelopment: Boolean
        get() {
            val isDevelopment: Boolean
            isDevelopment = try {
                environment == Environments.Development
            } catch (e: Exception) {
                false
            }
            return isDevelopment
        }


    val isLocal: Boolean
        get() {
            val isLocal: Boolean
            isLocal = try {
                environment == Environments.Local
            } catch (e: Exception) {
                false
            }
            return isLocal
        }


    val baseUrl: String?
        get() = if (environment == Environments.Development) {
            val decode =
                Base64.getDecoder().decode(Config.DEVELOPMENT)
            String(decode, StandardCharsets.UTF_8)
        } else null


    val kDSBaseUrl: String?
        get() = if (environment == Environments.Development) {
            val decode = Base64.getDecoder().decode(Config.KDS)
            String(decode, StandardCharsets.UTF_8)
        } else null


    val pingKDSUrl: String?
        get() = if (environment == Environments.Development) {
            val decode =
                Base64.getDecoder().decode(Config.PING_KDS)
            String(decode, StandardCharsets.UTF_8)
        } else null


    val pingDevelopmentUrl: String?
        get() = if (environment == Environments.Development) {
            val decode = Base64.getDecoder()
                .decode(Config.PING_DEVELOPMENT)
            String(decode, StandardCharsets.UTF_8)
        } else null


    val mqttBroker: String?
        get() = if (environment == Environments.Development) {
            val decode =
                Base64.getDecoder().decode(Config.MQTT_BROKER)
            String(decode, StandardCharsets.UTF_8)
        } else null


    val mqttPort: Int
        get() = if (environment == Environments.Development) {
            Config.MQTT_PORT
        } else 0


    val uploadsUrl: String?
        get() = if (environment == Environments.Development) {
            val decode =
                Base64.getDecoder().decode(Config.UPLOADS)
            String(decode, StandardCharsets.UTF_8)
        } else null


    val webSocketURL: String?
        get() = if (environment == Environments.Development) {
            val decode = Base64.getDecoder()
                .decode(Config.WEB_SOCKET_BASE_URL)
            String(decode, StandardCharsets.UTF_8)
        } else null


    val baseUploadsUrl: String?
        get() = if (environment == Environments.Development) {
            val decode =
                Base64.getDecoder().decode(Config.BASE_UPLOADS)
            String(decode, StandardCharsets.UTF_8)
        } else null


    val envName: String
        get() = environment.toString()

    enum class Environments {
        Development, Production, Local
    }
}