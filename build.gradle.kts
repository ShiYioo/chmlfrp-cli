
plugins {
    kotlin("jvm") version "2.1.20"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "com.shiyi"
version = "2.2.0"


repositories {
    // 阿里云镜像优先，规避 Maven Central / GitHub Releases CDN 故障，国内构建也更快
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}


dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation(kotlin("reflect"))
    // https://mvnrepository.com/artifact/com.alibaba.fastjson2/fastjson2
    implementation("com.alibaba.fastjson2:fastjson2:2.0.57")
    // https://mvnrepository.com/artifact/cn.hutool/hutool-all
    implementation("cn.hutool:hutool-all:5.8.37")
    // https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    // https://mvnrepository.com/artifact/info.picocli/picocli
    implementation("info.picocli:picocli:4.7.7")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
tasks {
    shadowJar {
        archiveClassifier.set("")
        manifest {
            attributes["Main-Class"] = "com.shiyi.FrpClient"
        }
    }
}
