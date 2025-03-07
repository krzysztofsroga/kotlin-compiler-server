package com.compiler.server

import com.compiler.server.generator.TestProjectRunner
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JvmRunnerTest {

  @Autowired
  private lateinit var testRunner: TestProjectRunner

  @Test
  fun `base execute test JVM`() = testRunner.run(
    code = "fun main() {\n println(\"Hello, world!!!\")\n}",
    contains = "Hello, world!!!"
  )

  @Test
  fun `base execute test JVM multi`() = testRunner.multiRun(
    code = listOf(
      "import cat.Cat\n\nfun main(args: Array<String>) {\nval cat = Cat(\"Kitty\")\nprintln(cat.name)\n}",
      "package cat\n    class Cat(val name: String)"
    ),
    contains = "Kitty"
  )

  @Test
  fun `correct kotlin version test jvm`() = testRunner.run(
    code = "fun main() {\n    println(KotlinVersion?.CURRENT)\n}",
    contains = testRunner.getVersion().substringBefore("-")
  )

}
