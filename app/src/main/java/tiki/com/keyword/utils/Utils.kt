package tiki.com.keyword.utils

import android.graphics.Color

class Utils {
    companion object {
        fun getRandomColor(): Int {
            return Color.argb(255, (0..200).random(), (0..200).random(), (0..200).random())
        }

        fun getStringBreakLine(keyWord: String): String {
            val isTwoLine = keyWord.trimStart().trimEnd().contains(" ")
            if (isTwoLine) {

                for (i in 0 until keyWord.length) {
                    if (keyWord[i] == ' ') {
                        val pre = keyWord.substring(0, i)
                        val suf = keyWord.substring(i + 1, keyWord.length)
                        if (pre.length.div(suf.length) > 2 || suf.length.div(pre.length) < 2) {
                            return "$pre\n$suf"
                        }
                    }
                }
            }
            return keyWord
        }
    }
}
