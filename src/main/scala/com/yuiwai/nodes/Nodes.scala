package com.yuiwai.nodes

import com.yuiwai.yachiyo.core.RGB
import com.yuiwai.yachiyo.drawing.DrawingAction
import com.yuiwai.yachiyo.drawing.js.canvas.Drawing
import org.scalajs.dom
import org.scalajs.dom.raw.{CanvasRenderingContext2D, HTMLCanvasElement}

import scala.util.chaining._

object Nodes extends Drawing[Int] {
  def main(args: Array[String]): Unit = {
    val canvas = init()

    implicit val ctx: CanvasRenderingContext2D =
      canvas.getContext("2d").asInstanceOf[CanvasRenderingContext2D]
    (strokeStyle(RGB.Blue) ::
      fillStyle(RGB.Black) ::
      strokeLine(10, 10, 50, 30) ::
      strokeStyle(RGB.Red) ::
      strokeLine(10, 10, 50, 80) ::
      fillCircle(10, 10, 10) ::
      fillStyle(RGB.Black) ::
      fillCircle(30, 10, 10) ::
      strokeStyle(RGB.Green) ::
      strokeLine(100, 100, 250, 280) ::
      fillStyle(RGB.Blue) ::
      fillCircle(30, 30, 10) ::
      fillCircle(60, 30, 10) ::
      fillCircle(90, 30, 10) ::
      fillRect(100, 200, 100, 100) ::
      fillStyle(RGB.Red) ::
      fillRect(100, 100, 100, 100) ::
      fontStyle(20) ::
      fillText("test", 150, 250) ::
      fontStyle(30) ::
      fillText("test", 150, 350) ::
      Nil)
      .tap(execute)
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

trait Renderer[T] {
  def renderNode(node: Node[T]): List[DrawingAction[T]] = {
    // TODO impl
    Nil
  }
  def renderEdge(edge: Edge[T]): List[DrawingAction[T]] = {
    // TODO impl
    Nil
  }
}