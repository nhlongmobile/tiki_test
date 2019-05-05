package tiki.com.keyword

import org.junit.Test

import org.junit.Assert.*
import tiki.com.keyword.utils.Utils

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class KeyWordUnitTest {
    @Test
    fun get_string_break_line_isCorrect() {
        assertEquals("xiaomi", Utils.getStringBreakLine("xiaomi"))
        assertEquals("bitis\nhunter", Utils.getStringBreakLine("bitis hunter"))
        assertEquals("bts", Utils.getStringBreakLine("bts"))
        assertEquals("balo", Utils.getStringBreakLine("balo"))
        assertEquals("bitis\nhunter x", Utils.getStringBreakLine("bitis hunter x"))
        assertEquals("tai\nnghe", Utils.getStringBreakLine("tai nghe"))
        assertEquals("harry\npotter", Utils.getStringBreakLine("harry potter"))
        assertEquals("anker", Utils.getStringBreakLine("anker"))
        assertEquals("iphone", Utils.getStringBreakLine("iphone"))
        assertEquals("balo\nnữ", Utils.getStringBreakLine("balo nữ"))
        assertEquals("nguyễn\nnhật ánh", Utils.getStringBreakLine("nguyễn nhật ánh"))
        assertEquals("đắc nhân\ntâm", Utils.getStringBreakLine("đắc nhân tâm"))
        assertEquals("ipad", Utils.getStringBreakLine("ipad"))
        assertEquals("senka", Utils.getStringBreakLine("senka"))
        assertEquals("tai nghe\nbluetooth", Utils.getStringBreakLine("tai nghe bluetooth"))
        assertEquals("son", Utils.getStringBreakLine("son"))
        assertEquals("maybelline", Utils.getStringBreakLine("maybelline"))
        assertEquals("laneige", Utils.getStringBreakLine("laneige"))
        assertEquals("kem chống\nnắng", Utils.getStringBreakLine("kem chống nắng"))
        assertEquals("anh chính là\nthanh xuân của em", Utils.getStringBreakLine("anh chính là thanh xuân của em"))
    }
}
