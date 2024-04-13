/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.exceptions

import java.lang.Exception

class ColorResolverNotFoundException: Exception("Color Resolver wasn't found in messages.yml") {
}