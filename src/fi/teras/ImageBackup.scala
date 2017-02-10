package fi.teras

import java.io.File

object Demo {

  final val months = Map(
    1 -> "01_tammi",
    2 -> "02_helmi",
    3 -> "03_maalis",
    4 -> "04_huhti",
    5 -> "05_touko",
    6 -> "06_kesa",
    7 -> "07_heina",
    8 -> "08_elo",
    9 -> "09_syys",
    1 -> "10_loka",
    1 -> "11_marras",
    12 -> "12_joulu")

  final def IMAGE_EXTENSION_PATTERN = "^*(jpg|JPG|png|PNG|gif|GIF|bmp|BMP)$"

  final def VIDEO_EXTENSION_PATTERN = "^*(avi|AVI|wmv|WMV|flv|FLV|mpg|MPG|mp4|MP4)$"

  def getExtension(path: String): String = "." + new File(path).getName().split(".").last

  def isImageFile(path: String): Boolean = getExtension(path).matches(IMAGE_EXTENSION_PATTERN)

  def isVideoFile(path: String): Boolean = getExtension(path).matches(VIDEO_EXTENSION_PATTERN)

  def main(args: Array[String]) = {
    println("Parameters: pathFrom: [" + args(0) + "] pathTo: [" + args(1) + "]")
    new File(args(0)).listFiles().filter {
      file => isImageFile(file.getName) || isVideoFile(file.getName)
    }.toList.foreach(println)
  }
}