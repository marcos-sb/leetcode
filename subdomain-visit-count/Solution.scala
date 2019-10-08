object Solution {
  def subdomainVisits(cpdomains: Array[String]): List[String] = {
    cpdomains
      .flatMap(line => {
        val cd = line.split(" ")
        val ld = extractSubdomains(cd(1), List())
        val cl = for (_ <- 0 until ld.length) yield cd(0).toInt
        ld.zip(cl)})
      .groupBy(p => p._1)
      .mapValues(_.map{ case (d,c) => c}.sum)
      .toList.map(p => s"${p._2} ${p._1}")
  }
  def extractSubdomains(
                         domain: String, subdomains: List[String]
                       ): List[String] = {
    if (domain == "") return subdomains
    return extractSubdomains(
      domain.dropWhile(_ != '.').drop(1),
      domain::subdomains)
  }
}