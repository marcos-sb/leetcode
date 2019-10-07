object Solution extends App {
  def numUniqueEmails(emails: Array[String]): Int = {
    val stopChars = Set('.','+')
    def go(_emails:List[String], uniq_emails:Set[String]): Int = _emails match {
      case Nil    => { println(uniq_emails); uniq_emails.size }
      case h :: t => go(t, uniq_emails ++ Set(flatten(h, stopChars)))
    }
    def flatten(s: String, stopChars: Set[Char]): String = {
      val sb = new StringBuilder
      var i = 0
      while (i < s.length) {
        var c = s(i)
        if (!stopChars.contains(c)) sb.append(c)
        else if (c == '+') {
          while (c != '@') { i+=1; c = s(i) }
          sb.append(s.drop(i))
          i = s.length-1
        }
        i += 1
      }
      sb.toString()
    }
    go(emails.toList, Set.empty)
  }
}

