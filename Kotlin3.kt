fun main(args: Array<String>) {

}

val list = listOf("aece", "efg", "de")

// Ej20
fun sort1() {
  val sortedList = list.sorted()
  println(sortedList)
}

// Ej21
fun sort2() {
  val sortedList = list.sortedBy(String::length)

  println(sortedList)
}

// Ej22
fun sort3() {
  val sortedList = list.sortedBy {
    it.toList().filter { it == 'e' }.size
  }

  println(sortedList)
}

fun sort3B() {
  val numOfE = { s: String ->
    s.toList().filter { it == 'e' }.size
  }

  val sortedList = list.sortedBy(numOfE)

  println(sortedList)
}

fun sort3C() {

  val numOfChar = { s: String, c: Char ->
    s.toList().filter { it == c }.size
  }

  val sortedList = list.sortedBy { numOfChar(it, 'e') }

  println(sortedList)
}

// Ej23
fun esPrimo2a(n: Int): Boolean =
    when {
      n <= 0 -> false
      else ->
        (2 until n).filter { n % it == 0 }.isEmpty()
    }

fun esPrimo2b(n: Int): Boolean =
    when {
      n <= 0 -> false
      else ->
        (2 until n).none { n % it == 0 }
    }

// Ej24
fun frame() {

  val list = listOf("Hello", "World", "in", "a", "frame")

  val maxSize: Int = list.maxBy(String::length)?.length ?: 0

  println((maxSize + 4) times "*")
  list.forEach {
    println("* $it ${(maxSize - it.length) times " "}*")
  }
  println((maxSize + 4) times "*")
}

// Ej25
data class Book(val name: String, val authors: List<String>)

fun booksTest() {
  val books = listOf(
      Book("Thursday Next", listOf("Jasper Fforde")),
      Book("Mort", listOf("Terry Pratchett")),
      Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman")))

  println(books.flatMap { it.authors }.toSet())

  println(books.filter { it.authors.contains("Terry Pratchett") }.map { it.name })
}

// Ej26
fun listOfFiles(directory: Directory): List<File> {
  val files = mutableListOf<File>()
  directory.subFiles.forEach {
    when (it) {
      is File -> files.add(it)
      is Directory -> files.addAll(listOfFiles(it))
    }
  }
  return files
}

fun listOfFilesB(directory: Directory): List<File> =
    directory.subFiles.flatMap {
    when (it) {
      is File -> listOf(it)
      is Directory -> listOfFilesB(it)
    }
  }

// Ej27
fun searchInFiles(directory: Directory, term: String) : List<String>=
    listOfFiles(directory)
        .filter { it.name.contains(term) }
        .map { it.name }

// Ej28
// https://supersimpleonline.com/song/who-took-the-cookie/
fun cookiePlay() {
  with(

      listOf("Panda", "Rabbit", "Bear", "Penguin", "Kangaroo")
          .shuffled()
          .reduce { s1: String, s2: String ->
            println("Who took the cookie from the cookie jar?")
            println("$s1 took the cookie from the cookie jar.")
            println("Who me?\nYes, you!\nNot me!\nThen who?")
            println("$s2!")
            println()
            s2
          }
  ) {
    println("Who took the cookie from the cookie jar?")
    println("$this took the cookie from the cookie jar.")
    println("Who me?\nYes, you!\nOkay, okay… I took the cookie.")
  }
}

// Ej29
data class A(val b: String?, val c: Int?, val d: List<Boolean?>?)

fun testNullables() {

  val a1 = A("B1", null, null)
  val a2 = A(null, 2, null)
  val a3 = A(null, null, listOf(null, false, true, null))
  val a4 = A(null, null, null)

  val listA = listOf(a1, a2, a3, a4)

  listA.forEach {
    if (it.b != null) {
      println(it.b)
    } else if (it.c != null) {
      println(it.c)
    } else if (it.d != null) {
      it.d.forEach {
        if (it != null) {
          print(it)
        }
      }
      println()
    } else {
      println("all null")
    }
  }
}

fun testNullablesSimp() {

  val a1 = A("B1", null, null)
  val a2 = A(null, 2, null)
  val a3 = A(null, null, listOf(null, false, true, null))
  val a4 = A(null, null, null)

  val listA = listOf(a1, a2, a3, a4)

  listA.forEach {
    it.b?.let { println(it) } ?: it.c?.let { println(it) } ?: it.d?.let {
      it.forEach { it?.let { print(it) } }
      println()
    } ?: println("all null")
  }
}


listOf(1, 2, 3, 4, 5)
    .reduce{ s1: Int, s2: Int -> s1 + s2 }