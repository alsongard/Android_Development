/*
 * Create a class that can represent the structure of a song. The Song class must include these code elements:

    Properties for the title, artist, year published, and play count
    A property that indicates whether the song is popular. If the play count is less than 1,000, consider it unpopular.
    A method that prints a song description in this format:

"[Title], performed by [artist], was released in [year published]."
*/

fun main()
{
    var firstSong = Songs("Quality over Quantity", "Polog", "2025", 1001)
	firstSong.checkPopularity()
	firstSong.songDescription()
}
class Songs(var title:String, var artist:String, var yearPublished:String, var playCount:Int)
{
	var checkPopularity = {
        if (playCount < 1000)
        {
            println("Song is unpopular")
        }
    }
    fun songDescription()
    {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}


