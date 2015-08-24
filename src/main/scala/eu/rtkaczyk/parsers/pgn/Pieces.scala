package eu.rtkaczyk.parsers.pgn

object Pieces {

  sealed trait Piece {
    def repr = this match {
      case Pawn => "p"
      case Knight => "N"
      case Bishop => "B"
      case Rook => "R"
      case Queen => "Q"
      case King => "K"
    }
  }

  case object Pawn extends Piece
  case object Knight extends Piece
  case object Bishop extends Piece
  case object Rook extends Piece
  case object Queen extends Piece
  case object King extends Piece


  sealed trait Colour

  case object White extends Colour
  case object Black extends Colour
}
