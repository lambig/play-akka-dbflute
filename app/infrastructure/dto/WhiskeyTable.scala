package infrastructure.dto
// AUTO-GENERATED Slick data model for table Whiskey
trait WhiskeyTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table Whiskey
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(50,true)
   *  @param distillery Database column distillery SqlType(INT) */
  case class WhiskeyRow(id: Int, name: String, distillery: Int)
  /** GetResult implicit for fetching WhiskeyRow objects using plain SQL queries */
  implicit def GetResultWhiskeyRow(implicit e0: GR[Int], e1: GR[String]): GR[WhiskeyRow] = GR{
    prs => import prs._
    WhiskeyRow.tupled((<<[Int], <<[String], <<[Int]))
  }
  /** Table description of table whiskey. Objects of this class serve as prototypes for rows in queries. */
  class Whiskey(_tableTag: Tag) extends profile.api.Table[WhiskeyRow](_tableTag, Some("whiskey"), "whiskey") {
    def * = (id, name, distillery) <> (WhiskeyRow.tupled, WhiskeyRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(distillery))).shaped.<>({r=>import r._; _1.map(_=> WhiskeyRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(50,true) */
    val name: Rep[String] = column[String]("name", O.Length(50,varying=true))
    /** Database column distillery SqlType(INT) */
    val distillery: Rep[Int] = column[Int]("distillery")
  }
  /** Collection-like TableQuery object for table Whiskey */
  lazy val Whiskey = new TableQuery(tag => new Whiskey(tag))
}
