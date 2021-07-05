plugins {
    val kotlinVersion = "1.4.30"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("net.mamoe.mirai-console") version "2.6.3"
}

group = "dev.horizonlight"
version = "0.1.0"

repositories {
    maven{ url =uri("https://maven.aliyun.com/nexus/content/groups/public/")}
    jcenter()
    mavenCentral()
    mavenLocal()
}
dependencies{
    implementation("junit:junit:4.13.1")
    implementation("com.google.code.gson:gson:2.8.7")
    implementation("org.jsoup:jsoup:1.13.1")
    implementation("cn.wanghaomiao:JsoupXpath:2.4.3")
    implementation("org.codehaus.jackson:jackson-core-asl:1.9.13")
    implementation("org.antlr:antlr4-runtime:4.7.2")

    //在IDE内运行的mcl添加滑块模块，请参考https://github.com/project-mirai/mirai-login-solver-selenium把版本更新为最新
    //runtimeOnly("net.mamoe:mirai-login-solver-selenium:1.0-dev-15")
}