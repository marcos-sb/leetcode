object Solution {
  def uniqueMorseRepresentations(words: Array[String]): Int = {
    if (words == null) 0
    else {
      val engLetters = 'a' to 'z'
      val morseCodes = Array(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
      val morseMap = engLetters.zip(morseCodes).toMap
      words.map( w => w.map ( morseMap(_) ).mkString ).toSet.size
    }
  }
}