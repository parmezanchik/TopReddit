import android.net.Uri
import android.os.Parcelable
    import kotlinx.android.parcel.Parcelize

    @Parcelize
    data class RedditPost(
        val author: String,
        val created_utc: Long,
        val thumbnail: String,
        val num_comments: Int,
        val url: String, // URL зображення, якщо є,
        val uri: Uri? = Uri.parse(url)
    ) : Parcelable