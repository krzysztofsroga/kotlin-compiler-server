package com.compiler.server.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonValue

@JsonIgnoreProperties(ignoreUnknown = true)
data class Project(
  val args: String = "",
  val files: List<ProjectFile> = listOf(),
  val confType: ProjectType = ProjectType.JAVA
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ProjectFile(
  val text: String = "",
  val name: String = "",
  val type: Type = Type.KOTLIN_FILE
)

enum class Type {
  KOTLIN_FILE,
  KOTLIN_TEST_FILE
}

enum class ProjectType(@JsonValue val id: String) {
  JAVA("java"),
  JUNIT("junit"),
  CANVAS("canvas"),
  JS("js")
}