package com.jetbrains.datalore.plot.dsl

import com.jetbrains.datalore.plot.PlotAssert.Companion.assertThat
import org.junit.Test

class PlotDslTest {

    @Test
    fun `empty plot`() {
        var p = ggplot()
        assertThat(p).features().length(0)

        p = ggplot {}
        assertThat(p).features().length(0)
    }

    @Test
    fun `empty plot with mapping`() {
        var p = ggplot(mapping = { x = "X"; y = "Y" })
        assertThat(p).features().length(0)
        assertThat(p).mapping()
            .contains("x", "X")
            .contains("y", "Y")

        p = ggplot { alpha = "A"; group = "G" }
        assertThat(p).features().length(0)
        assertThat(p).mapping()
            .contains("alpha", "A")
            .contains("group", "G")

        p = ggplot { color = "C"; fill = "F" }
        assertThat(p).features().length(0)
        assertThat(p).mapping()
            .contains("color", "C")
            .contains("fill", "F")
    }

    @Test
    fun `plot with layer and mapping`() {
        val p = ggplot() + geom_point({ x = "X"; color = "C" })
        assertThat(p).layers()
            .length(1)
            .get(0).mapping()
            .contains("x", "X")
            .contains("color", "C")
    }
}