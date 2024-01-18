package mbk.io.sabrina_hm4_5m.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.RecyclerView.Adapter
import mbk.io.sabrina_hm4_5m.OnBoardingModel
import mbk.io.sabrina_hm4_5m.R
import mbk.io.sabrina_hm4_5m.databinding.ItemOnboardingBinding

class OnBoardingAdapter(private val onClick:()-> Unit): Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

private val list = arrayListOf<OnBoardingModel>(
    OnBoardingModel(R.raw.anim_cat,"Have a good time","You should take the time to help those who need you"),
    OnBoardingModel(R.raw.anim_heart,"Cherishing love","It is now no longer possible for you to cherish love"),
    OnBoardingModel(R.raw.anim_sad,"Have a breakup?","We have made the correction for you don't worry"),
    OnBoardingModel(R.raw.anim_cloud,"It's Funs","and many more"),
)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding): ViewHolder(binding.root){

        fun bind(boarding: OnBoardingModel){
            binding.apply {
                boarding.apply {
                    tvTitle.text = title
                    tvDescription.text = description

                    boarding.image?.let {
                        animationView.setAnimation(boarding.image)
                        animationView.playAnimation()
                    }
                }
                btnStart.isVisible = adapterPosition == list.lastIndex
                btnStart.setOnClickListener{onClick()}
            }
        }

    }
}