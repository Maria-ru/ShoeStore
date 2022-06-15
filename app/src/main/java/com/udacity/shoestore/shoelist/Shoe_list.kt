package com.udacity.shoestore.shoelist

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding


class Shoe_list : Fragment() {

    companion object {
        fun newInstance() = Shoe_list()
    }
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val binding: ShoeListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)
        setHasOptionsMenu(true)
        binding.fab.setOnClickListener{findNavController().navigate(Shoe_listDirections.actionShoeListToShoeDetail())}
        binding.lifecycleOwner = this

        var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.setMargins(24, 24, 24, 8)
        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            if(it != null){
                for (i in it){
                    val textView = TextView(this.context)
                    textView.setTextSize(18.toFloat())
                    textView.setText("Name: ${i.name}. Size: ${i.size}.\nCompany: ${i.company}. Description: ${i.description}")
                    binding.list.addView(textView, params)
//
                }
            }
        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_items, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout -> toLogin()
        }
        return true
    }

    fun toLogin(){
        findNavController().navigate(Shoe_listDirections.actionShoeListToLoginFragment())
    }

}