plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    namespace = "easemob.com.uniapp"
    compileSdk = 33

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
val GROUP_ID = "easemob.com.uniapp"
val ARTIFACT_ID = "jitpack-lib-sample"
val VERSION = "0.1.2"
publishing { // 发布配置
    publications { // 发布的内容
        register<MavenPublication>("uniapp-push") { // 注册一个名字为 release 的发布内容
            groupId = GROUP_ID
            artifactId = ARTIFACT_ID
            version = VERSION


            artifact("$buildDir/outputs/aar/${artifactId}-release.aar")
//            afterEvaluate { // 在所有的配置都完成之后执行
//                // 从当前 module 的 release 包中发布
//                from(components["release"])
//            }
        }
    }
}
