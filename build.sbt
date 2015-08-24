name          := "parsers"
organization  := "eu.rtkaczyk"
version       := "0.1"
scalaVersion  := "2.11.7"
scalacOptions := Seq("-unchecked", "-feature", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators"     % "1.0.4",
  "org.scalatest"          %% "scalatest"                    % "2.2.4"      % "test"
)

assemblyJarName in assembly := s"${name.value}.jar"
crossPaths := false