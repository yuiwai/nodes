name := "nodes"
version := "0.1"
scalaVersion := "2.13.1"
enablePlugins(ScalaJSPlugin)
scalaJSUseMainModuleInitializer := true

resolvers += "yuiwai repo" at "https://s3-us-west-2.amazonaws.com/repo.yuiwai.com"
libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.7",
  "com.yuiwai" %%% "yachiyo-drawing-js-canvas" % "0.3.0-SNAPSHOT"
)
