object Solution {
  def distributeCandies(candies: Int, num_people: Int): Array[Int] = {
    val people = new Array[Int](num_people)
    var _candies = candies
    var i = 1
    while ((_candies - i) > 0) {
      people((i-1)%num_people) += i
      _candies -= i
      i += 1
    }
    people((i-1)%num_people) += _candies
    people
  }
}