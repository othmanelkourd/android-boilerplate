plugins {
  id("idea")
  id("java-library")
  kotlin("jvm")
}

dependencies {
  // ---------------------------------------------------------------------------------------------
  // Kotlin
  // ---------------------------------------------------------------------------------------------
  implementation(kotlin("stdlib"))

  // ---------------------------------------------------------------------------------------------
  // Libraries
  // ---------------------------------------------------------------------------------------------
  implementation(Dependencies.gson)
  implementation(Dependencies.rxJava)
  implementation(Dependencies.retrofit2) { exclude(module = "okhttp") }
  implementation(Dependencies.retrofitGsonConverter) {
    exclude(module = "retrofit")
    exclude(module = "gson")
  }
  implementation(Dependencies.retrofitRxJavaAdapter) { exclude(module = "retrofit") }
  implementation(Dependencies.okhttp3)

  // ---------------------------------------------------------------------------------------------
  // Test Libs
  // ---------------------------------------------------------------------------------------------
  testImplementation(TestDependencies.junit5Api)
  testRuntimeOnly(TestDependencies.junit5Engine)
  testImplementation(TestDependencies.mockito)
  testImplementation(TestDependencies.hamcrestAll)
  testImplementation(TestDependencies.requestMatcher)
  testImplementation(TestDependencies.okhttp3MockWebserver)
  testImplementation(TestDependencies.jsonPathAssert)
}
