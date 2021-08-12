import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("org.springframework.boot")

    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.allopen")
}

//"Abre" classes do JPA para que o Lazy fetching funcione da maneira esperada
//https://spring.io/guides/tutorials/spring-boot-kotlin
allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

dependencies {
    implementation(project(":client"))
    implementation(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:1.12.0")
}


//Defines the main class for run our app
//springBoot {
//    mainClass.set("com.example.demo.DemoApplication")
//}

tasks.test {
    useJUnitPlatform()
}

//tasks.register<BootRun>("bootRunDev") {
//    systemProperty("spring.profiles.active", "dev")
//    main(bootJar.mainClassName)
//    classpath(sourceSets.main.runtimeClasspath)
//}
//
//tasks.register<BootRun>("bootRunQa") {
//    systemProperty("spring.profiles.active", "qa")
//}
