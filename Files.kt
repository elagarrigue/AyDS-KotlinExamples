import java.lang.StringBuilder

sealed class FileSystemElement(var name: String) {
  abstract fun ls(level: Int = 0)
}

class File(fileName: String) : FileSystemElement(fileName) {

  override fun ls(level: Int) {
    println("${level times "- "}$name")
  }
}

open class Directory(directoryName: String) : FileSystemElement(directoryName) {

  private val subFiles = mutableListOf<FileSystemElement>()

  fun add(obj: FileSystemElement) {
    subFiles.add(obj)
  }

  override fun ls(level: Int) {
    println("${level times "- "}$name/")
    subFiles.forEach {
      it.ls(level + 1)
    }
  }
}

object RootDirectory : Directory(".")

infix fun Int.times(string: String): String {
  val text = StringBuilder()
  for (i in 0..this) {
    text.append(string)
  }
  return text.toString()
}