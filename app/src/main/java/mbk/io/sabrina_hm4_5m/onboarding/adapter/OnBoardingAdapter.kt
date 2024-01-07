package mbk.io.sabrina_hm4_5m.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import mbk.io.sabrina_hm4_5m.OnBoardingModel
import mbk.io.sabrina_hm4_5m.databinding.ItemOnboardingBinding

class OnBoardingAdapter(private val onClick:()-> Unit): Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

private val list = arrayListOf<OnBoardingModel>(
    OnBoardingModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxBNOF8laaeXRX4FDMMMl5P7u53PJokTejdQ&usqp=CAU","Have a good time","You should take the time to help those who need you"),
    OnBoardingModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxBNOF8laaeXRX4FDMMMl5P7u53PJokTejdQ&usqp=CAU","Cherishing love","It is now no longer possible for you to cherish love"),
    OnBoardingModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxBNOF8laaeXRX4FDMMMl5P7u53PJokTejdQ&usqp=CAU","Have a breakup?","We have made the correction for you don't worry"),
    OnBoardingModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxBNOF8laaeXRX4FDMMMl5P7u53PJokTejdQ&usqp=CAU","It's Funs","and many more"),
)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(boarding: OnBoardingModel){
            binding.apply {
                boarding.apply {
                    tvTitle.text = title
                    tvDescription.text = description
                    Glide.with(img).load(boarding.image).into(img)
                }
                btnStart.isVisible = adapterPosition == list.lastIndex
                btnStart.setOnClickListener{onClick()}
            }
        }

    }
}