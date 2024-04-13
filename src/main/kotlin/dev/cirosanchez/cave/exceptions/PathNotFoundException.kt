/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.exceptions

import java.lang.Exception

class PathNotFoundException(path: String) : Exception("$path wasn't found in messages.yml.")