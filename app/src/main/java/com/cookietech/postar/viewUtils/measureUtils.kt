package com.cookietech.postar.viewUtils

import android.content.res.Resources
import android.util.TypedValue




val Int.dp get() = this * Resources.getSystem().displayMetrics.density;
val Int.sp get() = this * Resources.getSystem().displayMetrics.scaledDensity;