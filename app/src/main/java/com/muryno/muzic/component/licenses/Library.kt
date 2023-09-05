package com.muryno.muzic.component.licenses

data class Library(val name: String, val url: String, val license: () -> String)