// Ej12
fun joinToOptions(array: Array<String>): String =
    array.joinToString(prefix = "[", postfix = "]", separator = ",")

// Ej13
fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) =
    (if (toUpperCase) name.toUpperCase() else name) + number

// Ej14
fun String.decode(key: Int) = decode(this, key)
fun String.encode(key: Int) = encode(this, key)

// Ej15
fun String.removeFirstLastChar() =
    when {
      length <= 2 -> this
      else -> this.removeRangelength - 1 until length)
          .removeRange(0 until 1)
    }

// Ej16
fun Int.removeFirstLastDigit(): Int =
    this.toString().removeFirstLastChar().toInt()

// Ej17
infix fun Int.veces(num: Int) = this * num

// Ej18
class Pyramid {
  infix fun create(rows: Int) = createPyramid(rows)
}

// Ej19
fun testFiles(): Directory {

  val dirA = Directory("A")
  val dirB = Directory("B")

  val dirK = Directory("K")
  val dirL = Directory("L")
  val dirP = Directory("P")
  val dirQ = Directory("Q")

  val dirR = Directory("R")

  val file1 = File("f1.dat")
  val file2 = File("f2.dat")
  val file3 = File("f3.dat")
  val file4 = File("f4.dat")
  val file5 = File("f5.dat")
  val file6 = File("f6.dat")

  RootDirectory.add(dirA)
  RootDirectory.add(dirB)

  dirA.add(dirK)
  dirA.add(dirL)

  dirK.add(file1)
  dirK.add(dirR)

  dirR.add(file2)
  dirR.add(file3)

  dirL.add(file4)

  dirB.add(dirP)
  dirB.add(dirQ)

  dirP.add(file5)
  dirP.add(file6)

  RootDirectory.ls()

  return RootDirectory
}