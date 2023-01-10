package digital_gallary.com.example.digital_gallery

class MyPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val items = ArrayList<Fragment>()

    override fun getItem(position: Int): Fragment {
        return items[position]
    }

    override fun getCount(): Int {
        return items.size
    }

    fun updateFragments(items: List<Fragment>){
        this.items.addAll(items)
    }

}