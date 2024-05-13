package com.statebirdandanimals

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.statebirdandanimals.databinding.ActivityStateBirdAnimalBinding
import com.statebirdandanimals.databinding.StateImgListBinding
import com.statebirdandanimals.model.StateModel

class StateBirdAnimalActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityStateBirdAnimalBinding.inflate(layoutInflater)
    }
    private lateinit var stateInfoList: ArrayList<StateModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        stateInfoList = arrayListOf()

        stateInfoList.add(
            StateModel(stateName = "Andaman & Nicobar Islands", stateImage = R.drawable.andaman)
        )
        stateInfoList.add(
            StateModel(stateName = "Andhra Pradesh", stateImage = R.drawable.andhra_pradesh)
        )
        stateInfoList.add(
            StateModel(stateName = "Assam", stateImage = R.drawable.assam)
        )
        stateInfoList.add(
            StateModel(stateName = "Bihar", stateImage = R.drawable.bihar)
        )
        stateInfoList.add(
            StateModel(stateName = "Chandigarh", stateImage = R.drawable.chandigarh)
        )
        stateInfoList.add(
            StateModel(stateName = "Chhattisgarh", stateImage = R.drawable.chattisgarh)
        )
        stateInfoList.add(
            StateModel(stateName = "dadra and nagar haveli", stateImage = R.drawable.dadra_nagar)
        )
        stateInfoList.add(
            StateModel(stateName = "Daman Diu", stateImage = R.drawable.daman_diu)
        )
        stateInfoList.add(
            StateModel(stateName = "Delhi", stateImage = R.drawable.delhi)
        )
        stateInfoList.add(
            StateModel(stateName = "Goa", stateImage = R.drawable.goa)
        )
        stateInfoList.add(
            StateModel(stateName = "Gujarat", stateImage = R.drawable.gujarat)
        )
        stateInfoList.add(
            StateModel(stateName = "Haryana", stateImage = R.drawable.haryana)
        )
        stateInfoList.add(
            StateModel(stateName = "Himachal Pradesh", stateImage = R.drawable.himachal_pradesh)
        )
        stateInfoList.add(
            StateModel(stateName = "Jammu & Kashmir", stateImage = R.drawable.jammu_kashmir)
        )
        stateInfoList.add(
            StateModel(stateName = "Jharkhand", stateImage = R.drawable.jharkhand)
        )
        stateInfoList.add(
            StateModel(stateName = "Karnataka", stateImage = R.drawable.karnataka)
        )
        stateInfoList.add(
            StateModel(stateName = "Kerala", stateImage = R.drawable.kerala)
        )
        stateInfoList.add(
            StateModel(stateName = "Lakshwadeep", stateImage = R.drawable.lakshwadeep)
        )
        stateInfoList.add(
            StateModel(stateName = "Madhya Pradesh", stateImage = R.drawable.madhya_pradesh)
        )
        stateInfoList.add(
            StateModel(stateName = "Maharashtra", stateImage = R.drawable.maharashtra)
        )
        stateInfoList.add(
            StateModel(stateName = "Manipur", stateImage = R.drawable.manipur)
        )
        stateInfoList.add(
            StateModel(stateName = "Meghalaya", stateImage = R.drawable.meghalaya)
        )
        stateInfoList.add(
            StateModel(stateName = "Mizoram", stateImage = R.drawable.mizoram)
        )
        stateInfoList.add(
            StateModel(stateName = "Nagaland", stateImage = R.drawable.nagaland)
        )
        stateInfoList.add(
            StateModel(stateName = "Odisha", stateImage = R.drawable.odisha)
        )
        stateInfoList.add(
            StateModel(stateName = "Pondicherry", stateImage = R.drawable.puducherry)
        )
        stateInfoList.add(
            StateModel(stateName = "Punjab", stateImage = R.drawable.punjab)
        )
        stateInfoList.add(
            StateModel(stateName = "Rajasthan", stateImage = R.drawable.rajasthan)
        )
        stateInfoList.add(
            StateModel(stateName = "Sikkim", stateImage = R.drawable.sikkim)
        )
        stateInfoList.add(
            StateModel(stateName = "Tamil Nadu", stateImage = R.drawable.tamil_nadu)
        )
        stateInfoList.add(
            StateModel(stateName = "Telangana", stateImage = R.drawable.telengana)
        )
        stateInfoList.add(
            StateModel(stateName = "Tripura", stateImage = R.drawable.tripura)
        )
        stateInfoList.add(
            StateModel(stateName = "Uttar Pradesh", stateImage = R.drawable.uttar_pradesh)
        )
        stateInfoList.add(
            StateModel(stateName = "Uttarakhand", stateImage = R.drawable.uttrakhand)
        )
        stateInfoList.add(
            StateModel(
                stateName = "West Bengal",
                stateImage = R.drawable.wb,
                stateBirdName = "White-breasted Kingfisher",
                stateBirdInfo = "Halcyon smyrnensis(Linnaeus, 1758)",
                stateBirdImg = R.drawable.wb_bird,
                stateAnimalName = "Fishing cat/ Mecho biral",
                stateAnimalInfo = "Prionailurus viverrinus(Bennett, 1833)",
                stateAnimalImg = R.drawable.wb_animal
            )
        )

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        val stateImageAdapter = StateImageAdapter()
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerState.also {
            it.adapter = stateImageAdapter
            it.layoutManager = layoutManager
        }
    }

    inner class StateImageAdapter : RecyclerView.Adapter<StateImageAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding =
                StateImgListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )

            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            Glide.with(this@StateBirdAnimalActivity).load(stateInfoList[position].stateImage)
                .into(holder.binding.imgState)

            holder.binding.txtState.setText(stateInfoList[position].stateName)

        }

        override fun getItemCount(): Int {
            return stateInfoList.size
        }

        inner class ViewHolder(val binding: StateImgListBinding) :
            RecyclerView.ViewHolder(binding.root),
            View.OnClickListener {

            init {
                itemView.setOnClickListener(this)
            }

            override fun onClick(view: View) {
                Intent(this@StateBirdAnimalActivity, StateBirdAnimalDetailsActivity::class.java).also {
                    it.putExtra("STATE_NAME", stateInfoList[adapterPosition].stateName)
                    it.putExtra("STATE_IMAGE", stateInfoList[adapterPosition].stateImage)
                    it.putExtra("BIRD_INFO", stateInfoList[adapterPosition].stateBirdInfo)
                    it.putExtra("BIRD_NAME", stateInfoList[adapterPosition].stateBirdName)
                    it.putExtra("BIRD_IMG", stateInfoList[adapterPosition].stateBirdImg)
                    it.putExtra("ANIMAL_INFO", stateInfoList[adapterPosition].stateAnimalInfo)
                    it.putExtra("ANIMAL_NAME", stateInfoList[adapterPosition].stateAnimalName)
                    it.putExtra("ANIMAL_IMAGE", stateInfoList[adapterPosition].stateAnimalImg)
                    startActivity(it)
                }
            }
        }
    }

}