package galaxyraiders.core.game

import galaxyraiders.core.physics.Point2D
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@DisplayName("Given an explosion")
class ExplosionTest {
  private val explosion = Explosion(
    Point2D(1.0, 1.0),
    10.0
  )

  @Test
  fun `it has a type Explosion `() {
    assertEquals("Explosion", explosion.type)
  }

  @Test
  fun `it has a symbol asterisk `() {
    assertEquals('*', explosion.symbol)
  }

  @Test
  fun `it shows the type Explosion when converted to String `() {
    assertTrue(Explosion.toString().contains("Explosion"))
  }

  @Test
  fun `it can tick down`() {
    val exp = Explosion(Point2D(1.0, 1.0), 10.0)
    val initialTicks = exp.ticks
    exp.tick()

    val expectedTicks = initialTicks - 1
    assertEquals(expectedTicks, exp.ticks)
  }

  @Test
  fun `it can vanish`() {
    val exp = Explosion(Point2D(1.0, 1.0), 10.0)

    while (exp.ticks > 0) exp.tick()

    val expectedTicks = 0
    assertEquals(expectedTicks, exp.ticks)
    assertTrue { exp.hasVanished }
  }
}