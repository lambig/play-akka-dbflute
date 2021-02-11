package generators

import slick.codegen.SourceCodeGenerator

object SlickTableCodeGenerator extends App {
  SourceCodeGenerator.run(
    profile = "slick.jdbc.PostgresProfile",
    jdbcDriver = "com.mysql.cj.jdbc.Driver",
    url = "jdbc:mysql://localhost:49156/whiskey",
    outputDir = "src/main/scala/",
    pkg = "infrastructure.whiskey",
    user = Some("root"),
    password = Some("mypassword"),
    ignoreInvalidDefaults = true,
    outputToMultipleFiles = true
  )
}