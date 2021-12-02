package com.example.paging_demo_recycler_mvvm

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paging_demo_recycler_mvvm.network.apiUserData
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    //val button: Button = findViewById(R.id.buttonCheck)
    //val textView: TextView = findViewById(R.id.textView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCheck.setOnClickListener{
            if (checkForInternet(this)){
                Toast.makeText(this, "Internet Is Coneected", Toast.LENGTH_LONG).show()
                buttonCheck.visibility = View.INVISIBLE

                initViewModel()
            } else {
                Toast.makeText(this, "Internet Is Not Connected!!, \n Please Connect to Internet",Toast.LENGTH_LONG).show()
                buttonCheck.visibility = View.VISIBLE
            }
        }

        //if (checkForInternet == true){}

        recyclerView = findViewById(R.id.recyclerView)

        //initializing recycler view
        initRecyclerView()
        initViewModel()
    }

    private fun checkForInternet(context: Context): Boolean{
        // register activity with the connectivity manager service
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

            // Returns a Network object corresponding to
            // the currently active default data network
            val network = connectivityManager.activeNetwork ?: return false

            // Representation of the capabilities of an active network
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when{
                //indicates this network uses a wifi transport
                // or wifi has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                // else return false
                else -> false
            }
        } else {

            //if the android version is below M
            @Suppress("DERPRECATION") val networkInfo = connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }

    /*private fun checkNetwork(): Boolean {
        val connManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        textView.text = "Network type is " + networkInfo!!.typeName
        return true
    }*/



    private fun initRecyclerView(){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)

            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter
        }
    }

    private fun initViewModel() {
        val viewModelProvider = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModelProvider.getRecyclerListObserver()?.observe(this, Observer<PagedList<apiUserData>> {
            if (it != null){
                recyclerViewAdapter.submitList(it)
            } else {
                Toast.makeText(this@MainActivity, "Failed to Fetch Data", Toast.LENGTH_LONG).show()
            }
        })
    }
}