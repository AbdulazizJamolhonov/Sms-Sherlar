package developer.abdulaziz.smssherlar.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import developer.abdulaziz.smssherlar.Cache.MyData
import developer.abdulaziz.smssherlar.Models.Poem
import developer.abdulaziz.smssherlar.R
import developer.abdulaziz.smssherlar.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        start1()
        start3()
        start4()
        start5()
        start6()
        start7()
        start8()

        binding.apply {

            countLikes.text = "${MyData.list2.size}"
            countNews.text = "${MyData.list1.size}"

            cardYangilar.setOnClickListener {
                findNavController().navigate(R.id.secondFragment, bundleOf("key" to 1))
            }
            cardSaqlanganlar.setOnClickListener {
                findNavController().navigate(R.id.secondFragment, bundleOf("key" to 2))
            }
            cardSevgiSherlari.setOnClickListener {
                findNavController().navigate(R.id.secondFragment, bundleOf("key" to 3))
            }
            cardSoginchArmon.setOnClickListener {
                findNavController().navigate(R.id.secondFragment, bundleOf("key" to 4))
            }
            cardTabrikSherlar.setOnClickListener {
                findNavController().navigate(R.id.secondFragment, bundleOf("key" to 5))
            }
            cardOtaOnaXaqida.setOnClickListener {
                findNavController().navigate(R.id.secondFragment, bundleOf("key" to 6))
            }
            cardDostlikSherlari.setOnClickListener {
                findNavController().navigate(R.id.secondFragment, bundleOf("key" to 7))
            }
            cardHazilSherlar.setOnClickListener {
                findNavController().navigate(R.id.secondFragment, bundleOf("key" to 8))
            }
        }

        return binding.root
    }
}

private fun start1() {
    if (MyData.list1.isEmpty()) {
        MyData.list1.add(
            Poem(
                "Yangisi", "Kuldirar o'ldirar bitta so'z\n" +
                        "Baht berar dard berar bitta do'st\n" +
                        "Sevdirar kuydirar bitta yor\n" +
                        "Chin sevgi bilmadim qayda bor", false
            )
        )
        MyData.list1.add(
            Poem(
                "So'radim", "Quyosh emas bir nur so'radim\n" +
                        "Yomg'irlardan bir gul so'radim\n" +
                        "O'zim uchun taqdir azaldan\n" +
                        "Xech kim yurmas bir yo'l so'radim", false
            )
        )
        MyData.list1.add(
            Poem(
                "Jannatim ONAM", "Жаннатни бағрида яширган гулим, \n" +
                        "Дўзахда тиллари куймас булбулим. \n" +
                        "Боласин қучганда чекинар ўлим, \n" +
                        "Дунё нафас олган ҳавосан ОНАМ... ", false
            )
        )
    }
}

private fun start3() {
    if (MyData.list3.isEmpty()) {
        MyData.list3.add(
            Poem(
                "Sensiz men...", "Sensiz men , go'yoki tushga o'xshayman,\n" +
                        "Uyg'onsam, lahzada ketaman o'chib,\n" +
                        "Qanoti lat yegan qushga o'xshayman,\n" +
                        "Dardlarga suyangan, uchishdan cho'chib.", false
            )
        )
        MyData.list3.add(
            Poem(
                "Ayon...", "Hislarimni aylamang ermak,\n" +
                        "Siyratimda qaynasa tug‘yon. \n" +
                        "Suratimga e’tibor bermang, \n" +
                        "Ko‘nglim faqat jafoga ayon. ", false
            )
        )
        MyData.list3.add(
            Poem(
                "Ey Yolg'onchilar", "Qaxrdosh yurakni ayting kim bilar\n" +
                        "U dilga sitamlar har on sanchilar\n" +
                        "Bu oxlar ortida kõzlar yaltirar\n" +
                        "Nega qiynalmaysiz Ey Yolģonchilar",
                false
            )
        )
    }
}

private fun start4() {
    if (MyData.list4.isEmpty()) {
        MyData.list4.add(
            Poem(
                "Sog'inding", "Soginding bilaman juda juda soginding\n" +
                        "Soginganin bildirib quyding sogintirmay\n" +
                        "Deymanu lekin bu hayotning sinovlaridan\n" +
                        "Ozga choram yoq ozga yolim yoq", false
            )
        )
        MyData.list4.add(
            Poem(
                "Sog'inch", "mehr izlab inson goho og'rinarkan\n" +
                        "og'ringanda Hayol surib ovinarkan\n" +
                        "taqdir uni olislardan sinaganda\n" +
                        "yurak qurg'ur yaqinlarni sog'inarkan", false
            )
        )
        MyData.list4.add(
            Poem(
                "Nega sizdan yo'q darak", "Ohlar chikib dilda faqat sog'inchning kuyi,\n" +
                        "sizni o'ylab paydo buldi azobning uyi,\n" +
                        "netayin men faqat sizga zor buldi yurak,\n" +
                        "kunlar o'tdi nega sizdan yuqdur darak.", false
            )
        )
    }
}

