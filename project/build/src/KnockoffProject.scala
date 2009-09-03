import sbt._
import com.tristanhunt._


class KnockoffProject( info : ProjectInfo )
extends DefaultProject( info )
with    Literable {
    
    override def compileOptions = {
        List( MaxCompileErrors( 10 ), CompileOption("-unchecked") ) :::
        super.compileOptions.toList
    }
    
    Credentials(Path.userHome / ".ivy2" / ".credentials", log)

    val nexus = "tristanhunt" at "http://tristanhunt.com:8081/content/groups/public/"

    val ScalaTest = "org.scala-tools.testing" % "scalatest" % "0.9.5"
    
    override def managedStyle = ManagedStyle.Maven
    val publishTo = "tristanhunt releases" at "http://tristanhunt.com:8081/content/repositories/releases/"
}