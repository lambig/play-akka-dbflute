package infrastructure.dto
// AUTO-GENERATED Slick data model for table SysConfig
trait SysConfigTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table SysConfig
   *  @param variable Database column variable SqlType(VARCHAR), PrimaryKey, Length(128,true)
   *  @param value Database column value SqlType(VARCHAR), Length(128,true), Default(None)
   *  @param setTime Database column set_time SqlType(TIMESTAMP)
   *  @param setBy Database column set_by SqlType(VARCHAR), Length(128,true), Default(None) */
  case class SysConfigRow(variable: String, value: Option[String] = None, setTime: Option[java.sql.Timestamp], setBy: Option[String] = None)
  /** GetResult implicit for fetching SysConfigRow objects using plain SQL queries */
  implicit def GetResultSysConfigRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[java.sql.Timestamp]]): GR[SysConfigRow] = GR{
    prs => import prs._
    SysConfigRow.tupled((<<[String], <<?[String], <<?[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table sys_config. Objects of this class serve as prototypes for rows in queries. */
  class SysConfig(_tableTag: Tag) extends profile.api.Table[SysConfigRow](_tableTag, "sys_config") {
    def * = (variable, value, setTime, setBy) <> (SysConfigRow.tupled, SysConfigRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(variable), value, setTime, setBy)).shaped.<>({r=>import r._; _1.map(_=> SysConfigRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column variable SqlType(VARCHAR), PrimaryKey, Length(128,true) */
    val variable: Rep[String] = column[String]("variable", O.PrimaryKey, O.Length(128,varying=true))
    /** Database column value SqlType(VARCHAR), Length(128,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("value", O.Length(128,varying=true), O.Default(None))
    /** Database column set_time SqlType(TIMESTAMP) */
    val setTime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("set_time")
    /** Database column set_by SqlType(VARCHAR), Length(128,true), Default(None) */
    val setBy: Rep[Option[String]] = column[Option[String]]("set_by", O.Length(128,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table SysConfig */
  lazy val SysConfig = new TableQuery(tag => new SysConfig(tag))
}
