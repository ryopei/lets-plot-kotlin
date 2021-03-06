/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package frontendContextDemo.scripts

import jetbrains.letsPlot.geom.geom_boxplot
import jetbrains.letsPlot.lets_plot
import frontendContextDemo.SwingJfxDemo
import kotlin.math.abs

object Boxplot {
    @JvmStatic
    fun main(args: Array<String>) {
        SwingJfxDemo.eval("Boxplot") {

            val categories = listOf("A", "B", "C", "D", "E")

            val n = 500
            val rand = java.util.Random()
            val data = mapOf<String, Any>(
                "val" to List(n) { rand.nextGaussian() },
                "cat" to List(n) { categories[abs(rand.nextInt()).rem(categories.size)] }
            )

            val p = lets_plot(data) { x = "cat"; y = "val" } + geom_boxplot(outlierColor = "red")
            p.show()
        }
    }
}
