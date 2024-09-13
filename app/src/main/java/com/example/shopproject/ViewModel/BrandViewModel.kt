package com.example.shopproject.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopproject.Model.BrandModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class BrandViewModel(
    private val firebaseDatabase: FirebaseDatabase
): ViewModel() {
    private val _brand = MutableLiveData<MutableList<BrandModel>>()
    val brand: LiveData<MutableList<BrandModel>> = _brand

    fun loadBrand(){
        val db = firebaseDatabase.getReference("Category")
        db.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var lists = mutableListOf<BrandModel>()
                for(children in snapshot.children){
                    var list = children.getValue(BrandModel::class.java)
                    if(list != null){
                        Log.d("ITEMS", list.title)
                        lists.add(list)
                    }
                }
                _brand.value = lists
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}