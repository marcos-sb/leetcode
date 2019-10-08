object Solution {
  val daysMonth = Array(31,28,31,30,31,30,31,31,30,31,30,31)
  val daysWeek = Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
  def dayOfTheWeek(day: Int, month: Int, year: Int): String = {
    var leaps = (year - 1968) / 4
    if (year >= 2100) leaps -= 1
    if (leapYear(year)) leaps -= 1
    val plusOne = if (leapYear(year) && month > 2) 1 else 0
    val daysYearSoFar = daysMonth.take(month-1).sum + plusOne + day
    val days = (year - 1971) * 365 + leaps + daysYearSoFar
    val day0 = 5 //Friday
    daysWeek((days + day0 - 1) % 7)
  }
  def leapYear(year: Int): Boolean = {
    if (year % 400 == 0) return true
    if (year % 100 == 0) return false
    if (year % 4   == 0) return true
    return false
  }
}