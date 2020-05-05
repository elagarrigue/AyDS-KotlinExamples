import java.lang.Float.NaN

// Ej1
fun main(args: Array<String>) {
  println("Hello World")
}

// Ej2 remainder
fun esPar(n: Int) = n % 2 == 0
fun esPar2(n: Int) = n.rem(2) == 0

// Ej3
fun esBisiesto(n: Int) = (n % 4 == 0) && (n % 100 != 0 || n % 400 == 0)

// Ej4
fun sumaN(n: Int): Int {
  var sum = 0
  for (i in 0..n) {
    sum += i
  }

  return sum
}

// Ej5
fun primerosPrimos(i: Int, j: Int, n: Int) {
  for (k in 1..n) {
    if (k % i == 0 || k % j == 0) println(k)
  }
}

// Ej6
fun tabla(n: Int) {
  for (i in 0..12) {
    println("$n x $i = ${n * i}")
  }
}

// Ej7
fun esPrimo(n: Int): Boolean =
    when {
      n <= 0 -> false
      else -> {
        var esPrimo = true
        for (i in n - 1 downTo 2 step 1) {
          if (n % i == 0) esPrimo = false
        }
        esPrimo
      }
    }

// Ej8
fun fizzBuzz() {
  for (i in 1..100)
    println(
        when {
          i % 3 == 0 && i % 5 == 0 -> "FizzBuzz"
          i % 3 == 0 -> "Fizz"
          i % 5 == 0 -> "Buzz"
          else -> i
        }
    )
}

// Ej9
fun divNan(n: Int, m: Int): Float =
    try {
      (n / m).toFloat()
    } catch (e: ArithmeticException) {
      NaN
    }

// Ej10
fun encode(s: String, key: Int): String {

  var encoded = ""

  val sUpper = s.toUpperCase()

  for (i in 0 until s.length)
    encoded +=
      when {
        sUpper[i] !in 'A'..'Z' -> sUpper[i]
        else -> {
          val c: Char = sUpper[i] + key
          if (c > 'Z')
            'A' + (c - 'Z') - 1
          else
            c
        }
      }
  return encoded

}

fun decode(s: String, key: Int): String {

  var decoded = ""

  val sUpper = s.toUpperCase()

  for (i in 0 until s.length) {
    decoded +=
        when {
          sUpper[i] !in 'A'..'Z' -> sUpper[i]
          else -> {
            val c: Char = sUpper[i] - key
            if (c < 'A')
              'Z' - ('A' - c) + 1
            else
              c
          }
        }
  }
  return decoded
}

// Ej11
fun createPyramid(rows: Int) {
  for (i in 0..rows) {

    for (j in 0 until rows - i) {
      print("  ")
    }

    for (j in 0 until (2 * i - 1)) {
      print("* ")
    }
    println()
  }
}