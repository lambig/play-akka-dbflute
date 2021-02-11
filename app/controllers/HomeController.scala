package controllers

import infrastructure.dto.Tables._
import javax.inject._
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.libs.json.Json
import play.api.mvc._
import slick.jdbc.MySQLProfile
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(
                                protected val dbConfigProvider: DatabaseConfigProvider,
                                controllerComponents: ControllerComponents)
                              (implicit executionContext: ExecutionContext)
  extends AbstractController(controllerComponents)
    with HasDatabaseConfigProvider[MySQLProfile] {
  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action.async {

    implicit request: Request[AnyContent] =>
      val action = Whiskey join Distillery on (_.distillery === _.id)
      db
        .run(action.result)
        .map(whiskeyDetails =>
          Ok(
            Json.obj(
              "Whiskies" ->
                whiskeyDetails
                  .map {
                    case (whiskey, distillery) =>
                      Json.obj("Name" -> whiskey.name, "Distillery" -> distillery.name)
                  })))
        .recover {
          case exception: Exception => InternalServerError(exception.getMessage)
        }
  }
}
