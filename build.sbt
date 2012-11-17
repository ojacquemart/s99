name <<= submitProjectName(pname => "progfun-"+ pname)

version := "1.0.0"

scalaVersion := "2.9.2"

scalacOptions ++= Seq("-deprecation")

libraryDependencies += "org.scalatest" %% "scalatest" % "1.8" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

// This setting defines the project to which a solution is submitted. When creating a
// handout, the 'createHandout' task will make sure that its value is correct.
submitProjectName := "ninety-nine-problems"

// This setting allows to restrict the source files that are compiled and tested
// to one specific project. It should be either the empty string, in which case all
// projects are included, or one of the project names from the projectDetailsMap.
currentProject := ""

// Packages in src/main/scala that are used in every project. Included in every
// handout, submission.
commonSourcePackages += "common"

// Packages in src/test/scala that are used for grading projects. Always included
// compiling tests, grading a project.
gradingTestPackages += "grading"
