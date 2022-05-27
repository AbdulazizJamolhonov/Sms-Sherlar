package developer.abdulaziz.smssherlar.Fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import developer.abdulaziz.smssherlar.Adapters.OnRVClicked
import developer.abdulaziz.smssherlar.Adapters.SherAdapter
import developer.abdulaziz.smssherlar.Cache.*
import developer.abdulaziz.smssherlar.Models.Poem
import developer.abdulaziz.smssherlar.R
import developer.abdulaziz.smssherlar.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.dialog_view.view.*

@SuppressLint("InflateParams", "SetTextI18n")
class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var rvList: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        rvList = binding.rvList

        binding.apply {
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }
            when (arguments?.getInt("key")) {
                1 -> {
                    binding.sherlarNomi.text = "YANGI\nSHERLAR"
                    rvList.adapter = SherAdapter(MyData.list1, object : OnRVClicked {
                        override fun onClick(position: Int) {
                            myItemClick(MyData.list1, position, true)
                        }
                    })
                }
                2 -> {
                    binding.sherlarNomi.text = "SAQLANGAN\nSHERLAR"
                    rvList.adapter = SherAdapter(MyData.list2, object : OnRVClicked {
                        override fun onClick(position: Int) {
                            myItemClick(MyData.list2, position, false)
                        }
                    })
                }
                3 -> {
                    binding.sherlarNomi.text = "SEVGI\nSHERLARI"
                    rvList.adapter = SherAdapter(MyData.list3, object : OnRVClicked {
                        override fun onClick(position: Int) {
                            myItemClick(MyData.list3, position, true)
                        }
                    })
                }
                4 -> {
                    binding.sherlarNomi.text = "SOG'INCH\nARMON"
                    rvList.adapter = SherAdapter(MyData.list4, object : OnRVClicked {
                        override fun onClick(position: Int) {
                            myItemClick(MyData.list4, position, true)
                        }
                    })
                }
                5 -> {
                    binding.sherlarNomi.text = "TABRIK\nSHERLARI"
                    rvList.adapter = SherAdapter(MyData.list5, object : OnRVClicked {
                        override fun onClick(position: Int) {
                            myItemClick(MyData.list5, position, true)
                        }
                    })
                }
                6 -> {
                    binding.sherlarNomi.text = "OTA-ONA XAQIDA\nSHERLARI"
                    rvList.adapter = SherAdapter(MyData.list6, object : OnRVClicked {
                        override fun onClick(position: Int) {
                            myItemClick(MyData.list6, position, true)
                        }
                    })
                }
                7 -> {
                    binding.sherlarNomi.text = "DO'STLIK\nSHERLARI"
                    rvList.adapter = SherAdapter(MyData.list7, object : OnRVClicked {
                        override fun onClick(position: Int) {
                            myItemClick(MyData.list7, position, true)
                        }
                    })
                }
                8 -> {
                    binding.sherlarNomi.text = "HAZIL\nSHERLAR"
                    rvList.adapter = SherAdapter(MyData.list8, object : OnRVClicked {
                        override fun onClick(position: Int) {
                            myItemClick(MyData.list8, position, true)
                        }
                    })
                }
            }
        }

        return binding.root
    }

    fun myItemClick(list: ArrayList<Poem>, position: Int, isList: Boolean) {
        val bottom = BottomSheetDialog(binding.root.context, R.style.NewDialog)
        val item =
            bottom.layoutInflater.inflate(R.layout.dialog_view, null, false)
        item.txt_dialog_name.text = list[position].name
        item.txt_dialog_text.text = list[position].matni
        if (list[position].like) {
            item.card_like_image.setImageResource(R.drawable.ic_sher_saqlanganda)
        } else {
            item.card_like_image.setImageResource(R.drawable.ic_love)
        }
        item.card_sms_dialog.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", list[position].matni)
            startActivity(intent)
        }
        item.card_like_dialog.setOnClickListener {
            if (isList) {
                if (!list[position].like) {
                    MyData.list2.add(
                        list[position]
                    )
                    bottom.cancel()
                    MyData.info = list
                    rvList.adapter?.notifyItemChanged(position)
                } else {
                    MyData.list2.removeAt(position)
                    bottom.cancel()
                    rvList.adapter?.notifyItemChanged(position)
                }
                list[position].like = !list[position].like
            } else {
                list.removeAt(position)
                MyData.info[position].like = !MyData.info[position].like
                bottom.cancel()
                rvList.adapter?.notifyItemRemoved(position)
            }
        }
        item.card_share_dialog.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Name: ${list[position].name}\n\n${list[position].matni}\n\nAuthor: Abdulaziz_Developer"
                )
                type = "text/plain"
            }
            startActivity(
                Intent.createChooser(sendIntent, list[position].name)
            )
        }
        item.card_copy_dialog.setOnClickListener {

        }
        bottom.setContentView(item)
        bottom.show()
    }
//    fun m(){
//        dialogViewBinding.cardSaqlanganDialog.setOnClickListener {
//            val index = Sherlar.saqlanganList.indexOf(sher)
//
//
//            val isFav = arguments?.getBoolean("isFav") ?: false
//
//            if (sher in Sherlar.saqlanganList) {
//                Sherlar.saqlanganList.remove(sher)
//                sherAdapter.notifyItemRemoved(index)
//
//
//                when (sher.category) {
//                    1 -> {
//                        val index = Sherlar.sevgiList.indexOf(sher)
//                        Sherlar.sevgiList[index].like = !Sherlar.sevgiList[index].like
//                    }
//                    2 -> {
//                        val index = Sherlar.soginchList.indexOf(sher)
//                        Sherlar.soginchList[index].like = !Sherlar.soginchList[index].like
//                    }
//                    3 -> {
//                        val index = Sherlar.tabrikList.indexOf(sher)
//                        Sherlar.tabrikList[index].like = !Sherlar.tabrikList[index].like
//                    }
//                    4 -> {
//                        val index = Sherlar.otaOnaList.indexOf(sher)
//                        Sherlar.otaOnaList[index].like = !Sherlar.otaOnaList[index].like
//                    }
//                    5 -> {
//                        val index = Sherlar.dostlikList.indexOf(sher)
//                        Sherlar.dostlikList[index].like = !Sherlar.dostlikList[index].like
//                    }
//                    6 -> {
//                        val index = Sherlar.hazilList.indexOf(sher)
//                        Sherlar.hazilList[index].like = !Sherlar.hazilList[index].like
//                    }
//                    7 -> {
//                        val index = Sherlar.yangilarList.indexOf(sher)
//                        Sherlar.yangilarList[index].like = !Sherlar.yangilarList[index].like
//                    }
//                }
//
//
//            } else {
//                val favSher = sher
//                favSher.like = true
//                Sherlar.saqlanganList.add(favSher)
//                sherAdapter.notifyItemInserted(Sherlar.saqlanganList.size - 1)
//            }
//
//            if (sher in Sherlar.saqlanganList) dialogViewBinding.ivSaqlanganDialog.setImageResource(
//                R.drawable.ic_sher_saqlanganda
//            )
//            else dialogViewBinding.ivSaqlanganDialog.setImageResource(R.drawable.ic_saqlanganlar)
//
//
////            favCount.text = "${Sherlar.saqlanganList.size}"
//        }
//    }
}