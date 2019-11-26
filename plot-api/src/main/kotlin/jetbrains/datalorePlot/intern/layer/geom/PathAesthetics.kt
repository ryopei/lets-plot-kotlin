package jetbrains.datalorePlot.intern.layer.geom

import jetbrains.datalorePlot.intern.Options
import jetbrains.datalorePlot.intern.layer.OptionsCapsule

interface PathAesthetics : OptionsCapsule {
    val x: Any?
    val y: Any?
    val alpha: Any?
    val color: Any?
    val linetype: Any?
    val size: Any?
    val speed: Any?
    val flow: Any?

    override fun seal() = Options.of(
        "x" to x,
        "y" to y,
        "alpha" to alpha,
        "color" to color,
        "linetype" to linetype,
        "size" to size,
        "speed" to speed,
        "flow" to flow
    )
}