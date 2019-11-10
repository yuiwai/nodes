package com.yuiwai.nodes

import com.yuiwai.yachiyo.drawing.js.canvas.Drawing
import org.scalajs.dom
import org.scalajs.dom.raw.{CanvasRenderingContext2D, HTMLCanvasElement}

import scala.util.chaining._

object Nodes extends Drawing[Int] {
  def main(args: Array[String]): Unit = {
    val canvas = init()
    implicit val ctx: CanvasRenderingContext2D =
      canvas.getContext("2d").asInstanceOf[CanvasRenderingContext2D]
    ctx.fillStyle = "green"
    ctx.strokeStyle = "red"
    ctx.lineWidth = 3
    (drawLine(10, 10, 50, 30) ::
      drawLine(10, 10, 50, 80) ::
      drawCircle(10, 10, 10) ::
      drawCircle(30, 10, 10) ::
      drawCircle(30, 30, 10) ::
      drawCircle(60, 30, 10) ::
      drawCircle(90, 30, 10) ::
      drawRect(100, 100, 100, 100) ::
      Nil)
      .tap(execute)
    ctx.stroke()
    ctx.fill()
  }

  def init(): HTMLCanvasElement = {
    val canvas = dom.document.createElement("canvas").asInstanceOf[HTMLCanvasElement]
    canvas.setAttribute("width", dom.window.innerWidth.toString)
    canvas.setAttribute("height", dom.window.innerHeight.toString)
    dom.document.body.appendChild(canvas)
    canvas
  }
}

case class Node[T](x: Int, y: Int, width: Int, height: Int, content: T)
case class Edge[T](from: Node[T], to: Node[T])