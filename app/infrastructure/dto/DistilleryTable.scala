package infrastructure.dto
// AUTO-GENERATED Slick data model for table Distillery
trait DistilleryTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table Distillery
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(50,true) */
  case class DistilleryRow(id: Int, name: String)
  /** GetResult implicit for fetching DistilleryRow objects using plain SQL queries */
  implicit def GetResultDistilleryRow(implicit e0: GR[Int], e1: GR[String]): GR[DistilleryRow] = GR{
    prs => import prs._
    DistilleryRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table distillery. Objects of this class serve as prototypes for rows in queries. */
  class Distillery(_tableTag: Tag) extends profile.api.Table[DistilleryRow](_tableTag, Some("whiskey"), "distillery") {
    def * = (id, name) <> (DistilleryRow.tupled, DistilleryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> DistilleryRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(50,true) */
    val name: Rep[String] = column[String]("name", O.Length(50,varying=true))
  }
  /** Collection-like TableQuery object for table Distillery */
  lazy val Distillery = new TableQuery(tag => new Distillery(tag))
}
