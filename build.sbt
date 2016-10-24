name := "paytm_platform_challenge_2"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.5"

resolvers += Resolver.mavenLocal
resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
