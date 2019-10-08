object Solution {
  import scala.util.control.Breaks.{breakable, break}
  def numRookCaptures(board: Array[Array[Char]]): Int = {
    val rookPos = findRook(board)
    val deltas = Array((1,0),(-1,0),(0,1),(0,-1))
    var count = 0
    for (dp <- deltas) {
      var currPos = rookPos
      breakable {
        while ({
          currPos = (currPos._1+dp._1, currPos._2+dp._2)
          valid(board,currPos) && !bishop(board,currPos)
        }) {
          if (board(currPos._1)(currPos._2) == 'p') {
            count += 1
            break
          }
        }}
    }
    count
  }
  def findRook(board: Array[Array[Char]]): (Int,Int) = {
    for (r <- board.indices; c <- board(0).indices) {
      if (board(r)(c) == 'R')
        return (r,c)
    }
    return (-1,-1)
  }
  def valid(board: Array[Array[Char]], pos: (Int,Int)): Boolean = {
    return pos._1 < board.length &&
      pos._2 < board(0).length &&
      pos._1 > 0 && pos._2 > 0
  }
  def bishop(board: Array[Array[Char]], pos: (Int,Int)): Boolean = {
    return board(pos._1)(pos._2) == 'B'
  }
}