private fun start5() {
    if (MyData.list5.isEmpty()) {
        MyData.list5.add(
            Poem(
                "Otam", "Siz mening savlatim, siz mening faxrim.\n" +
                        "Ishonchli qalqonim, xayotga dalda.\n" +
                        "Xayotda takrorsiz, eng oliy baxtim.\n" +
                        "Tug'ilgan kuningiz bilan dada.", false
            )
        )
        MyData.list5.add(
            Poem(
                "Akam", "Sizdan ko'rkam yigit yo'q bu kun.\n" +
                        "Doim mag'rur, g'ururi butun.\n" +
                        "Qo'shilib barcha ezgu tilakka.\n" +
                        "Tug'ulgan kuningiz bilan aka.", false
            )
        )
        MyData.list5.add(
            Poem(
                "Singlim", "Senday dardkash, yo'qdir mehribon.\n" +
                        "Xarqanday xolatda saqlagan sirim.\n" +
                        "Seni yaxshi ko'raman ishon.\n" +
                        "Tug'ulgan kuning bilan singlim.", false
            )
        )
    }
}

private fun start6() {
    if (MyData.list6.isEmpty()) {
        MyData.list6.add(
            Poem(
                "Ota rizoligi", "Отанг бўлса қилгин хурмат,\n" +
                        "Мадор кетса бўлгин қувват.\n" +
                        "Бу дунёда билгин фарзанд,\n" +
                        "Хаётинг хам нурга тўлар,\n" +
                        "Отанг сендан рози бўлса.", false
            )
        )
        MyData.list6.add(
            Poem(
                "Onam", "Тўққиз ой вужудим вужудингизда.\n" +
                        "Кўтариб юрдингиз бир парча танам.\n" +
                        "Илк бора йиғладим қўлларингизда.\n" +
                        "Қувониб кўзга ёш олдингиз онам.", false
            )
        )
        MyData.list6.add(
            Poem(
                "Onang uchun", "Koz yoshlari dary bolib oqqanida\n" +
                        "Senga gozal kozi bilan boqqanida\n" +
                        "Boor mehrini sening uchun sochganida\n" +
                        "Nima qilding dostim bugun onang uchun", false
            )
        )
    }
}

private fun start7() {
    if (MyData.list7.isEmpty()) {
        MyData.list7.add(
            Poem(
                "Sinfdoshlarim", "Uxlab qolib darsga kechikkanlarim\n" +
                        "Kechikib ustozdan gap eshitganlarim\n" +
                        "Uy vazifani bajarmay ko'chirganlarim\n" +
                        "Hech sizni unutmayman SINFDOSHLARIM", false
            )
        )
        MyData.list7.add(
            Poem(
                "Chin Do'st", "Og'ir kunda tirgak do'st,\n" +
                        "Havotirda sergak do'st,\n" +
                        "100 ta dushman oldida,\n" +
                        "Qochmas aslo erkak do'st!", false
            )
        )
        MyData.list7.add(
            Poem(
                "Do'st", "Men qandayin do'st bo'ldim chin do'stim uchun,\n" +
                        "og'ir paytda do'stimni tashlab ketdim-a,\n" +
                        "o'ylamadim ahvoli ne kecharkan deb,\n" +
                        "shunchalar nomard do'st ekanman bildim.", false
            )
        )
    }
}

private fun start8() {
    if (MyData.list8.isEmpty()) {
        MyData.list8.add(
            Poem(
                "Mensizlikda sensizlik", "Mensizlikda sensizlik, sensizlikdachi?\n" +
                        "Sensizlikda mensizlik, mensizlikdachi\n" +
                        "Mensizlikda sensizlik, olam aro cheksizlik\n" +
                        "Sensizlik va mensizlik, to'xta o'zi kimsizlik?", false
            )
        )
        MyData.list8.add(
            Poem(
                "Xotin", "Bugun ishdan charchab keganman. \n" +
                        "Ich etimdan sovuq yeganman. \n" +
                        "Ishonaver uyim-joyim deganman. \n" +
                        "\"Uyda kam bor\" demagin xotin.", false
            )
        )
        MyData.list8.add(
            Poem(
                "Shaxarlik qiz", "O'qishda kursdoshim Oydin ustidan. \n" +
                        "Kulishdi birnechta shaxarlik g'alcha. \n" +
                        "Yupka kiyip kepti shimni ustidan. \n" +
                        "Sapogi o'ziga kattamush ancha.", false
            )
        )
    }
}