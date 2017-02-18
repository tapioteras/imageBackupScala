package fi.teras

import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.time.Instant

object ImageBackup {

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

  def getExtension(path: String): String = new File(path).getName().split(".").last

  def getImageDateTaken(img: BufferedImage): Array[String] = img.getPropertyNames()

  //def copyFileTo(from: String, to: String): Boolean = copyTo()

  def main(args: Array[String]) = {
    println("Parameters: pathFrom: [" + args(0) + "] pathTo: [" + args(1) + "]")
    //new File(args(0)).listFiles().toList.foreach(copyFileTo(args(0), args(1)))
    new File(args(0)).listFiles().toList.foreach(file => {println(getImageDateTaken(ImageIO.read(file)))})
  }
}