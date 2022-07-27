package galaxyraiders.core.game

import galaxyraiders.core.physics.Object2D
import galaxyraiders.core.physics.Point2D
import galaxyraiders.core.physics.Vector2D
import kotlin.math.max

class Explosion(
  initialPosition: Point2D,
  radius: Double,
  ticks: Int = 30
) : SpaceObject("Explosion", '*', initialPosition, Vector2D(0.0, 0.0), radius, 0.0) {

  val hasVanished: Boolean
    get() = ticks == 0

  companion object {
    fun of(something: Object2D): Explosion {
      val position = Point2D(
        something.center.x - something.radius,
        something.center.y
      )
      val radius = something.radius * 2

      return Explosion(position, radius)
    }
  }

  var ticks: Int = ticks
    private set

  fun tick() {
    ticks = max(0, ticks - 1)
  }

}
