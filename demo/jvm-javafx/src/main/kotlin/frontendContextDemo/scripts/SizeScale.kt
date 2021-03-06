/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package frontendContextDemo.scripts

import jetbrains.letsPlot.geom.geom_point
import jetbrains.letsPlot.ggtitle
import jetbrains.letsPlot.lets_plot
import jetbrains.letsPlot.scale.scale_size
import jetbrains.letsPlot.scale.scale_size_area
import frontendContextDemo.SwingJfxDemo

object SizeScale {
    @JvmStatic
    fun main(args: Array<String>) {
        SwingJfxDemo.eval("Size Scale") {
            val dat = mapOf<String, Any>(
                "x" to (0..5).map { it },
                "y" to (0..5).map { 0 },
                "s" to (0..5).map { it }
            )

            val p = lets_plot(dat) + geom_point { x = "x"; y = "y"; size = "s" }

            // size ~= radius
            (p + scale_size(range = listOf(5, 50), guide = "none") + ggtitle("scale_size")).show()

            // size ~= radius where 0 size --> 0 radius
            (p + scale_size_area(max_size = 50, guide = "none") + ggtitle("scale_size_area")).show()
        }
    }
}