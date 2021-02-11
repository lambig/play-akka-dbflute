package generators

import slick.codegen.SourceCodeGenerator

object SlickTableCodeGenerator extends App {
  SourceCodeGenerator.run(
    profile = "slick.jdbc.MySQLProfile",
    jdbcDriver = "com.mysql.cj.jdbc.Driver",
    url = "jdbc:mysql://localhost:49156/whiskey",
    outputDir = "app/",
    pkg = "infrastructure.dto",
    user = Some("root"),
    password = Some("mypassword"),
    ignoreInvalidDefaults = true,
    outputToMultipleFiles = true
  )
}