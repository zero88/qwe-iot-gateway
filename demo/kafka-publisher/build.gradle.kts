import io.github.zero88.qwe.gradle.app.task.SystemdServiceExtension.Arch

dependencies {
    api(project(":connector:kafka"))
}

docker {
    qweApplication {
        enabled.set(true)
        dockerfile {
            ports.set(listOf(8888, 5000))
        }
    }
}

qwe {
    application.set(true)
    app {
        logging {
            otherLoggers.set(mapOf("kafka" to "info"))
        }
        systemd {
            enabled.set(true)
            arch.set(Arch.ARM_V7)
            workingDir.set("/app/qwe-kafka-publisher")
            serviceName.set("qwe-kafka-publisher")
            configFile.set("config.json")
        }
    }
}