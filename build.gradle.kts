import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.21"

    //	Plugin do spring p/ fz o package dos jar/war, rodar a aplicação e usar o gerenciamento de dependencias do spring
    id("org.springframework.boot") version "2.5.3" apply false

    // Plugin que permite "abrir" um grupo de classes, pois no kotlin todas as classes são final por default.
    kotlin("plugin.allopen") version "1.5.21" apply false

    // Plugin que "abre" as classes com annotations do spring, pois no kotlin todas as classes são final por default.
    kotlin("plugin.spring") version "1.5.21" apply false

    //Permite usar propriedades non-nullable com o JPA
//	kotlin("kotlin-jpa") version "1.5.21" apply false
}

subprojects {
    version = "1.0.0"

    repositories {
        mavenCentral()
    }

    // Permite que o spring gerencie as dependencias de submodulos com base na versão do plugin spring
    apply {
        plugin("io.spring.dependency-management")
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_11.majorVersion
        targetCompatibility = JavaVersion.VERSION_11.majorVersion
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.4")
}
