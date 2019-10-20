import DependencySettings._

val settingsHelper = ProjectSettingsHelper("au.id.tmm","http-constants")()

settingsHelper.settingsForBuild

lazy val root = project
  .in(file("."))
  .settings(settingsHelper.settingsForRootProject)
  .settings(console := (console in Compile in core).value)
  .aggregate(
    core,
    argonaut,
    circe,
  )

lazy val core = project
  .in(file("core"))
  .settings(settingsHelper.settingsForSubprojectCalled("core"))

lazy val argonaut = project
  .in(file("argonaut"))
  .settings(settingsHelper.settingsForSubprojectCalled("argonaut"))
  .settings(argonautDependency)
  .dependsOn(core)

lazy val circe = project
  .in(file("circe"))
  .settings(settingsHelper.settingsForSubprojectCalled("circe"))
  .settings(circeDependency)
  .dependsOn(core)

addCommandAlias("check", ";+test;scalafmtCheckAll")
addCommandAlias("cover", ";clean;coverage;test;coverageAggregate")
