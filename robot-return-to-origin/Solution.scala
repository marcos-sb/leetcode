object Solution {
  def judgeCircle(moves: String): Boolean = {
    var init = (0,0)
    def relativeDelta(move: Char): (Int,Int) = {
      move match {
        case 'U' => (-1, 0)
        case 'D' => ( 1, 0)
        case 'L' => ( 0,-1)
        case 'R' => ( 0, 1)
      }
    }

    moves.foreach(m => {
      val delta = relativeDelta(m)
      init = (init._1+delta._1, init._2+delta._2)
    })
    init == (0,0)
  }
}