import scala.concurrent.duration._

private class GitRepo

object Slides {

  ///////  Slide 1

  val goals = Seq(
    "Community building",
    "Opportunities to learn",
    "Gather best practices"
  )

  ///////  Slide 2

  val content = List(
    "Talk"    -> 10.minutes,
    "Coding"  ->  1.hour,
    "Summary" -> 20.minutes
  )
  // for complex topics we can send out reading materials in advance

  ///////  Slide 3

  case class Presenter(name: String, topic: String, exercise: GitRepo)

  def participate(you: Option[Presenter]): String = {
    you match {
      case Some(presenter) => s"Hey $presenter, let us know"
      case None => "You are welcome as participant"
    }
  }

}
