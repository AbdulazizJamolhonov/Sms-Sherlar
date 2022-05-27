package developer.abdulaziz.smssherlar.Cache

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import developer.abdulaziz.smssherlar.Models.Poem

object MyShared {
    private const val NAME = "my_cache_file"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var list: HashMap<ArrayList<ArrayList<Int>>, ArrayList<Poem>>
        get() = gsonStringToList(sharedPreferences.getString("keyList", "[]")!!)
        set(value) = sharedPreferences.edit {
            it.putString("keyList", listToGsonString(value))
        }

    private fun gsonStringToList(gsonString: String): HashMap<ArrayList<ArrayList<Int>>, ArrayList<Poem>> {
        val type = object : TypeToken<HashMap<ArrayList<ArrayList<Int>>, ArrayList<Poem>>>() {}.type
        return Gson().fromJson(gsonString, type)
    }

    private fun listToGsonString(list: HashMap<ArrayList<ArrayList<Int>>, ArrayList<Poem>>): String {
        return Gson().toJson(list)
    }
}